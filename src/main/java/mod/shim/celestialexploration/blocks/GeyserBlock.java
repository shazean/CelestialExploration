package mod.shim.celestialexploration.blocks;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryTileEntity;
import mod.shim.celestialexploration.tileentity.GeyserTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
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

	Boolean geyserToggle = true;

	public GeyserBlock(AbstractBlock.Properties p_i48366_1_) {
		super(p_i48366_1_);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		// TODO Auto-generated method stub
		return RegistryTileEntity.GEYSER_TILE_ENTITY_TYPE.get().create();
	}

	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
		return new GeyserTileEntity();
	}


	public void tick(BlockState blockstate, ServerWorld serverWorld, BlockPos pos, Random random) {

		//		System.out.println("GeyserBlock tick");

		if (!serverWorld.isClientSide()) {
			TileEntity tileentity = serverWorld.getBlockEntity(pos);
			if (tileentity instanceof GeyserTileEntity) {

				GeyserTileEntity geysertileentity = (GeyserTileEntity) tileentity;
				int counterTimer = geysertileentity.getCounterTime();
				if (counterTimer <= 2) {
					this.geyserToggle = !this.geyserToggle;
				}

				if (this.geyserToggle) {
					GeyserColumnBlock.growColumn(serverWorld, pos.above(), true);

				}
				if (!this.geyserToggle) {
					GeyserColumnBlock.removeColumn(serverWorld, pos.above(), true);
				}


			} 
		}

		serverWorld.addAlwaysVisibleParticle(ParticleTypes.ASH, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);

		serverWorld.addParticle(ParticleTypes.DRIPPING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
		serverWorld.addParticle(ParticleTypes.FALLING_LAVA, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);


	}


	public boolean isRandomlyTicking(BlockState blockstate) {
		return true;
	}

	//	public void randomTick(BlockState blockstate, ServerWorld serverWorld, BlockPos pos, Random random) {
	//			
	//		   this.tick(blockstate, serverWorld, pos, random);
	//	   }


	@Override
	public void animateTick(BlockState p_180655_1_, World world, BlockPos p_180655_3_, Random p_180655_4_) {
		if (geyserToggle) {
			double d0 = (double)p_180655_3_.getX() + 0.5D + (p_180655_4_.nextDouble() - 0.5D) * 0.2D;
			double d1 = (double)p_180655_3_.getY() + 0.7D + (p_180655_4_.nextDouble() - 0.5D) * 0.2D;
			double d2 = (double)p_180655_3_.getZ() + 0.5D + (p_180655_4_.nextDouble() - 0.5D) * 0.2D;
			world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
		if (!geyserToggle) {
			world.addParticle(ParticleTypes.LAVA, explosionResistance, explosionResistance, speedFactor, jumpFactor, friction, explosionResistance);
		}
	}


	public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld iworld, BlockPos p_196271_5_, BlockPos p_196271_6_) {
		//	      if (p_196271_2_ == Direction.UP && p_196271_3_.is(Blocks.WATER)) {
		iworld.getBlockTicks().scheduleTick(p_196271_5_, this, 50);
		//	         iworld.getBlockTicks().willTickThisTick(p_196271_6_, this);
		//	      }

		return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, iworld, p_196271_5_, p_196271_6_);
	}


	public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
		p_220082_2_.getBlockTicks().scheduleTick(p_220082_3_, this, 20);
	}


}
