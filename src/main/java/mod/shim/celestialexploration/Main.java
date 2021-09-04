package mod.shim.celestialexploration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.shim.celestialexploration.entity.RoverEntity;
import mod.shim.celestialexploration.entity.mobs.LurkerEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.RustSlimeEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.SulfuricSlimeEntity;
import mod.shim.celestialexploration.entity.mobs.slimes.WhiteSlimeEntity;
import mod.shim.celestialexploration.items.ModSpawnEgg;
import mod.shim.celestialexploration.registry.RegistryBiomes;
import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryContainerType;
import mod.shim.celestialexploration.registry.RegistryEffects;
import mod.shim.celestialexploration.registry.RegistryEntities;
import mod.shim.celestialexploration.registry.RegistryFeatures;
import mod.shim.celestialexploration.registry.RegistryFluids;
import mod.shim.celestialexploration.registry.RegistryItems;
import mod.shim.celestialexploration.registry.RegistryParticles;
import mod.shim.celestialexploration.registry.RegistryRecipeSerializer;
import mod.shim.celestialexploration.registry.RegistrySurfaceBuilders;
import mod.shim.celestialexploration.registry.RegistryTileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(Main.MODID)
@Mod.EventBusSubscriber(modid = Main.MODID, bus = Bus.MOD)
public class Main {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "celestialexploration";

//    public static final ResourceLocation MOON_DIM_TYPE = new ResourceLocation(MODID, "moon");
        
    public Main() {
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
//        RegistryStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
//        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
//        
//        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
//        
        RegistryItems.init();
        RegistryBlocks.init();
        RegistryFluids.init();
        RegistryTileEntity.init();
        RegistryContainerType.init();
        RegistryRecipeSerializer.init();
        RegistryEffects.init();
        RegistrySurfaceBuilders.init();
        RegistryParticles.init();
        RegistryBiomes.BIOMES.register(bus);
        
        RegistryFeatures.init();
        
        RegistryEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
//      RegistryEntities.ENTITY_TYPES.register(bus);

//        bus.register(new RegistryRecipeSerializer());
        
//        CelestialFeature.init();
//        CelestialStructures.init();
        System.out.println("Main *Main* CHECK");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        
    }
   

   
  
   
//    @SubscribeEvent
//   	public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
//   	{
//   		CelestialFeature.registerFeatures(event);
//
//   		LOGGER.log(Level.INFO, "features/structures registered.");
//   	}
    
    
    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)	{
    	event.enqueueWork(() -> {
//    		RegistryStructures.setupStructures();
//            RegistryConfiguredStructures.registerConfiguredStructures();
        });
    	
    	DeferredWorkQueue.runLater(() -> { //FIXME?
//    		GlobalEntityTypeAttributes.put(RegistryEntities.SHUTTLE.get(), ShuttleEntity.createLivingAttributes().build()); //ADD A NEW ONE OF THESE LINES FOR EACH ENTITY
    		GlobalEntityTypeAttributes.put(RegistryEntities.ROVER.get(), RoverEntity.createLivingAttributes().build());
    		GlobalEntityTypeAttributes.put(RegistryEntities.LURKER.get(), LurkerEntity.createAttributes().build());
    		GlobalEntityTypeAttributes.put(RegistryEntities.RUST_SLIME.get(), RustSlimeEntity.createMonsterAttributes().build());
    		GlobalEntityTypeAttributes.put(RegistryEntities.WHITE_SLIME.get(), WhiteSlimeEntity.createMonsterAttributes().build());
    		GlobalEntityTypeAttributes.put(RegistryEntities.SULFURIC_SLIME.get(), SulfuricSlimeEntity.createAttributes().build());

    
    	});

    	
    	for (Biome biome : ForgeRegistries.BIOMES)
		{ 
		
//			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, CelestialFeature.CRATER);
//			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, CelestialFeature.CRATER_METEOR.withConfiguration(IFeatureConfig.NONE)
//					.withPlacement(Placement.NOPE.configured(IPlacementConfig.NONE)));

		}
    	
    	
//    	DeferredWorkQueue.runLater(() -> {
//    		GlobalEntityTypeAttributes.put(RegistryEntities.SHUTTLE.get(), ShuttleEntity.create()); //ADD A NEW ONE OF THESE LINES FOR EACH ENTITY
//    	});

    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
    	ModSpawnEgg.initSpawnEggs();
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
//        RenderingRegistry.registerEntityRenderingHandler(RegistryEntities.SHUTTLE.get(), ShuttleRenderer::new);
        
    }

    public static final ItemGroup CELESTIAL_TAB = new ItemGroup("celestial_tab") {
 
    	@Override
    	public ItemStack makeIcon() {
    		return new ItemStack(RegistryBlocks.LUNAR_LANTERN.get());
    	}
    	
    };
   
    
    public static final ItemGroup SHUTTLE_TAB = new ItemGroup("shuttle_tab") {
    	 
    	@Override
    	public ItemStack makeIcon() {
    		return new ItemStack(RegistryItems.MOON_DUST.get());
    	}
    	
    };

    
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
	{
		entry.setRegistryName(new ResourceLocation(Main.MODID, registryKey));
		registry.register(entry);
		return entry;
	}


    /**
     * This is the event you will use to add anything to any biome.
     * This includes spawns, changing the biome's looks, messing with its surfacebuilders,
     * adding carvers, spawning new features... etc
     *
     * Here, we will use this to add our structure to all biomes.
     */
