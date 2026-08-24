package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.CelestialSkullRenderer;
import com.shim.celestialexploration.blocks.blockentities.DisplayBoardRenderer;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.entity.client.layers.VillagerSpaceSuitLayer;
import com.shim.celestialexploration.entity.client.renderer.*;
import com.shim.celestialexploration.entity.client.renderer.creature.*;
import com.shim.celestialexploration.entity.client.renderer.monster.*;
import com.shim.celestialexploration.entity.client.renderer.projectile.MeteorRenderer;
import com.shim.celestialexploration.entity.client.renderer.robot.*;
import com.shim.celestialexploration.inventory.StoneChestRenderer;
import com.shim.celestialexploration.inventory.screens.*;
import com.shim.celestialexploration.item.armor.*;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.Keybinds;
import com.shim.celestialexploration.world.renderer.CelestialDimensionRenderers;
import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CelestialClientEventBus {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.AddLayers event) {
//        LivingEntityRenderer<Villager, ? extends EntityModel<Villager>> renderer = event.getRenderer(EntityType.VILLAGER);
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        VillagerRenderer renderer = event.getRenderer(EntityType.VILLAGER);
        if (renderer != null)
            renderer.addLayer(new VillagerSpaceSuitLayer<>(renderer));

    }

    @SubscribeEvent
    public static void registerSkulls(EntityRenderersEvent.CreateSkullModels event) {
        event.registerSkullModel(CelestialSkullRenderer.Types.LURKER, new SkullModel(event.getEntityModelSet().bakeLayer(CelestialModelLayers.LURKER_HEAD)));
        event.registerSkullModel(CelestialSkullRenderer.Types.VOIDED, new SkullModel(event.getEntityModelSet().bakeLayer(CelestialModelLayers.VOIDED_HEAD)));
        event.registerSkullModel(CelestialSkullRenderer.Types.MECHADOG, new SkullModel(event.getEntityModelSet().bakeLayer(CelestialModelLayers.MECHADOG_HEAD)));
    }

    private static ResourceLocation color() {
        return new ResourceLocation("color");
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

        Keybinds.register(event);

        event.enqueueWork(CelestialDimensionRenderers::setDimensionEffects);

        event.enqueueWork(CelestialSkullRenderer::setSkullRenderers);

        event.enqueueWork(() -> ItemProperties.register(CelestialItems.LOX_TANK.get(), new ResourceLocation("filled"), (stack, level, living, id) -> {
            IFuelTank fuelTank = CelestialExploration.getCapability(stack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
            if (fuelTank != null) {
                return (float) fuelTank.getFullness() / 8.0F;
            } else {
                return 0;
            }
        }));

        event.enqueueWork(() -> ItemProperties.register(CelestialItems.METALLIC_HYDROGEN_TANK.get(), new ResourceLocation("filled"), (stack, level, living, id) -> {
            IFuelTank fuelTank = CelestialExploration.getCapability(stack, CelestialCapabilities.FUEL_TANK_CAPABILITY);
            if (fuelTank != null) {
                return (float) fuelTank.getFullness() / 16.0F;
            } else {
                return 0;
            }
        }));

        event.enqueueWork(() -> ItemProperties.register(CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.GRAVITY_SPACESUIT_BOOTS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.LIGHTWEIGHT_SPACESUIT_HELMET.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.LIGHTWEIGHT_SPACESUIT_CHESTPLATE.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.LIGHTWEIGHT_SPACESUIT_LEGGINGS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.BUOYANT_SPACESUIT_BOOTS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.INSULATED_SPACESUIT_HELMET.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.INSULATED_SPACESUIT_CHESTPLATE.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.INSULATED_SPACESUIT_LEGGINGS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.INSULATED_SPACESUIT_BOOTS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));
        event.enqueueWork(() -> ItemProperties.register(CelestialItems.LONG_FALL_SPACESUIT_BOOTS.get(), color(), (stack, level, living, id) -> SpacesuitArmorItem.getColorPredicate(stack)));


        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MARS_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MOON_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.VENUS_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MERCURY_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.JUPITER_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.EUROPA_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.CALLISTO_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.IO_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.GANYMEDE_PORTAL.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_BLUE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_WHITE_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_CYAN_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_RED_GLASS.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.REINFORCED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.REINFORCED_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.AIRLOCK_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.STEEL_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.STEEL_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.AIRLOCK_PANEL_DOOR_WINDOW.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.HANGAR_DOOR_WINDOW.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.JUPITER_ATMOSPHERE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.SATURN_ATMOSPHERE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.URANUS_ATMOSPHERE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.NEPTUNE_ATMOSPHERE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.LOX.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.LOX_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.LOX_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_IRON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_IRON_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_IRON_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_STEEL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_STEEL_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_STEEL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_COPPER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_COPPER_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_COPPER_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_GOLD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_GOLD_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialFluids.MOLTEN_GOLD_BLOCK.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE_FLOWING.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(FluidRegistry.MOLTEN_NETHERITE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.SOLAR_FLARE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.RED_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.YELLOW_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.BLUE_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.GREEN_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.WHITE_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.BLACK_BUTTON.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LOX_TANK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.METALLIC_HYDROGEN_TANK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.STEEL_FRAME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.STEEL_LADDER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MAGRAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.POWERED_MAGRAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.DETECTOR_MAGRAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.ACTIVATOR_MAGRAIL.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.PENITENTE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MERCURY_SLIME_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.INFUSED_VISCOUS_SLIME_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.DIAMOND_CLUSTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.SMALL_DIAMOND_CRYSTAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.MEDIUM_DIAMOND_CRYSTAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CelestialBlocks.LARGE_DIAMOND_CRYSTAL.get(), RenderType.cutout());


        //MOBS
        EntityRenderers.register(CelestialEntities.LURKER.get(), LurkerRenderer::new);
        EntityRenderers.register(CelestialEntities.VOIDFELLOW.get(), VoidFellowRenderer::new);
        EntityRenderers.register(CelestialEntities.VOIDED.get(), VoidedRenderer::new);
        EntityRenderers.register(CelestialEntities.VOIDED_PIGLIN.get(), VoidedPiglinRenderer::new);
        EntityRenderers.register(CelestialEntities.FLARE.get(), FlareRenderer::new);
        EntityRenderers.register(CelestialEntities.GYST.get(), GystRenderer::new);
        EntityRenderers.register(CelestialEntities.ASTRAL_PIGLIN.get(), AstralPiglinRenderer::new);
        EntityRenderers.register(CelestialEntities.CYBORG_PIGLIN.get(), CyborgPiglinRenderer::new);
        EntityRenderers.register(CelestialEntities.ASTRAL_HOGLIN.get(), AstralHoglinRenderer::new);
        EntityRenderers.register(CelestialEntities.VOIDED_ZOGLIN.get(), VoidedZoglinRenderer::new);
        EntityRenderers.register(CelestialEntities.METEOR_CRAWLER.get(), MeteorCrawlerRenderer::new);
        EntityRenderers.register(CelestialEntities.VOID_CRAWLER.get(), VoidCrawlerRenderer::new);
        EntityRenderers.register(CelestialEntities.GUST.get(), GustRenderer::new);
        EntityRenderers.register(CelestialEntities.ORBITER.get(), OrbiterRenderer::new);
        EntityRenderers.register(CelestialEntities.MECHACERBERUS_BOSS.get(), (context) -> new MechaCerberusRenderer(context, 2.5F));
        EntityRenderers.register(CelestialEntities.VULKAN.get(), VulkanRenderer::new);

        //SLIMES
        EntityRenderers.register(CelestialEntities.RUST_SLIME.get(), RustSlimeRenderer::new);
        EntityRenderers.register(CelestialEntities.LUNAR_SLIME.get(), LunarSlimeRenderer::new);
        EntityRenderers.register(CelestialEntities.QUICKSILVER_SLIME.get(), QuicksilverSlimeRenderer::new);
        EntityRenderers.register(CelestialEntities.VISCOUS_SLIME.get(), ViscousSlimeRenderer::new);
        EntityRenderers.register(CelestialEntities.MARS_MALLOW.get(), MarsMallowRenderer::new);
        EntityRenderers.register(CelestialEntities.SULFUR_CUBE.get(), SulfurCubeRenderer::new);

        //CREATURES
        EntityRenderers.register(CelestialEntities.CELESTIAL_CAT.get(), CelestialCatRenderer::new);
        EntityRenderers.register(CelestialEntities.EUREKA.get(), EurekaRenderer::new);
        EntityRenderers.register(CelestialEntities.MOON_COW.get(), MoonCowRenderer::new);
//        EntityRenderers.register(CelestialEntities.ASTEROID_SQUID.get(), AsteroidSquidRenderer::new);
//        EntityRenderers.register(CelestialEntities.STARDUST_SQUID.get(), StardustSquidRenderer::new);
//        EntityRenderers.register(CelestialEntities.CELESTIAL_AXOLOTL.get(), CelestialAxolotlRenderer::new);
        EntityRenderers.register(CelestialEntities.DRONE.get(), DroneRenderer::new);
        EntityRenderers.register(CelestialEntities.ROVER.get(), RoverRenderer::new);
        EntityRenderers.register(CelestialEntities.MECHADOG.get(), MechaDogRenderer::new);
        EntityRenderers.register(CelestialEntities.COBBLESAURUS.get(), CobblesaurusRenderer::new);
        EntityRenderers.register(CelestialEntities.MECHACROW.get(), MechaCrowRenderer::new);
        EntityRenderers.register(CelestialEntities.SPACE_LLAMA.get(), SpaceLlamaRenderer::new);
        EntityRenderers.register(CelestialEntities.ALIEN_LLAMA.get(), AlienLlamaRenderer::new);
        EntityRenderers.register(CelestialEntities.MECHACERBERUS.get(), (context) -> new MechaCerberusRenderer(context, 1.5F));

        //VEHICLES
        EntityRenderers.register(CelestialEntities.SPACESHIP.get(), SpaceshipRenderer::new);
//        EntityRenderers.register(CelestialEntities.SPACE_TAXI.get(), SpaceTaxiRenderer::new);
        EntityRenderers.register(CelestialEntities.MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.MAGCART));
        EntityRenderers.register(CelestialEntities.CHEST_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.CHEST_MAGCART));
        EntityRenderers.register(CelestialEntities.COMMAND_BLOCK_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.COMMAND_BLOCK_MAGCART));
        EntityRenderers.register(CelestialEntities.FURNACE_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.FURNACE_MAGCART));
        EntityRenderers.register(CelestialEntities.HOPPER_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.HOPPER_MAGCART));
        EntityRenderers.register(CelestialEntities.SPAWNER_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.SPAWNER_MAGCART));
        EntityRenderers.register(CelestialEntities.TNT_MAGCART.get(), (context) -> new MagCartRenderer<>(context, CelestialModelLayers.TNT_MAGCART));
        EntityRenderers.register(CelestialEntities.BUGGY.get(), BuggyRenderer::new);

        //OTHER
        EntityRenderers.register(CelestialEntities.CELESTIAL_TRADER.get(), CelestialTraderRenderer::new);
        EntityRenderers.register(CelestialEntities.METEOR.get(), MeteorRenderer::new);

        MenuScreens.register(CelestialMenus.OXYGEN_COMPRESSOR_MENU.get(), OxygenCompressorScreen::new);
        MenuScreens.register(CelestialMenus.PLANET_CHART_MENU.get(), PlanetChartScreen::new);
        MenuScreens.register(CelestialMenus.SPACESHIP_MENU.get(), SpaceshipScreen::new);
        MenuScreens.register(CelestialMenus.WORKBENCH_MENU.get(), WorkbenchScreen::new);
        MenuScreens.register(CelestialMenus.BUGGY_MENU.get(), BuggyScreen::new);
