package mod.shim.celestialexploration.entity.mobs.slimes;

import mod.shim.celestialexploration.registry.RegistryParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;

public class RustSlimeEntity extends SlimeEntity {

	public RustSlimeEntity(EntityType<? extends SlimeEntity> p_i48552_1_, World p_i48552_2_) {
		super(p_i48552_1_, p_i48552_2_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IParticleData getParticleType() {
		return RegistryParticles.RUST_SLIME.get();
	}

	public static AttributeModifierMap.MutableAttribute createMonsterAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE);
	}

}