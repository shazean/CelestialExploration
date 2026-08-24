package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.util.AsteroidOreBuilder;
import com.shim.celestialexploration.datagen.util.AsteroidOreProvider;
import com.shim.celestialexploration.registry.CelestialBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class AsteroidOreGen extends AsteroidOreProvider {
    public AsteroidOreGen(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<AsteroidOreBuilder> consumer, ExistingFileHelper fileHelper) {

        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR.get()).weight(150).frequency(0.9F).save(consumer, modLoc("meteor"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_COAL_ORE.get()).weight(100).frequency(0.8F).save(consumer, modLoc("coal"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_BAUXITE_ORE.get()).weight(80).frequency(0.5F).save(consumer, modLoc("bauxite"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_COPPER_ORE.get()).weight(60).frequency(0.5F).save(consumer, modLoc("copper"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_IRON_ORE.get()).weight(50).frequency(0.5F).save(consumer, modLoc("iron"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_REDSTONE_ORE.get()).weight(20).frequency(0.3F).save(consumer, modLoc("redstone"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_SULFUR_ORE.get()).weight(15).frequency(0.2F).save(consumer, modLoc("sulfur"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_LAPIS_ORE.get()).weight(10).frequency(0.2F).save(consumer, modLoc("lapis"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_GOLD_ORE.get()).weight(10).frequency(0.2F).save(consumer, modLoc("gold"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_EMERALD_ORE.get()).weight(2).frequency(0.1F).save(consumer, modLoc("emerald"));
        AsteroidOreBuilder.builder().ore(CelestialBlocks.METEOR_DIAMOND_ORE.get()).weight(1).frequency(0.1F).save(consumer, modLoc("diamond"));

    }

    private ResourceLocation modLoc(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc);
    }

}
