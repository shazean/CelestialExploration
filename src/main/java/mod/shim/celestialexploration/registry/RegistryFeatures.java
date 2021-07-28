//package mod.shim.celestialexploration.registry;
//
//import mod.shim.celestialexploration.Main;
//import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
//import mod.shim.celestialexploration.world.gen.feature.SulfurLake;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.Item;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.Features;
//import net.minecraft.world.gen.feature.LakesFeature;
//import net.minecraft.world.gen.feature.NoFeatureConfig;
//import net.minecraft.world.gen.placement.ChanceConfig;
//import net.minecraft.world.gen.placement.Placement;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class RegistryFeatures {
//
//	
//	
//	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Main.MODID);
//	
//	
//	public static void init() {
//		FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
//	}
//
//	
//	public static final RegistryObject<LakesFeature> CELESTIAL_LAKE = FEATURES.register("sulfur_lake", 
//			() -> new LakesFeature(BlockStateFeatureConfig.CODEC));
//	
//	   public ConfiguredFeature<FC, ?> configured(FC p_225566_1_) {
//		      return new ConfiguredFeature<>(this, p_225566_1_);
//		   }
//
//	
//	public static final RegistryObject<ConfiguredFeature<?, ?>> LAKE_LAVA = FEATURES.register("lake_lava", () -> CELESTIAL_LAKE.configured(new BlockStateFeatureConfig(Features.States.LAVA)).decorated(Placement.LAVA_LAKE.configured(new ChanceConfig(80))));
//	   
//	
//	
////	Feature.LAKE.configured(new BlockStateFeatureConfig(SULFUR)).decorated(Placement.LAVA_LAKE.configured(new ChanceConfig(80))));
//
//	
////	public static final RegistryObject<Feature<NoFeatureConfig>> HONEYCOMB_HOLE = FEATURES.register("honeycomb_holes", () -> new HoneycombHole(NoFeatureConfig.CODEC));
//	
//	
////	public static final ConfiguredFeature<?, ?> LAKE_LAVA = register("lake_lava", Feature.LAKE.configured(new BlockStateFeatureConfig(Features.States.LAVA)).decorated(Placement.LAVA_LAKE.configured(new ChanceConfig(80))));
//
//	
//    protected static final FluidState SULFUR_STATE = RegistryFluids.SULFUR.get().defaultFluidState();
//    protected static final BlockState SULFUR = RegistryBlocks.SULFUR_BLOCK.get().defaultBlockState();
//
//	
//}