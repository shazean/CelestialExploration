package com.shim.celestialexploration.world.gen;

import com.shim.celestialexploration.world.features.placement.CelestialFeaturePlacements;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class CelestialOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

//        //MOON
//        base.add(PlacedFeatureRegistry.MOON_IRON_ORE);
//        base.add(PlacedFeatureRegistry.MOON_REDSTONE_ORE);
//        base.add(PlacedFeatureRegistry.MOON_BAUXITE_ORE);
//
//        //MARS
//        base.add(PlacedFeatureRegistry.MARS_IRON_ORE);
//        base.add(PlacedFeatureRegistry.MARS_REDSTONE_ORE);
//        base.add(PlacedFeatureRegistry.MARS_BAUXITE_ORE);
//
//        //VENUS
//        base.add(PlacedFeatureRegistry.VENUS_IRON_ORE);
//        base.add(PlacedFeatureRegistry.VENUS_REDSTONE_ORE);
//        base.add(PlacedFeatureRegistry.VENUS_LAPIS_ORE);
//        base.add(PlacedFeatureRegistry.VENUS_BAUXITE_ORE);
//
        base.add(CelestialFeaturePlacements.BAUXITE_ORE);
//
//        //METEOR
////        base.add(PlacedFeatureRegistry.METEOR_COAL_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_COPPER_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_DIAMOND_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_EMERALD_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_GOLD_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_IRON_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_LAPIS_ORE);
////        base.add(PlacedFeatureRegistry.METEOR_REDSTONE_ORE);
//
//        //MERCURY
//        base.add(PlacedFeatureRegistry.MERCURY_IRON_ORE);
//        base.add(PlacedFeatureRegistry.MERCURY_REDSTONE_ORE);
//        base.add(PlacedFeatureRegistry.MERCURY_SULFUR_ORE);
//        base.add(PlacedFeatureRegistry.MERCURY_COAL_ORE);
//        base.add(PlacedFeatureRegistry.MERCURY_BAUXITE_ORE);
    }
}