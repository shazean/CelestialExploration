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

public class TinyCraterFeature extends Feature<NoFeatureConfig> {
	
	private static final BlockState MARS_ROCK = RegistryBlocks.MARS_STONE.get().defaultBlockState();

	public TinyCraterFeature(Codec<NoFeatureConfig> codec) {
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
		pos = pos.below();
		
		
		setBlock(reader, pos.above(), Blocks.AIR.defaultBlockState());
		setBlock(reader, pos, Blocks.AIR.defaultBlockState());
		
		pos = pos.above();
		BlockPos tempPos = pos;
		
		setBlock(reader, tempPos.west(), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.west(2), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.west().north(), Blocks.AIR.defaultBlockState());

		tempPos = pos;
		setBlock(reader, tempPos.east(), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.east(2), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.east().south(), Blocks.AIR.defaultBlockState());

		tempPos = pos;
		setBlock(reader, tempPos.north(), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.north(2), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.north().east(), Blocks.AIR.defaultBlockState());

		tempPos = pos;
		setBlock(reader, tempPos.south(), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.south(2), Blocks.AIR.defaultBlockState());
		setBlock(reader, tempPos.south().west(), Blocks.AIR.defaultBlockState());
		
		return false;
	}

}