package com.shim.celestialexploration.util.teleportation;

import com.google.common.collect.ImmutableList;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.world.portal.CelestialTeleporter;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeleportUtil {

    @Deprecated
    private static final Map<ResourceKey<Level>, List<Block>> CE_DIMENSION_STRUCTURE_BLOCKS = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put(CelestialDimensions.MERCURY, ImmutableList.<Block>builder().add(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_DEEPSLATE.get(), CelestialBlocks.MERCURY_CORE.get()).build());
        dimension.put(CelestialDimensions.VENUS, ImmutableList.<Block>builder().add(CelestialBlocks.VENUS_STONE.get(), Blocks.YELLOW_STAINED_GLASS, CelestialBlocks.VENUS_DEEPSLATE.get(), CelestialBlocks.VENUS_CORE.get()).build());
        dimension.put(Level.OVERWORLD, ImmutableList.<Block>builder().add(Blocks.STONE, Blocks.SANDSTONE, Blocks.WHITE_STAINED_GLASS, Blocks.GRASS_BLOCK, Blocks.SMOOTH_QUARTZ, Blocks.BLUE_STAINED_GLASS, Blocks.ICE, Blocks.PACKED_ICE, Blocks.DEEPSLATE, Blocks.BEDROCK).build());
        dimension.put(CelestialDimensions.MOON, ImmutableList.<Block>builder().add(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_DEEPSLATE.get(), CelestialBlocks.MOON_CORE.get()).build());
        dimension.put(CelestialDimensions.MARS, ImmutableList.<Block>builder().add(CelestialBlocks.MARS_STONE.get(), CelestialBlocks.MARS_DEEPSLATE.get(), CelestialBlocks.MARS_CORE.get(), CelestialBlocks.DRY_ICE.get()).build());
        dimension.put(CelestialDimensions.JUPITER, ImmutableList.<Block>builder().add(CelestialBlocks.JUPITER_DEEPSLATE.get(), CelestialBlocks.JUPITER_ATMOSPHERE.get(), Blocks.WHITE_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.RED_STAINED_GLASS,
                Blocks.ORANGE_STAINED_GLASS, CelestialBlocks.JUPITER_CORE.get()).build());
        dimension.put(CelestialDimensions.EUROPA, ImmutableList.<Block>builder().add(CelestialBlocks.EUROPA_CORE.get(), CelestialBlocks.EUROPA_HYDRATE.get(), CelestialBlocks.MOON_STONE.get()).build());

    });

