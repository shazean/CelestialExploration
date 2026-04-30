package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.util.StructureProvider;
import com.shim.celestialexploration.registry.CelestialGalaxies;
import com.shim.celestialexploration.registry.CelestialStructures;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.common.data.ExistingFileHelper;
import com.mojang.datafixers.util.Pair;

import java.util.function.Consumer;

public class CelestialStructureGen extends StructureProvider {
    public CelestialStructureGen(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    protected void registerStructureSets(Consumer<StructureSetGen> consumer, ExistingFileHelper fileHelper) {

        this.registerStructureSet(CelestialStructures.VOLCANO.get(), 439292, 30, 12, new Pair<>(modLoc("venus_volcano"), 1)).save(consumer);
    }

    ResourceLocation EMPTY = new ResourceLocation("empty");

    @Override
    protected void registerTemplatePools(Consumer<TemplatePoolGen> consumer, ExistingFileHelper fileHelper) {

        this.registerTemplatePool(modLoc("volcano/start_pool"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_center_1"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("volcano/volcano_side"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_side"), EMPTY, StructureTemplatePool.Projection.RIGID), 1),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_side_2"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("volcano/volcano_side_upper_vent"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_upper_vent_1"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("volcano/volcano_side_lower_vent"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_lower_vent_1"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("volcano/volcano_corner"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_corner"), EMPTY, StructureTemplatePool.Projection.RIGID), 1),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_corner_obsidian"), EMPTY, StructureTemplatePool.Projection.RIGID), 1),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_corner_sulfur"), EMPTY, StructureTemplatePool.Projection.RIGID), 1),
                new Pair<>(new TemplatePoolGen.Element(modLoc("volcano_corner_lava"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("volcano/vulkan"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("vulkan_1"), EMPTY, StructureTemplatePool.Projection.RIGID), 5),
                new Pair<>(new TemplatePoolGen.Element(modLoc("vulkan_2"), EMPTY, StructureTemplatePool.Projection.RIGID), 10),
                new Pair<>(new TemplatePoolGen.Element(modLoc("vulkan_3"), EMPTY, StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);



        this.registerTemplatePool(modLoc("callisto_colony/start_pool"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_bell"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 1)
        ).save(consumer);

        this.registerTemplatePool(modLoc("callisto_colony/roads"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_cross"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 1),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_elbow"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 10),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_straight"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 15),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_small_straight"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 12),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_small_straight_alt"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 20),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_road_tee"), modLoc("lunar_colony"), StructureTemplatePool.Projection.TERRAIN_MATCHING), 3)
        ).save(consumer);

        this.registerTemplatePool(modLoc("callisto_colony/building"),
                new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_crafting_hall"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 5),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_garden"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 1),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_greenhouse"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 8),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_house_alt"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 5),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_house_b_alt"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 5),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_house"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 10),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_house_b"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 10),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_mess_hall"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 10),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_research_hub"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 10),
        new Pair<>(new TemplatePoolGen.Element(modLoc("callisto_colony_smithy"), modLoc("lunar_colony"), StructureTemplatePool.Projection.RIGID), 8),
        new Pair<>(new TemplatePoolGen.Element(EMPTY, EMPTY, StructureTemplatePool.Projection.RIGID), 8)
        ).save(consumer);




    }

    @Override
    protected void registerConfiguredStructures(Consumer<ConfiguredStructureFeatureGen> consumer, ExistingFileHelper fileHelper) {

        this.registerStructureFeature().type(CelestialStructures.LUNAR_COLONY.get()).jigsawConfig(modLoc("callisto_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/callisto_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "callisto_colony");

        this.registerStructureFeature().type(CelestialStructures.LUNAR_COLONY.get()).jigsawConfig(modLoc("europa_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/europa_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "europa_colony");

        this.registerStructureFeature().type(CelestialStructures.LUNAR_COLONY.get()).jigsawConfig(modLoc("lunar_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/lunar_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "lunar_colony");

        this.registerStructureFeature().type(CelestialStructures.LUNAR_COLONY.get()).jigsawConfig(modLoc("ganymede_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/ganymede_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "ganymede_colony");

        this.registerStructureFeature().type(CelestialStructures.MARS_COLONY.get()).jigsawConfig(modLoc("mars_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/mars_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "mars_colony");

        this.registerStructureFeature().type(CelestialStructures.MERCURY_COLONY.get()).jigsawConfig(modLoc("mercury_colony/start_pool"), 5)
                .biomes(modLoc("has_structure/mercury_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "mercury_colony");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("earth"), 1, -2, 0, CelestialGalaxies.MILKY_WAY_GALAXY.get())
                .biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "earth");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("jupiter/start_pool"), 6, 6, 2, CelestialGalaxies.MILKY_WAY_GALAXY.get())
                .biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "jupiter");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("mars"), 1, 1, -3, CelestialGalaxies.MILKY_WAY_GALAXY.get())
                .biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "mars");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("mercury"), 1, 1, 1, CelestialGalaxies.MILKY_WAY_GALAXY.get())
                .biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "mercury");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("venus"), 1, 0, 2, CelestialGalaxies.MILKY_WAY_GALAXY.get())
                .biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "venus");

        this.registerStructureFeature().type(CelestialStructures.VOLCANO.get()).jigsawConfig(modLoc("volcano/start_pool"), 5).doAdaptNoise()
                .biomes(CelestialTags.Biomes.VENUS_VOLCANO_BIOMES).save(consumer, "venus_volcano");

    }

    @Override
    protected void registerProcessorList(Consumer<ProcessorListGen> consumer, ExistingFileHelper fileHelper) {

    }

    protected ResourceLocation modLoc(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc);
    }
}
