package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CelestialExploration.MODID, helper);

    }

    @Override
    protected void addTags() {
        //---- VANILLA BLOCKTAGS -------------------------------------------------------------------------------
        //TOOLS
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //MOON
                .addTag(TagRegistry.Blocks.MOON_STONE)
                .addTag(TagRegistry.Blocks.MOON_COBBLESTONE)
                .addTag(TagRegistry.Blocks.MOON_DEEPSLATE)
                .addTag(TagRegistry.Blocks.MOON_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MOON_IRON_ORE.get()).add(BlockRegistry.MOON_REDSTONE_ORE.get()).add(BlockRegistry.MOON_BAUXITE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())

                //MARS
                .addTag(TagRegistry.Blocks.MARS_STONE)
                .addTag(TagRegistry.Blocks.MARS_COBBLESTONE)
                .addTag(TagRegistry.Blocks.MARS_DEEPSLATE)
                .addTag(TagRegistry.Blocks.MARS_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MARS_IRON_ORE.get()).add(BlockRegistry.MARS_REDSTONE_ORE.get()).add(BlockRegistry.MARS_BAUXITE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

                //VENUS
                .addTag(TagRegistry.Blocks.VENUS_STONE)
                .addTag(TagRegistry.Blocks.VENUS_COBBLESTONE)
                .addTag(TagRegistry.Blocks.VENUS_DEEPSLATE)
                .addTag(TagRegistry.Blocks.VENUS_COBBLED_DEEPSLATE)
                .add(BlockRegistry.SULFURIC_OBSIDIAN.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get()).add(BlockRegistry.VENUS_REDSTONE_ORE.get()).add(BlockRegistry.VENUS_BAUXITE_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())

                //MERCURY
                .addTag(TagRegistry.Blocks.MERCURY_STONE)
                .addTag(TagRegistry.Blocks.MERCURY_COBBLESTONE)
                .addTag(TagRegistry.Blocks.MERCURY_DEEPSLATE)
                .addTag(TagRegistry.Blocks.MERCURY_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MERCURY_BAUXITE_ORE.get()).add(BlockRegistry.MERCURY_SULFUR_ORE.get()).add(BlockRegistry.MERCURY_COAL_ORE.get()).add(BlockRegistry.MERCURY_DIAMOND_ORE.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get())

                //JUPITER
                .addTag(TagRegistry.Blocks.JUPITER_DEEPSLATE)
                .addTag(TagRegistry.Blocks.JUPITER_COBBLED_DEEPSLATE)

                //METEOR
                .add(BlockRegistry.METEOR.get())
                .add(BlockRegistry.METEOR_BRICKS.get()).add(BlockRegistry.METEOR_BRICK_SLAB.get()).add(BlockRegistry.METEOR_BRICK_STAIRS.get()).add(BlockRegistry.METEOR_BRICK_WALL.get()).add(BlockRegistry.CHISELED_METEOR_BRICKS.get())
                .add(BlockRegistry.METEOR_COAL_ORE.get()).add(BlockRegistry.METEOR_COPPER_ORE.get()).add(BlockRegistry.METEOR_DIAMOND_ORE.get()).add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get()).add(BlockRegistry.METEOR_IRON_ORE.get()).add(BlockRegistry.METEOR_LAPIS_ORE.get()).add(BlockRegistry.METEOR_REDSTONE_ORE.get()).add(BlockRegistry.METEOR_BAUXITE_ORE.get())

                //MERCURY

                //CERAMIC
                .add(BlockRegistry.CERAMIC.get()).add(BlockRegistry.CERAMIC_TILE.get())
                .addTag(TagRegistry.Blocks.DYED_CERAMIC)
                .addTag(TagRegistry.Blocks.DYED_CERAMIC_TILE)
                .addTag(TagRegistry.Blocks.PAINTED_CERAMIC)
                
                //OTHER
                .add(BlockRegistry.BAUXITE_ORE.get()).add(BlockRegistry.STEEL_BLOCK.get()).add(BlockRegistry.ALUMINUM_BLOCK.get())
                .add(BlockRegistry.COMPRESSED_COBBLESTONE.get()).add(BlockRegistry.SUPER_COMPRESSED_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get()).add(BlockRegistry.SUPER_COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_NETHERRACK.get()).add(BlockRegistry.SUPER_COMPRESSED_NETHERRACK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.MOON_IRON_ORE.get()).add(BlockRegistry.MOON_BAUXITE_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get()).add(BlockRegistry.MARS_BAUXITE_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get()).add(BlockRegistry.VENUS_BAUXITE_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get()).add(BlockRegistry.METEOR_BAUXITE_ORE.get())
                .add(BlockRegistry.MERCURY_BAUXITE_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MERCURY_COAL_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get())
                .add(BlockRegistry.BAUXITE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get()).add(BlockRegistry.VENUS_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get()).add(BlockRegistry.METEOR_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_EMERALD_ORE.get()).add(BlockRegistry.METEOR_GOLD_ORE.get()).add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MERCURY_DIAMOND_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get())
                .add(BlockRegistry.MERCURY_SULFUR_ORE.get())
                .add(BlockRegistry.METEOR_SULFUR_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.SULFURIC_OBSIDIAN.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.MOON_SAND.get()).add(BlockRegistry.GLOWING_MOON_SAND.get()).add(BlockRegistry.COARSE_MOON_SAND.get())
                .add(BlockRegistry.MARS_SAND.get()).add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get()).add(BlockRegistry.FINE_VENUS_SAND.get())
                .add(BlockRegistry.MERCURY_SAND.get()).add(BlockRegistry.COARSE_MERCURY_SAND.get());

        //ORES
        tag(BlockTags.COAL_ORES)
                .add(BlockRegistry.METEOR_COAL_ORE.get())
                .add(BlockRegistry.MERCURY_COAL_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get());

        tag(BlockTags.COPPER_ORES)
                .add(BlockRegistry.METEOR_COPPER_ORE.get());

        tag(BlockTags.DIAMOND_ORES)
                .add(BlockRegistry.MERCURY_DIAMOND_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get());

        tag(BlockTags.EMERALD_ORES)
                .add(BlockRegistry.METEOR_EMERALD_ORE.get());

        tag(BlockTags.GOLD_ORES)
                .add(BlockRegistry.METEOR_GOLD_ORE.get());

        tag(BlockTags.LAPIS_ORES)
                .add(BlockRegistry.METEOR_LAPIS_ORE.get())
                .add(BlockRegistry.VENUS_LAPIS_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get());

        tag(BlockTags.IRON_ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.MARS_IRON_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.VENUS_IRON_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get());

        tag(BlockTags.LAPIS_ORES)
                .add(BlockRegistry.METEOR_LAPIS_ORE.get());

        tag(BlockTags.REDSTONE_ORES)
                .add(BlockRegistry.MOON_REDSTONE_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MARS_REDSTONE_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.VENUS_REDSTONE_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get());

        //SAND, DIRT, ETC.
        tag(BlockTags.SAND)
                .add(BlockRegistry.MOON_SAND.get()).add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get()).add(BlockRegistry.FINE_VENUS_SAND.get())
                .add(BlockRegistry.MERCURY_SAND.get())
                .add(BlockRegistry.GLOWING_EUROPA_SAND.get());

        //SLABS, STAIRS, WALLS
        tag(BlockTags.SLABS)
                .add(BlockRegistry.MOON_STONE_SLAB.get()).add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get()).add(BlockRegistry.MOON_BRICK_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_SLAB.get()).add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.MARS_STONE_SLAB.get()).add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get()).add(BlockRegistry.MARS_BRICK_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_SLAB.get()).add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.VENUS_STONE_SLAB.get()).add(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get()).add(BlockRegistry.VENUS_BRICK_SLAB.get()).add(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.MERCURY_STONE_SLAB.get()).add(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get()).add(BlockRegistry.MERCURY_BRICK_SLAB.get())
                .add(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get()).add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get())

                .add(BlockRegistry.EUROPA_BRICK_SLAB.get())

                .add(BlockRegistry.METEOR_BRICK_SLAB.get());

        tag(BlockTags.STAIRS)
                .add(BlockRegistry.MOON_STONE_STAIRS.get()).add(BlockRegistry.MOON_BRICK_STAIRS.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get())

                .add(BlockRegistry.MARS_STONE_STAIRS.get()).add(BlockRegistry.MARS_BRICK_STAIRS.get())
                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get())

                .add(BlockRegistry.VENUS_STONE_STAIRS.get()).add(BlockRegistry.VENUS_BRICK_STAIRS.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.SMALL_VENUS_BRICK_STAIRS.get())


                .add(BlockRegistry.MERCURY_STONE_STAIRS.get()).add(BlockRegistry.MERCURY_BRICK_STAIRS.get())
                .add(BlockRegistry.MERCURY_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_STAIRS.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_STAIRS.get())

                .add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_STAIRS.get())

                .add(BlockRegistry.EUROPA_BRICK_STAIRS.get())

                .add(BlockRegistry.METEOR_BRICK_STAIRS.get());

        tag(BlockTags.WALLS)
                .add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.MOON_COBBLESTONE_WALL.get()).add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.MARS_COBBLESTONE_WALL.get()).add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.VENUS_BRICK_WALL.get()).add(BlockRegistry.SMALL_VENUS_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_WALL.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.MERCURY_BRICK_WALL.get())
                .add(BlockRegistry.MERCURY_COBBLESTONE_WALL.get()).add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_WALL.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_WALL.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_WALL.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_WALL.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_WALL.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_WALL.get())

                .add(BlockRegistry.METEOR_BRICK_WALL.get())

                .add(BlockRegistry.EUROPA_BRICK_WALL.get())

                .add(BlockRegistry.PANEL_WALL.get());

        //OPENABLE THINGS
        tag(BlockTags.DOORS)
                .add(BlockRegistry.AIRLOCK_DOOR.get())
                .add(BlockRegistry.STEEL_DOOR.get());

        tag(BlockTags.TRAPDOORS)
                .add(BlockRegistry.STEEL_TRAPDOOR.get())
                .add(BlockRegistry.AIRLOCK_TRAPDOOR.get());

        //BUTTONS, PRESSURE PLATES
        tag(BlockTags.BUTTONS)
                .add(BlockRegistry.MOON_STONE_BUTTON.get()).add(BlockRegistry.MOON_DEEPSLATE_BUTTON.get())
                .add(BlockRegistry.MARS_STONE_BUTTON.get()).add(BlockRegistry.MARS_DEEPSLATE_BUTTON.get())
                .add(BlockRegistry.VENUS_STONE_BUTTON.get()).add(BlockRegistry.VENUS_DEEPSLATE_BUTTON.get())
                .add(BlockRegistry.METEOR_BUTTON.get())
                .add(BlockRegistry.MERCURY_STONE_BUTTON.get()).add(BlockRegistry.MERCURY_DEEPSLATE_BUTTON.get())

                .add(BlockRegistry.RED_BUTTON.get()).add(BlockRegistry.YELLOW_BUTTON.get()).add(BlockRegistry.BLUE_BUTTON.get())
                .add(BlockRegistry.GREEN_BUTTON.get()).add(BlockRegistry.WHITE_BUTTON.get()).add(BlockRegistry.BLACK_BUTTON.get())

                .add(BlockRegistry.STEEL_BUTTON.get())
                .add(BlockRegistry.AIRLOCK_BUTTON.get());

        tag(BlockTags.PRESSURE_PLATES)
                .add(BlockRegistry.MOON_STONE_PRESSURE_PLATE.get()).add(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE.get())
                .add(BlockRegistry.MARS_STONE_PRESSURE_PLATE.get()).add(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE.get())
                .add(BlockRegistry.VENUS_STONE_PRESSURE_PLATE.get()).add(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE.get())
                .add(BlockRegistry.MERCURY_STONE_PRESSURE_PLATE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_PRESSURE_PLATE.get())
                .add(BlockRegistry.JUPITER_DEEPSLATE_PRESSURE_PLATE.get())
                .add(BlockRegistry.METEOR_PRESSURE_PLATE.get());

        //OTHER
        tag(BlockTags.CLIMBABLE)
                .add(BlockRegistry.STEEL_FRAME.get())
                .add(BlockRegistry.STEEL_LADDER.get());

        tag(BlockTags.UNSTABLE_BOTTOM_CENTER)
                .add(BlockRegistry.STEEL_FRAME.get());

        tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(BlockRegistry.VENUS_SAND.get()).add(BlockRegistry.FINE_VENUS_SAND.get())
                .add(BlockRegistry.VENUS_STONE.get()).add(BlockRegistry.VENUS_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_COBBLESTONE.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.METEOR_SULFUR_ORE.get())
                .add(BlockRegistry.GEYSER.get());

        tag(BlockTags.PORTALS)
                .add(BlockRegistry.MARS_PORTAL.get()).add(BlockRegistry.MOON_PORTAL.get())
                .add(BlockRegistry.VENUS_PORTAL.get()).add(BlockRegistry.MERCURY_PORTAL.get())
                .add(BlockRegistry.JUPITER_PORTAL.get()).add(BlockRegistry.EUROPA_PORTAL.get());

        //---- FORGE TAGS.BLOCKS -------------------------------------------------------------------------------
        //TOOLS

        //ORES
        tag(Tags.Blocks.ORES)
                .add(BlockRegistry.MOON_IRON_ORE.get()).add(BlockRegistry.MOON_REDSTONE_ORE.get()).add(BlockRegistry.MOON_BAUXITE_ORE.get())
                .add(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.MARS_IRON_ORE.get()).add(BlockRegistry.MARS_REDSTONE_ORE.get()).add(BlockRegistry.MARS_BAUXITE_ORE.get())
                .add(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get())

                .add(BlockRegistry.VENUS_REDSTONE_ORE.get()).add(BlockRegistry.VENUS_IRON_ORE.get()).add(BlockRegistry.VENUS_LAPIS_ORE.get()).add(BlockRegistry.VENUS_BAUXITE_ORE.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get()).add(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get())

                .add(BlockRegistry.METEOR_COAL_ORE.get()).add(BlockRegistry.METEOR_COPPER_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get()).add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_GOLD_ORE.get()).add(BlockRegistry.METEOR_IRON_ORE.get())
                .add(BlockRegistry.METEOR_LAPIS_ORE.get()).add(BlockRegistry.METEOR_REDSTONE_ORE.get())
                .add(BlockRegistry.METEOR_BAUXITE_ORE.get())

                .add(BlockRegistry.MERCURY_BAUXITE_ORE.get())
                .add(BlockRegistry.MERCURY_COAL_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get())
                .add(BlockRegistry.MERCURY_DIAMOND_ORE.get()).add(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get())

                .add(BlockRegistry.BAUXITE_ORE.get());

        //TODO
        tag(Tags.Blocks.ORE_RATES_DENSE);
        tag(Tags.Blocks.ORE_RATES_SINGULAR);
        tag(Tags.Blocks.ORE_RATES_SPARSE);

        //SAND, DIRT, ETC.
        tag(Tags.Blocks.SAND)
                .add(BlockRegistry.MOON_SAND.get()).add(BlockRegistry.GLOWING_MOON_SAND.get())
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.VENUS_SAND.get()).add(BlockRegistry.FINE_VENUS_SAND.get())
                .add(BlockRegistry.MERCURY_SAND.get());

        //GLASS
        tag(Tags.Blocks.GLASS)
                .add(BlockRegistry.REINFORCED_GLASS.get())
                .add(BlockRegistry.LUMINOUS_BLUE_GLASS.get())
                .add(BlockRegistry.LUMINOUS_CYAN_GLASS.get())
                .add(BlockRegistry.LUMINOUS_WHITE_GLASS.get());

        tag(Tags.Blocks.GLASS_PANES)
                .add(BlockRegistry.REINFORCED_GLASS_PANE.get())
                .add(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get()).add(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get()).add(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get());


        //---- MOON -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.MOON_STONE)
                .add(BlockRegistry.MOON_STONE.get()).add(BlockRegistry.MOON_STONE_SLAB.get())
                .add(BlockRegistry.MOON_SMOOTH_STONE.get()).add(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.MOON_BRICKS.get()).add(BlockRegistry.MOON_BRICK_SLAB.get()).add(BlockRegistry.MOON_BRICK_STAIRS.get()).add(BlockRegistry.MOON_BRICK_WALL.get())
                .add(BlockRegistry.CHISELED_MOON_BRICKS.get()).add(BlockRegistry.MOON_BRICK_PILLAR.get()).add(BlockRegistry.CRACKED_MOON_BRICKS.get());

        tag(TagRegistry.Blocks.MOON_COBBLESTONE)
                .add(BlockRegistry.MOON_COBBLESTONE.get()).add(BlockRegistry.MOON_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MOON_COBBLESTONE_WALL.get());

        tag(TagRegistry.Blocks.MOON_DEEPSLATE)
                .add(BlockRegistry.MOON_DEEPSLATE.get()).add(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get()).add(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES.get()).add(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MOON_DEEPSLATE_BRICKS.get()).add(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MOON_DEEPSLATE_TILES.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MOON_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MOON_POLISHED_DEEPSLATE.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.MOON_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get()).add(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL.get());
        
        //---- MARS -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.MARS_STONE)
                .add(BlockRegistry.MARS_STONE.get()).add(BlockRegistry.MARS_STONE_SLAB.get())
                .add(BlockRegistry.MARS_SMOOTH_STONE.get()).add(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.MARS_BRICKS.get()).add(BlockRegistry.MARS_BRICK_SLAB.get()).add(BlockRegistry.MARS_BRICK_STAIRS.get()).add(BlockRegistry.MARS_BRICK_WALL.get())
                .add(BlockRegistry.CHISELED_MARS_BRICKS.get()).add(BlockRegistry.MARS_BRICK_PILLAR.get()).add(BlockRegistry.CRACKED_MARS_BRICKS.get());

        tag(TagRegistry.Blocks.MARS_COBBLESTONE)
                .add(BlockRegistry.MARS_COBBLESTONE.get()).add(BlockRegistry.MARS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MARS_COBBLESTONE_WALL.get());

        tag(TagRegistry.Blocks.MARS_DEEPSLATE)
                .add(BlockRegistry.MARS_DEEPSLATE.get()).add(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS.get()).add(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES.get()).add(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MARS_DEEPSLATE_BRICKS.get()).add(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MARS_DEEPSLATE_TILES.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MARS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MARS_POLISHED_DEEPSLATE.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.MARS_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get()).add(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL.get());
        
        //---- VENUS -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.VENUS_STONE)
                .add(BlockRegistry.VENUS_STONE.get()).add(BlockRegistry.VENUS_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_SMOOTH_STONE.get()).add(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.VENUS_BRICKS.get()).add(BlockRegistry.VENUS_BRICK_SLAB.get()).add(BlockRegistry.VENUS_BRICK_STAIRS.get()).add(BlockRegistry.VENUS_BRICK_WALL.get())
                .add(BlockRegistry.CHISELED_VENUS_BRICKS.get()).add(BlockRegistry.VENUS_BRICK_PILLAR.get()).add(BlockRegistry.CRACKED_VENUS_BRICKS.get());

        tag(TagRegistry.Blocks.VENUS_COBBLESTONE)
                .add(BlockRegistry.VENUS_COBBLESTONE.get()).add(BlockRegistry.VENUS_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLESTONE_STAIRS.get()).add(BlockRegistry.VENUS_COBBLESTONE_WALL.get());

        tag(TagRegistry.Blocks.VENUS_DEEPSLATE)
                .add(BlockRegistry.VENUS_DEEPSLATE.get()).add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS.get()).add(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES.get()).add(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_BRICKS.get()).add(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.VENUS_DEEPSLATE_TILES.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.VENUS_POLISHED_DEEPSLATE.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.VENUS_COBBLED_DEEPSLATE)
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL.get());
        
        //---- MERCURY -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.MERCURY_STONE)
                .add(BlockRegistry.MERCURY_STONE.get()).add(BlockRegistry.MERCURY_STONE_SLAB.get())
                .add(BlockRegistry.MERCURY_SMOOTH_STONE.get()).add(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get())
                .add(BlockRegistry.MERCURY_BRICKS.get()).add(BlockRegistry.MERCURY_BRICK_SLAB.get()).add(BlockRegistry.MERCURY_BRICK_STAIRS.get()).add(BlockRegistry.MERCURY_BRICK_WALL.get())
                .add(BlockRegistry.CHISELED_MERCURY_BRICKS.get()).add(BlockRegistry.MERCURY_BRICK_PILLAR.get()).add(BlockRegistry.CRACKED_MERCURY_BRICKS.get());

        tag(TagRegistry.Blocks.MERCURY_COBBLESTONE)
                .add(BlockRegistry.MERCURY_COBBLESTONE.get()).add(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get())
                .add(BlockRegistry.MERCURY_COBBLESTONE_STAIRS.get()).add(BlockRegistry.MERCURY_COBBLESTONE_WALL.get());

        tag(TagRegistry.Blocks.MERCURY_DEEPSLATE)
                .add(BlockRegistry.MERCURY_DEEPSLATE.get()).add(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_BRICKS.get()).add(BlockRegistry.CRACKED_MERCURY_DEEPSLATE_TILES.get()).add(BlockRegistry.CHISELED_MERCURY_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_BRICKS.get()).add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.MERCURY_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.MERCURY_DEEPSLATE_TILES.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.MERCURY_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.MERCURY_COBBLED_DEEPSLATE)
                .add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get()).add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_WALL.get());

        //---- JUPITER -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.JUPITER_DEEPSLATE)
                .add(BlockRegistry.JUPITER_DEEPSLATE.get()).add(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get()).add(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_TILES.get()).add(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get())
                .add(BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get()).add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get()).add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_STAIRS.get()).add(BlockRegistry.JUPITER_DEEPSLATE_BRICK_WALL.get())
                .add(BlockRegistry.JUPITER_DEEPSLATE_TILES.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_STAIRS.get()).add(BlockRegistry.JUPITER_DEEPSLATE_TILE_WALL.get())
                .add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.JUPITER_COBBLED_DEEPSLATE)
                .add(BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get()).add(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get())
                .add(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_STAIRS.get()).add(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_WALL.get());

        tag(TagRegistry.Blocks.EUROPA_BRICKS)
                .add(BlockRegistry.EUROPA_BRICKS.get());

        //---- METEOR -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.METEOR)
                .add(BlockRegistry.METEOR.get())
                .add(BlockRegistry.METEOR_BRICKS.get()).add(BlockRegistry.METEOR_BRICK_SLAB.get()).add(BlockRegistry.METEOR_BRICK_STAIRS.get()).add(BlockRegistry.METEOR_BRICK_WALL.get())
                .add(BlockRegistry.CHISELED_METEOR_BRICKS.get())
                .add(BlockRegistry.METEOR_IRON_ORE.get()).add(BlockRegistry.METEOR_REDSTONE_ORE.get()).add(BlockRegistry.METEOR_GOLD_ORE.get())
                .add(BlockRegistry.METEOR_DIAMOND_ORE.get()).add(BlockRegistry.METEOR_LAPIS_ORE.get()).add(BlockRegistry.METEOR_EMERALD_ORE.get())
                .add(BlockRegistry.METEOR_COPPER_ORE.get()).add(BlockRegistry.METEOR_COAL_ORE.get());

        //---- GLASS -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.CONNECTED_GLASS).add(BlockRegistry.REINFORCED_GLASS.get());

        tag(TagRegistry.Blocks.CONNECTED_GLASS_PANE).add(BlockRegistry.REINFORCED_GLASS_PANE.get());

        //---- CERAMIC -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.DYED_CERAMIC)
                .add(BlockRegistry.WHITE_CERAMIC.get()).add(BlockRegistry.LIGHT_GREY_CERAMIC.get()).add(BlockRegistry.GREY_CERAMIC.get()).add(BlockRegistry.BLACK_CERAMIC.get())
                .add(BlockRegistry.PURPLE_CERAMIC.get()).add(BlockRegistry.MAGENTA_CERAMIC.get()).add(BlockRegistry.BLUE_CERAMIC.get()).add(BlockRegistry.LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.CYAN_CERAMIC.get()).add(BlockRegistry.GREEN_CERAMIC.get()).add(BlockRegistry.LIME_CERAMIC.get()).add(BlockRegistry.YELLOW_CERAMIC.get())
                .add(BlockRegistry.ORANGE_CERAMIC.get()).add(BlockRegistry.BROWN_CERAMIC.get()).add(BlockRegistry.RED_CERAMIC.get()).add(BlockRegistry.PINK_CERAMIC.get());

        tag(TagRegistry.Blocks.DYED_CERAMIC_TILE)
                .add(BlockRegistry.WHITE_CERAMIC_TILE.get()).add(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get()).add(BlockRegistry.GREY_CERAMIC_TILE.get()).add(BlockRegistry.BLACK_CERAMIC_TILE.get())
                .add(BlockRegistry.PURPLE_CERAMIC_TILE.get()).add(BlockRegistry.MAGENTA_CERAMIC_TILE.get()).add(BlockRegistry.BLUE_CERAMIC_TILE.get()).add(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get())
                .add(BlockRegistry.CYAN_CERAMIC_TILE.get()).add(BlockRegistry.GREEN_CERAMIC_TILE.get()).add(BlockRegistry.LIME_CERAMIC_TILE.get()).add(BlockRegistry.YELLOW_CERAMIC_TILE.get())
                .add(BlockRegistry.ORANGE_CERAMIC_TILE.get()).add(BlockRegistry.BROWN_CERAMIC_TILE.get()).add(BlockRegistry.RED_CERAMIC_TILE.get()).add(BlockRegistry.PINK_CERAMIC_TILE.get());

        tag(TagRegistry.Blocks.PAINTED_CERAMIC)
                .add(BlockRegistry.PAINTED_WHITE_CERAMIC.get()).add(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get()).add(BlockRegistry.PAINTED_GREY_CERAMIC.get()).add(BlockRegistry.PAINTED_BLACK_CERAMIC.get())
                .add(BlockRegistry.PAINTED_PURPLE_CERAMIC.get()).add(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get()).add(BlockRegistry.PAINTED_BLUE_CERAMIC.get()).add(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get())
                .add(BlockRegistry.PAINTED_CYAN_CERAMIC.get()).add(BlockRegistry.PAINTED_GREEN_CERAMIC.get()).add(BlockRegistry.PAINTED_LIME_CERAMIC.get()).add(BlockRegistry.PAINTED_YELLOW_CERAMIC.get())
                .add(BlockRegistry.PAINTED_ORANGE_CERAMIC.get()).add(BlockRegistry.PAINTED_BROWN_CERAMIC.get()).add(BlockRegistry.PAINTED_RED_CERAMIC.get()).add(BlockRegistry.PAINTED_PINK_CERAMIC.get());
        
        //---- MISCELLANEOUS -------------------------------------------------------------------------------
        tag(TagRegistry.Blocks.REGOLITH)
                .add(BlockRegistry.MOON_SAND.get()).add(BlockRegistry.MARS_SAND.get()).add(BlockRegistry.VENUS_SAND.get()).add(BlockRegistry.MERCURY_SAND.get());

        tag(TagRegistry.Blocks.MAG_RAIL)
                .add(BlockRegistry.MAG_RAIL.get()).add(BlockRegistry.POWERED_MAG_RAIL.get()).add(BlockRegistry.DETECTOR_MAG_RAIL.get()).add(BlockRegistry.ACTIVATOR_MAG_RAIL.get());

        tag(TagRegistry.Blocks.MOON_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.MOON_BRICKS.get());

        tag(TagRegistry.Blocks.MARS_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.MARS_BRICKS.get());

        tag(TagRegistry.Blocks.VENUS_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.VENUS_BRICKS.get());

        tag(TagRegistry.Blocks.MERCURY_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.MERCURY_BRICKS.get());

        tag(TagRegistry.Blocks.JUPITER_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get());

        tag(TagRegistry.Blocks.EUROPA_PORTAL_FRAME_BLOCK)
                .add(BlockRegistry.EUROPA_BRICKS.get());


        tag(TagRegistry.Blocks.BAUXITE_ORE)
                .add(BlockRegistry.BAUXITE_ORE.get())
                .add(BlockRegistry.MOON_BAUXITE_ORE.get())
                .add(BlockRegistry.MARS_BAUXITE_ORE.get())
                .add(BlockRegistry.VENUS_BAUXITE_ORE.get())
                .add(BlockRegistry.MERCURY_BAUXITE_ORE.get())
                .add(BlockRegistry.METEOR_BAUXITE_ORE.get());

        tag(TagRegistry.Blocks.NO_SNOW)
                .add(BlockRegistry.MARS_SAND.get())
                .add(BlockRegistry.MARS_STONE.get())
                .add(BlockRegistry.COARSE_MARS_SAND.get())
                .add(BlockRegistry.MOON_SAND.get())
                .add(BlockRegistry.MOON_STONE.get())
                .add(BlockRegistry.COARSE_MOON_SAND.get())
                .add(BlockRegistry.MERCURY_SAND.get())
                .add(BlockRegistry.MERCURY_STONE.get())
                .add(BlockRegistry.COARSE_MERCURY_SAND.get());

        tag(TagRegistry.Blocks.COMPRESSIBLE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(Blocks.NETHERRACK)
                .add(BlockRegistry.COMPRESSED_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_NETHERRACK.get())
                .add(BlockRegistry.MOON_COBBLESTONE.get())
                .add(BlockRegistry.MOON_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_MOON_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MARS_COBBLESTONE.get())
                .add(BlockRegistry.MARS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_MARS_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.VENUS_COBBLESTONE.get())
                .add(BlockRegistry.VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.MERCURY_COBBLESTONE.get())
                .add(BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get())
                .add(BlockRegistry.COMPRESSED_MERCURY_COBBLESTONE.get())
                .add(BlockRegistry.COMPRESSED_MERCURY_COBBLED_DEEPSLATE.get());

    }

    @Override
    public @NotNull String getName() {
        return "Celestial Exploration tags";

    }
}
