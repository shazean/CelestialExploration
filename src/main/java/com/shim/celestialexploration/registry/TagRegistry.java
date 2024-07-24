package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagRegistry {

    public class Blocks {

        public static final TagKey<Block> MOON = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon"));
        public static final TagKey<Block> MOON_STONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone"));
        public static final TagKey<Block> MOON_COBBLESTONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone"));
        public static final TagKey<Block> MOON_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));
        public static final TagKey<Block> MOON_COBBLED_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));

        public static final TagKey<Block> MARS = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars"));
        public static final TagKey<Block> MARS_STONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone"));
        public static final TagKey<Block> MARS_COBBLESTONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone"));
        public static final TagKey<Block> MARS_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate"));
        public static final TagKey<Block> MARS_COBBLED_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate"));

        public static final TagKey<Block> VENUS = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus"));
        public static final TagKey<Block> VENUS_STONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_stone"));
        public static final TagKey<Block> VENUS_COBBLESTONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobblestone"));
        public static final TagKey<Block> VENUS_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_deepslate"));
        public static final TagKey<Block> VENUS_COBBLED_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobbled_deepslate"));

        public static final TagKey<Block> MERCURY = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury"));
        public static final TagKey<Block> MERCURY_STONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_stone"));
        public static final TagKey<Block> MERCURY_COBBLESTONE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_cobblestone"));
        public static final TagKey<Block> MERCURY_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_deepslate"));
        public static final TagKey<Block> MERCURY_COBBLED_DEEPSLATE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_deepslate"));


        public static final TagKey<Block> REGOLITH = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "regolith"));

        public static final TagKey<Block> METEOR = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor"));

        public static final TagKey<Block> CONNECTED_GLASS = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass"));
        public static final TagKey<Block> CONNECTED_GLASS_PANE = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass_pane"));

        public static final TagKey<Block> DYED_CERAMIC = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "dyed_ceramic"));
        public static final TagKey<Block> PAINTED_CERAMIC = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "painted_ceramic"));

        public static final TagKey<Block> MARS_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_portal_frame_block"));
        public static final TagKey<Block> MOON_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_portal_frame_block"));
        public static final TagKey<Block> VENUS_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_portal_frame_block"));
        public static final TagKey<Block> MERCURY_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_portal_frame_block"));

        public static final TagKey<Block> MAG_RAIL = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mag_rail"));

    }

    public class Items {
        public static final TagKey<Item> MOON = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon"));
        public static final TagKey<Item> MOON_STONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone"));
        public static final TagKey<Item> MOON_COBBLESTONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone"));
        public static final TagKey<Item> MOON_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));
        public static final TagKey<Item> MOON_COBBLED_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobbled_deepslate"));

        public static final TagKey<Item> MARS = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars"));
        public static final TagKey<Item> MARS_STONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone"));
        public static final TagKey<Item> MARS_COBBLESTONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone"));
        public static final TagKey<Item> MARS_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate"));
        public static final TagKey<Item> MARS_COBBLED_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate"));

        public static final TagKey<Item> VENUS = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus"));
        public static final TagKey<Item> VENUS_STONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_stone"));
        public static final TagKey<Item> VENUS_COBBLESTONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobblestone"));
        public static final TagKey<Item> VENUS_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_deepslate"));
        public static final TagKey<Item> VENUS_COBBLED_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobbled_deepslate"));

        public static final TagKey<Item> METEOR = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor"));

        public static final TagKey<Item> MERCURY = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury"));
        public static final TagKey<Item> MERCURY_STONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_stone"));
        public static final TagKey<Item> MERCURY_COBBLESTONE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_cobblestone"));
        public static final TagKey<Item> MERCURY_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_deepslate"));
        public static final TagKey<Item> MERCURY_COBBLED_DEEPSLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mercury_cobbled_deepslate"));

        public static final TagKey<Item> DYED_CERAMIC = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "ceramic"));
        public static final TagKey<Item> PAINTED_CERAMIC = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "painted"));
        public static final TagKey<Item> DYED_CERAMIC_TILE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "ceramic_tile"));
        public static final TagKey<Item> PAINTED_CERAMIC_TILE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "painted_ceramic_tile"));

        public static final TagKey<Item> MAG_RAIL = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mag_rail"));

        public static final TagKey<Item> STONE_PRESSURE_PLATE = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "stone_pressure_plate"));
        public static final TagKey<Item> REGOLITH = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "regolith"));

        public static final TagKey<Item>  SPACESHIP = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "spaceship"));

    }
}
