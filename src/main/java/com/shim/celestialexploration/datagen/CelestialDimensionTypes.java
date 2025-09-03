package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestiallib.api.datagen.DimensionTypeGenProvider;
import com.shim.celestiallib.data.gen.DimensionTypeGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialDimensionTypes extends DimensionTypeGenProvider {
    public CelestialDimensionTypes(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<DimensionTypeGen> consumer, ExistingFileHelper fileHelper) {

        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(12F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.MOON.location())
                .height(256, 256, -32).save(consumer, CelestialDimensions.MOON);

        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(3F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.MARS.location())
                .height(384, 384, -64).save(consumer, CelestialDimensions.MARS);


        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0.2F).coordinateScale(0.25F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.MILKY_WAY.location())
                .height(384, 384, -128).save(consumer, CelestialDimensions.MILKY_WAY);


        DimensionTypeGen.builder().ultrawarm(true).natural(false).mobs(true, true).respawn(true, false)
                .sky(true, false, 0.2F).coordinateScale(1.5F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.VENUS.location()).fixedTime(18000)
                .height(384, 384, -64).save(consumer, CelestialDimensions.VENUS);


        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(10).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.MERCURY.location())
                .height(256, 256, -32).save(consumer, CelestialDimensions.MERCURY);


        DimensionTypeGen.builder().ultrawarm(false).natural(false).mobs(true, true).respawn(false, false)
                .sky(true, false, 0F).coordinateScale(.25F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.JUPITER.location())
                .height(512, 512, -96).save(consumer, CelestialDimensions.JUPITER);


        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(14F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.EUROPA.location())
                .height(256, 256, -96).save(consumer, CelestialDimensions.EUROPA);


        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(12F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.IO.location())
                .height(256, 256, -32).save(consumer, CelestialDimensions.IO);


        DimensionTypeGen.builder().ultrawarm(true).natural(false).mobs(true, true).respawn(false, true)
                .sky(true, false, 0F).coordinateScale(12F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.CALLISTO.location())
                .height(256, 256, -32).save(consumer, CelestialDimensions.CALLISTO);


        DimensionTypeGen.builder().ultrawarm(false).natural(true).mobs(true, false).respawn(true, false)
                .sky(true, false, 0F).coordinateScale(10F).infiniburn(BlockTags.INFINIBURN_OVERWORLD)
                .effects(CelestialDimensions.GANYMEDE.location())
                .height(256, 256, -32).save(consumer, CelestialDimensions.GANYMEDE);


    }
}
