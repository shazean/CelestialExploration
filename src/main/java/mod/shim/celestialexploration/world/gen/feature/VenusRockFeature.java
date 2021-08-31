package mod.shim.celestialexploration.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class VenusRockFeature extends Feature<NoFeatureConfig> {
	
	private static final BlockState VENUS_ROCK = RegistryBlocks.VENUS_STONE.get().defaultBlockState();

	public VenusRockFeature(Codec<NoFeatureConfig> codec) {
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
		
		for (int i = 0; i < rand.nextInt(4); i++) 
			setBlock(reader, pos.above(i), VENUS_ROCK);
//		setBlockState(reader, pos.down(1), STONE);

		return false;
	}

}