package mod.shim.celestialexploration.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class AsteroidFeature extends Feature<NoFeatureConfig> {

	public AsteroidFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
		// TODO Auto-generated constructor stub
	}
	
	private static final BlockState METEOR = RegistryBlocks.METEOR.get().defaultBlockState();
	private static final BlockState EMERALD = RegistryBlocks.METEOR_EMERALD_ORE.get().defaultBlockState();
	private static final BlockState DIAMOND = RegistryBlocks.METEOR_DIAMOND_ORE.get().defaultBlockState();
	private static final BlockState REDSTONE = RegistryBlocks.METEOR_REDSTONE_ORE.get().defaultBlockState();
	private static final BlockState COAL = RegistryBlocks.METEOR_COAL_ORE.get().defaultBlockState();
	private static final BlockState LAPIS_LAZULI = RegistryBlocks.METEOR_LAPIS_ORE.get().defaultBlockState();
	private static final BlockState IRON = RegistryBlocks.METEOR_IRON_ORE.get().defaultBlockState();
	private static final BlockState GOLD = RegistryBlocks.METEOR_GOLD_ORE.get().defaultBlockState();

	
	private BlockState oreType(int num) {
		
		switch(num) {
		
		case 1:
			return METEOR;
			
		case 2:
			return DIAMOND;
			
		case 3:
			return REDSTONE;
			
		case 4:
			return COAL;
		
		case 5:
			return LAPIS_LAZULI;
			
		case 6:
			return IRON;
			
		case 7:
			return GOLD;
			
		case 8:
			return METEOR;
			
		default:
			return METEOR;
		
		}
		
	}

	@Override
	public boolean place(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos pos,
			NoFeatureConfig p_241855_5_) {
		      float f = (float)(p_241855_3_.nextInt(3) + 4);

		      for(int i = 0; f > 0.5F; --i) {
		         for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
		            for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
		               if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
		                  this.setBlock(p_241855_1_, pos.offset(j, i, k), METEOR);
		               }
		            }
		         }

		         f = (float)((double)f - ((double)p_241855_3_.nextInt(2) + 0.5D));
		      }
		      
		      this.setBlock(p_241855_1_, pos, COAL);
		      

		      return true;
	}
	


}
