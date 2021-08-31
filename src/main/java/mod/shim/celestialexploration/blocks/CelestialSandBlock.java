package mod.shim.celestialexploration.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CelestialSandBlock extends SandBlock {
	private final int dustColor;

	public CelestialSandBlock(int p_i48338_1_, AbstractBlock.Properties p_i48338_2_) {
		super(p_i48338_1_, p_i48338_2_);
		this.dustColor = p_i48338_1_;
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState p_189876_1_, IBlockReader p_189876_2_, BlockPos p_189876_3_) {
		return this.dustColor;
	}
}