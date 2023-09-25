package com.shim.celestialexploration.registry;

import java.util.function.ToIntFunction;


import com.shim.celestialexploration.CelestialExploration;

import com.shim.celestialexploration.blocks.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockRegistry {

	private BlockState defaultState;

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CelestialExploration.MODID);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}


// 	public static final Block STONE = register("stone", new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	  

	//Blocks
	//LUNAR BLOCKS
	public static final RegistryObject<Block> MOON_STONE = BLOCKS.register("moon_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));	
	public static final RegistryObject<Block> MOON_SAND = BLOCKS.register("moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> GLOWING_MOON_SAND = BLOCKS.register("glowing_moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((p_235455_0_) -> {
		return 2;
	})));
	public static final RegistryObject<Block> MOON_BRICKS = BLOCKS.register("moon_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_MOON_BRICKS = BLOCKS.register("chiseled_moon_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOON_IRON_ORE = BLOCKS.register("moon_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOON_REDSTONE_ORE = BLOCKS.register("moon_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LUNAR_LANTERN = BLOCKS.register("lunar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
		return 12;
	})));
	public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new StairBlock(MOON_BRICKS.get().defaultBlockState(), Block.Properties.copy(MOON_BRICKS.get())));
	public static final RegistryObject<Block> MOON_BRICK_SLAB = BLOCKS.register("moon_brick_slab", () -> new SlabBlock(Block.Properties.copy(MOON_BRICKS.get())));
	public static final RegistryObject<Block> MOON_BRICK_WALL = BLOCKS.register("moon_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));
	
	

	//MARTIAN BLOCKS
	public static final RegistryObject<Block> MARS_STONE = BLOCKS.register("mars_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));	
	public static final RegistryObject<Block> MARS_SAND = BLOCKS.register("mars_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MARS_BRICKS = BLOCKS.register("mars_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_MARS_BRICKS = BLOCKS.register("chiseled_mars_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MARS_IRON_ORE = BLOCKS.register("mars_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MARS_REDSTONE_ORE = BLOCKS.register("mars_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new StairBlock(MARS_BRICKS.get().defaultBlockState(), Block.Properties.copy(MARS_BRICKS.get())));
	public static final RegistryObject<Block> MARS_BRICK_SLAB = BLOCKS.register("mars_brick_slab", () -> new SlabBlock(Block.Properties.copy(MARS_BRICKS.get())));
	public static final RegistryObject<Block> MARS_BRICK_WALL = BLOCKS.register("mars_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));

	//	public static final RegistryObject<Block> MARS_SOIL = BLOCKS.register("mars_soil", () -> new MarsFarmlandBlock(Block.Properties.of(Material.DIRT).strength(0.6f).sound(SoundType.GRAVEL)));

//	//VENUS (VENETIAN?) BLOCKS
//	public static final RegistryObject<Block> VENUS_STONE = BLOCKS.register("venus_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));	
//	public static final RegistryObject<Block> VENUS_SAND = BLOCKS.register("venus_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
//	public static final RegistryObject<Block> VENUS_BRICK = BLOCKS.register("venus_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> CHISELED_VENUS_BRICK = BLOCKS.register("chiseled_venus_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> VENUS_IRON_ORE = BLOCKS.register("venus_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> VENUS_REDSTONE_ORE = BLOCKS.register("venus_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> VENUS_BRICK_STAIRS = BLOCKS.register("venus_brick_stairs", () -> new StairBlock(VENUS_BRICK.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICK.get())));
//	public static final RegistryObject<Block> VENUS_BRICK_SLAB = BLOCKS.register("venus_brick_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_BRICK.get())));

//	//MERCURY BLOCKS
//	public static final RegistryObject<Block> MERCURY_STONE = BLOCKS.register("mercury_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));	
//	public static final RegistryObject<Block> MERCURY_SAND = BLOCKS.register("mercury_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
//	public static final RegistryObject<Block> MERCURY_BRICK = BLOCKS.register("mercury_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> CHISELED_MERCURY_BRICK = BLOCKS.register("chiseled_mercury_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> MERCURY_IRON_ORE = BLOCKS.register("mercury_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> MERCURY_REDSTONE_ORE = BLOCKS.register("mercury_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> MERCURY_BRICK_STAIRS = BLOCKS.register("mercury_brick_stairs", () -> new StairBlock(VENUS_BRICK.get().defaultBlockState(), Block.Properties.copy(MERCURY_BRICK.get())));
//	public static final RegistryObject<Block> MERCURY_BRICK_SLAB = BLOCKS.register("mercury_brick_slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_BRICK.get())));


	//METEOR BLOCKS
	public static final RegistryObject<Block> METEOR = BLOCKS.register("meteor", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_EMERALD_ORE = BLOCKS.register("meteor_emerald_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_COAL_ORE = BLOCKS.register("meteor_coal_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_GOLD_ORE = BLOCKS.register("meteor_gold_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_IRON_ORE = BLOCKS.register("meteor_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_REDSTONE_ORE = BLOCKS.register("meteor_redstone_ore", () -> new RedStoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_DIAMOND_ORE = BLOCKS.register("meteor_diamond_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_COPPER_ORE = BLOCKS.register("meteor_copper_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_LAPIS_ORE = BLOCKS.register("meteor_lapis_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE)));		   
	public static final RegistryObject<Block> METEOR_BRICKS = BLOCKS.register("meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_METEOR_BRICKS = BLOCKS.register("chiseled_meteor_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new StairBlock(METEOR_BRICKS.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICKS.get())));
	public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICKS.get())));
	public static final RegistryObject<Block> METEOR_BRICK_WALL = BLOCKS.register("meteor_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(6.0f).sound(SoundType.STONE)));

	
	
	
	//POWER-RELATED BLOCKS
	public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL = BLOCKS.register("solar_panel", SolarPanelBlock::new);
	
	
//	public static final RegistryObject<Block> GEYSER = BLOCKS.register("geyser", () -> new GeyserBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(0.5f).sound(SoundType.STONE)));
//	public static final RegistryObject<Block> GEYSER_COLUMN = BLOCKS.register("geyser_column", () -> new GeyserColumnBlock(Block.Properties.of(Material.BUBBLE_COLUMN).noCollission().noDrops()));

	//PORTAL BLOCKS
	public static final RegistryObject<Block> MARS_PORTAL = BLOCKS.register("mars_portal", MarsPortalBlock::new);
	public static final RegistryObject<Block> MOON_PORTAL = BLOCKS.register("moon_portal", MoonPortalBlock::new);


	//OTHER BLOCKS
	public static final RegistryObject<Block> SOLAR_LANTERN = BLOCKS.register("solar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
		return 20;
	})));

	public static final RegistryObject<Block> IGNEOUS_ROCK = BLOCKS.register("igneous_rock", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));



//	public static final RegistryObject<Block> ECLIPSE_LANTERN = BLOCKS.register("eclipse_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.FIRE).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
//		return 8;
//	})));

//	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
//	public static final RegistryObject<Block> STEEL_BLOCK_STAIRS = BLOCKS.register("steel_block_stairs", () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), Block.Properties.copy(STEEL_BLOCK.get())));
//	public static final RegistryObject<Block> STEEL_BLOCK_SLAB = BLOCKS.register("steel_block_slab", () -> new SlabBlock(Block.Properties.copy(STEEL_BLOCK.get())));


//	public static final RegistryObject<Block> DRY_ICE = BLOCKS.register("dry_ice", () -> new IceBlock(Block.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
//	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur", () -> new FlowingFluidBlock(RegistryFluids.SULFUR, AbstractBlock.Properties.of(Material.LAVA).noCollission().randomTicks().strength(100.0F).lightLevel((p_235418_0_) -> {
//		return 15;
//	}).noDrops()));	


	public static final RegistryObject<Block> STEEL_FRAME = BLOCKS.register("steel_frame", () -> new SteelFrameBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
//	public static final RegistryObject<Block> LAUNCH_PAD = BLOCKS.register("launch_pad", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<IronBarsBlock> CERAMIC_TILE = BLOCKS.register("ceramic_tile", () -> new IronBarsBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> CERAMIC = BLOCKS.register("ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> WHITE_CERAMIC = BLOCKS.register("white_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIGHT_GREY_CERAMIC = BLOCKS.register("light_grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GREY_CERAMIC = BLOCKS.register("grey_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BLACK_CERAMIC = BLOCKS.register("black_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> PURPLE_CERAMIC = BLOCKS.register("purple_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> MAGENTA_CERAMIC = BLOCKS.register("magenta_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BLUE_CERAMIC = BLOCKS.register("blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIGHT_BLUE_CERAMIC = BLOCKS.register("light_blue_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> CYAN_CERAMIC = BLOCKS.register("cyan_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> GREEN_CERAMIC = BLOCKS.register("green_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> LIME_CERAMIC = BLOCKS.register("lime_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> YELLOW_CERAMIC = BLOCKS.register("yellow_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> ORANGE_CERAMIC = BLOCKS.register("orange_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> BROWN_CERAMIC = BLOCKS.register("brown_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> RED_CERAMIC = BLOCKS.register("red_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> PINK_CERAMIC = BLOCKS.register("pink_ceramic", () -> new GlazedTerracottaBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));

	//	public static final RegistryObject<Block> THICK_CARBON_AIR = BLOCKS.register("thick_carbon_air", () -> new AtmosphereBlock(AbstractBlock.Properties.of(Material.GLASS)
//			.strength(0.3F).sound(SoundType.GLASS).noCollission()//.air()
//			.noOcclusion().isRedstoneConductor(RegistryBlocks::never)
//			.isSuffocating(RegistryBlocks::never).isViewBlocking(RegistryBlocks::never)));
//	public static final RegistryObject<Block> FUEL_TANK = BLOCKS.register("fuel_tank", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).air()));


//	public static final RegistryObject<Block> ASSEMBLY_STATION = BLOCKS.register("assembly_station", () -> new AssemblyStationBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> OXYGEN_COMPRESSOR = BLOCKS.register("oxygen_compressor", () -> new OxygenCompressorBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).lightLevel(litBlockEmission(10)).strength(5.0F, 6.0F).sound(SoundType.METAL)));


//	public static final RegistryObject<Block> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(Block.Properties.of(Material.DECORATION, MaterialColor.METAL).noCollission().sound(SoundType.METAL).lightLevel(litBlockEmission(1))));

	public static final RegistryObject<Block> LOX_TANK = BLOCKS.register("lox_tank", () -> new LoxTankBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE)));



	//CUSTOM BLOCK TAGS
	public static final TagKey<Block> MARS_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_tag"));
	public static final TagKey<Block> MARS_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone_tag"));
	public static final TagKey<Block> MOON_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_tag"));
	public static final TagKey<Block> MOON_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone_tag"));
	public static final TagKey<Block> METEOR_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_tag"));
	public static final TagKey<Block> METEOR_STONE_TAG = BlockTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_stone_tag"));

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


	


}