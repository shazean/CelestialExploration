package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestiallib.api.datagen.PlanetIconProvider;
import com.shim.celestiallib.data.gen.PlanetIcon;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialPlanetIcons extends PlanetIconProvider {
    public CelestialPlanetIcons(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<PlanetIcon> consumer, ExistingFileHelper fileHelper) {

        PlanetIcon.builder().texture(modLoc("gui/light_speed_travel/mars")).size(6).save(consumer, CelestialDimensions.MARS.location());
        PlanetIcon.builder().texture(modLoc("gui/light_speed_travel/overworld")).size(6).save(consumer, Level.OVERWORLD.location());
        PlanetIcon.builder().texture(modLoc("gui/light_speed_travel/venus")).size(6).save(consumer, CelestialDimensions.VENUS.location());
        PlanetIcon.builder().texture(modLoc("gui/light_speed_travel/mercury")).size(5).save(consumer, CelestialDimensions.MERCURY.location());
        PlanetIcon.builder().texture(modLoc("gui/light_speed_travel/jupiter")).size(11).save(consumer, CelestialDimensions.JUPITER.location());


    }

    public ResourceLocation modLoc(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc);
    }
}
