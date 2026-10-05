package com.shim.celestialexploration.datagen;

import com.google.common.collect.ImmutableList;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.datagen.util.StructureProvider;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialGalaxies;
import com.shim.celestialexploration.registry.CelestialStructures;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
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

        this.registerStructureSet(CelestialStructures.SOLAR_FIELD.get(), 213972, 30, 12, new Pair<>(modLoc("solar_field"), 1)).save(consumer);

        this.registerStructureSet(CelestialStructures.MARS_RESEARCH_TUNNEL.get(), 263272, 50, 12, new Pair<>(modLoc("mars_research_tunnel"), 1)).save(consumer);
        this.registerStructureSet(CelestialStructures.MOON_RESEARCH_TUNNEL.get(), 215975, 50, 12, new Pair<>(modLoc("moon_research_tunnel"), 1)).save(consumer);
        this.registerStructureSet(CelestialStructures.MERCURY_RESEARCH_TUNNEL.get(), 263137, 50, 12, new Pair<>(modLoc("mercury_research_tunnel"), 1)).save(consumer);


        this.registerStructureSet(CelestialStructures.MARS_COLONY.get(), 23712738, 30, 12, new Pair<>(modLoc("mars_colony"), 1)).save(consumer);
        this.registerStructureSet(CelestialStructures.MOON_COLONY.get(), 23328430, 30, 12, new Pair<>(modLoc("moon_colony"), 1)).save(consumer);


    }

    private final static ResourceLocation EMPTY = new ResourceLocation("empty");
    private final static ResourceLocation MOON_COLONY = new ResourceLocation(CelestialExploration.MODID, "moon_colony");
    private final static ResourceLocation RUINED_MOON_COLONY = new ResourceLocation(CelestialExploration.MODID, "ruined_moon_colony");
    private final static ResourceLocation MOON_ROADS = new ResourceLocation(CelestialExploration.MODID, "moon_colony_road");
    private final static ResourceLocation MARS_COLONY = new ResourceLocation(CelestialExploration.MODID, "mars_colony");

    private final static ResourceLocation MOON_TUNNEL = new ResourceLocation(CelestialExploration.MODID, "moon_research_tunnel");
    private final static ResourceLocation MARS_TUNNEL = new ResourceLocation(CelestialExploration.MODID, "mars_research_tunnel");
    private final static ResourceLocation MERCURY_TUNNEL = new ResourceLocation(CelestialExploration.MODID, "mercury_research_tunnel");


    @Override
    protected void registerTemplatePools(Consumer<TemplatePoolGen> consumer, ExistingFileHelper fileHelper) {

        this.registerTemplatePool(modLoc("volcano/start_pool"), poolElement(modLoc("volcano_center_1"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("volcano/volcano_side"), poolElement(modLoc("volcano_side"), EMPTY, true, 1),
                poolElement(modLoc("volcano_side_2"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("volcano/volcano_side_upper_vent"), poolElement(modLoc("volcano_upper_vent_1"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("volcano/volcano_side_lower_vent"), poolElement(modLoc("volcano_lower_vent_1"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("volcano/volcano_corner"),
                poolElement(modLoc("volcano_corner"), EMPTY, true, 1), poolElement(modLoc("volcano_corner_obsidian"), EMPTY, true, 1),
                poolElement(modLoc("volcano_corner_sulfur"), EMPTY, true, 1), poolElement(modLoc("volcano_corner_lava"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("volcano/vulkan"),
                poolElement(modLoc("vulkan_1"), EMPTY, true, 5), poolElement(modLoc("vulkan_2"), EMPTY, true, 10),
                poolElement(modLoc("vulkan_3"), EMPTY, true, 1)).save(consumer);

        this.registerTemplatePool(modLoc("callisto_colony/start_pool"), poolElement(modLoc("colony/callisto/bell"), MOON_COLONY, true, 1)).save(consumer);

        this.registerTemplatePool(modLoc("callisto_colony/roads"),
                poolElement(modLoc("colony/callisto/road_cross"), MOON_ROADS, false, 1),
                poolElement(modLoc("colony/callisto/road_elbow"), MOON_ROADS, false, 10),
                poolElement(modLoc("colony/callisto/road_straight"), MOON_ROADS, false, 15),
                poolElement(modLoc("colony/callisto/road_small_straight"), MOON_ROADS, false, 12),
                poolElement(modLoc("colony/callisto/road_small_straight_alt"), MOON_ROADS, false, 20),
                poolElement(modLoc("colony/callisto/road_tee"), MOON_ROADS, false, 3)
        ).save(consumer);

        this.registerTemplatePool(modLoc("callisto_colony/building"),
                poolElement(modLoc("colony/callisto/crafting_hall"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/callisto/garden"), MOON_COLONY, true, 1),
                poolElement(modLoc("colony/callisto/greenhouse"), MOON_COLONY, true, 8),
                poolElement(modLoc("colony/callisto/house_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/callisto/house_b_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/callisto/house"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/callisto/house_b"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/callisto/ruined"), MOON_COLONY, true, 15),
                poolElement(modLoc("colony/callisto/mess_hall"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/callisto/research_hub"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/callisto/smithy"), MOON_COLONY, true, 8),
                poolElement(EMPTY, EMPTY, true, 8)
        ).save(consumer);

        this.registerTemplatePool(modLoc("solar_field"),
                poolElement(modLoc("solar_field_of_4"), EMPTY, true, 8), poolElement(modLoc("solar_field_of_4_broken"), EMPTY, false, 8),
                poolElement(modLoc("solar_field_of_9"), EMPTY, true, 10), poolElement(modLoc("solar_field_of_16"), EMPTY, true, 5)).save(consumer);

        this.registerTemplatePool(modLoc("research_tunnel/research_tunnel_mag_cart"),
                poolElement(modLoc("research_tunnel/no_mag_cart"), EMPTY, true, 20),
                poolElement(modLoc("research_tunnel/mag_cart_chest"), EMPTY, true, 2),
                poolElement(modLoc("research_tunnel/mag_cart"), EMPTY, true, 5)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/start"), poolElement(modLoc("research_tunnel_four_way"), EMPTY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/moon/chest"), poolElement(modLoc("research_tunnel/no_chest"), EMPTY, true, 5),
                poolElement(modLoc("research_tunnel/chest_moon"), EMPTY, true, 2)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mars/chest"), poolElement(modLoc("research_tunnel/no_chest"), EMPTY, true, 5),
                poolElement(modLoc("research_tunnel/chest_mars"), EMPTY, true, 2)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mercury/chest"), poolElement(modLoc("research_tunnel/no_chest"), EMPTY, true, 5),
                poolElement(modLoc("research_tunnel/chest_mercury"), EMPTY, true, 2)).save(consumer);

        this.registerTemplatePool(modLoc("research_tunnel/mars/start"), poolElement(modLoc("research_tunnel/mars/four_way"), MARS_TUNNEL, true, 50)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mars/research_tunnel"),
                poolElement(modLoc("research_tunnel/mars/hall_long"), MARS_TUNNEL, true, 90),
                poolElement(modLoc("research_tunnel/mars/hall_medium"), MARS_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mars/hall_short"), MARS_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mars/hall_tiny"), MARS_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mars/hall_spider"), MARS_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mars/hall_spider_alt"), MARS_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mars/four_way"), MARS_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/mars/tee"), MARS_TUNNEL, true, 60),
                poolElement(modLoc("research_tunnel/mars/corner"), MARS_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/mars/corner_spider"), MARS_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mars/steps"), MARS_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mars/steps_alt"), MARS_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mars/steps_cave_in"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/cave_in_1"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/cave_in_2"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/cave_in_3"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/dead_end"), MARS_TUNNEL, true, 10)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mars/likely_spider"),
                poolElement(modLoc("research_tunnel/mars/hall_spider"), MARS_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mars/hall_spider_alt"), MARS_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mars/corner_spider"), MARS_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mars/hall_long"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/hall_medium"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/hall_short"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/hall_tiny"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/four_way"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/tee"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/corner"), MARS_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mars/steps"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/steps_alt"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/steps_cave_in"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/cave_in_1"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/cave_in_2"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/cave_in_3"), MARS_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mars/dead_end"), MARS_TUNNEL, true, 10)).save(consumer);

        this.registerTemplatePool(modLoc("research_tunnel/moon/start"), poolElement(modLoc("research_tunnel/moon/four_way"), MOON_TUNNEL, true, 50)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/moon/research_tunnel"),
                poolElement(modLoc("research_tunnel/moon/hall_long"), MOON_TUNNEL, true, 90),
                poolElement(modLoc("research_tunnel/moon/hall_medium"), MOON_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/moon/hall_short"), MOON_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/moon/hall_tiny"), MOON_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/moon/hall_spider"), MOON_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/moon/hall_spider_alt"), MOON_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/moon/four_way"), MOON_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/moon/tee"), MOON_TUNNEL, true, 60),
                poolElement(modLoc("research_tunnel/moon/corner"), MOON_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/moon/corner_spider"), MOON_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/moon/steps"), MOON_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/moon/steps_alt"), MOON_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/moon/steps_cave_in"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/cave_in_1"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/cave_in_2"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/cave_in_3"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/dead_end"), MOON_TUNNEL, true, 10)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/moon/likely_spider"),
                poolElement(modLoc("research_tunnel/moon/hall_spider"), MOON_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/moon/hall_spider_alt"), MOON_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/moon/corner_spider"), MOON_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/moon/hall_long"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/hall_medium"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/hall_short"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/hall_tiny"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/four_way"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/tee"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/corner"), MOON_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/moon/steps"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/steps_alt"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/steps_cave_in"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/cave_in_1"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/cave_in_2"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/cave_in_3"), MOON_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/moon/dead_end"), MOON_TUNNEL, true, 10)).save(consumer);


        this.registerTemplatePool(modLoc("research_tunnel/mercury/start"), poolElement(modLoc("research_tunnel/mercury/four_way"), MERCURY_TUNNEL, true, 50)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mercury/research_tunnel"),
                poolElement(modLoc("research_tunnel/mercury/hall_long"), MERCURY_TUNNEL, true, 90),
                poolElement(modLoc("research_tunnel/mercury/hall_medium"), MERCURY_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mercury/hall_short"), MERCURY_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mercury/hall_tiny"), MERCURY_TUNNEL, true, 100),
                poolElement(modLoc("research_tunnel/mercury/hall_spider"), MERCURY_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mercury/hall_spider_alt"), MERCURY_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mercury/four_way"), MERCURY_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/mercury/tee"), MERCURY_TUNNEL, true, 60),
                poolElement(modLoc("research_tunnel/mercury/corner"), MERCURY_TUNNEL, true, 50),
                poolElement(modLoc("research_tunnel/mercury/corner_spider"), MERCURY_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mercury/steps"), MERCURY_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mercury/steps_alt"), MERCURY_TUNNEL, true, 40),
                poolElement(modLoc("research_tunnel/mercury/steps_cave_in"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/cave_in_1"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/cave_in_2"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/cave_in_3"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/dead_end"), MERCURY_TUNNEL, true, 10)).save(consumer);
        this.registerTemplatePool(modLoc("research_tunnel/mercury/likely_spider"),
                poolElement(modLoc("research_tunnel/mercury/hall_spider"), MERCURY_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mercury/hall_spider_alt"), MERCURY_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mercury/corner_spider"), MERCURY_TUNNEL, true, 150),
                poolElement(modLoc("research_tunnel/mercury/hall_long"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/hall_medium"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/hall_short"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/hall_tiny"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/four_way"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/tee"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/corner"), MERCURY_TUNNEL, true, 30),
                poolElement(modLoc("research_tunnel/mercury/steps"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/steps_alt"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/steps_cave_in"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/cave_in_1"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/cave_in_2"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/cave_in_3"), MERCURY_TUNNEL, true, 10),
                poolElement(modLoc("research_tunnel/mercury/dead_end"), MERCURY_TUNNEL, true, 10)).save(consumer);

        this.registerTemplatePool(modLoc("moon_colony/moon_colony_buildings"),
                poolElement(modLoc("colony/moon/crafting_hall"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/moon/garden"), MOON_COLONY, true, 1),
                poolElement(modLoc("colony/moon/greenhouse"), MOON_COLONY, true, 8),
                poolElement(modLoc("colony/moon/house_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/moon/house_b_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/moon/house"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/moon/house_b"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/moon/mess_hall"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/moon/research_hub"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/moon/ruined_meteor"), RUINED_MOON_COLONY, true, 1),
                poolElement(modLoc("colony/moon/ruined_alt"), RUINED_MOON_COLONY, true, 3),
                poolElement(modLoc("colony/moon/ruined"), RUINED_MOON_COLONY, true, 5),
                poolElement(modLoc("colony/moon/smithy"), MOON_COLONY, true, 8),
                poolElement(EMPTY, EMPTY, true, 8)).save(consumer);
        this.registerTemplatePool(modLoc("moon_colony/moon_colony_roads"),
                poolElement(modLoc("colony/moon/road_cross"), MOON_ROADS, false, 1),
                poolElement(modLoc("colony/moon/road_elbow"), MOON_ROADS, false, 10),
                poolElement(modLoc("colony/moon/road_straight"), MOON_ROADS, false, 15),
                poolElement(modLoc("colony/moon/road_small_straight"), MOON_ROADS, false, 12),
                poolElement(modLoc("colony/moon/road_small_straight_alt"), MOON_ROADS, false, 20),
                poolElement(modLoc("colony/moon/road_tee"), MOON_ROADS, false, 3)).save(consumer);
        this.registerTemplatePool(modLoc("moon_colony/start_pool"), poolElement(modLoc("colony/moon/bell"), MOON_COLONY, false, 1)).save(consumer);

        this.registerTemplatePool(modLoc("europa_colony/europa_colony_buildings"),
                poolElement(modLoc("colony/europa/crafting_hall"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/europa/garden"), MOON_COLONY, true, 1),
                poolElement(modLoc("colony/europa/greenhouse"), MOON_COLONY, true, 8),
                poolElement(modLoc("colony/europa/house_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/europa/house_b_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/europa/house"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/europa/house_b"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/europa/mess_hall"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/europa/research_hub"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/europa/ruined_meteor"), RUINED_MOON_COLONY, true, 1),
                poolElement(modLoc("colony/europa/ruined_alt"), RUINED_MOON_COLONY, true, 3),
                poolElement(modLoc("colony/europa/ruined"), RUINED_MOON_COLONY, true, 5),
                poolElement(modLoc("colony/europa/smithy"), MOON_COLONY, true, 8),
                poolElement(EMPTY, EMPTY, true, 8)).save(consumer);
        this.registerTemplatePool(modLoc("europa_colony/europa_colony_roads"),
                poolElement(modLoc("colony/europa/road_cross"), MOON_ROADS, false, 1),
                poolElement(modLoc("colony/europa/road_elbow"), MOON_ROADS, false, 10),
                poolElement(modLoc("colony/europa/road_straight"), MOON_ROADS, false, 15),
                poolElement(modLoc("colony/europa/road_small_straight"), MOON_ROADS, false, 12),
                poolElement(modLoc("colony/europa/road_small_straight_alt"), MOON_ROADS, false, 20),
                poolElement(modLoc("colony/europa/road_tee"), MOON_ROADS, false, 3)).save(consumer);
        this.registerTemplatePool(modLoc("europa_colony/start_pool"), poolElement(modLoc("colony/europa/bell"), MOON_COLONY, false, 1)).save(consumer);

        this.registerTemplatePool(modLoc("ganymede_colony/ganymede_colony_buildings"),
                poolElement(modLoc("colony/ganymede/crafting_hall"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/ganymede/garden"), MOON_COLONY, true, 1),
                poolElement(modLoc("colony/ganymede/greenhouse"), MOON_COLONY, true, 8),
                poolElement(modLoc("colony/ganymede/house_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/ganymede/house_b_alt"), MOON_COLONY, true, 5),
                poolElement(modLoc("colony/ganymede/house"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/ganymede/house_b"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/ganymede/mess_hall"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/ganymede/research_hub"), MOON_COLONY, true, 10),
                poolElement(modLoc("colony/ganymede/ruined_meteor"), RUINED_MOON_COLONY, true, 1),
                poolElement(modLoc("colony/ganymede/ruined_alt"), RUINED_MOON_COLONY, true, 3),
                poolElement(modLoc("colony/ganymede/ruined"), RUINED_MOON_COLONY, true, 5),
                poolElement(modLoc("colony/ganymede/smithy"), MOON_COLONY, true, 8),
                poolElement(EMPTY, EMPTY, true, 8)).save(consumer);
        this.registerTemplatePool(modLoc("ganymede_colony/ganymede_colony_roads"),
                poolElement(modLoc("colony/ganymede/road_cross"), MOON_ROADS, false, 1),
                poolElement(modLoc("colony/ganymede/road_elbow"), MOON_ROADS, false, 10),
                poolElement(modLoc("colony/ganymede/road_straight"), MOON_ROADS, false, 15),
                poolElement(modLoc("colony/ganymede/road_small_straight"), MOON_ROADS, false, 12),
                poolElement(modLoc("colony/ganymede/road_small_straight_alt"), MOON_ROADS, false, 20),
                poolElement(modLoc("colony/ganymede/road_tee"), MOON_ROADS, false, 3)).save(consumer);
        this.registerTemplatePool(modLoc("ganymede_colony/start_pool"), poolElement(modLoc("colony/ganymede/bell"), MOON_COLONY, false, 1)).save(consumer);


        this.registerTemplatePool(modLoc("mars_colony/downstairs"),
                poolElement(modLoc("mars_colony/bell"), MARS_COLONY, true, 1)).save(consumer);
        this.registerTemplatePool(modLoc("mars_colony/mars_colony_buildings"),
                poolElement(modLoc("mars_colony/crafting_hall"), MARS_COLONY, true, 5),
                poolElement(modLoc("mars_colony/farm"), MARS_COLONY, true, 1),
                poolElement(modLoc("mars_colony/greenhouse"), MARS_COLONY, true, 8),
                poolElement(modLoc("mars_colony/house_alt"), MARS_COLONY, true, 5),
                poolElement(modLoc("mars_colony/small_house_alt"), MARS_COLONY, true, 5),
                poolElement(modLoc("mars_colony/house"), MARS_COLONY, true, 10),
                poolElement(modLoc("mars_colony/small_house"), MARS_COLONY, true, 10),
                poolElement(modLoc("mars_colony/mess_hall"), MARS_COLONY, true, 10),
                poolElement(modLoc("mars_colony/research_hub"), MARS_COLONY, true, 8),
                poolElement(modLoc("mars_colony/smithy"), MARS_COLONY, true, 8),
                poolElement(EMPTY, EMPTY, true, 8)).save(consumer);
        this.registerTemplatePool(modLoc("mars_colony/mars_colony_roads"),
                poolElement(modLoc("mars_colony/road_cross"), MARS_COLONY, true, 1),
                poolElement(modLoc("mars_colony/road_elbow"), MARS_COLONY, true, 10),
                poolElement(modLoc("mars_colony/road_straight"), MARS_COLONY, true, 2),
                poolElement(modLoc("mars_colony/road_straight_one"), MARS_COLONY, true, 12),
                poolElement(modLoc("mars_colony/road_straight_two"), MARS_COLONY, true, 25),
                poolElement(modLoc("mars_colony/road_straight_short"), MARS_COLONY, true, 50),
                poolElement(modLoc("mars_colony/road_tee"), MARS_COLONY, true, 3),
                poolElement(modLoc("mars_colony/road_tee_alt"), MARS_COLONY, true, 5)).save(consumer);
        this.registerTemplatePool(modLoc("mars_colony/start_pool"), poolElement(modLoc("mars_colony/surface_entrance"), MARS_COLONY, true, 1)).save(consumer);

    }

    private Pair<TemplatePoolGen.Element, Integer> poolElement(ResourceLocation structure, ResourceLocation processor, boolean rigidProjection, int weight) {
        if (rigidProjection)
            return new Pair<>(new TemplatePoolGen.Element(structure, processor, StructureTemplatePool.Projection.RIGID), weight);
        else
            return new Pair<>(new TemplatePoolGen.Element(structure, processor, StructureTemplatePool.Projection.TERRAIN_MATCHING), weight);
    }

    @Override
    protected void registerConfiguredStructures(Consumer<ConfiguredStructureFeatureGen> consumer, ExistingFileHelper fileHelper) {

        this.registerStructureFeature().type(CelestialStructures.MOON_COLONY.get()).jigsawConfig(modLoc("callisto_colony/start_pool"), 5).biomes(modLoc("has_structure/callisto_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "callisto_colony");
        this.registerStructureFeature().type(CelestialStructures.MOON_COLONY.get()).jigsawConfig(modLoc("europa_colony/start_pool"), 5).biomes(modLoc("has_structure/europa_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "europa_colony");
        this.registerStructureFeature().type(CelestialStructures.MOON_COLONY.get()).jigsawConfig(modLoc("moon_colony/start_pool"), 5).biomes(modLoc("has_structure/moon_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "moon_colony");
        this.registerStructureFeature().type(CelestialStructures.MOON_COLONY.get()).jigsawConfig(modLoc("ganymede_colony/start_pool"), 5).biomes(modLoc("has_structure/ganymede_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "ganymede_colony");
        this.registerStructureFeature().type(CelestialStructures.MARS_COLONY.get()).jigsawConfig(modLoc("mars_colony/start_pool"), 5).biomes(modLoc("has_structure/mars_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "mars_colony");
        this.registerStructureFeature().type(CelestialStructures.MERCURY_COLONY.get()).jigsawConfig(modLoc("mercury_colony/start_pool"), 5).biomes(modLoc("has_structure/mercury_colony_biomes")).doAdaptNoise().emptyMonsterSpawns().save(consumer, "mercury_colony");

        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("earth"), 1, -2, 0, CelestialGalaxies.MILKY_WAY_GALAXY.get()).biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "earth");
        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("jupiter/start_pool"), 6, 6, 2, CelestialGalaxies.MILKY_WAY_GALAXY.get()).biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "jupiter");
        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("mars"), 1, 1, -3, CelestialGalaxies.MILKY_WAY_GALAXY.get()).biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "mars");
        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("mercury"), 1, 1, 1, CelestialGalaxies.MILKY_WAY_GALAXY.get()).biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "mercury");
        this.registerStructureFeature().type(CelestialStructures.PLANET.get()).planetConfig(modLoc("venus"), 1, 0, 2, CelestialGalaxies.MILKY_WAY_GALAXY.get()).biomes(CelestialTags.Biomes.MILKY_WAY_BIOMES).save(consumer, "venus");
        this.registerStructureFeature().type(CelestialStructures.VOLCANO.get()).jigsawConfig(modLoc("volcano/start_pool"), 5).doAdaptNoise().biomes(CelestialTags.Biomes.VENUS_VOLCANO_BIOMES).save(consumer, "venus_volcano");
        this.registerStructureFeature().type(CelestialStructures.SOLAR_FIELD.get()).jigsawConfig(modLoc("solar_field"), 2).biomes(CelestialTags.Biomes.SOLAR_FIELDS_BIOMES).emptyMonsterSpawns().save(consumer, "solar_field");

        this.registerStructureFeature().type(CelestialStructures.MARS_RESEARCH_TUNNEL.get()).jigsawConfig(modLoc("research_tunnel/mars/start"), 15).biomes(CelestialTags.Biomes.MARS_RESEARCH_TUNNEL_BIOMES).save(consumer, "mars_research_tunnel");
        this.registerStructureFeature().type(CelestialStructures.MOON_RESEARCH_TUNNEL.get()).jigsawConfig(modLoc("research_tunnel/moon/start"), 15).biomes(CelestialTags.Biomes.MOON_RESEARCH_TUNNEL_BIOMES).save(consumer, "moon_research_tunnel");
        this.registerStructureFeature().type(CelestialStructures.MERCURY_RESEARCH_TUNNEL.get()).jigsawConfig(modLoc("research_tunnel/mercury/start"), 15).biomes(CelestialTags.Biomes.MERCURY_RESEARCH_TUNNEL_BIOMES).save(consumer, "mercury_research_tunnel");

    }

    protected static final ProcessorRule MAG_RAIL_TO_AIR = processorRuleRandomMatch(CelestialBlocks.MAGRAIL.get(), Blocks.AIR, 0.8F);
    protected static final ProcessorRule MAG_RAIL_TO_ACTIVATOR = processorRuleRandomMatch(CelestialBlocks.MAGRAIL.get(), CelestialBlocks.ACTIVATOR_MAGRAIL.get(), 0.05F);
    protected static final ProcessorRule COBWEB_TO_AIR = processorRuleRandomMatch(Blocks.COBWEB, Blocks.AIR, 0.3F);
    protected static final ProcessorRule SPAWNER_TO_AIR = processorRuleRandomMatch(Blocks.SPAWNER, Blocks.AIR, 0.7F);
    protected static final ProcessorRule GLOW_STRIP_TO_AIR = processorRuleRandomMatch(CelestialBlocks.GLOW_STRIP.get(), Blocks.AIR, 0.7F);
    protected static final ProcessorRule GENERATOR_TO_AIR = processorRuleRandomMatch(CelestialBlocks.UNSTABLE_OXYGEN_GENERATOR.get(), Blocks.AIR, 0.8F);
    protected static final float CRACKED_BRICK_CHANCE = 0.25F;
    protected static final float LANTERN_TO_AIR_CHANCE = 0.4F;


    @Override
    protected void registerProcessorList(Consumer<ProcessorListGen> consumer, ExistingFileHelper fileHelper) {

        this.registerProcessorRules(modLoc("mars_research_tunnel"), ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleAlwaysMatch(Blocks.STONE_BRICKS, CelestialBlocks.MARS_BRICKS.get()), processorRuleAlwaysMatch(Blocks.COBBLESTONE, CelestialBlocks.MARS_COBBLESTONE.get()),
                processorRuleAlwaysMatch(Blocks.STONE_BRICK_WALL, CelestialBlocks.MARS_BRICK_WALL.get()), processorRuleAlwaysMatch(Blocks.STONE_BRICK_STAIRS, CelestialBlocks.MARS_STONE_STAIRS.get()),
                processorRuleAlwaysMatch(Blocks.CRACKED_STONE_BRICKS, CelestialBlocks.CRACKED_MARS_BRICKS.get()), MAG_RAIL_TO_AIR, MAG_RAIL_TO_ACTIVATOR, COBWEB_TO_AIR, SPAWNER_TO_AIR, GLOW_STRIP_TO_AIR)))).save(consumer);

        this.registerProcessorRules(modLoc("moon_research_tunnel"), ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleAlwaysMatch(Blocks.STONE_BRICKS, CelestialBlocks.MOON_BRICKS.get()), processorRuleAlwaysMatch(Blocks.COBBLESTONE, CelestialBlocks.MOON_COBBLESTONE.get()),
                processorRuleAlwaysMatch(Blocks.STONE_BRICK_WALL, CelestialBlocks.MOON_BRICK_WALL.get()), processorRuleAlwaysMatch(Blocks.STONE_BRICK_STAIRS, CelestialBlocks.MOON_STONE_STAIRS.get()),
                processorRuleAlwaysMatch(Blocks.CRACKED_STONE_BRICKS, CelestialBlocks.CRACKED_MOON_BRICKS.get()), MAG_RAIL_TO_AIR, MAG_RAIL_TO_ACTIVATOR, COBWEB_TO_AIR, SPAWNER_TO_AIR, GLOW_STRIP_TO_AIR)))).save(consumer);

        this.registerProcessorRules(modLoc("mercury_research_tunnel"), ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleAlwaysMatch(Blocks.STONE_BRICKS, CelestialBlocks.MERCURY_BRICKS.get()), processorRuleAlwaysMatch(Blocks.COBBLESTONE, CelestialBlocks.MERCURY_COBBLESTONE.get()),
                processorRuleAlwaysMatch(Blocks.STONE_BRICK_WALL, CelestialBlocks.MERCURY_BRICK_WALL.get()), processorRuleAlwaysMatch(Blocks.STONE_BRICK_STAIRS, CelestialBlocks.MERCURY_STONE_STAIRS.get()),
                processorRuleAlwaysMatch(Blocks.CRACKED_STONE_BRICKS, CelestialBlocks.CRACKED_MERCURY_BRICKS.get()), MAG_RAIL_TO_AIR, MAG_RAIL_TO_ACTIVATOR, COBWEB_TO_AIR, SPAWNER_TO_AIR, GLOW_STRIP_TO_AIR)))).save(consumer);

        this.registerProcessorRules(MOON_ROADS, ImmutableList.of(new RuleProcessor(ImmutableList.of(processorRuleRandomMatch(CelestialBlocks.MOON_SAND_PATH.get(), CelestialBlocks.MOON_SAND.get(), 0.1F))))).save(consumer);

        this.registerProcessorRules(MOON_COLONY, ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleRandomMatch(CelestialBlocks.MOON_BRICKS.get(), CelestialBlocks.CRACKED_MOON_BRICKS.get(), CRACKED_BRICK_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get(), CRACKED_BRICK_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MOON_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get(), CRACKED_BRICK_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MOON_SAND_PATH.get(), CelestialBlocks.MOON_SAND.get(), 0.2F),
                processorRuleRandomMatch(CelestialBlocks.LUNAR_LANTERN.get(), Blocks.AIR, LANTERN_TO_AIR_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MOON_FARMLAND.get(), CelestialBlocks.MOON_FARMLAND_TILLED.get(), 0.1F),
                GLOW_STRIP_TO_AIR, GENERATOR_TO_AIR)))).save(consumer);

        this.registerProcessorRules(RUINED_MOON_COLONY, ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleRandomMatch(CelestialBlocks.MOON_BRICKS.get(), CelestialBlocks.CRACKED_MOON_BRICKS.get(), CRACKED_BRICK_CHANCE * 2.0F),
                processorRuleRandomMatch(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get(), CRACKED_BRICK_CHANCE * 2.0F),
                processorRuleRandomMatch(CelestialBlocks.MOON_DEEPSLATE_TILES.get(), CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get(), CRACKED_BRICK_CHANCE * 2.0F),
                processorRuleRandomMatch(CelestialBlocks.MOON_SAND_PATH.get(), CelestialBlocks.MOON_SAND.get(), 0.6F),
                processorRuleRandomMatch(CelestialBlocks.LUNAR_LANTERN.get(), Blocks.AIR, LANTERN_TO_AIR_CHANCE * 2.0F),
                GLOW_STRIP_TO_AIR)))).save(consumer);

        this.registerProcessorRules(modLoc("mars_colony"), ImmutableList.of(new RuleProcessor(ImmutableList.of(
                processorRuleRandomMatch(CelestialBlocks.MARS_BRICKS.get(), CelestialBlocks.CRACKED_MARS_BRICKS.get(), CRACKED_BRICK_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MARS_LANTERN.get(), Blocks.AIR, LANTERN_TO_AIR_CHANCE),
                processorRuleRandomMatch(CelestialBlocks.MARS_FARMLAND.get(), CelestialBlocks.MARS_FARMLAND_TILLED.get(), 0.1F),
                GLOW_STRIP_TO_AIR, GENERATOR_TO_AIR)))).save(consumer);


    }

    private static ProcessorRule processorRuleAlwaysMatch(Block originBlock, Block processedBlock) {
        return new ProcessorRule(new BlockMatchTest(originBlock), AlwaysTrueTest.INSTANCE, processedBlock.defaultBlockState());
    }

    private static ProcessorRule processorRuleRandomMatch(Block originBlock, Block processedBlock, float chance) {
        return new ProcessorRule(new RandomBlockMatchTest(originBlock, chance), AlwaysTrueTest.INSTANCE, processedBlock.defaultBlockState());
    }

    protected ResourceLocation modLoc(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc);
    }
}
