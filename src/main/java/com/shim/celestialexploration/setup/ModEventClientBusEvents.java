package com.shim.celestialexploration.setup;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.item.SpaceSuitArmorItem;
import com.shim.celestialexploration.item.armor.SpaceSuitRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(SpaceSuitArmorItem.class, new SpaceSuitRenderer());
    }
}