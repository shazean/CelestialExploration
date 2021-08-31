package mod.shim.celestialexploration.blocks;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryTileEntity;
import mod.shim.celestialexploration.tileentity.OxygenCompressorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class OxygenCompressorBlock extends Block {

	public static final BooleanProperty POWERED = RedstoneTorchBlock.LIT;


	public OxygenCompressorBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		// TODO Auto-generated method stub
		return RegistryTileEntity.OXYGEN_COMPRESSOR_TILE_ENTITY_TYPE.get().create();
	}

	//	@Override
	//	public ActionResultType onBlockActivate(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	//		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	//	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos,
			PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		// TODO Auto-generated method stub
		if (!worldIn.isClientSide) {
			TileEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof OxygenCompressorTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (OxygenCompressorTileEntity) tileentity, pos);
			}
		}
		return super.use(state, worldIn, pos, player, handIn, hit);
	}

	public void neighborChanged(BlockState p_220069_1_, World p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
		if (!p_220069_2_.isClientSide) {
			boolean flag = p_220069_1_.getValue(POWERED);
			if (flag != p_220069_2_.hasNeighborSignal(p_220069_3_)) {
				if (flag) {
					p_220069_2_.getBlockTicks().scheduleTick(p_220069_3_, this, 4);
				} else {
					p_220069_2_.setBlock(p_220069_3_, p_220069_1_.cycle(POWERED), 2);
				}
			}

		}
	}

	public void tick(BlockState p_225534_1_, ServerWorld p_225534_2_, BlockPos p_225534_3_, Random p_225534_4_) {
		if (p_225534_1_.getValue(POWERED) && !p_225534_2_.hasNeighborSignal(p_225534_3_)) {
			p_225534_2_.setBlock(p_225534_3_, p_225534_1_.cycle(POWERED), 2);

			OxygenCompressorTileEntity.setLit(true);

		}

	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
		p_206840_1_.add(POWERED);
	}

}
