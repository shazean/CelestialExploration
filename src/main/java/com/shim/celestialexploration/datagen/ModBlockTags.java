package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CelestialExploration.MODID, helper);
    }

    @Override
    protected void addTags() {
        /*VANILLA TAGS*/
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                /*MOON*/
                .add(BlockRegistry.MOON_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_STONE.get())
                .add(BlockRegistry.CHISELED_MOON_BRICKS.get())
                .add(BlockRegistry.MOON_BRICK_PILLAR.get())
                .add(BlockRegistry.MOON_COBBLESTONE.get())
                .add(BlockRegistry.MOON_DEEPSLATE.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_STONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MOON_SMOOTH_STONE.get())
//                .add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MOON_BRICKS.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())


                /*MARS*/
                .add(BlockRegistry.MARS_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.MARS_BRICKS.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_STONE.get())
                .add(BlockRegistry.CHISELED_MARS_BRICKS.get())
                .add(BlockRegistry.MARS_BRICK_PILLAR.get())
                .add(BlockRegistry.MARS_COBBLESTONE.get())
                .add(BlockRegistry.MARS_DEEPSLATE.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MARS_STONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MARS_SMOOTH_STONE.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MARS_BRICKS.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())


                .add(BlockRegistry.VENUS_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_BRICKS.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_STONE.get())
                .add(BlockRegistry.GEYSER.get())

                .add(BlockRegistry.CHISELED_VENUS_BRICKS.get())
//                .add(BlockRegistry.MARS_BRICK_PILLAR.get())
                .add(BlockRegistry.VENUS_COBBLESTONE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
//                .add(BlockRegistry.CRACKED_MARS_BRICKS.get())
//                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
//                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
//                .add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.SULFURIC_OBSIDIAN.get())


                /*METEOR*/
                .add(BlockRegistry.METEOR.get())
                .add(BlockRegistry.METEOR_BRICK_SLAB.get())
                .add(BlockRegistry.METEOR_BRICK_STAIRS.get())
                .add(BlockRegistry.METEOR_BRICK_WALL.get())
                .add(BlockRegistry.METEOR_BRICKS.get())
                .add(BlockRegistry.METEOR_COAL_ORE.get())
                .add(BlockRegistry.METEOR_COPPER_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.CHISELED_METEOR_BRICKS.get())

                /*CERAMIC*/
                .add(BlockRegistry.CERAMIC.get())
                .add(BlockRegistry.CERAMIC_TILE.get())
                .add(BlockRegistry.WHITE_CERAMIC.get())
                .add(BlockRegistry.WHITE_CERAMIC_TILE.get())
                .add(BlockRegistry.LIGHT_GREY_CERAMIC.get())
                .add(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get())
                .add(BlockRegistry.GREY_CERAMIC.get())
                .add(BlockRegistry.GREY_CERAMIC_TILE.get())
                .add(BlockRegistry.BLACK_CERAMIC.get())
                .add(BlockRegistry.BLACK_CERAMIC_TILE.get())
                .add(BlockRegistry.PURPLE_CERAMIC.get())
                .add(BlockRegistry.PURPLE_CERAMIC_TILE.get())
                .add(BlockRegistry.MAGENTA_CERAMIC.get())
                .add(BlockRegistry.MAGENTA_CERAMIC_TILE.get())
                .add(BlockRegistry.BLUE_CERAMIC.get())
                .add(BlockRegistry.BLUE_CERAMIC_TILE.get())
                .add(BlockRegistry.LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get())
                .add(BlockRegistry.CYAN_CERAMIC.get())
                .add(BlockRegistry.CYAN_CERAMIC_TILE.get())
                .add(BlockRegistry.GREEN_CERAMIC.get())
                .add(BlockRegistry.GREEN_CERAMIC_TILE.get())
                .add(BlockRegistry.LIME_CERAMIC.get())
                .add(BlockRegistry.LIME_CERAMIC_TILE.get())
                .add(BlockRegistry.YELLOW_CERAMIC.get())
                .add(BlockRegistry.YELLOW_CERAMIC_TILE.get())
                .add(BlockRegistry.ORANGE_CERAMIC.get())
                .add(BlockRegistry.ORANGE_CERAMIC_TILE.get())
                .add(BlockRegistry.BROWN_CERAMIC.get())
                .add(BlockRegistry.BROWN_CERAMIC_TILE.get())
                .add(BlockRegistry.RED_CERAMIC.get())
                .add(BlockRegistry.RED_CERAMIC_TILE.get())
                .add(BlockRegistry.PINK_CERAMIC.get())
                .add(BlockRegistry.PINK_CERAMIC_TILE.get())
                .add(BlockRegistry.PAINTED_WHITE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLACK_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PURPLE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_CYAN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREEN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIME_CERAMIC.get())
                .add(BlockRegistry.PAINTED_YELLOW_CERAMIC.get())
                .add(BlockRegistry.PAINTED_ORANGE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BROWN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_RED_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PINK_CERAMIC.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get())

                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.VENUS_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())

                .add(BlockRegistry.METEOR_LAPIS_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.SULFURIC_OBSIDIAN.get());


        tag(Tags.Blocks.ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.VENUS_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get())
                .add(BlockRegistry.VENUS_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())

                .add(BlockRegistry.METEOR_COAL_ORE.get())
                .add(BlockRegistry.METEOR_COPPER_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get());

//        tag(BlockTags.DIRT)
//                .add(BlockRegistry.COARSE_MOON_SAND.get())
//                .add(BlockRegistry.COARSE_MARS_SAND.get())
//                .add(BlockRegistry.COARSE_VENUS_SAND.get())

//        ;

        tag(BlockTags.COAL_ORES)
                .add(BlockRegistry.METEOR_COAL_ORE.get());

        tag(BlockTags.COPPER_ORES)
                .add(BlockRegistry.METEOR_COPPER_ORE.get());

        tag(BlockTags.DIAMOND_ORES)
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get());

        tag(BlockTags.EMERALD_ORES)
                .add(BlockRegistry.METEOR_EMERALD_ORE.get());

        tag(BlockTags.GOLD_ORES)
                .add(BlockRegistry.METEOR_GOLD_ORE.get());

        tag(BlockTags.LAPIS_ORES)
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())
        ;

        tag(BlockTags.IRON_ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get());

        tag(BlockTags.LAPIS_ORES)
                .add(BlockRegistry.METEOR_LAPIS_ORE.get());

        tag(BlockTags.REDSTONE_ORES)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.COARSE_MOON_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.FINE_VENUS_SAND.get())
        ;

        tag(BlockTags.SLABS)
                .add(BlockRegistry.MARS_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_BRICK_SLAB.get())
                .add(BlockRegistry.METEOR_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_STONE_SLAB.get())
                .add(BlockRegistry.MOON_STONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.VENUS_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
        ;

        tag(BlockTags.STAIRS)
                .add(BlockRegistry.MARS_BRICK_STAIRS.get())
                .add(BlockRegistry.METEOR_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
                ;

        tag(BlockTags.WALLS)
                .add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.METEOR_BRICK_WALL.get())
                .add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.MARS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MOON_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.VENUS_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get())
        ;


        tag(Tags.Blocks.SAND)
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
//                .add(BlockRegistry.COARSE_MOON_SAND.get())
//                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get())
                .add(BlockRegistry.FINE_VENUS_SAND.get())
        ;

        tag(BlockTags.SAND)
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
//                .add(BlockRegistry.COARSE_MOON_SAND.get())
//                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get())
                .add(BlockRegistry.FINE_VENUS_SAND.get())
        ;

        tag(BlockTags.CLIMBABLE)
                .add(BlockRegistry.STEEL_FRAME.get());

        tag(BlockTags.UNSTABLE_BOTTOM_CENTER)
                .add(BlockRegistry.STEEL_FRAME.get());

        //TODO
        tag(Tags.Blocks.ORE_RATES_DENSE);
        tag(Tags.Blocks.ORE_RATES_SINGULAR);
        tag(Tags.Blocks.ORE_RATES_SPARSE);

        /*CUSTOM TAGS*/
        tag(BlockRegistry.MOON_TAG)
                .add(BlockRegistry.MOON_BRICKS.get())
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MOON_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.COARSE_MOON_SAND.get())
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.MOON_STONE.get())
                .add(BlockRegistry.CHISELED_MOON_BRICKS.get())
                .add(BlockRegistry.MOON_BRICK_PILLAR.get())
                .add(BlockRegistry.MOON_COBBLESTONE.get())
                .add(BlockRegistry.MOON_DEEPSLATE.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_STONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MOON_SMOOTH_STONE.get())
