package com.shim.celestialexploration.setup;

import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.blocks.screens.SolarPanelScreen;
import com.shim.celestialexploration.registry.ContainerRegistry;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        MenuScreens.register(ContainerRegistry.SOLAR_PANEL_CONTAINER.get(), SolarPanelScreen::new);
//        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
//        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);

        event.enqueueWork(() -> {
//            MagicRenderer.register();
//            ItemBlockRenderTypes.setRenderLayer(Registration.COMPLEX_MULTIPART.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(Registration.FANCYBLOCK.get(), (RenderType) -> true);
//            Minecraft.getInstance().getBlockColors().register(new FancyBlockColor(), Registration.FANCYBLOCK.get());
        });
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
//        event.registerLayerDefinition(WeirdMobModel.CUBE_LAYER, WeirdMobModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerEntityRenderer(Registration.WEIRDMOB.get(), WeirdMobRenderer::new);
    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {
//        event.getItemColors().register((stack, i) -> 0xff0000, Registration.WEIRDMOB_EGG.get());
    }

    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
//        ModelLoaderRegistry.registerLoader(new ResourceLocation(MyTutorial.MODID, "fancyloader"), new FancyModelLoader());
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getAtlas().location().equals(TextureAtlas.LOCATION_BLOCKS)) {
            return;
        }

  //      event.addSprite(MAGICBLOCK_TEXTURE);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.GatherComponents event) {
        Item item = event.getItemStack().getItem();
        if (item.getRegistryName().getNamespace().equals(CelestialExploration.MODID)) {
            event.setMaxWidth(200);
        }
    }

}