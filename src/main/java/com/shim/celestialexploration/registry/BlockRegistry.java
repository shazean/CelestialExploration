package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;


public class BlockRegistry {

    private BlockState defaultState;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CelestialExploration.MODID);

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }

	/*
     * ~~BLOCKS~~
     * LUNAR BLOCKS
     * FULL BLOCKS
     */
    public static final RegistryObject<Block> MOON_CORE = BLOCKS.register("moon_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    public static final RegistryObject<Block> MOON_SAND = BLOCKS.register("moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> GLOWING_MOON_SAND = BLOCKS.register("glowing_moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((p_235455_0_) -> {
        return 2;
    })));
    public static final RegistryObject<Block> COARSE_MOON_SAND = BLOCKS.register("coarse_moon_sand", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
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
        return 13;
    })));
    public static final RegistryObject<Block> COMPRESSED_MOON_COBBLESTONE = BLOCKS.register("compressed_moon_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COMPRESSED_MOON_COBBLED_DEEPSLATE = BLOCKS.register("compressed_moon_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));

    //STAIRS
    public static final RegistryObject<Block> MOON_STONE_STAIRS = BLOCKS.register("moon_stone_stairs", () -> new StairBlock(MOON_STONE.get().defaultBlockState(), Block.Properties.copy(MOON_STONE.get())));
    public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new StairBlock(MOON_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_BRICKS.get())));
    public static final RegistryObject<Block> MOON_COBBLESTONE_STAIRS = BLOCKS.register("moon_cobblestone_stairs", () -> new StairBlock(MOON_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLESTONE.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("moon_deepslate_brick_stairs", () -> new StairBlock(MOON_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILE_STAIRS = BLOCKS.register("moon_deepslate_tile_stairs", () -> new StairBlock(MOON_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("moon_polished_deepslate_stairs", () -> new StairBlock(MOON_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("moon_cobbled_deepslate_stairs", () -> new StairBlock(MOON_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())));

    //SLAB
    public static final RegistryObject<Block> MOON_STONE_SLAB = BLOCKS.register("moon_stone_slab", () -> new SlabBlock(Block.Properties.copy(MOON_STONE.get())));
    public static final RegistryObject<Block> MOON_SMOOTH_STONE_SLAB = BLOCKS.register("moon_smooth_stone_slab", () -> new SlabBlock(Block.Properties.copy(MOON_SMOOTH_STONE.get())));
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


    /*
     * MARTIAN BLOCKS
     */
    public static final RegistryObject<Block> MARS_CORE = BLOCKS.register("mars_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MARS_SAND = BLOCKS.register("mars_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> COARSE_MARS_SAND = BLOCKS.register("coarse_mars_sand", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
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
    public static final RegistryObject<Block> COMPRESSED_MARS_COBBLESTONE = BLOCKS.register("compressed_mars_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COMPRESSED_MARS_COBBLED_DEEPSLATE = BLOCKS.register("compressed_mars_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));

    //STAIRS
    public static final RegistryObject<Block> MARS_STONE_STAIRS = BLOCKS.register("mars_stone_stairs", () -> new StairBlock(MARS_STONE.get().defaultBlockState(), Block.Properties.copy(MARS_STONE.get())));
    public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new StairBlock(MARS_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLESTONE_STAIRS = BLOCKS.register("mars_cobblestone_stairs", () -> new StairBlock(MARS_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLESTONE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("mars_deepslate_brick_stairs", () -> new StairBlock(MARS_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("mars_cobbled_deepslate_stairs", () -> new StairBlock(MARS_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILE_STAIRS = BLOCKS.register("mars_deepslate_tile_stairs", () -> new StairBlock(MARS_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("mars_polished_deepslate_stairs", () -> new StairBlock(MARS_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())));

    //SLAB
    public static final RegistryObject<Block> MARS_STONE_SLAB = BLOCKS.register("mars_stone_slab", () -> new SlabBlock(Block.Properties.copy(MARS_STONE.get())));
    public static final RegistryObject<Block> MARS_SMOOTH_STONE_SLAB = BLOCKS.register("mars_smooth_stone_slab", () -> new SlabBlock(Block.Properties.copy(MARS_SMOOTH_STONE.get())));
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

    public static final RegistryObject<Block> MARS_LANTERN = BLOCKS.register("mars_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> {
        return 13;
    })));


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
    public static final RegistryObject<Block> METEOR_SULFUR_ORE = BLOCKS.register("meteor_sulfur_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> METEOR_BRICKS = BLOCKS.register("meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_METEOR_BRICKS = BLOCKS.register("chiseled_meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new StairBlock(METEOR_BRICKS.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BRICK_WALL = BLOCKS.register("meteor_brick_wall", () -> new WallBlock(Block.Properties.copy(METEOR_BRICKS.get())));
//    public static final RegistryObject<Block> METEOR_BRICK_PILLAR = BLOCKS.register("meteor_brick_pillar", () -> new Block(Block.Properties.copy(METEOR_BRICKS.get())));
    public static final RegistryObject<Block> METEOR_BUTTON = BLOCKS.register("meteor_button", () -> new StoneButtonBlock(Block.Properties.copy(METEOR.get())));
    public static final RegistryObject<Block> METEOR_PRESSURE_PLATE = BLOCKS.register("meteor_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(METEOR.get())));

    /*
     * VENUSIAN BLOCKS
     */
    public static final RegistryObject<Block> VENUS_CORE = BLOCKS.register("venus_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> VENUS_SAND = BLOCKS.register("venus_sand", () -> new SandBlock(0x64431d, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> FINE_VENUS_SAND = BLOCKS.register("fine_venus_sand", () -> new SandBlock(0x64431d, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> VENUS_STONE = BLOCKS.register("venus_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_SMOOTH_STONE = BLOCKS.register("venus_smooth_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_BRICKS = BLOCKS.register("venus_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMALL_VENUS_BRICKS = BLOCKS.register("small_venus_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_BRICK_PILLAR = BLOCKS.register("venus_brick_pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MARS_BRICKS.get())));
    public static final RegistryObject<Block> CHISELED_VENUS_BRICKS = BLOCKS.register("chiseled_venus_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_VENUS_BRICKS = BLOCKS.register("cracked_venus_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_IRON_ORE = BLOCKS.register("venus_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_REDSTONE_ORE = BLOCKS.register("venus_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_LAPIS_ORE = BLOCKS.register("venus_lapis_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> VENUS_COBBLESTONE = BLOCKS.register("venus_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE = BLOCKS.register("venus_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BRICKS = BLOCKS.register("venus_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_VENUS_DEEPSLATE_BRICKS = BLOCKS.register("chiseled_venus_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_VENUS_DEEPSLATE_BRICKS = BLOCKS.register("cracked_venus_deepslate_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_COBBLED_DEEPSLATE = BLOCKS.register("venus_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_TILES = BLOCKS.register("venus_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_VENUS_DEEPSLATE_TILES = BLOCKS.register("cracked_venus_deepslate_tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_POLISHED_DEEPSLATE = BLOCKS.register("venus_polished_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_IRON_ORE = BLOCKS.register("venus_deepslate_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_REDSTONE_ORE = BLOCKS.register("venus_deepslate_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_LAPIS_ORE = BLOCKS.register("venus_deepslate_lapis_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));

    public static final RegistryObject<Block> COMPRESSED_VENUS_COBBLESTONE = BLOCKS.register("compressed_venus_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COMPRESSED_VENUS_COBBLED_DEEPSLATE = BLOCKS.register("compressed_venus_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));

    //STAIRS
    public static final RegistryObject<Block> VENUS_STONE_STAIRS = BLOCKS.register("venus_stone_stairs", () -> new StairBlock(VENUS_STONE.get().defaultBlockState(), Block.Properties.copy(VENUS_STONE.get())));
    public static final RegistryObject<Block> VENUS_BRICK_STAIRS = BLOCKS.register("venus_brick_stairs", () -> new StairBlock(VENUS_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICKS.get())));
    public static final RegistryObject<Block> SMALL_VENUS_BRICK_STAIRS = BLOCKS.register("small_venus_brick_stairs", () -> new StairBlock(VENUS_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICKS.get())));
    public static final RegistryObject<Block> VENUS_COBBLESTONE_STAIRS = BLOCKS.register("venus_cobblestone_stairs", () -> new StairBlock(VENUS_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(VENUS_COBBLESTONE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BRICK_STAIRS = BLOCKS.register("venus_deepslate_brick_stairs", () -> new StairBlock(VENUS_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> VENUS_COBBLED_DEEPSLATE_STAIRS = BLOCKS.register("venus_cobbled_deepslate_stairs", () -> new StairBlock(VENUS_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_TILE_STAIRS = BLOCKS.register("venus_deepslate_tile_stairs", () -> new StairBlock(VENUS_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> VENUS_POLISHED_DEEPSLATE_STAIRS = BLOCKS.register("venus_polished_deepslate_stairs", () -> new StairBlock(VENUS_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())));

    //SLAB
    public static final RegistryObject<Block> VENUS_STONE_SLAB = BLOCKS.register("venus_stone_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_STONE.get())));
    public static final RegistryObject<Block> VENUS_SMOOTH_STONE_SLAB = BLOCKS.register("venus_smooth_stone_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_SMOOTH_STONE.get())));
    public static final RegistryObject<Block> VENUS_BRICK_SLAB = BLOCKS.register("venus_brick_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_BRICKS.get())));
    public static final RegistryObject<Block> SMALL_VENUS_BRICK_SLAB = BLOCKS.register("small_venus_brick_slab", () -> new SlabBlock(Block.Properties.copy(SMALL_VENUS_BRICKS.get())));
    public static final RegistryObject<Block> VENUS_COBBLESTONE_SLAB = BLOCKS.register("venus_cobblestone_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_COBBLESTONE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BRICK_SLAB = BLOCKS.register("venus_deepslate_brick_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_DEEPSLATE_BRICKS.get())));
    public static final RegistryObject<Block> VENUS_COBBLED_DEEPSLATE_SLAB = BLOCKS.register("venus_cobbled_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_TILE_SLAB = BLOCKS.register("venus_deepslate_tile_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> VENUS_POLISHED_DEEPSLATE_SLAB = BLOCKS.register("venus_polished_deepslate_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())));

    //WALL
    public static final RegistryObject<Block> VENUS_BRICK_WALL = BLOCKS.register("venus_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMALL_VENUS_BRICK_WALL = BLOCKS.register("small_venus_brick_wall", () -> new WallBlock(Block.Properties.copy(SMALL_VENUS_BRICKS.get())));
    public static final RegistryObject<Block> VENUS_COBBLESTONE_WALL = BLOCKS.register("venus_cobblestone_wall", () -> new WallBlock(Block.Properties.copy(VENUS_COBBLESTONE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BRICK_WALL = BLOCKS.register("venus_deepslate_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> VENUS_COBBLED_DEEPSLATE_WALL = BLOCKS.register("venus_cobbled_deepslate_wall", () -> new WallBlock(Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_TILE_WALL = BLOCKS.register("venus_deepslate_tile_wall", () -> new WallBlock(Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())));
    public static final RegistryObject<Block> VENUS_POLISHED_DEEPSLATE_WALL = BLOCKS.register("venus_polished_deepslate_wall", () -> new WallBlock(Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())));

    //BUTTON
    public static final RegistryObject<Block> VENUS_STONE_BUTTON = BLOCKS.register("venus_stone_button", () -> new StoneButtonBlock(Block.Properties.copy(VENUS_STONE.get())));
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BUTTON = BLOCKS.register("venus_deepslate_button", () -> new StoneButtonBlock(Block.Properties.copy(VENUS_DEEPSLATE.get())));

    //PRESSURE PLATE
    public static final RegistryObject<Block> VENUS_DEEPSLATE_PRESSURE_PLATE = BLOCKS.register("venus_deepslate_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(VENUS_DEEPSLATE.get()).isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> VENUS_STONE_PRESSURE_PLATE = BLOCKS.register("venus_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(VENUS_STONE.get()).isValidSpawn(BlockRegistry::never)));

    //OTHER
    public static final RegistryObject<Block> VENUS_LANTERN = BLOCKS.register("venus_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> {
        return 13;
    })));
    public static final RegistryObject<Block> GEYSER = BLOCKS.register("geyser", () -> new GeyserBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> SULFURIC_OBSIDIAN = BLOCKS.register("sulfuric_obsidian", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(50.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    //SOLAR BLOCKS
    public static final RegistryObject<Block> SOLAR_PLASMA = BLOCKS.register("solar_plasma", () -> new SolarBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(1.0f).lightLevel((light) -> 20).randomTicks().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> SUN_SPOT = BLOCKS.register("sun_spot", () -> new SolarBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(1.0f).lightLevel((light) -> 13).randomTicks().isValidSpawn(BlockRegistry::never).hasPostProcess(BlockRegistry::always)));
    public static final RegistryObject<Block> SOLAR_FLARE = BLOCKS.register("solar_flare", () -> new SolarFlareBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(0.8f).lightLevel((light) -> 15).isValidSpawn(BlockRegistry::never).hasPostProcess(BlockRegistry::always).noOcclusion()));

    //MERCURY
    public static final RegistryObject<Block> MERCURY_STONE = BLOCKS.register("mercury_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MERCURY_CORE = BLOCKS.register("mercury_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MERCURY_DEEPSLATE = BLOCKS.register("mercury_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //JUPITER
    public static final RegistryObject<Block> JUPITER_ATMOSPHERE = BLOCKS.register("jupiter_atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> JUPITER_CORE = BLOCKS.register("jupiter_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> JUPITER_DEEPSLATE = BLOCKS.register("jupiter_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //JUPITER'S MOONS
    public static final RegistryObject<Block> IO_CORE = BLOCKS.register("io_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> IO_STONE = BLOCKS.register("io_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> IO_DEEPSLATE = BLOCKS.register("io_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> EUROPA_CORE = BLOCKS.register("europa_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> EUROPA_HYDRATE = BLOCKS.register("europa_hydrate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> GANYMEDE_CORE = BLOCKS.register("ganymede_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> CALLISTO_CORE = BLOCKS.register("callisto_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //SATURN
    public static final RegistryObject<Block> SATURN_ATMOSPHERE = BLOCKS.register("saturn_atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> SATURN_CORE = BLOCKS.register("saturn_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> SATURN_DEEPSLATE = BLOCKS.register("saturn_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //SATURN'S MOONS
    public static final RegistryObject<Block> TITAN_CORE = BLOCKS.register("titan_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> ENCELADUS_CORE = BLOCKS.register("enceladus_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> RHEA_CORE = BLOCKS.register("rhea_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> IAPETUS_CORE = BLOCKS.register("iapetus_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> HYPERION_CORE = BLOCKS.register("hyperion_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> DIONE_CORE = BLOCKS.register("dione_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //URANUS
    public static final RegistryObject<Block> URANUS_ATMOSPHERE = BLOCKS.register("uranus_atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> URANUS_CORE = BLOCKS.register("uranus_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> URANUS_DEEPSLATE = BLOCKS.register("uranus_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //URANUS'S MOONS
    public static final RegistryObject<Block> TITANIA_CORE = BLOCKS.register("titania_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> OBERON_CORE = BLOCKS.register("oberon_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //NEPTUNE
    public static final RegistryObject<Block> NEPTUNE_ATMOSPHERE = BLOCKS.register("neptune_atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> NEPTUNE_CORE = BLOCKS.register("neptune_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> NEPTUNE_DEEPSLATE = BLOCKS.register("neptune_deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //NEPTUNE'S MOON
    public static final RegistryObject<Block> TRITON_CORE = BLOCKS.register("triton_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //DWARF PLANETS
//    public static final RegistryObject<Block> PLUTO_CORE = BLOCKS.register("pluto_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> CERES_CORE = BLOCKS.register("ceres_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> MAKEMAKE_CORE = BLOCKS.register("makemake_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> HAUMEA_CORE = BLOCKS.register("haumea_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> ERIS_CORE = BLOCKS.register("eris_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));


    //POWER-RELATED BLOCKS
//	public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL = BLOCKS.register("solar_panel", SolarPanelBlock::new);

    /*
     * PORTAL BLOCKS
     */
    public static final RegistryObject<Block> MARS_PORTAL = BLOCKS.register("mars_portal", MarsPortalBlock::new);
    public static final RegistryObject<Block> MOON_PORTAL = BLOCKS.register("moon_portal", MoonPortalBlock::new);
    public static final RegistryObject<Block> VENUS_PORTAL = BLOCKS.register("venus_portal", VenusPortalBlock::new);

    /*
     * SPACESHIP BLOCKS
     */
    public static final RegistryObject<Block> STEEL_FRAME = BLOCKS.register("steel_frame", () -> new SteelFrameBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).dynamicShape()));
    //	public static final RegistryObject<Block> LAUNCH_PAD = BLOCKS.register("launch_pad", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<IronBarsBlock> CERAMIC_TILE = BLOCKS.register("ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CERAMIC = BLOCKS.register("ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
	public static final RegistryObject<Block> WHITE_CERAMIC = BLOCKS.register("white_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> WHITE_CERAMIC_TILE = BLOCKS.register("white_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> LIGHT_GREY_CERAMIC = BLOCKS.register("light_grey_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> LIGHT_GREY_CERAMIC_TILE = BLOCKS.register("light_grey_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> GREY_CERAMIC = BLOCKS.register("grey_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> GREY_CERAMIC_TILE = BLOCKS.register("grey_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> BLACK_CERAMIC = BLOCKS.register("black_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> BLACK_CERAMIC_TILE = BLOCKS.register("black_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> PURPLE_CERAMIC = BLOCKS.register("purple_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> PURPLE_CERAMIC_TILE = BLOCKS.register("purple_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> MAGENTA_CERAMIC = BLOCKS.register("magenta_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> MAGENTA_CERAMIC_TILE = BLOCKS.register("magenta_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> BLUE_CERAMIC = BLOCKS.register("blue_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> BLUE_CERAMIC_TILE = BLOCKS.register("blue_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> LIGHT_BLUE_CERAMIC = BLOCKS.register("light_blue_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> LIGHT_BLUE_CERAMIC_TILE = BLOCKS.register("light_blue_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> CYAN_CERAMIC = BLOCKS.register("cyan_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> CYAN_CERAMIC_TILE = BLOCKS.register("cyan_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> GREEN_CERAMIC = BLOCKS.register("green_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> GREEN_CERAMIC_TILE = BLOCKS.register("green_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> LIME_CERAMIC = BLOCKS.register("lime_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> LIME_CERAMIC_TILE = BLOCKS.register("lime_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> YELLOW_CERAMIC = BLOCKS.register("yellow_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> YELLOW_CERAMIC_TILE = BLOCKS.register("yellow_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> ORANGE_CERAMIC = BLOCKS.register("orange_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> ORANGE_CERAMIC_TILE = BLOCKS.register("orange_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> BROWN_CERAMIC = BLOCKS.register("brown_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> BROWN_CERAMIC_TILE = BLOCKS.register("brown_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> RED_CERAMIC = BLOCKS.register("red_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> RED_CERAMIC_TILE = BLOCKS.register("red_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));
	public static final RegistryObject<Block> PINK_CERAMIC = BLOCKS.register("pink_ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final RegistryObject<IronBarsBlock> PINK_CERAMIC_TILE = BLOCKS.register("pink_ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> PAINTED_WHITE_CERAMIC = BLOCKS.register("painted_white_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_LIGHT_GREY_CERAMIC = BLOCKS.register("painted_light_grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_GREY_CERAMIC = BLOCKS.register("painted_grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_BLACK_CERAMIC = BLOCKS.register("painted_black_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_PURPLE_CERAMIC = BLOCKS.register("painted_purple_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_MAGENTA_CERAMIC = BLOCKS.register("painted_magenta_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_BLUE_CERAMIC = BLOCKS.register("painted_blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_LIGHT_BLUE_CERAMIC = BLOCKS.register("painted_light_blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_CYAN_CERAMIC = BLOCKS.register("painted_cyan_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_GREEN_CERAMIC = BLOCKS.register("painted_green_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_LIME_CERAMIC = BLOCKS.register("painted_lime_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_YELLOW_CERAMIC = BLOCKS.register("painted_yellow_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_ORANGE_CERAMIC = BLOCKS.register("painted_orange_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_BROWN_CERAMIC = BLOCKS.register("painted_brown_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_RED_CERAMIC = BLOCKS.register("painted_red_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PAINTED_PINK_CERAMIC = BLOCKS.register("painted_pink_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));

    /*
     * OTHER BLOCKS
     */
    public static final RegistryObject<Block> OXYGEN_COMPRESSOR = BLOCKS.register("oxygen_compressor", () -> new OxygenCompressorBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WORKBENCH = BLOCKS.register("workbench", () -> new WorkbenchBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(3.5F).sound(SoundType.METAL)));

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
    public static final RegistryObject<Block> SILICA = BLOCKS.register("silica", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> AIRLOCK_DOOR = BLOCKS.register("airlock_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> STEEL_DOOR = BLOCKS.register("steel_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> STEEL_TRAPDOOR = BLOCKS.register("steel_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> STEEL_BUTTON = BLOCKS.register("steel_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.5F).noCollission()));


    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = BLOCKS.register("compressed_cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COMPRESSED_COBBLED_DEEPSLATE = BLOCKS.register("compressed_cobbled_deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COMPRESSED_NETHERRACK = BLOCKS.register("compressed_netherrack", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)));


    //GLASS
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS = BLOCKS.register("luminous_blue_glass", () -> new ConnectedGlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS = BLOCKS.register("luminous_white_glass", () -> new ConnectedGlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS_PANE = BLOCKS.register("luminous_blue_glass_pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS_PANE = BLOCKS.register("luminous_white_glass_pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> {
        return 9;
    })));

    public static final RegistryObject<Block> REINFORCED_GLASS = BLOCKS.register("reinforced_glass", () -> new ConnectedGlassBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F, 4.0F).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> REINFORCED_GLASS_PANE = BLOCKS.register("reinforced_glass_pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F, 4.0F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion()));

    //MAG LEV
    public static final RegistryObject<Block> MAG_RAIL = BLOCKS.register("mag_rail", () -> new MagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> POWERED_MAG_RAIL = BLOCKS.register("powered_mag_rail", () -> new PoweredMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL), true));
    public static final RegistryObject<Block> DETECTOR_MAG_RAIL = BLOCKS.register("detector_mag_rail", () -> new DetectorMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ACTIVATOR_MAG_RAIL = BLOCKS.register("activator_mag_rail", () -> new PoweredMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)));

    /*
     * ~~CUSTOM BLOCK TAGS~~
     */
    public static final TagKey<Block> MOON_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon"));
    public static final TagKey<Block> MOON_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone"));
    public static final TagKey<Block> MOON_COBBLESTONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone"));
    public static final TagKey<Block> MOON_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));
    public static final TagKey<Block> MOON_COBBLED_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));

    public static final TagKey<Block> MARS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars"));
    public static final TagKey<Block> MARS_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone"));
    public static final TagKey<Block> MARS_COBBLESTONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone"));
    public static final TagKey<Block> MARS_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate"));
    public static final TagKey<Block> MARS_COBBLED_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate"));

    public static final TagKey<Block> VENUS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus"));
    public static final TagKey<Block> VENUS_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_stone"));
    public static final TagKey<Block> VENUS_COBBLESTONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobblestone"));
    public static final TagKey<Block> VENUS_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_deepslate"));
    public static final TagKey<Block> VENUS_COBBLED_DEEPSLATE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobbled_deepslate"));

    public static final TagKey<Block> REGOLITH_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "regolith"));

    public static final TagKey<Block> METEOR_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor"));

    public static final TagKey<Block> CONNECTED_GLASS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass"));
    public static final TagKey<Block> CONNECTED_GLASS_PANE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "connected_glass_pane"));

    public static final TagKey<Block> DYED_CERAMIC_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "dyed_ceramic"));
    public static final TagKey<Block> PAINTED_CERAMIC_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "painted_ceramic"));

    public static final TagKey<Block> MARS_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_portal_frame_block"));
    public static final TagKey<Block> MOON_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_portal_frame_block"));
    public static final TagKey<Block> VENUS_PORTAL_FRAME_BLOCK = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_portal_frame_block"));

    public static final TagKey<Block> MAG_RAIL_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mag_rail"));

    private static ToIntFunction<BlockState> litBlockEmission(int p_235420_0_) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? p_235420_0_ : 0;
    }

    private static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pose, EntityType<?> entityType) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

}