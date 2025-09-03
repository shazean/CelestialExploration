package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialGalaxies;
import com.shim.celestiallib.api.datagen.GalaxyIconProvider;
import com.shim.celestiallib.data.gen.GalaxyIcon;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialGalaxyIcons extends GalaxyIconProvider {
    public CelestialGalaxyIcons(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<GalaxyIcon> consumer, ExistingFileHelper fileHelper) {

        GalaxyIcon.builder().texture(new ResourceLocation(CelestialExploration.MODID, "milky_way_icon")).save(consumer, CelestialDimensions.MILKY_WAY.location().getPath());

    }
}