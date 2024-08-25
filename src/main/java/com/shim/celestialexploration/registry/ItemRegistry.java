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
import net.minecraft.world.entity.EntityType;
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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class ItemRegistry {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CelestialExploration.MODID);

	public static final Map<RegistryObject<? extends Item>, String> ITEM_LANG_EN_US = new HashMap<>();

	public static void register(IEventBus event) {
		ITEMS.register(event);
	}

	public static <T extends Item> RegistryObject<T> registerItem(String nameIn, String localizationIn, Supplier<T> itemIn) {
		RegistryObject<T> item = ITEMS.register(nameIn, itemIn);
		ITEM_LANG_EN_US.put(item, localizationIn);
		return item;
	}

	public static RegistryObject<Item> registerFood(String nameIn, String localizationIn, int nutrition, float saturation) {
		RegistryObject<Item> item = ITEMS.register(nameIn, () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food((new FoodProperties.Builder()).fast().nutrition(nutrition).saturationMod(saturation).build())));
		ITEM_LANG_EN_US.put(item, localizationIn);
		return item;
	}
	
	public static final Item.Properties BLOCK_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_BLOCKS_TAB);
	public static final Item.Properties SPACESHIP_ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.SPACESHIP_TAB);
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB);

	//---- SPACESHIP -------------------------------------------------------------------------------
	public static final RegistryObject<Item> LOX_TANK = registerItem("lox_tank", "Liquid Oxygen Tank", () -> new LoxTankItem(BlockRegistry.LOX_TANK.get(), new Item.Properties().tab(CelestialExploration.SPACESHIP_TAB).stacksTo(1)));

	public static final RegistryObject<Item> SPACESHIP_CABIN = registerItem("spaceship_cabin", "Spaceship Cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_FRAME = registerItem("spaceship_frame", "Spaceship Frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_ENGINE = registerItem("spaceship_engine", "Spaceship Engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));

	public static final RegistryObject<Item> BLACK_SPACESHIP = registerItem("black_spaceship", "Black Spaceship", () -> new SpaceshipItem(Spaceship.Type.BLACK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREY_SPACESHIP = registerItem("grey_spaceship", "Grey Spaceship", () -> new SpaceshipItem(Spaceship.Type.GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_SPACESHIP = registerItem("light_grey_spaceship", "Light Grey Spaceship", () -> new SpaceshipItem(Spaceship.Type.LIGHT_GREY, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> WHITE_SPACESHIP = registerItem("white_spaceship", "White Spaceship", () -> new SpaceshipItem(Spaceship.Type.WHITE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PINK_SPACESHIP = registerItem("pink_spaceship", "Pink Spaceship", () -> new SpaceshipItem(Spaceship.Type.PINK, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> MAGENTA_SPACESHIP = registerItem("magenta_spaceship", "Magenta Spaceship", () -> new SpaceshipItem(Spaceship.Type.MAGENTA, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> RED_SPACESHIP = registerItem("red_spaceship", "Red Spaceship", () -> new SpaceshipItem(Spaceship.Type.RED, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BROWN_SPACESHIP = registerItem("brown_spaceship", "Brown Spaceship", () -> new SpaceshipItem(Spaceship.Type.BROWN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> ORANGE_SPACESHIP = registerItem("orange_spaceship", "Orange Spaceship", () -> new SpaceshipItem(Spaceship.Type.ORANGE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> YELLOW_SPACESHIP = registerItem("yellow_spaceship", "Yellow Spaceship", () -> new SpaceshipItem(Spaceship.Type.YELLOW, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIME_SPACESHIP = registerItem("lime_spaceship", "Lime Spaceship", () -> new SpaceshipItem(Spaceship.Type.LIME, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREEN_SPACESHIP = registerItem("green_spaceship", "Green Spaceship", () -> new SpaceshipItem(Spaceship.Type.GREEN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> CYAN_SPACESHIP = registerItem("cyan_spaceship", "Cyan Spaceship", () -> new SpaceshipItem(Spaceship.Type.CYAN, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_SPACESHIP = registerItem("light_blue_spaceship", "Light Blue Spaceship", () -> new SpaceshipItem(Spaceship.Type.LIGHT_BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BLUE_SPACESHIP = registerItem("blue_spaceship", "Blue Spaceship", () -> new SpaceshipItem(Spaceship.Type.BLUE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PURPLE_SPACESHIP = registerItem("purple_spaceship", "Purple Spaceship", () -> new SpaceshipItem(Spaceship.Type.PURPLE, new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB)));

	//ITEMS
	public static final RegistryObject<Item> MAGCART = registerItem("magcart", "Magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> CHEST_MAGCART = registerItem("chest_magcart", "Chest Magcart", () -> new MagCartItem(AbstractMagCart.Type.CHEST, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> COMMAND_BLOCK_MAGCART = registerItem("command_block_magcart", "Command Block Magcart", () -> new MagCartItem(AbstractMagCart.Type.COMMAND_BLOCK, (new Item.Properties().stacksTo(1).rarity(Rarity.EPIC))));
	public static final RegistryObject<Item> FURNACE_MAGCART = registerItem("furnace_magcart", "Furnace Magcart", () -> new MagCartItem(AbstractMagCart.Type.FURNACE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> HOPPER_MAGCART = registerItem("hopper_magcart", "Hopper Magcart", () -> new MagCartItem(AbstractMagCart.Type.HOPPER, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	//	public static final RegistryObject<Item> SPAWNER_MAGCART = registerItem("magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));
	public static final RegistryObject<Item> TNT_MAGCART = registerItem("tnt_magcart", "TNT Magcart", () -> new MagCartItem(AbstractMagCart.Type.TNT, (new Item.Properties().stacksTo(1).tab(CelestialExploration.SPACESHIP_TAB))));

	//---- ARMOR -------------------------------------------------------------------------------
	//STEEL
	public static final RegistryObject<Item> STEEL_HELMET = registerItem("steel_helmet", "Steel Helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_BOOTS = registerItem("steel_boots", "Steel Boots", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_CHESTPLATE = registerItem("steel_chestplate", "Steel Chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_LEGGINGS = registerItem("steel_leggings", "Steel Leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

	//SPACE SUIT
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_HELMET = registerItem("basic_spacesuit_helmet", "Basic Spacesuit Helmet", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_BOOTS = registerItem("basic_spacesuit_boots", "Basic Spacesuit Boots", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_CHESTPLATE = registerItem("basic_spacesuit_chestplate", "Basic Spacesuit Chestplate", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_LEGGINGS = registerItem("basic_spacesuit_leggings", "Basic Spacesuit Leggings", () -> new SpaceSuitArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_HELMET = registerItem("heavy_duty_spacesuit_helmet", "Heavy Duty Spacesuit Helmet", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_BOOTS = registerItem("heavy_duty_spacesuit_boots", "Heavy Duty Spacesuit Boots", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_CHESTPLATE = registerItem("heavy_duty_spacesuit_chestplate", "Heavy Duty Spacesuit Chestplate", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_LEGGINGS = registerItem("heavy_duty_spacesuit_leggings", "Heavy Duty Spacesuit Leggings", () -> new HeavyDutySpaceSuitArmorItem(ModArmorMaterials.HEAVY_DUTY_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_HELMET = registerItem("thermal_spacesuit_helmet", "Thermal Spacesuit Helmet", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_BOOTS = registerItem("thermal_spacesuit_boots", "Thermal Spacesuit Boots", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_CHESTPLATE = registerItem("thermal_spacesuit_chestplate", "Thermal Spacesuit Chestplate", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_LEGGINGS = registerItem("thermal_spacesuit_leggings", "Thermal Spacesuit Leggings", () -> new ThermalSpaceSuitArmorItem(ModArmorMaterials.THERMAL_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_HELMET = registerItem("advanced_spacesuit_helmet", "Advanced Spacesuit Helmet", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_BOOTS = registerItem("advanced_spacesuit_boots", "Advanced Spacesuit Boots", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_CHESTPLATE = registerItem("advanced_spacesuit_chestplate", "Advanced Spacesuit Chestplate", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_LEGGINGS = registerItem("advanced_spacesuit_leggings", "Advanced Spacesuit Leggings", () -> new AdvancedSpaceSuitArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	//---- SPAWN EGGS -------------------------------------------------------------------------------
	public static final RegistryObject<Item> RUST_SPAWN_EGG = registerItem("rust_spawn_egg", "Rust Slime Spawn egg", () -> new ForgeSpawnEggItem(EntityRegistry.RUST_SLIME,0x7f3414, 0x984521, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_SPAWN_EGG = registerItem("lunar_spawn_egg", "Lunar Slime Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.LUNAR_SLIME,0xd5d5d5, 0xfafafa, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> MARS_MALLOW_SPAWN_EGG = registerItem("mars_mallow_spawn_egg", "Mars Mallow Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.MARS_MALLOW,0xcda568, 0xfaf5ee, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> QUICKSILVER_SPAWN_EGG = registerItem("quicksilver_spawn_egg", "Quicksilver Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.QUICKSILVER_SLIME,0xd5d5d5, 0xfafafa, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VISCOUS_SPAWN_EGG = registerItem("viscous_spawn_egg", "Viscous Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.VISCOUS_SLIME,0xcda568, 0xfaf5ee, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LURKER_SPAWN_EGG = registerItem("lurker_spawn_egg", "Lurker Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.LURKER,0, 0x894731, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDFELLOW_SPAWN_EGG = registerItem("voidfellow_spawn_egg", "Space Fellow Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.VOIDFELLOW,0, 0xffffff, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_SPAWN_EGG = registerItem("voided_spawn_egg", "Voided Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.VOIDED,0, 0x3c2d42, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> SULFUR_CUBE_SPAWN_EGG = registerItem("sulfur_cube_spawn_egg", "Sulfur Cube Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.SULFUR_CUBE,0x3e2800, 0x825300, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_PIGLIN_SPAWN_EGG = registerItem("voided_piglin_spawn_egg", "Voided Piglin Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.VOIDED_PIGLIN,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ASTRAL_PIGLIN_SPAWN_EGG = registerItem("astral_piglin_spawn_egg", "Astral Piglin Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.ASTRAL_PIGLIN,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> FLARE_SPAWN_EGG = registerItem("flare_spawn_egg", "Flare Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.FLARE,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GUST_SPAWN_EGG = registerItem("gust_spawn_egg", "Gust Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.GUST,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_ZOGLIN_SPAWN_EGG = registerItem("voided_zoglin_spawn_egg", "Voided Zoglin Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.VOIDED_ZOGLIN,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ASTRAL_HOGLIN_SPAWN_EGG = registerItem("astral_hoglin_spawn_egg", "Astral Hoglin Spawn Egg", () -> new ForgeSpawnEggItem(EntityRegistry.ASTRAL_HOGLIN,0, 0x3c2d62, new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));

	//---- MOB HEADS -------------------------------------------------------------------------------

	public static final RegistryObject<Item> LURKER_HEAD = ITEMS.register("lurker_head", () -> new StandingAndWallBlockItem(BlockRegistry.LURKER_HEAD.get(), BlockRegistry.LURKER_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> VOIDED_HEAD = ITEMS.register("voided_head", () -> new StandingAndWallBlockItem(BlockRegistry.VOIDED_HEAD.get(), BlockRegistry.VOIDED_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));

	//---- MISC ITEMS -------------------------------------------------------------------------------
	public static final RegistryObject<Item> RUSTED_IRON_NUGGET = registerItem("rusted_iron_nugget", "Rusted Iron Nugget", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_GOO = registerItem("lunar_goo", "Lunar Goo", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> STEEL_INGOT = registerItem("steel_ingot", "Steel Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_NUGGET = registerItem("steel_nugget", "Steel Nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_BAUXITE = registerItem("raw_bauxite", "Raw Bauxite", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> BAUXITE_INGOT = registerItem("bauxite_ingot", "Bauxite Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = registerItem("aluminum_ingot", "Aluminum Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> MOON_DUST = registerItem("moon_dust", "Moon Dust", () -> new Item((new Item.Properties()).tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> STEEL_ROD = registerItem("steel_rod", "Steel Rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> FLARE_ROD = registerItem("flare_rod", "Flare Rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> BLOCK_MOLD = registerItem("block_mold", "Block Mold", () -> new Item(new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> INGOT_MOLD = registerItem("ingot_mold", "Ingot Mold", () -> new Item(new Item.Properties().tab(CelestialExploration.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> STEEL_WOOL = registerItem("steel_wool", "Steel Wool", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> SULFUR_CRYSTAL = registerItem("sulfur_crystal", "Sulfur Crystal", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> CINNABAR = registerItem("cinnabar", "Cinnarbar", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> CONTROL_PANEL = registerItem("control_panel", "Control Panel", () -> new ControlPanelItem(new Item.Properties().tab(CelestialExploration.SPACESHIP_TAB)));

	//---- FOOD -------------------------------------------------------------------------------
	public static final RegistryObject<Item> MARSHMALLOW_GOO = registerFood("marshmallow_goo", "Marshmallow Goo", 1, 0.1F);
	public static final RegistryObject<Item> MARSHMALLOW = registerFood("marshmallow", "Marshmallow", 1, 0.2F);
	public static final RegistryObject<Item> ROASTED_MARSHMALLOW = registerFood("roasted_marshmallow", "Roasted Marshmallow", 1, 0.2F);
	public static final RegistryObject<Item> CHOCOLATE = registerFood("chocolate", "Chocolate", 1, 0.4F);
	public static final RegistryObject<Item> CRACKER = registerFood("cracker", "Cracker", 1, 0.2F);
	public static final RegistryObject<Item> SMORES = registerFood("smores", "S'mores", 1, 0.3F);
	public static final RegistryObject<Item> LUNAR_CHEESE = registerFood("lunar_cheese", "Lunar Cheese", 5, 0.65F);
	public static final RegistryObject<Item> CHEESE = registerFood("cheese", "Cheese", 5, 0.65F);

}