package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.Spaceship;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.EffectRegistry;
import com.shim.celestialexploration.util.DimensionUtil;
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
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

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

//    @SubscribeEvent
//    public static void onEntityChangeDimension(EntityTravelToDimensionEvent event) {
//        Entity entity = event.getEntity();
//        ResourceKey<Level> dimension = event.getDimension();
//        if (entity instanceof Player player) {
//            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);
//            if (itemStack.getItem() instanceof LowAtmosSpaceSuitArmorItem && ((LowAtmosSpaceSuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
//                player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
//                return;
//            }
//
//            if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
//                player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
//            } else {
//                player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
//            }
//        }
//    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        if (!CelestialCommonConfig.USE_GRAVITY_EFFECTS.get()) return;

        Entity entity = event.getEntity();
        ResourceKey<Level> dimension = event.getWorld().dimension();
        if (entity instanceof ServerPlayer player) {

            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);

            if (itemStack.getItem() instanceof ThermalSpaceSuitArmorItem && ((ThermalSpaceSuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
                player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
            } else {
                if (DimensionUtil.isLowGravityDimension(dimension)) {
//                if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
                }
            }
        } else if (entity instanceof LivingEntity livingEntity) {
            if (DimensionUtil.isLowGravityDimension(dimension)) {
//                if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
                livingEntity.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
            } else {
                livingEntity.removeEffect(EffectRegistry.LOW_GRAVITY.get());
            }
        }

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
            } else {
                ResourceKey<Level> dimension = player.level.dimension();
                if (DimensionUtil.isLowGravityDimension(dimension)) {
//                    if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                }
            }
        }
    }
}