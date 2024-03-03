package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Spaceship;
import com.shim.celestialexploration.entity.vehicle.AbstractMagCart;
import com.shim.celestialexploration.item.*;
import com.shim.celestialexploration.item.armor.AdvancedSpaceSuitArmorItem;
import com.shim.celestialexploration.item.armor.HeavyDutySpaceSuitArmorItem;
import com.shim.celestialexploration.item.armor.ThermalSpaceSuitArmorItem;
import com.shim.celestialexploration.item.armor.SpaceSuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
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

	public static <B extends Block> RegistryObject<Item> fromSpaceshipBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), SPACESHIP_ITEM_PROPERTIES));
	}

	public static <B extends Block> RegistryObject<Item> fromMiscBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
	}

	public static <B extends Block> RegistryObject<Item> fromNoTabBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}


	public static final Item.Properties BLOCK_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_BLOCKS_TAB);
	public static final Item.Properties SPACESHIP_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.SPACESHIP_TAB);
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB);

	/**
	 * Block Items
	 * MOON
	 * ~FULL BLOCKS
	 */
	public static final RegistryObject<Item> MOON_CORE = fromNoTabBlock(BlockRegistry.MOON_CORE);
	public static final RegistryObject<Item> MOON_SAND = fromBlock(BlockRegistry.MOON_SAND);
	public static final RegistryObject<Item> GLOWING_MOON_SAND = fromBlock(BlockRegistry.GLOWING_MOON_SAND);
	public static final RegistryObject<Item> COARSE_MOON_SAND = fromBlock(BlockRegistry.COARSE_MOON_SAND);
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
	public static final RegistryObject<Item> COMPRESSED_MOON_COBBLESTONE = fromBlock(BlockRegistry.COMPRESSED_MOON_COBBLESTONE);
	public static final RegistryObject<Item> COMPRESSED_MOON_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.COMPRESSED_MOON_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> MOON_BAUXITE_ORE = fromBlock(BlockRegistry.MOON_BAUXITE_ORE);

	//~STAIRS
	public static final RegistryObject<Item> MOON_STONE_STAIRS = fromBlock(BlockRegistry.MOON_STONE_STAIRS);
	public static final RegistryObject<Item> MOON_BRICK_STAIRS = fromBlock(BlockRegistry.MOON_BRICK_STAIRS);
	public static final RegistryObject<Item> MOON_COBBLESTONE_STAIRS = fromBlock(BlockRegistry.MOON_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> MOON_COBBLED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MOON_COBBLED_DEEPSLATE_STAIRS);
	public static final RegistryObject<Item> MOON_DEEPSLATE_BRICK_STAIRS = fromBlock(BlockRegistry.MOON_DEEPSLATE_BRICK_STAIRS);
	public static final RegistryObject<Item> MOON_DEEPSLATE_TILE_STAIRS = fromBlock(BlockRegistry.MOON_DEEPSLATE_TILE_STAIRS);
	public static final RegistryObject<Item> MOON_POLISHED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MOON_POLISHED_DEEPSLATE_STAIRS);
	//~SLABS
	public static final RegistryObject<Item> MOON_STONE_SLAB = fromBlock(BlockRegistry.MOON_STONE_SLAB);
	public static final RegistryObject<Item> MOON_SMOOTH_STONE_SLAB = fromBlock(BlockRegistry.MOON_SMOOTH_STONE_SLAB);
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
	public static final RegistryObject<Item> MARS_CORE = fromNoTabBlock(BlockRegistry.MARS_CORE);

	public static final RegistryObject<Item> MARS_SAND = fromBlock(BlockRegistry.MARS_SAND);
	public static final RegistryObject<Item> COARSE_MARS_SAND = fromBlock(BlockRegistry.COARSE_MARS_SAND);

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
	public static final RegistryObject<Item> COMPRESSED_MARS_COBBLESTONE = fromBlock(BlockRegistry.COMPRESSED_MARS_COBBLESTONE);
	public static final RegistryObject<Item> COMPRESSED_MARS_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.COMPRESSED_MARS_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> MARS_LANTERN = fromBlock(BlockRegistry.MARS_LANTERN);
	public static final RegistryObject<Item> MARS_BAUXITE_ORE = fromBlock(BlockRegistry.MARS_BAUXITE_ORE);


	//STAIRS
	public static final RegistryObject<Item> MARS_STONE_STAIRS = fromBlock(BlockRegistry.MARS_STONE_STAIRS);
	public static final RegistryObject<Item> MARS_BRICK_STAIRS = fromBlock(BlockRegistry.MARS_BRICK_STAIRS);
	public static final RegistryObject<Item> MARS_COBBLESTONE_STAIRS = fromBlock(BlockRegistry.MARS_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> MARS_DEEPSLATE_BRICK_STAIRS = fromBlock(BlockRegistry.MARS_DEEPSLATE_BRICK_STAIRS);
	public static final RegistryObject<Item> MARS_COBBLED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MARS_COBBLED_DEEPSLATE_STAIRS);
	public static final RegistryObject<Item> MARS_DEEPSLATE_TILE_STAIRS = fromBlock(BlockRegistry.MARS_DEEPSLATE_TILE_STAIRS);
	public static final RegistryObject<Item> MARS_POLISHED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.MARS_POLISHED_DEEPSLATE_STAIRS);

	//SLABS
	public static final RegistryObject<Item> MARS_STONE_SLAB = fromBlock(BlockRegistry.MARS_STONE_SLAB);
	public static final RegistryObject<Item> MARS_SMOOTH_STONE_SLAB = fromBlock(BlockRegistry.MARS_SMOOTH_STONE_SLAB);
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

	//VENUS
	//FULL BLOCKS
	public static final RegistryObject<Item> VENUS_CORE = fromNoTabBlock(BlockRegistry.VENUS_CORE);

	public static final RegistryObject<Item> VENUS_SAND = fromBlock(BlockRegistry.VENUS_SAND);
	public static final RegistryObject<Item> FINE_VENUS_SAND = fromBlock(BlockRegistry.FINE_VENUS_SAND);

	//	public static final RegistryObject<Item> MARS_SOIL = ITEMS.register("mars_soil", () -> new BlockItemBase(RegistryBlocks.MARS_SOIL.get()));
	public static final RegistryObject<Item> VENUS_STONE = fromBlock(BlockRegistry.VENUS_STONE);
	public static final RegistryObject<Item> VENUS_SMOOTH_STONE = fromBlock(BlockRegistry.VENUS_SMOOTH_STONE);

	public static final RegistryObject<Item> VENUS_BRICKS = fromBlock(BlockRegistry.VENUS_BRICKS);
	public static final RegistryObject<Item> SMALL_VENUS_BRICKS = fromBlock(BlockRegistry.SMALL_VENUS_BRICKS);

	public static final RegistryObject<Item> VENUS_BRICK_PILLAR = fromBlock(BlockRegistry.VENUS_BRICK_PILLAR);
	public static final RegistryObject<Item> CHISELED_VENUS_BRICKS = fromBlock(BlockRegistry.CHISELED_VENUS_BRICKS);
	public static final RegistryObject<Item> CRACKED_VENUS_BRICKS = fromBlock(BlockRegistry.CRACKED_VENUS_BRICKS);
	public static final RegistryObject<Item> VENUS_IRON_ORE = fromBlock(BlockRegistry.VENUS_IRON_ORE);
	public static final RegistryObject<Item> VENUS_REDSTONE_ORE = fromBlock(BlockRegistry.VENUS_REDSTONE_ORE);
	public static final RegistryObject<Item> VENUS_LAPIS_ORE = fromBlock(BlockRegistry.VENUS_LAPIS_ORE);
	public static final RegistryObject<Item> VENUS_COBBLESTONE = fromBlock(BlockRegistry.VENUS_COBBLESTONE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE = fromBlock(BlockRegistry.VENUS_DEEPSLATE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.VENUS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CRACKED_VENUS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> CHISELED_VENUS_DEEPSLATE_BRICKS = fromBlock(BlockRegistry.CHISELED_VENUS_DEEPSLATE_BRICKS);
	public static final RegistryObject<Item> VENUS_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_TILES = fromBlock(BlockRegistry.VENUS_DEEPSLATE_TILES);
	public static final RegistryObject<Item> CRACKED_VENUS_DEEPSLATE_TILES = fromBlock(BlockRegistry.CRACKED_VENUS_DEEPSLATE_TILES);
	public static final RegistryObject<Item> VENUS_POLISHED_DEEPSLATE = fromBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_IRON_ORE = fromBlock(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_REDSTONE_ORE = fromBlock(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_LAPIS_ORE = fromBlock(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE);
	public static final RegistryObject<Item> GEYSER = fromBlock(BlockRegistry.GEYSER);
	public static final RegistryObject<Item> VENUS_LANTERN = fromBlock(BlockRegistry.VENUS_LANTERN);
	public static final RegistryObject<Item> VENUS_BAUXITE_ORE = fromBlock(BlockRegistry.VENUS_BAUXITE_ORE);

	public static final RegistryObject<Item> SULFURIC_OBSIDIAN = fromBlock(BlockRegistry.SULFURIC_OBSIDIAN);

	public static final RegistryObject<Item> COMPRESSED_VENUS_COBBLESTONE = fromBlock(BlockRegistry.COMPRESSED_VENUS_COBBLESTONE);
	public static final RegistryObject<Item> COMPRESSED_VENUS_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.COMPRESSED_VENUS_COBBLED_DEEPSLATE);


	//STAIRS
	public static final RegistryObject<Item> VENUS_STONE_STAIRS = fromBlock(BlockRegistry.VENUS_STONE_STAIRS);
	public static final RegistryObject<Item> VENUS_BRICK_STAIRS = fromBlock(BlockRegistry.VENUS_BRICK_STAIRS);
	public static final RegistryObject<Item> SMALL_VENUS_BRICK_STAIRS = fromBlock(BlockRegistry.SMALL_VENUS_BRICK_STAIRS);
	public static final RegistryObject<Item> VENUS_COBBLESTONE_STAIRS = fromBlock(BlockRegistry.VENUS_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_BRICK_STAIRS = fromBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_STAIRS);
	public static final RegistryObject<Item> VENUS_COBBLED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_STAIRS);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_TILE_STAIRS = fromBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_STAIRS);
	public static final RegistryObject<Item> VENUS_POLISHED_DEEPSLATE_STAIRS = fromBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_STAIRS);


	//SLABS
	public static final RegistryObject<Item> VENUS_STONE_SLAB = fromBlock(BlockRegistry.VENUS_STONE_SLAB);
	public static final RegistryObject<Item> VENUS_SMOOTH_STONE_SLAB = fromBlock(BlockRegistry.VENUS_SMOOTH_STONE_SLAB);
	public static final RegistryObject<Item> VENUS_BRICK_SLAB = fromBlock(BlockRegistry.VENUS_BRICK_SLAB);
	public static final RegistryObject<Item> SMALL_VENUS_BRICK_SLAB = fromBlock(BlockRegistry.SMALL_VENUS_BRICK_SLAB);
	public static final RegistryObject<Item> VENUS_COBBLESTONE_SLAB = fromBlock(BlockRegistry.VENUS_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> VENUS_COBBLED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_BRICK_SLAB = fromBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_TILE_SLAB = fromBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB);
	public static final RegistryObject<Item> VENUS_POLISHED_DEEPSLATE_SLAB = fromBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB);

	//WALLS
	public static final RegistryObject<Item> VENUS_BRICK_WALL = fromBlock(BlockRegistry.VENUS_BRICK_WALL);
	public static final RegistryObject<Item> SMALL_VENUS_BRICK_WALL = fromBlock(BlockRegistry.SMALL_VENUS_BRICK_WALL);
	public static final RegistryObject<Item> VENUS_COBBLESTONE_WALL = fromBlock(BlockRegistry.VENUS_COBBLESTONE_WALL);
	public static final RegistryObject<Item> VENUS_COBBLED_DEEPSLATE_WALL = fromBlock(BlockRegistry.VENUS_COBBLED_DEEPSLATE_WALL);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_BRICK_WALL = fromBlock(BlockRegistry.VENUS_DEEPSLATE_BRICK_WALL);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_TILE_WALL = fromBlock(BlockRegistry.VENUS_DEEPSLATE_TILE_WALL);
	public static final RegistryObject<Item> VENUS_POLISHED_DEEPSLATE_WALL = fromBlock(BlockRegistry.VENUS_POLISHED_DEEPSLATE_WALL);

	//BUTTONS
	public static final RegistryObject<Item> VENUS_STONE_BUTTON = fromMiscBlock(BlockRegistry.VENUS_STONE_BUTTON);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_BUTTON = fromMiscBlock(BlockRegistry.VENUS_DEEPSLATE_BUTTON);

	//PRESSURE PlATES
	public static final RegistryObject<Item> VENUS_STONE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.VENUS_STONE_PRESSURE_PLATE);
	public static final RegistryObject<Item> VENUS_DEEPSLATE_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.VENUS_DEEPSLATE_PRESSURE_PLATE);



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
	public static final RegistryObject<Item> METEOR_SULFUR_ORE = fromBlock(BlockRegistry.METEOR_SULFUR_ORE);
	public static final RegistryObject<Item> METEOR_BAUXITE_ORE = fromBlock(BlockRegistry.METEOR_BAUXITE_ORE);

	public static final RegistryObject<Item> METEOR_BRICKS = fromBlock(BlockRegistry.METEOR_BRICKS);
	public static final RegistryObject<Item> CHISELED_METEOR_BRICKS = fromBlock(BlockRegistry.CHISELED_METEOR_BRICKS);	
	public static final RegistryObject<Item> METEOR_BRICK_STAIRS = fromBlock(BlockRegistry.METEOR_BRICK_STAIRS);	
	public static final RegistryObject<Item> METEOR_BRICK_SLAB = fromBlock(BlockRegistry.METEOR_BRICK_SLAB);	
	public static final RegistryObject<Item> METEOR_BRICK_WALL = fromBlock(BlockRegistry.METEOR_BRICK_WALL);

	public static final RegistryObject<Item> METEOR_BUTTON = fromMiscBlock(BlockRegistry.METEOR_BUTTON);
	public static final RegistryObject<Item> METEOR_PRESSURE_PLATE = fromMiscBlock(BlockRegistry.METEOR_PRESSURE_PLATE);



	public static final RegistryObject<Item> SOLAR_PLASMA = fromBlock(BlockRegistry.SOLAR_PLASMA);
	public static final RegistryObject<Item> SOLAR_FLARE = fromBlock(BlockRegistry.SOLAR_FLARE);
	public static final RegistryObject<Item> SUN_SPOT = fromBlock(BlockRegistry.SUN_SPOT);


	public static final RegistryObject<Item> MERCURY_STONE = fromBlock(BlockRegistry.MERCURY_STONE);
	public static final RegistryObject<Item> MERCURY_CORE = fromNoTabBlock(BlockRegistry.MERCURY_CORE);
	public static final RegistryObject<Item> MERCURY_DEEPSLATE = fromBlock(BlockRegistry.MERCURY_DEEPSLATE);


	public static final RegistryObject<Item> JUPITER_ATMOSPHERE = fromBlock(BlockRegistry.JUPITER_ATMOSPHERE);
	public static final RegistryObject<Item> JUPITER_CORE = fromNoTabBlock(BlockRegistry.JUPITER_CORE);
	public static final RegistryObject<Item> JUPITER_DEEPSLATE = fromBlock(BlockRegistry.JUPITER_DEEPSLATE);

	public static final RegistryObject<Item> IO_CORE = fromNoTabBlock(BlockRegistry.IO_CORE);
	public static final RegistryObject<Item> IO_STONE = fromBlock(BlockRegistry.IO_STONE);
	public static final RegistryObject<Item> IO_DEEPSLATE = fromBlock(BlockRegistry.IO_DEEPSLATE);

	public static final RegistryObject<Item> EUROPA_CORE = fromNoTabBlock(BlockRegistry.EUROPA_CORE);
	public static final RegistryObject<Item> EUROPA_HYDRATE = fromBlock(BlockRegistry.EUROPA_HYDRATE);
	public static final RegistryObject<Item> GANYMEDE_CORE = fromNoTabBlock(BlockRegistry.GANYMEDE_CORE);
	public static final RegistryObject<Item> CALLISTO_CORE = fromNoTabBlock(BlockRegistry.CALLISTO_CORE);

	public static final RegistryObject<Item> SATURN_ATMOSPHERE = fromBlock(BlockRegistry.SATURN_ATMOSPHERE);
	public static final RegistryObject<Item> SATURN_CORE = fromNoTabBlock(BlockRegistry.SATURN_CORE);
	public static final RegistryObject<Item> SATURN_DEEPSLATE = fromBlock(BlockRegistry.SATURN_DEEPSLATE);
	public static final RegistryObject<Item> TITAN_CORE = fromNoTabBlock(BlockRegistry.TITAN_CORE);
	public static final RegistryObject<Item> ENCELADUS_CORE = fromNoTabBlock(BlockRegistry.ENCELADUS_CORE);
	public static final RegistryObject<Item> RHEA_CORE = fromNoTabBlock(BlockRegistry.RHEA_CORE);
	public static final RegistryObject<Item> IAPETUS_CORE = fromNoTabBlock(BlockRegistry.IAPETUS_CORE);
	public static final RegistryObject<Item> HYPERION_CORE = fromNoTabBlock(BlockRegistry.HYPERION_CORE);
	public static final RegistryObject<Item> DIONE_CORE = fromNoTabBlock(BlockRegistry.DIONE_CORE);
	public static final RegistryObject<Item> URANUS_ATMOSPHERE = fromBlock(BlockRegistry.URANUS_ATMOSPHERE);
	public static final RegistryObject<Item> URANUS_CORE = fromNoTabBlock(BlockRegistry.URANUS_CORE);
	public static final RegistryObject<Item> URANUS_DEEPSLATE = fromBlock(BlockRegistry.URANUS_DEEPSLATE);
	public static final RegistryObject<Item> TITANIA_CORE = fromNoTabBlock(BlockRegistry.TITANIA_CORE);
	public static final RegistryObject<Item> OBERON_CORE = fromNoTabBlock(BlockRegistry.OBERON_CORE);
	public static final RegistryObject<Item> NEPTUNE_ATMOSPHERE = fromBlock(BlockRegistry.NEPTUNE_ATMOSPHERE);
	public static final RegistryObject<Item> NEPTUNE_CORE = fromNoTabBlock(BlockRegistry.NEPTUNE_CORE);
	public static final RegistryObject<Item> NEPTUNE_DEEPSLATE = fromBlock(BlockRegistry.NEPTUNE_DEEPSLATE);
	public static final RegistryObject<Item> TRITON_CORE = fromNoTabBlock(BlockRegistry.TRITON_CORE);
