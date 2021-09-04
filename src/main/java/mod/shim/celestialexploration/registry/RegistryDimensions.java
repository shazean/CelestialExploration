package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class RegistryDimensions {
	
	public static final ResourceLocation MARS_ID = new ResourceLocation(Main.MODID, "mars");
	
	public static final RegistryKey<World> MARS_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, MARS_ID);

}
