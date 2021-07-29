//package mod.shim.celestialexploration.registry;
//
//import mod.shim.celestialexploration.Main;
//import mod.shim.celestialexploration.items.crafting.AssemblyStationRecipe;
//import net.minecraft.item.crafting.IRecipeSerializer;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public interface RegistryRecipeType {
//
//	
//	
//
//	
//	public static DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.rec, Main.MODID);
//	
//	public static void init() {
//		RECIPE_SERIALIZER.register(FMLJavaModLoadingContext.get().getModEventBus());
//	}
//
//	
//	
//	public static final RegistryObject<IRecipeSerializer<AssemblyStationRecipe>> OXYGEN_COMPRESSOR_TILE_ENTITY_TYPE = RECIPE_SERIALIZER.register("oxygen_compressor", 
//			() -> new AssemblyStationRecipe.Serializer());
//	
//	
//	
//	
//}
