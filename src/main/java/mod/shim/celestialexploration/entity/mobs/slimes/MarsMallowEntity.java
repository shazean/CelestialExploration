package mod.shim.celestialexploration.entity.mobs.slimes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.world.World;

public class MarsMallowEntity extends SlimeEntity {

	public MarsMallowEntity(EntityType<? extends SlimeEntity> p_i48552_1_, World p_i48552_2_) {
		super(p_i48552_1_, p_i48552_2_);
		// TODO Auto-generated constructor stub
	}

	public static AttributeModifierMap.MutableAttribute createMonsterAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE);
	}


}
