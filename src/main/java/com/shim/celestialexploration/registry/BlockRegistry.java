package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@SuppressWarnings("deprecated")
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CelestialExploration.MODID);

    public static final Map<RegistryObject<? extends Block>, String> BLOCK_LANG_EN_US = new HashMap<>();
    public static final LinkedList<RegistryObject<? extends Block>> BLOCKS_LOOT_TABLE = new LinkedList<>();

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String nameIn, String localizationIn, Supplier<T> blockIn, CreativeModeTab tabIn) {
        RegistryObject<T> block = BLOCKS.register(nameIn, blockIn);
        ItemRegistry.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tabIn)));
        BLOCK_LANG_EN_US.put(block, localizationIn);
        return block;
    }

    private static <T extends Block> RegistryObject<T> registerCoreBlock(String nameIn, String localizationIn, Supplier<T> blockIn) {
        RegistryObject<T> block = BLOCKS.register(nameIn, blockIn);
        ItemRegistry.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
        BLOCK_LANG_EN_US.put(block, localizationIn);
        return block;
    }

    private static <T extends Block> RegistryObject<T> registerBlockDropsSelf(String nameIn, String localizationIn, Supplier<T> blockIn, CreativeModeTab tabIn) {
        RegistryObject<T> block = BLOCKS.register(nameIn, blockIn);
        ItemRegistry.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tabIn)));
        BLOCK_LANG_EN_US.put(block, localizationIn);
        BLOCKS_LOOT_TABLE.add(block);
        return block;
    }

    private static <T extends Block> RegistryObject<T> registerBlockNoItem(String nameIn, String localizationIn, Supplier<T> blockIn) {
        RegistryObject<T> block = BLOCKS.register(nameIn, blockIn);
        BLOCK_LANG_EN_US.put(block, localizationIn);
        return block;
    }

    
    //---- MOON -------------------------------------------------------------------------------
    //STONE
    public static final RegistryObject<Block> MOON_STONE = registerBlock("moon_stone", "Lunar Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_SMOOTH_STONE = registerBlockDropsSelf("moon_smooth_stone", "Lunar Smooth Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_BRICKS = registerBlockDropsSelf("moon_bricks", "Lunar Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<RotatedPillarBlock> MOON_BRICK_PILLAR = registerBlockDropsSelf("moon_brick_pillar", "Lunar Brick Pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MOON_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MOON_BRICKS = registerBlockDropsSelf("chiseled_moon_bricks", "Chiseled Lunar Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MOON_BRICKS = registerBlockDropsSelf("cracked_moon_bricks", "Cracked Lunar Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<Block> MOON_COBBLESTONE = registerBlockDropsSelf("moon_cobblestone", "Lunar Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MOON_COBBLESTONE = registerBlockDropsSelf("compressed_moon_cobblestone", "Compressed Lunar Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MOON_COBBLESTONE = registerBlockDropsSelf("super_compressed_moon_cobblestone", "Super Compressed Lunar Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MOON_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_moon_cobbled_deepslate", "Compressed Lunar Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MOON_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_moon_cobbled_deepslate", "Super Compressed Lunar Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //DEEPSLATE
    public static final RegistryObject<RotatedPillarBlock> MOON_DEEPSLATE = registerBlock("moon_deepslate", "Lunar Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_DEEPSLATE_BRICKS = registerBlockDropsSelf("moon_deepslate_bricks", "Lunar Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MOON_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_moon_deepslate_bricks", "Chiseled Lunar Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MOON_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_moon_deepslate_bricks", "Cracked Lunar Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_DEEPSLATE_TILES = registerBlockDropsSelf("moon_deepslate_tiles", "Lunar Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MOON_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_moon_deepslate_tiles", "Cracked Lunar Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_POLISHED_DEEPSLATE = registerBlockDropsSelf("moon_polished_deepslate", "Polished Lunar Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_COBBLED_DEEPSLATE = registerBlockDropsSelf("moon_cobbled_deepslate", "Lunar Cobbled Deepslate", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //ORES
    public static final RegistryObject<Block> MOON_IRON_ORE = registerBlock("moon_iron_ore", "Lunar Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_REDSTONE_ORE = registerBlock("moon_redstone_ore", "Lunar Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_BAUXITE_ORE = registerBlock("moon_bauxite_ore", "Lunar Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_DEEPSLATE_IRON_ORE = registerBlock("moon_deepslate_iron_ore", "Lunar Deepslate Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_DEEPSLATE_REDSTONE_ORE = registerBlock("moon_deepslate_redstone_ore", "LUnar Deepslate Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
    public static final RegistryObject<StairBlock> MOON_STONE_STAIRS = registerBlockDropsSelf("moon_stone_stairs", "Lunar Stone Stairs", () -> new StairBlock(MOON_STONE.get().defaultBlockState(), Block.Properties.copy(MOON_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_BRICK_STAIRS = registerBlockDropsSelf("moon_brick_stairs", "Lunar Brick Stairs", () -> new StairBlock(MOON_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_COBBLESTONE_STAIRS = registerBlockDropsSelf("moon_cobblestone_stairs", "Lunar Cobblestone Stairs", () -> new StairBlock(MOON_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("moon_deepslate_brick_stairs", "Lunar Deepslate Brick Stairs", () -> new StairBlock(MOON_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("moon_deepslate_tile_stairs", "LUnar Deepslate Tile Stairs", () -> new StairBlock(MOON_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MOON_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("moon_polished_deepslate_stairs", "Lunar Polished Deepslate Stairs", () -> new StairBlock(MOON_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MOON_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("moon_cobbled_deepslate_stairs", "Lunar Cobbled Deepslate Stairs", () -> new StairBlock(MOON_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
    public static final RegistryObject<SlabBlock> MOON_STONE_SLAB = registerBlock("moon_stone_slab", "Lunar Stone Slab", () -> new SlabBlock(Block.Properties.copy(MOON_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_SMOOTH_STONE_SLAB = registerBlock("moon_smooth_stone_slab", "Lunar Smooth Stone Slab", () -> new SlabBlock(Block.Properties.copy(MOON_SMOOTH_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_BRICK_SLAB = registerBlock("moon_brick_slab", "Lunar Brick Slab", () -> new SlabBlock(Block.Properties.copy(MOON_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_COBBLESTONE_SLAB = registerBlock("moon_cobblestone_slab", "Lunar Cobblestone Slab", () -> new SlabBlock(Block.Properties.copy(MOON_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_DEEPSLATE_BRICK_SLAB = registerBlock("moon_deepslate_brick_slab", "Lunar Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_COBBLED_DEEPSLATE_SLAB = registerBlock("moon_cobbled_deepslate_slab", "Lunar Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_DEEPSLATE_TILE_SLAB = registerBlock("moon_deepslate_tile_slab", "Lunar Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(MOON_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MOON_POLISHED_DEEPSLATE_SLAB = registerBlock("moon_polished_deepslate_slab", "Lunar Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
    public static final RegistryObject<WallBlock> MOON_BRICK_WALL = registerBlockDropsSelf("moon_brick_wall", "Lunar Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MOON_COBBLESTONE_WALL = registerBlockDropsSelf("moon_cobblestone_wall", "Lunar Cobblestone Wall", () -> new WallBlock(Block.Properties.copy(MOON_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MOON_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("moon_deepslate_brick_wall", "Lunar Deepslate Brick Wall", () -> new WallBlock(Block.Properties.copy(MOON_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MOON_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("moon_cobbled_deepslate_wall", "Lunar Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MOON_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MOON_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("moon_deepslate_tile_wall", "Lunar Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(MOON_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MOON_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("moon_polished_deepslate_wall", "Lunar Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MOON_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
    public static final RegistryObject<ButtonBlock> MOON_STONE_BUTTON = registerBlockDropsSelf("moon_stone_button", "Lunar Stone Button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> MOON_DEEPSLATE_BUTTON = registerBlockDropsSelf("moon_deepslate_button", "Lunar Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
    public static final RegistryObject<PressurePlateBlock> MOON_STONE_PRESSURE_PLATE = registerBlockDropsSelf("moon_stone_pressure_plate", "Lunar Stone Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<PressurePlateBlock> MOON_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("moon_deepslate_pressure_plate", "Lunar Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> MOON_CORE = registerCoreBlock("moon_core", "Lunar Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MOON_SAND = registerBlockDropsSelf("moon_sand", "Lunar Regolith", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> GLOWING_MOON_SAND = registerBlock("glowing_moon_sand", "Glowing Lunar Regolith", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((light) -> 2)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COARSE_MOON_SAND = registerBlockDropsSelf("coarse_moon_sand", "Coarse Lunar Regolith", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.GRAVEL)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LUNAR_LANTERN = registerBlock("lunar_lantern", "Lunar Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MOON_SAND_PATH = registerBlock("moon_sand_path", "Lunar Regolith Path", () -> new CelestialPathBlock(Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND), MOON_SAND.get()), CelestialExploration.CELESTIAL_BLOCKS_TAB);


    //---- MARS -------------------------------------------------------------------------------
    //STONE
    public static final RegistryObject<Block> MARS_STONE = registerBlock("mars_stone", "Martian Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_SMOOTH_STONE = registerBlockDropsSelf("mars_smooth_stone", "Martian Smooth Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_BRICKS = registerBlockDropsSelf("mars_bricks", "Martian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<RotatedPillarBlock> MARS_BRICK_PILLAR = registerBlockDropsSelf("mars_brick_pillar", "Martian Brick Pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MARS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MARS_BRICKS = registerBlockDropsSelf("chiseled_mars_bricks", "Chiseled Martian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MARS_BRICKS = registerBlockDropsSelf("cracked_mars_bricks", "Cracked Martian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_COBBLESTONE = registerBlockDropsSelf("mars_cobblestone", "Martian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MARS_COBBLESTONE = registerBlockDropsSelf("compressed_mars_cobblestone", "Compressed Martian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MARS_COBBLESTONE = registerBlockDropsSelf("super_compressed_mars_cobblestone", "Super Compressed Martian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //DEEPSLATE
    public static final RegistryObject<Block> MARS_DEEPSLATE = registerBlock("mars_deepslate", "Martian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_DEEPSLATE_BRICKS = registerBlockDropsSelf("mars_deepslate_bricks", "Martian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MARS_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_mars_deepslate_bricks", "Chiseled Martian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MARS_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_mars_deepslate_bricks", "Cracked Martian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_COBBLED_DEEPSLATE = registerBlockDropsSelf("mars_cobbled_deepslate", "Martian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_DEEPSLATE_TILES = registerBlockDropsSelf("mars_deepslate_tiles", "Martian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MARS_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_mars_deepslate_tiles", "Cracked Martian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_POLISHED_DEEPSLATE = registerBlockDropsSelf("mars_polished_deepslate", "Martian Polished Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MARS_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_mars_cobbled_deepslate", "Compressed Martian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MARS_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_mars_cobbled_deepslate", "Super Compressed Martian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //ORES
    public static final RegistryObject<Block> MARS_IRON_ORE = registerBlock("mars_iron_ore", "Martian Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_REDSTONE_ORE = registerBlock("mars_redstone_ore", "Martian Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_BAUXITE_ORE = registerBlock("mars_bauxite_ore", "Martian Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_DEEPSLATE_IRON_ORE = registerBlock("mars_deepslate_iron_ore", "Martian Deepslate Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_DEEPSLATE_REDSTONE_ORE = registerBlock("mars_deepslate_redstone_ore", "Martian Deepslate Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
    public static final RegistryObject<StairBlock> MARS_STONE_STAIRS = registerBlockDropsSelf("mars_stone_stairs", "Martian Stone Stairs", () -> new StairBlock(MARS_STONE.get().defaultBlockState(), Block.Properties.copy(MARS_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_BRICK_STAIRS = registerBlockDropsSelf("mars_brick_stairs", "Martian Brick Stairs", () -> new StairBlock(MARS_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_COBBLESTONE_STAIRS = registerBlockDropsSelf("mars_cobblestone_stairs", "Martian Cobblestone Stairs", () -> new StairBlock(MARS_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("mars_deepslate_brick_stairs", "Martian Deepslate Brick Stairs", () -> new StairBlock(MARS_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("mars_cobbled_deepslate_stairs", "Martian Cobbled Deepslate Stairs", () -> new StairBlock(MARS_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("mars_deepslate_tile_stairs", "Martian Deepslate Tile Stairs", () -> new StairBlock(MARS_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MARS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MARS_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("mars_polished_deepslate_stairs", "Martian Polished Deepslate Stairs", () -> new StairBlock(MARS_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
    public static final RegistryObject<SlabBlock> MARS_STONE_SLAB = registerBlock("mars_stone_slab", "Martian Stone Slab", () -> new SlabBlock(Block.Properties.copy(MARS_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_SMOOTH_STONE_SLAB = registerBlock("mars_smooth_stone_slab", "Martian Smooth Stone Slab", () -> new SlabBlock(Block.Properties.copy(MARS_SMOOTH_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_BRICK_SLAB = registerBlock("mars_brick_slab", "Martian Brick Slab", () -> new SlabBlock(Block.Properties.copy(MARS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_COBBLESTONE_SLAB = registerBlock("mars_cobblestone_slab", "Martian Cobblestone Slab", () -> new SlabBlock(Block.Properties.copy(MARS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_DEEPSLATE_BRICK_SLAB = registerBlock("mars_deepslate_brick_slab", "Martian Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(MARS_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_COBBLED_DEEPSLATE_SLAB = registerBlock("mars_cobbled_deepslate_slab", "Martian Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_DEEPSLATE_TILE_SLAB = registerBlock("mars_deepslate_tile_slab", "Martian Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(MARS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MARS_POLISHED_DEEPSLATE_SLAB = registerBlock("mars_polished_deepslate_slab", "Martian Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
    public static final RegistryObject<WallBlock> MARS_BRICK_WALL = registerBlockDropsSelf("mars_brick_wall", "Martian Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MARS_COBBLESTONE_WALL = registerBlockDropsSelf("mars_cobblestone_wall", "Martian Cobblestone Wall", () -> new WallBlock(Block.Properties.copy(MARS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MARS_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("mars_deepslate_brick_wall", "Martian Deepslate Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MARS_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("mars_cobbled_deepslate_wall", "Martian Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MARS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MARS_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("mars_deepslate_tile_wall", "Martian Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(MARS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MARS_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("mars_polished_deepslate_wall", "Martian Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MARS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
    public static final RegistryObject<ButtonBlock> MARS_STONE_BUTTON = registerBlockDropsSelf("mars_stone_button", "Martian Stone Button", () -> new StoneButtonBlock(Block.Properties.copy(MOON_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> MARS_DEEPSLATE_BUTTON = registerBlockDropsSelf("mars_deepslate_button", "Martian Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(MARS_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
    public static final RegistryObject<PressurePlateBlock> MARS_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("mars_deepslate_pressure_plate", "Martian Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MARS_DEEPSLATE.get()).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<PressurePlateBlock> MARS_STONE_PRESSURE_PLATE = registerBlockDropsSelf("mars_stone_pressure_plate", "Martian Stone Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MOON_STONE.get()).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> MARS_CORE = registerCoreBlock("mars_core", "Martian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MARS_SAND = registerBlockDropsSelf("mars_sand", "Martian Regolith", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COARSE_MARS_SAND = registerBlockDropsSelf("coarse_mars_sand", "Coarse Martian Regolith", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.GRAVEL)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    //	public static final RegistryObject<Block> MARS_SOIL = BLOCKS.register("mars_soil", () -> new MarsFarmlandBlock(Block.Properties.of(Material.DIRT).strength(0.6f).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> MARS_LANTERN = registerBlock("mars_lantern", "Martian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MARS_SAND_PATH = registerBlock("mars_sand_path", "Martian Regolith Path", () -> new CelestialPathBlock(Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND), MARS_SAND.get()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- VENUS -------------------------------------------------------------------------------
    //STONE
    public static final RegistryObject<Block> VENUS_STONE = registerBlock("venus_stone", "Venusian Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_SMOOTH_STONE = registerBlockDropsSelf("venus_smooth_stone", "Venusian Smooth Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_BRICKS = registerBlockDropsSelf("venus_bricks", "Venusian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SMALL_VENUS_BRICKS = registerBlockDropsSelf("small_venus_bricks", "Small Venusian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_BRICK_PILLAR = registerBlockDropsSelf("venus_brick_pillar", "Venusian Brick Pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MARS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_VENUS_BRICKS = registerBlockDropsSelf("chiseled_venus_bricks", "Chiseled Venusian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_VENUS_BRICKS = registerBlockDropsSelf("cracked_venus_bricks", "Cracked Venusian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_COBBLESTONE = registerBlockDropsSelf("venus_cobblestone", "Venusian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_VENUS_COBBLESTONE = registerBlockDropsSelf("compressed_venus_cobblestone", "Compressed Venusian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_VENUS_COBBLESTONE = registerBlockDropsSelf("super_compressed_venus_cobblestone", "Super Compressed Venusian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //DEEPSLATE
    public static final RegistryObject<Block> VENUS_DEEPSLATE = registerBlock("venus_deepslate", "Venusian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BRICKS = registerBlockDropsSelf("venus_deepslate_bricks", "Venusian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_VENUS_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_venus_deepslate_bricks", "Chiseled Venusian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_VENUS_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_venus_deepslate_bricks", "Cracked Venusian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_COBBLED_DEEPSLATE = registerBlockDropsSelf("venus_cobbled_deepslate", "Venusian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_TILES = registerBlockDropsSelf("venus_deepslate_tiles", "Venusian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_VENUS_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_venus_deepslate_tiles", "Cracked Venusian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_POLISHED_DEEPSLATE = registerBlockDropsSelf("venus_polished_deepslate", "Venusian Polished Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_VENUS_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_venus_cobbled_deepslate", "Compressed Venusian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_VENUS_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_venus_cobbled_deepslate", "Super Compressed Venusian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //ORES
    public static final RegistryObject<Block> VENUS_IRON_ORE = registerBlock("venus_iron_ore", "Venusian Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_REDSTONE_ORE = registerBlock("venus_redstone_ore", "Venusian Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_LAPIS_ORE = registerBlock("venus_lapis_ore", "Venusian Lapis Lazuli Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_BAUXITE_ORE = registerBlock("venus_bauxite_ore", "Venusian Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_IRON_ORE = registerBlock("venus_deepslate_iron_ore", "Venusian Deepslate Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_REDSTONE_ORE = registerBlock("venus_deepslate_redstone_ore", "Venusian Deepslate Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_LAPIS_ORE = registerBlock("venus_deepslate_lapis_ore", "Venusian Deepslate Lapis Lazuli Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
    public static final RegistryObject<StairBlock> VENUS_STONE_STAIRS = registerBlockDropsSelf("venus_stone_stairs", "Venusian Stone Stairs", () -> new StairBlock(VENUS_STONE.get().defaultBlockState(), Block.Properties.copy(VENUS_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_BRICK_STAIRS = registerBlockDropsSelf("venus_brick_stairs", "Venusian Brick Stairs", () -> new StairBlock(VENUS_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> SMALL_VENUS_BRICK_STAIRS = registerBlockDropsSelf("small_venus_brick_stairs", "Small Venusian Brick Stairs", () -> new StairBlock(VENUS_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_COBBLESTONE_STAIRS = registerBlockDropsSelf("venus_cobblestone_stairs", "Venusian Cobblestone Stairs", () -> new StairBlock(VENUS_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(VENUS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("venus_deepslate_brick_stairs", "Venusian Deepslate Brick Stairs", () -> new StairBlock(VENUS_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(VENUS_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("venus_cobbled_deepslate_stairs", "Venusian Cobbled Deepslate Stairs", () -> new StairBlock(VENUS_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("venus_deepslate_tile_stairs", "Venusian Deepslate Tile Stairs", () -> new StairBlock(VENUS_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> VENUS_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("venus_polished_deepslate_stairs", "Venusian Polished Deepslate Stairs", () -> new StairBlock(VENUS_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
    public static final RegistryObject<SlabBlock> VENUS_STONE_SLAB = registerBlock("venus_stone_slab", "Venusian Stone Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_SMOOTH_STONE_SLAB = registerBlock("venus_smooth_stone_slab", "Venusian Smooth Stone Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_SMOOTH_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_BRICK_SLAB = registerBlock("venus_brick_slab", "Venusian Brick Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> SMALL_VENUS_BRICK_SLAB = registerBlock("small_venus_brick_slab", "Small Venusian Brick Slab", () -> new SlabBlock(Block.Properties.copy(SMALL_VENUS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_COBBLESTONE_SLAB = registerBlock("venus_cobblestone_slab", "Venusian Cobblestone Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_DEEPSLATE_BRICK_SLAB = registerBlock("venus_deepslate_brick_slab", "Venusian Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_COBBLED_DEEPSLATE_SLAB = registerBlock("venus_cobbled_deepslate_slab", "Venusian Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_DEEPSLATE_TILE_SLAB = registerBlock("venus_deepslate_tile_slab", "Venusian Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> VENUS_POLISHED_DEEPSLATE_SLAB = registerBlock("venus_polished_deepslate_slab", "Venusian Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
    public static final RegistryObject<WallBlock> VENUS_BRICK_WALL = registerBlockDropsSelf("venus_brick_wall", "Venusian Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> SMALL_VENUS_BRICK_WALL = registerBlockDropsSelf("small_venus_brick_wall", "Small Venusian Brick Wall", () -> new WallBlock(Block.Properties.copy(SMALL_VENUS_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> VENUS_COBBLESTONE_WALL = registerBlockDropsSelf("venus_cobblestone_wall", "Venusian Cobblestone Wall", () -> new WallBlock(Block.Properties.copy(VENUS_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> VENUS_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("venus_deepslate_brick_wall", "Venusian Deepslate Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> VENUS_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("venus_cobbled_deepslate_wall", "Venusian Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(VENUS_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> VENUS_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("venus_deepslate_tile_wall", "Venus Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(VENUS_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> VENUS_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("venus_polished_deepslate_wall", "Venusian Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(VENUS_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
    public static final RegistryObject<Block> VENUS_STONE_BUTTON = registerBlockDropsSelf("venus_stone_button", "Venusian Stone Button", () -> new StoneButtonBlock(Block.Properties.copy(VENUS_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<Block> VENUS_DEEPSLATE_BUTTON = registerBlockDropsSelf("venus_deepslate_button", "Venusian Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(VENUS_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
    public static final RegistryObject<Block> VENUS_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("venus_deepslate_pressure_plate", "Venusian Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(VENUS_DEEPSLATE.get()).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<Block> VENUS_STONE_PRESSURE_PLATE = registerBlockDropsSelf("venus_stone_pressure_plate", "Venusian Stone Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(VENUS_STONE.get()).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> VENUS_CORE = registerCoreBlock("venus_core", "Venusian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> VENUS_SAND = registerBlockDropsSelf("venus_sand", "Venusian Regolith", () -> new SandBlock(0x64431d, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> FINE_VENUS_SAND = registerBlockDropsSelf("fine_venus_sand", "Fine Venusian Regolith", () -> new SandBlock(0x64431d, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_LANTERN = registerBlock("venus_lantern", "Venusian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> GEYSER = registerBlockDropsSelf("geyser", "Geyser", () -> new GeyserBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SULFURIC_OBSIDIAN = registerBlockDropsSelf("sulfuric_obsidian", "Sulfuric Obsidian", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(50.0f, 1200.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> VENUS_SAND_PATH = registerBlock("venus_sand_path", "Venusian Regolith Path", () -> new CelestialPathBlock(Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND), VENUS_SAND.get()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- MERCURY -------------------------------------------------------------------------------
    //STONE
    public static final RegistryObject<Block> MERCURY_STONE = registerBlock("mercury_stone", "Mercurian Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_SMOOTH_STONE = registerBlockDropsSelf("mercury_smooth_stone", "Mercurian Smooth Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_BRICKS = registerBlockDropsSelf("mercury_bricks", "Mercurian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<RotatedPillarBlock> MERCURY_BRICK_PILLAR = registerBlockDropsSelf("mercury_brick_pillar", "Mercurian Brick Pillar", () -> new RotatedPillarBlock(Block.Properties.copy(MERCURY_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MERCURY_BRICKS = registerBlockDropsSelf("chiseled_mercury_bricks", "Chiseled Mercurian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MERCURY_BRICKS = registerBlockDropsSelf("cracked_mercury_bricks", "Cracked Mercurian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_COBBLESTONE = registerBlockDropsSelf("mercury_cobblestone", "Mercurian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MERCURY_COBBLESTONE = registerBlockDropsSelf("compressed_mercury_cobblestone", "Compressed Mercurian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MERCURY_COBBLESTONE = registerBlockDropsSelf("super_compressed_mercury_cobblestone", "Super Compressed Mercurian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //DEEPSLATE
    public static final RegistryObject<RotatedPillarBlock> MERCURY_DEEPSLATE = registerBlock("mercury_deepslate", "Mercurian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_BRICKS = registerBlockDropsSelf("mercury_deepslate_bricks", "Mercurian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_MERCURY_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_mercury_deepslate_bricks", "Chiseled Mercurian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MERCURY_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_mercury_deepslate_bricks", "Cracked Mercurian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_TILES = registerBlockDropsSelf("mercury_deepslate_tiles", "Mercurian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_MERCURY_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_mercury_deepslate_tiles", "Cracked Mercurian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_POLISHED_DEEPSLATE = registerBlockDropsSelf("mercury_polished_deepslate", "Mercurian Polished Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_COBBLED_DEEPSLATE = registerBlockDropsSelf("mercury_cobbled_deepslate", "Mercurian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_MERCURY_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_mercury_cobbled_deepslate", "Compressed Mercurian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_MERCURY_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_mercury_cobbled_deepslate", "Super Compressed Mercurian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //ORES
    public static final RegistryObject<Block> MERCURY_SULFUR_ORE = registerBlock("mercury_sulfur_ore", "Mercurian Sulfur Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_BAUXITE_ORE = registerBlock("mercury_bauxite_ore", "Mercurian Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_COAL_ORE = registerBlock("mercury_coal_ore", "Mercurian Coal Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 2)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DIAMOND_ORE = registerBlock("mercury_diamond_ore", "Mercurian Diamond Ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_DIAMOND_ORE = registerBlock("mercury_deepslate_diamond_ore", "Mercurian Deepslate Diamond Ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_IRON_ORE = registerBlock("mercury_deepslate_iron_ore", "Mercurian Deepslate Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_COAL_ORE = registerBlock("mercury_deepslate_coal_ore", "Mercurian Deepslate Coal Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE), UniformInt.of(0, 2)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_DEEPSLATE_REDSTONE_ORE = registerBlock("mercury_deepslate_redstone_ore", "Mercurian Deepslate Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
    public static final RegistryObject<StairBlock> MERCURY_STONE_STAIRS = registerBlockDropsSelf("mercury_stone_stairs", "Mercurian Stone Stairs", () -> new StairBlock(MERCURY_STONE.get().defaultBlockState(), Block.Properties.copy(MERCURY_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_BRICK_STAIRS = registerBlockDropsSelf("mercury_brick_stairs", "Mercurian Brick Stairs", () -> new StairBlock(MERCURY_BRICKS.get().defaultBlockState(), Block.Properties.copy(MERCURY_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_COBBLESTONE_STAIRS = registerBlockDropsSelf("mercury_cobblestone_stairs", "Mercurian Cobblestone Stairs", () -> new StairBlock(MERCURY_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(MERCURY_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("mercury_deepslate_brick_stairs", "Mercurian Deepslate Brick Stairs", () -> new StairBlock(MERCURY_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(MERCURY_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("mercury_deepslate_tile_stairs", "Mercurian Deepslate Tile Stairs", () -> new StairBlock(MERCURY_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(MERCURY_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("mercury_polished_deepslate_stairs", "Mercurian Polished Deepslate Stairs", () -> new StairBlock(MERCURY_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MERCURY_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> MERCURY_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("mercury_cobbled_deepslate_stairs", "Mercurian Cobbled Deepslate Stairs", () -> new StairBlock(MERCURY_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(MERCURY_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
    public static final RegistryObject<SlabBlock> MERCURY_STONE_SLAB = registerBlock("mercury_stone_slab", "Mercurian Stone Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_SMOOTH_STONE_SLAB = registerBlock("mercury_smooth_stone_slab", "Mercurian Smooth Stone Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_SMOOTH_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_BRICK_SLAB = registerBlock("mercury_brick_slab", "Mercurian Brick Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_COBBLESTONE_SLAB = registerBlock("mercury_cobblestone_slab", "Mercurian Cobblestone Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_DEEPSLATE_BRICK_SLAB = registerBlock("mercury_deepslate_brick_slab", "Mercurian Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_COBBLED_DEEPSLATE_SLAB = registerBlock("mercury_cobbled_deepslate_slab", "Mercurian Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_DEEPSLATE_TILE_SLAB = registerBlock("mercury_deepslate_tile_slab", "Mercurian Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> MERCURY_POLISHED_DEEPSLATE_SLAB = registerBlock("mercury_polished_deepslate_slab", "Mercurian Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
    public static final RegistryObject<WallBlock> MERCURY_BRICK_WALL = registerBlockDropsSelf("mercury_brick_wall", "Mercurian Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MERCURY_COBBLESTONE_WALL = registerBlockDropsSelf("mercury_cobblestone_wall", "Mercurian Cobblestone Wall", () -> new WallBlock(Block.Properties.copy(MERCURY_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MERCURY_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("mercury_deepslate_brick_wall", "Mercurian Deepslate Brick Wall", () -> new WallBlock(Block.Properties.copy(MERCURY_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MERCURY_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("mercury_cobbled_deepslate_wall", "Mercurian Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MERCURY_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MERCURY_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("mercury_deepslate_tile_wall", "Mercurian Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(MERCURY_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> MERCURY_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("mercury_polished_deepslate_wall", "Mercurian Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(MERCURY_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
    public static final RegistryObject<ButtonBlock> MERCURY_STONE_BUTTON = registerBlockDropsSelf("mercury_stone_button", "Mercurian Stone Button", () -> new StoneButtonBlock(Block.Properties.copy(MERCURY_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> MERCURY_DEEPSLATE_BUTTON = registerBlockDropsSelf("mercury_deepslate_button", "Mercurian Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(MERCURY_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
    public static final RegistryObject<PressurePlateBlock> MERCURY_STONE_PRESSURE_PLATE = registerBlockDropsSelf("mercury_stone_pressure_plate", "Mercurian Stone Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MERCURY_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<PressurePlateBlock> MERCURY_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("mercury_deepslate_pressure_plate", "Mercurian Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(MERCURY_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> MERCURY_CORE = registerCoreBlock("mercury_core", "Mercurian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> MERCURY_SAND = registerBlockDropsSelf("mercury_sand", "Mercurian Regolith", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COARSE_MERCURY_SAND = registerBlockDropsSelf("coarse_mercury_sand", "Coarse Mercurian Regolith", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.GRAVEL)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_SAND_PATH = registerBlock("mercury_sand_path", "Mercurian Regolith Path", () -> new CelestialPathBlock(Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND), MERCURY_SAND.get()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MERCURY_LANTERN = registerBlock("mercury_lantern", "Mercurian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);


    //---- JUPITER -------------------------------------------------------------------------------
    //DEEPSLATE
    public static final RegistryObject<RotatedPillarBlock> JUPITER_DEEPSLATE = registerBlock("jupiter_deepslate", "Jovian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> JUPITER_DEEPSLATE_BRICKS = registerBlockDropsSelf("jupiter_deepslate_bricks", "Jovian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_JUPITER_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_jupiter_deepslate_bricks", "Chiseled Jovian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_JUPITER_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_jupiter_deepslate_bricks", "Cracked Jovian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> JUPITER_COBBLED_DEEPSLATE = registerBlockDropsSelf("jupiter_cobbled_deepslate", "Jovian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> JUPITER_DEEPSLATE_TILES = registerBlockDropsSelf("jupiter_deepslate_tiles", "Jovian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CRACKED_JUPITER_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_jupiter_deepslate_tiles", "Cracked Jovian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> JUPITER_POLISHED_DEEPSLATE = registerBlockDropsSelf("jupiter_polished_deepslate", "Jovian Polished Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_JUPITER_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_jupiter_cobbled_deepslate", "Compressed Jovian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_JUPITER_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_jupiter_cobbled_deepslate", "Super Compressed Jovian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
    public static final RegistryObject<StairBlock> JUPITER_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("jupiter_deepslate_brick_stairs", "Jovian Deepslate Brick Stairs", () -> new StairBlock(JUPITER_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(JUPITER_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> JUPITER_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("jupiter_cobbled_deepslate_stairs", "Jovian Cobbled Deepslate Stairs", () -> new StairBlock(JUPITER_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(JUPITER_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> JUPITER_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("jupiter_deepslate_tile_stairs", "Jovian Deepslate Tile Stairs", () -> new StairBlock(JUPITER_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(JUPITER_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> JUPITER_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("jupiter_polished_deepslate_stairs", "Jovian Polished Deepslate Stairs", () -> new StairBlock(JUPITER_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(JUPITER_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
    public static final RegistryObject<SlabBlock> JUPITER_DEEPSLATE_BRICK_SLAB = registerBlock("jupiter_deepslate_brick_slab", "Jovian Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(JUPITER_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> JUPITER_COBBLED_DEEPSLATE_SLAB = registerBlock("jupiter_cobbled_deepslate_slab", "Jovian Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(JUPITER_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> JUPITER_DEEPSLATE_TILE_SLAB = registerBlock("jupiter_deepslate_tile_slab", "Jovian Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(JUPITER_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> JUPITER_POLISHED_DEEPSLATE_SLAB = registerBlock("jupiter_polished_deepslate_slab", "Jovian Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(JUPITER_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
    public static final RegistryObject<WallBlock> JUPITER_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("jupiter_deepslate_brick_wall", "Jovian Deepslate Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> JUPITER_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("jupiter_cobbled_deepslate_wall", "Jovian Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(JUPITER_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> JUPITER_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("jupiter_deepslate_tile_wall", "Jovian Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(JUPITER_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> JUPITER_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("jupiter_polished_deepslate_wall", "Jovian Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(JUPITER_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
    public static final RegistryObject<ButtonBlock> JUPITER_DEEPSLATE_BUTTON = registerBlockDropsSelf("jupiter_deepslate_button", "Jovian Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(JUPITER_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
    public static final RegistryObject<PressurePlateBlock> JUPITER_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("jupiter_deepslate_pressure_plate", "Jovian Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(JUPITER_DEEPSLATE.get()).isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> JUPITER_CORE = registerCoreBlock("jupiter_core", "Jovian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> JUPITER_LANTERN = registerBlock("jupiter_lantern", "Jovian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> JUPITER_ATMOSPHERE = registerBlock("jupiter_atmosphere", "Jovian Atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)), CelestialExploration.CELESTIAL_BLOCKS_TAB);


    //---- JUPITER'S MOONS -------------------------------------------------------------------------------
    //IO
    //STONE
    public static final RegistryObject<Block> IO_STONE = registerCoreBlock("io_stone", "Ionian Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//    public static final RegistryObject<Block> IO_SMOOTH_STONE = registerBlockDropsSelf("io_smooth_stone", "Ionian Smooth Stone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_BRICKS = registerBlockDropsSelf("io_bricks", "Ionian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<RotatedPillarBlock> IO_BRICK_PILLAR = registerBlockDropsSelf("io_brick_pillar", "Ionian Brick Pillar", () -> new RotatedPillarBlock(Block.Properties.copy(IO_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> CHISELED_IO_BRICKS = registerBlockDropsSelf("chiseled_io_bricks", "Chiseled Ionian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> CRACKED_IO_BRICKS = registerBlockDropsSelf("cracked_io_bricks", "Cracked Ionian Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_COBBLESTONE = registerBlockDropsSelf("io_cobblestone", "Ionian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> COMPRESSED_IO_COBBLESTONE = registerBlockDropsSelf("compressed_io_cobblestone", "Compressed Ionian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> SUPER_COMPRESSED_IO_COBBLESTONE = registerBlockDropsSelf("super_compressed_io_cobblestone", "Super Compressed Ionian Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //DEEPSLATE
    public static final RegistryObject<RotatedPillarBlock> IO_DEEPSLATE = registerCoreBlock("io_deepslate", "Ionian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//    public static final RegistryObject<Block> IO_DEEPSLATE_BRICKS = registerBlockDropsSelf("io_deepslate_bricks", "Ionian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> CHISELED_IO_DEEPSLATE_BRICKS = registerBlockDropsSelf("chiseled_io_deepslate_bricks", "Chiseled Ionian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> CRACKED_IO_DEEPSLATE_BRICKS = registerBlockDropsSelf("cracked_io_deepslate_bricks", "Cracked Ionian Deepslate Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_DEEPSLATE_TILES = registerBlockDropsSelf("io_deepslate_tiles", "Ionian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> CRACKED_IO_DEEPSLATE_TILES = registerBlockDropsSelf("cracked_io_deepslate_tiles", "Cracked Ionian Deepslate Tiles", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_POLISHED_DEEPSLATE = registerBlockDropsSelf("io_polished_deepslate", "Ionian Polished Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_COBBLED_DEEPSLATE = registerBlockDropsSelf("io_cobbled_deepslate", "Ionian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> COMPRESSED_IO_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_io_cobbled_deepslate", "Compressed Ionian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> SUPER_COMPRESSED_IO_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_io_cobbled_deepslate", "Super Compressed Ionian Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //ORES
//    public static final RegistryObject<Block> IO_SULFUR_ORE = registerBlock("io_sulfur_ore", "Ionian Sulfur Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_DEEPSLATE_IRON_ORE = registerBlock("io_deepslate_iron_ore", "Ionian Deepslate Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> IO_DEEPSLATE_REDSTONE_ORE = registerBlock("io_deepslate_redstone_ore", "Ionian Deepslate Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //STAIRS
//    public static final RegistryObject<StairBlock> IO_STONE_STAIRS = registerBlockDropsSelf("io_stone_stairs", "Ionian Stone Stairs", () -> new StairBlock(IO_STONE.get().defaultBlockState(), Block.Properties.copy(IO_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_BRICK_STAIRS = registerBlockDropsSelf("io_brick_stairs", "Ionian Brick Stairs", () -> new StairBlock(IO_BRICKS.get().defaultBlockState(), Block.Properties.copy(IO_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_COBBLESTONE_STAIRS = registerBlockDropsSelf("io_cobblestone_stairs", "Ionian Cobblestone Stairs", () -> new StairBlock(IO_COBBLESTONE.get().defaultBlockState(), Block.Properties.copy(IO_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_DEEPSLATE_BRICK_STAIRS = registerBlockDropsSelf("io_deepslate_brick_stairs", "Ionian Deepslate Brick Stairs", () -> new StairBlock(IO_DEEPSLATE_BRICKS.get().defaultBlockState(), Block.Properties.copy(IO_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_DEEPSLATE_TILE_STAIRS = registerBlockDropsSelf("io_deepslate_tile_stairs", "Ionian Deepslate Tile Stairs", () -> new StairBlock(IO_DEEPSLATE_TILES.get().defaultBlockState(), Block.Properties.copy(IO_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_POLISHED_DEEPSLATE_STAIRS = registerBlockDropsSelf("io_polished_deepslate_stairs", "Ionian Polished Deepslate Stairs", () -> new StairBlock(IO_POLISHED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(IO_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<StairBlock> IO_COBBLED_DEEPSLATE_STAIRS = registerBlockDropsSelf("io_cobbled_deepslate_stairs", "Ionian Cobbled Deepslate Stairs", () -> new StairBlock(IO_COBBLED_DEEPSLATE.get().defaultBlockState(), Block.Properties.copy(IO_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //SLAB
//    public static final RegistryObject<SlabBlock> IO_STONE_SLAB = registerBlock("io_stone_slab", "Ionian Stone Slab", () -> new SlabBlock(Block.Properties.copy(IO_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_SMOOTH_STONE_SLAB = registerBlock("io_smooth_stone_slab", "Ionian Smooth Stone Slab", () -> new SlabBlock(Block.Properties.copy(IO_SMOOTH_STONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_BRICK_SLAB = registerBlock("io_brick_slab", "Ionian Brick Slab", () -> new SlabBlock(Block.Properties.copy(IO_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_COBBLESTONE_SLAB = registerBlock("io_cobblestone_slab", "Ionian Cobblestone Slab", () -> new SlabBlock(Block.Properties.copy(IO_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_DEEPSLATE_BRICK_SLAB = registerBlock("io_deepslate_brick_slab", "Ionian Deepslate Brick Slab", () -> new SlabBlock(Block.Properties.copy(IO_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_COBBLED_DEEPSLATE_SLAB = registerBlock("io_cobbled_deepslate_slab", "Ionian Cobbled Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(IO_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_DEEPSLATE_TILE_SLAB = registerBlock("io_deepslate_tile_slab", "Ionian Deepslate Tile Slab", () -> new SlabBlock(Block.Properties.copy(IO_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<SlabBlock> IO_POLISHED_DEEPSLATE_SLAB = registerBlock("io_polished_deepslate_slab", "Ionian Polished Deepslate Slab", () -> new SlabBlock(Block.Properties.copy(IO_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //WALL
//    public static final RegistryObject<WallBlock> IO_BRICK_WALL = registerBlockDropsSelf("io_brick_wall", "Ionian Brick Wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<WallBlock> IO_COBBLESTONE_WALL = registerBlockDropsSelf("io_cobblestone_wall", "Ionian Cobblestone Wall", () -> new WallBlock(Block.Properties.copy(IO_COBBLESTONE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<WallBlock> IO_DEEPSLATE_BRICK_WALL = registerBlockDropsSelf("io_deepslate_brick_wall", "Ionian Deepslate Brick Wall", () -> new WallBlock(Block.Properties.copy(IO_DEEPSLATE_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<WallBlock> IO_COBBLED_DEEPSLATE_WALL = registerBlockDropsSelf("io_cobbled_deepslate_wall", "Ionian Cobbled Deepslate Wall", () -> new WallBlock(Block.Properties.copy(IO_COBBLED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<WallBlock> IO_DEEPSLATE_TILE_WALL = registerBlockDropsSelf("io_deepslate_tile_wall", "Ionian Deepslate Tile Wall", () -> new WallBlock(Block.Properties.copy(IO_DEEPSLATE_TILES.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<WallBlock> IO_POLISHED_DEEPSLATE_WALL = registerBlockDropsSelf("io_polished_deepslate_wall", "Ionian Polished Deepslate Wall", () -> new WallBlock(Block.Properties.copy(IO_POLISHED_DEEPSLATE.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //BUTTON
//    public static final RegistryObject<ButtonBlock> IO_STONE_BUTTON = registerBlockDropsSelf("io_stone_button", "Ionian Stone Button", () -> new StoneButtonBlock(Block.Properties.copy(IO_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
//    public static final RegistryObject<ButtonBlock> IO_DEEPSLATE_BUTTON = registerBlockDropsSelf("io_deepslate_button", "Ionian Deepslate Button", () -> new StoneButtonBlock(Block.Properties.copy(IO_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //PRESSURE PLATE
//    public static final RegistryObject<PressurePlateBlock> IO_STONE_PRESSURE_PLATE = registerBlockDropsSelf("io_stone_pressure_plate", "Ionian Stone Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(IO_STONE.get())), CelestialExploration.CELESTIAL_MISC_TAB);
//    public static final RegistryObject<PressurePlateBlock> IO_DEEPSLATE_PRESSURE_PLATE = registerBlockDropsSelf("io_deepslate_pressure_plate", "Ionian Deepslate Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(IO_DEEPSLATE.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //OTHER
    public static final RegistryObject<Block> IO_CORE = registerCoreBlock("io_core", "Ionian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> IO_LANTERN = registerBlock("io_lantern", "Ionian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //EUROPA
    //some ocean, topped with ice; no craters, very smooth, no mountains; "Penitente" features near the equator. Deepslate iron.
    public static final RegistryObject<Block> EUROPA_CORE = registerCoreBlock("europa_core", "Europan Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> EUROPA_HYDRATE = registerCoreBlock("europa_hydrate", "Europan Hydrate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//    public static final RegistryObject<Block> PENITENTE = registerCoreBlock("penitente", "Europan Hydrate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//    public static final RegistryObject<Block> EUROPA_LANTERN = registerBlock("europa_lantern", "Europan Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //GANYMEDE
    //mostly stone, with spots of surface deepslate. cratered.  underground ocean.  ice.
    public static final RegistryObject<Block> GANYMEDE_CORE = registerCoreBlock("ganymede_core", "Ganymedian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> GANYMEDE_LANTERN = registerBlock("ganymede_lantern", "Ganymedian Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //CALLISTO
    //deepslate all the way, with pockets of stone throughout.  heavily cratered.  ice.  coal ore.
    public static final RegistryObject<Block> CALLISTO_CORE = registerCoreBlock("callisto_core", "Callistoan Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> CALLISTO_LANTERN = registerBlock("callisto_lantern", "Callistoan Lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((light) -> 13)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- OTHER PLANETS -------------------------------------------------------------------------------

    //SATURN
    public static final RegistryObject<Block> SATURN_ATMOSPHERE = registerCoreBlock("saturn_atmosphere", "Saturnian Atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> SATURN_CORE = registerCoreBlock("saturn_core", "Saturnian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> SATURN_DEEPSLATE = registerCoreBlock("saturn_deepslate", "Saturnian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //SATURN'S MOONS
    public static final RegistryObject<Block> TITAN_CORE = registerCoreBlock("titan_core", "Titanian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> ENCELADUS_CORE = registerCoreBlock("enceladus_core", "Enceladean Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> RHEA_CORE = registerCoreBlock("rhea_core", "Rhean Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> IAPETUS_CORE = registerCoreBlock("iapetus_core", "Iapetian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> HYPERION_CORE = registerCoreBlock("hyperion_core", "Hyperionian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> DIONE_CORE = registerCoreBlock("dione_core", "Dionean Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //URANUS
    public static final RegistryObject<Block> URANUS_ATMOSPHERE = registerCoreBlock("uranus_atmosphere", "Uranian Atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> URANUS_CORE = registerCoreBlock("uranus_core", "Uranian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> URANUS_DEEPSLATE = registerCoreBlock("uranus_deepslate", "Uranian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //URANUS'S MOONS
    public static final RegistryObject<Block> TITANIA_CORE = registerCoreBlock("titania_core", "Little Titanian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> OBERON_CORE = registerCoreBlock("oberon_core", "Oberonian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //NEPTUNE
    public static final RegistryObject<Block> NEPTUNE_ATMOSPHERE = registerCoreBlock("neptune_atmosphere", "Neptunian Atmosphere", () -> new AtmosphereBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).noCollission().noOcclusion().isViewBlocking(BlockRegistry::never).isSuffocating(BlockRegistry::never)));
    public static final RegistryObject<Block> NEPTUNE_CORE = registerCoreBlock("neptune_core", "Neptunian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
    public static final RegistryObject<Block> NEPTUNE_DEEPSLATE = registerCoreBlock("neptune_deepslate", "Neptunian Deepslate", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));

    //NEPTUNE'S MOON
    public static final RegistryObject<Block> TRITON_CORE = registerCoreBlock("triton_core", "Tritonian Core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //DWARF PLANETS
//    public static final RegistryObject<Block> PLUTO_CORE = registerCoreBlock("pluto_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> CERES_CORE = registerCoreBlock("ceres_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> MAKEMAKE_CORE = registerCoreBlock("makemake_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> HAUMEA_CORE = registerCoreBlock("haumea_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));
//    public static final RegistryObject<Block> ERIS_CORE = registerCoreBlock("eris_core", () -> new Block(Block.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).noDrops().isValidSpawn(BlockRegistry::never)));

    //---- CELESTIAL OBJECTS -------------------------------------------------------------------------------

    //METEOR
    public static final RegistryObject<Block> METEOR = registerBlockDropsSelf("meteor", "Meteorite", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_BRICKS = registerBlockDropsSelf("meteor_bricks", "Meteorite Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CHISELED_METEOR_BRICKS = registerBlockDropsSelf("chiseled_meteor_bricks", "Chiseled Meteorite Bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_BRICK_STAIRS = registerBlockDropsSelf("meteor_brick_stairs", "Meteorite Brick Stairs", () -> new StairBlock(METEOR_BRICKS.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_BRICK_SLAB = registerBlockDropsSelf("meteor_brick_slab", "Meteorite Brick Slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_BRICK_WALL = registerBlockDropsSelf("meteor_brick_wall", "Meteorite Brick Wall", () -> new WallBlock(Block.Properties.copy(METEOR_BRICKS.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    //    public static final RegistryObject<Block> METEOR_BRICK_PILLAR = BLOCKS.register("meteor_brick_pillar", () -> new Block(Block.Properties.copy(METEOR_BRICKS.get())));

    //METEOR ORE
    public static final RegistryObject<Block> METEOR_EMERALD_ORE = registerBlock("meteor_emerald_ore", "Meteorite Emerald Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_COAL_ORE = registerBlock("meteor_coal_ore", "Meteorite Coal Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_GOLD_ORE = registerBlock("meteor_gold_ore", "Meteorite Gold Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_IRON_ORE = registerBlock("meteor_iron_ore", "Meteorite Iron Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_REDSTONE_ORE = registerBlock("meteor_redstone_ore", "Meteorite Redstone Ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_DIAMOND_ORE = registerBlock("meteor_diamond_ore", "Meteorite Diamond Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_COPPER_ORE = registerBlock("meteor_copper_ore", "Meteorite Copper Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_LAPIS_ORE = registerBlock("meteor_lapis_ore", "Meteorite Lapis Lazuli Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_SULFUR_ORE = registerBlock("meteor_sulfur_ore", "Meteorite Sulfur Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> METEOR_BAUXITE_ORE = registerBlock("meteor_bauxite_ore", "Meteorite Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //METEOR OTHER
    public static final RegistryObject<Block> METEOR_BUTTON = registerBlockDropsSelf("meteor_button", "Meteorite Button", () -> new StoneButtonBlock(Block.Properties.copy(METEOR.get())), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<Block> METEOR_PRESSURE_PLATE = registerBlockDropsSelf("meteor_pressure_plate", "Meteorite Pressure Plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.copy(METEOR.get())), CelestialExploration.CELESTIAL_MISC_TAB);

    //SOLAR BLOCKS
    public static final RegistryObject<Block> SOLAR_PLASMA = registerBlockDropsSelf("solar_plasma", "Solar Plasma", () -> new SolarBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(1.0f).lightLevel((light) -> 20).randomTicks().isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUN_SPOT = registerBlockDropsSelf("sun_spot", "Sun Spot", () -> new SolarBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(1.0f).lightLevel((light) -> 13).randomTicks().isValidSpawn(BlockRegistry::never).hasPostProcess(BlockRegistry::always)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SOLAR_FLARE = registerBlockDropsSelf("solar_flare", "Solar Surface", () -> new SolarFlareBlock(Block.Properties.of(Material.STONE, MaterialColor.NETHER).strength(0.8f).lightLevel((light) -> 15).isValidSpawn(BlockRegistry::never).hasPostProcess(BlockRegistry::always).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- ORE-RELATED -------------------------------------------------------------------------------
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore", "Bauxite Ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = registerBlockDropsSelf("compressed_cobblestone", "Compressed Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_COBBLED_DEEPSLATE = registerBlockDropsSelf("compressed_cobbled_deepslate", "Compressed Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> COMPRESSED_NETHERRACK = registerBlockDropsSelf("compressed_netherrack", "Compressed Netherrack", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_COBBLESTONE = registerBlockDropsSelf("super_compressed_cobblestone", "Super Compressed Cobblestone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_COBBLED_DEEPSLATE = registerBlockDropsSelf("super_compressed_cobbled_deepslate", "Super Compressed Cobbled Deepslate", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> SUPER_COMPRESSED_NETHERRACK = registerBlockDropsSelf("super_compressed_netherrack", "Super Compressed Netherrack", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 8.0f).sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlockDropsSelf("steel_block", "Steel Block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlockDropsSelf("aluminum_block", "Aluminum Block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- SPACESHIP-RELATED -------------------------------------------------------------------------------
    public static final RegistryObject<Block> OXYGEN_COMPRESSOR = registerBlockDropsSelf("oxygen_compressor", "Oxygen Compressor", () -> new OxygenCompressorBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(3.5F).sound(SoundType.METAL)), CelestialExploration.SPACESHIP_TAB);
    public static final RegistryObject<Block> WORKBENCH = registerBlockDropsSelf("workbench", "Workbench", () -> new WorkbenchBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(3.5F).sound(SoundType.METAL)), CelestialExploration.SPACESHIP_TAB);
    public static final RegistryObject<Block> LOX_TANK = registerBlockNoItem("lox_tank", "Liquid Oxygen Tank", () -> new LoxTankBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).noOcclusion().strength(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> STEEL_FRAME = registerBlockDropsSelf("steel_frame", "Steel Frame", () -> new SteelFrameBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).dynamicShape()), CelestialExploration.SPACESHIP_TAB);

    //---- SPACE STATION -------------------------------------------------------------------------------
    public static final RegistryObject<DoorBlock> AIRLOCK_DOOR = registerBlock("airlock_door", "Airlock Door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<TrapDoorBlock> AIRLOCK_TRAPDOOR = registerBlockDropsSelf("airlock_trapdoor", "Airlock Trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<DoorBlock> STEEL_DOOR = registerBlock("steel_door", "Steel Door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<TrapDoorBlock> STEEL_TRAPDOOR = registerBlockDropsSelf("steel_trapdoor", "Steel Trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion().isValidSpawn(BlockRegistry::never)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> STEEL_BUTTON = registerBlockDropsSelf("steel_button", "Steel Button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.5F).noCollission()), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<LadderBlock> STEEL_LADDER = registerBlockDropsSelf("steel_ladder", "Steel Ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.4F).sound(SoundType.LADDER).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<ButtonBlock> AIRLOCK_BUTTON = registerBlockDropsSelf("airlock_button", "Airlock Button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.5F).noCollission()), CelestialExploration.CELESTIAL_MISC_TAB);

    public static final RegistryObject<Block> GLOW_STRIP = registerBlockDropsSelf("glow_strip", "Glow Strip", () -> new GlowStripBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_152607_) -> 15).sound(SoundType.GLASS), false), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<Block> HORIZONTAL_GLOW_STRIP = registerBlockDropsSelf("horizontal_glow_strip", "Horizontal Glow Strip", () -> new GlowStripBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((p_152607_) -> 15).sound(SoundType.GLASS), true), CelestialExploration.CELESTIAL_MISC_TAB);

    public static final RegistryObject<AirlockDoorBlock> AIRLOCK_PANEL_DOOR = registerBlockDropsSelf("airlock_panel_door", "Airlock Panel Door", () -> new AirlockDoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<HangarDoorBlock> HANGAR_DOOR = registerBlockDropsSelf("hangar_door", "Hangar Door", () -> new HangarDoorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()), CelestialExploration.CELESTIAL_MISC_TAB);


    public static final RegistryObject<RotatedDirectionalBlock> INSULATED_PANEL = registerBlockDropsSelf("insulated_panel", "Insulated Panel", () -> new RotatedDirectionalBlock(Block.Properties.of(Material.METAL).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<RotatedDirectionalBlock> INSULATED_PANEL_CORNER = registerBlockDropsSelf("insulated_panel_corner", "Insulated Panel Corner", () -> new RotatedDirectionalBlock(Block.Properties.of(Material.METAL).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PANEL = registerBlockDropsSelf("panel", "Panel", () -> new Block(Block.Properties.of(Material.METAL).strength(3.0f, 3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<StairBlock> PANEL_STAIRS = registerBlockDropsSelf("panel_stairs", "Panel Stairs", () -> new StairBlock(PANEL.get().defaultBlockState(), Block.Properties.copy(PANEL.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<SlabBlock> PANEL_SLAB = registerBlockDropsSelf("panel_slab", "Panel Slab", () -> new SlabBlock(Block.Properties.copy(PANEL.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<WallBlock> PANEL_WALL = registerBlockDropsSelf("panel_wall", "Panel Wall", () -> new WallBlock(Block.Properties.copy(PANEL.get())), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<IronBarsBlock> THIN_PANEL = registerBlockDropsSelf("thin_panel", "Thin Panel", () -> new IronBarsBlock(Block.Properties.of(Material.METAL).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<ButtonBlock> RED_BUTTON = registerBlockDropsSelf("red_button", "Red Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> YELLOW_BUTTON = registerBlockDropsSelf("yellow_button", "Yellow Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> BLUE_BUTTON = registerBlockDropsSelf("blue_button", "Blue Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> GREEN_BUTTON = registerBlockDropsSelf("green_button", "Green Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> WHITE_BUTTON = registerBlockDropsSelf("white_button", "White Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);
    public static final RegistryObject<ButtonBlock> BLACK_BUTTON = registerBlockDropsSelf("black_button", "Black Button", () -> new WoodButtonBlock(Block.Properties.copy(Blocks.GLASS).lightLevel((light) -> 4)), CelestialExploration.CELESTIAL_MISC_TAB);

    public static final RegistryObject<Block> PATHWAY_LIGHT = registerBlockDropsSelf("pathway_light", "Pathway Light", () -> new PathwayLightBlock(Block.Properties.of(Material.METAL).strength(0.1F).sound(SoundType.METAL).lightLevel(litBlockEmission(9))), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<Block> TAXI_STATION = registerCoreBlock("taxi_station", "Taxi Station", () -> new TaxiStationBlock(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.5F).sound(SoundType.METAL)));

    //---- MAG LEV -------------------------------------------------------------------------------
    public static final RegistryObject<Block> MAG_RAIL = registerBlockDropsSelf("mag_rail", "Mag Rail", () -> new MagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)), CelestialExploration.SPACESHIP_TAB);
    public static final RegistryObject<Block> POWERED_MAG_RAIL = registerBlockDropsSelf("powered_mag_rail", "Powered Mag Rail", () -> new PoweredMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL), true), CelestialExploration.SPACESHIP_TAB);
    public static final RegistryObject<Block> DETECTOR_MAG_RAIL = registerBlockDropsSelf("detector_mag_rail", "Detector Mag Rail", () -> new DetectorMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)), CelestialExploration.SPACESHIP_TAB);
    public static final RegistryObject<Block> ACTIVATOR_MAG_RAIL = registerBlockDropsSelf("activator_mag_rail", "Activator Mag Rail", () -> new PoweredMagRailBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.7F).sound(SoundType.METAL)), CelestialExploration.SPACESHIP_TAB);

    //---- GLASS/CERAMICS -------------------------------------------------------------------------------
    //GLASS
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS = registerBlock("luminous_blue_glass", "Luminous Blue Glass", () -> new ConnectedGlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> 9)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS = registerBlock("luminous_white_glass", "Luminous White Glass", () -> new ConnectedGlassBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> 9)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LUMINOUS_BLUE_GLASS_PANE = registerBlock("luminous_blue_glass_pane", "Luminous Blue Glass Pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> 9)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LUMINOUS_WHITE_GLASS_PANE = registerBlock("luminous_white_glass_pane", "Luminous White Glass Pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().lightLevel((light) -> 9)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<Block> REINFORCED_GLASS = registerBlock("reinforced_glass", "Reinforced Glass", () -> new ConnectedGlassBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F, 4.0F).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_PANE = registerBlock("reinforced_glass_pane", "Reinforced Glass Pane", () -> new ConnectedGlassPaneBlock(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F, 4.0F).sound(SoundType.GLASS).isValidSpawn(BlockRegistry::never).isRedstoneConductor(BlockRegistry::never).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //CERAMICS
    public static final RegistryObject<Block> SILICA = registerBlockDropsSelf("silica", "Silica", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    public static final RegistryObject<IronBarsBlock> CERAMIC_TILE = registerBlock("ceramic_tile", "Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CERAMIC = registerBlock("ceramic", "Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> WHITE_CERAMIC = registerBlock("white_ceramic", "White Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> WHITE_CERAMIC_TILE = registerBlock("white_ceramic_tile", "White Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LIGHT_GREY_CERAMIC = registerBlock("light_grey_ceramic", "Light Grey Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> LIGHT_GREY_CERAMIC_TILE = registerBlock("light_grey_ceramic_tile", "Light Grey Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> GREY_CERAMIC = registerBlock("grey_ceramic", "Grey Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> GREY_CERAMIC_TILE = registerBlock("grey_ceramic_tile", "Grey Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> BLACK_CERAMIC = registerBlock("black_ceramic", "Black Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> BLACK_CERAMIC_TILE = registerBlock("black_ceramic_tile", "Black Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PURPLE_CERAMIC = registerBlock("purple_ceramic", "Purple Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> PURPLE_CERAMIC_TILE = registerBlock("purple_ceramic_tile", "Purple Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> MAGENTA_CERAMIC = registerBlock("magenta_ceramic", "Magenta Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> MAGENTA_CERAMIC_TILE = registerBlock("magenta_ceramic_tile", "Magenta Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> BLUE_CERAMIC = registerBlock("blue_ceramic", "Blue Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> BLUE_CERAMIC_TILE = registerBlock("blue_ceramic_tile", "Blue Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LIGHT_BLUE_CERAMIC = registerBlock("light_blue_ceramic", "Light Blue Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> LIGHT_BLUE_CERAMIC_TILE = registerBlock("light_blue_ceramic_tile", "Light Blue Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> CYAN_CERAMIC = registerBlock("cyan_ceramic", "Cyan Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> CYAN_CERAMIC_TILE = registerBlock("cyan_ceramic_tile", "Cyan Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> GREEN_CERAMIC = registerBlock("green_ceramic", "Green Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> GREEN_CERAMIC_TILE = registerBlock("green_ceramic_tile", "Green Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> LIME_CERAMIC = registerBlock("lime_ceramic", "Lime Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> LIME_CERAMIC_TILE = registerBlock("lime_ceramic_tile", "Lime Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> YELLOW_CERAMIC = registerBlock("yellow_ceramic", "Yellow Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> YELLOW_CERAMIC_TILE = registerBlock("yellow_ceramic_tile", "Yellow Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> ORANGE_CERAMIC = registerBlock("orange_ceramic", "Orange Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> ORANGE_CERAMIC_TILE = registerBlock("orange_ceramic_tile", "Orange Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> BROWN_CERAMIC = registerBlock("brown_ceramic", "Brown Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> BROWN_CERAMIC_TILE = registerBlock("brown_ceramic_tile", "Brown Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> RED_CERAMIC = registerBlock("red_ceramic", "Red Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> RED_CERAMIC_TILE = registerBlock("red_ceramic_tile", "Red Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PINK_CERAMIC = registerBlock("pink_ceramic", "Pink Ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).requiresCorrectToolForDrops().sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<IronBarsBlock> PINK_CERAMIC_TILE = registerBlock("pink_ceramic_tile", "Pink Ceramic Tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).requiresCorrectToolForDrops().noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);

   public static final RegistryObject<Block> PAINTED_WHITE_CERAMIC = registerBlock("painted_white_ceramic", "Painted White Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_LIGHT_GREY_CERAMIC = registerBlock("painted_light_grey_ceramic", "Painted Light Grey Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_GREY_CERAMIC = registerBlock("painted_grey_ceramic", "Painted Grey Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_BLACK_CERAMIC = registerBlock("painted_black_ceramic", "Painted Black Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_PURPLE_CERAMIC = registerBlock("painted_purple_ceramic", "Painted Purple Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_MAGENTA_CERAMIC = registerBlock("painted_magenta_ceramic", "Painted Magenta Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_BLUE_CERAMIC = registerBlock("painted_blue_ceramic", "Painted Blue Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_LIGHT_BLUE_CERAMIC = registerBlock("painted_light_blue_ceramic", "Painted Light Blue Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_CYAN_CERAMIC = registerBlock("painted_cyan_ceramic", "Painted Cyan Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_GREEN_CERAMIC = registerBlock("painted_green_ceramic", "Painted Green Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_LIME_CERAMIC = registerBlock("painted_lime_ceramic", "Painted Lime Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_YELLOW_CERAMIC = registerBlock("painted_yellow_ceramic", "Painted Yellow Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_ORANGE_CERAMIC = registerBlock("painted_orange_ceramic", "Painted Orange Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_BROWN_CERAMIC = registerBlock("painted_brown_ceramic", "Painted Brown Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_RED_CERAMIC = registerBlock("painted_red_ceramic", "Painted Red Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PAINTED_PINK_CERAMIC = registerBlock("painted_pink_ceramic", "Painted Pink Ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.CELESTIAL_BLOCKS_TAB);

    //---- PORTALS -------------------------------------------------------------------------------
    public static final RegistryObject<MarsPortalBlock> MARS_PORTAL = BLOCKS.register("mars_portal", MarsPortalBlock::new);
    public static final RegistryObject<MoonPortalBlock> MOON_PORTAL = BLOCKS.register("moon_portal", MoonPortalBlock::new);
    public static final RegistryObject<VenusPortalBlock> VENUS_PORTAL = BLOCKS.register("venus_portal", VenusPortalBlock::new);
    public static final RegistryObject<MercuryPortalBlock> MERCURY_PORTAL = BLOCKS.register("mercury_portal", MercuryPortalBlock::new);
    public static final RegistryObject<JupiterPortalBlock> JUPITER_PORTAL = BLOCKS.register("jupiter_portal", JupiterPortalBlock::new);

    //---- MISC -------------------------------------------------------------------------------
    public static final RegistryObject<Block> DRY_ICE = registerBlockDropsSelf("dry_ice", "Dry Ice", () -> new DryIceBlock(Block.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
    public static final RegistryObject<Block> PLANET_CHART = registerBlockDropsSelf("planet_chart", "Planet Chart", () -> new PlanetChartBlock(Block.Properties.of(Material.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);
//    public static final RegistryObject<Block> GRINDING_WHEEL = registerBlockDropsSelf("grinding_wheel", "Grinding Wheel", () -> new Block(Block.Properties.of(Material.STONE).strength(0.5F).sound(SoundType.STONE).noOcclusion()), CelestialExploration.CELESTIAL_BLOCKS_TAB);


    public static final RegistryObject<Block> LURKER_HEAD = BLOCKS.register("lurker_head", () -> new SkullBlock(CelestialSkullRenderer.Types.LURKER, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
    public static final RegistryObject<Block> LURKER_WALL_HEAD = BLOCKS.register("lurker_wall_head", () -> new WallSkullBlock(CelestialSkullRenderer.Types.LURKER, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).lootFrom(LURKER_HEAD)));
    public static final RegistryObject<Block> VOIDED_HEAD = BLOCKS.register("voided_head", () -> new SkullBlock(CelestialSkullRenderer.Types.VOIDED, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F)));
    public static final RegistryObject<Block> VOIDED_WALL_HEAD = BLOCKS.register("voided_wall_head", () -> new WallSkullBlock(CelestialSkullRenderer.Types.VOIDED, BlockBehaviour.Properties.of(Material.DECORATION).strength(1.0F).lootFrom(VOIDED_HEAD)));


    	public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL = registerBlockDropsSelf("solar_panel", "Solar Panel", () -> new SolarPanelBlock(Block.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS)), CelestialExploration.SPACESHIP_TAB);

    //	public static final RegistryObject<Block> LAUNCH_PAD = BLOCKS.register("launch_pad", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    //	public static final RegistryObject<Block> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(Block.Properties.of(Material.DECORATION, MaterialColor.METAL).noCollission().sound(SoundType.METAL).lightLevel(litBlockEmission(1))));
    //	public static final RegistryObject<Block> SOLAR_LANTERN = BLOCKS.register("solar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> 20)));
    //	public static final RegistryObject<Block> IGNEOUS_ROCK = BLOCKS.register("igneous_rock", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE)));
    //	public static final RegistryObject<Block> ECLIPSE_LANTERN = BLOCKS.register("eclipse_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> 8)));
    //	public static final RegistryObject<Block> STEEL_BLOCK_STAIRS = BLOCKS.register("steel_block_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), Block.Properties.copy(STEEL_BLOCK.get())));
    //	public static final RegistryObject<Block> STEEL_BLOCK_SLAB = BLOCKS.register("steel_block_slab", () -> new SlabBlock(Block.Properties.copy(STEEL_BLOCK.get())));

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