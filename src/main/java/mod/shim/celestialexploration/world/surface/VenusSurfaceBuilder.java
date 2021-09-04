package mod.shim.celestialexploration.world.surface;

import java.util.Collections;
import java.util.Random;

import com.mojang.serialization.Codec;

import mod.shim.celestialexploration.registry.RegistryBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class VenusSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public static final BlockState VENUS_STONE = RegistryBlocks.VENUS_STONE.get().defaultBlockState();
	public static final BlockState VENUS_SAND = RegistryBlocks.VENUS_SAND.get().defaultBlockState();
	public static final BlockState VENUS_GEYSER = RegistryBlocks.GEYSER.get().defaultBlockState();
	
	public static final SurfaceBuilderConfig VENUS_STONE_CONFIG = new SurfaceBuilderConfig(VENUS_STONE, VENUS_STONE, VENUS_STONE);
	public static final SurfaceBuilderConfig VENUS_SAND_CONFIG = new SurfaceBuilderConfig(VENUS_SAND, VENUS_STONE, VENUS_STONE);
	public static final SurfaceBuilderConfig VENUS_GEYSER_CONFIG = new SurfaceBuilderConfig(VENUS_GEYSER, VENUS_STONE, VENUS_GEYSER);
	
	public static final PerlinNoiseGenerator perlinNoiseGenerator = new PerlinNoiseGenerator(new SharedSeedRandom(358L), Collections.singletonList(4));
    public static final PerlinNoiseGenerator secondPerlinNoiseGenerator = new PerlinNoiseGenerator(new SharedSeedRandom(1823L), Collections.singletonList(4));
    public static final PerlinNoiseGenerator thirdPerlinNoiseGenerator = new PerlinNoiseGenerator(new SharedSeedRandom(212L), Collections.singletonList(3));
	
	
	public VenusSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232136_1_) {
		super(p_i232136_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
//		//temp surface builder, testing how perlin noise gen works
		if (thirdPerlinNoiseGenerator.getValue(x/100.0f, z/100.0f, false) > 0.6f)
        {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_STONE_CONFIG);
        }
        else if (noise > -1.8f && noise < 1.8f) {
            if (secondPerlinNoiseGenerator.getValue(x/300.0f, z/300.0f, false) > 0.0f)
                SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_SAND_CONFIG);
            else
                SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_SAND_CONFIG);
        } else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_SAND_CONFIG);
        }

        if (perlinNoiseGenerator.getValue(x/100.0f, z/100.0f, false) > 0.3f)
        {
            if (startHeight <= 64)
            {
                chunkIn.setBlockState(new BlockPos(x, 64, z), Blocks.AIR.defaultBlockState(), false);
                chunkIn.setBlockState(new BlockPos(x, 63, z), Blocks.AIR.defaultBlockState(), false);
                chunkIn.setBlockState(new BlockPos(x, 62, z), RegistryBlocks.SULFUR_BLOCK.get().defaultBlockState(), false);
            }
        }
		
		
		
		//FIXME applies geysers
//		int rand = random.nextInt(2000);
//		
//		if (rand == 0) {
//			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_GEYSER_CONFIG);
//			
//		}
//		else {
//			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, VENUS_SAND_CONFIG);
//			
//		}
		
		
		
	}

	
	
	
}
