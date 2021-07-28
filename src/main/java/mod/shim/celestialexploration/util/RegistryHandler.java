//package mod.shim.celestialexploration.util;
//
//import mod.shim.celestialexploration.Main;
//
//
//import mod.shim.celestialexploration.blocks.BlockItemBase;
//import mod.shim.celestialexploration.items.ItemBase;
//import mod.shim.celestialexploration.items.SpaceSuitArmor;
//import mod.shim.celestialexploration.tools.ModArmorMaterial;
//import mod.shim.celestialexploration.tools.ModItemTier;
//import net.minecraft.block.AirBlock;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.FlowingFluidBlock;
//import net.minecraft.block.IceBlock;
//import net.minecraft.block.OreBlock;
//import net.minecraft.block.RedstoneOreBlock;
//import net.minecraft.block.SandBlock;
//import net.minecraft.block.SlabBlock;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.StairsBlock;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.material.MaterialColor;
//import net.minecraft.entity.EntityType;
//import net.minecraft.fluid.FlowingFluid;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.fluid.LavaFluid;
//import net.minecraft.fluid.LavaFluid.Source;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.ArmorMaterial;
//import net.minecraft.item.AxeItem;
//import net.minecraft.item.BucketItem;
//import net.minecraft.item.HoeItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.Items;
//import net.minecraft.item.PickaxeItem;
//import net.minecraft.item.ShovelItem;
//import net.minecraft.item.SwordItem;
//import net.minecraft.util.registry.Registry;
//import net.minecraftforge.common.ToolType;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class RegistryHandler {
//	
//
//	private BlockState defaultState;
//	
//	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
//	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
////	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);
//
////	public static final DeferredRegister<ChunkGeneratorType<?, ?>> CHUNK_GENERATOR_TYPES = new DeferredRegister<>(ForgeRegistries.CHUNK_GENERATOR_TYPES, Main.MODID);
//	
//	
//	public static void init() {
//		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
//		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
////		FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
//	}
//
//	
////   public static final RegistryObject<Flowing> FLOWING_SULFUR = FLUIDS.register("flowing_sulfur", () -> new SulfurFluid.Flowing());
////   public static final RegistryObject<mod.shim.celestialexploration.fluid.SulfurFluid.Source> SULFUR = FLUIDS.register("sulfur", () -> new SulfurFluid.Source());
//
////	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur", () -> new FlowingFluidBlock(CelestialFluids.SULFUR, AbstractBlock.Properties.of(Material.LAVA).noCollission().randomTicks().strength(100.0F).lightLevel((p_235418_0_) -> {
////	      return 15;
////	   }).noDrops()));	
//
//   
//	//Items
//	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ItemBase::new);
//	public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", ItemBase::new);
//	public static final RegistryObject<Item> LIQUID_OXYGEN = ITEMS.register("liquid_oxygen",  ItemBase::new);
//	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", ItemBase::new);
//
//	
//	//Blocks
//	//LUNAR BLOCKS
//	public static final RegistryObject<Block> MOON_ROCK_BLOCK = BLOCKS.register("moon_rock_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> MOON_SAND_BLOCK = BLOCKS.register("moon_sand_block", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
//	public static final RegistryObject<Block> GLOWING_MOON_SAND_BLOCK = BLOCKS.register("glowing_moon_sand_block", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(0.5F).sound(SoundType.SAND).lightLevel((p_235455_0_) -> {
//	      return 4;
//	   })));
//	public static final RegistryObject<Block> MOON_BRICK_BLOCK = BLOCKS.register("moon_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> CHISELED_MOON_BRICK_BLOCK = BLOCKS.register("chiseled_moon_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
////	public static final RegistryObject<Block> MOON_COAL_BLOCK = BLOCKS.register("moon_coal_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> MOON_IRON_BLOCK = BLOCKS.register("moon_iron_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> MOON_REDSTONE_BLOCK = BLOCKS.register("moon_redstone_block", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> LUNAR_LANTERN = BLOCKS.register("lunar_lantern", () -> new Block(Block.Properties.of(Material.GLASS, MaterialColor.QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235455_0_) -> {
//	      return 15;
//	   })));
//
//	//MARTIAN BLOCKS
//	public static final RegistryObject<Block> MARS_ROCK_BLOCK = BLOCKS.register("mars_rock_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> MARS_SAND_BLOCK = BLOCKS.register("mars_sand_block", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
//	public static final RegistryObject<Block> MARS_BRICK_BLOCK = BLOCKS.register("mars_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> CHISELED_MARS_BRICK_BLOCK = BLOCKS.register("chiseled_mars_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
////	public static final RegistryObject<Block> MARS_COAL_BLOCK = BLOCKS.register("mars_coal_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> MARS_IRON_BLOCK = BLOCKS.register("mars_iron_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> MARS_REDSTONE_BLOCK = BLOCKS.register("mars_redstone_block", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//
//	//VENUS (VENETIAN?) BLOCKS
//	public static final RegistryObject<Block> VENUS_ROCK_BLOCK = BLOCKS.register("venus_rock_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> VENUS_SAND_BLOCK = BLOCKS.register("venus_sand_block", () -> new SandBlock(0xE7E2E2, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
//	public static final RegistryObject<Block> VENUS_BRICK_BLOCK = BLOCKS.register("venus_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> CHISELED_VENUS_BRICK_BLOCK = BLOCKS.register("chiseled_venus_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
////	public static final RegistryObject<Block> VENUS_COAL_BLOCK = BLOCKS.register("venus_coal_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));	
//	public static final RegistryObject<Block> VENUS_IRON_BLOCK = BLOCKS.register("venus_iron_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> VENUS_REDSTONE_BLOCK = BLOCKS.register("venus_redstone_block", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//
//	//METEOR BLOCKS
//	public static final RegistryObject<Block> METEOR_BLOCK = BLOCKS.register("meteor_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_EMERALD_ORE_BLOCK = BLOCKS.register("meteor_emerald_ore_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_COAL_ORE_BLOCK = BLOCKS.register("meteor_coal_ore_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_GOLD_ORE_BLOCK = BLOCKS.register("meteor_gold_ore_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_IRON_ORE_BLOCK = BLOCKS.register("meteor_iron_ore_block", () -> new Block(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_REDSTONE_ORE_BLOCK = BLOCKS.register("meteor_redstone_ore_block", () -> new RedstoneOreBlock(Block.Properties.of(Material.STONE).strength(2.0f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_DIAMOND_ORE_BLOCK = BLOCKS.register("meteor_diamond_ore_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_LAPIS_ORE_BLOCK = BLOCKS.register("meteor_lapis_ore_block", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));		   
//	public static final RegistryObject<Block> METEOR_BRICK_BLOCK = BLOCKS.register("meteor_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	public static final RegistryObject<Block> CHISELED_METEOR_BRICK_BLOCK = BLOCKS.register("chiseled_meteor_brick_block", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5f, 6.0f).sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
//	
//	public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new StairsBlock(MARS_BRICK_BLOCK.get().defaultBlockState(), Block.Properties.copy(MARS_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> MARS_BRICK_STAIRS_ITEM = ITEMS.register("mars_brick_stairs", () -> new BlockItemBase(MARS_BRICK_STAIRS.get()));
//	public static final RegistryObject<Block> MARS_BRICK_SLAB = BLOCKS.register("mars_brick_slab", () -> new SlabBlock(Block.Properties.copy(MARS_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> MARS_BRICK_SLAB_ITEM = ITEMS.register("mars_brick_slab", () -> new BlockItemBase(MARS_BRICK_SLAB.get()));
//
//	public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new StairsBlock(MOON_BRICK_BLOCK.get().defaultBlockState(), Block.Properties.copy(MARS_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> MOON_BRICK_STAIRS_ITEM = ITEMS.register("moon_brick_stairs", () -> new BlockItemBase(MOON_BRICK_STAIRS.get()));
//	public static final RegistryObject<Block> MOON_BRICK_SLAB = BLOCKS.register("moon_brick_slab", () -> new SlabBlock(Block.Properties.copy(MOON_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> MOON_BRICK_SLAB_ITEM = ITEMS.register("moon_brick_slab", () -> new BlockItemBase(MOON_BRICK_SLAB.get()));
//
//	public static final RegistryObject<Block> VENUS_BRICK_STAIRS = BLOCKS.register("venus_brick_stairs", () -> new StairsBlock(VENUS_BRICK_BLOCK.get().defaultBlockState(), Block.Properties.copy(MOON_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> VENUS_BRICK_STAIRS_ITEM = ITEMS.register("venus_brick_stairs", () -> new BlockItemBase(VENUS_BRICK_STAIRS.get()));
//	public static final RegistryObject<Block> VENUS_BRICK_SLAB = BLOCKS.register("venus_brick_slab", () -> new SlabBlock(Block.Properties.copy(VENUS_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> VENUS_BRICK_SLAB_ITEM = ITEMS.register("venus_brick_slab", () -> new BlockItemBase(VENUS_BRICK_SLAB.get()));
//
//	public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new StairsBlock(METEOR_BRICK_BLOCK.get().defaultBlockState(), Block.Properties.copy(METEOR_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> METEOR_BRICK_STAIRS_ITEM = ITEMS.register("meteor_brick_stairs", () -> new BlockItemBase(METEOR_BRICK_STAIRS.get()));
//	public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new SlabBlock(Block.Properties.copy(METEOR_BRICK_BLOCK.get())));
//	public static final RegistryObject<Item> METEOR_BRICK_SLAB_ITEM = ITEMS.register("meteor_brick_slab", () -> new BlockItemBase(METEOR_BRICK_SLAB.get()));
//
//	
////	public static final Item PURPUR_STAIRS = registerBlock(Blocks.PURPUR_STAIRS, ItemGroup.TAB_BUILDING_BLOCKS);
//
//	
////	   public static final Block OAK_STAIRS = register("oak_stairs", new StairsBlock(OAK_PLANKS.defaultBlockState(), AbstractBlock.Properties.copy(OAK_PLANKS)));
//
//	
//	
//	//OTHER BLOCKS
//	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL)));
//	public static final RegistryObject<Block> DRY_ICE = BLOCKS.register("dry_ice", () -> new IceBlock(Block.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
//	
//
//
//
//	//FIXME
////	public static final RegistryObject<Block> MOON_BRICK_STAIRS = BLOCKS.register("moon_brick_stairs", () -> new CelestialStairsBlock(MOON_BRICK_BLOCK.get().getDefaultState(), Block.Properties.from(MOON_BRICK_BLOCK.get())));
////	public static final RegistryObject<Block> MOON_BRICK_SLAB = BLOCKS.register("moon_brick_slab", () -> new CelestialSlabBlock(Block.Properties.of(Material.STONE).strength(2.0F, 6.0F)));
////	public static final RegistryObject<Block> MARS_BRICK_STAIRS = BLOCKS.register("mars_brick_stairs", () -> new CelestialStairsBlock(MOON_BRICK_BLOCK.get().getDefaultState(), Block.Properties.from(MOON_BRICK_BLOCK.get())));
////	public static final RegistryObject<Block> MARS_BRICK_SLAB = BLOCKS.register("mars_brick_slab", () -> new CelestialSlabBlock(Block.Properties.of(Material.STONE).strength(2.0F, 6.0F)));
////	public static final RegistryObject<Block> METEOR_BRICK_STAIRS = BLOCKS.register("meteor_brick_stairs", () -> new CelestialStairsBlock(METEOR_BRICK_BLOCK.get().getDefaultState(), Block.Properties.from(METEOR_BRICK_BLOCK.get())));
////	public static final RegistryObject<Block> METEOR_BRICK_SLAB = BLOCKS.register("meteor_brick_slab", () -> new CelestialSlabBlock(Block.Properties.of(Material.STONE).strength(2.0F, 6.0F)));
////	public static final RegistryObject<Block> METEOR_BLOCK_STAIRS = BLOCKS.register("meteor_block_stairs", () -> new CelestialStairsBlock(METEOR_BRICK_BLOCK.get().getDefaultState(), Block.Properties.from(METEOR_BLOCK.get())));
////	public static final RegistryObject<Block> METEOR_BLOCK_SLAB = BLOCKS.register("meteor_block_slab", () -> new CelestialSlabBlock(Block.Properties.of(Material.STONE).strength(2.0F, 6.0F)));
//
//	
//	
//	//Block Items
//	//MOON
//	public static final RegistryObject<Item> MOON_ROCK_BLOCK_ITEM = ITEMS.register("moon_rock_block", () -> new BlockItemBase(MOON_ROCK_BLOCK.get()));
//	public static final RegistryObject<Item> MOON_SAND_BLOCK_ITEM = ITEMS.register("moon_sand_block", () -> new BlockItemBase(MOON_SAND_BLOCK.get()));
//	public static final RegistryObject<Item> GLOWING_MOON_SAND_BLOCK_ITEM = ITEMS.register("glowing_moon_sand_block", () -> new BlockItemBase(GLOWING_MOON_SAND_BLOCK.get()));
//	public static final RegistryObject<Item> MOON_BRICK_BLOCK_ITEM = ITEMS.register("moon_brick_block", () -> new BlockItemBase(MOON_BRICK_BLOCK.get()));
////	public static final RegistryObject<Item> MOON_COAL_BLOCK_ITEM = ITEMS.register("moon_coal_block", () -> new BlockItemBase(MOON_COAL_BLOCK.get()));
//	public static final RegistryObject<Item> MOON_IRON_BLOCK_ITEM = ITEMS.register("moon_iron_block", () -> new BlockItemBase(MOON_IRON_BLOCK.get()));
//	public static final RegistryObject<Item> MOON_REDSTONE_BLOCK_ITEM = ITEMS.register("moon_redstone_block", () -> new BlockItemBase(MOON_REDSTONE_BLOCK.get()));
////	public static final RegistryObject<Item> MOON_BRICK_STAIRS_ITEM = ITEMS.register("moon_brick_stairs", () -> new BlockItemBase(MOON_BRICK_STAIRS.get()));
////	public static final RegistryObject<Item> MOON_BRICK_SLAB_ITEM = ITEMS.register("moon_brick_slab", () -> new BlockItemBase(MOON_BRICK_SLAB.get()));
//
//	public static final RegistryObject<Item> LUNAR_LANTERN_ITEM = ITEMS.register("lunar_lantern", () -> new BlockItemBase(LUNAR_LANTERN.get()));
//	
//	public static final RegistryObject<Item> CHISELED_MOON_BRICK_BLOCK_ITEM = ITEMS.register("chiseled_moon_brick_block", () -> new BlockItemBase(CHISELED_MOON_BRICK_BLOCK.get()));
//	public static final RegistryObject<Item> CHISELED_MARS_BRICK_BLOCK_ITEM = ITEMS.register("chiseled_mars_brick_block", () -> new BlockItemBase(CHISELED_MARS_BRICK_BLOCK.get()));
//	public static final RegistryObject<Item> CHISELED_METEOR_BRICK_BLOCK_ITEM = ITEMS.register("chiseled_meteor_brick_block", () -> new BlockItemBase(CHISELED_METEOR_BRICK_BLOCK.get()));
//	public static final RegistryObject<Item> CHISELED_VENUS_BRICK_BLOCK_ITEM = ITEMS.register("chiseled_venus_brick_block", () -> new BlockItemBase(CHISELED_VENUS_BRICK_BLOCK.get()));
//
//	
//	public static final RegistryObject<Item> METEOR_BLOCK_ITEM = ITEMS.register("meteor_block", () -> new BlockItemBase(METEOR_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_EMERALD_ORE_BLOCK_ITEM = ITEMS.register("meteor_emerald_ore_block", () -> new BlockItemBase(METEOR_EMERALD_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_COAL_ORE_BLOCK_ITEM = ITEMS.register("meteor_coal_ore_block", () -> new BlockItemBase(METEOR_COAL_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_GOLD_ORE_BLOCK_ITEM = ITEMS.register("meteor_gold_ore_block", () -> new BlockItemBase(METEOR_GOLD_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_IRON_ORE_BLOCK_ITEM = ITEMS.register("meteor_iron_ore_block", () -> new BlockItemBase(METEOR_IRON_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_REDSTONE_ORE_BLOCK_ITEM = ITEMS.register("meteor_redstone_ore_block", () -> new BlockItemBase(METEOR_REDSTONE_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_DIAMOND_ORE_BLOCK_ITEM = ITEMS.register("meteor_diamond_ore_block", () -> new BlockItemBase(METEOR_DIAMOND_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_LAPIS_ORE_BLOCK_ITEM = ITEMS.register("meteor_lapis_ore_block", () -> new BlockItemBase(METEOR_LAPIS_ORE_BLOCK.get()));
//	public static final RegistryObject<Item> METEOR_BRICK_BLOCK_ITEM = ITEMS.register("meteor_brick_block", () -> new BlockItemBase(METEOR_BRICK_BLOCK.get()));
////	public static final RegistryObject<Item> METEOR_BRICK_STAIRS_ITEM = ITEMS.register("meteor_brick_stairs", () -> new BlockItemBase(METEOR_BRICK_STAIRS.get()));
////	public static final RegistryObject<Item> METEOR_BRICK_SLAB_ITEM = ITEMS.register("meteor_brick_slab", () -> new BlockItemBase(METEOR_BRICK_SLAB.get()));
////	public static final RegistryObject<Item> METEOR_BLOCK_STAIRS_ITEM = ITEMS.register("meteor_block_stairs", () -> new BlockItemBase(METEOR_BLOCK_STAIRS.get()));
////	public static final RegistryObject<Item> METEOR_BLOCK_SLAB_ITEM = ITEMS.register("meteor_block_slab", () -> new BlockItemBase(METEOR_BLOCK_SLAB.get()));
//
////	  public static final RegistryObject<Item> SULFUR_BUCKET = ITEMS.register("sulfur_bucket", () -> new BucketItem(CelestialFluids.SULFUR, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));
//	  
//	
//	public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",  () -> new BlockItemBase(STEEL_BLOCK.get()));
//	
//	
//	public static final RegistryObject<Item> MARS_ROCK_BLOCK_ITEM = ITEMS.register("mars_rock_block", () -> new BlockItemBase(MARS_ROCK_BLOCK.get()));	
//	public static final RegistryObject<Item> MARS_SAND_BLOCK_ITEM = ITEMS.register("mars_sand_block", () -> new BlockItemBase(MARS_SAND_BLOCK.get()));
//	public static final RegistryObject<Item> MARS_BRICK_BLOCK_ITEM = ITEMS.register("mars_brick_block", () -> new BlockItemBase(MARS_BRICK_BLOCK.get()));
////	public static final RegistryObject<Item> MARS_COAL_BLOCK_ITEM = ITEMS.register("mars_coal_block", () -> new BlockItemBase(MARS_COAL_BLOCK.get()));
//	public static final RegistryObject<Item> MARS_IRON_BLOCK_ITEM = ITEMS.register("mars_iron_block", () -> new BlockItemBase(MARS_IRON_BLOCK.get()));
//	public static final RegistryObject<Item> MARS_REDSTONE_BLOCK_ITEM = ITEMS.register("mars_redstone_block", () -> new BlockItemBase(MARS_REDSTONE_BLOCK.get()));
//
//	public static final RegistryObject<Item> VENUS_ROCK_BLOCK_ITEM = ITEMS.register("venus_rock_block", () -> new BlockItemBase(VENUS_ROCK_BLOCK.get()));	
//	public static final RegistryObject<Item> VENUS_SAND_BLOCK_ITEM = ITEMS.register("venus_sand_block", () -> new BlockItemBase(VENUS_SAND_BLOCK.get()));
//	public static final RegistryObject<Item> VENUS_BRICK_BLOCK_ITEM = ITEMS.register("venus_brick_block", () -> new BlockItemBase(VENUS_BRICK_BLOCK.get()));
////	public static final RegistryObject<Item> VENUS_COAL_BLOCK_ITEM = ITEMS.register("venus_coal_block", () -> new BlockItemBase(VENUS_COAL_BLOCK.get()));
//	public static final RegistryObject<Item> VENUS_IRON_BLOCK_ITEM = ITEMS.register("venus_iron_block", () -> new BlockItemBase(VENUS_IRON_BLOCK.get()));
//	public static final RegistryObject<Item> VENUS_REDSTONE_BLOCK_ITEM = ITEMS.register("venus_redstone_block", () -> new BlockItemBase(VENUS_REDSTONE_BLOCK.get()));
//
//	
//	public static final RegistryObject<Item> DRY_ICE_ITEM = ITEMS.register("dry_ice", () -> new BlockItemBase(DRY_ICE.get()));
//	
//	
//	
//	//Tools
//	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(ModItemTier.STEEL, /*attackDamage*/ 5, /*attackSpeed*/ -2.4F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(ModItemTier.STEEL, 8, -3.1F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModItemTier.STEEL, 3, -2.8F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(ModItemTier.STEEL, 3, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(ModItemTier.STEEL, 0, 0, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//
//	//Armor
//	public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	
//	public static final RegistryObject<ArmorItem> SPACE_SUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> SPACE_SUIT_BOOTS = ITEMS.register("space_suit_boots", () -> new SpaceSuitArmor(ArmorMaterial.LEATHER, EquipmentSlotType.FEET, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> SPACE_SUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<ArmorItem> SPACE_SUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
//
//	
//	
////	 public static final Item IRON_HELMET = register("iron_helmet", new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)));
//	  
//	
//	
//	 public final BlockState getDefaultState() {
//	      return this.defaultState;
//	   }	 
//
//}
