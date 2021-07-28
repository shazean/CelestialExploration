package mod.shim.celestialexploration.registry;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class RegistryBiomes {

	   public static final RegistryKey<Biome> MARS_DESERTS = register("mars_deserts");
	   public static final RegistryKey<Biome> MARS_CANYONS = register("mars_canyons");
	   public static final RegistryKey<Biome> OLYMPUS_MONS = register("olympus_mons");
	   public static final RegistryKey<Biome> MARS_POLES = register("mars_poles");

	   
	   
	   private static RegistryKey<Biome> register(String p_242548_0_) {
	      return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(p_242548_0_));
	   }

	
}
