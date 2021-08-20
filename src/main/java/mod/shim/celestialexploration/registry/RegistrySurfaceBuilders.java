package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.world.surface.VenusSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistrySurfaceBuilders {
	
	
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Main.MODID);
	
	
	public static void init() {
		SURFACE_BUILDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	public static final RegistryObject<VenusSurfaceBuilder> VENUS_SURFACE_BUILDER = SURFACE_BUILDERS.register("venus_surface_builder", 
			() -> new VenusSurfaceBuilder(SurfaceBuilderConfig.CODEC));
	

}
