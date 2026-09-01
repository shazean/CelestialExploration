package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class CelestialBlockTags extends BlockTagsProvider {

    public CelestialBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CelestialExploration.MODID, helper);

    }

    @Override
    protected void addTags() {
        //---- VANILLA BLOCKTAGS -------------------------------------------------------------------------------
        //TOOLS
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                //MOON
                .addTag(CelestialTags.Blocks.MOON_STONE)
                .addTag(CelestialTags.Blocks.MOON_COBBLESTONE)
                .addTag(CelestialTags.Blocks.MOON_DEEPSLATE)
                .addTag(CelestialTags.Blocks.MOON_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MOON_IRON_ORE.get()).add(CelestialBlocks.MOON_REDSTONE_ORE.get()).add(CelestialBlocks.MOON_BAUXITE_ORE.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.COMPRESSED_MOON_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE.get())

                //MARS
                .addTag(CelestialTags.Blocks.MARS_STONE)
                .addTag(CelestialTags.Blocks.MARS_COBBLESTONE)
                .addTag(CelestialTags.Blocks.MARS_DEEPSLATE)
                .addTag(CelestialTags.Blocks.MARS_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MARS_IRON_ORE.get()).add(CelestialBlocks.MARS_REDSTONE_ORE.get()).add(CelestialBlocks.MARS_BAUXITE_ORE.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.COMPRESSED_MARS_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE.get())

                //VENUS
                .addTag(CelestialTags.Blocks.VENUS_STONE)
                .addTag(CelestialTags.Blocks.VENUS_COBBLESTONE)
                .addTag(CelestialTags.Blocks.VENUS_DEEPSLATE)
                .addTag(CelestialTags.Blocks.VENUS_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.SULFURIC_OBSIDIAN.get())
                .add(CelestialBlocks.VENUS_IRON_ORE.get()).add(CelestialBlocks.VENUS_REDSTONE_ORE.get()).add(CelestialBlocks.VENUS_BAUXITE_ORE.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.COMPRESSED_VENUS_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE.get())

                //MERCURY
                .addTag(CelestialTags.Blocks.MERCURY_STONE)
                .addTag(CelestialTags.Blocks.MERCURY_COBBLESTONE)
                .addTag(CelestialTags.Blocks.MERCURY_DEEPSLATE)
                .addTag(CelestialTags.Blocks.MERCURY_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MERCURY_BAUXITE_ORE.get()).add(CelestialBlocks.MERCURY_SULFUR_ORE.get()).add(CelestialBlocks.MERCURY_COAL_ORE.get()).add(CelestialBlocks.MERCURY_DIAMOND_ORE.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get())
                .add(CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get())

                //JUPITER
                .addTag(CelestialTags.Blocks.JUPITER_DEEPSLATE)
                .addTag(CelestialTags.Blocks.JUPITER_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE.get())


                //METEOR
                .add(CelestialBlocks.METEOR.get())
                .add(CelestialBlocks.METEOR_BRICKS.get()).add(CelestialBlocks.METEOR_BRICK_SLAB.get()).add(CelestialBlocks.METEOR_BRICK_STAIRS.get()).add(CelestialBlocks.METEOR_BRICK_WALL.get()).add(CelestialBlocks.CHISELED_METEOR_BRICKS.get())
                .add(CelestialBlocks.METEOR_COAL_ORE.get()).add(CelestialBlocks.METEOR_COPPER_ORE.get()).add(CelestialBlocks.METEOR_DIAMOND_ORE.get()).add(CelestialBlocks.METEOR_EMERALD_ORE.get())
                .add(CelestialBlocks.METEOR_GOLD_ORE.get()).add(CelestialBlocks.METEOR_IRON_ORE.get()).add(CelestialBlocks.METEOR_LAPIS_ORE.get()).add(CelestialBlocks.METEOR_REDSTONE_ORE.get()).add(CelestialBlocks.METEOR_BAUXITE_ORE.get())

                //IO
                .addTag(CelestialTags.Blocks.IO_STONE)
                .addTag(CelestialTags.Blocks.IO_COBBLESTONE)
                .addTag(CelestialTags.Blocks.IO_DEEPSLATE)
                .addTag(CelestialTags.Blocks.IO_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.IO_SULFUR_ORE.get()).add(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE.get())

                //CERAMIC
                .add(CelestialBlocks.CERAMIC.get()).add(CelestialBlocks.CERAMIC_TILE.get())
                .addTag(CelestialTags.Blocks.DYED_CERAMIC)
                .addTag(CelestialTags.Blocks.DYED_CERAMIC_TILE)
                .addTag(CelestialTags.Blocks.PAINTED_CERAMIC)
                
                //OTHER
                .add(CelestialBlocks.BAUXITE_ORE.get()).add(CelestialBlocks.STEEL_BLOCK.get()).add(CelestialBlocks.ALUMINUM_BLOCK.get())
                .add(CelestialBlocks.COMPRESSED_COBBLESTONE.get()).add(CelestialBlocks.SUPER_COMPRESSED_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_NETHERRACK.get()).add(CelestialBlocks.SUPER_COMPRESSED_NETHERRACK.get())

                .add(CelestialBlocks.STEEL_BLOCK.get()).add(CelestialBlocks.ALUMINUM_BLOCK.get())
                .add(CelestialBlocks.PANEL_WALL.get()).add(CelestialBlocks.PANEL.get()).add(CelestialBlocks.PANEL_SLAB.get()).add(CelestialBlocks.PANEL_STAIRS.get())
                .add(CelestialBlocks.INSULATED_PANEL.get()).add(CelestialBlocks.SOLAR_PANEL.get()).add(CelestialBlocks.INSULATED_PANEL_CORNER.get())

                .add(CelestialBlocks.AIRLOCK_PANEL_DOOR.get()).add(CelestialBlocks.AIRLOCK_PANEL_DOOR_WINDOW.get()).add(CelestialBlocks.HANGAR_DOOR.get()).add(CelestialBlocks.HANGAR_DOOR_WINDOW.get())

                .add(CelestialBlocks.MAGRAIL.get()).add(CelestialBlocks.ACTIVATOR_MAGRAIL.get()).add(CelestialBlocks.DETECTOR_MAGRAIL.get()).add(CelestialBlocks.POWERED_MAGRAIL.get())


                .add(CelestialBlocks.STEEL_FRAME.get())

                .addTag(CelestialTags.Blocks.CHESTS)

                .add(CelestialBlocks.DIAMOND_CHUNK.get()).add(CelestialBlocks.DIAMOND_CLUSTER.get())
                .add(CelestialBlocks.SMALL_DIAMOND_CRYSTAL.get()).add(CelestialBlocks.MEDIUM_DIAMOND_CRYSTAL.get()).add(CelestialBlocks.LARGE_DIAMOND_CRYSTAL.get())

                .add(CelestialBlocks.WORKBENCH.get()).add(CelestialBlocks.OXYGEN_COMPRESSOR.get()).add(CelestialBlocks.OXYGEN_GENERATOR.get()).add(CelestialBlocks.UNSTABLE_OXYGEN_GENERATOR.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(CelestialBlocks.WORKBENCH.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(CelestialBlocks.MOON_IRON_ORE.get()).add(CelestialBlocks.MOON_BAUXITE_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.MARS_IRON_ORE.get()).add(CelestialBlocks.MARS_BAUXITE_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.VENUS_IRON_ORE.get()).add(CelestialBlocks.VENUS_BAUXITE_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.METEOR_IRON_ORE.get()).add(CelestialBlocks.METEOR_BAUXITE_ORE.get())
                .add(CelestialBlocks.MERCURY_BAUXITE_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.MERCURY_COAL_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get())
                .add(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.BAUXITE_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(CelestialBlocks.MOON_REDSTONE_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.MARS_REDSTONE_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.VENUS_REDSTONE_ORE.get()).add(CelestialBlocks.VENUS_LAPIS_ORE.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.METEOR_REDSTONE_ORE.get()).add(CelestialBlocks.METEOR_DIAMOND_ORE.get())
                .add(CelestialBlocks.METEOR_EMERALD_ORE.get()).add(CelestialBlocks.METEOR_GOLD_ORE.get()).add(CelestialBlocks.METEOR_LAPIS_ORE.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.MERCURY_DIAMOND_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get())
                .add(CelestialBlocks.MERCURY_SULFUR_ORE.get())
                .add(CelestialBlocks.IO_SULFUR_ORE.get())
                .add(CelestialBlocks.METEOR_SULFUR_ORE.get())

                .add(CelestialBlocks.DIAMOND_CHUNK.get()).add(CelestialBlocks.DIAMOND_CLUSTER.get())
                .add(CelestialBlocks.SMALL_DIAMOND_CRYSTAL.get()).add(CelestialBlocks.MEDIUM_DIAMOND_CRYSTAL.get()).add(CelestialBlocks.LARGE_DIAMOND_CRYSTAL.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CelestialBlocks.SULFURIC_OBSIDIAN.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL)
                .add(CelestialBlocks.MOON_SAND.get()).add(CelestialBlocks.GLOWING_MOON_SAND.get()).add(CelestialBlocks.COARSE_MOON_SAND.get())
                .add(CelestialBlocks.MOON_SAND_PATH.get()).add(CelestialBlocks.MARS_SAND_PATH.get())
                .add(CelestialBlocks.MARS_SAND.get()).add(CelestialBlocks.COARSE_MARS_SAND.get())
                .add(CelestialBlocks.VENUS_SAND.get()).add(CelestialBlocks.FINE_VENUS_SAND.get())
                .add(CelestialBlocks.VENUS_SAND_PATH.get()).add(CelestialBlocks.MERCURY_SAND_PATH.get())
                .add(CelestialBlocks.MERCURY_SAND.get()).add(CelestialBlocks.COARSE_MERCURY_SAND.get())
                .add(CelestialBlocks.GLOWING_CALLISTO_SAND.get()).add(CelestialBlocks.GLOWING_EUROPA_SAND.get())
                .add(CelestialBlocks.GLOWING_GANYMEDE_SAND.get())
                .add(CelestialBlocks.IO_SAND.get()).add(CelestialBlocks.COARSE_IO_SAND.get())
                .add(CelestialBlocks.GLOWING_IO_SAND.get()).add(CelestialBlocks.IO_SAND_PATH.get())
                .add(CelestialBlocks.SILICA.get());

        //ORES
        tag(net.minecraft.tags.BlockTags.COAL_ORES)
                .add(CelestialBlocks.METEOR_COAL_ORE.get())
                .add(CelestialBlocks.MERCURY_COAL_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get());

        tag(net.minecraft.tags.BlockTags.COPPER_ORES)
                .add(CelestialBlocks.METEOR_COPPER_ORE.get());

        tag(net.minecraft.tags.BlockTags.DIAMOND_ORES)
                .add(CelestialBlocks.MERCURY_DIAMOND_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get())
                .add(CelestialBlocks.METEOR_DIAMOND_ORE.get());

        tag(net.minecraft.tags.BlockTags.EMERALD_ORES)
                .add(CelestialBlocks.METEOR_EMERALD_ORE.get());

        tag(net.minecraft.tags.BlockTags.GOLD_ORES)
                .add(CelestialBlocks.METEOR_GOLD_ORE.get());

        tag(net.minecraft.tags.BlockTags.LAPIS_ORES)
                .add(CelestialBlocks.METEOR_LAPIS_ORE.get())
                .add(CelestialBlocks.VENUS_LAPIS_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get());

        tag(net.minecraft.tags.BlockTags.IRON_ORES)
                .add(CelestialBlocks.MOON_IRON_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.MARS_IRON_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.VENUS_IRON_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.METEOR_IRON_ORE.get())
                .add(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get())
                .add(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get());

        tag(net.minecraft.tags.BlockTags.LAPIS_ORES)
                .add(CelestialBlocks.METEOR_LAPIS_ORE.get());

        tag(net.minecraft.tags.BlockTags.REDSTONE_ORES)
                .add(CelestialBlocks.MOON_REDSTONE_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.MARS_REDSTONE_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.VENUS_REDSTONE_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.METEOR_REDSTONE_ORE.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

        //SAND, DIRT, ETC.
        tag(net.minecraft.tags.BlockTags.SAND)
                .add(CelestialBlocks.MOON_SAND.get()).add(CelestialBlocks.GLOWING_MOON_SAND.get())
                .add(CelestialBlocks.MARS_SAND.get())
                .add(CelestialBlocks.VENUS_SAND.get()).add(CelestialBlocks.FINE_VENUS_SAND.get())
                .add(CelestialBlocks.MERCURY_SAND.get())
                .add(CelestialBlocks.GLOWING_EUROPA_SAND.get())
                .add(CelestialBlocks.GLOWING_CALLISTO_SAND.get())
                .add(CelestialBlocks.GLOWING_GANYMEDE_SAND.get())
                .add(CelestialBlocks.IO_SAND.get()).add(CelestialBlocks.GLOWING_IO_SAND.get());

        //SLABS, STAIRS, WALLS
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(CelestialBlocks.MOON_STONE_SLAB.get()).add(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get()).add(CelestialBlocks.MOON_BRICK_SLAB.get())
                .add(CelestialBlocks.MOON_COBBLESTONE_SLAB.get()).add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.MARS_STONE_SLAB.get()).add(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get()).add(CelestialBlocks.MARS_BRICK_SLAB.get())
                .add(CelestialBlocks.MARS_COBBLESTONE_SLAB.get()).add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.VENUS_STONE_SLAB.get()).add(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get()).add(CelestialBlocks.VENUS_BRICK_SLAB.get()).add(CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.MERCURY_STONE_SLAB.get()).add(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get()).add(CelestialBlocks.MERCURY_BRICK_SLAB.get())
                .add(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get()).add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.IO_STONE_SLAB.get()).add(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get()).add(CelestialBlocks.IO_BRICK_SLAB.get())
                .add(CelestialBlocks.IO_COBBLESTONE_SLAB.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get())

                .add(CelestialBlocks.EUROPA_BRICK_SLAB.get())
                .add(CelestialBlocks.CALLISTO_BRICK_SLAB.get())
                .add(CelestialBlocks.GANYMEDE_BRICK_SLAB.get())

                .add(CelestialBlocks.METEOR_BRICK_SLAB.get());

        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(CelestialBlocks.MOON_STONE_STAIRS.get()).add(CelestialBlocks.MOON_BRICK_STAIRS.get())
                .add(CelestialBlocks.MOON_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_STAIRS.get())

                .add(CelestialBlocks.MARS_STONE_STAIRS.get()).add(CelestialBlocks.MARS_BRICK_STAIRS.get())
                .add(CelestialBlocks.MARS_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_STAIRS.get())

                .add(CelestialBlocks.VENUS_STONE_STAIRS.get()).add(CelestialBlocks.VENUS_BRICK_STAIRS.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.SMALL_VENUS_BRICK_STAIRS.get())

                .add(CelestialBlocks.MERCURY_STONE_STAIRS.get()).add(CelestialBlocks.MERCURY_BRICK_STAIRS.get())
                .add(CelestialBlocks.MERCURY_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_STAIRS.get())

                .add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_STAIRS.get())

                .add(CelestialBlocks.IO_STONE_STAIRS.get()).add(CelestialBlocks.IO_BRICK_STAIRS.get())
                .add(CelestialBlocks.IO_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE_STAIRS.get())
                .add(CelestialBlocks.IO_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_STAIRS.get())

                .add(CelestialBlocks.EUROPA_BRICK_STAIRS.get())
                .add(CelestialBlocks.CALLISTO_BRICK_STAIRS.get())
                .add(CelestialBlocks.GANYMEDE_BRICK_STAIRS.get())

                .add(CelestialBlocks.METEOR_BRICK_STAIRS.get());

        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(CelestialBlocks.MOON_BRICK_WALL.get())
                .add(CelestialBlocks.MOON_COBBLESTONE_WALL.get()).add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_WALL.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.MARS_BRICK_WALL.get())
                .add(CelestialBlocks.MARS_COBBLESTONE_WALL.get()).add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_WALL.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.VENUS_BRICK_WALL.get()).add(CelestialBlocks.SMALL_VENUS_BRICK_WALL.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE_WALL.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_WALL.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.MERCURY_BRICK_WALL.get())
                .add(CelestialBlocks.MERCURY_COBBLESTONE_WALL.get()).add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_WALL.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.METEOR_BRICK_WALL.get())

                .add(CelestialBlocks.IO_BRICK_WALL.get())
                .add(CelestialBlocks.IO_COBBLESTONE_WALL.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE_WALL.get())
                .add(CelestialBlocks.IO_DEEPSLATE_BRICK_WALL.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_WALL.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_WALL.get())

                .add(CelestialBlocks.EUROPA_BRICK_WALL.get())
                .add(CelestialBlocks.CALLISTO_BRICK_WALL.get())
                .add(CelestialBlocks.GANYMEDE_BRICK_WALL.get())

                .add(CelestialBlocks.PANEL_WALL.get());

        //OPENABLE THINGS
        tag(net.minecraft.tags.BlockTags.DOORS)
                .add(CelestialBlocks.AIRLOCK_DOOR.get())
                .add(CelestialBlocks.STEEL_DOOR.get());

        tag(net.minecraft.tags.BlockTags.TRAPDOORS)
                .add(CelestialBlocks.STEEL_TRAPDOOR.get())
                .add(CelestialBlocks.AIRLOCK_TRAPDOOR.get());

        //BUTTONS, PRESSURE PLATES
        tag(net.minecraft.tags.BlockTags.BUTTONS)
                .add(CelestialBlocks.MOON_STONE_BUTTON.get()).add(CelestialBlocks.MOON_DEEPSLATE_BUTTON.get())
                .add(CelestialBlocks.MARS_STONE_BUTTON.get()).add(CelestialBlocks.MARS_DEEPSLATE_BUTTON.get())
                .add(CelestialBlocks.VENUS_STONE_BUTTON.get()).add(CelestialBlocks.VENUS_DEEPSLATE_BUTTON.get())
                .add(CelestialBlocks.METEOR_BUTTON.get())
                .add(CelestialBlocks.MERCURY_STONE_BUTTON.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_BUTTON.get())
                .add(CelestialBlocks.IO_STONE_BUTTON.get()).add(CelestialBlocks.IO_DEEPSLATE_BUTTON.get())

                .add(CelestialBlocks.RED_BUTTON.get()).add(CelestialBlocks.YELLOW_BUTTON.get()).add(CelestialBlocks.BLUE_BUTTON.get())
                .add(CelestialBlocks.GREEN_BUTTON.get()).add(CelestialBlocks.WHITE_BUTTON.get()).add(CelestialBlocks.BLACK_BUTTON.get())

                .add(CelestialBlocks.STEEL_BUTTON.get())
                .add(CelestialBlocks.AIRLOCK_BUTTON.get());

        tag(net.minecraft.tags.BlockTags.PRESSURE_PLATES)
                .add(CelestialBlocks.MOON_STONE_PRESSURE_PLATE.get()).add(CelestialBlocks.MOON_DEEPSLATE_PRESSURE_PLATE.get())
                .add(CelestialBlocks.MARS_STONE_PRESSURE_PLATE.get()).add(CelestialBlocks.MARS_DEEPSLATE_PRESSURE_PLATE.get())
                .add(CelestialBlocks.VENUS_STONE_PRESSURE_PLATE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_PRESSURE_PLATE.get())
                .add(CelestialBlocks.MERCURY_STONE_PRESSURE_PLATE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_PRESSURE_PLATE.get())
                .add(CelestialBlocks.JUPITER_DEEPSLATE_PRESSURE_PLATE.get())
                .add(CelestialBlocks.IO_STONE_PRESSURE_PLATE.get()).add(CelestialBlocks.IO_DEEPSLATE_PRESSURE_PLATE.get())

                .add(CelestialBlocks.METEOR_PRESSURE_PLATE.get());

        //OTHER
        tag(net.minecraft.tags.BlockTags.CLIMBABLE)
                .add(CelestialBlocks.STEEL_FRAME.get())
                .add(CelestialBlocks.STEEL_LADDER.get());

        tag(net.minecraft.tags.BlockTags.UNSTABLE_BOTTOM_CENTER)
                .add(CelestialBlocks.STEEL_FRAME.get());

        tag(net.minecraft.tags.BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(CelestialBlocks.VENUS_SAND.get()).add(CelestialBlocks.FINE_VENUS_SAND.get())
                .add(CelestialBlocks.VENUS_STONE.get()).add(CelestialBlocks.VENUS_DEEPSLATE.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.METEOR_SULFUR_ORE.get())
                .add(CelestialBlocks.GEYSER.get())
                .add(CelestialBlocks.IO_SAND.get()).add(CelestialBlocks.COARSE_IO_SAND.get())
                .add(CelestialBlocks.IO_STONE.get()).add(CelestialBlocks.IO_DEEPSLATE.get())
                .add(CelestialBlocks.IO_COBBLESTONE.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.IO_GEYSER.get());

        tag(net.minecraft.tags.BlockTags.PORTALS)
                .add(CelestialBlocks.MARS_PORTAL.get()).add(CelestialBlocks.MOON_PORTAL.get())
                .add(CelestialBlocks.VENUS_PORTAL.get()).add(CelestialBlocks.MERCURY_PORTAL.get())
                .add(CelestialBlocks.JUPITER_PORTAL.get()).add(CelestialBlocks.EUROPA_PORTAL.get())
                .add(CelestialBlocks.CALLISTO_PORTAL.get()).add(CelestialBlocks.IO_PORTAL.get())
                .add(CelestialBlocks.GANYMEDE_PORTAL.get());

        //---- FORGE TAGS.BLOCKS -------------------------------------------------------------------------------
        //TOOLS

        //ORES
        tag(Tags.Blocks.ORES)
                .add(CelestialBlocks.MOON_IRON_ORE.get()).add(CelestialBlocks.MOON_REDSTONE_ORE.get()).add(CelestialBlocks.MOON_BAUXITE_ORE.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get())

                .add(CelestialBlocks.MARS_IRON_ORE.get()).add(CelestialBlocks.MARS_REDSTONE_ORE.get()).add(CelestialBlocks.MARS_BAUXITE_ORE.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get())

                .add(CelestialBlocks.VENUS_REDSTONE_ORE.get()).add(CelestialBlocks.VENUS_IRON_ORE.get()).add(CelestialBlocks.VENUS_LAPIS_ORE.get()).add(CelestialBlocks.VENUS_BAUXITE_ORE.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get()).add(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get())

                .add(CelestialBlocks.METEOR_COAL_ORE.get()).add(CelestialBlocks.METEOR_COPPER_ORE.get())
                .add(CelestialBlocks.METEOR_DIAMOND_ORE.get()).add(CelestialBlocks.METEOR_EMERALD_ORE.get())
                .add(CelestialBlocks.METEOR_GOLD_ORE.get()).add(CelestialBlocks.METEOR_IRON_ORE.get())
                .add(CelestialBlocks.METEOR_LAPIS_ORE.get()).add(CelestialBlocks.METEOR_REDSTONE_ORE.get())
                .add(CelestialBlocks.METEOR_BAUXITE_ORE.get())

                .add(CelestialBlocks.MERCURY_BAUXITE_ORE.get())
                .add(CelestialBlocks.MERCURY_COAL_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get())
                .add(CelestialBlocks.MERCURY_DIAMOND_ORE.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get())

                .add(CelestialBlocks.IO_SULFUR_ORE.get()).add(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get())

                .add(CelestialBlocks.BAUXITE_ORE.get());

        //TODO
        tag(Tags.Blocks.ORE_RATES_DENSE);
        tag(Tags.Blocks.ORE_RATES_SINGULAR);
        tag(Tags.Blocks.ORE_RATES_SPARSE);

        //SAND, DIRT, ETC.
        tag(Tags.Blocks.SAND)
                .addTag(net.minecraft.tags.BlockTags.SAND);

        //GLASS
        tag(Tags.Blocks.GLASS)
                .add(CelestialBlocks.REINFORCED_GLASS.get())
                .add(CelestialBlocks.LUMINOUS_BLUE_GLASS.get()).add(CelestialBlocks.LUMINOUS_CYAN_GLASS.get())
                .add(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get()).add(CelestialBlocks.LUMINOUS_RED_GLASS.get())
                .add(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get()).add(CelestialBlocks.LUMINOUS_WHITE_GLASS.get());

        tag(Tags.Blocks.GLASS_PANES)
                .add(CelestialBlocks.REINFORCED_GLASS_PANE.get())
                .add(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get()).add(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get())
                .add(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get()).add(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get())
                .add(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get()).add(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get());

        //---- MOON -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.MOON_STONE)
                .add(CelestialBlocks.MOON_STONE.get()).add(CelestialBlocks.MOON_STONE_SLAB.get()).add(CelestialBlocks.MOON_STONE_STAIRS.get())
                .add(CelestialBlocks.MOON_SMOOTH_STONE.get()).add(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get())
                .add(CelestialBlocks.MOON_BRICKS.get()).add(CelestialBlocks.MOON_BRICK_SLAB.get()).add(CelestialBlocks.MOON_BRICK_STAIRS.get()).add(CelestialBlocks.MOON_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_MOON_BRICKS.get()).add(CelestialBlocks.MOON_BRICK_PILLAR.get()).add(CelestialBlocks.CRACKED_MOON_BRICKS.get());

        tag(CelestialTags.Blocks.MOON_COBBLESTONE)
                .add(CelestialBlocks.MOON_COBBLESTONE.get()).add(CelestialBlocks.MOON_COBBLESTONE_SLAB.get())
                .add(CelestialBlocks.MOON_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MOON_COBBLESTONE_WALL.get());

        tag(CelestialTags.Blocks.MOON_DEEPSLATE)
                .add(CelestialBlocks.MOON_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_MOON_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MOON_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.MOON_DEEPSLATE_TILES.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MOON_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.MOON_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MOON_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.MOON_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MOON_COBBLED_DEEPSLATE_WALL.get());
        
        //---- MARS -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.MARS_STONE)
                .add(CelestialBlocks.MARS_STONE.get()).add(CelestialBlocks.MARS_STONE_SLAB.get()).add(CelestialBlocks.MARS_STONE_STAIRS.get())
                .add(CelestialBlocks.MARS_SMOOTH_STONE.get()).add(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get())
                .add(CelestialBlocks.MARS_BRICKS.get()).add(CelestialBlocks.MARS_BRICK_SLAB.get()).add(CelestialBlocks.MARS_BRICK_STAIRS.get()).add(CelestialBlocks.MARS_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_MARS_BRICKS.get()).add(CelestialBlocks.MARS_BRICK_PILLAR.get()).add(CelestialBlocks.CRACKED_MARS_BRICKS.get());

        tag(CelestialTags.Blocks.MARS_COBBLESTONE)
                .add(CelestialBlocks.MARS_COBBLESTONE.get()).add(CelestialBlocks.MARS_COBBLESTONE_SLAB.get())
                .add(CelestialBlocks.MARS_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MARS_COBBLESTONE_WALL.get());

        tag(CelestialTags.Blocks.MARS_DEEPSLATE)
                .add(CelestialBlocks.MARS_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_MARS_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_MARS_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MARS_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.MARS_DEEPSLATE_TILES.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MARS_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.MARS_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MARS_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.MARS_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MARS_COBBLED_DEEPSLATE_WALL.get());
        
        //---- VENUS -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.VENUS_STONE)
                .add(CelestialBlocks.VENUS_STONE.get()).add(CelestialBlocks.VENUS_STONE_SLAB.get()).add(CelestialBlocks.VENUS_STONE_STAIRS.get())
                .add(CelestialBlocks.VENUS_SMOOTH_STONE.get()).add(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get())
                .add(CelestialBlocks.VENUS_BRICKS.get()).add(CelestialBlocks.VENUS_BRICK_SLAB.get()).add(CelestialBlocks.VENUS_BRICK_STAIRS.get()).add(CelestialBlocks.VENUS_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_VENUS_BRICKS.get()).add(CelestialBlocks.VENUS_BRICK_PILLAR.get()).add(CelestialBlocks.CRACKED_VENUS_BRICKS.get());

        tag(CelestialTags.Blocks.VENUS_COBBLESTONE)
                .add(CelestialBlocks.VENUS_COBBLESTONE.get()).add(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.VENUS_COBBLESTONE_WALL.get());

        tag(CelestialTags.Blocks.VENUS_DEEPSLATE)
                .add(CelestialBlocks.VENUS_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_VENUS_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.VENUS_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.VENUS_DEEPSLATE_TILES.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.VENUS_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.VENUS_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_WALL.get());
        
        //---- MERCURY -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.MERCURY_STONE)
                .add(CelestialBlocks.MERCURY_STONE.get()).add(CelestialBlocks.MERCURY_STONE_SLAB.get()).add(CelestialBlocks.MERCURY_STONE_STAIRS.get())
                .add(CelestialBlocks.MERCURY_SMOOTH_STONE.get()).add(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get())
                .add(CelestialBlocks.MERCURY_BRICKS.get()).add(CelestialBlocks.MERCURY_BRICK_SLAB.get()).add(CelestialBlocks.MERCURY_BRICK_STAIRS.get()).add(CelestialBlocks.MERCURY_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_MERCURY_BRICKS.get()).add(CelestialBlocks.MERCURY_BRICK_PILLAR.get()).add(CelestialBlocks.CRACKED_MERCURY_BRICKS.get());

        tag(CelestialTags.Blocks.MERCURY_COBBLESTONE)
                .add(CelestialBlocks.MERCURY_COBBLESTONE.get()).add(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get())
                .add(CelestialBlocks.MERCURY_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.MERCURY_COBBLESTONE_WALL.get());

        tag(CelestialTags.Blocks.MERCURY_DEEPSLATE)
                .add(CelestialBlocks.MERCURY_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_MERCURY_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_MERCURY_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.MERCURY_DEEPSLATE_TILES.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.MERCURY_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.MERCURY_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_WALL.get());

        //---- JUPITER -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.JUPITER_DEEPSLATE)
                .add(CelestialBlocks.JUPITER_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.JUPITER_DEEPSLATE_TILES.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.JUPITER_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.JUPITER_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_WALL.get());

        //---- IO -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.IO_STONE)
                .add(CelestialBlocks.IO_STONE.get()).add(CelestialBlocks.IO_STONE_SLAB.get()).add(CelestialBlocks.IO_STONE_STAIRS.get())
                .add(CelestialBlocks.IO_SMOOTH_STONE.get()).add(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get())
                .add(CelestialBlocks.IO_BRICKS.get()).add(CelestialBlocks.IO_BRICK_SLAB.get()).add(CelestialBlocks.IO_BRICK_STAIRS.get()).add(CelestialBlocks.IO_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_IO_BRICKS.get()).add(CelestialBlocks.IO_BRICK_PILLAR.get()).add(CelestialBlocks.CRACKED_IO_BRICKS.get());

        tag(CelestialTags.Blocks.IO_COBBLESTONE)
                .add(CelestialBlocks.IO_COBBLESTONE.get()).add(CelestialBlocks.IO_COBBLESTONE_SLAB.get())
                .add(CelestialBlocks.IO_COBBLESTONE_STAIRS.get()).add(CelestialBlocks.IO_COBBLESTONE_WALL.get());

        tag(CelestialTags.Blocks.IO_DEEPSLATE)
                .add(CelestialBlocks.IO_DEEPSLATE.get()).add(CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.CRACKED_IO_DEEPSLATE_TILES.get()).add(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get())
                .add(CelestialBlocks.IO_DEEPSLATE_BRICKS.get()).add(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get()).add(CelestialBlocks.IO_DEEPSLATE_BRICK_STAIRS.get()).add(CelestialBlocks.IO_DEEPSLATE_BRICK_WALL.get())
                .add(CelestialBlocks.IO_DEEPSLATE_TILES.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_STAIRS.get()).add(CelestialBlocks.IO_DEEPSLATE_TILE_WALL.get())
                .add(CelestialBlocks.IO_POLISHED_DEEPSLATE.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.IO_POLISHED_DEEPSLATE_WALL.get());

        tag(CelestialTags.Blocks.IO_COBBLED_DEEPSLATE)
                .add(CelestialBlocks.IO_COBBLED_DEEPSLATE.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get())
                .add(CelestialBlocks.IO_COBBLED_DEEPSLATE_STAIRS.get()).add(CelestialBlocks.IO_COBBLED_DEEPSLATE_WALL.get());


        //---- METEOR -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.METEOR)
                .add(CelestialBlocks.METEOR.get())
                .add(CelestialBlocks.METEOR_BRICKS.get()).add(CelestialBlocks.METEOR_BRICK_SLAB.get()).add(CelestialBlocks.METEOR_BRICK_STAIRS.get()).add(CelestialBlocks.METEOR_BRICK_WALL.get())
                .add(CelestialBlocks.CHISELED_METEOR_BRICKS.get())
                .add(CelestialBlocks.METEOR_IRON_ORE.get()).add(CelestialBlocks.METEOR_REDSTONE_ORE.get()).add(CelestialBlocks.METEOR_GOLD_ORE.get())
                .add(CelestialBlocks.METEOR_DIAMOND_ORE.get()).add(CelestialBlocks.METEOR_LAPIS_ORE.get()).add(CelestialBlocks.METEOR_EMERALD_ORE.get())
                .add(CelestialBlocks.METEOR_COPPER_ORE.get()).add(CelestialBlocks.METEOR_COAL_ORE.get());

        //---- GLASS -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.CONNECTED_GLASS).add(CelestialBlocks.REINFORCED_GLASS.get());

        tag(CelestialTags.Blocks.CONNECTED_GLASS_PANE).add(CelestialBlocks.REINFORCED_GLASS_PANE.get());

        //---- CERAMIC -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.DYED_CERAMIC)
                .add(CelestialBlocks.WHITE_CERAMIC.get()).add(CelestialBlocks.LIGHT_GREY_CERAMIC.get()).add(CelestialBlocks.GREY_CERAMIC.get()).add(CelestialBlocks.BLACK_CERAMIC.get())
                .add(CelestialBlocks.PURPLE_CERAMIC.get()).add(CelestialBlocks.MAGENTA_CERAMIC.get()).add(CelestialBlocks.BLUE_CERAMIC.get()).add(CelestialBlocks.LIGHT_BLUE_CERAMIC.get())
                .add(CelestialBlocks.CYAN_CERAMIC.get()).add(CelestialBlocks.GREEN_CERAMIC.get()).add(CelestialBlocks.LIME_CERAMIC.get()).add(CelestialBlocks.YELLOW_CERAMIC.get())
                .add(CelestialBlocks.ORANGE_CERAMIC.get()).add(CelestialBlocks.BROWN_CERAMIC.get()).add(CelestialBlocks.RED_CERAMIC.get()).add(CelestialBlocks.PINK_CERAMIC.get());

        tag(CelestialTags.Blocks.DYED_CERAMIC_TILE)
                .add(CelestialBlocks.WHITE_CERAMIC_TILE.get()).add(CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get()).add(CelestialBlocks.GREY_CERAMIC_TILE.get()).add(CelestialBlocks.BLACK_CERAMIC_TILE.get())
                .add(CelestialBlocks.PURPLE_CERAMIC_TILE.get()).add(CelestialBlocks.MAGENTA_CERAMIC_TILE.get()).add(CelestialBlocks.BLUE_CERAMIC_TILE.get()).add(CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get())
                .add(CelestialBlocks.CYAN_CERAMIC_TILE.get()).add(CelestialBlocks.GREEN_CERAMIC_TILE.get()).add(CelestialBlocks.LIME_CERAMIC_TILE.get()).add(CelestialBlocks.YELLOW_CERAMIC_TILE.get())
                .add(CelestialBlocks.ORANGE_CERAMIC_TILE.get()).add(CelestialBlocks.BROWN_CERAMIC_TILE.get()).add(CelestialBlocks.RED_CERAMIC_TILE.get()).add(CelestialBlocks.PINK_CERAMIC_TILE.get());

        tag(CelestialTags.Blocks.PAINTED_CERAMIC)
                .add(CelestialBlocks.PAINTED_WHITE_CERAMIC.get()).add(CelestialBlocks.PAINTED_LIGHT_GREY_CERAMIC.get()).add(CelestialBlocks.PAINTED_GREY_CERAMIC.get()).add(CelestialBlocks.PAINTED_BLACK_CERAMIC.get())
                .add(CelestialBlocks.PAINTED_PURPLE_CERAMIC.get()).add(CelestialBlocks.PAINTED_MAGENTA_CERAMIC.get()).add(CelestialBlocks.PAINTED_BLUE_CERAMIC.get()).add(CelestialBlocks.PAINTED_LIGHT_BLUE_CERAMIC.get())
                .add(CelestialBlocks.PAINTED_CYAN_CERAMIC.get()).add(CelestialBlocks.PAINTED_GREEN_CERAMIC.get()).add(CelestialBlocks.PAINTED_LIME_CERAMIC.get()).add(CelestialBlocks.PAINTED_YELLOW_CERAMIC.get())
                .add(CelestialBlocks.PAINTED_ORANGE_CERAMIC.get()).add(CelestialBlocks.PAINTED_BROWN_CERAMIC.get()).add(CelestialBlocks.PAINTED_RED_CERAMIC.get()).add(CelestialBlocks.PAINTED_PINK_CERAMIC.get());
        
        //---- MISCELLANEOUS -------------------------------------------------------------------------------
        tag(CelestialTags.Blocks.REGOLITH)
                .add(CelestialBlocks.MOON_SAND.get()).add(CelestialBlocks.MARS_SAND.get()).add(CelestialBlocks.VENUS_SAND.get()).add(CelestialBlocks.MERCURY_SAND.get())
                .add(CelestialBlocks.IO_SAND.get());

        tag(CelestialTags.Blocks.COARSE_REGOLITH)
                .add(CelestialBlocks.COARSE_MOON_SAND.get()).add(CelestialBlocks.COARSE_MARS_SAND.get()).add(CelestialBlocks.COARSE_MERCURY_SAND.get())
                .add(CelestialBlocks.COARSE_IO_SAND.get());


        tag(CelestialTags.Blocks.MAGRAIL)
                .add(CelestialBlocks.MAGRAIL.get()).add(CelestialBlocks.POWERED_MAGRAIL.get()).add(CelestialBlocks.DETECTOR_MAGRAIL.get()).add(CelestialBlocks.ACTIVATOR_MAGRAIL.get());

        tag(CelestialTags.Blocks.MOON_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.MOON_BRICKS.get());

        tag(CelestialTags.Blocks.MARS_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.MARS_BRICKS.get());

        tag(CelestialTags.Blocks.VENUS_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.VENUS_BRICKS.get());

        tag(CelestialTags.Blocks.MERCURY_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.MERCURY_BRICKS.get());

        tag(CelestialTags.Blocks.JUPITER_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get());

        tag(CelestialTags.Blocks.EUROPA_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.EUROPA_BRICKS.get());

        tag(CelestialTags.Blocks.CALLISTO_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.CALLISTO_BRICKS.get());

        tag(CelestialTags.Blocks.IO_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.IO_BRICKS.get());

        tag(CelestialTags.Blocks.GANYMEDE_PORTAL_FRAME_BLOCK)
                .add(CelestialBlocks.GANYMEDE_BRICKS.get());

        tag(CelestialTags.Blocks.BAUXITE_ORE)
                .add(CelestialBlocks.BAUXITE_ORE.get())
                .add(CelestialBlocks.MOON_BAUXITE_ORE.get())
                .add(CelestialBlocks.MARS_BAUXITE_ORE.get())
                .add(CelestialBlocks.VENUS_BAUXITE_ORE.get())
                .add(CelestialBlocks.MERCURY_BAUXITE_ORE.get())
                .add(CelestialBlocks.METEOR_BAUXITE_ORE.get());

        tag(CelestialTags.Blocks.NO_SNOW)
                .add(CelestialBlocks.MARS_SAND.get())
                .add(CelestialBlocks.MARS_STONE.get())
                .add(CelestialBlocks.COARSE_MARS_SAND.get())
                .add(CelestialBlocks.MOON_SAND.get())
                .add(CelestialBlocks.MOON_STONE.get())
                .add(CelestialBlocks.COARSE_MOON_SAND.get())
                .add(CelestialBlocks.MERCURY_SAND.get())
                .add(CelestialBlocks.MERCURY_STONE.get())
                .add(CelestialBlocks.COARSE_MERCURY_SAND.get());

        tag(CelestialTags.Blocks.COMPRESSIBLE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(Blocks.NETHERRACK)
                .add(CelestialBlocks.COMPRESSED_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_NETHERRACK.get())
                .addTag(CelestialTags.Blocks.CELESTIAL_COBBLESTONE)
                .add(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_MOON_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.MARS_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_MARS_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_MERCURY_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.IO_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.COMPRESSED_IO_COBBLESTONE.get())
                .add(CelestialBlocks.COMPRESSED_IO_COBBLED_DEEPSLATE.get());

        tag(CelestialTags.Blocks.CELESTIAL_COBBLESTONE)
                .add(CelestialBlocks.MOON_COBBLESTONE.get())
                .add(CelestialBlocks.MARS_COBBLESTONE.get())
                .add(CelestialBlocks.VENUS_COBBLESTONE.get())
                .add(CelestialBlocks.MERCURY_COBBLESTONE.get())
                .add(CelestialBlocks.IO_COBBLESTONE.get());

        tag(CelestialTags.Blocks.COBBLESAURUS_FOOD)
                .add(Blocks.COBBLESTONE)
                .addTag(CelestialTags.Blocks.CELESTIAL_COBBLESTONE);

        tag(CelestialTags.Blocks.CHESTS)
                .add(CelestialBlocks.MOON_CHEST.get())
                .add(CelestialBlocks.MARS_CHEST.get())
                .add(CelestialBlocks.VENUS_CHEST.get())
                .add(CelestialBlocks.MERCURY_CHEST.get())
                .add(CelestialBlocks.JUPITER_CHEST.get())
                .add(CelestialBlocks.IO_CHEST.get());

        tag(CelestialTags.Blocks.FARMLAND)
                .add(CelestialBlocks.MARS_FARMLAND_TILLED.get())
                .add(CelestialBlocks.MOON_FARMLAND_TILLED.get())
                .add(CelestialBlocks.MERCURY_FARMLAND_TILLED.get());


        tag(CelestialTags.Blocks.MOON_COW_SPAWNABLE_ON)
                .add(CelestialBlocks.MOON_SAND.get())
                .add(CelestialBlocks.MOON_STONE.get())
                .add(CelestialBlocks.MOON_COBBLESTONE.get())
                .add(CelestialBlocks.MOON_DEEPSLATE.get())
                .add(CelestialBlocks.MOON_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.MOON_SAND_PATH.get())
                .add(CelestialBlocks.IO_SAND.get())
                .add(CelestialBlocks.IO_STONE.get())
                .add(CelestialBlocks.IO_COBBLESTONE.get())
                .add(CelestialBlocks.IO_DEEPSLATE.get())
                .add(CelestialBlocks.IO_COBBLED_DEEPSLATE.get())
                .add(CelestialBlocks.IO_SAND_PATH.get());

    }

    @Override
    public @NotNull String getName() {
        return "Celestial Exploration tags";

    }
}
