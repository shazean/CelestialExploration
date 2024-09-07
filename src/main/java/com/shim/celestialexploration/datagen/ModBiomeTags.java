package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.world.biome.CelestialBiomeKeys;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;

public class ModBiomeTags extends BiomeTagsProvider {

    public ModBiomeTags(DataGenerator generator, String modid, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TagRegistry.Biomes.MARS_BIOMES)
                .add(CelestialBiomeKeys.MARS_CRATERS)
                .add(CelestialBiomeKeys.MARS_DEEP_CRATERS)
                .add(CelestialBiomeKeys.MARS_DESERT)
                .add(CelestialBiomeKeys.MARS_DUNES)
                .add(CelestialBiomeKeys.MARS_DRY_ICE_FLATS)
                .add(CelestialBiomeKeys.MARS_DRY_ICE_PEAKS)
                .add(CelestialBiomeKeys.MARS_ERODED_FLATS)
                .add(CelestialBiomeKeys.MARS_FLATS)
                .add(CelestialBiomeKeys.MARS_VOLCANO_FLATS);

        tag(TagRegistry.Biomes.MOON_BIOMES)
                .add(CelestialBiomeKeys.MOON_CRATERS)
                .add(CelestialBiomeKeys.MOON_DESERT)
                .add(CelestialBiomeKeys.MOON_LAVA_FLATS)
                .add(CelestialBiomeKeys.MOON_PLAINS)
                .add(CelestialBiomeKeys.MOON_LOWER_PLAINS);

        tag(TagRegistry.Biomes.VENUS_BIOMES)
                .add(CelestialBiomeKeys.VENUS_DESERT)
                .add(CelestialBiomeKeys.VENUS_LOWER_PLAINS)
                .add(CelestialBiomeKeys.VENUS_PLAINS)
                .add(CelestialBiomeKeys.VENUS_SULFUR_FLATS)
                .add(CelestialBiomeKeys.SULFUR_RIVER)
                .add(CelestialBiomeKeys.SULFUR_OCEAN);

        tag(TagRegistry.Biomes.MERCURY_BIOMES)
                .add(CelestialBiomeKeys.MERCURY_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_DESERT)
                .add(CelestialBiomeKeys.MERCURY_DEEP_CRATERED_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_PLAINS)
                .add(CelestialBiomeKeys.MERCURY_RIDGES);

        tag(TagRegistry.Biomes.SPACE_BIOMES)
                .add(CelestialBiomeKeys.SPACE);

        tag(TagRegistry.Biomes.NO_SNOW_BIOMES)
                .addTag(TagRegistry.Biomes.MARS_BIOMES)
                .addTag(TagRegistry.Biomes.MOON_BIOMES)
                .addTag(TagRegistry.Biomes.SPACE_BIOMES)
                .addTag(TagRegistry.Biomes.MERCURY_BIOMES);

        tag(TagRegistry.Biomes.PLANETS)
                .addTag(TagRegistry.Biomes.MARS_BIOMES)
                .addTag(TagRegistry.Biomes.VENUS_BIOMES)
                .addTag(TagRegistry.Biomes.MERCURY_BIOMES);

        tag(TagRegistry.Biomes.MOONS)
                .addTag(TagRegistry.Biomes.MOON_BIOMES);

        tag(TagRegistry.Biomes.CELESTIAL_BODIES)
                .addTag(TagRegistry.Biomes.MARS_BIOMES)
                .addTag(TagRegistry.Biomes.MOON_BIOMES)
                .addTag(TagRegistry.Biomes.SPACE_BIOMES)
                .addTag(TagRegistry.Biomes.VENUS_BIOMES)
                .addTag(TagRegistry.Biomes.MERCURY_BIOMES);

    }
}