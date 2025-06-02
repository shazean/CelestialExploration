package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.entity.vehicle.AbstractMagCart;
import com.shim.celestialexploration.item.*;
import com.shim.celestialexploration.item.armor.HeavyDutySpacesuitArmorItem;
import com.shim.celestialexploration.item.armor.ThermalSpacesuitArmorItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class CelestialItems {
	
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
	
	public static final Item.Properties BLOCK_ITEM_PROPERTIES = new Item.Properties().tab(CelestialTabs.CELESTIAL_BLOCKS_TAB);
	public static final Item.Properties SPACESHIP_ITEM_PROPERTIES = new Item.Properties().tab(CelestialTabs.SPACESHIP_TAB);
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB);

	//---- SPACESHIP -------------------------------------------------------------------------------
	public static final RegistryObject<Item> LOX_TANK = ITEMS.register("lox_tank", () -> new LoxTankItem(CelestialBlocks.LOX_TANK.get(), new Item.Properties().tab(CelestialTabs.SPACESHIP_TAB).stacksTo(1)));

	public static final RegistryObject<Item> SPACESHIP_CABIN = registerItem("spaceship_cabin", "Spaceship Cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_FRAME = registerItem("spaceship_frame", "Spaceship Frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> SPACESHIP_ENGINE = registerItem("spaceship_engine", "Spaceship Engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));

	public static final RegistryObject<Item> BLACK_SPACESHIP = registerItem("black_spaceship", "Black Spaceship", () -> new SpaceshipItem(DyeType.BLACK, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREY_SPACESHIP = registerItem("grey_spaceship", "Grey Spaceship", () -> new SpaceshipItem(DyeType.GREY, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_SPACESHIP = registerItem("light_grey_spaceship", "Light Grey Spaceship", () -> new SpaceshipItem(DyeType.LIGHT_GREY, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> WHITE_SPACESHIP = registerItem("white_spaceship", "White Spaceship", () -> new SpaceshipItem(DyeType.WHITE, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PINK_SPACESHIP = registerItem("pink_spaceship", "Pink Spaceship", () -> new SpaceshipItem(DyeType.PINK, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> MAGENTA_SPACESHIP = registerItem("magenta_spaceship", "Magenta Spaceship", () -> new SpaceshipItem(DyeType.MAGENTA, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> RED_SPACESHIP = registerItem("red_spaceship", "Red Spaceship", () -> new SpaceshipItem(DyeType.RED, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BROWN_SPACESHIP = registerItem("brown_spaceship", "Brown Spaceship", () -> new SpaceshipItem(DyeType.BROWN, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> ORANGE_SPACESHIP = registerItem("orange_spaceship", "Orange Spaceship", () -> new SpaceshipItem(DyeType.ORANGE, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> YELLOW_SPACESHIP = registerItem("yellow_spaceship", "Yellow Spaceship", () -> new SpaceshipItem(DyeType.YELLOW, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIME_SPACESHIP = registerItem("lime_spaceship", "Lime Spaceship", () -> new SpaceshipItem(DyeType.LIME, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> GREEN_SPACESHIP = registerItem("green_spaceship", "Green Spaceship", () -> new SpaceshipItem(DyeType.GREEN, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> CYAN_SPACESHIP = registerItem("cyan_spaceship", "Cyan Spaceship", () -> new SpaceshipItem(DyeType.CYAN, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_SPACESHIP = registerItem("light_blue_spaceship", "Light Blue Spaceship", () -> new SpaceshipItem(DyeType.LIGHT_BLUE, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> BLUE_SPACESHIP = registerItem("blue_spaceship", "Blue Spaceship", () -> new SpaceshipItem(DyeType.BLUE, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));
	public static final RegistryObject<Item> PURPLE_SPACESHIP = registerItem("purple_spaceship", "Purple Spaceship", () -> new SpaceshipItem(DyeType.PURPLE, new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));

	//ITEMS
	public static final RegistryObject<Item> MAGCART = registerItem("magcart", "Magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));
	public static final RegistryObject<Item> CHEST_MAGCART = registerItem("chest_magcart", "Chest Magcart", () -> new MagCartItem(AbstractMagCart.Type.CHEST, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));
	public static final RegistryObject<Item> COMMAND_BLOCK_MAGCART = registerItem("command_block_magcart", "Command Block Magcart", () -> new MagCartItem(AbstractMagCart.Type.COMMAND_BLOCK, (new Item.Properties().stacksTo(1).rarity(Rarity.EPIC))));
	public static final RegistryObject<Item> FURNACE_MAGCART = registerItem("furnace_magcart", "Furnace Magcart", () -> new MagCartItem(AbstractMagCart.Type.FURNACE, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));
	public static final RegistryObject<Item> HOPPER_MAGCART = registerItem("hopper_magcart", "Hopper Magcart", () -> new MagCartItem(AbstractMagCart.Type.HOPPER, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));
	//	public static final RegistryObject<Item> SPAWNER_MAGCART = registerItem("magcart", () -> new MagCartItem(AbstractMagCart.Type.RIDEABLE, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));
	public static final RegistryObject<Item> TNT_MAGCART = registerItem("tnt_magcart", "TNT Magcart", () -> new MagCartItem(AbstractMagCart.Type.TNT, (new Item.Properties().stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB))));

	//---- ARMOR -------------------------------------------------------------------------------
	//STEEL
	public static final RegistryObject<Item> STEEL_HELMET = registerItem("steel_helmet", "Steel Helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_BOOTS = registerItem("steel_boots", "Steel Boots", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_CHESTPLATE = registerItem("steel_chestplate", "Steel Chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_LEGGINGS = registerItem("steel_leggings", "Steel Leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));

	//SPACE SUIT
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_HELMET = registerItem("basic_spacesuit_helmet", "Basic Spacesuit Helmet", () -> new ArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_BOOTS = registerItem("basic_spacesuit_boots", "Basic Spacesuit Boots", () -> new ArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_CHESTPLATE = registerItem("basic_spacesuit_chestplate", "Basic Spacesuit Chestplate", () -> new ArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> BASIC_SPACESUIT_LEGGINGS = registerItem("basic_spacesuit_leggings", "Basic Spacesuit Leggings", () -> new ArmorItem(ModArmorMaterials.BASIC_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_HELMET = registerItem("heavy_duty_spacesuit_helmet", "Heavy Duty Spacesuit Helmet", () -> new HeavyDutySpacesuitArmorItem(EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_BOOTS = registerItem("heavy_duty_spacesuit_boots", "Heavy Duty Spacesuit Boots", () -> new HeavyDutySpacesuitArmorItem(EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_CHESTPLATE = registerItem("heavy_duty_spacesuit_chestplate", "Heavy Duty Spacesuit Chestplate", () -> new HeavyDutySpacesuitArmorItem(EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> HEAVY_DUTY_SPACESUIT_LEGGINGS = registerItem("heavy_duty_spacesuit_leggings", "Heavy Duty Spacesuit Leggings", () -> new HeavyDutySpacesuitArmorItem(EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_HELMET = registerItem("thermal_spacesuit_helmet", "Thermal Spacesuit Helmet", () -> new ThermalSpacesuitArmorItem(EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_BOOTS = registerItem("thermal_spacesuit_boots", "Thermal Spacesuit Boots", () -> new ThermalSpacesuitArmorItem(EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_CHESTPLATE = registerItem("thermal_spacesuit_chestplate", "Thermal Spacesuit Chestplate", () -> new ThermalSpacesuitArmorItem(EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> THERMAL_SPACESUIT_LEGGINGS = registerItem("thermal_spacesuit_leggings", "Thermal Spacesuit Leggings", () -> new ThermalSpacesuitArmorItem(EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_HELMET = registerItem("advanced_spacesuit_helmet", "Advanced Spacesuit Helmet", () -> new ArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_BOOTS = registerItem("advanced_spacesuit_boots", "Advanced Spacesuit Boots", () -> new ArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_CHESTPLATE = registerItem("advanced_spacesuit_chestplate", "Advanced Spacesuit Chestplate", () -> new ArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ADVANCED_SPACESUIT_LEGGINGS = registerItem("advanced_spacesuit_leggings", "Advanced Spacesuit Leggings", () -> new ArmorItem(ModArmorMaterials.ADVANCED_SPACESUIT, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	//---- SPAWN EGGS -------------------------------------------------------------------------------
	public static final RegistryObject<Item> RUST_SPAWN_EGG = registerItem("rust_spawn_egg", "Rust Slime Spawn egg", () -> new ForgeSpawnEggItem(CelestialEntities.RUST_SLIME,0x7f3414, 0x984521, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_SPAWN_EGG = registerItem("lunar_spawn_egg", "Lunar Slime Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.LUNAR_SLIME,0xd5d5d5, 0xfafafa, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> MARS_MALLOW_SPAWN_EGG = registerItem("mars_mallow_spawn_egg", "Mars Mallow Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.MARS_MALLOW, 0xfaf5ee, 0xcda568, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> QUICKSILVER_SPAWN_EGG = registerItem("quicksilver_spawn_egg", "Quicksilver Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.QUICKSILVER_SLIME,0xb4b4b4, 0xc8abab, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VISCOUS_SPAWN_EGG = registerItem("viscous_spawn_egg", "Viscous Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VISCOUS_SLIME,0x525964, 0xb4b4b4, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LURKER_SPAWN_EGG = registerItem("lurker_spawn_egg", "Lurker Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.LURKER,0x00a100, 0xffffff, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDFELLOW_SPAWN_EGG = registerItem("voidfellow_spawn_egg", "Space Fellow Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VOIDFELLOW,0x1d1024, 0x0b4647, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_SPAWN_EGG = registerItem("voided_spawn_egg", "Voided Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VOIDED,0x413245, 0x3c2d42, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> SULFUR_CUBE_SPAWN_EGG = registerItem("sulfur_cube_spawn_egg", "Sulfur Cube Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.SULFUR_CUBE,0x794d00, 0x3e77ff, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_PIGLIN_SPAWN_EGG = registerItem("voided_piglin_spawn_egg", "Voided Piglin Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VOIDED_PIGLIN,0xe9a3bb, 0x583b5e, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ASTRAL_PIGLIN_SPAWN_EGG = registerItem("astral_piglin_spawn_egg", "Astral Piglin Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.ASTRAL_PIGLIN,0xd09392, 0xb06661, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> CYBORG_PIGLIN_SPAWN_EGG = registerItem("cyborg_piglin_spawn_egg", "Cyborg Piglin Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.CYBORG_PIGLIN,0xda927c, 0xb4b4c1, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> FLARE_SPAWN_EGG = registerItem("flare_spawn_egg", "Flare Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.FLARE,0x24335b, 0xf1c350, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GYST_SPAWN_EGG = registerItem("gyst_spawn_egg", "Gyst Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.GYST,0, 0x3c2d62, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOIDED_ZOGLIN_SPAWN_EGG = registerItem("voided_zoglin_spawn_egg", "Voided Zoglin Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VOIDED_ZOGLIN,0x583b5e, 0xe9a3bb, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ASTRAL_HOGLIN_SPAWN_EGG = registerItem("astral_hoglin_spawn_egg", "Astral Hoglin Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.ASTRAL_HOGLIN,0xb06661, 0xd09392, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> METEOR_CRAWLER_SPAWN_EGG = registerItem("meteor_crawler_spawn_egg", "Meteor Crawler Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.METEOR_CRAWLER,0x3f3430, 0x211713, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> VOID_CRAWLER_SPAWN_EGG = registerItem("void_crawler_spawn_egg", "Void Crawler Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.VOID_CRAWLER,0x17405f, 0x0e2746, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> CELESTIAL_CAT_SPAWN_EGG = registerItem("celestial_cat_spawn_egg", "Celestial Cat Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.CELESTIAL_CAT,0x6C543E, 0xC3A676, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> EUREKA_SPAWN_EGG = registerItem("eureka_spawn_egg", "Eureka! Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.EUREKA,0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GUST_SPAWN_EGG = registerItem("gust_spawn_egg", "Gust Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.GUST,0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> DRONE_SPAWN_EGG = registerItem("drone_spawn_egg", "Drone Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.DRONE,0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ROVER_SPAWN_EGG = registerItem("rover_spawn_egg", "Rover Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.ROVER,0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> WILD_MECHADOG_SPAWN_EGG = registerItem("wild_mechadog_spawn_egg", "Wild MechaDog Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.MECHADOG, 0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> COBBLESAURUS_SPAWN_EGG = registerItem("cobblesaurus_spawn_egg", "Cobblesaurus Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.COBBLESAURUS, 0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ORBITER_SPAWN_EGG = registerItem("orbiter_spawn_egg", "Orbiter Spawn Egg", () -> new ForgeSpawnEggItem(CelestialEntities.ORBITER, 0x0b6f3f, 0x1d8c56, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));

 	public static final RegistryObject<Item> WHITE_MECHADOG = registerItem("white_mechadog", "White MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.WHITE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GREY_MECHADOG = registerItem("grey_mechadog", "Grey MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.GREY, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_MECHADOG = registerItem("light_grey_mechadog", "Light Grey MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.LIGHT_GREY, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BLACK_MECHADOG = registerItem("black_mechadog", "Black MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.BLACK, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> PURPLE_MECHADOG = registerItem("purple_mechadog", "Purple MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.PURPLE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BLUE_MECHADOG = registerItem("blue_mechadog", "Blue MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.BLUE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_MECHADOG = registerItem("light_blue_mechadog", "Light Blue MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.LIGHT_BLUE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> CYAN_MECHADOG = registerItem("cyan_mechadog", "Cyan MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.CYAN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GREEN_MECHADOG = registerItem("green_mechadog", "Green MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.GREEN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIME_MECHADOG = registerItem("lime_mechadog", "Lime MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.LIME, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> YELLOW_MECHADOG = registerItem("yellow_mechadog", "Yellow MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.YELLOW, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ORANGE_MECHADOG = registerItem("orange_mechadog", "Orange MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.ORANGE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> RED_MECHADOG = registerItem("red_mechadog", "Red MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.RED, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BROWN_MECHADOG = registerItem("brown_mechadog", "Brown MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.BROWN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> MAGENTA_MECHADOG = registerItem("magenta_mechadog", "Magenta MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.MAGENTA, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> PINK_MECHADOG = registerItem("pink_mechadog", "Pink MechaDog", () -> new AutoTameSpawnItem(CelestialEntities.MECHADOG, DyeType.PINK, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> WHITE_MECHACERBERUS = registerItem("white_mechacerberus", "White MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.WHITE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GREY_MECHACERBERUS = registerItem("grey_mechacerberus", "Grey MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.GREY, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIGHT_GREY_MECHACERBERUS = registerItem("light_grey_mechacerberus", "Light Grey MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.LIGHT_GREY, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BLACK_MECHACERBERUS = registerItem("black_mechacerberus", "Black MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.BLACK, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> PURPLE_MECHACERBERUS = registerItem("purple_mechacerberus", "Purple MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.PURPLE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BLUE_MECHACERBERUS = registerItem("blue_mechacerberus", "Blue MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.BLUE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIGHT_BLUE_MECHACERBERUS = registerItem("light_blue_mechacerberus", "Light Blue MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.LIGHT_BLUE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> CYAN_MECHACERBERUS = registerItem("cyan_mechacerberus", "Cyan MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.CYAN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GREEN_MECHACERBERUS = registerItem("green_mechacerberus", "Green MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.GREEN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LIME_MECHACERBERUS = registerItem("lime_mechacerberus", "Lime MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.LIME, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> YELLOW_MECHACERBERUS = registerItem("yellow_mechacerberus", "Yellow MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.YELLOW, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> ORANGE_MECHACERBERUS = registerItem("orange_mechacerberus", "Orange MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.ORANGE, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> RED_MECHACERBERUS = registerItem("red_mechacerberus", "Red MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.RED, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> BROWN_MECHACERBERUS = registerItem("brown_mechacerberus", "Brown MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.BROWN, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> MAGENTA_MECHACERBERUS = registerItem("magenta_mechacerberus", "Magenta MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.MAGENTA, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> PINK_MECHACERBERUS = registerItem("pink_mechacerberus", "Pink MechaCerberus", () -> new AutoTameSpawnItem(CelestialEntities.MECHACERBERUS, DyeType.PINK, new Item.Properties().tab(CelestialTabs.CELESTIAL_MISC_TAB)));


	//---- MOB HEADS -------------------------------------------------------------------------------

	public static final RegistryObject<Item> LURKER_HEAD = ITEMS.register("lurker_head", () -> new StandingAndWallBlockItem(CelestialBlocks.LURKER_HEAD.get(), CelestialBlocks.LURKER_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> VOIDED_HEAD = ITEMS.register("voided_head", () -> new StandingAndWallBlockItem(CelestialBlocks.VOIDED_HEAD.get(), CelestialBlocks.VOIDED_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));
//	public static final RegistryObject<Item> MECHADOG_HEAD = ITEMS.register("mechadog_head", () -> new StandingAndWallBlockItem(BlockRegistry.MECHADOG_HEAD.get(), BlockRegistry.MECHADOG_WALL_HEAD.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_DECORATIONS).rarity(Rarity.UNCOMMON)));

	//---- MISC ITEMS -------------------------------------------------------------------------------
	public static final RegistryObject<Item> RUSTED_IRON_NUGGET = registerItem("rusted_iron_nugget", "Rusted Iron Nugget", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> LUNAR_GOO = registerItem("lunar_goo", "Lunar Goo", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> STEEL_INGOT = registerItem("steel_ingot", "Steel Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_NUGGET = registerItem("steel_nugget", "Steel Nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_BAUXITE = registerItem("raw_bauxite", "Raw Bauxite", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> BAUXITE_INGOT = registerItem("bauxite_ingot", "Bauxite Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = registerItem("aluminum_ingot", "Aluminum Ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> MOON_DUST = registerItem("moon_dust", "Lunar Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> EUROPA_DUST = registerItem("europa_dust", "Europan Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> CALLISTO_DUST = registerItem("callisto_dust", "Callistoan Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> IO_DUST = registerItem("io_dust", "Ionian Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));
	public static final RegistryObject<Item> GANYMEDE_DUST = registerItem("ganymede_dust", "Ganymedian Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> WHITE_MOON_DUST = registerItem("white_moon_dust", "White Lunar Dust", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));

	public static final RegistryObject<Item> STEEL_ROD = registerItem("steel_rod", "Steel Rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> FLARE_ROD = registerItem("flare_rod", "Flare Rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_WOOL = registerItem("steel_wool", "Steel Wool", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> SULFUR_CRYSTAL = registerItem("sulfur_crystal", "Sulfur Crystal", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> CINNABAR = registerItem("cinnabar", "Cinnabar", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));

	public static final RegistryObject<Item> MECHACERBERUS_CORE = registerItem("mechacerberus_core", "MechaCerberus Core", () -> new Item((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB)));


	public static final RegistryObject<Item> EUREKA_BUCKET = registerItem("eureka_bucket", "Eureka! Bucket", () -> new MobBucketItem(CelestialEntities.EUREKA, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> FLUID_BASIN = registerItem("fluid_basin", "Fluid Basin", () -> new BasinItem((new Item.Properties()).stacksTo(1).tab(CelestialTabs.SPACESHIP_TAB)));

	public static final RegistryObject<Item> TEST_ITEM = registerItem("test_item", "Test Item", () -> new TestItem((new Item.Properties())));


//	public static final RegistryObject<Item> RED_DISPLAY_BOARD = ITEMS.register("red_display_board", () -> new DisplayBoardItem((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB), BlockRegistry.RED_DISPLAY_BOARD.get(), BlockRegistry.RED_WALL_DISPLAY_BOARD.get()));
//	public static final RegistryObject<Item> BLACK_DISPLAY_BOARD = ITEMS.register("black_display_board", () -> new DisplayBoardItem((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB), BlockRegistry.BLACK_DISPLAY_BOARD.get(), BlockRegistry.BLACK_WALL_DISPLAY_BOARD.get()));
//	public static final RegistryObject<Item> BLUE_DISPLAY_BOARD = ITEMS.register("blue_display_board", () -> new DisplayBoardItem((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB), BlockRegistry.BLUE_DISPLAY_BOARD.get(), BlockRegistry.BLUE_WALL_DISPLAY_BOARD.get()));
//	public static final RegistryObject<Item> WHITE_DISPLAY_BOARD = ITEMS.register("white_display_board", () -> new DisplayBoardItem((new Item.Properties()).tab(CelestialTabs.CELESTIAL_MISC_TAB), BlockRegistry.WHITE_DISPLAY_BOARD.get(), BlockRegistry.WHITE_WALL_DISPLAY_BOARD.get()));


//	public static final RegistryObject<Item> CONTROL_PANEL = registerItem("control_panel", "Control Panel", () -> new ControlPanelItem(new Item.Properties().tab(CelestialTabs.SPACESHIP_TAB)));

	//---- FOOD -------------------------------------------------------------------------------
	public static final RegistryObject<Item> MARSHMALLOW_GOO = registerFood("marshmallow_goo", "Marshmallow Goo", 1, 0.1F);
	public static final RegistryObject<Item> MARSHMALLOW = registerFood("marshmallow", "Marshmallow", 1, 0.2F);
	public static final RegistryObject<Item> ROASTED_MARSHMALLOW = registerFood("roasted_marshmallow", "Roasted Marshmallow", 1, 0.2F);
	public static final RegistryObject<Item> CHOCOLATE = registerFood("chocolate", "Chocolate", 1, 0.4F);
	public static final RegistryObject<Item> CRACKER = registerFood("cracker", "Cracker", 1, 0.2F);
	public static final RegistryObject<Item> SMORES = registerFood("smores", "S'mores", 1, 0.3F);
	public static final RegistryObject<Item> LUNAR_CHEESE = registerFood("lunar_cheese", "Lunar Cheese", 5, 0.65F);
	public static final RegistryObject<Item> CHEESE = registerFood("cheese", "Cheese", 5, 0.65F);
	public static final RegistryObject<Item> SUSPICIOUS_JELLO = registerItem("suspicious_jello", "Suspicious Jello", () -> new SuspiciousJelloItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food((new FoodProperties.Builder()).fast().nutrition(1).saturationMod(.2F).alwaysEat().build())));
}