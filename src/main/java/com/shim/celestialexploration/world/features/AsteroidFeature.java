package com.shim.celestialexploration.world.features;

import com.mojang.serialization.Codec;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.util.CelestialUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class AsteroidFeature extends Feature<NoneFeatureConfiguration> {
//    final int lowerSize;
//    final int upperSize;
    BlockState alternateMeteorBlock;
    private static final BlockState METEOR = CelestialBlocks.METEOR.get().defaultBlockState();

    public AsteroidFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
//        this.lowerSize = lowerSize;
//        this.upperSize = upperSize;
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

    private int chooseSize(Random random) {

        SimpleWeightedRandomList<Integer> randomSize = SimpleWeightedRandomList.<Integer>builder()
                .add(1, 32)
                .add(2, 30)
                .add(3, 28)
                .add(4, 26)
                .add(5, 22)
                .add(6, 18)
                .add(8, 14)
                .add(10, 9)
                .add(13, 5)
                .add(16, 1)
                .build();

        return randomSize.getRandomValue(random).orElse(8);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();

        if (!level.getBlockState(pos).isAir())
            return false;

        ChunkPos chunkpos = new ChunkPos(pos);
        boolean asteroidBelt = true;
        boolean kuiperBelt = true;

        //TODO - Oort cloud

        //ASTEROID BELT
        //Not inside of large circle
        if (!CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(4.5), chunkpos.x, chunkpos.z)) {
            asteroidBelt = false;
        }

        //only check if we didn't eliminate the asteroid belt in the previous step
        //eliminate the inner circle
        if (asteroidBelt && CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(4.2), chunkpos.x, chunkpos.z)) {
            asteroidBelt = false;
        }

        //KUIPER BELT
        //Not inside of large circle
        if (!CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(28.0), chunkpos.x, chunkpos.z)) {
            kuiperBelt = false;
        }

        //only check if we didn't eliminate the kuiper belt in the previous step
        //eliminate the inner circle
        if (kuiperBelt && CelestialUtil.isPointInCircle(0, 0, CelestialUtil.getCalculatedCircleRadius(26.5), chunkpos.x, chunkpos.z)) {
            kuiperBelt = false;
        }

        if (!asteroidBelt && !kuiperBelt)
            return false;

        int radius = chooseSize(context.random());
        this.alternateMeteorBlock = this.chooseRandomMeteorOre();

//        int radius = Mth.clamp(context.random().nextInt(this.upperSize - this.lowerSize) + this.lowerSize, 5, 16);
        int x;
        int y;
        int z;
        int point;
        int radiusSq = radius * radius;

        for (int row = 0; row < radius * 2 + 1; row++) {
            for (int col = 0; col < radius * 2 + 1; col++) {
                for (int height = 0; height < radius * 2 + 1; height++) {
                    x = radius - row;
                    y = radius - height;
                    z = radius - col;

                    point = x * x + z * z + y * y;

                    if (point <= radiusSq + 1) {
                        if (context.random().nextInt(20) == 0)
                            level.setBlock(pos.offset(x, y - radius - 1, z), this.alternateMeteorBlock, 2);
                        else {
                            if (!(context.random().nextInt(25) == 0))
                                level.setBlock(pos.offset(x, y - radius - 1, z), METEOR, 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}