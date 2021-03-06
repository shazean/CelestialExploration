package mod.shim.celestialexploration.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AbstractAtmosphereBlock extends BreakableBlock {
	protected AbstractAtmosphereBlock(AbstractBlock.Properties p_i49999_1_) {
		super(p_i49999_1_);
	}

	public VoxelShape getVisualShape(BlockState p_230322_1_, IBlockReader p_230322_2_, BlockPos p_230322_3_, ISelectionContext p_230322_4_) {
		return VoxelShapes.empty();
	}

	@OnlyIn(Dist.CLIENT)
	public float getShadeBrightness(BlockState p_220080_1_, IBlockReader p_220080_2_, BlockPos p_220080_3_) {
		return 0.3F;
	}

	public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
		return true;
	}

	//Makes completely invisible
	//	   @Override
	//	   public BlockRenderType getRenderShape(BlockState p_149645_1_) {
	//		      return BlockRenderType.INVISIBLE;
	//		   }


}

