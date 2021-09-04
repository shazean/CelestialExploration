package mod.shim.celestialexploration.registry;

import java.util.function.Supplier;

import mod.shim.celestialexploration.Main;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBiomes {

	
		public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Main.MODID);
	
		
		static {
			createBiome("olympus_mons", BiomeMaker::theVoidBiome);
		}
		
	   public static final RegistryKey<Biome> MARS_DESERTS = register("mars_deserts");
	   public static final RegistryKey<Biome> MARS_CANYONS = register("mars_canyons");
	   public static final RegistryKey<Biome> OLYMPUS_MONS = register("olympus_mons");
	   public static final RegistryKey<Biome> MARS_POLES = register("mars_poles");

	   
	   public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
		   return BIOMES.register(biomeName, biome);
	   }
	   
	   
	   private static RegistryKey<Biome> register(String p_242548_0_) {
	      return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(p_242548_0_));
	   }

	
}
