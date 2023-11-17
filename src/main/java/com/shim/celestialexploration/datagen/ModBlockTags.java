package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BiomeRegistry;
import com.shim.celestialexploration.registry.BlockRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CelestialExploration.MODID, helper);
    }

    @Override
    protected void addTags() {
        /**
         * VANILLA TAGS
         */
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                /**
                 * MOON
                 */
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


                /**MARS*/
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


                /**METEOR*/
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
                .add(BlockRegistry.CHISELED_METEOR_BRICKS.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get());

        tag(Tags.Blocks.ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.METEOR_COAL_ORE.get())
                .add(BlockRegistry.METEOR_COPPER_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get());

        tag(BlockTags.DIRT);

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

        tag(BlockTags.IRON_ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
        ;

        tag(BlockTags.LAPIS_ORES)
                .add(BlockRegistry.METEOR_LAPIS_ORE.get());

        tag(BlockTags.REDSTONE_ORES)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.MARS_SAND.get());

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
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get());

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
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get());

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
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get());

        tag(Tags.Blocks.SAND)
                .add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.COARSE_MOON_SAND.get())
                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.MOON_SAND.get());

        tag(BlockTags.CLIMBABLE)
                .add(BlockRegistry.STEEL_FRAME.get());

        tag(BlockTags.UNSTABLE_BOTTOM_CENTER)
                .add(BlockRegistry.STEEL_FRAME.get());

        //TODO
        tag(Tags.Blocks.ORE_RATES_DENSE);
        tag(Tags.Blocks.ORE_RATES_SINGULAR);
        tag(Tags.Blocks.ORE_RATES_SPARSE);

        /**
         * CUSTOM TAGS
         */

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
                .add(BlockRegistry.MOON_PORTAL.get());

        tag(BlockRegistry.CONNECTED_GLASS_TAG)
                .add(BlockRegistry.REINFORCED_GLASS.get());

        tag(BlockRegistry.CONNECTED_GLASS_PANE_TAG)
                .add(BlockRegistry.REINFORCED_GLASS_PANE.get());

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


        //TODO fluid tags
    }

    @Override
    public String getName() {
        return "Celestial Exploration tags";

    }
}
