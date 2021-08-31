package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.blocks.BlockItemBase;
import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import mod.shim.celestialexploration.potion.CelestialEffect;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryEffects {

//	public static DeferredRegister<Attribute> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Main.MODID);
	public static DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MODID);
	

	
	public static void init() {
		EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	
	public static final RegistryObject<Effect> GRAVITY = EFFECTS.register("gravity", () -> new CelestialEffect(EffectType.NEUTRAL, 5926017).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "503FE595-3498-8478-234A-3EC09BF892EF", 0.01D, AttributeModifier.Operation.ADDITION));
//	public static final RegistryObject<Item> CERAMIC = ITEMS.register("ceramic",  () -> new BlockItemBase(RegistryBlocks.CERAMIC.get()));	

	
//	   public static final Effect MOVEMENT_SPEED = register(1, "speed", (new Effect(EffectType.BENEFICIAL, 8171462)).addAttributeModifier(Attributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", (double)0.2F, AttributeModifier.Operation.MULTIPLY_TOTAL));

	
}
