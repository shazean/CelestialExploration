package mod.shim.celestialexploration.registry;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.blocks.BlockItemBase;
import mod.shim.celestialexploration.items.ItemBase;
import mod.shim.celestialexploration.items.ModSpawnEgg;
import mod.shim.celestialexploration.items.SpaceSuitArmor;
import mod.shim.celestialexploration.tools.ModArmorMaterial;
import mod.shim.celestialexploration.tools.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryItems {


	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
	
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
   
	public static final RegistryObject<ModSpawnEgg> ROVER_SPAWN_EGG = ITEMS.register("rover_spawn_egg", () -> 
		new ModSpawnEgg(RegistryEntities.ROVER, 0x000000, 0xffffff, new Item.Properties().tab(Main.CELESTIAL_TAB)));
	
	
	
	//Items
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ItemBase::new);
	public static final RegistryObject<Item> MOON_DUST = ITEMS.register("moon_dust", ItemBase::new);
	public static final RegistryObject<Item> LIQUID_OXYGEN = ITEMS.register("liquid_oxygen",  ItemBase::new);
	public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", ItemBase::new);
	 public static final RegistryObject<Item> SULFUR_BUCKET = ITEMS.register("sulfur_bucket", () -> new BucketItem(RegistryFluids.SULFUR, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC)));

	public static final RegistryObject<Item> OXYGEN_CANNISTER = ITEMS.register("oxygen_cannister", ItemBase::new);
	public static final RegistryObject<Item> COLD_OXYGEN_CANNISTER = ITEMS.register("cold_oxygen_cannister", ItemBase::new);

	 
	
	//Block Items
	//MOON
	public static final RegistryObject<Item> MOON_STONE = ITEMS.register("moon_stone", () -> new BlockItemBase(RegistryBlocks.MOON_STONE.get()));
	public static final RegistryObject<Item> MOON_SAND = ITEMS.register("moon_sand", () -> new BlockItemBase(RegistryBlocks.MOON_SAND.get()));
	public static final RegistryObject<Item> GLOWING_MOON_SAND = ITEMS.register("glowing_moon_sand", () -> new BlockItemBase(RegistryBlocks.GLOWING_MOON_SAND.get()));
	public static final RegistryObject<Item> MOON_BRICK = ITEMS.register("moon_brick", () -> new BlockItemBase(RegistryBlocks.MOON_BRICK.get()));
	public static final RegistryObject<Item> MOON_IRON_ORE = ITEMS.register("moon_iron_ore", () -> new BlockItemBase(RegistryBlocks.MOON_IRON_ORE.get()));
	public static final RegistryObject<Item> MOON_REDSTONE = ITEMS.register("moon_redstone_ore", () -> new BlockItemBase(RegistryBlocks.MOON_REDSTONE_ORE.get()));

	public static final RegistryObject<Item> LUNAR_LANTERN = ITEMS.register("lunar_lantern", () -> new BlockItemBase(RegistryBlocks.LUNAR_LANTERN.get()));
	
	public static final RegistryObject<Item> CHISELED_MOON_BRICK = ITEMS.register("chiseled_moon_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_MOON_BRICK.get()));
	public static final RegistryObject<Item> MOON_BRICK_STAIRS = ITEMS.register("moon_brick_stairs", () -> new BlockItemBase(RegistryBlocks.MOON_BRICK_STAIRS.get()));
	public static final RegistryObject<Item> MOON_BRICK_SLAB = ITEMS.register("moon_brick_slab", () -> new BlockItemBase(RegistryBlocks.MOON_BRICK_SLAB.get()));

	
	//METEOR
	public static final RegistryObject<Item> METEOR = ITEMS.register("meteor", () -> new BlockItemBase(RegistryBlocks.METEOR.get()));
	public static final RegistryObject<Item> METEOR_EMERALD_ORE = ITEMS.register("meteor_emerald_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_EMERALD_ORE.get()));
	public static final RegistryObject<Item> METEOR_COAL_ORE = ITEMS.register("meteor_coal_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_COAL_ORE.get()));
	public static final RegistryObject<Item> METEOR_GOLD_ORE = ITEMS.register("meteor_gold_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_GOLD_ORE.get()));
	public static final RegistryObject<Item> METEOR_IRON_ORE = ITEMS.register("meteor_iron_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_IRON_ORE.get()));
	public static final RegistryObject<Item> METEOR_REDSTONE_ORE = ITEMS.register("meteor_redstone_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_REDSTONE_ORE.get()));
	public static final RegistryObject<Item> METEOR_DIAMOND_ORE = ITEMS.register("meteor_diamond_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_DIAMOND_ORE.get()));
	public static final RegistryObject<Item> METEOR_LAPIS_ORE = ITEMS.register("meteor_lapis_ore", () -> new BlockItemBase(RegistryBlocks.METEOR_LAPIS_ORE.get()));
	public static final RegistryObject<Item> METEOR_BRICK = ITEMS.register("meteor_brick", () -> new BlockItemBase(RegistryBlocks.METEOR_BRICK.get()));
	public static final RegistryObject<Item> CHISELED_METEOR_BRICK = ITEMS.register("chiseled_meteor_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_METEOR_BRICK.get()));
	public static final RegistryObject<Item> METEOR_BRICK_STAIRS = ITEMS.register("meteor_brick_stairs", () -> new BlockItemBase(RegistryBlocks.METEOR_BRICK_STAIRS.get()));
	public static final RegistryObject<Item> METEOR_BRICK_SLAB = ITEMS.register("meteor_brick_slab", () -> new BlockItemBase(RegistryBlocks.METEOR_BRICK_SLAB.get()));

	
	  
	
	
	//MARS
	public static final RegistryObject<Item> MARS_STONE = ITEMS.register("mars_stone", () -> new BlockItemBase(RegistryBlocks.MARS_STONE.get()));	
	public static final RegistryObject<Item> MARS_SAND = ITEMS.register("mars_sand", () -> new BlockItemBase(RegistryBlocks.MARS_SAND.get()));
	public static final RegistryObject<Item> MARS_BRICK = ITEMS.register("mars_brick", () -> new BlockItemBase(RegistryBlocks.MARS_BRICK.get()));
	public static final RegistryObject<Item> MARS_IRON_ORE = ITEMS.register("mars_iron_ore", () -> new BlockItemBase(RegistryBlocks.MARS_IRON_ORE.get()));
	public static final RegistryObject<Item> MARS_REDSTONE_ORE = ITEMS.register("mars_redstone_ore", () -> new BlockItemBase(RegistryBlocks.MARS_REDSTONE_ORE.get()));
	public static final RegistryObject<Item> CHISELED_MARS_BRICK = ITEMS.register("chiseled_mars_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_MARS_BRICK.get()));
	public static final RegistryObject<Item> MARS_BRICK_STAIRS = ITEMS.register("mars_brick_stairs", () -> new BlockItemBase(RegistryBlocks.MARS_BRICK_STAIRS.get()));
	public static final RegistryObject<Item> MARS_BRICK_SLAB = ITEMS.register("mars_brick_slab", () -> new BlockItemBase(RegistryBlocks.MARS_BRICK_SLAB.get()));

	
	//VENUS
	public static final RegistryObject<Item> VENUS_STONE = ITEMS.register("venus_stone", () -> new BlockItemBase(RegistryBlocks.VENUS_STONE.get()));	
	public static final RegistryObject<Item> VENUS_SAND = ITEMS.register("venus_sand", () -> new BlockItemBase(RegistryBlocks.VENUS_SAND.get()));
	public static final RegistryObject<Item> VENUS_BRICK = ITEMS.register("venus_brick", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK.get()));
	public static final RegistryObject<Item> VENUS_IRON_ORE = ITEMS.register("venus_iron_ore", () -> new BlockItemBase(RegistryBlocks.VENUS_IRON_ORE.get()));
	public static final RegistryObject<Item> VENUS_REDSTONE_ORE = ITEMS.register("venus_redstone_ore", () -> new BlockItemBase(RegistryBlocks.VENUS_REDSTONE_ORE.get()));
	public static final RegistryObject<Item> CHISELED_VENUS_BRICK = ITEMS.register("chiseled_venus_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_VENUS_BRICK.get()));
	public static final RegistryObject<Item> VENUS_BRICK_STAIRS = ITEMS.register("venus_brick_stairs", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK_STAIRS.get()));
	public static final RegistryObject<Item> VENUS_BRICK_SLAB = ITEMS.register("venus_brick_slab", () -> new BlockItemBase(RegistryBlocks.VENUS_BRICK_SLAB.get()));

	
	//MERCURY
	public static final RegistryObject<Item> MERCURY_STONE = ITEMS.register("mercury_stone", () -> new BlockItemBase(RegistryBlocks.MERCURY_STONE.get()));	
	public static final RegistryObject<Item> MERCURY_SAND = ITEMS.register("mercury_sand", () -> new BlockItemBase(RegistryBlocks.MERCURY_SAND.get()));
	public static final RegistryObject<Item> MERCURY_BRICK = ITEMS.register("mercury_brick", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK.get()));
	public static final RegistryObject<Item> MERCURY_IRON = ITEMS.register("mercury_iron_ore", () -> new BlockItemBase(RegistryBlocks.MERCURY_IRON_ORE.get()));
	public static final RegistryObject<Item> MERCURY_REDSTONE = ITEMS.register("mercury_redstone_ore", () -> new BlockItemBase(RegistryBlocks.MERCURY_REDSTONE_ORE.get()));
	public static final RegistryObject<Item> CHISELED_MERCURY_BRICK = ITEMS.register("chiseled_mercury_brick", () -> new BlockItemBase(RegistryBlocks.CHISELED_MERCURY_BRICK.get()));
	public static final RegistryObject<Item> MERCURY_BRICK_STAIRS = ITEMS.register("mercury_brick_stairs", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK_STAIRS.get()));
	public static final RegistryObject<Item> MERCURY_BRICK_SLAB = ITEMS.register("mercury_brick_slab", () -> new BlockItemBase(RegistryBlocks.MERCURY_BRICK_SLAB.get()));

	
	
	//OTHER BLOCK ITEMS
	public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register("steel_block",  () -> new BlockItemBase(RegistryBlocks.STEEL_BLOCK.get()));
	public static final RegistryObject<Item> DRY_ICE = ITEMS.register("dry_ice", () -> new BlockItemBase(RegistryBlocks.DRY_ICE.get()));
//	public static final RegistryObject<Item> OXYGEN_COMPRESSOR = ITEMS.register("oxygen_compressor",  () -> new BlockItemBase(RegistryBlocks.OXYGEN_COMPRESSOR.get()));
	public static final RegistryObject<Item> ASSEMBLY_STATION = ITEMS.register("assembly_station",  () -> new BlockItemBase(RegistryBlocks.ASSEMBLY_STATION.get()));
	public static final RegistryObject<Item> SOLAR_PANEL = ITEMS.register("solar_panel",  () -> new BlockItemBase(RegistryBlocks.SOLAR_PANEL.get()));


		
	
	public static final RegistryObject<Item> CERAMIC = ITEMS.register("ceramic",  () -> new BlockItemBase(RegistryBlocks.CERAMIC.get()));	
	public static final RegistryObject<Item> CERAMIC_TILE = ITEMS.register("ceramic_tile",  () -> new BlockItemBase(RegistryBlocks.CERAMIC_TILE.get()));
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_FRAME = ITEMS.register("steel_frame",  () -> new BlockItemBase(RegistryBlocks.STEEL_FRAME.get()));
	public static final RegistryObject<Item> LAUNCH_PAD = ITEMS.register("launch_pad",  () -> new BlockItemBase(RegistryBlocks.LAUNCH_PAD.get()));
	public static final RegistryObject<Item> ROCKET_CABIN = ITEMS.register("rocket_cabin", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
	public static final RegistryObject<Item> ROCKET_FRAME = ITEMS.register("rocket_frame", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
	public static final RegistryObject<Item> ROCKET_ENGINE = ITEMS.register("rocket_engine", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
	public static final RegistryObject<Item> NOSE_CONE = ITEMS.register("nose_cone", () -> new Item((new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));
	public static final RegistryObject<Item> FUEL_TANK = ITEMS.register("fuel_tank",  () -> new BlockItemBase(RegistryBlocks.FUEL_TANK.get()));	

	public static final RegistryObject<Item> THICK_CARBON_AIR = ITEMS.register("thick_carbon_air",  () -> new BlockItemBase(RegistryBlocks.THICK_CARBON_AIR.get()));	
	
	public static final RegistryObject<Item> GASEOUS_CARBON = ITEMS.register("gaseous_carbon", () -> new Item((new Item.Properties()).tab(Main.CELESTIAL_TAB)));

	
	
	
//	public static final RegistryObject<Item> SPRUCE_SHUTTLE = ITEMS.register("spruce_shuttle", () -> new ShuttleItem(ShuttleEntity.Type.SPRUCE, (new Item.Properties()).stacksTo(1).tab(Main.SHUTTLE_TAB)));

//	   public static final Item SPRUCE_BOAT = registerItem("spruce_boat", new BoatItem(BoatEntity.Type.SPRUCE, (new Item.Properties()).stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));

	
	
	//Tools
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(ModItemTier.STEEL, /*attackDamage*/ 5, /*attackSpeed*/ -2.4F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(ModItemTier.STEEL, 8, -3.1F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModItemTier.STEEL, 3, -2.8F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(ModItemTier.STEEL, 3, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(ModItemTier.STEEL, 0, 0, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

	//Armor
	public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	
	public static final RegistryObject<ArmorItem> SPACE_SUIT_HELMET = ITEMS.register("space_suit_helmet", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_BOOTS = ITEMS.register("space_suit_boots", () -> new SpaceSuitArmor(ArmorMaterial.LEATHER, EquipmentSlotType.FEET, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_CHESTPLATE = ITEMS.register("space_suit_chestplate", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<ArmorItem> SPACE_SUIT_LEGGINGS = ITEMS.register("space_suit_leggings", () -> new ArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.LEGS, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));

	
	
	  
	
}
