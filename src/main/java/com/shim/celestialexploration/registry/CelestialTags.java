package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.material.Fluid;

public class CelestialTags {

    public static class Blocks {

        public static final TagKey<Block> MOON = BlockTags.create(modLoc("moon"));
        public static final TagKey<Block> MOON_STONE = BlockTags.create(modLoc("moon_stone"));
        public static final TagKey<Block> MOON_COBBLESTONE = BlockTags.create(modLoc("moon_cobblestone"));
        public static final TagKey<Block> MOON_DEEPSLATE = BlockTags.create(modLoc("moon_deepslate"));
        public static final TagKey<Block> MOON_COBBLED_DEEPSLATE = BlockTags.create(modLoc("moon_deepslate"));

        public static final TagKey<Block> MARS = BlockTags.create(modLoc("mars"));
        public static final TagKey<Block> MARS_STONE = BlockTags.create(modLoc("mars_stone"));
        public static final TagKey<Block> MARS_COBBLESTONE = BlockTags.create(modLoc("mars_cobblestone"));
        public static final TagKey<Block> MARS_DEEPSLATE = BlockTags.create(modLoc("mars_deepslate"));
        public static final TagKey<Block> MARS_COBBLED_DEEPSLATE = BlockTags.create(modLoc("mars_cobbled_deepslate"));

        public static final TagKey<Block> VENUS = BlockTags.create(modLoc("venus"));
        public static final TagKey<Block> VENUS_STONE = BlockTags.create(modLoc("venus_stone"));
        public static final TagKey<Block> VENUS_COBBLESTONE = BlockTags.create(modLoc("venus_cobblestone"));
        public static final TagKey<Block> VENUS_DEEPSLATE = BlockTags.create(modLoc("venus_deepslate"));
        public static final TagKey<Block> VENUS_COBBLED_DEEPSLATE = BlockTags.create(modLoc("venus_cobbled_deepslate"));

        public static final TagKey<Block> MERCURY = BlockTags.create(modLoc("mercury"));
        public static final TagKey<Block> MERCURY_STONE = BlockTags.create(modLoc("mercury_stone"));
        public static final TagKey<Block> MERCURY_COBBLESTONE = BlockTags.create(modLoc("mercury_cobblestone"));
        public static final TagKey<Block> MERCURY_DEEPSLATE = BlockTags.create(modLoc("mercury_deepslate"));
        public static final TagKey<Block> MERCURY_COBBLED_DEEPSLATE = BlockTags.create(modLoc("mercury_deepslate"));

        public static final TagKey<Block> JUPITER = BlockTags.create(modLoc("jupiter"));
        public static final TagKey<Block> JUPITER_DEEPSLATE = BlockTags.create(modLoc("jupiter_deepslate"));
        public static final TagKey<Block> JUPITER_COBBLED_DEEPSLATE = BlockTags.create(modLoc("jupiter_deepslate"));

        public static final TagKey<Block> IO = BlockTags.create(modLoc("io"));
        public static final TagKey<Block> IO_STONE = BlockTags.create(modLoc("io_stone"));
        public static final TagKey<Block> IO_COBBLESTONE = BlockTags.create(modLoc("io_cobblestone"));
        public static final TagKey<Block> IO_DEEPSLATE = BlockTags.create(modLoc("io_deepslate"));
        public static final TagKey<Block> IO_COBBLED_DEEPSLATE = BlockTags.create(modLoc("io_cobbled_deepslate"));

        public static final TagKey<Block> REGOLITH = BlockTags.create(modLoc("regolith"));
        public static final TagKey<Block> FARMLAND = BlockTags.create(modLoc("farmland"));

        public static final TagKey<Block> METEOR = BlockTags.create(modLoc("meteor"));

        public static final TagKey<Block> CONNECTED_GLASS = BlockTags.create(modLoc("connected_glass"));
        public static final TagKey<Block> CONNECTED_GLASS_PANE = BlockTags.create(modLoc("connected_glass_pane"));

        public static final TagKey<Block> DYED_CERAMIC = BlockTags.create(modLoc("dyed_ceramic"));
        public static final TagKey<Block> DYED_CERAMIC_TILE = BlockTags.create(modLoc("dyed_ceramic_tile"));
        public static final TagKey<Block> PAINTED_CERAMIC = BlockTags.create(modLoc("painted_ceramic"));

