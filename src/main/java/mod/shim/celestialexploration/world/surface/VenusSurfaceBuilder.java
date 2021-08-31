package mod.shim.celestialexploration.world.surface;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class VenusSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public static final BlockState VENUS_STONE = RegistryBlocks.VENUS_STONE.get().defaultBlockState();
	public static final BlockState VENUS_SAND = RegistryBlocks.VENUS_SAND.get().defaultBlockState();
	public static final BlockState VENUS_GEYSER = RegistryBlocks.GEYSER.get().defaultBlockState();
	
	public static final SurfaceBuilderConfig VENUS_STONE_CONFIG = new SurfaceBuilderConfig(VENUS_STONE, VENUS_STONE, VENUS_STONE);
	public static final SurfaceBuilderConfig VENUS_SAND_CONFIG = new SurfaceBuilderConfig(VENUS_SAND, VENUS_STONE, VENUS_STONE);
	public static final SurfaceBuilderConfig VENUS_GEYSER_CONFIG = new SurfaceBuilderConfig(VENUS_GEYSER, VENUS_STONE, VENUS_GEYSER);
	
	
	public VenusSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232136_1_) {
		super(p_i232136_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z,
			int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel,
			long seed, SurfaceBuilderConfig config) {
		// TODO Auto-generated method stub
		
		int rand = random.nextInt(2000);
		
		if (rand == 0) {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_GEYSER_CONFIG);
			
		}
		else {
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_SAND_CONFIG);
			
		}
		
		
		
	}

	
	
	
}
