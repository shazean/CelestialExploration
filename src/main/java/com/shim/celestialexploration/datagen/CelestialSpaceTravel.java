package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialGalaxies;
import com.shim.celestiallib.api.datagen.SpaceTravelProvider;
import com.shim.celestiallib.data.gen.SpaceTravel;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialSpaceTravel extends SpaceTravelProvider {
    public CelestialSpaceTravel(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<SpaceTravel> consumer, ExistingFileHelper fileHelper) {


        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(-2, 0)).save(consumer, CelestialDimensions.MOON);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(-2, 0)).save(consumer, Level.OVERWORLD);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(1, -3)).save(consumer, CelestialDimensions.MARS);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(0, 2)).save(consumer, CelestialDimensions.VENUS);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(1, 1)).save(consumer, CelestialDimensions.MERCURY);

        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(6, 2)).save(consumer, CelestialDimensions.JUPITER);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(6, 2)).save(consumer, CelestialDimensions.EUROPA);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(6, 2)).save(consumer, CelestialDimensions.CALLISTO);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(6, 2)).save(consumer, CelestialDimensions.IO);
        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinates(coord(6, 2)).save(consumer, CelestialDimensions.GANYMEDE);

        SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get()).coordinateScale(0.75D).save(consumer, Level.END);

    }
}
