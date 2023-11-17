package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import net.minecraftforge.event.entity.EntityMountEvent;
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
}