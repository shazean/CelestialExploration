package mod.shim.celestialexploration.registry;

import java.util.function.ToIntFunction;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.blocks.AssemblyStationBlock;
import mod.shim.celestialexploration.blocks.AtmosphereBlock;
import mod.shim.celestialexploration.blocks.MarsPortalBlock;
import mod.shim.celestialexploration.blocks.OxygenCompressorBlock;
import mod.shim.celestialexploration.blocks.SolarPanelBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.IceBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBlocks {


	private BlockState defaultState;
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
	
	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	

		
	//Blocks
	//LUNAR BLOCKS
	public static final RegistryObject<Block> MOON_STONE = BLOCKS.register("moon_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
	public static final RegistryObject<Block> MOON_SAND = BLOCKS.register("moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> GLOWING_MOON_SAND = BLOCKS.register("glowing_moon_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((p_235455_0_) -> {
	      return 4;
	   })));
	public static final RegistryObject<Block> MOON_BRICK = BLOCKS.register("moon_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> CHISELED_MOON_BRICK = BLOCKS.register("chiseled_moon_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MOON_IRON_ORE = BLOCKS.register("moon_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MOON_REDSTONE_ORE = BLOCKS.register("moon_redstone_ore", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> LUNAR_LANTERN = BLOCKS.register("lunar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
	      return 15;
	   })));
	public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new StairsBlock(MOON_BRICK.get().defaultBlockState(), Block.Properties.copy(MOON_BRICK.get())));
	public static final RegistryObject<Block> MOON_BRICK_SLAB = BLOCKS.register("moon_brick_slab", () -> new SlabBlock(Block.Properties.copy(MOON_BRICK.get())));


	//MARTIAN BLOCKS
	public static final RegistryObject<Block> MARS_STONE = BLOCKS.register("mars_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
	public static final RegistryObject<Block> MARS_SAND = BLOCKS.register("mars_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MARS_BRICK = BLOCKS.register("mars_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> CHISELED_MARS_BRICK = BLOCKS.register("chiseled_mars_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MARS_IRON_ORE = BLOCKS.register("mars_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MARS_REDSTONE_ORE = BLOCKS.register("mars_redstone_ore", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new StairsBlock(MARS_BRICK.get().defaultBlockState(), Block.Properties.copy(MARS_BRICK.get())));
	public static final RegistryObject<Block> MARS_BRICK_SLAB = BLOCKS.register("mars_brick_slab", () -> new SlabBlock(Block.Properties.copy(MARS_BRICK.get())));

	//VENUS (VENETIAN?) BLOCKS
	public static final RegistryObject<Block> VENUS_STONE = BLOCKS.register("venus_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
	public static final RegistryObject<Block> VENUS_SAND = BLOCKS.register("venus_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> VENUS_BRICK = BLOCKS.register("venus_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> CHISELED_VENUS_BRICK = BLOCKS.register("chiseled_venus_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> VENUS_IRON_ORE = BLOCKS.register("venus_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> VENUS_REDSTONE_ORE = BLOCKS.register("venus_redstone_ore", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> VENUS_BRICK_STAIRS = BLOCKS.register("venus_brick_stairs", () -> new StairsBlock(VENUS_BRICK.get().defaultBlockState(), Block.Properties.copy(VENUS_BRICK.get())));
	public static final RegistryObject<Block> VENUS_BRICK_SLAB = BLOCKS.register("venus_brick_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_BRICK.get())));

	//MERCURY BLOCKS
	public static final RegistryObject<Block> MERCURY_STONE = BLOCKS.register("mercury_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
	public static final RegistryObject<Block> MERCURY_SAND = BLOCKS.register("mercury_sand", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> MERCURY_BRICK = BLOCKS.register("mercury_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> CHISELED_MERCURY_BRICK = BLOCKS.register("chiseled_mercury_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MERCURY_IRON_ORE = BLOCKS.register("mercury_iron_ore", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MERCURY_REDSTONE_ORE = BLOCKS.register("mercury_redstone_ore", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> MERCURY_BRICK_STAIRS = BLOCKS.register("mercury_brick_stairs", () -> new StairsBlock(VENUS_BRICK.get().defaultBlockState(), Block.Properties.copy(MERCURY_BRICK.get())));
	public static final RegistryObject<Block> MERCURY_BRICK_SLAB = BLOCKS.register("mercury_brick_slab", () -> new SlabBlock(Block.Properties.copy(MERCURY_BRICK.get())));

	
	//METEOR BLOCKS
	public static final RegistryObject<Block> METEOR = BLOCKS.register("meteor", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_EMERALD_ORE = BLOCKS.register("meteor_emerald_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_COAL_ORE = BLOCKS.register("meteor_coal_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_GOLD_ORE = BLOCKS.register("meteor_gold_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_IRON_ORE = BLOCKS.register("meteor_iron_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_REDSTONE_ORE = BLOCKS.register("meteor_redstone_ore", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_DIAMOND_ORE = BLOCKS.register("meteor_diamond_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_LAPIS_ORE = BLOCKS.register("meteor_lapis_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
	public static final RegistryObject<Block> METEOR_BRICK = BLOCKS.register("meteor_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> CHISELED_METEOR_BRICK = BLOCKS.register("chiseled_meteor_brick", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new StairsBlock(METEOR_BRICK.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICK.get())));
	public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICK.get())));
	
	
	

	
	
	//OTHER BLOCKS
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> DRY_ICE = BLOCKS.register("dry_ice", () -> new IceBlock(Block.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur", () -> new FlowingFluidBlock(RegistryFluids.SULFUR, AbstractBlock.Properties.of(Material.LAVA).noCollission().randomTicks().strength(100.0F).lightLevel((p_235418_0_) -> {
	      return 15;
	   }).noDrops()));	
	
	
//	public static final RegistryObject<Block> MARS_PORTAL = BLOCKS.register("mars_portal", () -> new MarsPortalBlock(AbstractBlock.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((p_235463_0_) -> {
//		      return 11;
//		})));

	public static final RegistryObject<Block> OXYGEN_COMPRESSOR = BLOCKS.register("oxygen_compressor", () -> new OxygenCompressorBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel(litBlockEmission(13))));

	
	
	public static final RegistryObject<Block> STEEL_FRAME = BLOCKS.register("steel_frame", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> LAUNCH_PAD = BLOCKS.register("launch_pad", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> CERAMIC_TILE = BLOCKS.register("ceramic_tile", () -> new PaneBlock(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> CERAMIC = BLOCKS.register("ceramic", () -> new Block(Block.Properties.of(Material.CLAY, MaterialColor.CLAY).strength(0.3F).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> THICK_CARBON_AIR = BLOCKS.register("thick_carbon_air", () -> new AtmosphereBlock(AbstractBlock.Properties.of(Material.GLASS)
			.strength(0.3F).sound(SoundType.GLASS)
			.noCollission()
//			.air()
			.noOcclusion()
			.isRedstoneConductor(RegistryBlocks::never)
			.isSuffocating(RegistryBlocks::never)
			.isViewBlocking(RegistryBlocks::never)));
	public static final RegistryObject<Block> FUEL_TANK = BLOCKS.register("fuel_tank", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).air()));
	
	
	public static final RegistryObject<Block> ASSEMBLY_STATION = BLOCKS.register("assembly_station", () -> new AssemblyStationBlock(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));

	   public static final RegistryObject<Block> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(Block.Properties.of(Material.DECORATION, MaterialColor.METAL).noCollission().sound(SoundType.METAL).lightLevel(litBlockEmission(1))));
	
	
	 public final BlockState getDefaultState() {
	      return this.defaultState;
	   }	 

	 
	 
	   private static ToIntFunction<BlockState> litBlockEmission(int p_235420_0_) {
		      return (p_235421_1_) -> {
		         return p_235421_1_.getValue(BlockStateProperties.LIT) ? p_235420_0_ : 0;
		      };
		   }

	 
	   private static boolean never(BlockState p_235436_0_, IBlockReader p_235436_1_, BlockPos p_235436_2_) {
		      return false;
		   }

	 
}
