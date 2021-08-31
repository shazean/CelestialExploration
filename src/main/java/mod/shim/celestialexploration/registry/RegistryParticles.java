package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.potion.CelestialEffect;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryParticles {

	public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Main.MODID);
	
	
	public static void init() {
		PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//FIXME?
	public static final RegistryObject<BasicParticleType> RUST_SLIME = PARTICLES.register("rust_slime", () -> new BasicParticleType(false));
	
	
//	public static final RegistryObject<Effect> GRAVITY = EFFECTS.register("gravity", () -> new CelestialEffect(EffectType.NEUTRAL, 5926017).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "503FE595-3498-8478-234A-3EC09BF892EF", 0.01D, AttributeModifier.Operation.ADDITION));
	
//	   private static BasicParticleType register(String p_218415_0_, boolean p_218415_1_) {
//		      return Registry.register(Registry.PARTICLE_TYPE, p_218415_0_, new BasicParticleType(p_218415_1_));
//		   }

	
	
}