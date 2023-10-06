package com.shim.celestialexploration.events;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.model.ShuttleModel;
import com.shim.celestialexploration.entity.renderer.*;
import com.shim.celestialexploration.inventory.screens.OxygenCompressorScreen;
import com.shim.celestialexploration.inventory.screens.ShuttleScreen;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

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

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(DimensionRenderers::setDimensionEffects);

        event.enqueueWork(() -> {
            ItemProperties.register(ItemRegistry.LOX_TANK.get(), new ResourceLocation( "filled"), (stack, level, living, id) -> {
                LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(stack, CapabilityRegistry.LOX_TANK_CAPABILITY);
                if (loxTank != null) {
                    return (float) loxTank.getFullness() / 8.0F;
                } else {
                    return 0;
                }
            });
        });

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MARS_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MOON_PORTAL.get(), RenderType.translucent());

//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.LOX_STILL.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.LOX_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LOX_TANK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STEEL_FRAME.get(), RenderType.cutout());

        EntityRenderers.register(EntityRegistry.RUST_SLIME.get(), RustSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.LUNAR_SLIME.get(), LunarSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.MARS_MALLOW.get(), MarsMallowRenderer::new);
        EntityRenderers.register(EntityRegistry.LURKER.get(), LurkerRenderer::new);
        EntityRenderers.register(EntityRegistry.SHUTTLE.get(), ShuttleRenderer::new);

        MenuScreens.register(MenuRegistry.OXYGEN_COMPRESSOR_MENU.get(), OxygenCompressorScreen::new);
        MenuScreens.register(MenuRegistry.SHUTTLE_MENU.get(), ShuttleScreen::new);
//        MenuScreens.register(MenuRegistry.ASSEMBLY_MENU.get(), AssemblyStationScreen::new);


    }

}
