package com.shim.celestialexploration.world.features;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;

import java.util.Random;

public class AsteroidOres {
    private static final SimpleWeightedRandomList.Builder<AsteroidOre> ORES = SimpleWeightedRandomList.builder();

    public static void addOre(Block ore, int weight, float frequency) {
        ORES.add(new AsteroidOre(ore, frequency), weight);
    }

    public static AsteroidOre chooseRandomMeteorOre(Random random) {
        AsteroidOre ore = ORES.build().getRandomValue(random).orElse(new AsteroidOre(CelestialBlocks.METEOR.get(), 1.0F));
        CelestialExploration.LOGGER.debug("random meteor ore, returning: " + ore.block());
        return ore;
    }

    public static boolean shouldUseOre(AsteroidOre ore, Random random) {
        return random.nextDouble() < ore.frequency();
    }

    public record AsteroidOre(Block block, float frequency) {}
}