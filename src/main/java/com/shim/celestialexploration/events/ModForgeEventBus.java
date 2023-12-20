package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.Shuttle;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.EffectRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEventBus {

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.isDismounting() && event.getEntityBeingMounted() instanceof Shuttle shuttle) {
            if (!shuttle.isRemoved() && !event.getWorldObj().isClientSide) {
                event.setCanceled(shuttle.getTimeOnGround() < Shuttle.maxTimeOnGround);
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
                if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    player.removeEffect(EffectRegistry.LOW_GRAVITY.get());
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
            } else {
                ResourceKey<Level> dimension = player.level.dimension();
                if (dimension == DimensionRegistry.MARS || dimension == DimensionRegistry.MOON) {
                    player.addEffect(new MobEffectInstance(EffectRegistry.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                }
            }
        }
    }
}