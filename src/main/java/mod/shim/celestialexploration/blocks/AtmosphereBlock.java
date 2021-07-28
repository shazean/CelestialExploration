package mod.shim.celestialexploration.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class AtmosphereBlock extends AbstractAtmosphereBlock {
	   public AtmosphereBlock(AbstractBlock.Properties p_i48296_1_) {
		      super(p_i48296_1_);
		   }

		   public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
		      p_196262_4_.makeStuckInBlock(p_196262_1_, new Vector3d(0.9D, (double)0.9F, 0.9D));
		   }
		}
