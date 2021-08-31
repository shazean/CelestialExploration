package mod.shim.celestialexploration.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MarsRockFeature extends Feature<NoFeatureConfig> {
	
	private static final BlockState MARS_ROCK = RegistryBlocks.MARS_STONE.get().defaultBlockState();

	public MarsRockFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@SuppressWarnings("deprecation")
	public boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos) {
		if (!(reader instanceof IWorldReader)) {
			return reader.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES));
		} else {
			return reader.isStateAtPosition(pos, state -> state.canBeReplacedByLeaves((IWorldReader) reader, pos));
		}
	}

	@Override
	public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos,
			NoFeatureConfig config) {

		while (pos.getY() > 1 && isAirOrLeaves(reader, pos)) {
			pos = pos.below();
		}
		pos = pos.above();
		
		int height = rand.nextInt(3) + 1;
		int addon = rand.nextInt(8);
		
		for (int i = 0; i < height; i++) 
			setBlock(reader, pos.above(i), MARS_ROCK);
//		setBlockState(reader, pos.down(1), STONE);
		
		switch(addon) {
		
		case 0: 
			break;
			
		case 1: 
			setBlock(reader, pos.west(), MARS_ROCK);
			
		case 2:
			break;

		case 3:
			setBlock(reader, pos.north(), MARS_ROCK);
			
		case 4:
			break;
			
		case 5:
			setBlock(reader, pos.east(), MARS_ROCK);
			
		case 6:
			break;
			
		case 7:
			setBlock(reader, pos.south(), MARS_ROCK);
		
		default: 
			break;
		
		}
		

		return false;
	}

}