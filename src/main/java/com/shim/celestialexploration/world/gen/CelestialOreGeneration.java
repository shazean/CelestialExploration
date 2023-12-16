package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.registry.PlacedFeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class CelestialOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        //MOON
        base.add(PlacedFeatureRegistry.MOON_IRON_ORE_PLACED);
        base.add(PlacedFeatureRegistry.MOON_REDSTONE_ORE_PLACED);

        //MARS
        base.add(PlacedFeatureRegistry.MARS_IRON_ORE_PLACED);
        base.add(PlacedFeatureRegistry.MARS_REDSTONE_ORE_PLACED);

        base.add(PlacedFeatureRegistry.VENUS_IRON_ORE_PLACED);
        base.add(PlacedFeatureRegistry.VENUS_REDSTONE_ORE_PLACED);
        base.add(PlacedFeatureRegistry.VENUS_LAPIS_ORE_PLACED);

        //METEOR
//        base.add(PlacedFeatureRegistry.METEOR_COAL_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_COPPER_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_DIAMOND_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_EMERALD_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_GOLD_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_IRON_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_LAPIS_ORE_PLACED);
//        base.add(PlacedFeatureRegistry.METEOR_REDSTONE_ORE_PLACED);
    }
}