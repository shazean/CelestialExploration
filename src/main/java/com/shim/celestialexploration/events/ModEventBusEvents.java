package com.shim.celestialexploration.events;


import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.model.MagCartModel;
import com.shim.celestialexploration.entity.model.ShuttleModel;
import com.shim.celestialexploration.entity.renderer.*;
import com.shim.celestialexploration.inventory.screens.OxygenCompressorScreen;
import com.shim.celestialexploration.inventory.screens.ShuttleScreen;
import com.shim.celestialexploration.inventory.screens.WorkbenchScreen;
import com.shim.celestialexploration.particles.CelestialSlimeParticles;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.MinecartModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.shim.celestialexploration.entity.renderer.ShuttleRenderer.createShuttleModelName;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.RUST_SLIME.get(), RustSlime.setAttributes());
        event.put(EntityRegistry.LUNAR_SLIME.get(), LunarSlime.setAttributes());
        event.put(EntityRegistry.MARS_MALLOW.get(), MarsMallow.setAttributes());
        event.put(EntityRegistry.LURKER.get(), Lurker.setAttributes());
        event.put(EntityRegistry.VOIDFELLOW.get(), VoidFellow.setAttributes());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (Shuttle.Type shuttle$type : Shuttle.Type.values())
            event.registerLayerDefinition(createShuttleModelName(shuttle$type), ShuttleModel::createBodyLayer);

        event.registerLayerDefinition(CelestialModelLayers.MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.CHEST_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.COMMAND_BLOCK_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.FURNACE_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.HOPPER_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.SPAWNER_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.TNT_MAGCART, MagCartModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(DimensionRenderers::setDimensionEffects);

//        DimensionRenderers::setDimensionEffects);

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


        MenuScreens.register(MenuRegistry.OXYGEN_COMPRESSOR_MENU.get(), OxygenCompressorScreen::new);
        MenuScreens.register(MenuRegistry.SHUTTLE_MENU.get(), ShuttleScreen::new);
        MenuScreens.register(MenuRegistry.WORKBENCH_MENU.get(), WorkbenchScreen::new);

        OverlayRegistry.registerOverlay(event);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.RUST_SLIME_PARTICLES.get(), CelestialSlimeParticles.RustProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.LUNAR_SLIME_PARTICLES.get(), CelestialSlimeParticles.LunarProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MARS_MALLOW_SLIME_PARTICLES.get(), CelestialSlimeParticles.MallowProvider::new);
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, WorkbenchSmeltingRecipe.Type.ID, WorkbenchSmeltingRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, WorkbenchCraftingRecipe.Type.ID, WorkbenchCraftingRecipe.Type.INSTANCE);

    }
}