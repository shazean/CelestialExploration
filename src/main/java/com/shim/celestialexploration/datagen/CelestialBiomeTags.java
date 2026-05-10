package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialTags;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import com.shim.celestiallib.api.world.tags.CLibTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;

public class CelestialBiomeTags extends BiomeTagsProvider {

    public CelestialBiomeTags(DataGenerator generator, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(generator, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(CelestialTags.Biomes.MARS_BIOMES)
                .add(CelestialBiomeKeys.MARS_CRATERS)
                .add(CelestialBiomeKeys.MARS_DEEP_CRATERS)
                .add(CelestialBiomeKeys.MARS_DESERT)
                .add(CelestialBiomeKeys.MARS_DUNES)
                .add(CelestialBiomeKeys.MARS_DRY_ICE_FLATS)
                .add(CelestialBiomeKeys.MARS_DRY_ICE_PEAKS)
                .add(CelestialBiomeKeys.MARS_ERODED_FLATS)
                .add(CelestialBiomeKeys.MARS_FLATS)
                .add(CelestialBiomeKeys.MARS_VOLCANO_FLATS);

        tag(CelestialTags.Biomes.MOON_BIOMES)
                .add(CelestialBiomeKeys.MOON_CRATERS)
                .add(CelestialBiomeKeys.MOON_DESERT)
                .add(CelestialBiomeKeys.MOON_LAVA_FLATS)
                .add(CelestialBiomeKeys.MOON_PLAINS)
                .add(CelestialBiomeKeys.MOON_LOWER_PLAINS);

        tag(CelestialTags.Biomes.VENUS_BIOMES)
                .add(CelestialBiomeKeys.VENUS_DESERT)
                .add(CelestialBiomeKeys.VENUS_LOWER_PLAINS)
                .add(CelestialBiomeKeys.VENUS_PLAINS)
                .add(CelestialBiomeKeys.VENUS_SULFUR_FLATS)
                .add(CelestialBiomeKeys.SULFUR_RIVER)
                .add(CelestialBiomeKeys.SULFUR_OCEAN);

        tag(CelestialTags.Biomes.MERCURY_BIOMES)
                .add(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_DESERT)
                .add(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_RIDGES);

        tag(CelestialTags.Biomes.JUPITER_BIOMES)
                .add(CelestialBiomeKeys.JUPITER_GREAT_STORM)
                .add(CelestialBiomeKeys.JUPITER_LESSER_STORM)
                .add(CelestialBiomeKeys.JUPITER_ETHER);

        tag(CelestialTags.Biomes.EUROPA_BIOMES)
                .add(CelestialBiomeKeys.EUROPA_DESERT)
                .add(CelestialBiomeKeys.EUROPA_JAGGED_PLAINS)
                .add(CelestialBiomeKeys.EUROPA_LOWER_PLAINS)
                .add(CelestialBiomeKeys.EUROPA_OCEAN)
                .add(CelestialBiomeKeys.EUROPA_PLAINS)
                .add(CelestialBiomeKeys.EUROPA_RIVER);

        tag(CelestialTags.Biomes.CALLISTO_BIOMES)
                .add(CelestialBiomeKeys.CALLISTO_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.CALLISTO_DESERT)
                .add(CelestialBiomeKeys.CALLISTO_LOWER_PLAINS)
                .add(CelestialBiomeKeys.CALLISTO_PLAINS);

        tag(CelestialTags.Biomes.IO_BIOMES)
                .add(CelestialBiomeKeys.IO_DESERT)
                .add(CelestialBiomeKeys.IO_LOWER_PLAINS)
                .add(CelestialBiomeKeys.IO_PLAINS)
                .add(CelestialBiomeKeys.IO_SULFUR_FLATS);

        tag(CelestialTags.Biomes.GANYMEDE_BIOMES)
                .add(CelestialBiomeKeys.GANYMEDE_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.GANYMEDE_DESERT)
                .add(CelestialBiomeKeys.GANYMEDE_LOWER_PLAINS)
                .add(CelestialBiomeKeys.GANYMEDE_PLAINS);

        tag(CelestialTags.Biomes.MILKY_WAY_BIOMES)
                .add(CelestialBiomeKeys.MILKY_WAY);

        tag(CLibTags.Biomes.NO_SNOW_BIOMES)
                .addTag(CelestialTags.Biomes.MARS_BIOMES)
                .addTag(CelestialTags.Biomes.MOON_BIOMES)
                .addTag(CelestialTags.Biomes.MILKY_WAY_BIOMES)
                .addTag(CelestialTags.Biomes.MERCURY_BIOMES)
                .addTag(CelestialTags.Biomes.JUPITER_BIOMES)
                .addTag(CelestialTags.Biomes.EUROPA_BIOMES)
                .addTag(CelestialTags.Biomes.CALLISTO_BIOMES)
                .addTag(CelestialTags.Biomes.IO_BIOMES)
                .addTag(CelestialTags.Biomes.GANYMEDE_BIOMES);

        tag(CelestialTags.Biomes.VENUS_VOLCANO_BIOMES)
                .add(CelestialBiomeKeys.VENUS_DESERT)
                .add(CelestialBiomeKeys.VENUS_LOWER_PLAINS)
                .add(CelestialBiomeKeys.VENUS_PLAINS)
                .add(CelestialBiomeKeys.VENUS_SULFUR_FLATS);

        //FIXME
        tag(CLibTags.Biomes.PLANETS)
                .addTag(CelestialTags.Biomes.MARS_BIOMES)
                .addTag(CelestialTags.Biomes.VENUS_BIOMES)
                .addTag(CelestialTags.Biomes.MERCURY_BIOMES)
                .addTag(CelestialTags.Biomes.JUPITER_BIOMES);

        tag(CLibTags.Biomes.MOONS)
                .addTag(CelestialTags.Biomes.MOON_BIOMES)
                .addTag(CelestialTags.Biomes.EUROPA_BIOMES)
                .addTag(CelestialTags.Biomes.CALLISTO_BIOMES)
                .addTag(CelestialTags.Biomes.IO_BIOMES)
                .addTag(CelestialTags.Biomes.GANYMEDE_BIOMES);

        tag(CelestialTags.Biomes.CELESTIAL_BODIES)
                .addTag(CLibTags.Biomes.PLANETS)
                .addTag(CLibTags.Biomes.MOONS);
//                .addTag(CelestialTags.Biomes.MILKY_WAY_BIOMES);

        tag(CelestialTags.Biomes.DUST_STORM_BIOMES)
                .addTag(CelestialTags.Biomes.MARS_BIOMES)
                .addTag(CelestialTags.Biomes.JUPITER_BIOMES);

        tag(CelestialTags.Biomes.METEOR_SHOWER_BIOMES)
                .addTag(CelestialTags.Biomes.MERCURY_BIOMES)
                .addTag(CelestialTags.Biomes.CALLISTO_BIOMES);

        tag(CelestialTags.Biomes.SOLAR_FIELDS_BIOMES)
                .addTag(CelestialTags.Biomes.MOON_BIOMES)
                .addTag(CelestialTags.Biomes.MARS_BIOMES)
                .addTag(CelestialTags.Biomes.MERCURY_BIOMES)
                .addTag(CelestialTags.Biomes.EUROPA_BIOMES)
                .addTag(CelestialTags.Biomes.CALLISTO_BIOMES)
                .addTag(CelestialTags.Biomes.GANYMEDE_BIOMES);


    }
}