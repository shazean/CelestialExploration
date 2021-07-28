//package mod.shim.celestialexploration.world.gen.feature;
//
//import java.util.Locale;
//
//
//import mod.shim.celestialexploration.Main;
//
//import mod.shim.celestialexploration.world.gen.feature.structure.CraterPiece;
//import mod.shim.celestialexploration.world.gen.feature.structure.CraterStructure;
//import net.minecraft.block.Block;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.IFeatureConfig;
//import net.minecraft.world.gen.feature.NoFeatureConfig;
//import net.minecraft.world.gen.feature.StructureFeature;
//import net.minecraft.world.gen.feature.structure.IStructurePieceType;
//import net.minecraft.world.gen.feature.structure.JunglePyramidStructure;
//import net.minecraft.world.gen.feature.structure.Structure;
//import net.minecraftforge.common.ToolType;
//import net.minecraftforge.event.RegistryEvent.Register;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.IForgeRegistry;
//
//public class CelestialFeature<FC extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Feature<?>> {
//
//	public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Main.MODID);
//
//	
//	//Static instance of our structure so we can reference it and add it to biomes easily.
////		public static Structure<NoFeatureConfig> CRATER = new CraterStructure(NoFeatureConfig.CODEC);
////		public static IStructurePieceType CP = CraterPiece.Piece::new;
//		
//		
//		public static RegistryObject<CraterStructure> CRATER = STRUCTURES.register("crater", () -> new CraterStructure(NoFeatureConfig.CODEC));
//		public static IStructurePieceType CP = CraterPiece.Piece::new;
//
//		
////		public static Structure<NoFeatureConfig> CRATER_METEOR = new CraterMeteorStructure(NoFeatureConfig::deserialize);
////		public static IStructurePieceType CMP = CraterMeteorPiece.Piece::new;
//
//		
////		public static final Structure<NoFeatureConfig> JUNGLE_TEMPLE = register("Jungle_Pyramid", new JunglePyramidStructure(NoFeatureConfig.CODEC), GenerationStage.Decoration.SURFACE_STRUCTURES);
////		public static final RegistryObject<Block> MOON_ROCK_BLOCK = BLOCKS.register("moon_rock_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//
//
//		/*
//		 * Registers the features and structures. Normal Features will be registered here too.
//		 */
//		public static void registerFeatures(Register<Feature<?>> event)
//		{
//			IForgeRegistry<Feature<?>> registry = event.getRegistry();
//
//			/* Registers the structure itself and sets what its path is. In this case,
//			 * the structure will have the resourcelocation of structure_tutorial:run_down_house .
//			 * 
//			 * It is always a good idea to register your regular features too so that other mods
//			 * can use them too directly from the Forge Registry. It great for mod compatibility.
//			 */
////			Main.register(registry, CRATER, "crater");
//			register(CP, "CP");
//			
//			
////			Main.register(registry, CRATER_METEOR, "crater_meteor");
////			register(CMP, "CMP");
//			
//		}
//		
//		
//		static IStructurePieceType register(IStructurePieceType structurePiece, String key)
//		{
//			return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
//		}
//	
////	public static final DeferredRegister<Feature<?>> STRUCTURE = new DeferredRegister<>(ForgeRegistries.FEATURES, Main.MODID);
////	public static final DeferredRegister<Feature<?>> FEATURE = new DeferredRegister<>(ForgeRegistries.FEATURES, Main.MODID);
////
////	
////	
//	public static void init() {
//		STRUCTURES.register(FMLJavaModLoadingContext.get().getModEventBus());
////		FEATURE.register(FMLJavaModLoadingContext.get().getModEventBus());
//		System.out.println("CelestialFeature *init* CHECK");
//	}
////
////	
////	private static final String SMALL_CRATER_STRUCTURE = "scs";
////	
////	
////	   public static final RegistryObject<SmallCraterStructure> SMALL_CRATER = STRUCTURE.register("small_crater_structure", () -> new SmallCraterStructure(NoFeatureConfig::deserialize));
////	   
////	   public static final RegistryObject<ReplaceBlockFeature> GLOWING_MOON_SAND = FEATURE.register("glowing_moon_sand", () -> new ReplaceBlockFeature(ReplaceBlockConfig::deserialize));
////	   
//////	   public static final Feature<ReplaceBlockConfig> EMERALD_ORE = register("emerald_ore", new ReplaceBlockFeature(ReplaceBlockConfig::deserialize));
//////	public static final Feature<OreFeatureConfig> ORE = register("ore", new OreFeature(OreFeatureConfig::deserialize));
////	   
////	   
//////	public static final Structure<NoFeatureConfig> JUNGLE_TEMPLE = register("jungle_temple", new JunglePyramidStructure(NoFeatureConfig::deserialize));
////	   	   
////	   
////	   private final Function<Dynamic<?>, ? extends FC> configFactory;
////
////	   private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
////	      return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
////	   }
////
////	   public CelestialFeature(Function<Dynamic<?>, ? extends FC> configFactoryIn) {
////	      this.configFactory = configFactoryIn;
////	   }
////
//////	   public ConfiguredFeature<FC, ?> withConfiguration(FC p_225566_1_) {
//////	      return new ConfiguredFeature<>(this, p_225566_1_);
//////	   }
////
////	   public FC createConfig(Dynamic<?> p_214470_1_) {
////	      return (FC)(this.configFactory.apply(p_214470_1_));
////	   }
////
////	   protected void setBlockState(IWorldWriter worldIn, BlockPos pos, BlockState state) {
////	      worldIn.setBlockState(pos, state, 3);
////	   }
////
//////	   public abstract boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, FC config);
////
////	   public List<Biome.SpawnListEntry> getSpawnList() {
////	      return Collections.emptyList();
////	   }
////
////	   public List<Biome.SpawnListEntry> getCreatureSpawnList() {
////	      return Collections.emptyList();
////	   }
////
////	   protected static boolean isStone(Block blockIn) {
////	      return net.minecraftforge.common.Tags.Blocks.STONE.contains(blockIn);
////	   }
////
////	   protected static boolean isDirt(Block blockIn) {
////	      return net.minecraftforge.common.Tags.Blocks.DIRT.contains(blockIn);
//	   }
//	   
////	   public static void registerBiomeSpanws(FMLCommonSetupEvent event) {
////		   for(Biome biome : ForgeRegistries.BIOMES) {
////			   biome.addStructure(SMALL_CRATER_STRUCTURE, IFeatureConfig.NO_FEATURE_CONFIG);
////			   biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(SMALL_CRATER_STRUCTURE,
////					   IFeatureConfig.NO_FEATURE_CONFIG,Placement.NOPE, NoPlacementConfig.NO_PLACEMENT_CONFIG
////					   ));
////		   }
////	   }
//	   
//