//	public static final RegistryObject<Item> PLUTO_CORE = fromNoTabBlock(BlockRegistry.PLUTO_CORE);
//	public static final RegistryObject<Item> CERES_CORE = fromNoTabBlock(BlockRegistry.CERES_CORE);
//	public static final RegistryObject<Item> ERIS_CORE = fromNoTabBlock(BlockRegistry.ERIS_CORE);
//	public static final RegistryObject<Item> HAUMEA_CORE = fromNoTabBlock(BlockRegistry.HAUMEA_CORE);
//	public static final RegistryObject<Item> MAKEMAKE_CORE = fromNoTabBlock(BlockRegistry.MAKEMAKE_CORE);

	
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
	public static final RegistryObject<Item> ALUMINUM_BLOCK = fromBlock(BlockRegistry.ALUMINUM_BLOCK);

	public static final RegistryObject<Item> AIRLOCK_DOOR = fromMiscBlock(BlockRegistry.AIRLOCK_DOOR);
	public static final RegistryObject<Item> STEEL_DOOR = fromMiscBlock(BlockRegistry.STEEL_DOOR);
	public static final RegistryObject<Item> STEEL_TRAPDOOR = fromMiscBlock(BlockRegistry.STEEL_TRAPDOOR);
	public static final RegistryObject<Item> STEEL_BUTTON = fromMiscBlock(BlockRegistry.STEEL_BUTTON);

	public static final RegistryObject<Item> COMPRESSED_COBBLESTONE = fromBlock(BlockRegistry.COMPRESSED_COBBLESTONE);
	public static final RegistryObject<Item> COMPRESSED_COBBLED_DEEPSLATE = fromBlock(BlockRegistry.COMPRESSED_COBBLED_DEEPSLATE);
	public static final RegistryObject<Item> COMPRESSED_NETHERRACK = fromBlock(BlockRegistry.COMPRESSED_NETHERRACK);
	public static final RegistryObject<Item> BAUXITE_ORE = fromBlock(BlockRegistry.BAUXITE_ORE);

	public static final RegistryObject<Item> DRY_ICE = fromBlock(BlockRegistry.DRY_ICE);
	public static final RegistryObject<Item> OXYGEN_COMPRESSOR = fromSpaceshipBlock(BlockRegistry.OXYGEN_COMPRESSOR);
	public static final RegistryObject<Item> WORKBENCH = fromSpaceshipBlock(BlockRegistry.WORKBENCH);

	public static final RegistryObject<Item> LOX_TANK = ITEMS.register("lox_tank", () -> new LoxTankItem(BlockRegistry.LOX_TANK.get(), new Item.Properties().tab(CelestialExploration.SPACESHIP_TAB).stacksTo(1)));

	public static final RegistryObject<Item> RUSTED_IRON_NUGGET = ITEMS.register("rusted_iron_nugget", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
//	public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_GOO = ITEMS.register("lunar_goo", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> INSULATED_PANEL = fromBlock(BlockRegistry.INSULATED_PANEL);
	public static final RegistryObject<Item> INSULATED_PANEL_CORNER = fromBlock(BlockRegistry.INSULATED_PANEL_CORNER);
	public static final RegistryObject<Item> PANEL = fromBlock(BlockRegistry.PANEL);
	public static final RegistryObject<Item> PANEL_STAIRS = fromBlock(BlockRegistry.PANEL_STAIRS);
	public static final RegistryObject<Item> PANEL_SLAB = fromBlock(BlockRegistry.PANEL_SLAB);
	public static final RegistryObject<Item> PANEL_WALL = fromBlock(BlockRegistry.PANEL_WALL);
	public static final RegistryObject<Item> THIN_PANEL = fromMiscBlock(BlockRegistry.THIN_PANEL);

	public static final RegistryObject<Item> RED_BUTTON = fromMiscBlock(BlockRegistry.RED_BUTTON);
	public static final RegistryObject<Item> YELLOW_BUTTON = fromMiscBlock(BlockRegistry.YELLOW_BUTTON);
	public static final RegistryObject<Item> BLUE_BUTTON = fromMiscBlock(BlockRegistry.BLUE_BUTTON);
	public static final RegistryObject<Item> GREEN_BUTTON = fromMiscBlock(BlockRegistry.GREEN_BUTTON);
	public static final RegistryObject<Item> WHITE_BUTTON = fromMiscBlock(BlockRegistry.WHITE_BUTTON);
	public static final RegistryObject<Item> BLACK_BUTTON = fromMiscBlock(BlockRegistry.BLACK_BUTTON);

	public static final RegistryObject<Item> PATHWAY_LIGHT = fromBlock(BlockRegistry.PATHWAY_LIGHT);

	public static final RegistryObject<Item> LUMINOUS_BLUE_GLASS = fromBlock(BlockRegistry.LUMINOUS_BLUE_GLASS);
	public static final RegistryObject<Item> LUMINOUS_WHITE_GLASS = fromBlock(BlockRegistry.LUMINOUS_WHITE_GLASS);
	public static final RegistryObject<Item> LUMINOUS_BLUE_GLASS_PANE = fromBlock(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE);
	public static final RegistryObject<Item> LUMINOUS_WHITE_GLASS_PANE = fromBlock(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE);

//	public static final RegistryObject<Item> CONNECTED_GLASS = fromBlock(BlockRegistry.CONNECTED_GLASS);
//	public static final RegistryObject<Item> CONNECTED_GLASS_PANE = fromBlock(BlockRegistry.CONNECTED_GLASS_PANE);
	public static final RegistryObject<Item> REINFORCED_GLASS = fromBlock(BlockRegistry.REINFORCED_GLASS);
	public static final RegistryObject<Item> REINFORCED_GLASS_PANE = fromBlock(BlockRegistry.REINFORCED_GLASS_PANE);

	public static final RegistryObject<Item> SILICA = fromBlock(BlockRegistry.SILICA);


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

	public static final RegistryObject<Item> VOIDFELLOW_SPAWN_EGG = ITEMS.register("voidfellow_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.VOIDFELLOW,0, 0xffffff,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> VOIDED_SPAWN_EGG = ITEMS.register("voided_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.VOIDED,0, 0x3c2d42,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> SULFUR_CUBE_SPAWN_EGG = ITEMS.register("sulfur_cube_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.SULFUR_CUBE,0x3e2800, 0x825300,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> VOIDED_PIGLIN_SPAWN_EGG = ITEMS.register("voided_piglin_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.VOIDED_PIGLIN,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> ASTRAL_PIGLIN_SPAWN_EGG = ITEMS.register("astral_piglin_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.ASTRAL_PIGLIN,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> FLARE_SPAWN_EGG = ITEMS.register("flare_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.FLARE,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> GUST_SPAWN_EGG = ITEMS.register("gust_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.GUST,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> VOIDED_ZOGLIN_SPAWN_EGG = ITEMS.register("voided_zoglin_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.VOIDED_ZOGLIN,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> ASTRAL_HOGLIN_SPAWN_EGG = ITEMS.register("astral_hoglin_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityRegistry.ASTRAL_HOGLIN,0, 0x3c2d62,
					new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));


	public static final RegistryObject<Item> CERAMIC = fromBlock(BlockRegistry.CERAMIC);
	public static final RegistryObject<Item> CERAMIC_TILE = fromBlock(BlockRegistry.CERAMIC_TILE);
	public static final RegistryObject<Item> WHITE_CERAMIC = fromBlock(BlockRegistry.WHITE_CERAMIC);
	public static final RegistryObject<Item> WHITE_CERAMIC_TILE = fromBlock(BlockRegistry.WHITE_CERAMIC_TILE);
	public static final RegistryObject<Item> LIGHT_GREY_CERAMIC = fromBlock(BlockRegistry.LIGHT_GREY_CERAMIC);
	public static final RegistryObject<Item> LIGHT_GREY_CERAMIC_TILE = fromBlock(BlockRegistry.LIGHT_GREY_CERAMIC_TILE);
	public static final RegistryObject<Item> GREY_CERAMIC = fromBlock(BlockRegistry.GREY_CERAMIC);
	public static final RegistryObject<Item> GREY_CERAMIC_TILE = fromBlock(BlockRegistry.GREY_CERAMIC_TILE);
	public static final RegistryObject<Item> BLACK_CERAMIC = fromBlock(BlockRegistry.BLACK_CERAMIC);
	public static final RegistryObject<Item> BLACK_CERAMIC_TILE = fromBlock(BlockRegistry.BLACK_CERAMIC_TILE);
	public static final RegistryObject<Item> PURPLE_CERAMIC = fromBlock(BlockRegistry.PURPLE_CERAMIC);
	public static final RegistryObject<Item> PURPLE_CERAMIC_TILE = fromBlock(BlockRegistry.PURPLE_CERAMIC_TILE);
	public static final RegistryObject<Item> MAGENTA_CERAMIC = fromBlock(BlockRegistry.MAGENTA_CERAMIC);
	public static final RegistryObject<Item> MAGENTA_CERAMIC_TILE = fromBlock(BlockRegistry.MAGENTA_CERAMIC_TILE);
	public static final RegistryObject<Item> BLUE_CERAMIC = fromBlock(BlockRegistry.BLUE_CERAMIC);
	public static final RegistryObject<Item> BLUE_CERAMIC_TILE = fromBlock(BlockRegistry.BLUE_CERAMIC_TILE);
	public static final RegistryObject<Item> LIGHT_BLUE_CERAMIC = fromBlock(BlockRegistry.LIGHT_BLUE_CERAMIC);
	public static final RegistryObject<Item> LIGHT_BLUE_CERAMIC_TILE = fromBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE);
	public static final RegistryObject<Item> CYAN_CERAMIC = fromBlock(BlockRegistry.CYAN_CERAMIC);
	public static final RegistryObject<Item> CYAN_CERAMIC_TILE = fromBlock(BlockRegistry.CYAN_CERAMIC_TILE);
	public static final RegistryObject<Item> GREEN_CERAMIC = fromBlock(BlockRegistry.GREEN_CERAMIC);
	public static final RegistryObject<Item> GREEN_CERAMIC_TILE = fromBlock(BlockRegistry.GREEN_CERAMIC_TILE);
	public static final RegistryObject<Item> LIME_CERAMIC = fromBlock(BlockRegistry.LIME_CERAMIC);
	public static final RegistryObject<Item> LIME_CERAMIC_TILE = fromBlock(BlockRegistry.LIME_CERAMIC_TILE);
	public static final RegistryObject<Item> YELLOW_CERAMIC = fromBlock(BlockRegistry.YELLOW_CERAMIC);
	public static final RegistryObject<Item> YELLOW_CERAMIC_TILE = fromBlock(BlockRegistry.YELLOW_CERAMIC_TILE);
	public static final RegistryObject<Item> ORANGE_CERAMIC = fromBlock(BlockRegistry.ORANGE_CERAMIC);
	public static final RegistryObject<Item> ORANGE_CERAMIC_TILE = fromBlock(BlockRegistry.ORANGE_CERAMIC_TILE);
	public static final RegistryObject<Item> BROWN_CERAMIC = fromBlock(BlockRegistry.BROWN_CERAMIC);
	public static final RegistryObject<Item> BROWN_CERAMIC_TILE = fromBlock(BlockRegistry.BROWN_CERAMIC_TILE);
	public static final RegistryObject<Item> RED_CERAMIC = fromBlock(BlockRegistry.RED_CERAMIC);
	public static final RegistryObject<Item> RED_CERAMIC_TILE = fromBlock(BlockRegistry.RED_CERAMIC_TILE);
	public static final RegistryObject<Item> PINK_CERAMIC = fromBlock(BlockRegistry.PINK_CERAMIC);
	public static final RegistryObject<Item> PINK_CERAMIC_TILE = fromBlock(BlockRegistry.PINK_CERAMIC_TILE);

//	public static final RegistryObject<Item> CERAMIC_STAIRS = fromBlock(BlockRegistry.CERAMIC_STAIRS);
//	public static final RegistryObject<Item> CERAMIC_SLAB = fromBlock(BlockRegistry.CERAMIC_SLAB);
//	public static final RegistryObject<Item> WHITE_CERAMIC_STAIRS = fromBlock(BlockRegistry.WHITE_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> WHITE_CERAMIC_SLAB = fromBlock(BlockRegistry.WHITE_CERAMIC_SLAB);
//	public static final RegistryObject<Item> LIGHT_GREY_CERAMIC_STAIRS = fromBlock(BlockRegistry.LIGHT_GREY_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> LIGHT_GREY_CERAMIC_SLAB = fromBlock(BlockRegistry.LIGHT_GREY_CERAMIC_SLAB);
//	public static final RegistryObject<Item> GREY_CERAMIC_STAIRS = fromBlock(BlockRegistry.GREY_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> GREY_CERAMIC_SLAB = fromBlock(BlockRegistry.GREY_CERAMIC_SLAB);
//	public static final RegistryObject<Item> BLACK_CERAMIC_STAIRS = fromBlock(BlockRegistry.BLACK_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> BLACK_CERAMIC_SLAB = fromBlock(BlockRegistry.BLACK_CERAMIC_SLAB);
//	public static final RegistryObject<Item> PURPLE_CERAMIC_STAIRS = fromBlock(BlockRegistry.PURPLE_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> PURPLE_CERAMIC_SLAB = fromBlock(BlockRegistry.PURPLE_CERAMIC_SLAB);
//	public static final RegistryObject<Item> MAGENTA_CERAMIC_STAIRS = fromBlock(BlockRegistry.MAGENTA_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> MAGENTA_CERAMIC_SLAB = fromBlock(BlockRegistry.MAGENTA_CERAMIC_SLAB);
//	public static final RegistryObject<Item> BLUE_CERAMIC_STAIRS = fromBlock(BlockRegistry.BLUE_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> BLUE_CERAMIC_SLAB = fromBlock(BlockRegistry.BLUE_CERAMIC_SLAB);
//	public static final RegistryObject<Item> LIGHT_BLUE_CERAMIC_STAIRS = fromBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> LIGHT_BLUE_CERAMIC_SLAB = fromBlock(BlockRegistry.LIGHT_BLUE_CERAMIC_SLAB);
//	public static final RegistryObject<Item> CYAN_CERAMIC_STAIRS = fromBlock(BlockRegistry.CYAN_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> CYAN_CERAMIC_SLAB = fromBlock(BlockRegistry.CYAN_CERAMIC_SLAB);
//	public static final RegistryObject<Item> GREEN_CERAMIC_STAIRS = fromBlock(BlockRegistry.GREEN_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> GREEN_CERAMIC_SLAB = fromBlock(BlockRegistry.GREEN_CERAMIC_SLAB);
//	public static final RegistryObject<Item> LIME_CERAMIC_STAIRS = fromBlock(BlockRegistry.LIME_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> LIME_CERAMIC_SLAB = fromBlock(BlockRegistry.LIME_CERAMIC_SLAB);
//	public static final RegistryObject<Item> YELLOW_CERAMIC_STAIRS = fromBlock(BlockRegistry.YELLOW_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> YELLOW_CERAMIC_SLAB = fromBlock(BlockRegistry.YELLOW_CERAMIC_SLAB);
//	public static final RegistryObject<Item> ORANGE_CERAMIC_STAIRS = fromBlock(BlockRegistry.ORANGE_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> ORANGE_CERAMIC_SLAB = fromBlock(BlockRegistry.ORANGE_CERAMIC_SLAB);
//	public static final RegistryObject<Item> BROWN_CERAMIC_STAIRS = fromBlock(BlockRegistry.BROWN_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> BROWN_CERAMIC_SLAB = fromBlock(BlockRegistry.BROWN_CERAMIC_SLAB);
//	public static final RegistryObject<Item> RED_CERAMIC_STAIRS = fromBlock(BlockRegistry.RED_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> RED_CERAMIC_SLAB = fromBlock(BlockRegistry.RED_CERAMIC_SLAB);
//	public static final RegistryObject<Item> PINK_CERAMIC_STAIRS = fromBlock(BlockRegistry.PINK_CERAMIC_STAIRS);
//	public static final RegistryObject<Item> PINK_CERAMIC_SLAB = fromBlock(BlockRegistry.PINK_CERAMIC_SLAB);

	public static final RegistryObject<Item> PAINTED_WHITE_CERAMIC = fromBlock(BlockRegistry.PAINTED_WHITE_CERAMIC);
	public static final RegistryObject<Item> PAINTED_LIGHT_GREY_CERAMIC = fromBlock(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC);
	public static final RegistryObject<Item> PAINTED_GREY_CERAMIC = fromBlock(BlockRegistry.PAINTED_GREY_CERAMIC);
	public static final RegistryObject<Item> PAINTED_BLACK_CERAMIC = fromBlock(BlockRegistry.PAINTED_BLACK_CERAMIC);
	public static final RegistryObject<Item> PAINTED_PURPLE_CERAMIC = fromBlock(BlockRegistry.PAINTED_PURPLE_CERAMIC);
	public static final RegistryObject<Item> PAINTED_MAGENTA_CERAMIC = fromBlock(BlockRegistry.PAINTED_MAGENTA_CERAMIC);
	public static final RegistryObject<Item> PAINTED_BLUE_CERAMIC = fromBlock(BlockRegistry.PAINTED_BLUE_CERAMIC);
	public static final RegistryObject<Item> PAINTED_LIGHT_BLUE_CERAMIC = fromBlock(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC);
	public static final RegistryObject<Item> PAINTED_CYAN_CERAMIC = fromBlock(BlockRegistry.PAINTED_CYAN_CERAMIC);
	public static final RegistryObject<Item> PAINTED_GREEN_CERAMIC = fromBlock(BlockRegistry.PAINTED_GREEN_CERAMIC);
	public static final RegistryObject<Item> PAINTED_LIME_CERAMIC = fromBlock(BlockRegistry.PAINTED_LIME_CERAMIC);
	public static final RegistryObject<Item> PAINTED_YELLOW_CERAMIC = fromBlock(BlockRegistry.PAINTED_YELLOW_CERAMIC);
	public static final RegistryObject<Item> PAINTED_ORANGE_CERAMIC = fromBlock(BlockRegistry.PAINTED_ORANGE_CERAMIC);
	public static final RegistryObject<Item> PAINTED_BROWN_CERAMIC = fromBlock(BlockRegistry.PAINTED_BROWN_CERAMIC);
	public static final RegistryObject<Item> PAINTED_RED_CERAMIC = fromBlock(BlockRegistry.PAINTED_RED_CERAMIC);
	public static final RegistryObject<Item> PAINTED_PINK_CERAMIC = fromBlock(BlockRegistry.PAINTED_PINK_CERAMIC);


	//	public static final RegistryObject<Item> THICK_CARBON_AIR = ITEMS.register("thick_carbon_air",  () -> new BlockItemBase(RegistryBlocks.THICK_CARBON_AIR.get()));
//	public static final RegistryObject<Item> GASEOUS_CARBON = ITEMS.register("gaseous_carbon", () -> new Item((new Item.Properties()).tab(Main.CELESTIAL_TAB)));



	//SPACESHIP
	public static final RegistryObject<Item> STEEL_FRAME = fromSpaceshipBlock(BlockRegistry.STEEL_FRAME);
//	public static final RegistryObject<Item> LAUNCH_PAD = ITEMS.register("launch_pad",  () -> new BlockItemBase(RegistryBlocks.LAUNCH_PAD.get()));
	public static final RegistryObject<Item> SPACESHIP_CABIN = ITEMS.register("spaceship_cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_FRAME = ITEMS.register("spaceship_frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_ENGINE = ITEMS.register("spaceship_engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
//	public static final RegistryObject<Item> NOSE_CONE = ITEMS.register("nose_cone", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	
	public static final RegistryObject<Item> BLACK_SPACESHIP = ITEMS.register("black_spaceship", () -> new SpaceshipItem(Spaceship.Type.BLACK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREY_SPACESHIP = ITEMS.register("grey_spaceship", () -> new SpaceshipItem(Spaceship.Type.GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_SPACESHIP = ITEMS.register("light_grey_spaceship", () -> new SpaceshipItem(Spaceship.Type.LIGHT_GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> WHITE_SPACESHIP = ITEMS.register("white_spaceship", () -> new SpaceshipItem(Spaceship.Type.WHITE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PINK_SPACESHIP = ITEMS.register("pink_spaceship", () -> new SpaceshipItem(Spaceship.Type.PINK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> MAGENTA_SPACESHIP = ITEMS.register("magenta_spaceship", () -> new SpaceshipItem(Spaceship.Type.MAGENTA, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> RED_SPACESHIP = ITEMS.register("red_spaceship", () -> new SpaceshipItem(Spaceship.Type.RED, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BROWN_SPACESHIP = ITEMS.register("brown_spaceship", () -> new SpaceshipItem(Spaceship.Type.BROWN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> ORANGE_SPACESHIP = ITEMS.register("orange_spaceship", () -> new SpaceshipItem(Spaceship.Type.ORANGE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> YELLOW_SPACESHIP = ITEMS.register("yellow_spaceship", () -> new SpaceshipItem(Spaceship.Type.YELLOW, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIME_SPACESHIP = ITEMS.register("lime_spaceship", () -> new SpaceshipItem(Spaceship.Type.LIME, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREEN_SPACESHIP = ITEMS.register("green_spaceship", () -> new SpaceshipItem(Spaceship.Type.GREEN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> CYAN_SPACESHIP = ITEMS.register("cyan_spaceship", () -> new SpaceshipItem(Spaceship.Type.CYAN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_SPACESHIP = ITEMS.register("light_blue_spaceship", () -> new SpaceshipItem(Spaceship.Type.LIGHT_BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BLUE_SPACESHIP = ITEMS.register("blue_spaceship", () -> new SpaceshipItem(Spaceship.Type.BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PURPLE_SPACESHIP = ITEMS.register("purple_spaceship", () -> new SpaceshipItem(Spaceship.Type.PURPLE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));


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

	public static final RegistryObject<ArmorItem> BASIC_SPACE_SUIT_HELMET = ITEMS.register("basic_space_suit_helmet", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACE_SUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACE_SUIT_BOOTS = ITEMS.register("basic_space_suit_boots", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACE_SUIT_CHESTPLATE = ITEMS.register("basic_space_suit_chestplate", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACE_SUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACE_SUIT_LEGGINGS = ITEMS.register("basic_space_suit_leggings", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACE_SUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACE_SUIT_HELMET = ITEMS.register("heavy_duty_space_suit_helmet", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACE_SUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACE_SUIT_BOOTS = ITEMS.register("heavy_duty_space_suit_boots", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACE_SUIT_CHESTPLATE = ITEMS.register("heavy_duty_space_suit_chestplate", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACE_SUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACE_SUIT_LEGGINGS = ITEMS.register("heavy_duty_space_suit_leggings", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACE_SUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> THERMAL_SPACE_SUIT_HELMET = ITEMS.register("thermal_space_suit_helmet", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACE_SUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACE_SUIT_BOOTS = ITEMS.register("thermal_space_suit_boots", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACE_SUIT_CHESTPLATE = ITEMS.register("thermal_space_suit_chestplate", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACE_SUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACE_SUIT_LEGGINGS = ITEMS.register("thermal_space_suit_leggings", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACE_SUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACE_SUIT_HELMET = ITEMS.register("advanced_space_suit_helmet", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACE_SUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACE_SUIT_BOOTS = ITEMS.register("advanced_space_suit_boots", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACE_SUIT_CHESTPLATE = ITEMS.register("advanced_space_suit_chestplate", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACE_SUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACE_SUIT_LEGGINGS = ITEMS.register("advanced_space_suit_leggings", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACE_SUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));


	//	public static final RegistryObject<ArmorItem> GRAVITY_BOOTS = ITEMS.register("gravity_boots", () -> new SpaceSuitArmorItem(ModArmorMaterials.SPACE_SUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));


	//TODO - netherite space suit

	//Items
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
//	public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register("raw_bauxite", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> BAUXITE_INGOT = ITEMS.register("bauxite_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	//	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_TAB)));
//	 public static final RegistryObject<Item> SULFUR_BUCKET = ITEMS.register("sulfur_bucket", () -> new BucketItem(RegistryFluids.SULFUR, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new CatalystItem()); //FIXME?
//	public static final RegistryObject<Item> METEOR_INGOT = ITEMS.register("meteor_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> FLARE_ROD = ITEMS.register("flare_rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));


	public static final RegistryObject<Item> BLOCK_MOLD = ITEMS.register("block_mold", () -> new Item(new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> INGOT_MOLD = ITEMS.register("ingot_mold", () -> new Item(new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
//	public static final RegistryObject<Item> NUGGET_MOLD = ITEMS.register("nugget_mold", () -> new NuggetMoldItem((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> STEEL_WOOL = ITEMS.register("steel_wool", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));


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
	public static final RegistryObject<Item> MARSHMALLOW_GOO = ITEMS.register("marshmallow_goo", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_GOO_PROPERTIES)));
	public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_PROPERTIES)));
	public static final RegistryObject<Item> ROASTED_MARSHMALLOW = ITEMS.register("roasted_marshmallow", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(MARSHMALLOW_PROPERTIES)));
	public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHOCOLATE_PROPERTIES)));
	public static final RegistryObject<Item> CRACKER = ITEMS.register("cracker", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CRACKER_PROPERTIES)));
	public static final RegistryObject<Item> SMORES = ITEMS.register("smores", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(SMORES_PROPERTIES)));
	public static final RegistryObject<Item> LUNAR_CHEESE = ITEMS.register("lunar_cheese", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHEESE_PROPERTIES)));
	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CHEESE_PROPERTIES)));

	/* MAG LEV */
	public static final RegistryObject<Item> MAG_RAIL = fromSpaceshipBlock(BlockRegistry.MAG_RAIL);
	public static final RegistryObject<Item> POWERED_MAG_RAIL = fromSpaceshipBlock(BlockRegistry.POWERED_MAG_RAIL);
	public static final RegistryObject<Item> DETECTOR_MAG_RAIL = fromSpaceshipBlock(BlockRegistry.DETECTOR_MAG_RAIL);
	public static final RegistryObject<Item> ACTIVATOR_MAG_RAIL = fromSpaceshipBlock(BlockRegistry.ACTIVATOR_MAG_RAIL);

	public static final RegistryObject<Item> MAGCART = ITEMS.register("magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> CHEST_MAGCART = ITEMS.register("chest_magcart", () -> new MagCartItem(AbstractMagCart.Type.CHEST, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> COMMAND_BLOCK_MAGCART = ITEMS.register("command_block_magcart", () -> new MagCartItem(AbstractMagCart.Type.COMMAND_BLOCK, (new Item.Properties().stacksTo(1).rarity(Rarity.EPIC))));
	public static final RegistryObject<Item> FURNACE_MAGCART = ITEMS.register("furnace_magcart", () -> new MagCartItem(AbstractMagCart.Type.FURNACE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> HOPPER_MAGCART = ITEMS.register("hopper_magcart", () -> new MagCartItem(AbstractMagCart.Type.HOPPER, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
//	public static final RegistryObject<Item> SPAWNER_MAGCART = ITEMS.register("magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> TNT_MAGCART = ITEMS.register("tnt_magcart", () -> new MagCartItem(AbstractMagCart.Type.TNT, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));

	//	public static final Item MINECART = registerItem("minecart", new MinecartItem(AbstractMinecart.Type.RIDEABLE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
//	public static final Item CHEST_MINECART = registerItem("chest_minecart", new MinecartItem(AbstractMinecart.Type.CHEST, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
//	public static final Item FURNACE_MINECART = registerItem("furnace_minecart", new MinecartItem(AbstractMinecart.Type.FURNACE, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
//	public static final Item TNT_MINECART = registerItem("tnt_minecart", new MinecartItem(AbstractMinecart.Type.TNT, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
//	public static final Item HOPPER_MINECART = registerItem("hopper_minecart", new MinecartItem(AbstractMinecart.Type.HOPPER, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
//	public static final Item COMMAND_BLOCK_MINECART = registerItem("command_block_minecart", new MinecartItem(AbstractMinecart.Type.COMMAND_BLOCK, (new Item.Properties()).stacksTo(1).rarity(Rarity.EPIC)));


	//CUSTOM ITEM TAGS
	public static final TagKey<Item> MARS_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars"));
	public static final TagKey<Item> MARS_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_stone"));
	public static final TagKey<Item> MARS_COBBLESTONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobblestone"));
	public static final TagKey<Item> MARS_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_deepslate"));
	public static final TagKey<Item> MARS_COBBLED_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mars_cobbled_deepslate"));

	public static final TagKey<Item> MOON_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon"));
	public static final TagKey<Item> MOON_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_stone"));
	public static final TagKey<Item> MOON_COBBLESTONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobblestone"));
	public static final TagKey<Item> MOON_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_deepslate"));
	public static final TagKey<Item> MOON_COBBLED_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "moon_cobbled_deepslate"));

	public static final TagKey<Item> VENUS_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus"));
	public static final TagKey<Item> VENUS_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_stone"));
	public static final TagKey<Item> VENUS_COBBLESTONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobblestone"));
	public static final TagKey<Item> VENUS_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_deepslate"));
	public static final TagKey<Item> VENUS_COBBLED_DEEPSLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "venus_cobbled_deepslate"));


	public static final TagKey<Item> METEOR_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor"));
	public static final TagKey<Item> METEOR_STONE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "meteor_stone"));

	public static final TagKey<Item> DYED_CERAMIC_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "ceramic"));
	public static final TagKey<Item> PAINTED_CERAMIC_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "painted"));
	public static final TagKey<Item> DYED_CERAMIC_TILE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "ceramic_tile"));
	public static final TagKey<Item> PAINTED_CERAMIC_TILE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "painted_ceramic_tile"));

	public static final TagKey<Item> MAG_RAIL_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "mag_rail"));

	public static final TagKey<Item> STONE_PRESSURE_PLATE_TAG = ItemTags.create(new ResourceLocation(CelestialExploration.MODID, "stone_pressure_plate"));


}