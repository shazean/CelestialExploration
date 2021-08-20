package mod.shim.celestialexploration.blocks;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IPlantable;

public class GeyserBlock extends Block {

	
	public GeyserBlock(AbstractBlock.Properties p_i48366_1_) {
	      super(p_i48366_1_);
	}
	
	public void tick(BlockState blockstate, ServerWorld serverWorld, BlockPos pos, Random random) {
//		int geyserLength = random.nextInt(10);
//		int timeBetween = random.nextInt(1000);
		

//		Boolean length = true;
		
//		System.out.println("GeyserBlock tick");
//		System.out.println("GeyserBlock tick geyserLength: " + geyserLength);

//		System.out.println("GeyserBlock Boolean length: " + length);
		
//		if (geyserLength < 5) {
//			length = false;
//		}
		
//		System.out.println("GeyserBlock Boolean length: " + length);

		
			GeyserColumnBlock.growColumn(serverWorld, pos.above(), true);
			
			
		    serverWorld.addAlwaysVisibleParticle(ParticleTypes.ASH, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);

			serverWorld.addParticle(ParticleTypes.DRIPPING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
			serverWorld.addParticle(ParticleTypes.FALLING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);

	
	}
	
	
	public boolean isRandomlyTicking(BlockState blockstate) {
			return true;
	}

	   public void randomTick(BlockState blockstate, ServerWorld serverWorld, BlockPos pos, Random random) {
			
		   int time = random.nextInt(50);
		   
		   //FIXME hasn't been tested, since randomTick isn't getting called?
		   
		   while (time > 30) {
		   
		   
				GeyserColumnBlock.growColumn(serverWorld, pos.above(), true);
				
				
			    serverWorld.addAlwaysVisibleParticle(ParticleTypes.ASH, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
	
				serverWorld.addParticle(ParticleTypes.DRIPPING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
				serverWorld.addParticle(ParticleTypes.FALLING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);

				
				time--;
				
		   }
		   
				

	   }

	   
	 
	
	
	 public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld iworld, BlockPos p_196271_5_, BlockPos p_196271_6_) {
//	      if (p_196271_2_ == Direction.UP && p_196271_3_.is(Blocks.WATER)) {
	         iworld.getBlockTicks().scheduleTick(p_196271_5_, this, 20);
//	         iworld.getBlockTicks().willTickThisTick(p_196271_6_, this);
//	      }

	      return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, iworld, p_196271_5_, p_196271_6_);
	   }
	
	
	 public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
	      p_220082_2_.getBlockTicks().scheduleTick(p_220082_3_, this, 20);
	   }
	
//	 public static void startGeyser(World p_220098_0_, BlockPos p_220098_1_, boolean p_220098_2_, boolean p_220098_3_) {
//	      Random random = p_220098_0_.getRandom();
//	      BasicParticleType basicparticletype = p_220098_2_ ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
//	      p_220098_0_.addAlwaysVisibleParticle(basicparticletype, true, (double)p_220098_1_.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)p_220098_1_.getY() + random.nextDouble() + random.nextDouble(), (double)p_220098_1_.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
//	      if (p_220098_3_) {
//	         p_220098_0_.addParticle(ParticleTypes.SMOKE, (double)p_220098_1_.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)p_220098_1_.getY() + 0.4D, (double)p_220098_1_.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
//	      }
//
//	 }

}