//        MenuScreens.register(CelestialMenus.SPACE_TAXI_MENU.get(), SpaceTaxiScreen::new);
//        MenuScreens.register(CelestialMenus.TAXI_STATION_MENU.get(), TaxiStationScreen::new);

//        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MECHADOG_HEAD.get(), RenderType.cutout());


//        AzArmorRendererRegistry.register(() -> new SpacesuitRenderer("advanced_spacesuit"), CelestialItems.ADVANCED_SPACESUIT_HELMET.get(), CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get(), CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get(), CelestialItems.ADVANCED_SPACESUIT_BOOTS.get());
//        AzArmorRendererRegistry.register(() -> new SpacesuitRenderer("og_heavy_duty_spacesuit"), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_HELMET.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), CelestialItems.OG_HEAVY_DUTY_SPACESUIT_BOOTS.get());
//        AzArmorRendererRegistry.register(() -> new SpacesuitRenderer("thermal_spacesuit"), CelestialItems.THERMAL_SPACESUIT_HELMET.get(), CelestialItems.THERMAL_SPACESUIT_CHESTPLATE.get(), CelestialItems.THERMAL_SPACESUIT_LEGGINGS.get(), CelestialItems.THERMAL_SPACESUIT_BOOTS.get());
//        AzArmorRendererRegistry.register(() -> new SpacesuitRenderer("basic_spacesuit"), CelestialItems.BASIC_SPACESUIT_HELMET.get(), CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get(), CelestialItems.BASIC_SPACESUIT_LEGGINGS.get(), CelestialItems.BASIC_SPACESUIT_BOOTS.get());

        AzArmorRendererRegistry.register(SpacesuitRenderer.Simple::new, CelestialItems.SIMPLE_SPACESUIT_HELMET.get(), CelestialItems.SIMPLE_SPACESUIT_CHESTPLATE.get(), CelestialItems.SIMPLE_SPACESUIT_LEGGINGS.get(), CelestialItems.SIMPLE_SPACESUIT_BOOTS.get());
        AzArmorRendererRegistry.register(SpacesuitRenderer.HeavyDuty::new, CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get(), CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get(), CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get(), CelestialItems.GRAVITY_SPACESUIT_BOOTS.get());
        AzArmorRendererRegistry.register(SpacesuitRenderer.Lightweight::new, CelestialItems.LIGHTWEIGHT_SPACESUIT_HELMET.get(), CelestialItems.LIGHTWEIGHT_SPACESUIT_CHESTPLATE.get(), CelestialItems.LIGHTWEIGHT_SPACESUIT_LEGGINGS.get(), CelestialItems.BUOYANT_SPACESUIT_BOOTS.get());
        AzArmorRendererRegistry.register(SpacesuitRenderer.Insulated::new, CelestialItems.INSULATED_SPACESUIT_HELMET.get(), CelestialItems.INSULATED_SPACESUIT_CHESTPLATE.get(), CelestialItems.INSULATED_SPACESUIT_LEGGINGS.get(), CelestialItems.INSULATED_SPACESUIT_BOOTS.get());
        AzArmorRendererRegistry.register(SpacesuitRenderer.LongFall::new, CelestialItems.LONG_FALL_SPACESUIT_BOOTS.get());


        CelestialOverlays.registerOverlay(event);

        RecipeBookCategories.create("celestialexploration:workbench_crafting",  new ItemStack[] { new ItemStack((ItemLike) CelestialBlocks.WORKBENCH.get()) });
        RecipeBookCategories.create("celestialexploration:workbench_smelting", new ItemStack(CelestialBlocks.WORKBENCH.get()));

        BlockEntityRenderers.register(CelestialBlockEntities.STONE_CHEST_BLOCK_ENTITY.get(), StoneChestRenderer::new);
        BlockEntityRenderers.register(CelestialBlockEntities.DISPLAY_BOARD_BLOCK_ENTITY.get(), DisplayBoardRenderer::new);

    }


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (event.getAtlas().location().equals(Sheets.CHEST_SHEET)) {
            for (Material material : StoneChestRenderer.single) {
                event.addSprite(material.texture());
            }
            for (Material material : StoneChestRenderer.left) {
                event.addSprite(material.texture());
            }
            for (Material material : StoneChestRenderer.right) {
                event.addSprite(material.texture());
            }
        }
        if (event.getAtlas().location().equals(Sheets.SIGN_SHEET)) {
            event.addSprite(CelestialMaterials.BLACK.texture());
            event.addSprite(CelestialMaterials.WHITE.texture());
            event.addSprite(CelestialMaterials.RED.texture());
            event.addSprite(CelestialMaterials.BLUE.texture());
        }
    }

    @SubscribeEvent
    public static void onRegisterColor(ColorHandlerEvent.Item event) {
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.LIGHTWEIGHT_SPACESUIT_HELMET.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.LIGHTWEIGHT_SPACESUIT_CHESTPLATE.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.LIGHTWEIGHT_SPACESUIT_LEGGINGS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.BUOYANT_SPACESUIT_BOOTS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.HEAVY_DUTY_SPACESUIT_HELMET.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.HEAVY_DUTY_SPACESUIT_CHESTPLATE.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.HEAVY_DUTY_SPACESUIT_LEGGINGS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.GRAVITY_SPACESUIT_BOOTS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.INSULATED_SPACESUIT_HELMET.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.INSULATED_SPACESUIT_CHESTPLATE.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.INSULATED_SPACESUIT_LEGGINGS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.INSULATED_SPACESUIT_BOOTS.get());
        SpacesuitArmorItem.registerSpacesuitItemColors(event, CelestialItems.LONG_FALL_SPACESUIT_BOOTS.get());

    }
}