package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBiomes;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialNoises;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import com.shim.celestiallib.api.datagen.DimensionGenProvider;
import com.shim.celestiallib.data.gen.DimensionGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialDimensionGen extends DimensionGenProvider {
    public CelestialDimensionGen(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<DimensionGen> consumer, ExistingFileHelper fileHelper) {

        DimensionGen.builder().typeAndSettings(CelestialDimensions.MOON).preset(CelestialDimensions.MOON).useForgeSeed().save(consumer, CelestialDimensions.MOON);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.MARS).preset(CelestialDimensions.MARS).useForgeSeed().save(consumer, CelestialDimensions.MARS);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.VENUS).preset(CelestialDimensions.VENUS).useForgeSeed().save(consumer, CelestialDimensions.VENUS);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.MERCURY).preset(CelestialDimensions.MERCURY).useForgeSeed().save(consumer, CelestialDimensions.MERCURY);

        DimensionGen.builder().type(CelestialDimensions.MILKY_WAY).settings(CelestialDimensions.MILKY_WAY).presetOrFixedBiome(null, CelestialBiomeKeys.MILKY_WAY).save(consumer, CelestialDimensions.MILKY_WAY);

        DimensionGen.builder().typeAndSettings(CelestialDimensions.JUPITER).preset(CelestialDimensions.JUPITER).useForgeSeed().save(consumer, CelestialDimensions.JUPITER);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.EUROPA).preset(CelestialDimensions.EUROPA).useForgeSeed().save(consumer, CelestialDimensions.EUROPA);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.CALLISTO).preset(CelestialDimensions.CALLISTO).useForgeSeed().save(consumer, CelestialDimensions.CALLISTO);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.IO).preset(CelestialDimensions.IO).useForgeSeed().save(consumer, CelestialDimensions.IO);
        DimensionGen.builder().typeAndSettings(CelestialDimensions.GANYMEDE).preset(CelestialDimensions.GANYMEDE).useForgeSeed().save(consumer, CelestialDimensions.GANYMEDE);


    }
}
