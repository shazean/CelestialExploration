package com.shim.celestialexploration.events;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.model.ShuttleModel;
import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.shim.celestialexploration.entity.renderer.ShuttleRenderer.createShuttleModelName;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.RUST_SLIME.get(), RustSlimeEntity.setAttributes());
        event.put(EntityRegistry.LUNAR_SLIME.get(), LunarSlimeEntity.setAttributes());
        event.put(EntityRegistry.MARS_MALLOW.get(), MarsMallowEntity.setAttributes());
        event.put(EntityRegistry.LURKER.get(), LurkerEntity.setAttributes());


    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        for(Shuttle.Type shuttle$type : Shuttle.Type.values())
            event.registerLayerDefinition(createShuttleModelName(shuttle$type), ShuttleModel::createBodyLayer);

    }

}
