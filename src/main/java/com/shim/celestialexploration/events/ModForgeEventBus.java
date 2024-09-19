package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.Spaceship;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.SpaceFlightPacket;
import com.shim.celestialexploration.packets.SpaceshipFuelTickPacket;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.EffectRegistry;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.DimensionUtil;
import com.shim.celestialexploration.util.TeleportUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;

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
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Entity spaceVehicle = null;

        ISpaceFlight flightCap = CelestialExploration.getCapability(player, CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
        if (flightCap != null) spaceVehicle = player;
        else {
            if (player.getVehicle() != null) {
                flightCap = CelestialExploration.getCapability(player.getVehicle(), CapabilityRegistry.SPACE_FLIGHT_CAPABILITY);
                if (flightCap != null)  spaceVehicle = player.getVehicle();
            }
        }
        if (spaceVehicle != null) {
            if (flightCap.canSpaceTravel() && flightCap.isTeleportHeight(spaceVehicle) && !spaceVehicle.level.dimension().equals(DimensionRegistry.SPACE)) {
                ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);
                TeleportUtil.displayTeleportMessage(player, flightCap.getTeleportationCooldown(), DimensionRegistry.SPACE);

                if (flightCap.getTeleportationCooldown() == 0) {
                    Vec3 teleportLocation = new Vec3(CelestialUtil.getPlanetaryChunkCoordinates(spaceVehicle.level.dimension()).x * 16, 135.0, CelestialUtil.getPlanetaryChunkCoordinates(spaceVehicle.level.dimension()).z * 16);

                    TeleportUtil.teleport(spaceVehicle, passengers, DimensionRegistry.SPACE, teleportLocation);
                    flightCap.resetTeleportationCooldown();
                } else {
                    flightCap.decrementTeleportationCooldown();
                }
            } else if (flightCap.canSpaceTravel() && spaceVehicle.level.dimension().equals(DimensionRegistry.SPACE)) {
                BlockHitResult hitResult;
                if (spaceVehicle instanceof Spaceship spaceship && spaceship.getMaxSpeed() >= Spaceship.SPACESHIP_LOW_FUEL_SPEED) {
                    //to account for the spaceship having the option for fast movement speeds
                    hitResult = (BlockHitResult) player.pick(35.0D, 0.0F, false);
                } else {
                    hitResult = (BlockHitResult) player.pick(18.0D, 0.0F, false);
                }

                BlockState blockState = spaceVehicle.level.getBlockState(hitResult.getBlockPos());
                ResourceKey<Level> destination = TeleportUtil.getTeleportLocation(spaceVehicle.position(), blockState);
                ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);
                CelestialExploration.LOGGER.debug("canSpaceTravel, and in space. destination: " + destination);

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

    @SubscribeEvent
    public static void clickEvent(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();

        if (event.getSide() == LogicalSide.SERVER && player != null) {
            if (event.getItemStack() != null && event.getItemStack().getItem() == Items.FLINT_AND_STEEL) {
                Level level = event.getWorld();

                if(player.level.dimension() == DimensionRegistry.MARS
                        || player.level.dimension() == DimensionRegistry.MOON
                        || player.level.dimension() == DimensionRegistry.VENUS
                        || player.level.dimension() == DimensionRegistry.MERCURY

                        || player.level.dimension() == Level.OVERWORLD) {

                    for(Direction direction : Direction.Plane.VERTICAL) {
                        BlockPos framePos = event.getPos().relative(direction);

                        if(BlockRegistry.MARS_PORTAL.get().trySpawnPortal(level, framePos)) {
                            level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                            event.setCanceled(true);
                            event.setCancellationResult(InteractionResult.CONSUME);
                        }
                        else if(BlockRegistry.MOON_PORTAL.get().trySpawnPortal(level, framePos)) {

                            level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                            event.setCanceled(true);
                            event.setCancellationResult(InteractionResult.CONSUME);
                        }
                        else if(BlockRegistry.VENUS_PORTAL.get().trySpawnPortal(level, framePos)) {
                            level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                            event.setCanceled(true);
                            event.setCancellationResult(InteractionResult.CONSUME);
                        }
                        else if(BlockRegistry.MERCURY_PORTAL.get().trySpawnPortal(level, framePos)) {
                            level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                            event.setCanceled(true);
                            event.setCancellationResult(InteractionResult.CONSUME);
                        }
                    }
                }
            } else if (event.getItemStack() != null && event.getItemStack().getItem() instanceof ShovelItem) {
                Level level = event.getWorld();

                BlockState block = level.getBlockState(event.getHitVec().getBlockPos());
                if (block.is(BlockRegistry.MERCURY_SAND.get())) {
                    level.setBlock(event.getHitVec().getBlockPos(), BlockRegistry.MERCURY_SAND_PATH.get().defaultBlockState(), 1);
                }

            }

            }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        ResourceKey<Level> dimension = event.getWorld().dimension();

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
            if (event.getWorld().isRaining() && dimension.equals(DimensionRegistry.MARS)) { //FIXME, update way of checking if dimension (and biome?) has sandstorms
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12000, 1, false, false, true));
                }
            } else if (!event.getWorld().isRaining() && dimension.equals(DimensionRegistry.MARS)) {
                if (entity instanceof LivingEntity livingEntity) {
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
}