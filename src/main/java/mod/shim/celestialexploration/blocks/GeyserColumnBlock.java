package mod.shim.celestialexploration.blocks;

import java.util.Random;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import mod.shim.celestialexploration.registry.RegistryFluids;
import mod.shim.celestialexploration.registry.RegistryTileEntity;
import mod.shim.celestialexploration.tileentity.GeyserTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.fluid.Fluid;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GeyserColumnBlock extends Block implements IBucketPickupHandler {
//	   public static final BooleanProperty DRAG_DOWN = BlockStateProperties.DRAG;
	   public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");


	   public GeyserColumnBlock(AbstractBlock.Properties p_i48783_1_) {
	      super(p_i48783_1_);
//	      this.registerDefaultState(this.stateDefinition.any().setValue(DRAG_DOWN, Boolean.valueOf(true)));
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

	   

	   public void onPlace(BlockState p_220082_1_, World world, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
			   growColumn(world, p_220082_3_.above(), true);
	   }

	   public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
		   
		   
			   growColumn(world, pos.above(), true);
	   }

	   public static void growColumn(IWorld world, BlockPos pos, boolean p_203159_2_) {
		   BlockState blockstate = world.getBlockState(pos);
		   Random random = world.getRandom();
		   int rand = random.nextInt(15);
		   
		   
		   
			if (!world.isClientSide()) {
				TileEntity tileentity = world.getBlockEntity(pos);
				if (tileentity instanceof GeyserTileEntity) {
					tileentity.load(blockstate, tileentity.getTileData());
					

				}
			}

		   
			   if (blockstate.canSurvive(world, pos)) {
				   world.setBlock(pos, RegistryBlocks.GEYSER_COLUMN.get().defaultBlockState(), 2);
			   }
			   if (!blockstate.canSurvive(world, pos)) {
				   for (int i = 0; i < 15; i++) {
					   world.removeBlock(pos, p_203159_2_);
					   pos = pos.above();
				   }
			   }
		   

	   }
	   
	 
	   
	   public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
	      if (p_196271_1_.canSurvive(p_196271_4_, p_196271_5_)) {
//	         return Blocks.WATER.defaultBlockState();
	    	  return RegistryBlocks.SULFUR_BLOCK.get().defaultBlockState();
	      }
//	      } else {
//	         if (p_196271_2_ == Direction.DOWN) {
//	            p_196271_4_.setBlock(p_196271_5_, RegistryBlocks.GEYSER_COLUMN.get().defaultBlockState().setValue(DRAG_DOWN, Boolean.valueOf(getDrag(p_196271_4_, p_196271_6_))), 2);
//	         } else if (p_196271_2_ == Direction.UP && !p_196271_3_.is(RegistryBlocks.GEYSER_COLUMN.get())) {
//	            p_196271_4_.getBlockTicks().scheduleTick(p_196271_5_, this, 5);
//	         }
//
//	         p_196271_4_.getLiquidTicks().scheduleTick(p_196271_5_, RegistryFluids.SULFUR.get(), RegistryFluids.SULFUR.get().getTickDelay(p_196271_4_));
	         return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
//	      }
	   }
	   
//	   public boolean geyserToggleOn() {
//		   Random random = new Random();
//		   int rand = random.nextInt(4);
//		   
//		   if (rand >= 2) {
//			   return true;
//		   }
//		   
//		   return false;
//	   }
	   

	   public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos pos) {
		   
//		   if (!geyserToggleOn()) {
//			   System.out.println("GeyserColumnBlock canSurviva geyserToggleOn(): " + geyserToggleOn());
//			   return false;
//		   } else {
		   
		   
	      BlockState blockstate = p_196260_2_.getBlockState(pos.below());
	      Boolean geyserInRange = false;
	      
	      Random random = new Random();
	      int rand = random.nextInt(15);
	      
	      for (int i = 0; i < (rand + 5); i++) {
	    	  blockstate = p_196260_2_.getBlockState(pos.below(i));
	    	  if (blockstate.is(RegistryBlocks.GEYSER.get())) {
	    		  geyserInRange = true;
	    	  }
	      }
	      
//	      if (((rand + 5) / 2 ) < 5) {
//	    	  return false;
//	      }
//	      
//    	  System.out.println("GeyserColumn canSurvive geyserInRange: " + geyserInRange);

	      return geyserInRange;
//		   }
//	      return blockstate.is(RegistryBlocks.GEYSER_COLUMN.get()) || blockstate.is(RegistryBlocks.GEYSER.get());
	   }

	   public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
	      return VoxelShapes.empty();
	   }

	   public BlockRenderType getRenderShape(BlockState p_149645_1_) {
	      return BlockRenderType.INVISIBLE;
	   }

	   protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
//	      p_206840_1_.add(DRAG_DOWN);
	   }

	   public Fluid takeLiquid(IWorld p_204508_1_, BlockPos p_204508_2_, BlockState p_204508_3_) {
	      p_204508_1_.setBlock(p_204508_2_, Blocks.AIR.defaultBlockState(), 6); //11
	      return RegistryFluids.SULFUR.get();
	   }
	}