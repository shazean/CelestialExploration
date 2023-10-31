package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import com.shim.celestialexploration.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemRegistry {

	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CelestialExploration.MODID);


	public static void register(IEventBus event) {
		ITEMS.register(event);
	}
	
	public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), BLOCK_ITEM_PROPERTIES));
	}

	public static <B extends Block> RegistryObject<Item> fromShuttleBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), SHUTTLE_ITEM_PROPERTIES));
	}

	public static <B extends Block> RegistryObject<Item> fromMiscBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
	}

	public static final Item.Properties BLOCK_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_BLOCKS_TAB);
	public static final Item.Properties SHUTTLE_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.SHUTTLE_TAB);
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB);

	/**
	 * Block Items
	 * MOON
	 * ~FULL BLOCKS
	 */
	public static final RegistryObject<Item> MOON_SAND = fromBlock(BlockRegistry.MOON_SAND);
	public static final RegistryObject<Item> GLOWING_MOON_SAND = fromBlock(BlockRegistry.GLOWING_MOON_SAND);
	public static final RegistryObject<Item> MOON_STONE = fromBlock(BlockRegistry.MOON_STONE);
	public static final RegistryObject<Item> MOON_SMOOTH_STONE = fromBlock(BlockRegistry.MOON_SMOOTH_STONE);
	public static final RegistryObject<Item> MOON_BRICKS = fromBlock(BlockRegistry.MOON_BRICKS);
	public static final RegistryObject<Item> MOON_BRICK_PILLAR = fromBlock(BlockRegistry.MOON_BRICK_PILLAR);
	public static final RegistryObject<Item> CHISELED_MOON_BRICKS = fromBlock(BlockRegistry.CHISELED_MOON_BRICKS);
	public static final RegistryObject<Item> CRACKED_MOON_BRICKS = fromBlock(BlockRegistry.CRACKED_MOON_BRICKS);
	public static final RegistryObject<Item> MOON_IRON_ORE = fromBlock(BlockRegistry.MOON_IRON_ORE);
	public static final RegistryObject<Item> MOON_REDSTONE_ORE = fromBlock(BlockRegistry.MOON_REDSTONE_ORE);
	public static final RegistryObject<Item> MOON_COBBLESTONE = fromBlock(BlockRegistry.MOON_COBBLESTONE);
	public static final RegistryObject<Item> MOON_DEEPSLATE = fromBlock(BlockRegistry.MOON_DEEPSLATE);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.MOON_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CRACKED_MOON_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CHISELED_MOON_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> MOON_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> MOON_DEEPSLATE_TILES = fromBlock(BlockRegistry.MOON_DEEPSLATE_TILES);
	public static final RegistryObject<Item> CRACKED_MOON_DEEPSLATE_TILES = fromBlock(BlockRegistry.CRACKED_MOON_DEEPSLATE_TILES);
	public static final RegistryObject<Item> MOON_POLISHED_DEEPSLATE = fromBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE);
	public static final RegistryObject<Item> MOON_DEEPSLATE_IRON_ORE = fromBlock(BlockRegistry.MOON_DEEPSLATE_IRON_ORE);
	public static final RegistryObject<Item> MOON_DEEPSLATE_REDSTONE_ORE = fromBlock(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE);
	public static final RegistryObject<Item> LUNAR_LANTERN = fromBlock(BlockRegistry.LUNAR_LANTERN);

	//~STAIRS
	public static final RegistryObject<Item> MOON_BRICK_STAIRS = fromBlock(BlockRegistry.MOON_BRICK_STAIRS);
	public static final RegistryObject<Item> MOON_COBBLESTONE_STAIRS = fromBlock(BlockRegistry.MOON_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> MOON_COBBLED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BRICK_STAIRS = fromBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS);
	public static final RegistryObject<Item> MOON_DEEPSLATE_TILE_STAIRS = fromBlock(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS);
	public static final RegistryObject<Item> MOON_POLISHED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS);
	//~SLABS
	public static final RegistryObject<Item> MOON_STONE_SLAB = fromBlock(BlockRegistry.MOON_STONE_SLAB);
	//	public static final RegistryObject<Item> MOON_SMOOTH_STONE_SLAB = fromBlock(BlockRegistry.MOON_SMOOTH_STONE_SLAB);
	public static final RegistryObject<Item> MOON_COBBLESTONE_SLAB = fromBlock(BlockRegistry.MOON_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> MOON_BRICK_SLAB = fromBlock(BlockRegistry.MOON_BRICK_SLAB);
	public static final RegistryObject<Item> MOON_COBBLED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BRICK_SLAB = fromBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB);
	public static final RegistryObject<Item> MOON_DEEPSLATE_TILE_SLAB = fromBlock(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB);
	public static final RegistryObject<Item> MOON_POLISHED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB);
	//~WALLS
	public static final RegistryObject<Item> MOON_BRICK_WALL = fromBlock(BlockRegistry.MOON_BRICK_WALL);
	public static final RegistryObject<Item> MOON_COBBLESTONE_WALL = fromBlock(BlockRegistry.MOON_COBBLESTONE_WALL);
	public static final RegistryObject<Item> MOON_COBBLED_DEEPSLATE_WALL = fromBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_WALL);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BRICK_WALL = fromBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_WALL);
	public static final RegistryObject<Item> MOON_DEEPSLATE_TILE_WALL = fromBlock(BlockRegistry.MOON_DEEPSLATE_TILE_WALL);
	public static final RegistryObject<Item> MOON_POLISHED_DEEPSLATE_WALL = fromBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_WALL);
	//~BUTTONS
	public static final RegistryObject<Item> MOON_STONE_BUTTON = fromMiscBlock(BlockRegistry.MOON_STONE_BUTTON);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BUTTON = fromMiscBlock(BlockRegistry.MOON_DEEPSLATE_BUTTON);
	//~PRESSURE PLATES
	public static final RegistryObject<Item> MOON_STONE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.MOON_STONE_PRESSURE_PLATE);
	public static final RegistryObject<Item> MOON_DEEPSLATE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.MOON_DEEPSLATE_PRESSURE_PLATE);