//                .add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MOON_BRICKS.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get());

        tag(BlockRegistry.MOON_STONE_TAG)
                .add(BlockRegistry.MOON_BRICKS.get())
                .add(BlockRegistry.MOON_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.MOON_STONE.get())
                .add(BlockRegistry.CHISELED_MOON_BRICKS.get())
                .add(BlockRegistry.MOON_BRICK_PILLAR.get())
                .add(BlockRegistry.MOON_STONE_SLAB.get())
                .add(BlockRegistry.MOON_SMOOTH_STONE.get())
//                .add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MOON_BRICKS.get());

        tag(BlockRegistry.MOON_COBBLESTONE_TAG)
                .add(BlockRegistry.MOON_COBBLESTONE.get())
                .add(BlockRegistry.MOON_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLESTONE_WALL.get());

        tag(BlockRegistry.MOON_DEEPSLATE_TAG)
                .add(BlockRegistry.MOON_DEEPSLATE.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILES.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get());

        tag(BlockRegistry.MOON_COBBLED_DEEPSLATE_TAG)
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get());


        tag(BlockRegistry.MARS_TAG)
                .add(BlockRegistry.MARS_BRICKS.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MARS_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.MARS_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.MARS_STONE.get())
                .add(BlockRegistry.CHISELED_MARS_BRICKS.get())
                .add(BlockRegistry.MARS_BRICK_PILLAR.get())
                .add(BlockRegistry.MARS_COBBLESTONE.get())
                .add(BlockRegistry.MARS_DEEPSLATE.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MARS_STONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MARS_SMOOTH_STONE.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MARS_BRICKS.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get());

        tag(BlockRegistry.MARS_STONE_TAG)
                .add(BlockRegistry.MARS_BRICKS.get())
