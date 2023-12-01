package com.shim.celestialexploration;

import com.shim.celestialexploration.entity.LunarSlime;
import com.shim.celestialexploration.entity.Lurker;
import com.shim.celestialexploration.entity.MarsMallow;
import com.shim.celestialexploration.entity.RustSlime;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.Keybinds;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.annotation.Nullable;
import java.util.stream.Collectors;

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

//        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
//            modEventBus.addListener(this::clientSetup);
//        });

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        ContainerRegistry.register(modEventBus);
        BlockEntityRegistry.register(modEventBus);
        MenuRegistry.register(modEventBus);
        PortalRegistry.register(modEventBus);
        EffectRegistry.register(modEventBus);
        EntityRegistry.register(modEventBus);
        FeatureRegistry.register(modEventBus);
        FluidRegistry.register(modEventBus);
        StructureRegistry.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        ParticleRegistry.register(modEventBus);
        RecipeRegistry.register(modEventBus);

        modEventBus.addListener(CapabilityRegistry::registerCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener(ItemStack.class, CapabilityRegistry::attachItemCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener(BlockEntity.class, CapabilityRegistry::attachBlockCapabilities);

//        bus.addListener(EventPriority.NORMAL, Structures::addDimensionalSpacing);
//        bus.addListener(EventPriority.NORMAL, Structures::setupStructureSpawns);

        GeckoLib.initialize();

        bus.addListener((InputEvent.KeyInputEvent e) -> onKeyPress(e.getKey(), e.getAction(), e.getModifiers()));
    }

    public static final CreativeModeTab CELESTIAL_BLOCKS_TAB = new CreativeModeTab("celestialblockstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MOON_STONE.get());
        }
    };

    public static final CreativeModeTab CELESTIAL_MISC_TAB = new CreativeModeTab("celestialmisctab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MOON_DUST.get());
        }
    };

    public static final CreativeModeTab SHUTTLE_TAB = new CreativeModeTab("shuttletab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WHITE_SHUTTLE.get());
        }
    };

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        SpawnPlacements.register(EntityRegistry.MARS_MALLOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MarsMallow::checkMarsMallowSpawnRules);
        SpawnPlacements.register(EntityRegistry.RUST_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, RustSlime::checkRustSlimeSpawnRules);
        SpawnPlacements.register(EntityRegistry.LUNAR_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LunarSlime::checkLunarSlimeSpawnRules);
        SpawnPlacements.register(EntityRegistry.LURKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Lurker::checkMonsterSpawnRules);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(MODID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
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

    static void onKeyPress(int key, int action, int modifiers) {
        Keybinds.handleKeyPress(key, action);
    }

    @Nullable
    public static <T> T getCapability(ItemStack stackIn, Capability<T> capability) {
        if (stackIn == null) return null;
        return stackIn.getCapability(capability).isPresent() ? stackIn.getCapability(capability).orElseThrow(() -> new IllegalArgumentException("Lazy optional must not be empty")) : null;
    }

    @Nullable
    public static <T> T getCapability(BlockEntity entityIn, Capability<T> capability) {
        if (entityIn == null) return null;
        return entityIn.getCapability(capability).isPresent() ? entityIn.getCapability(capability).orElseThrow(() -> new IllegalArgumentException("Lazy optional must not be empty")) : null;
    }
}