//	public static final RegistryObject<Item> TEST_BLOCK = fromBlock(BlockRegistry.TEST_BLOCK);

	  
	
	
	//MARS
	//FULL BLOCKS
	public static final RegistryObject<Item> MARS_SAND = fromBlock(BlockRegistry.MARS_SAND);
	//	public static final RegistryObject<Item> MARS_SOIL = ITEMS.register("mars_soil", () -> new BlockItemBase(RegistryBlocks.MARS_SOIL.get()));
	public static final RegistryObject<Item> MARS_STONE = fromBlock(BlockRegistry.MARS_STONE);
	public static final RegistryObject<Item> MARS_SMOOTH_STONE = fromBlock(BlockRegistry.MARS_SMOOTH_STONE);

	public static final RegistryObject<Item> MARS_BRICKS = fromBlock(BlockRegistry.MARS_BRICKS);
	public static final RegistryObject<Item> MARS_BRICK_PILLAR = fromBlock(BlockRegistry.MARS_BRICK_PILLAR);
	public static final RegistryObject<Item> CHISELED_MARS_BRICKS = fromBlock(BlockRegistry.CHISELED_MARS_BRICKS);
	public static final RegistryObject<Item> CRACKED_MARS_BRICKS = fromBlock(BlockRegistry.CRACKED_MARS_BRICKS);
	public static final RegistryObject<Item> MARS_IRON_ORE = fromBlock(BlockRegistry.MARS_IRON_ORE);
	public static final RegistryObject<Item> MARS_REDSTONE_ORE = fromBlock(BlockRegistry.MARS_REDSTONE_ORE);
	public static final RegistryObject<Item> MARS_COBBLESTONE = fromBlock(BlockRegistry.MARS_COBBLESTONE);
	public static final RegistryObject<Item> MARS_DEEPSLATE = fromBlock(BlockRegistry.MARS_DEEPSLATE);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.MARS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CRACKED_MARS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CHISELED_MARS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CHISELED_MARS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> MARS_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> MARS_DEEPSLATE_TILES = fromBlock(BlockRegistry.MARS_DEEPSLATE_TILES);
	public static final RegistryObject<Item> CRACKED_MARS_DEEPSLATE_TILES = fromBlock(BlockRegistry.CRACKED_MARS_DEEPSLATE_TILES);
	public static final RegistryObject<Item> MARS_POLISHED_DEEPSLATE = fromBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE);
	public static final RegistryObject<Item> MARS_DEEPSLATE_IRON_ORE = fromBlock(BlockRegistry.MARS_DEEPSLATE_IRON_ORE);
	public static final RegistryObject<Item> MARS_DEEPSLATE_REDSTONE_ORE = fromBlock(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE);


	//STAIRS
	public static final RegistryObject<Item> MARS_BRICK_STAIRS = fromBlock(BlockRegistry.MARS_BRICK_STAIRS);
	public static final RegistryObject<Item> MARS_COBBLESTONE_STAIRS = fromBlock(BlockRegistry.MARS_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BRICK_STAIRS = fromBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS);
	public static final RegistryObject<Item> MARS_COBBLED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS);
	public static final RegistryObject<Item> MARS_DEEPSLATE_TILE_STAIRS = fromBlock(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS);
	public static final RegistryObject<Item> MARS_POLISHED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS);

	//SLABS
	public static final RegistryObject<Item> MARS_STONE_SLAB = fromBlock(BlockRegistry.MARS_STONE_SLAB);
	//	public static final RegistryObject<Item> MARS_SMOOTH_STONE_SLAB = fromBlock(BlockRegistry.MARS_SMOOTH_STONE_SLAB);
	public static final RegistryObject<Item> MARS_BRICK_SLAB = fromBlock(BlockRegistry.MARS_BRICK_SLAB);
	public static final RegistryObject<Item> MARS_COBBLESTONE_SLAB = fromBlock(BlockRegistry.MARS_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> MARS_COBBLED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BRICK_SLAB = fromBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB);
	public static final RegistryObject<Item> MARS_DEEPSLATE_TILE_SLAB = fromBlock(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB);
	public static final RegistryObject<Item> MARS_POLISHED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB);

	//WALLS
	public static final RegistryObject<Item> MARS_BRICK_WALL = fromBlock(BlockRegistry.MARS_BRICK_WALL);
	public static final RegistryObject<Item> MARS_COBBLESTONE_WALL = fromBlock(BlockRegistry.MARS_COBBLESTONE_WALL);
	public static final RegistryObject<Item> MARS_COBBLED_DEEPSLATE_WALL = fromBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_WALL);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BRICK_WALL = fromBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_WALL);
	public static final RegistryObject<Item> MARS_DEEPSLATE_TILE_WALL = fromBlock(BlockRegistry.MARS_DEEPSLATE_TILE_WALL);
	public static final RegistryObject<Item> MARS_POLISHED_DEEPSLATE_WALL = fromBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_WALL);

	//BUTTONS
	public static final RegistryObject<Item> MARS_STONE_BUTTON = fromMiscBlock(BlockRegistry.MARS_STONE_BUTTON);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BUTTON = fromMiscBlock(BlockRegistry.MARS_DEEPSLATE_BUTTON);

	//PRESSURE PlATES
	public static final RegistryObject<Item> MARS_STONE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.MARS_STONE_PRESSURE_PLATE);
	public static final RegistryObject<Item> MARS_DEEPSLATE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.MARS_DEEPSLATE_PRESSURE_PLATE);


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

	public static final RegistryObject<Item> METEOR_BUTTON = fromMiscBlock(BlockRegistry.METEOR_BUTTON);
	public static final RegistryObject<Item> METEOR_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.METEOR_PRESSURE_PLATE);


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
//	public static final RegistryObject<Item> SOLAR_PANEL = fromBlock(BlockRegistry.SOLAR_PANEL);
	
	
	//OTHER BLOCK ITEMS
