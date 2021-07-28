package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.fluid.SulfurFluid;
import mod.shim.celestialexploration.fluid.SulfurFluid.Flowing;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryFluids {


		
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);
	
		
		
	public static void init() {
		FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
		
	   public static final RegistryObject<Flowing> FLOWING_SULFUR = FLUIDS.register("flowing_sulfur", () -> new SulfurFluid.Flowing());
	   public static final RegistryObject<SulfurFluid.Source> SULFUR = FLUIDS.register("sulfur", () -> new SulfurFluid.Source());
	
	}
