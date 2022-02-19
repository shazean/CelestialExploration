package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CelestialExploration.MODID);
	
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
	}
	
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_TAB);
   
	
	

	
	//Items
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	public static final RegistryObject<Item> LIQUID_OXYGEN = ITEMS.register("liquid_oxygen",  () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	 public static final RegistryObject<Item> SULFUR_BUCKET = ITEMS.register("sulfur_bucket", () -> new BucketItem(RegistryFluids.SULFUR, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));

//	public static final RegistryObject<Item> OXYGEN_CANISTER = ITEMS.register("oxygen_canister", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	public static final RegistryObject<Item> COLD_OXYGEN_CANISTER = ITEMS.register("cold_oxygen_canister", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	 
	
	//Block Items
	//MOON
	public static final RegistryObject<Item> MOON_STONE = fromBlock(BlockRegistry.MOON_STONE);
	public static final RegistryObject<Item> MOON_SAND = fromBlock(BlockRegistry.MOON_SAND);
	public static final RegistryObject<Item> GLOWING_MOON_SAND = fromBlock(BlockRegistry.GLOWING_MOON_SAND);
	public static final RegistryObject<Item> MOON_BRICKS = fromBlock(BlockRegistry.MOON_BRICKS);
	public static final RegistryObject<Item> MOON_IRON_ORE = fromBlock(BlockRegistry.MOON_IRON_ORE);
	public static final RegistryObject<Item> MOON_REDSTONE = fromBlock(BlockRegistry.MOON_REDSTONE_ORE);

	public static final RegistryObject<Item> LUNAR_LANTERN = fromBlock(BlockRegistry.LUNAR_LANTERN);
	
	public static final RegistryObject<Item> CHISELED_MOON_BRICKS = fromBlock(BlockRegistry.CHISELED_MOON_BRICKS);
	public static final RegistryObject<Item> MOON_BRICK_STAIRS = fromBlock(BlockRegistry.MOON_BRICK_STAIRS);
	public static final RegistryObject<Item> MOON_BRICK_SLAB = fromBlock(BlockRegistry.MOON_BRICK_SLAB);
	public static final RegistryObject<Item> MOON_BRICK_WALL = fromBlock(BlockRegistry.MOON_BRICK_WALL);

	

	
	  
	
	
	//MARS
	public static final RegistryObject<Item> MARS_STONE = fromBlock(BlockRegistry.MARS_STONE);	
	public static final RegistryObject<Item> MARS_SAND = fromBlock(BlockRegistry.MARS_SAND);
	public static final RegistryObject<Item> MARS_BRICKS = fromBlock(BlockRegistry.MARS_BRICKS);
	public static final RegistryObject<Item> MARS_IRON_ORE = fromBlock(BlockRegistry.MARS_IRON_ORE);
	public static final RegistryObject<Item> MARS_REDSTONE_ORE = fromBlock(BlockRegistry.MARS_REDSTONE_ORE);
	public static final RegistryObject<Item> CHISELED_MARS_BRICKS = fromBlock(BlockRegistry.CHISELED_MARS_BRICKS);
	public static final RegistryObject<Item> MARS_BRICK_STAIRS = fromBlock(BlockRegistry.MARS_BRICK_STAIRS);
	public static final RegistryObject<Item> MARS_BRICK_SLAB = fromBlock(BlockRegistry.MARS_BRICK_SLAB);
	public static final RegistryObject<Item> MARS_BRICK_WALL = fromBlock(BlockRegistry.MARS_BRICK_WALL);
//	public static final RegistryObject<Item> MARS_SOIL = ITEMS.register("mars_soil", () -> new BlockItemBase(RegistryBlocks.MARS_SOIL.get()));
	
	//METEOR
	public static final RegistryObject<Item> METEOR = fromBlock(BlockRegistry.METEOR);	
	public static final RegistryObject<Item> METEOR_EMERALD_ORE = fromBlock(BlockRegistry.METEOR_EMERALD_ORE);	
	public static final RegistryObject<Item> METEOR_COAL_ORE = fromBlock(BlockRegistry.METEOR_COAL_ORE);	
	public static final RegistryObject<Item> METEOR_GOLD_ORE = fromBlock(BlockRegistry.METEOR_GOLD_ORE);	
	public static final RegistryObject<Item> METEOR_IRON_ORE = fromBlock(BlockRegistry.METEOR_IRON_ORE);	
	public static final RegistryObject<Item> METEOR_REDSTONE_ORE = fromBlock(BlockRegistry.METEOR_REDSTONE_ORE);	
	public static final RegistryObject<Item> METEOR_DIAMOND_ORE = fromBlock(BlockRegistry.METEOR_DIAMOND_ORE);	
	public static final RegistryObject<Item> METEOR_COPPER_ORE = fromBlock(BlockRegistry.METEOR_COPPER_ORE);	
	public static final RegistryObject<Item> METEOR_LAPIS_ORE = fromBlock(BlockRegistry.METEOR_LAPIS_ORE);	
	public static final RegistryObject<Item> METEOR_BRICKS = fromBlock(BlockRegistry.METEOR_BRICKS);	
	public static final RegistryObject<Item> CHISELED_METEOR_BRICKS = fromBlock(BlockRegistry.CHISELED_METEOR_BRICKS);	
	public static final RegistryObject<Item> METEOR_BRICK_STAIRS = fromBlock(BlockRegistry.METEOR_BRICK_STAIRS);	
	public static final RegistryObject<Item> METEOR_BRICK_SLAB = fromBlock(BlockRegistry.METEOR_BRICK_SLAB);	
	public static final RegistryObject<Item> METEOR_BRICK_WALL = fromBlock(BlockRegistry.METEOR_BRICK_WALL);

	
	
	//VENUS
//	public static final RegistryObject<Item> VENUS_STONE = ITEMS.register("venus_stone", () -> new BlockItemBase(RegistryBlocks.VENUS_STONE.get()));	
//	public static final RegistryObject<Item> VENUS_SAND = ITEMS.register("venus_sand", () -> new BlockItemBase(RegistryBlocks.VENUS_SAND.get()));
//	public static final RegistryObject<Item> VENUS_BRICK = ITEMS.register("venus_brick", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK.get()));
//	public static final RegistryObject<Item> VENUS_IRON_ORE = ITEMS.register("venus_iron_ore", () -> new BlockItemBase(RegistryBlocks.VENUS_IRON_ORE.get()));
//	public static final RegistryObject<Item> VENUS_REDSTONE_ORE = ITEMS.register("venus_redstone_ore", () -> new BlockItemBase(RegistryBlocks.VENUS_REDSTONE_ORE.get()));
//	public static final RegistryObject<Item> CHISELED_VENUS_BRICK = ITEMS.register("chiseled_venus_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_VENUS_BRICK.get()));
//	public static final RegistryObject<Item> VENUS_BRICK_STAIRS = ITEMS.register("venus_brick_stairs", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK_STAIRS.get()));
//	public static final RegistryObject<Item> VENUS_BRICK_SLAB = ITEMS.register("venus_brick_slab", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK_SLAB.get()));

	
	//MERCURY
//	public static final RegistryObject<Item> MERCURY_STONE = ITEMS.register("mercury_stone", () -> new BlockItemBase(RegistryBlocks.MERCURY_STONE.get()));	
//	public static final RegistryObject<Item> MERCURY_SAND = ITEMS.register("mercury_sand", () -> new BlockItemBase(RegistryBlocks.MERCURY_SAND.get()));
//	public static final RegistryObject<Item> MERCURY_BRICK = ITEMS.register("mercury_brick", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK.get()));
//	public static final RegistryObject<Item> MERCURY_IRON = ITEMS.register("mercury_iron_ore", () -> new BlockItemBase(RegistryBlocks.MERCURY_IRON_ORE.get()));
//	public static final RegistryObject<Item> MERCURY_REDSTONE = ITEMS.register("mercury_redstone_ore", () -> new BlockItemBase(RegistryBlocks.MERCURY_REDSTONE_ORE.get()));
//	public static final RegistryObject<Item> CHISELED_MERCURY_BRICK = ITEMS.register("chiseled_mercury_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_MERCURY_BRICK.get()));
//	public static final RegistryObject<Item> MERCURY_BRICK_STAIRS = ITEMS.register("mercury_brick_stairs", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK_STAIRS.get()));
//	public static final RegistryObject<Item> MERCURY_BRICK_SLAB = ITEMS.register("mercury_brick_slab", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK_SLAB.get()));

	//POWER-RELATED
	public static final RegistryObject<Item> SOLAR_PANEL = fromBlock(BlockRegistry.SOLAR_PANEL);
	
	
	//OTHER BLOCK ITEMS
	public static final RegistryObject<Item> SOLAR_LANTERN = fromBlock(BlockRegistry.SOLAR_LANTERN);
	public static final RegistryObject<Item> ECLIPSE_LANTERN = fromBlock(BlockRegistry.ECLIPSE_LANTERN);
//	public static final RegistryObject<Item> STEEL_BLOCK = fromBlock(BlockRegistry.STEEL_BLOCK);
//	public static final RegistryObject<Item> STEEL_BLOCK_STAIRS = fromBlock(BlockRegistry.STEEL_BLOCK_STAIRS);
//	public static final RegistryObject<Item> STEEL_BLOCK_SLAB = fromBlock(BlockRegistry.STEEL_BLOCK_SLAB);

	
//	public static final RegistryObject<Item> DRY_ICE = ITEMS.register("dry_ice", () -> new BlockItemBase(RegistryBlocks.DRY_ICE.get()));
//	public static final RegistryObject<Item> ASSEMBLY_STATION = ITEMS.register("assembly_station",  () -> new BlockItemBase(RegistryBlocks.ASSEMBLY_STATION.get()));
//	public static final RegistryObject<Item> SOLAR_PANEL = ITEMS.register("solar_panel",  () -> new BlockItemBase(RegistryBlocks.SOLAR_PANEL.get()));


//	public static final RegistryObject<ModSpawnEgg> ROVER_SPAWN_EGG = ITEMS.register("rover_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.ROVER, 0x000000, 0xffffff, new Item.Properties().tab(Main.CELESTIAL_TAB)));
//	public static final RegistryObject<ModSpawnEgg> LURKER_SPAWN_EGG = ITEMS.register("lurker_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.LURKER, 0, 894731, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//
//	public static final RegistryObject<ModSpawnEgg> RUST_SLIME_SPAWN_EGG = ITEMS.register("rust_slime_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.RUST_SLIME, 0x984521, 0x7d3213, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//	public static final RegistryObject<ModSpawnEgg> WHITE_SLIME_SPAWN_EGG = ITEMS.register("white_slime_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.WHITE_SLIME, 0xdbdbdb, 0xffffff, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//	public static final RegistryObject<ModSpawnEgg> SULFURIC_SLIME_SPAWN_EGG = ITEMS.register("sulfuric_slime_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.SULFURIC_SLIME, 0xbd9200, 0xa68000, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//	public static final RegistryObject<ModSpawnEgg> MARS_MALLOW_SPAWN_EGG = ITEMS.register("mars_mallow_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.MARS_MALLOW, 0xffffff, 0xF3F3F3, new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
//	public static final RegistryObject<Item> GEYSER = ITEMS.register("geyser", () -> new BlockItemBase(RegistryBlocks.GEYSER.get()));

	
	
//	public static final RegistryObject<Item> CERAMIC = fromBlock(BlockRegistry.CERAMIC);
//	public static final RegistryObject<Item> CERAMIC_TILE = fromBlock(BlockRegistry.CERAMIC_TILE);
//	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	
	//ROCKET
//	public static final RegistryObject<Item> STEEL_FRAME = ITEMS.register("steel_frame",  () -> new BlockItemBase(RegistryBlocks.STEEL_FRAME.get()));
//	public static final RegistryObject<Item> LAUNCH_PAD = ITEMS.register("launch_pad",  () -> new BlockItemBase(RegistryBlocks.LAUNCH_PAD.get()));
//	public static final RegistryObject<Item> ROCKET_CABIN = ITEMS.register("rocket_cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> ROCKET_FRAME = ITEMS.register("rocket_frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> ROCKET_ENGINE = ITEMS.register("rocket_engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> NOSE_CONE = ITEMS.register("nose_cone", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> FUEL_TANK = ITEMS.register("fuel_tank",  () -> new BlockItemBase(RegistryBlocks.FUEL_TANK.get()));	
//
//	public static final RegistryObject<Item> THICK_CARBON_AIR = ITEMS.register("thick_carbon_air",  () -> new BlockItemBase(RegistryBlocks.THICK_CARBON_AIR.get()));	
//	
//	public static final RegistryObject<Item> GASEOUS_CARBON = ITEMS.register("gaseous_carbon", () -> new Item((new Item.Properties()).tab(Main.CELESTIAL_TAB)));

	
	
//	public static final RegistryObject<Item> WHITE_SHUTTLE = ITEMS.register("white_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.WHITE, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> RED_SHUTTLE = ITEMS.register("red_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.RED, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> ORANGE_SHUTTLE = ITEMS.register("orange_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.ORANGE, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> YELLOW_SHUTTLE = ITEMS.register("yellow_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.YELLOW, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> GREEN_SHUTTLE = ITEMS.register("green_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.GREEN, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> BLUE_SHUTTLE = ITEMS.register("blue_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.BLUE, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> PURPLE_SHUTTLE = ITEMS.register("purple_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.PURPLE, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));
//	public static final RegistryObject<Item> BLACK_SHUTTLE = ITEMS.register("black_shuttle", () -> new ShuttleItem(ShuttleEntity.Color.BLACK, new Item.Properties().stacksTo(1).tab(Main.SHUTTLE_TAB)));

	
	
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

	
	//CUSTOM ITEM TAGS
	public static final Tags.IOptionalNamedTag<Item> MARS_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "mars_tag"));
	public static final Tags.IOptionalNamedTag<Item> MARS_STONE_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "mars_stone_tag"));
	public static final Tags.IOptionalNamedTag<Item> MOON_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "moon_tag"));
	public static final Tags.IOptionalNamedTag<Item> MOON_STONE_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "moon_stone_tag"));
	public static final Tags.IOptionalNamedTag<Item> METEOR_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "meteor_tag"));
	public static final Tags.IOptionalNamedTag<Item> METEOR_STONE_TAG = ItemTags.createOptional(new ResourceLocation(CelestialExploration.MODID, "meteor_stone_tag"));

	
}

	