//    public void biomeModification(final BiomeLoadingEvent event) {
//        /*
//         * Add our structure to all biomes including other modded biomes.
//         * You can skip or add only to certain biomes based on stuff like biome category,
//         * temperature, scale, precipitation, mod id, etc. All kinds of options!
//         *
//         * You can even use the BiomeDictionary as well! To use BiomeDictionary, do
//         * RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName()) to get the biome's
//         * registrykey. Then that can be fed into the dictionary to get the biome's types.
//         */
//        event.getGeneration().getStructures().add(() -> RegistryConfiguredStructures.CONFIGURED_CRATER);
//    }

    /**
     * Will go into the world's chunkgenerator and manually add our structure spacing.
     * If the spacing is not added, the structure doesn't spawn.
     *
     * Use this for dimension blacklists for your structure.
     * (Don't forget to attempt to remove your structure too from the map if you are blacklisting that dimension!)
     * (It might have your structure in it already.)
     *
     * Basically use this to make absolutely sure the chunkgenerator can or cannot spawn your structure.
     */
//    private static Method GETCODEC_METHOD;
//    public void addDimensionalSpacing(final WorldEvent.Load event) {
//        if(event.getWorld() instanceof ServerWorld){
//            ServerWorld serverWorld = (ServerWorld)event.getWorld();
//
//            /*
//             * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
//             * They will handle your structure spacing for your if you add to WorldGenRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
//             * This here is done with reflection as this tutorial is not about setting up and using Mixins.
//             * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
//             */
//            try {
//                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
//                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
//                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
//            }
//            catch(Exception e){
//                Main.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
//            }
//
//            /*
//             * Prevent spawning our structure in Vanilla's superflat world as
//             * people seem to want their superflat worlds free of modded structures.
//             * Also that vanilla superflat is really tricky and buggy to work with in my experience.
//             */
//            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
//                serverWorld.dimension().equals(World.OVERWORLD)){
//                return;
//            }
//
//            /*
//             * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
//             * Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
//             *
//             * NOTE: if you add per-dimension spacing configs, you can't use putIfAbsent as WorldGenRegistries.NOISE_GENERATOR_SETTINGS in FMLCommonSetupEvent
//             * already added your default structure spacing to some dimensions. You would need to override the spacing with .put(...)
//             * And if you want to do dimension blacklisting, you need to remove the spacing entry entirely from the map below to prevent generation safely.
//             */
//            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
//            tempMap.putIfAbsent(RegistryStructures.CRATER.get(), DimensionStructuresSettings.DEFAULTS.get(RegistryStructures.CRATER.get()));
////            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap; FIXME
//        }
//   }

}
