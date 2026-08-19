package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class CraterFeature extends Feature<NoneFeatureConfiguration> {
    final int lowerSize;
    final int upperSize;
    final boolean shouldSpawnMeteorite;
    AsteroidOres.AsteroidOre alternateMeteorBlock;
    private static final BlockState METEOR = CelestialBlocks.METEOR.get().defaultBlockState();
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();

    public CraterFeature(Codec<NoneFeatureConfiguration> codec, int lowerSize, int upperSize, boolean shouldSpawnMeteorite) {
        super(codec);
        this.lowerSize = lowerSize;
        this.upperSize = upperSize;
        this.shouldSpawnMeteorite = shouldSpawnMeteorite;
    }

    private BlockState chooseRandomMeteorOre() {

        SimpleWeightedRandomList<Block> randomMeteor = SimpleWeightedRandomList.<Block>builder()
                .add(CelestialBlocks.METEOR.get(), 10)
                .add(CelestialBlocks.METEOR_COAL_ORE.get(), 20)
                .add(CelestialBlocks.METEOR_IRON_ORE.get(), 15)
                .add(CelestialBlocks.METEOR_COPPER_ORE.get(), 15)
                .add(CelestialBlocks.METEOR_REDSTONE_ORE.get(), 15)
                .add(CelestialBlocks.METEOR_BAUXITE_ORE.get(), 15)
                .add(CelestialBlocks.METEOR_SULFUR_ORE.get(), 8)
                .add(CelestialBlocks.METEOR_LAPIS_ORE.get(), 4)
                .add(CelestialBlocks.METEOR_GOLD_ORE.get(), 3)
                .add(CelestialBlocks.METEOR_EMERALD_ORE.get(), 2)
                .add(CelestialBlocks.METEOR_DIAMOND_ORE.get(), 1).build();

        return randomMeteor.getRandomValue(new Random()).orElseGet(CelestialBlocks.METEOR).defaultBlockState();
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        int radius = Mth.clamp(context.random().nextInt(this.upperSize - this.lowerSize) + this.lowerSize, 5, 16);
        int x;
        int y;
        int z;
        int point;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        int radiusSq = radius * radius;

        if (this.shouldSpawnMeteorite)
            this.alternateMeteorBlock = AsteroidOres.chooseRandomMeteorOre(context.random());

        if (level.getFluidState(pos).is(Fluids.WATER))
            return false;

        for (int row = 0; row < radius * 2 + 1; row++) {
            for (int col = 0; col < radius * 2 + 1; col++) {
                for (int height = 0; height < radius * 2 + 1; height++) {
                    x = radius - row;
                    y = radius - height;
                    z = radius - col;

                    point = x * x + z * z + y * y;

                    if (point <= radiusSq + 1) {
                        level.setBlock(pos.offset(x, -y, z), AIR, 2);
                    }
                }
            }
        }

        if (this.shouldSpawnMeteorite) {
            int meteorRadius = (radius / 6) + 1;
            if (((float) radius / 6.0F) < 1.0) {
                level.setBlock(pos.offset(0, -radius - 1, 0), METEOR, 2);
            } else {
                int meteorRadiusSQ = meteorRadius * meteorRadius;

                for (int row = 0; row < meteorRadius * 2 + 1; row++) {
                    for (int col = 0; col < meteorRadius * 2 + 1; col++) {
                        for (int height = 0; height < meteorRadius; height++) {
                            x = meteorRadius - row;
                            y = meteorRadius - height;
                            z = meteorRadius - col;
                            point = x * x + y * y + z * z;

                            if (point <= meteorRadiusSQ + 1) {
                                if (context.random().nextDouble() <= 0.25 //meteor will always be at least 75% meteor block
                                        && AsteroidOres.shouldUseOre(this.alternateMeteorBlock, context.random())) { //spawn ore block only as often as dictated by type of ore

                                    level.setBlock(pos.offset(x, y - radius - 1, z), this.alternateMeteorBlock.block().defaultBlockState(), 2);
                                } else {
                                    if (!(context.random().nextDouble() <= .25)) //chance of spawning nothing, i.e. leaving air
                                        level.setBlock(pos.offset(x, y - radius - 1, z), METEOR, 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        CelestialExploration.LOGGER.debug("spawning crater at: " + pos);

        return true;
    }
}