package mod.shim.celestialexploration.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.world.World;

public class RoverEntity extends CreatureEntity {

	public RoverEntity(EntityType<? extends RoverEntity> p_i48577_1_, World p_i48577_2_) {
		super(p_i48577_1_, p_i48577_2_);
		// TODO Auto-generated constructor stub
	}
	
	public static AttributeModifierMap.MutableAttribute createLivingAttributes() {
	    
		return CreatureEntity.createLivingAttributes().add(Attributes.MAX_HEALTH, 20.0f).add(Attributes.MOVEMENT_SPEED, 1.2f).add(Attributes.FOLLOW_RANGE, 5);
		
//		return AttributeModifierMap.builder().add(Attributes.MAX_HEALTH).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.MOVEMENT_SPEED).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	   }


	@Override
	protected void registerGoals() {
		// TODO Auto-generated method stub
		super.registerGoals();
		
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
//		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 5.0f));

	}
	

}
