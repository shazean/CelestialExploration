package com.shim.celestialexploration.util;

import com.google.common.collect.ImmutableList;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.world.portal.CelestialTeleporter;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeleportUtil {
    private static final Map<ResourceKey<Level>, List<Block>> DIMENSION_STRUCTURE_BLOCKS = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put(DimensionRegistry.MERCURY, ImmutableList.<Block>builder().add(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_DEEPSLATE.get(), BlockRegistry.MERCURY_CORE.get()).build());
        dimension.put(DimensionRegistry.VENUS, ImmutableList.<Block>builder().add(BlockRegistry.VENUS_STONE.get(), Blocks.YELLOW_STAINED_GLASS, BlockRegistry.VENUS_DEEPSLATE.get(), BlockRegistry.VENUS_CORE.get()).build());
        dimension.put(Level.OVERWORLD, ImmutableList.<Block>builder().add(Blocks.STONE, Blocks.SANDSTONE, Blocks.WHITE_STAINED_GLASS, Blocks.GRASS_BLOCK, Blocks.SMOOTH_QUARTZ, Blocks.BLUE_STAINED_GLASS, Blocks.ICE, Blocks.PACKED_ICE, Blocks.DEEPSLATE, Blocks.BEDROCK).build());
        dimension.put(DimensionRegistry.MOON, ImmutableList.<Block>builder().add(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_CORE.get()).build());
        dimension.put(DimensionRegistry.MARS, ImmutableList.<Block>builder().add(BlockRegistry.MARS_STONE.get(), BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_CORE.get(), BlockRegistry.DRY_ICE.get()).build());
    });

    public static void addDimensionStructureBlocks(ResourceKey<Level> dimension, List<Block> blocks) {
        DIMENSION_STRUCTURE_BLOCKS.put(dimension, blocks);
    }

    private static final Map<ResourceKey<Level>, List<ResourceKey<Level>>> PLANET_MOONS = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put(DimensionRegistry.MERCURY, null);
        dimension.put(DimensionRegistry.VENUS, null);
        dimension.put(Level.OVERWORLD, ImmutableList.<ResourceKey<Level>>builder().add(DimensionRegistry.MOON).build());
        dimension.put(DimensionRegistry.MARS, null);

    });

    public static void addPlanetMoon(ResourceKey<Level> dimension, List<ResourceKey<Level>> moons) {
        PLANET_MOONS.put(dimension, moons);
    }

    public static ResourceKey<Level> getTeleportLocation(Vec3 location, BlockState blockWeSee) {
        ResourceKey<Level> planet = null;
        List<ResourceKey<Level>> moons;
        ChunkPos planetChunkPos;

        //check if we're in the general area of a planet
        for (ResourceKey<Level> loc : CelestialUtil.DIMENSION_LOCATION.keySet()) {
            planetChunkPos = new ChunkPos((int) CelestialUtil.getPlanetaryChunkCoordinates(loc).x, (int) CelestialUtil.getPlanetaryChunkCoordinates(loc).z);
            ChunkPos locationChunk = new ChunkPos(new BlockPos(location.x, location.y, location.z));
            if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 4, locationChunk.x, locationChunk.z)) {
                planet = loc;
                break;
            }
        }
        CelestialExploration.LOGGER.debug("");

        if (planet == null) return null;
        //check if what we're looking at matches said planet…
        List<Block> blocksToComp = DIMENSION_STRUCTURE_BLOCKS.get(planet);
        if (blocksToComp == null) return null;

        for (Block block : blocksToComp) {
            //  return planet
            if (block.defaultBlockState().is(blockWeSee.getBlock())) return planet;
        }
        //…or one of its moons
        moons = PLANET_MOONS.get(planet);
        if (moons != null) {
            for (ResourceKey<Level> moon : moons) {
                blocksToComp = DIMENSION_STRUCTURE_BLOCKS.get(moon);
                for (Block block : blocksToComp) {
                    //  return moon
                    if (block.defaultBlockState().is(blockWeSee.getBlock())) return moon;
                }
            }
        }
        return null;
    }

    public static void teleport(Entity spaceVehicle, @Nullable ArrayList<Entity> passengers, ResourceKey<Level> destinationDim, Vec3 locationInPlace) {
        if (spaceVehicle.canChangeDimensions()) {

            Level entityWorld = spaceVehicle.level;
            MinecraftServer minecraftserver = entityWorld.getServer();
            if (minecraftserver != null) {
                ServerLevel destinationWorld = minecraftserver.getLevel(destinationDim);
                if (destinationWorld != null) {

                    if (!(destinationDim == DimensionRegistry.SPACE)) {
                        locationInPlace = new Vec3(locationInPlace.x, destinationWorld.getMaxBuildHeight() - 10, locationInPlace.z);
                    }

                    if (!entityWorld.isClientSide) {
                        ServerLevel level = (ServerLevel) spaceVehicle.getLevel();
                        level.getProfiler().push("placing");
                        spaceVehicle.moveTo(locationInPlace);
                        if (passengers != null) {
                            for (Entity passenger : passengers) {
                                passenger.moveTo(locationInPlace);
                            }
                        }
                        level.getProfiler().pop();
                    }

                    Entity newSpaceVehicle = spaceVehicle.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));

                    if (passengers != null) {
                        for (Entity passenger : passengers) {
                            Entity newPassenger = null;
                            if (passenger instanceof Player) {
                                passenger.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                            } else {
                                newPassenger = passenger.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                            }

                            if (!entityWorld.isClientSide) {
                                assert newSpaceVehicle != null;

                                if (passenger instanceof ServerPlayer) {
                                    passenger.startRiding(newSpaceVehicle);
                                } else if (newPassenger != null) {
                                    newPassenger.startRiding(newSpaceVehicle);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void displayTeleportMessage(Entity entity, int teleportCooldown, ResourceKey<Level> destination) {
        if (entity instanceof Player) {
            if (teleportCooldown % 20 == 0 && teleportCooldown != 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting to " + destination.location().getPath().toUpperCase() + " in… " + teleportCooldown / 20), true);
            } else if (teleportCooldown == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting!"), true);
            }
        }
    }
}