        public static final TagKey<Block> MARS_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("mars_portal_frame_block"));
        public static final TagKey<Block> MOON_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("moon_portal_frame_block"));
        public static final TagKey<Block> VENUS_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("venus_portal_frame_block"));
        public static final TagKey<Block> MERCURY_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("mercury_portal_frame_block"));
        public static final TagKey<Block> JUPITER_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("jupiter_portal_frame_block"));
        public static final TagKey<Block> EUROPA_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("europa_portal_frame_block"));
        public static final TagKey<Block> IO_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("io_portal_frame_block"));
        public static final TagKey<Block> CALLISTO_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("callisto_portal_frame_block"));
        public static final TagKey<Block> GANYMEDE_PORTAL_FRAME_BLOCK = BlockTags.create(modLoc("ganymede_portal_frame_block"));

        public static final TagKey<Block> MAGRAIL = BlockTags.create(modLoc("magrail"));
        public static final TagKey<Block> CHESTS = BlockTags.create(modLoc("chests"));

        public static final TagKey<Block> BAUXITE_ORE = BlockTags.create(modLoc("bauxite_ore"));

        public static final TagKey<Block> NO_SNOW = BlockTags.create(modLoc("no_snow"));

        public static final TagKey<Block> COMPRESSIBLE = BlockTags.create(modLoc("compressible"));
        public static final TagKey<Block> CELESTIAL_COBBLESTONE = BlockTags.create(modLoc("celestial_cobblestone"));
        public static final TagKey<Block> COBBLESAURUS_FOOD = BlockTags.create(modLoc("cobblesaurus_food"));

        public static final TagKey<Block> MOON_COW_SPAWNABLE_ON = BlockTags.create(modLoc("moon_cow_spawnable_on"));



    }

    public static class Items {
        public static final TagKey<Item> MOON = ItemTags.create(modLoc("moon"));
        public static final TagKey<Item> MOON_STONE = ItemTags.create(modLoc("moon_stone"));
        public static final TagKey<Item> MOON_COBBLESTONE = ItemTags.create(modLoc("moon_cobblestone"));
        public static final TagKey<Item> MOON_DEEPSLATE = ItemTags.create(modLoc("moon_deepslate"));
        public static final TagKey<Item> MOON_COBBLED_DEEPSLATE = ItemTags.create(modLoc("moon_cobbled_deepslate"));

        public static final TagKey<Item> MARS = ItemTags.create(modLoc("mars"));
        public static final TagKey<Item> MARS_STONE = ItemTags.create(modLoc("mars_stone"));
        public static final TagKey<Item> MARS_COBBLESTONE = ItemTags.create(modLoc("mars_cobblestone"));
        public static final TagKey<Item> MARS_DEEPSLATE = ItemTags.create(modLoc("mars_deepslate"));
        public static final TagKey<Item> MARS_COBBLED_DEEPSLATE = ItemTags.create(modLoc("mars_cobbled_deepslate"));

        public static final TagKey<Item> VENUS = ItemTags.create(modLoc("venus"));
        public static final TagKey<Item> VENUS_STONE = ItemTags.create(modLoc("venus_stone"));
        public static final TagKey<Item> VENUS_COBBLESTONE = ItemTags.create(modLoc("venus_cobblestone"));
        public static final TagKey<Item> VENUS_DEEPSLATE = ItemTags.create(modLoc("venus_deepslate"));
        public static final TagKey<Item> VENUS_COBBLED_DEEPSLATE = ItemTags.create(modLoc("venus_cobbled_deepslate"));

        public static final TagKey<Item> MERCURY = ItemTags.create(modLoc("mercury"));
        public static final TagKey<Item> MERCURY_STONE = ItemTags.create(modLoc("mercury_stone"));
        public static final TagKey<Item> MERCURY_COBBLESTONE = ItemTags.create(modLoc("mercury_cobblestone"));
        public static final TagKey<Item> MERCURY_DEEPSLATE = ItemTags.create(modLoc("mercury_deepslate"));
        public static final TagKey<Item> MERCURY_COBBLED_DEEPSLATE = ItemTags.create(modLoc("mercury_cobbled_deepslate"));

        public static final TagKey<Item> JUPITER = ItemTags.create(modLoc("jupiter"));
        public static final TagKey<Item> JUPITER_DEEPSLATE = ItemTags.create(modLoc("jupiter_deepslate"));
        public static final TagKey<Item> JUPITER_COBBLED_DEEPSLATE = ItemTags.create(modLoc("jupiter_cobbled_deepslate"));

        public static final TagKey<Item> IO = ItemTags.create(modLoc("io"));
        public static final TagKey<Item> IO_STONE = ItemTags.create(modLoc("io_stone"));
        public static final TagKey<Item> IO_COBBLESTONE = ItemTags.create(modLoc("io_cobblestone"));
        public static final TagKey<Item> IO_DEEPSLATE = ItemTags.create(modLoc("io_deepslate"));
        public static final TagKey<Item> IO_COBBLED_DEEPSLATE = ItemTags.create(modLoc("io_cobbled_deepslate"));

        public static final TagKey<Item> METEOR = ItemTags.create(modLoc("meteor"));

        public static final TagKey<Item> DYED_CERAMIC = ItemTags.create(modLoc("dyed_ceramic"));
        public static final TagKey<Item> PAINTED_CERAMIC = ItemTags.create(modLoc("painted_ceramic"));
        public static final TagKey<Item> DYED_CERAMIC_TILE = ItemTags.create(modLoc("ceramic_tile"));

        public static final TagKey<Item> MAG_RAIL = ItemTags.create(modLoc("mag_rail"));
        public static final TagKey<Item> CHESTS = ItemTags.create(modLoc("chests"));

        public static final TagKey<Item> STONE_PRESSURE_PLATE = ItemTags.create(modLoc("stone_pressure_plate"));

        public static final TagKey<Item> REGOLITH = ItemTags.create(modLoc("regolith"));
        public static final TagKey<Item> FARMLAND = ItemTags.create(modLoc("farmland"));

        public static final TagKey<Item> SPACESHIP = ItemTags.create(modLoc("spaceship"));

        public static final TagKey<Item> COMPRESSIBLE = ItemTags.create(modLoc("compressible"));
        public static final TagKey<Item> COBBLESAURUS_FOOD = ItemTags.create(modLoc("cobblesaurus_food"));
        public static final TagKey<Item> CELESTIAL_COBBLESTONE = ItemTags.create(modLoc("celestial_cobblestone"));

        public static final TagKey<Item> LUNAR_DUSTS = ItemTags.create(modLoc("lunar_dusts"));
        public static final TagKey<Item> SLIME_DROPS = ItemTags.create(modLoc("slime_drops"));
        public static final TagKey<Item> BAUXITE_ORE = ItemTags.create(modLoc("bauxite_ore"));



    }

    public static class Biomes {

        public static final TagKey<Biome> MARS_BIOMES = create("mars");
        public static final TagKey<Biome> MOON_BIOMES = create("moon");
        public static final TagKey<Biome> MILKY_WAY_BIOMES = create("milky_way");
        public static final TagKey<Biome> VENUS_BIOMES = create("venus");
        public static final TagKey<Biome> MERCURY_BIOMES = create("mercury");
        public static final TagKey<Biome> JUPITER_BIOMES = create("jupiter");
        public static final TagKey<Biome> EUROPA_BIOMES = create("europa");
        public static final TagKey<Biome> CALLISTO_BIOMES = create("callisto");
        public static final TagKey<Biome> IO_BIOMES = create("io");
        public static final TagKey<Biome> GANYMEDE_BIOMES = create("ganymede");


//        public static final TagKey<Biome> NO_SNOW_BIOMES = create("no_snow");

        public static final TagKey<Biome> DUST_STORM_BIOMES = create("dust_storms");
        public static final TagKey<Biome> METEOR_SHOWER_BIOMES = create("meteor_showers");

        public static final TagKey<Biome> VENUS_VOLCANO_BIOMES = create("venus_volcanoes");
        public static final TagKey<Biome> SOLAR_FIELDS_BIOMES = create("has_structure/solar_fields");


        //        public static final TagKey<Biome> PLANETS = create("planets");
//        public static final TagKey<Biome> MOONS = create("moons");
        public static final TagKey<Biome> CELESTIAL_BODIES = create("celestial_bodies");

        private static TagKey<Biome> create(String key) {
            return TagKey.create(Registry.BIOME_REGISTRY, modLoc(key));
        }

    }

    public static class Entities {
        public static final TagKey<EntityType<?>> FARM_ANIMALS = create("farm_animals");

//        public static final TagKey<EntityType<?>> LOW_GRAVITY_EXEMPT = create("low_gravity_exempt");
//        public static final TagKey<EntityType<?>> HIGH_GRAVITY_EXEMPT = create("high_gravity_exempt");

        private static TagKey<EntityType<?>> create(String key) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, modLoc(key));
        }
    }

    public static class Fluids {
        public static final TagKey<Fluid> SULFUR = FluidTags.create(modLoc("sulfur"));
        public static final TagKey<Fluid> MOLTEN_METAL = FluidTags.create(modLoc("molten_metal"));

    }

    public static class Structures {
        public static final TagKey<ConfiguredStructureFeature<?, ?>> MARS_LABYRINTH = create("mars_labyrinth");

        private static TagKey<ConfiguredStructureFeature<?, ?>> create(String key) {
            return TagKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY, modLoc(key));
        }
    }

    private static ResourceLocation modLoc(String location) {
        return new ResourceLocation(CelestialExploration.MODID, location);
    }
}
