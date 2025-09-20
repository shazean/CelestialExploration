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

        milkyWay().coordinates(coord(-2, 0)).save(consumer, CelestialDimensions.MOON);
        milkyWay().coordinates(coord(-2, 0)).save(consumer, Level.OVERWORLD);
        milkyWay().coordinates(coord(1, -3)).save(consumer, CelestialDimensions.MARS);
        milkyWay().coordinates(coord(0, 2)).save(consumer, CelestialDimensions.VENUS);
        milkyWay().coordinates(coord(1, 1)).save(consumer, CelestialDimensions.MERCURY);

        milkyWay().coordinates(coord(6, 2)).save(consumer, CelestialDimensions.JUPITER);
        milkyWay().coordinates(coord(6, 2)).save(consumer, CelestialDimensions.EUROPA);
        milkyWay().coordinates(coord(6, 2)).save(consumer, CelestialDimensions.CALLISTO);
        milkyWay().coordinates(coord(6, 2)).save(consumer, CelestialDimensions.IO);
        milkyWay().coordinates(coord(6, 2)).save(consumer, CelestialDimensions.GANYMEDE);

        milkyWay().coordinateScale(0.75D).save(consumer, Level.END);

    }

    public SpaceTravel.Builder milkyWay() {
        return SpaceTravel.builder().galaxy(CelestialGalaxies.MILKY_WAY_GALAXY.get());
    }
}