//	public static final RegistryObject<Item> SOLAR_LANTERN = fromBlock(BlockRegistry.SOLAR_LANTERN);
	//	public static final RegistryObject<Item> ECLIPSE_LANTERN = fromBlock(BlockRegistry.ECLIPSE_LANTERN);
	//	public static final RegistryObject<Item> IGNEOUS_ROCK = fromBlock(BlockRegistry.IGNEOUS_ROCK);
	public static final RegistryObject<Item> STEEL_BLOCK = fromBlock(BlockRegistry.STEEL_BLOCK);


	public static final RegistryObject<Item> DRY_ICE = fromBlock(BlockRegistry.DRY_ICE);
	public static final RegistryObject<Item> OXYGEN_COMPRESSOR = fromShuttleBlock(BlockRegistry.OXYGEN_COMPRESSOR);

	public static final RegistryObject<Item> LOX_TANK = ITEMS.register("lox_tank", () -> new LoxTankItem(BlockRegistry.LOX_TANK.get(), new Item.Properties().tab(CelestialExploration.SHUTTLE_TAB).stacksTo(1)));
	public static final RegistryObject<Item> LOX_BUCKET = ITEMS.register("lox_bucket", () -> new BucketItem(FluidRegistry.LOX_STILL, new Item.Properties().stacksTo(1))); //TODO add creative tab

	public static final RegistryObject<Item> RUSTED_IRON_NUGGET = ITEMS.register("rusted_iron_nugget", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_GOO = ITEMS.register("lunar_goo", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> LUMINOUS_BLUE_GLASS = fromBlock(BlockRegistry.LUMINOUS_BLUE_GLASS);
	public static final RegistryObject<Item> LUMINOUS_WHITE_GLASS = fromBlock(BlockRegistry.LUMINOUS_WHITE_GLASS);
	public static final RegistryObject<Item> LUMINOUS_BLUE_GLASS_PANE = fromBlock(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE);
	public static final RegistryObject<Item> LUMINOUS_WHITE_GLASS_PANE = fromBlock(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE);

	public static final RegistryObject<Item> CONNECTED_GLASS = fromBlock(BlockRegistry.CONNECTED_GLASS);
	public static final RegistryObject<Item> CONNECTED_GLASS_PANE = fromBlock(BlockRegistry.CONNECTED_GLASS_PANE);


//	public static final RegistryObject<Item> SOLAR_PANEL = ITEMS.register("solar_panel",  () -> new BlockItemBase(RegistryBlocks.SOLAR_PANEL.get()));

	//SPAWN EGGS
//	public static final RegistryObject<ModSpawnEgg> ROVER_SPAWN_EGG = ITEMS.register("rover_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.ROVER, 0x000000, 0xffffff, new Item.Properties().tab(Main.CELESTIAL_TAB)));
//	public static final RegistryObject<ModSpawnEgg> LURKER_SPAWN_EGG = ITEMS.register("lurker_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.LURKER, 0, 894731, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//
	public static final RegistryObject<Item> RUST_SPAWN_EGG = ITEMS.register("rust_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.RUST_SLIME,0x7f3414, 0x984521,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> LUNAR_SPAWN_EGG = ITEMS.register("lunar_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.LUNAR_SLIME,0xd5d5d5, 0xfafafa,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> MARS_MALLOW_SPAWN_EGG = ITEMS.register("mars_mallow_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.MARS_MALLOW,0xcda568, 0xfaf5ee,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> LURKER_SPAWN_EGG = ITEMS.register("lurker_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.LURKER,0, 0x894731,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> LURKER_HEAD = ITEMS.register("lurker_head", () -> new StandingAndWallBlockItem(BlockRegistry.LURKER_HEAD.get(), BlockRegistry.LURKER_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));


//	public static final RegistryObject<ModSpawnEgg> SULFURIC_SLIME_SPAWN_EGG = ITEMS.register("sulfuric_slime_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.SULFURIC_SLIME, 0xbd9200, 0xa68000, new Item.Properties().tab(ItemGroup.TAB_MISC)));
//	public static final RegistryObject<ModSpawnEgg> MARS_MALLOW_SPAWN_EGG = ITEMS.register("mars_mallow_spawn_egg", () -> new ModSpawnEgg(RegistryEntities.MARS_MALLOW, 0xffffff, 0xF3F3F3, new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
//	public static final RegistryObject<Item> GEYSER = ITEMS.register("geyser", () -> new BlockItemBase(RegistryBlocks.GEYSER.get()));



	public static final RegistryObject<Item> CERAMIC = fromBlock(BlockRegistry.CERAMIC);
	public static final RegistryObject<Item> CERAMIC_TILE = fromBlock(BlockRegistry.CERAMIC_TILE);
//	public static final RegistryObject<Item> WHITE_CERAMIC = fromBlock(BlockRegistry.WHITE_CERAMIC);
//	public static final RegistryObject<Item> LIGHT_GREY_CERAMIC = fromBlock(BlockRegistry.LIGHT_GREY_CERAMIC);
//	public static final RegistryObject<Item> GREY_CERAMIC = fromBlock(BlockRegistry.GREY_CERAMIC);
//	public static final RegistryObject<Item> BLACK_CERAMIC = fromBlock(BlockRegistry.BLACK_CERAMIC);
//	public static final RegistryObject<Item> PURPLE_CERAMIC = fromBlock(BlockRegistry.PURPLE_CERAMIC);
//	public static final RegistryObject<Item> MAGENTA_CERAMIC = fromBlock(BlockRegistry.MAGENTA_CERAMIC);
//	public static final RegistryObject<Item> BLUE_CERAMIC = fromBlock(BlockRegistry.BLUE_CERAMIC);
//	public static final RegistryObject<Item> LIGHT_BLUE_CERAMIC = fromBlock(BlockRegistry.LIGHT_BLUE_CERAMIC);
//	public static final RegistryObject<Item> CYAN_CERAMIC = fromBlock(BlockRegistry.CYAN_CERAMIC);
//	public static final RegistryObject<Item> GREEN_CERAMIC = fromBlock(BlockRegistry.GREEN_CERAMIC);
//	public static final RegistryObject<Item> LIME_CERAMIC = fromBlock(BlockRegistry.LIME_CERAMIC);
//	public static final RegistryObject<Item> YELLOW_CERAMIC = fromBlock(BlockRegistry.YELLOW_CERAMIC);
//	public static final RegistryObject<Item> ORANGE_CERAMIC = fromBlock(BlockRegistry.ORANGE_CERAMIC);
//	public static final RegistryObject<Item> BROWN_CERAMIC = fromBlock(BlockRegistry.BROWN_CERAMIC);
//	public static final RegistryObject<Item> RED_CERAMIC = fromBlock(BlockRegistry.RED_CERAMIC);
//	public static final RegistryObject<Item> PINK_CERAMIC = fromBlock(BlockRegistry.PINK_CERAMIC);


	//	public static final RegistryObject<Item> THICK_CARBON_AIR = ITEMS.register("thick_carbon_air",  () -> new BlockItemBase(RegistryBlocks.THICK_CARBON_AIR.get()));
//	public static final RegistryObject<Item> GASEOUS_CARBON = ITEMS.register("gaseous_carbon", () -> new Item((new Item.Properties()).tab(Main.CELESTIAL_TAB)));



	//SHUTTLE
	public static final RegistryObject<Item> STEEL_FRAME = fromShuttleBlock(BlockRegistry.STEEL_FRAME);
//	public static final RegistryObject<Item> LAUNCH_PAD = ITEMS.register("launch_pad",  () -> new BlockItemBase(RegistryBlocks.LAUNCH_PAD.get()));
	public static final RegistryObject<Item> SHUTTLE_CABIN = ITEMS.register("shuttle_cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> SHUTTLE_FRAME = ITEMS.register("shuttle_frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> SHUTTLE_ENGINE = ITEMS.register("shuttle_engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> NOSE_CONE = ITEMS.register("nose_cone", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	
	public static final RegistryObject<Item> BLACK_SHUTTLE = ITEMS.register("black_shuttle", () -> new ShuttleItem(Shuttle.Type.BLACK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> GREY_SHUTTLE = ITEMS.register("grey_shuttle", () -> new ShuttleItem(Shuttle.Type.GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_SHUTTLE = ITEMS.register("light_grey_shuttle", () -> new ShuttleItem(Shuttle.Type.LIGHT_GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> WHITE_SHUTTLE = ITEMS.register("white_shuttle", () -> new ShuttleItem(Shuttle.Type.WHITE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> PINK_SHUTTLE = ITEMS.register("pink_shuttle", () -> new ShuttleItem(Shuttle.Type.PINK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> MAGENTA_SHUTTLE = ITEMS.register("magenta_shuttle", () -> new ShuttleItem(Shuttle.Type.MAGENTA, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> RED_SHUTTLE = ITEMS.register("red_shuttle", () -> new ShuttleItem(Shuttle.Type.RED, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> BROWN_SHUTTLE = ITEMS.register("brown_shuttle", () -> new ShuttleItem(Shuttle.Type.BROWN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> ORANGE_SHUTTLE = ITEMS.register("orange_shuttle", () -> new ShuttleItem(Shuttle.Type.ORANGE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> YELLOW_SHUTTLE = ITEMS.register("yellow_shuttle", () -> new ShuttleItem(Shuttle.Type.YELLOW, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> LIME_SHUTTLE = ITEMS.register("lime_shuttle", () -> new ShuttleItem(Shuttle.Type.LIME, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> GREEN_SHUTTLE = ITEMS.register("green_shuttle", () -> new ShuttleItem(Shuttle.Type.GREEN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> CYAN_SHUTTLE = ITEMS.register("cyan_shuttle", () -> new ShuttleItem(Shuttle.Type.CYAN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_SHUTTLE = ITEMS.register("light_blue_shuttle", () -> new ShuttleItem(Shuttle.Type.LIGHT_BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> BLUE_SHUTTLE = ITEMS.register("blue_shuttle", () -> new ShuttleItem(Shuttle.Type.BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));
	public static final RegistryObject<Item> PURPLE_SHUTTLE = ITEMS.register("purple_shuttle", () -> new ShuttleItem(Shuttle.Type.PURPLE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SHUTTLE_TAB)));


//	//Tools
//	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(ModItemTier.STEEL, /*attackDamage*/ 5, /*attackSpeed*/ -2.4F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
//	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(ModItemTier.STEEL, 8, -3.1F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModItemTier.STEEL, 3, -2.8F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(ModItemTier.STEEL, 3, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(ModItemTier.STEEL, 0, 0, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
//
//	//Armor
	public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

	public static final RegistryObject<Item> SPACE_SUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new SpaceSuitArmorItem(ModArmorMaterials.SPACE_SUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_BOOTS = ITEMS.register("space_suit_boots", () -> new SpaceSuitArmorItem(ModArmorMaterials.SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () -> new SpaceSuitArmorItem(ModArmorMaterials.SPACE_SUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () -> new SpaceSuitArmorItem(ModArmorMaterials.SPACE_SUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

	//TODO - netherite space suit

	//Items
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	//	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	 public static final RegistryObject<Item> SULFUR_BUCKET = ITEMS.register("sulfur_bucket", () -> new BucketItem(RegistryFluids.SULFUR, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new CatalystItem()); //FIXME?
//	public static final RegistryObject<Item> METEOR_INGOT = ITEMS.register("meteor_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	/**
	 * FOOD PROPERTIES
	 */
	public static final FoodProperties MARSHMALLOW_GOO_PROPERTIES = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.1F).build();
	public static final FoodProperties MARSHMALLOW_PROPERTIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
	public static final FoodProperties CHOCOLATE_PROPERTIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).build();
	public static final FoodProperties CRACKER_PROPERTIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
	public static final FoodProperties SMORES_PROPERTIES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties CHEESE_PROPERTIES = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.65F).build();

	/**
	 * FOODS
	 */
	public static final RegistryObject<Item> MARSHMALLOW_GOO = ITEMS.register("marshmallow_goo",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_GOO_PROPERTIES)));
	public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_PROPERTIES)));
	public static final RegistryObject<Item> ROASTED_MARSHMALLOW = ITEMS.register("roasted_marshmallow",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_PROPERTIES)));
	public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHOCOLATE_PROPERTIES)));
	public static final RegistryObject<Item> CRACKER = ITEMS.register("cracker",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CRACKER_PROPERTIES)));
	public static final RegistryObject<Item> SMORES = ITEMS.register("smores",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(SMORES_PROPERTIES)));
	public static final RegistryObject<Item> LUNAR_CHEESE = ITEMS.register("lunar_cheese",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHEESE_PROPERTIES)));
	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHEESE_PROPERTIES)));


	//CUSTOM ITEM TAGS
	public static final TagKey<Item> MARS_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_tag"));
	public static final TagKey<Item> MARS_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone_tag"));
	public static final TagKey<Item> MARS_COBBLESTONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone_tag"));
	public static final TagKey<Item> MARS_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate_tag"));
	public static final TagKey<Item> MARS_COBBLED_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate_tag"));

	public static final TagKey<Item> MOON_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_tag"));
	public static final TagKey<Item> MOON_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone_tag"));
	public static final TagKey<Item> MOON_COBBLESTONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone_tag"));
	public static final TagKey<Item> MOON_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate_tag"));
	public static final TagKey<Item> MOON_COBBLED_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobbled_deepslate_tag"));

	public static final TagKey<Item> METEOR_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_tag"));
	public static final TagKey<Item> METEOR_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_stone_tag"));



}

	
