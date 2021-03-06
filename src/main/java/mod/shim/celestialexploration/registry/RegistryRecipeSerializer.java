package mod.shim.celestialexploration.registry;

import 	cpw.mods.modlauncher.TransformingClassLoader;




import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.items.crafting.AssemblyStationRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public interface RegistryRecipeSerializer {

	
	public static DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Main.MODID);
	
	public static void init() {
		RECIPE_SERIALIZER.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	
	public static final RegistryObject<IRecipeSerializer<AssemblyStationRecipe>> ASSEMBLY_STATION_RECIPE = RECIPE_SERIALIZER.register("assembly_station_recipe", 
			() -> new AssemblyStationRecipe.Serializer());
	
	
	
//	public static final RegistryObject<IRecipeSerializer<OxygenCompressorRecipe>> OXYGEN_COMPRESSOR_RECIPE = RECIPE_SERIALIZER.register("oxygen_compressor_recipe", 
//			() -> new OxygenCompressorRecipe.Serializer());

	
//	   IRecipeSerializer<ShapedRecipe> SHAPED_RECIPE = register("crafting_shaped", new ShapedRecipe.Serializer());

	
}