//    public static void addDimensionStructureBlocks(ResourceKey<Level> dimension, List<Block> blocks) {
//        DIMENSION_STRUCTURE_BLOCKS.put(dimension, blocks);
//    }

    protected static final Map<ResourceKey<Level>, List<Block>> DIMENSION_STRUCTURE_BLOCKS = new HashMap<>();

    public static List<Block> getDimensionStructureBlocks(ResourceKey<Level> dimension) {
        return DIMENSION_STRUCTURE_BLOCKS.get(dimension);
    }

    public static void addDimensionStructureBlocks(ResourceKey<Level> dimension, List<Block> blocks) {
        DIMENSION_STRUCTURE_BLOCKS.put(dimension, blocks);
    }

    public static void clearDimensionStructureBlocks() {
        DIMENSION_STRUCTURE_BLOCKS.clear();

        //add hardcoded exceptions
//        addDimensionStructureBlocks(Level.OVERWORLD, ImmutableList.<Block>builder().add(Blocks.STONE, Blocks.SANDSTONE, Blocks.WHITE_STAINED_GLASS, Blocks.GRASS_BLOCK, Blocks.SMOOTH_QUARTZ, Blocks.BLUE_STAINED_GLASS, Blocks.ICE, Blocks.PACKED_ICE, Blocks.DEEPSLATE, Blocks.BEDROCK).build());
//        addDimensionStructureBlocks(DimensionRegistry.MOON, ImmutableList.<Block>builder().add(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_CORE.get()).build());
//        addDimensionStructureBlocks(DimensionRegistry.JUPITER, ImmutableList.<Block>builder().add(BlockRegistry.JUPITER_DEEPSLATE.get(), BlockRegistry.JUPITER_ATMOSPHERE.get(), Blocks.WHITE_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, BlockRegistry.JUPITER_CORE.get()).build());
    }


    private static final Map<ResourceKey<Level>, List<ResourceKey<Level>>> PLANET_MOONS_WITH_PLANET = Util.make(new Object2ObjectArrayMap<>(), (dimension) -> {
        dimension.put(CelestialDimensions.MERCURY, null);
        dimension.put(CelestialDimensions.VENUS, null);
        dimension.put(Level.OVERWORLD, ImmutableList.<ResourceKey<Level>>builder().add(CelestialDimensions.MOON).build());
        dimension.put(CelestialDimensions.MARS, null);
        dimension.put(CelestialDimensions.JUPITER, ImmutableList.<ResourceKey<Level>>builder().add(CelestialDimensions.EUROPA).add(CelestialDimensions.CALLISTO).build());
    });

    private static final List<ResourceKey<Level>> PLANET_MOONS = Util.make(new ArrayList<>(), (dimension) -> {
        dimension.add(CelestialDimensions.MOON);
        dimension.add(CelestialDimensions.EUROPA);
        dimension.add(CelestialDimensions.CALLISTO);
    });

    public static void addPlanetMoon(ResourceKey<Level> dimension, List<ResourceKey<Level>> moons) {
        PLANET_MOONS_WITH_PLANET.put(dimension, moons);
    }


    public static ResourceKey<Level> getTeleportLocation(Vec3 location, BlockState blockWeSee) {
        ResourceKey<Level> planet = null;
        List<ResourceKey<Level>> moons;
        ChunkPos planetChunkPos;

        //check if we're in the general area of a planet
        for (ResourceKey<Level> loc : CelestialUtil.getPlanetLocations().keySet()) {
            //limit to only planets and not any of the moons
            if (!PLANET_MOONS.contains(loc)) {
                planetChunkPos = new ChunkPos((int) CelestialUtil.getPlanetaryChunkCoordinates(loc).x, (int) CelestialUtil.getPlanetaryChunkCoordinates(loc).z);
                ChunkPos locationChunk = new ChunkPos(new BlockPos(location.x, location.y, location.z));

                //check if we're somewhat nearby
                if (CelestialUtil.isInRectangle(planetChunkPos.x, planetChunkPos.z, 6, locationChunk.x, locationChunk.z)) {
                    planet = loc;
                    break;
                }
            }
        }

        if (planet == null) return null;

        //check if what we're looking at matches said planet…
        List<Block> blocksToComp = getDimensionStructureBlocks(planet);
        if (blocksToComp == null) return null;

        for (Block block : blocksToComp) {
            //  return planet
            if (block.defaultBlockState().is(blockWeSee.getBlock())) return planet;
        }
        //…or one of its moons
        moons = PLANET_MOONS_WITH_PLANET.get(planet);

        if (moons != null) {
            for (ResourceKey<Level> moon : moons) {
                blocksToComp = getDimensionStructureBlocks(moon);

                for (Block block : blocksToComp) {
                    //  return moon
                    if (block.defaultBlockState().is(blockWeSee.getBlock())) return moon;
                }
            }
        }
        //otherwise, we're not near and/or looking at anything relevant
        return null;
    }

    public static void teleport(Entity spaceVehicle, @Nullable ArrayList<Entity> passengers, ResourceKey<Level> destinationDim, Vec3 locationInPlace) {
        if (spaceVehicle.canChangeDimensions()) {

            //get server and level
            Level entityWorld = spaceVehicle.level;
            MinecraftServer minecraftserver = entityWorld.getServer();
            if (minecraftserver != null) {
                ServerLevel destinationWorld = minecraftserver.getLevel(destinationDim);
                if (destinationWorld != null) {

                    //if we're teleporting FROM space, passengers' Y level should be the max build height minus 10 blocks
                    if (!(destinationDim == CelestialDimensions.SPACE)) {
                        locationInPlace = new Vec3(locationInPlace.x, destinationWorld.getMaxBuildHeight() - 10, locationInPlace.z);
                    }

                    //move players to the right coordinates BEFORE changing dimensions
                    //otherwise, there's a good chance of trying to load the admittedly massive sun structure,
                    //which caused lag if the space dimension hadn't been loaded before
                    //and sometimes the lag would cause discrepancies between client/server that the game didn't always recover from
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



                    Entity newSpaceVehicle = null;
                    if (!spaceVehicle.level.dimension().equals(destinationDim)) {
                        //check if spaceVehicle is a player or not
                        //because for all entities NOT players, changing dimensions returns a new instance of the entity with the same data
                        //but you do NOT create a new instance of a player
                        //so this is important to check
                        if (spaceVehicle instanceof Player) {
                            spaceVehicle.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                        } else {
                            newSpaceVehicle = spaceVehicle.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                        }
                    }

                    //this assumes that if the player is the spaceVehicle, that there are not additional passengers besides the player
                    if (newSpaceVehicle != null && passengers != null) {
                        //for all of our passengers…
                        for (Entity passenger : passengers) {
                            Entity newPassenger = null;
                            if (!passenger.level.dimension().equals(destinationDim)) {
                                //check if they're players or not to handle changing dimensions appropriately
                                if (passenger instanceof Player) {
                                    passenger.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                                } else {
                                    newPassenger = passenger.changeDimension(destinationWorld, new CelestialTeleporter(destinationWorld));
                                }
                            }

                            //have passengers, player or otherwise, start riding the vehicle again
                            if (!entityWorld.isClientSide) {
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
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting to " + new TranslatableComponent("dimension.celestialexploration." + destination.location().getPath()).getString() + " in… " + teleportCooldown / 20), true);
            } else if (teleportCooldown == 0) {
                ((Player) entity).displayClientMessage(Component.nullToEmpty("Teleporting!"), true);
            }
        }
    }
}

