package mod.shim.celestialexploration.entity;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class RoverEntity extends CreatureEntity {

	public RoverEntity(EntityType<? extends RoverEntity> p_i48577_1_, World p_i48577_2_) {
		super(p_i48577_1_, p_i48577_2_);
		// TODO Auto-generated constructor stub
	}
	
	
	   private static final DataParameter<Optional<BlockState>> DATA_CARRY_STATE = EntityDataManager.defineId(RoverEntity.class, DataSerializers.BLOCK_STATE);

	public static AttributeModifierMap.MutableAttribute createLivingAttributes() {
	    
		
		return CreatureEntity.createLivingAttributes().add(Attributes.MAX_HEALTH, 20.0f).add(Attributes.MOVEMENT_SPEED, 0.05D).add(Attributes.FOLLOW_RANGE, 5);
		
//		return AttributeModifierMap.builder().add(Attributes.MAX_HEALTH).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.MOVEMENT_SPEED).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	   }


	@Override
	protected void registerGoals() {
		// TODO Auto-generated method stub
		super.registerGoals();
		
		this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 5.0f));
		
//	      this.goalSelector.addGoal(2, new RoverEntity.PlaceBlockGoal(this));
//	      this.goalSelector.addGoal(3, new RoverEntity.TakeBlockGoal(this));


	}
	
	//FIXME -- crash report 2021-08-12_16.10.59
//	   public void setCarriedBlock(@Nullable BlockState p_195406_1_) {
//		      this.entityData.set(DATA_CARRY_STATE, Optional.ofNullable(p_195406_1_));
//		   }
//
//	
//	   @Nullable
//	   public BlockState getCarriedBlock() {
//	      return this.entityData.get(DATA_CARRY_STATE).orElse((BlockState)null);
//	   }
//
//	
//	
//	  static class PlaceBlockGoal extends Goal {
//	      private final RoverEntity rover;
//
//	      public PlaceBlockGoal(RoverEntity p_i45843_1_) {
//	         this.rover = p_i45843_1_;
//	      }
//
//	      public boolean canUse() {
//	         if (this.rover.getCarriedBlock() == null) {
//	            return false;
//	         } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rover.level, this.rover)) {
//	            return false;
//	         } else {
//	            return this.rover.getRandom().nextInt(2000) == 0;
//	         }
//	      }
//
//	      public void tick() {
//	         Random random = this.rover.getRandom();
//	         World world = this.rover.level;
//	         int i = MathHelper.floor(this.rover.getX() - 1.0D + random.nextDouble() * 2.0D);
//	         int j = MathHelper.floor(this.rover.getY() + random.nextDouble() * 2.0D);
//	         int k = MathHelper.floor(this.rover.getZ() - 1.0D + random.nextDouble() * 2.0D);
//	         BlockPos blockpos = new BlockPos(i, j, k);
//	         BlockState blockstate = world.getBlockState(blockpos);
//	         BlockPos blockpos1 = blockpos.below();
//	         BlockState blockstate1 = world.getBlockState(blockpos1);
//	         BlockState blockstate2 = this.rover.getCarriedBlock();
//	         if (blockstate2 != null) {
//	            blockstate2 = Block.updateFromNeighbourShapes(blockstate2, this.rover.level, blockpos);
//	            if (this.canPlaceBlock(world, blockpos, blockstate2, blockstate, blockstate1, blockpos1) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(rover, net.minecraftforge.common.util.BlockSnapshot.create(world.dimension(), world, blockpos1), net.minecraft.util.Direction.UP)) {
//	               world.setBlock(blockpos, blockstate2, 3);
//	               this.rover.setCarriedBlock((BlockState)null);
//	            }
//
//	         }
//	      }
//
//	      private boolean canPlaceBlock(World p_220836_1_, BlockPos p_220836_2_, BlockState p_220836_3_, BlockState p_220836_4_, BlockState p_220836_5_, BlockPos p_220836_6_) {
//	         return p_220836_4_.isAir(p_220836_1_, p_220836_2_) && !p_220836_5_.isAir(p_220836_1_, p_220836_6_) && !p_220836_5_.is(Blocks.BEDROCK) && !p_220836_5_.is(net.minecraftforge.common.Tags.Blocks.ENDERMAN_PLACE_ON_BLACKLIST) && p_220836_5_.isCollisionShapeFullBlock(p_220836_1_, p_220836_6_) && p_220836_3_.canSurvive(p_220836_1_, p_220836_2_) && p_220836_1_.getEntities(this.rover, AxisAlignedBB.unitCubeFromLowerCorner(Vector3d.atLowerCornerOf(p_220836_2_))).isEmpty();
//	      }
//	   }
//
//	 
//
//	   static class TakeBlockGoal extends Goal {
//	      private final RoverEntity rover;
//
//	      public TakeBlockGoal(RoverEntity p_i45841_1_) {
//	         this.rover = p_i45841_1_;
//	      }
//
//	      public boolean canUse() {
//	         if (this.rover.getCarriedBlock() != null) {
//	            return false;
//	         } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rover.level, this.rover)) {
//	            return false;
//	         } else {
//	            return this.rover.getRandom().nextInt(20) == 0;
//	         }
//	      }
//
//	      public void tick() {
//	         Random random = this.rover.getRandom();
//	         World world = this.rover.level;
//	         int i = MathHelper.floor(this.rover.getX() - 2.0D + random.nextDouble() * 4.0D);
//	         int j = MathHelper.floor(this.rover.getY() + random.nextDouble() * 3.0D);
//	         int k = MathHelper.floor(this.rover.getZ() - 2.0D + random.nextDouble() * 4.0D);
//	         BlockPos blockpos = new BlockPos(i, j, k);
//	         BlockState blockstate = world.getBlockState(blockpos);
//	         Block block = blockstate.getBlock();
//	         Vector3d vector3d = new Vector3d((double)MathHelper.floor(this.rover.getX()) + 0.5D, (double)j + 0.5D, (double)MathHelper.floor(this.rover.getZ()) + 0.5D);
//	         Vector3d vector3d1 = new Vector3d((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
//	         BlockRayTraceResult blockraytraceresult = world.clip(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, this.rover));
//	         boolean flag = blockraytraceresult.getBlockPos().equals(blockpos);
//	         if (block.is(BlockTags.ENDERMAN_HOLDABLE) && flag) {
//	            world.removeBlock(blockpos, false);
//	            this.rover.setCarriedBlock(blockstate.getBlock().defaultBlockState());
//	         }
//
//	      }
//	   }
	
}
