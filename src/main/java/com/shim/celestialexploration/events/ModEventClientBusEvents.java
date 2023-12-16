package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.entity.renderer.*;
import com.shim.celestialexploration.inventory.screens.OxygenCompressorScreen;
import com.shim.celestialexploration.inventory.screens.ShuttleScreen;
import com.shim.celestialexploration.inventory.screens.WorkbenchScreen;
import com.shim.celestialexploration.item.armor.*;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(SpaceSuitArmorItem.class, new SpaceSuitRenderer());
        GeoArmorRenderer.registerArmorRenderer(HeavyDutySpaceSuitArmorItem.class, new HeavyDutySpaceSuitRenderer());
        GeoArmorRenderer.registerArmorRenderer(ThermalSpaceSuitArmorItem.class, new ThermalSpaceSuitRenderer());
        GeoArmorRenderer.registerArmorRenderer(AdvancedSpaceSuitArmorItem.class, new AdvancedSpaceSuitRenderer());
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(DimensionRenderers::setDimensionEffects);

        event.enqueueWork(() -> ItemProperties.register(ItemRegistry.LOX_TANK.get(), new ResourceLocation("filled"), (stack, level, living, id) -> {
            LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(stack, CapabilityRegistry.LOX_TANK_CAPABILITY);
            if (loxTank != null) {
                return (float) loxTank.getFullness() / 8.0F;
            } else {
                return 0;
            }
        }));

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MARS_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MOON_PORTAL.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.REINFORCED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.REINFORCED_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.LOX.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.LOX_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.LOX_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_IRON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_IRON_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_IRON_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_STEEL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_STEEL_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_STEEL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_COPPER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_COPPER_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_COPPER_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_GOLD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_GOLD_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_GOLD_BLOCK.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE_FLOWING.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SOLAR_FLARE.get(), RenderType.translucent());


        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LOX_TANK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STEEL_FRAME.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MAG_RAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.POWERED_MAG_RAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.DETECTOR_MAG_RAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ACTIVATOR_MAG_RAIL.get(), RenderType.cutout());

        EntityRenderers.register(EntityRegistry.RUST_SLIME.get(), RustSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.LUNAR_SLIME.get(), LunarSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.MARS_MALLOW.get(), MarsMallowRenderer::new);
        EntityRenderers.register(EntityRegistry.LURKER.get(), LurkerRenderer::new);
        EntityRenderers.register(EntityRegistry.SHUTTLE.get(), ShuttleRenderer::new);
        EntityRenderers.register(EntityRegistry.VOIDFELLOW.get(), VoidFellowRenderer::new);
        EntityRenderers.register(EntityRegistry.MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.MAGCART));
        EntityRenderers.register(EntityRegistry.CHEST_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.CHEST_MAGCART));
        EntityRenderers.register(EntityRegistry.COMMAND_BLOCK_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.COMMAND_BLOCK_MAGCART));
        EntityRenderers.register(EntityRegistry.FURNACE_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.FURNACE_MAGCART));
        EntityRenderers.register(EntityRegistry.HOPPER_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.HOPPER_MAGCART));
        EntityRenderers.register(EntityRegistry.SPAWNER_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.SPAWNER_MAGCART));
        EntityRenderers.register(EntityRegistry.TNT_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.TNT_MAGCART));
        EntityRenderers.register(EntityRegistry.VOIDED.get(), VoidedRenderer::new);
        EntityRenderers.register(EntityRegistry.SULFUR_CUBE.get(), SulfurCubeRenderer::new);


        MenuScreens.register(MenuRegistry.OXYGEN_COMPRESSOR_MENU.get(), OxygenCompressorScreen::new);
        MenuScreens.register(MenuRegistry.SHUTTLE_MENU.get(), ShuttleScreen::new);
        MenuScreens.register(MenuRegistry.WORKBENCH_MENU.get(), WorkbenchScreen::new);

        OverlayRegistry.registerOverlay(event);
    }
}