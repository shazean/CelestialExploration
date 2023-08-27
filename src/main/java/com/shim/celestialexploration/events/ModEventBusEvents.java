package com.shim.celestialexploration.events;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.LunarSlimeEntity;
import com.shim.celestialexploration.entity.LurkerEntity;
import com.shim.celestialexploration.entity.MarsMallowEntity;
import com.shim.celestialexploration.entity.RustSlimeEntity;
import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.RUST_SLIME.get(), RustSlimeEntity.setAttributes());
        event.put(EntityRegistry.LUNAR_SLIME.get(), LunarSlimeEntity.setAttributes());
        event.put(EntityRegistry.MARS_MALLOW.get(), MarsMallowEntity.setAttributes());
        event.put(EntityRegistry.LURKER.get(), LurkerEntity.setAttributes());


    }

}
