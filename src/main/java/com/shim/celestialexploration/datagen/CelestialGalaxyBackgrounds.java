package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialGalaxies;
import com.shim.celestiallib.api.datagen.GalaxyBackgroundProvider;
import com.shim.celestiallib.data.gen.GalaxyBackground;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialGalaxyBackgrounds extends GalaxyBackgroundProvider {
    public CelestialGalaxyBackgrounds(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, CelestialExploration.MODID, fileHelperIn);
    }

    @Override
    protected void register(Consumer<GalaxyBackground> consumer, ExistingFileHelper fileHelper) {

        GalaxyBackground.add().size(512)
                .texture(new ResourceLocation(CelestialExploration.MODID, "gui/light_speed_travel/milky_way")).save(consumer, CelestialDimensions.MILKY_WAY);

    }
}
