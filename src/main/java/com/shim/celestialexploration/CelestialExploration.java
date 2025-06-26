package com.shim.celestialexploration;

import com.shim.celestialexploration.config.CelestialClientConfig;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.config.CelestialServerConfig;
import com.shim.celestialexploration.data.CelestialDimensionEffectsManager;
import com.shim.celestialexploration.data.CelestialDimensionManager;
import com.shim.celestialexploration.data.CelestialPlanetManager;
import com.shim.celestialexploration.events.CelestialCommonEventSetup;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.*;
import mod.azure.azurelib.AzureLib;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

@Mod("celestialexploration")
public class CelestialExploration {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "celestialexploration";

    public CelestialExploration() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = MinecraftForge.EVENT_BUS;

//        // Register the setup method for mod-loading
        modEventBus.addListener(CelestialCommonEventSetup::commonSetup);
        // Register the enqueueIMC method for mod-loading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for mod-loading
        modEventBus.addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        CelestialItems.ITEMS.register(modEventBus);
        CelestialBlocks.BLOCKS.register(modEventBus);
        CelestialBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        CelestialMenus.MENUS.register(modEventBus);
        CelestialPOIs.POI.register(modEventBus);
        CelestialEffects.MOB_EFFECTS.register(modEventBus);
        CelestialEntities.ENTITY_TYPES.register(modEventBus);
        CelestialFeatures.FEATURES.register(modEventBus);
        CelestialFluids.FLUIDS.register(modEventBus);
        CelestialStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        CelestialParticles.PARTICLES.register(modEventBus);
        CelestialRecipes.SERIALIZERS.register(modEventBus);
        CelestialVillagers.VILLAGER_PROFESSIONS.register(modEventBus);
        CelestialPaintings.PAINTING_MOTIVES.register(modEventBus);

        CelestialBiomes.BIOMES.register(modEventBus);
        CelestialDimensions.BIOME_SOURCE.register(modEventBus);
        CelestialNoises.NOISES.register(modEventBus);

        modEventBus.addListener(CelestialCapabilities::registerCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener(ItemStack.class, CelestialCapabilities::attachItemCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener(BlockEntity.class, CelestialCapabilities::attachBlockCapabilities);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, CelestialCapabilities::attachEntityCapabilities);

        MinecraftForge.EVENT_BUS.addListener(this::reloadResources);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CelestialClientConfig.SPEC, "celestialexploration-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CelestialCommonConfig.SPEC, "celestialexploration-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CelestialServerConfig.SPEC, "celestialexploration-server.toml");

        AzureLib.initialize();

        bus.addListener((InputEvent.KeyInputEvent e) -> onKeyPress(e.getKey(), e.getAction(), e.getModifiers()));
    }

    public static final IProxy PROXY = DistExecutor.unsafeRunForDist(()-> ClientProxy::new, ()-> ServerProxy::new);

    private void enqueueIMC(final InterModEnqueueEvent event) {}

    private void processIMC(final InterModProcessEvent event) {}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

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

    @Nullable
    public static <T> T getCapability(Entity entityIn, Capability<T> capability) {
        if (entityIn == null) return null;
        return entityIn.getCapability(capability).isPresent() ? entityIn.getCapability(capability).orElseThrow(() -> new IllegalArgumentException("Lazy optional must not be empty")) : null;
    }

    private void reloadResources(final AddReloadListenerEvent event) {
        event.addListener(new CelestialDimensionManager());
        event.addListener(new CelestialPlanetManager());
        event.addListener(new CelestialDimensionEffectsManager());

    }
}