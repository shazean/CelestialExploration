package com.shim.celestialexploration.registry;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;


import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.blocks.*;
import com.shim.celestialexploration.events.ModEventBusEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.block.Blocks.OAK_PLANKS;


public class BlockRegistry {

    private BlockState defaultState;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CelestialExploration.MODID);

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }

	/**
     * ~~BLOCKS~~
     * LUNAR BLOCKS
     * FULL BLOCKS
     **/
    public static final RegistryObject<Block> MOON_SAND = BLOCKS.register("moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GLOWING_MOON_SAND = BLOCKS.register("glowing_moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((p_235455_0_) -> {
        return 2;
    })));
    public static final RegistryObject<Block> MOON_STONE = BLOCKS.register("moon_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_SMOOTH_STONE = BLOCKS.register("moon_smooth_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_BRICKS = BLOCKS.register("moon_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_BRICK_PILLAR = BLOCKS.register("moon_brick_pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MOON_BRICKS.get())));
    public static final RegistryObject<Block> CHISELED_MOON_BRICKS = BLOCKS.register("chiseled_moon_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MOON_BRICKS = BLOCKS.register("cracked_moon_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_IRON_ORE = BLOCKS.register("moon_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_REDSTONE_ORE = BLOCKS.register("moon_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_COBBLESTONE = BLOCKS.register("moon_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_DEEPSLATE = BLOCKS.register("moon_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICKS = BLOCKS.register("moon_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_MOON_DEEPSLATE_BRICKS = BLOCKS.register("chiseled_moon_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MOON_DEEPSLATE_BRICKS = BLOCKS.register("cracked_moon_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILES = BLOCKS.register("moon_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MOON_DEEPSLATE_TILES = BLOCKS.register("cracked_moon_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE = BLOCKS.register("moon_polished_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE = BLOCKS.register("moon_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_DEEPSLATE_IRON_ORE = BLOCKS.register("moon_deepslate_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_DEEPSLATE_REDSTONE_ORE = BLOCKS.register("moon_deepslate_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> LUNAR_LANTERN = BLOCKS.register("lunar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> {
        return 12;
    })));
    //STAIRS
    public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new StairBlock(MOON_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_BRICKS.get())));
    public static final RegistryObject<Block> MOON_COBBLESTONE_STAIRS = BLOCKS.register("moon_cobblestone_stairs", () -> new StairBlock(MOON_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLESTONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("moon_deepslate_brick_stairs", () -> new StairBlock(MOON_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILE_STAIRS = BLOCKS.register("moon_deepslate_tile_stairs", () -> new StairBlock(MOON_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("moon_polished_deepslate_stairs", () -> new StairBlock(MOON_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("moon_cobbled_deepslate_stairs", () -> new StairBlock(MOON_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())));
    //SLAB
    public static final RegistryObject<Block> MOON_STONE_SLAB = BLOCKS.register("moon_stone_slab", () -> new SlabBlock(Block.Properties.copy(MOON_STONE.get())));
    //    public static final RegistryObject<Block> MOON_SMOOTH_STONE_SLAB = BLOCKS.register("moon_smooth_stone_slab", () -> new SlabBlock(Block.Properties.copy(MOON_SMOOTH_STONE.get())));
    public static final RegistryObject<Block> MOON_BRICK_SLAB = BLOCKS.register("moon_brick_slab", () -> new SlabBlock(Block.Properties.copy(MOON_BRICKS.get())));
    public static final RegistryObject<Block> MOON_COBBLESTONE_SLAB = BLOCKS.register("moon_cobblestone_slab", () -> new SlabBlock(Block.Properties.copy(MOON_COBBLESTONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICK_SLAB = BLOCKS.register("moon_deepslate_brick_slab", () -> new SlabBlock(Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE_SLAB = BLOCKS.register("moon_cobbled_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILE_SLAB = BLOCKS.register("moon_deepslate_tile_slab", () -> new SlabBlock(Block.Properties.copy(MOON_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE_SLAB = BLOCKS.register("moon_polished_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())));

    //WALL
    public static final RegistryObject<Block> MOON_BRICK_WALL = BLOCKS.register("moon_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOON_COBBLESTONE_WALL = BLOCKS.register("moon_cobblestone_wall", () -> new WallBlock(Block.Properties.copy(MOON_COBBLESTONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICK_WALL = BLOCKS.register("moon_deepslate_brick_wall", () -> new WallBlock(Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE_WALL = BLOCKS.register("moon_cobbled_deepslate_wall", () -> new WallBlock(Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILE_WALL = BLOCKS.register("moon_deepslate_tile_wall", () -> new WallBlock(Block.Properties.copy(MOON_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE_WALL = BLOCKS.register("moon_polished_deepslate_wall", () -> new WallBlock(Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())));

    //BUTTON
    public static final RegistryObject<Block> MOON_STONE_BUTTON = BLOCKS.register("moon_stone_button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_STONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BUTTON = BLOCKS.register("moon_deepslate_button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_DEEPSLATE.get())));

    //PRESSURE PLATE
    public static final RegistryObject<Block> MOON_STONE_PRESSURE_PLATE = BLOCKS.register("moon_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_STONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_PRESSURE_PLATE = BLOCKS.register("moon_deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_DEEPSLATE.get())));


    /**
     * MARTIAN BLOCKS
     **/
    public static final RegistryObject<Block> MARS_SAND = BLOCKS.register("mars_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    //	public static final RegistryObject<Block> MARS_SOIL = BLOCKS.register("mars_soil", () -> new MarsFarmlandBlock(Block.Properties.of(Material.DIRT).strength(0.6f).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> MARS_STONE = BLOCKS.register("mars_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_SMOOTH_STONE = BLOCKS.register("mars_smooth_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_BRICKS = BLOCKS.register("mars_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_BRICK_PILLAR = BLOCKS.register("mars_brick_pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MARS_BRICKS.get())));
    public static final RegistryObject<Block> CHISELED_MARS_BRICKS = BLOCKS.register("chiseled_mars_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MARS_BRICKS = BLOCKS.register("cracked_mars_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_IRON_ORE = BLOCKS.register("mars_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_REDSTONE_ORE = BLOCKS.register("mars_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_COBBLESTONE = BLOCKS.register("mars_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_DEEPSLATE = BLOCKS.register("mars_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICKS = BLOCKS.register("mars_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_MARS_DEEPSLATE_BRICKS = BLOCKS.register("chiseled_mars_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MARS_DEEPSLATE_BRICKS = BLOCKS.register("cracked_mars_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE = BLOCKS.register("mars_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILES = BLOCKS.register("mars_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_MARS_DEEPSLATE_TILES = BLOCKS.register("cracked_mars_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE = BLOCKS.register("mars_polished_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_DEEPSLATE_IRON_ORE = BLOCKS.register("mars_deepslate_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_DEEPSLATE_REDSTONE_ORE = BLOCKS.register("mars_deepslate_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    //STAIRS
    public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new StairBlock(MARS_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLESTONE_STAIRS = BLOCKS.register("mars_cobblestone_stairs", () -> new StairBlock(MARS_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLESTONE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("mars_deepslate_brick_stairs", () -> new StairBlock(MARS_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("mars_cobbled_deepslate_stairs", () -> new StairBlock(MARS_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILE_STAIRS = BLOCKS.register("mars_deepslate_tile_stairs", () -> new StairBlock(MARS_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("mars_polished_deepslate_stairs", () -> new StairBlock(MARS_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())));

    //SLAB
    public static final RegistryObject<Block> MARS_STONE_SLAB = BLOCKS.register("mars_stone_slab", () -> new SlabBlock(Block.Properties.copy(MARS_STONE.get())));
    //    public static final RegistryObject<Block> MARS_SMOOTH_STONE_SLAB = BLOCKS.register("mars_smooth_stone_slab", () -> new SlabBlock(Block.Properties.copy(MARS_SMOOTH_STONE.get())));
    public static final RegistryObject<Block> MARS_BRICK_SLAB = BLOCKS.register("mars_brick_slab", () -> new SlabBlock(Block.Properties.copy(MARS_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLESTONE_SLAB = BLOCKS.register("mars_cobblestone_slab", () -> new SlabBlock(Block.Properties.copy(MARS_COBBLESTONE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICK_SLAB = BLOCKS.register("mars_deepslate_brick_slab", () -> new SlabBlock(Block.Properties.copy(MARS_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE_SLAB = BLOCKS.register("mars_cobbled_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILE_SLAB = BLOCKS.register("mars_deepslate_tile_slab", () -> new SlabBlock(Block.Properties.copy(MARS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE_SLAB = BLOCKS.register("mars_polished_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())));

    //WALL
    public static final RegistryObject<Block> MARS_BRICK_WALL = BLOCKS.register("mars_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_COBBLESTONE_WALL = BLOCKS.register("mars_cobblestone_wall", () -> new WallBlock(Block.Properties.copy(MARS_COBBLESTONE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICK_WALL = BLOCKS.register("mars_deepslate_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE_WALL = BLOCKS.register("mars_cobbled_deepslate_wall", () -> new WallBlock(Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILE_WALL = BLOCKS.register("mars_deepslate_tile_wall", () -> new WallBlock(Block.Properties.copy(MARS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE_WALL = BLOCKS.register("mars_polished_deepslate_wall", () -> new WallBlock(Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())));

    //BUTTON
    public static final RegistryObject<Block> MARS_STONE_BUTTON = BLOCKS.register("mars_stone_button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_STONE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BUTTON = BLOCKS.register("mars_deepslate_button", () -> new StoneButtonBlock(Block.Properties.copy(MARS_DEEPSLATE.get())));

    //PRESSURE PLATE
    public static final RegistryObject<Block> MARS_DEEPSLATE_PRESSURE_PLATE = BLOCKS.register("mars_deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MARS_DEEPSLATE.get()).isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MARS_STONE_PRESSURE_PLATE = BLOCKS.register("mars_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_STONE.get()).isValidSpawn(BlockRegistry::never)));

    /**
     * METEOR BLOCKS
     **/
    public static final RegistryObject<Block> METEOR = BLOCKS.register("meteor", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_EMERALD_ORE = BLOCKS.register("meteor_emerald_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_COAL_ORE = BLOCKS.register("meteor_coal_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_GOLD_ORE = BLOCKS.register("meteor_gold_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_IRON_ORE = BLOCKS.register("meteor_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_REDSTONE_ORE = BLOCKS.register("meteor_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_DIAMOND_ORE = BLOCKS.register("meteor_diamond_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_COPPER_ORE = BLOCKS.register("meteor_copper_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_LAPIS_ORE = BLOCKS.register("meteor_lapis_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_BRICKS = BLOCKS.register("meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_METEOR_BRICKS = BLOCKS.register("chiseled_meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new StairBlock(METEOR_BRICKS.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BRICK_WALL = BLOCKS.register("meteor_brick_wall", () -> new WallBlock(Block.Properties.copy(METEOR_BRICKS.get())));
//    public static final RegistryObject<Block> METEOR_BRICK_PILLAR = BLOCKS.register("meteor_brick_pillar", () -> new Block(Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BUTTON = BLOCKS.register("meteor_button", () -> new StoneButtonBlock(Block.Properties.copy(METEOR.get())));
    public static final RegistryObject<Block> METEOR_PRESSURE_PLATE = BLOCKS.register("meteor_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(METEOR.get())));


    //POWER-RELATED BLOCKS
//	public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL = BLOCKS.register("solar_panel", SolarPanelBlock::new);

    /**
     * PORTAL BLOCKS
     **/
    public static final RegistryObject<Block> MARS_PORTAL = BLOCKS.register("mars_portal", MarsPortalBlock::new);
    public static final RegistryObject<Block> MOON_PORTAL = BLOCKS.register("moon_portal", MoonPortalBlock::new);

    /**
     * SHUTTLE BLOCKS
     **/
    public static final RegistryObject<Block> STEEL_FRAME = BLOCKS.register("steel_frame", () -> new SteelFrameBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    //	public static final RegistryObject<Block> LAUNCH_PAD = BLOCKS.register("launch_pad", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<IronBarsBlock> CERAMIC_TILE = BLOCKS.register("ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> CERAMIC = BLOCKS.register("ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> WHITE_CERAMIC = BLOCKS.register("white_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> LIGHT_GREY_CERAMIC = BLOCKS.register("light_grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> GREY_CERAMIC = BLOCKS.register("grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> BLACK_CERAMIC = BLOCKS.register("black_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> PURPLE_CERAMIC = BLOCKS.register("purple_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> MAGENTA_CERAMIC = BLOCKS.register("magenta_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> BLUE_CERAMIC = BLOCKS.register("blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> LIGHT_BLUE_CERAMIC = BLOCKS.register("light_blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> CYAN_CERAMIC = BLOCKS.register("cyan_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> GREEN_CERAMIC = BLOCKS.register("green_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> LIME_CERAMIC = BLOCKS.register("lime_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> YELLOW_CERAMIC = BLOCKS.register("yellow_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> ORANGE_CERAMIC = BLOCKS.register("orange_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> BROWN_CERAMIC = BLOCKS.register("brown_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> RED_CERAMIC = BLOCKS.register("red_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
//	public static final RegistryObject<Block> PINK_CERAMIC = BLOCKS.register("pink_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));


    /**
     * OTHER BLOCKS
     **/
    //	public static final RegistryObject<Block> ASSEMBLY_STATION = BLOCKS.register("assembly_station", () -> new AssemblyStationBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> OXYGEN_COMPRESSOR = BLOCKS.register("oxygen_compressor", () -> new OxygenCompressorBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(3.5F).sound(SoundType.METAL)));
    //	public static final RegistryObject<Block> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(Block.Properties.of(Material.DECORATION, MaterialColor.METAL).noCollission().sound(SoundType.METAL).lightLevel(litBlockEmission(1))));
    public static final RegistryObject<Block> LOX_TANK = BLOCKS.register("lox_tank", () -> new LoxTankBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).noOcclusion().strength(0.5F).sound(SoundType.STONE)));
    //	public static final RegistryObject<Block> SOLAR_LANTERN = BLOCKS.register("solar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
//		return 20;
//	})));
//	public static final RegistryObject<Block> IGNEOUS_ROCK = BLOCKS.register("igneous_rock", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
//	public static final RegistryObject<Block> ECLIPSE_LANTERN = BLOCKS.register("eclipse_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
//		return 8;
//	})));
//	public static final RegistryObject<Block> STEEL_BLOCK_STAIRS = BLOCKS.register("steel_block_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), Block.Properties.copy(STEEL_BLOCK.get())));
//	public static final RegistryObject<Block> STEEL_BLOCK_SLAB = BLOCKS.register("steel_block_slab", () -> new SlabBlock(Block.Properties.copy(STEEL_BLOCK.get())));
	public static final RegistryObject<Block> DRY_ICE = BLOCKS.register("dry_ice", () -> new IceBlock(Block.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
//	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur", () -> new FlowingFluidBlock(RegistryFluids.SULFUR, AbstractBlock.Properties.of(Material.LAVA).noCollission().randomTicks().strength(100.0F).lightLevel((p_235418_0_) -> {
//		return 15;
//	}).noDrops()));
    //	public static final RegistryObject<Block> THICK_CARBON_AIR = BLOCKS.register("thick_carbon_air", () -> new AtmosphereBlock(AbstractBlock.Properties.of(Material.GLASS)
//			.strength(0.3F).sound(SoundType.GLASS).noCollission()//.air()
//			.noOcclusion().isRedstoneConductor(RegistryBlocks::never)
//			.isSuffocating(RegistryBlocks::never).isViewBlocking(RegistryBlocks::never)));


    //LUMINOUS GLASS
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS = BLOCKS.register("luminous_blue_glass", () -> new GlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS = BLOCKS.register("luminous_white_glass", () -> new GlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS_PANE = BLOCKS.register("luminous_blue_glass_pane", () -> new IronBarsBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS_PANE = BLOCKS.register("luminous_white_glass_pane", () -> new IronBarsBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));


    public static final RegistryObject<Block> CONNECTED_GLASS = BLOCKS.register("connected_glass", () -> new ConnectedGlassBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> CONNECTED_GLASS_PANE = BLOCKS.register("connected_glass_pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion()));

    //MOB-RELATED

    public static final RegistryObject<Block> LURKER_HEAD = BLOCKS.register("lurker_head", () -> new SkullBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
    public static final RegistryObject<Block> LURKER_WALL_HEAD = BLOCKS.register("lurker_wall_head", () -> new WallSkullBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).dropsLike(LURKER_HEAD.get())));



    /**
     * ~~CUSTOM BLOCK TAGS~~
     **/
    public static final TagKey<Block> MARS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_tag"));
    public static final TagKey<Block> MARS_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone_tag"));
    public static final TagKey<Block> MARS_COBBLESTONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone_tag"));
    public static final TagKey<Block> MARS_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate_tag"));
    public static final TagKey<Block> MARS_COBBLED_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate_tag"));

    public static final TagKey<Block> MOON_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_tag"));
    public static final TagKey<Block> MOON_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone_tag"));
    public static final TagKey<Block> MOON_COBBLESTONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone_tag"));
    public static final TagKey<Block> MOON_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate_tag"));
    public static final TagKey<Block> MOON_COBBLED_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate_tag"));

    public static final TagKey<Block> METEOR_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_tag"));
    public static final TagKey<Block> METEOR_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_stone_tag"));

    public static final TagKey<Block> CONNECTED_GLASS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass_tag"));
    public static final TagKey<Block> CONNECTED_GLASS_PANE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass_pane_tag"));


    public static final TagKey<Block> MARS_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_portal_frame_block"));
    public static final TagKey<Block> MOON_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_portal_frame_block"));


    public final BlockState getDefaultState() {
        return this.defaultState;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int p_235420_0_) {
        return (p_235421_1_) -> {
            return p_235421_1_.getValue(BlockStateProperties.LIT) ? p_235420_0_ : 0;
        };
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

}