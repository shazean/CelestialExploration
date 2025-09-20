package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestiallib.api.datagen.PlanetDataProvider;
import com.shim.celestiallib.api.effects.CLibEffects;
import com.shim.celestiallib.data.gen.PlanetData;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialPlanetData extends PlanetDataProvider {
    public CelestialPlanetData(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<PlanetData> consumer, ExistingFileHelper fileHelper) {

        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).save(consumer, CelestialDimensions.MOON);

        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).lightSpeedLocked(true, false, modLoc("enter_mars")).save(consumer, CelestialDimensions.MARS);
        PlanetData.builder().lightSpeedLocked(true, false, modLoc("enter_venus")).save(consumer, CelestialDimensions.VENUS);
        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).lightSpeedLocked(true, false,modLoc("enter_mercury")).save(consumer, CelestialDimensions.MERCURY);
        PlanetData.builder().gravity(CLibEffects.HIGH_GRAVITY.get()).lightSpeedLocked(true, false, modLoc("enter_jupiter")).save(consumer, CelestialDimensions.JUPITER);
        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).save(consumer, CelestialDimensions.IO);
        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).save(consumer, CelestialDimensions.CALLISTO);
        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).save(consumer, CelestialDimensions.EUROPA);
        PlanetData.builder().gravity(CLibEffects.LOW_GRAVITY.get()).save(consumer, CelestialDimensions.GANYMEDE);


    }

    public ResourceLocation modLoc(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc);
    }
}