//                .add(BlockRegistry.MARS_BRICK_SLAB.get())
//                .add(BlockRegistry.MARS_BRICK_STAIRS.get())
//                .add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.MARS_STONE.get())
                .add(BlockRegistry.CHISELED_MARS_BRICKS.get())
                .add(BlockRegistry.MARS_BRICK_PILLAR.get())
//                .add(BlockRegistry.MARS_STONE_SLAB.get())
                .add(BlockRegistry.MARS_SMOOTH_STONE.get())
//                .add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.CRACKED_MARS_BRICKS.get());

        tag(BlockRegistry.MARS_COBBLESTONE_TAG)
                .add(BlockRegistry.MARS_COBBLESTONE.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
//                .add(BlockRegistry.MARS_COBBLESTONE_SLAB.get())
//                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get())
//                .add(BlockRegistry.MARS_COBBLESTONE_WALL.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get());
        ;

        tag(BlockRegistry.MARS_DEEPSLATE_TAG)
                .add(BlockRegistry.MARS_DEEPSLATE.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICKS.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILES.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get())
//                .add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get())
//                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())
//                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get());
        ;

        tag(BlockRegistry.MARS_COBBLED_DEEPSLATE_TAG)
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
//                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get());
        ;




        tag(BlockRegistry.VENUS_TAG)
                .add(BlockRegistry.VENUS_BRICKS.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get())
                .add(BlockRegistry.VENUS_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.VENUS_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_SAND.get())
//                .add(BlockRegistry.COARSE_VENUS_SAND.get())
                .add(BlockRegistry.VENUS_STONE.get())
                .add(BlockRegistry.CHISELED_VENUS_BRICKS.get())
//                .add(BlockRegistry.VENUS_BRICK_PILLAR.get())
                .add(BlockRegistry.VENUS_COBBLESTONE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_WALL.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get())
//                .add(BlockRegistry.VENUS_SMOOTH_STONE.get())
//                .add(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get())
//                .add(BlockRegistry.CRACKED_VENUS_BRICKS.get())
//                .add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get())
//                .add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get());

        tag(BlockRegistry.VENUS_STONE_TAG)
                .add(BlockRegistry.VENUS_BRICKS.get())
                .add(BlockRegistry.VENUS_STONE.get())
                .add(BlockRegistry.CHISELED_VENUS_BRICKS.get())
//                .add(BlockRegistry.VENUS_BRICK_PILLAR.get())
//                .add(BlockRegistry.VENUS_SMOOTH_STONE.get())
//                .add(BlockRegistry.CRACKED_VENUS_BRICKS.get())
                ;

        tag(BlockRegistry.VENUS_COBBLESTONE_TAG)
                .add(BlockRegistry.VENUS_COBBLESTONE.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
        ;

        tag(BlockRegistry.VENUS_DEEPSLATE_TAG)
                .add(BlockRegistry.VENUS_DEEPSLATE.get())
//                .add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get())
//                .add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get())
//                .add(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILES.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get())
        ;

        tag(BlockRegistry.VENUS_COBBLED_DEEPSLATE_TAG)
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
        ;

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(BlockRegistry.VENUS_SAND.get())
                .add(BlockRegistry.VENUS_STONE.get())
                .add(BlockRegistry.FINE_VENUS_SAND.get())
                .add(BlockRegistry.VENUS_COBBLESTONE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.METEOR_SULFUR_ORE.get())
                .add(BlockRegistry.GEYSER.get())
        ;

        tag(BlockRegistry.METEOR_TAG)
                .add(BlockRegistry.METEOR_BRICKS.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.METEOR_BRICK_SLAB.get())
                .add(BlockRegistry.METEOR_BRICK_STAIRS.get())
                .add(BlockRegistry.METEOR_BRICK_WALL.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_COPPER_ORE.get())
                .add(BlockRegistry.METEOR_COAL_ORE.get())
                .add(BlockRegistry.METEOR.get())
                .add(BlockRegistry.CHISELED_METEOR_BRICKS.get());

        tag(BlockTags.PORTALS)
                .add(BlockRegistry.MARS_PORTAL.get())
                .add(BlockRegistry.MOON_PORTAL.get())
                .add(BlockRegistry.VENUS_PORTAL.get())
        ;

        tag(BlockRegistry.REGOLITH_TAG)
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get());


        tag(BlockRegistry.CONNECTED_GLASS_TAG).add(BlockRegistry.REINFORCED_GLASS.get());

        tag(BlockRegistry.CONNECTED_GLASS_PANE_TAG).add(BlockRegistry.REINFORCED_GLASS_PANE.get());


        tag(Tags.Blocks.GLASS)
                .add(BlockRegistry.REINFORCED_GLASS.get())
                .add(BlockRegistry.REINFORCED_GLASS_PANE.get())
                .add(BlockRegistry.LUMINOUS_BLUE_GLASS.get())
                .add(BlockRegistry.LUMINOUS_WHITE_GLASS.get())
                .add(BlockRegistry.LUMINOUS_BLUE_GLASS.get())
                .add(BlockRegistry.LUMINOUS_WHITE_GLASS.get());

        tag(Tags.Blocks.GLASS_PANES)
                .add(BlockRegistry.REINFORCED_GLASS_PANE.get())
                .add(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get())
                .add(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get());

        tag(BlockRegistry.DYED_CERAMIC_TAG)
//                .add(BlockRegistry.CERAMIC.get())
//                .add(BlockRegistry.CERAMIC_TILE.get())
                .add(BlockRegistry.WHITE_CERAMIC.get())
//                .add(BlockRegistry.WHITE_CERAMIC_TILE.get())
                .add(BlockRegistry.LIGHT_GREY_CERAMIC.get())
//                .add(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get())
                .add(BlockRegistry.GREY_CERAMIC.get())
//                .add(BlockRegistry.GREY_CERAMIC_TILE.get())
                .add(BlockRegistry.BLACK_CERAMIC.get())
//                .add(BlockRegistry.BLACK_CERAMIC_TILE.get())
                .add(BlockRegistry.PURPLE_CERAMIC.get())
//                .add(BlockRegistry.PURPLE_CERAMIC_TILE.get())
                .add(BlockRegistry.MAGENTA_CERAMIC.get())
//                .add(BlockRegistry.MAGENTA_CERAMIC_TILE.get())
                .add(BlockRegistry.BLUE_CERAMIC.get())
//                .add(BlockRegistry.BLUE_CERAMIC_TILE.get())
                .add(BlockRegistry.LIGHT_BLUE_CERAMIC.get())
//                .add(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get())
                .add(BlockRegistry.CYAN_CERAMIC.get())
//                .add(BlockRegistry.CYAN_CERAMIC_TILE.get())
                .add(BlockRegistry.GREEN_CERAMIC.get())
//                .add(BlockRegistry.GREEN_CERAMIC_TILE.get())
                .add(BlockRegistry.LIME_CERAMIC.get())
//                .add(BlockRegistry.LIME_CERAMIC_TILE.get())
                .add(BlockRegistry.YELLOW_CERAMIC.get())
//                .add(BlockRegistry.YELLOW_CERAMIC_TILE.get())
                .add(BlockRegistry.ORANGE_CERAMIC.get())
//                .add(BlockRegistry.ORANGE_CERAMIC_TILE.get())
                .add(BlockRegistry.BROWN_CERAMIC.get())
//                .add(BlockRegistry.BROWN_CERAMIC_TILE.get())
                .add(BlockRegistry.RED_CERAMIC.get())
//                .add(BlockRegistry.RED_CERAMIC_TILE.get())
                .add(BlockRegistry.PINK_CERAMIC.get());
//                .add(BlockRegistry.PINK_CERAMIC_TILE.get());


        tag(BlockRegistry.PAINTED_CERAMIC_TAG)
                .add(BlockRegistry.PAINTED_WHITE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLACK_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PURPLE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_CYAN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREEN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIME_CERAMIC.get())
                .add(BlockRegistry.PAINTED_YELLOW_CERAMIC.get())
                .add(BlockRegistry.PAINTED_ORANGE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BROWN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_RED_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PINK_CERAMIC.get());

        tag(BlockRegistry.CONNECTED_GLASS_PANE_TAG)
                .add(BlockRegistry.PAINTED_WHITE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREY_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLACK_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PURPLE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_CYAN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_GREEN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_LIME_CERAMIC.get())
                .add(BlockRegistry.PAINTED_YELLOW_CERAMIC.get())
                .add(BlockRegistry.PAINTED_ORANGE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_BROWN_CERAMIC.get())
                .add(BlockRegistry.PAINTED_RED_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PINK_CERAMIC.get());


        tag(BlockRegistry.MAG_RAIL_TAG)
                .add(BlockRegistry.MAG_RAIL.get())
                .add(BlockRegistry.POWERED_MAG_RAIL.get())
                .add(BlockRegistry.DETECTOR_MAG_RAIL.get())
                .add(BlockRegistry.ACTIVATOR_MAG_RAIL.get());

        //TODO fluid tags
    }

    @Override
    public @NotNull String getName() {
        return "Celestial Exploration tags";

    }
}
