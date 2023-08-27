package com.shim.celestialexploration;

import java.util.stream.Collectors;

import com.shim.celestialexploration.entity.RustSlimeEntity;
import com.shim.celestialexploration.entity.renderer.LunarSlimeRenderer;
import com.shim.celestialexploration.entity.renderer.LurkerRenderer;
import com.shim.celestialexploration.entity.renderer.MarsMallowRenderer;
import com.shim.celestialexploration.entity.renderer.RustSlimeRenderer;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod("celestialexploration")
public class CelestialExploration {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "celestialexploration";

    public CelestialExploration() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = MinecraftForge.EVENT_BUS;

        // Register the setup method for modloading
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        modEventBus.addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(this::clientSetup);
        });

        BlockRegistry.init();
        ItemRegistry.init();
        ContainerRegistry.init();
        BlockEntityRegistry.init();

        StructureRegistry.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        PortalRegistry.register(modEventBus);
        EffectRegistry.register(modEventBus);
        EntityRegistry.register(modEventBus);

//        bus.addListener(EventPriority.NORMAL, Structures::addDimensionalSpacing);
//        bus.addListener(EventPriority.NORMAL, Structures::setupStructureSpawns);

        GeckoLib.initialize();

    }

    public static final CreativeModeTab CELESTIAL_TAB = new CreativeModeTab("celestialtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MOON_DUST.get());
        }
    };

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("celestialexploration", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    public void clientSetup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            DimensionRenderers.setDimensionEffects();
        });

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MARS_PORTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MOON_PORTAL.get(), RenderType.translucent());

        EntityRenderers.register(EntityRegistry.RUST_SLIME.get(), RustSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.LUNAR_SLIME.get(), LunarSlimeRenderer::new);
        EntityRenderers.register(EntityRegistry.MARS_MALLOW.get(), MarsMallowRenderer::new);
        EntityRenderers.register(EntityRegistry.LURKER.get(), LurkerRenderer::new);

    }

}
