package com.shim.celestialexploration.events;

import com.mojang.datafixers.util.Either;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.CelestialCatSpawner;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.SpaceFlightPacket;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.DimensionUtil;
import com.shim.celestialexploration.util.teleportation.TeleportUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkDirection;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEventBus {

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.isDismounting() && event.getEntityBeingMounted() instanceof Spaceship spaceship) {
            if (!spaceship.isRemoved() && !event.getWorldObj().isClientSide) {
                event.setCanceled(spaceship.getTimeOnGround() < Spaceship.maxTimeOnGround);
            }
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent.WorldTickEvent event) {
        if (event.world instanceof ServerLevel serverLevel && event.haveTime())
            new CelestialCatSpawner().tick(serverLevel, true, true);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Entity spaceVehicle = null;

        if (player.level.dimension().equals(DimensionRegistry.SPACE)) {
            if (player.position().y <= player.level.getMinBuildHeight()) {
                player.displayClientMessage(new TranslatableComponent("celestialexploration.spaceship.space_min_height"), true);

            }
        }

        ISpaceFlight flightCap = CelestialExploration.getCapability(player, CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
        if (flightCap != null) spaceVehicle = player;
        else {
            if (player.getVehicle() != null) {
                flightCap = CelestialExploration.getCapability(player.getVehicle(), CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
                if (flightCap != null)  spaceVehicle = player.getVehicle();
            }
        }
        if (spaceVehicle != null) {
            if (flightCap.canSpaceTravel(spaceVehicle) && flightCap.isTeleportHeight(spaceVehicle) && !spaceVehicle.level.dimension().equals(DimensionRegistry.SPACE)) {
                ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);
                TeleportUtil.displayTeleportMessage(player, flightCap.getTeleportationCooldown(), DimensionRegistry.SPACE);

                if (flightCap.getTeleportationCooldown() == 0) {
                    BlockPos pos = new BlockPos(spaceVehicle.position().x, spaceVehicle.position().y, spaceVehicle.position().z);Vec3 teleportLocation = CelestialUtil.getDimensionToSpaceCoordinates(spaceVehicle.level.dimension(), new ChunkPos(pos));
//                    Vec3 teleportLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(spaceVehicle.level.dimension()).x * 16, 135.0, CelestialUtil.getPlanetaryChunkCoordinates(spaceVehicle.level.dimension()).z * 16);

                        TeleportUtil.teleport(spaceVehicle, passengers, DimensionRegistry.SPACE, teleportLocation);
                    flightCap.resetTeleportationCooldown();
                } else {
                    if (event.phase.equals(TickEvent.Phase.END)) {
                        flightCap.decrementTeleportationCooldown();
                    }
                }
            } else if (flightCap.canSpaceTravel(spaceVehicle) && spaceVehicle.level.dimension().equals(DimensionRegistry.SPACE)) {
                BlockHitResult hitResult;
                if (spaceVehicle instanceof Spaceship spaceship && spaceship.getMaxSpeed() >= Spaceship.SPACESHIP_LOW_FUEL_SPEED) {
                    //to account for the spaceship having the option for fast movement speeds in space
                    hitResult = (BlockHitResult) player.pick(35.0D, 0.0F, false);
                } else {
                    hitResult = (BlockHitResult) player.pick(18.0D, 0.0F, false);
                }

                BlockState blockState = spaceVehicle.level.getBlockState(hitResult.getBlockPos());

                if (!spaceVehicle.level.isClientSide()) {

                    ResourceKey<Level> destination = TeleportUtil.getTeleportLocation(spaceVehicle.position(), blockState);
//                CelestialExploration.LOGGER.debug("seenBlock: " + blockState + "destination: " + destination);
                    ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);
                    if (destination != null) {
                        TeleportUtil.displayTeleportMessage(player, flightCap.getTeleportationCooldown(), destination);

                        if (flightCap.getTeleportationCooldown() == 0) {
                            if (player instanceof ServerPlayer serverPlayer) {
                                CelestialPacketHandler.INSTANCE.sendTo(new SpaceFlightPacket(flightCap.getTeleportationCooldown()), serverPlayer.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
                            }

                            TeleportUtil.teleport(spaceVehicle, passengers, destination, spaceVehicle.position());
                            flightCap.resetTeleportationCooldown();

                        } else {
                            if (player instanceof ServerPlayer serverPlayer) {
                                CelestialPacketHandler.INSTANCE.sendTo(new SpaceFlightPacket(flightCap.getTeleportationCooldown()), serverPlayer.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
                            }
                            flightCap.decrementTeleportationCooldown();
                        }
                    } else {
                        flightCap.resetTeleportationCooldown();
                    }
                }
            }
        }

        LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);

//        if (!player.level.isClientSide()) {

            if (travelCap != null) {
                if (event.phase.equals(TickEvent.Phase.END)) {
                    travelCap.getMercuryCooldown().decrementCooldown();
                    travelCap.getVenusCooldown().decrementCooldown();
                    travelCap.getOverworldCooldown().decrementCooldown();
                    travelCap.getMarsCooldown().decrementCooldown();
                    travelCap.getJupiterCooldown().decrementCooldown();
                }
            }
//        }


        if (CelestialCommonConfig.STORMS.get()) {
            if (player.level.isRaining() && player.level.getBiome(player.blockPosition()).is(TagRegistry.Biomes.DUST_STORM_BIOMES)) {
                ItemStack boots = player.getInventory().getArmor(0);
                ItemStack leggings = player.getInventory().getArmor(1);
                ItemStack breastplate = player.getInventory().getArmor(2);
                ItemStack helmet = player.getInventory().getArmor(3);

                if (helmet.isEmpty() && breastplate.isEmpty() && leggings.isEmpty() && boots.isEmpty()) {
                    player.hurt(CelestialDamageSource.DUST_STORM, 0.5F);
                }

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0, false, false, true));
            }
            if (!player.level.isRaining() && player.level.getBiome(player.blockPosition()).is(TagRegistry.Biomes.DUST_STORM_BIOMES)) {
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
        }

    }

    @SubscribeEvent
    public static void clickEvent(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();

        if (event.getSide() == LogicalSide.SERVER && player != null) {
            if (event.getItemStack() != null && event.getItemStack().getItem() == Items.FLINT_AND_STEEL) {
                if (CelestialCommonConfig.PORTALS.get()) {
                    Level level = event.getWorld();

                    if (player.level.getBiome(player.getOnPos()).is(TagRegistry.Biomes.CELESTIAL_BODIES) || player.level.dimension() == Level.OVERWORLD) {
                        for (Direction direction : Direction.Plane.VERTICAL) {
                            BlockPos framePos = event.getPos().relative(direction);

                            if (BlockRegistry.MARS_PORTAL.get().trySpawnPortal(level, framePos) || BlockRegistry.MOON_PORTAL.get().trySpawnPortal(level, framePos) ||
                                    BlockRegistry.VENUS_PORTAL.get().trySpawnPortal(level, framePos) || BlockRegistry.MERCURY_PORTAL.get().trySpawnPortal(level, framePos) ||
                                    BlockRegistry.JUPITER_PORTAL.get().trySpawnPortal(level, framePos) || BlockRegistry.EUROPA_PORTAL.get().trySpawnPortal(level, framePos)) {
                                level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                                event.setCanceled(true);
                                event.setCancellationResult(InteractionResult.CONSUME);
                            }
                        }
                    }
                }
            } else if (event.getItemStack() != null && event.getItemStack().getItem() instanceof ShovelItem) {
                Level level = event.getWorld();
                BlockPos pos = event.getHitVec().getBlockPos();

                BlockState block = level.getBlockState(pos);
                if (block.is(BlockRegistry.MOON_SAND.get())) {
                    level.setBlock(pos, BlockRegistry.MOON_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(BlockRegistry.MARS_SAND.get())) {
                    level.setBlock(pos, BlockRegistry.MARS_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(BlockRegistry.VENUS_SAND.get())) {
                    level.setBlock(pos, BlockRegistry.VENUS_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(BlockRegistry.MERCURY_SAND.get())) {
                    level.setBlock(pos, BlockRegistry.MERCURY_SAND_PATH.get().defaultBlockState(), 1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        ResourceKey<Level> dimension = event.getWorld().dimension();

        if (event.getEntity() instanceof Player player) {
            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);

            if (travelCap != null) {
                travelCap.sync(player);
            }
        }

        if (CelestialCommonConfig.USE_GRAVITY_EFFECTS.get()) {

            if (entity instanceof ServerPlayer player) {
                ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);

                if (itemStack.getItem() instanceof ThermalSpaceSuitArmorItem && ((ThermalSpaceSuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
                    player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
                } else {
                    if (DimensionUtil.isLowGravityDimension(dimension)) {
                        player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                    } else {
                        player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
                    }
                }

                if (DimensionUtil.isHighGravityDimension(dimension)) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.HIGH_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    player.removeEffect(EffectRegistry.HIGH_GRAVITY.get());
                }
            } else if (entity instanceof LivingEntity livingEntity) {
                if (DimensionUtil.isLowGravityDimension(dimension)) {
                    livingEntity.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                } else  {
                    livingEntity.removeEffect(EffectRegistry.LOW_GRAVITY.get());
                }

                if (DimensionUtil.isHighGravityDimension(dimension)) {
                    livingEntity.addEffect(new MobEffectInstance(EffectRegistry.HIGH_GRAVITY.get(), 120000, 0, false, false, true));
                } else  {
                    livingEntity.removeEffect(EffectRegistry.HIGH_GRAVITY.get());
                }
            }
        }

        if (CelestialCommonConfig.STORMS.get()) {
            if (event.getWorld().isRaining() && event.getWorld().getBiome(entity.blockPosition()).is(TagRegistry.Biomes.DUST_STORM_BIOMES)) {
                if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 7000, 0, false, false, true));
                }
            }
            if (!event.getWorld().isRaining() && event.getWorld().getBiome(entity.blockPosition()).is(TagRegistry.Biomes.DUST_STORM_BIOMES)) {
                if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                    livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!CelestialCommonConfig.USE_GRAVITY_EFFECTS.get()) return;

        Entity entity = event.getEntity();
        EquipmentSlot slot = event.getSlot();

        if (entity instanceof ServerPlayer player) {
            ItemStack itemStack = event.getTo();

            if (!(slot == EquipmentSlot.FEET)) return;

            if (itemStack.getItem() instanceof ThermalSpaceSuitArmorItem && ((ThermalSpaceSuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
                player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
                player.removeEffect(EffectRegistry.EXTRA_LOW_GRAVITY.get());

            } else {
                ResourceKey<Level> dimension = player.level.dimension();
                if (DimensionUtil.isLowGravityDimension(dimension)) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerChangeDimensions(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getPlayer();
        LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);

        if (travelCap != null) {

            if (event.getTo().equals(DimensionRegistry.SPACE)) {
                travelCap.setBeenToSpace();
            } else if (event.getTo().equals(DimensionRegistry.MARS)) {
                travelCap.setBeenToMars();
            } else if (event.getTo().equals(DimensionRegistry.VENUS)) {
                travelCap.setBeenToVenus();
            } else if (event.getTo().equals(DimensionRegistry.MERCURY)) {
                travelCap.setBeenToMercury();
            } else if (event.getTo().equals(DimensionRegistry.JUPITER)) {
                travelCap.setBeenToJupiter();
            }

            travelCap.sync(player);
        }
    }

//    @SubscribeEvent
//    public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
//        if (event.getEntity() instanceof Player player) {
//            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);
//
//            if (travelCap != null) {
//                if (event.getDimension().equals(DimensionRegistry.SPACE)) {
//                    CelestialExploration.LOGGER.debug("beenToSpace");
//                    travelCap.setBeenToSpace();
//                } else if (event.getDimension().equals(DimensionRegistry.MARS)) {
//                    travelCap.setBeenToMars();
//                } else if (event.getDimension().equals(DimensionRegistry.VENUS)) {
//                    travelCap.setBeenToVenus();
//                } else if (event.getDimension().equals(DimensionRegistry.MERCURY)) {
//                    travelCap.setBeenToMercury();
//                } else if (event.getDimension().equals(DimensionRegistry.JUPITER)) {
//                    travelCap.setBeenToJupiter();
//                }
//            }
//        }
//    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal() != null && event.getPlayer() != null) {
                event.getOriginal().reviveCaps();

                LightTravelCapability.ILightTravel oldTravelData = event.getOriginal().getCapability(CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY).orElse(null);
                LightTravelCapability.ILightTravel newTravelData = event.getPlayer().getCapability(CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY).orElse(null);
                if (oldTravelData != null && newTravelData != null) newTravelData.setData(oldTravelData.getData());

                TaxiCapability.ITaxi oldTaxiData = event.getOriginal().getCapability(CapabilityRegistry.TAXI_CAPABILITY).orElse(null);
                TaxiCapability.ITaxi newTaxiData = event.getPlayer().getCapability(CapabilityRegistry.TAXI_CAPABILITY).orElse(null);
                if (oldTaxiData != null && newTaxiData != null) newTaxiData.setData(oldTaxiData.getData());

                event.getOriginal().invalidateCaps();
            }
        }
    }

    @SubscribeEvent
    public static void onToolTipRender(RenderTooltipEvent.GatherComponents event) {
        if (event.getItemStack().is(BlockRegistry.AIRLOCK_PANEL_DOOR.get().asItem())) {
            event.getTooltipElements().add(Either.left(new TranslatableComponent("item.celestialexploration.door.airlock_panel_door")));
        }
        if (event.getItemStack().is(BlockRegistry.HANGAR_DOOR.get().asItem())) {
            event.getTooltipElements().add(Either.left(new TranslatableComponent("item.celestialexploration.door.hangar_door")));
        }

    }
}