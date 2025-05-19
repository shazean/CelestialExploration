package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.datagen.util.BaseLootTableProvider;
import com.shim.celestialexploration.registry.BlockRegistry;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {

		for (RegistryObject<? extends Block> block : BlockRegistry.BLOCKS_LOOT_TABLE) block(block.get(), createSimpleTable(block.get()));

		//---- ENTITIES -------------------------------------------------------------------------------
		entity(EntityRegistry.FLARE.get(), createEntitySingleDropTable(ItemRegistry.FLARE_ROD.get(), 0.0F, 1.0F, true));
		entity(EntityRegistry.LUNAR_SLIME.get(), createEntitySingleDropTable(ItemRegistry.LUNAR_GOO.get(), 0.0F, 2.0F, false));
		entity(EntityRegistry.MARS_MALLOW.get(), createEntitySingleDropTable(ItemRegistry.MARSHMALLOW_GOO.get(), 0.0F, 2.0F, false));
		entity(EntityRegistry.RUST_SLIME.get(), createEntitySingleDropTable(ItemRegistry.RUSTED_IRON_NUGGET.get(), 0.0F, 2.0F, false));
		entity(EntityRegistry.SULFUR_CUBE.get(), createEntitySingleDropTable(Items.LAPIS_LAZULI, -2.0F, 1.0F, false));
		entity(EntityRegistry.VISCOUS_SLIME.get(), createEntitySingleDropTable(ItemRegistry.CINNABAR.get(), 0.0F, 2.0F, false));
		entity(EntityRegistry.QUICKSILVER_SLIME.get(), createEntitySingleDropTable(ItemRegistry.CINNABAR.get(), 0.0F, 2.0F, false));

		entity(EntityRegistry.VOIDED.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 2.0F, false)
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(Items.IRON_INGOT))
						.add(LootItem.lootTableItem(Items.CARROT))
						.add(LootItem.lootTableItem(Items.POTATO)
								.apply(SmeltItemFunction.smelted()
										.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.LURKER.get(), createEntitySingleDropTable(Items.GUNPOWDER, 0.0F, 2.0F, false)
				.withPool(LootPool.lootPool()
						.add(TagEntry.expandTag(ItemTags.CREEPER_DROP_MUSIC_DISCS))
						.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.entity().of(EntityTypeTags.SKELETONS)))));

		entity(EntityRegistry.VOIDED_PIGLIN.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 1.0F, false)
				.withPool(createEntitySingleDropPool(Items.GOLD_NUGGET, 0.0F, 1.0F, false))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.GOLD_INGOT))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.VOIDED_ZOGLIN.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 1.0F, false));
		entity(EntityRegistry.FLARE.get(), createEntitySingleDropTable(ItemRegistry.FLARE_ROD.get(), 0.0F, 1.0F, true));

		entity(EntityRegistry.CELESTIAL_CAT.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.STRING)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(ItemRegistry.BASIC_SPACESUIT_HELMET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.VOID_CRAWLER.get(), createEntitySingleDropTable(Items.STRING, 0.0F, 2.0F, false)
				.withPool(createEntitySingleDropPool(Items.SPIDER_EYE, -1.0F, 1.0F, true)));

		entity(EntityRegistry.ORBITER.get(), createEntitySingleDropTable(Items.GHAST_TEAR, 0.0F, 1.0F, false)
				.withPool(createEntitySingleDropPool(Items.GUNPOWDER, 0.0F, 2.0F, false)));


		entity(EntityRegistry.METEOR_CRAWLER.get(), createEntitySingleDropTable(Items.STRING, 0.0F, 2.0F, false)
				.withPool(createEntitySingleDropPool(Items.SPIDER_EYE, -1.0F, 1.0F, true))
				.withPool(createEntitySingleDropPool(Items.IRON_NUGGET, -1.0F, 1.0F, true))
				.withPool(createEntitySingleDropPool(Items.GOLD_NUGGET, -1.0F, 1.0F, true)));


		entity(EntityRegistry.ASTRAL_HOGLIN.get(), createEntitySingleDropTable(Items.LEATHER, 0.0F, 1.0F, false)
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.PORKCHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
								.apply(SmeltItemFunction.smelted()
										.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
								.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		entity(EntityRegistry.ASTRAL_PIGLIN.get(), LootTable.lootTable());

		entity(EntityRegistry.CYBORG_PIGLIN.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(ItemRegistry.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.DRONE.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.REDSTONE))
						.add(LootItem.lootTableItem(ItemRegistry.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.VOIDFELLOW.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.ENDER_PEARL)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
								.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));


		entity(EntityRegistry.ROVER.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.REDSTONE))
						.add(LootItem.lootTableItem(ItemRegistry.RUSTED_IRON_NUGGET.get()))
						.add(LootItem.lootTableItem(Items.IRON_NUGGET))
						.add(LootItem.lootTableItem(ItemRegistry.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.COBBLESAURUS.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(BlockRegistry.MARS_COBBLESTONE.get()))
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(EntityRegistry.GUST.get(), createEntitySingleDropTable(Items.GUNPOWDER, 0.0F, 2.0F, false));

		entity(EntityRegistry.MECHADOG.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantValue.exactly(1.0F))
					.add(LootItem.lootTableItem(Items.REDSTONE)))
//					.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.8F, 0.01F)))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(BlockRegistry.MECHADOG_HEAD.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F)))
//				.withPool(LootPool.lootPool()
//						.setRolls(ConstantValue.exactly(1.0F))
//						.add(LootItem.lootTableItem(ItemRegistry.MECHADOG_CORE.get()))
//						.when(LootItemKilledByPlayerCondition.killedByPlayer())
//						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.010F, 0.01F)))
		);

		entity(EntityRegistry.MECHACERBERUS_BOSS.get(), LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(ItemRegistry.MECHADOG_CORE.get()))
//								.when(LootItemKilledByPlayerCondition.killedByPlayer())
						));

		//---- BLOCKS -------------------------------------------------------------------------------
		//---- MOON -------------------------------------------------------------------------------
		//STONE
		block(BlockRegistry.MOON_STONE.get(), createSilkTouchTable(BlockRegistry.MOON_STONE.get(), BlockRegistry.MOON_COBBLESTONE.get(), 1, 1));

		block(BlockRegistry.MOON_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_STONE_SLAB.get()));
		block(BlockRegistry.MOON_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_COBBLESTONE_SLAB.get()));
		block(BlockRegistry.MOON_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_BRICK_SLAB.get()));
		block(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(BlockRegistry.MOON_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MOON_DEEPSLATE.get(), BlockRegistry.MOON_COBBLED_DEEPSLATE.get(), 1, 1));

		block(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MOON_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(BlockRegistry.MOON_IRON_ORE.get(), createIronOreTable(BlockRegistry.MOON_IRON_ORE.get()));
		block(BlockRegistry.MOON_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MOON_REDSTONE_ORE.get()));
		block(BlockRegistry.MOON_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MOON_BAUXITE_ORE.get()));
		block(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MOON_DEEPSLATE_IRON_ORE.get()));
		block(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MOON_DEEPSLATE_REDSTONE_ORE.get()));

		block(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CHISELED_MOON_DEEPSLATE_BRICKS.get()));
		block(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CRACKED_MOON_DEEPSLATE_BRICKS.get()));

		//OTHER
    	block(BlockRegistry.GLOWING_MOON_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_MOON_SAND.get(), ItemRegistry.MOON_DUST.get(), 2, 5));
		block(BlockRegistry.LUNAR_LANTERN.get(), createSilkTouchTable(BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.MOON_DUST.get(), 1, 3));

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		block(BlockRegistry.MARS_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_STONE_SLAB.get()));
		block(BlockRegistry.MARS_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_COBBLESTONE_SLAB.get()));
		block(BlockRegistry.MARS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_BRICK_SLAB.get()));
		block(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(BlockRegistry.MARS_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MARS_DEEPSLATE.get(), BlockRegistry.MARS_COBBLED_DEEPSLATE.get(), 1, 1));

		block(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MARS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(BlockRegistry.MARS_IRON_ORE.get(), createIronOreTable(BlockRegistry.MARS_IRON_ORE.get()));
		block(BlockRegistry.MARS_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MARS_REDSTONE_ORE.get()));
		block(BlockRegistry.MARS_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MARS_BAUXITE_ORE.get()));
		block(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MARS_DEEPSLATE_IRON_ORE.get()));
		block(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get(), createIronOreTable(BlockRegistry.MARS_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		block(BlockRegistry.MARS_LANTERN.get(), createSilkTouchTable(BlockRegistry.MARS_LANTERN.get(), ItemRegistry.RUSTED_IRON_NUGGET.get(), 1, 3));

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		block(BlockRegistry.VENUS_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_STONE_SLAB.get()));
		block(BlockRegistry.VENUS_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_COBBLESTONE_SLAB.get()));
		block(BlockRegistry.VENUS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_BRICK_SLAB.get()));
		block(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.SMALL_VENUS_BRICK_SLAB.get()));
		block(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(BlockRegistry.VENUS_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.VENUS_DEEPSLATE.get(), BlockRegistry.VENUS_COBBLED_DEEPSLATE.get(), 1, 1));

		block(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.VENUS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(BlockRegistry.VENUS_IRON_ORE.get(), createIronOreTable(BlockRegistry.VENUS_IRON_ORE.get()));
		block(BlockRegistry.VENUS_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.VENUS_REDSTONE_ORE.get()));
		block(BlockRegistry.VENUS_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.VENUS_BAUXITE_ORE.get()));
		block(BlockRegistry.VENUS_LAPIS_ORE.get(), createOreTable(BlockRegistry.VENUS_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		block(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.VENUS_DEEPSLATE_IRON_ORE.get()));
		block(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.VENUS_DEEPSLATE_REDSTONE_ORE.get()));
		block(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), createOreTable(BlockRegistry.VENUS_DEEPSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		//OTHER
		block(BlockRegistry.VENUS_LANTERN.get(), createSilkTouchTable(BlockRegistry.VENUS_LANTERN.get(), ItemRegistry.SULFUR_CRYSTAL.get(), 1, 3));

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
    	block(BlockRegistry.METEOR_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.METEOR_BRICK_SLAB.get()));

		//METEOR ORE
		block(BlockRegistry.METEOR_COAL_ORE.get(), createCoalOreTable(BlockRegistry.METEOR_COAL_ORE.get()));
		block(BlockRegistry.METEOR_COPPER_ORE.get(), createCopperOreTable(BlockRegistry.METEOR_COPPER_ORE.get()));
		block(BlockRegistry.METEOR_DIAMOND_ORE.get(), createOreTable(BlockRegistry.METEOR_DIAMOND_ORE.get(), Items.DIAMOND));
		block(BlockRegistry.METEOR_EMERALD_ORE.get(), createOreTable(BlockRegistry.METEOR_EMERALD_ORE.get(), Items.EMERALD));
		block(BlockRegistry.METEOR_GOLD_ORE.get(), createOreTable(BlockRegistry.METEOR_GOLD_ORE.get(), Items.RAW_GOLD));
		block(BlockRegistry.METEOR_IRON_ORE.get(), createIronOreTable(BlockRegistry.METEOR_IRON_ORE.get()));
		block(BlockRegistry.METEOR_LAPIS_ORE.get(), createOreTable(BlockRegistry.METEOR_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		block(BlockRegistry.METEOR_SULFUR_ORE.get(), createSulfurOreTable(BlockRegistry.METEOR_SULFUR_ORE.get()));
		block(BlockRegistry.METEOR_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.METEOR_REDSTONE_ORE.get()));
		block(BlockRegistry.METEOR_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.METEOR_BAUXITE_ORE.get()));

		//SUN
		block(BlockRegistry.SOLAR_PLASMA.get(), createSimpleTable(BlockRegistry.SOLAR_PLASMA.get()));
		block(BlockRegistry.SUN_SPOT.get(), createSimpleTable(BlockRegistry.SUN_SPOT.get()));
		block(BlockRegistry.SOLAR_FLARE.get(), createSimpleTable(BlockRegistry.SOLAR_FLARE.get()));

		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		block(BlockRegistry.MERCURY_STONE.get(), createSilkTouchTable(BlockRegistry.MERCURY_STONE.get(), BlockRegistry.MERCURY_COBBLESTONE.get(), 1, 1));

		block(BlockRegistry.MERCURY_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_STONE_SLAB.get()));
		block(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_COBBLESTONE_SLAB.get()));
		block(BlockRegistry.MERCURY_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_BRICK_SLAB.get()));
		block(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(BlockRegistry.MERCURY_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.MERCURY_DEEPSLATE.get(), BlockRegistry.MERCURY_COBBLED_DEEPSLATE.get(), 1, 1));
		block(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.MERCURY_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(BlockRegistry.MERCURY_BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.MERCURY_BAUXITE_ORE.get()));
		block(BlockRegistry.MERCURY_SULFUR_ORE.get(), createSulfurOreTable(BlockRegistry.MERCURY_SULFUR_ORE.get()));
		block(BlockRegistry.MERCURY_COAL_ORE.get(), createCoalOreTable(BlockRegistry.MERCURY_COAL_ORE.get()));
		block(BlockRegistry.MERCURY_DIAMOND_ORE.get(), createOreTable(BlockRegistry.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		block(BlockRegistry.MERCURY_DEEPSLATE_DIAMOND_ORE.get(), createOreTable(BlockRegistry.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		block(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.MERCURY_DEEPSLATE_IRON_ORE.get()));
		block(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get(), createCoalOreTable(BlockRegistry.MERCURY_DEEPSLATE_COAL_ORE.get()));
		block(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(BlockRegistry.MERCURY_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		block(BlockRegistry.MERCURY_LANTERN.get(), createSilkTouchTable(BlockRegistry.MERCURY_LANTERN.get(), BlockRegistry.MERCURY_STONE.get(), 1, 1)); //FIXME
		block(BlockRegistry.MERCURY_SAND_PATH.get(), createSimpleTable(BlockRegistry.MERCURY_SAND.get()));

		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		block(BlockRegistry.JUPITER_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.JUPITER_DEEPSLATE.get(), BlockRegistry.JUPITER_COBBLED_DEEPSLATE.get(), 1, 1));

		block(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.JUPITER_DEEPSLATE_TILE_SLAB.get()));

		block(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CHISELED_JUPITER_DEEPSLATE_BRICKS.get()));
		block(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CRACKED_JUPITER_DEEPSLATE_BRICKS.get()));

		//OTHER
		block(BlockRegistry.JUPITER_LANTERN.get(), createSilkTouchTable(BlockRegistry.JUPITER_LANTERN.get(), BlockRegistry.JUPITER_DEEPSLATE.get(), 1, 3)); //FIXME?
		block(BlockRegistry.JUPITER_ATMOSPHERE.get(), createSimpleTable(BlockRegistry.JUPITER_ATMOSPHERE.get()));

		//---- IO -------------------------------------------------------------------------------
		//STONE
		block(BlockRegistry.IO_STONE.get(), createSilkTouchTable(BlockRegistry.IO_STONE.get(), BlockRegistry.IO_COBBLESTONE.get(), 1, 1));

		block(BlockRegistry.IO_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_STONE_SLAB.get()));
		block(BlockRegistry.IO_COBBLESTONE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_COBBLESTONE_SLAB.get()));
		block(BlockRegistry.IO_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.IO_BRICK_SLAB.get()));
		block(BlockRegistry.IO_SMOOTH_STONE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(BlockRegistry.IO_DEEPSLATE.get(), createSilkTouchTable(BlockRegistry.IO_DEEPSLATE.get(), BlockRegistry.IO_COBBLED_DEEPSLATE.get(), 1, 1));

		block(BlockRegistry.IO_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_COBBLED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.IO_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.IO_DEEPSLATE_BRICK_SLAB.get()));
		block(BlockRegistry.IO_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_POLISHED_DEEPSLATE_SLAB.get()));
		block(BlockRegistry.IO_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(BlockRegistry.IO_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(BlockRegistry.IO_SULFUR_ORE.get(), createSulfurOreTable(BlockRegistry.IO_SULFUR_ORE.get()));
		block(BlockRegistry.IO_DEEPSLATE_IRON_ORE.get(), createIronOreTable(BlockRegistry.IO_DEEPSLATE_IRON_ORE.get()));

		block(BlockRegistry.CHISELED_IO_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CHISELED_IO_DEEPSLATE_BRICKS.get()));
		block(BlockRegistry.CRACKED_IO_DEEPSLATE_BRICKS.get(), createSimpleTable(BlockRegistry.CRACKED_IO_DEEPSLATE_BRICKS.get()));

		//OTHER
		block(BlockRegistry.GLOWING_IO_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_IO_SAND.get(), ItemRegistry.IO_DUST.get(), 2, 5));
		block(BlockRegistry.IO_LANTERN.get(), createSilkTouchTable(BlockRegistry.LUNAR_LANTERN.get(), ItemRegistry.IO_DUST.get(), 1, 3));

		//---- EUROPA -------------------------------------------------------------------------------
		block(BlockRegistry.EUROPA_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.EUROPA_BRICK_SLAB.get()));
		block(BlockRegistry.GLOWING_EUROPA_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_EUROPA_SAND.get(), ItemRegistry.EUROPA_DUST.get(), 2, 5));
		block(BlockRegistry.EUROPA_LANTERN.get(), createSilkTouchTable(BlockRegistry.EUROPA_LANTERN.get(), ItemRegistry.EUROPA_DUST.get(), 1, 3));

		//---- CALLISTO -------------------------------------------------------------------------------
		block(BlockRegistry.CALLISTO_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.CALLISTO_BRICK_SLAB.get()));
		block(BlockRegistry.GLOWING_CALLISTO_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_CALLISTO_SAND.get(), ItemRegistry.CALLISTO_DUST.get(), 2, 5));
		block(BlockRegistry.CALLISTO_LANTERN.get(), createSilkTouchTable(BlockRegistry.CALLISTO_LANTERN.get(), ItemRegistry.CALLISTO_DUST.get(), 1, 3));

		//---- GANYMEDE -------------------------------------------------------------------------------
		block(BlockRegistry.GANYMEDE_BRICK_SLAB.get(), createSlabItemTable(BlockRegistry.GANYMEDE_BRICK_SLAB.get()));
		block(BlockRegistry.GLOWING_GANYMEDE_SAND.get(), createSilkTouchTable(BlockRegistry.GLOWING_GANYMEDE_SAND.get(), ItemRegistry.GANYMEDE_DUST.get(), 2, 5));
		block(BlockRegistry.GANYMEDE_LANTERN.get(), createSilkTouchTable(BlockRegistry.GANYMEDE_LANTERN.get(), ItemRegistry.GANYMEDE_DUST.get(), 1, 3));


		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		block(BlockRegistry.BAUXITE_ORE.get(), createBauxiteOreTable(BlockRegistry.BAUXITE_ORE.get()));

		//---- SPACESHIP-RELATED -------------------------------------------------------------------------------
		block(BlockRegistry.STEEL_FRAME.get(), createSimpleTable(BlockRegistry.STEEL_FRAME.get()));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		block(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_BLUE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_WHITE_GLASS.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_CYAN_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_CYAN_GLASS.get(), ItemRegistry.EUROPA_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_MAGENTA_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_MAGENTA_GLASS.get(), ItemRegistry.CALLISTO_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_YELLOW_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_YELLOW_GLASS.get(), ItemRegistry.IO_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_RED_GLASS.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_RED_GLASS.get(), ItemRegistry.GANYMEDE_DUST.get(), 1, 1));

		block(BlockRegistry.LUMINOUS_YELLOW_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_YELLOW_GLASS_PANE.get(), ItemRegistry.IO_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_RED_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_RED_GLASS_PANE.get(), ItemRegistry.GANYMEDE_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_MAGENTA_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_MAGENTA_GLASS_PANE.get(), ItemRegistry.CALLISTO_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_CYAN_GLASS_PANE.get(), ItemRegistry.EUROPA_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_BLUE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));
		block(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), createSilkTouchTable(BlockRegistry.LUMINOUS_WHITE_GLASS_PANE.get(), ItemRegistry.MOON_DUST.get(), 1, 1));

		block(BlockRegistry.REINFORCED_GLASS.get(), createSimpleTable(BlockRegistry.REINFORCED_GLASS.get()));
		block(BlockRegistry.REINFORCED_GLASS_PANE.get(), createSimpleTable(BlockRegistry.REINFORCED_GLASS_PANE.get()));

		//CERAMIC
		block(BlockRegistry.CERAMIC.get(), createCeramicTable(BlockRegistry.CERAMIC.get()));
		block(BlockRegistry.CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.CERAMIC_TILE.get()));
		block(BlockRegistry.WHITE_CERAMIC.get(), createCeramicTable(BlockRegistry.WHITE_CERAMIC.get()));
		block(BlockRegistry.WHITE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.WHITE_CERAMIC_TILE.get()));
		block(BlockRegistry.LIGHT_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.LIGHT_GREY_CERAMIC.get()));
		block(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIGHT_GREY_CERAMIC_TILE.get()));
		block(BlockRegistry.GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.GREY_CERAMIC.get()));
		block(BlockRegistry.GREY_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.GREY_CERAMIC_TILE.get()));
		block(BlockRegistry.BLACK_CERAMIC.get(), createCeramicTable(BlockRegistry.BLACK_CERAMIC.get()));
		block(BlockRegistry.BLACK_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BLACK_CERAMIC_TILE.get()));
		block(BlockRegistry.PURPLE_CERAMIC.get(), createCeramicTable(BlockRegistry.PURPLE_CERAMIC.get()));
		block(BlockRegistry.PURPLE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.PURPLE_CERAMIC_TILE.get()));
		block(BlockRegistry.MAGENTA_CERAMIC.get(), createCeramicTable(BlockRegistry.MAGENTA_CERAMIC.get()));
		block(BlockRegistry.MAGENTA_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.MAGENTA_CERAMIC_TILE.get()));
		block(BlockRegistry.BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.BLUE_CERAMIC.get()));
		block(BlockRegistry.BLUE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BLUE_CERAMIC_TILE.get()));
		block(BlockRegistry.LIGHT_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.LIGHT_BLUE_CERAMIC.get()));
		block(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIGHT_BLUE_CERAMIC_TILE.get()));
		block(BlockRegistry.CYAN_CERAMIC.get(), createCeramicTable(BlockRegistry.CYAN_CERAMIC.get()));
		block(BlockRegistry.CYAN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.CYAN_CERAMIC_TILE.get()));
		block(BlockRegistry.GREEN_CERAMIC.get(), createCeramicTable(BlockRegistry.GREEN_CERAMIC.get()));
		block(BlockRegistry.GREEN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.GREEN_CERAMIC_TILE.get()));
		block(BlockRegistry.LIME_CERAMIC.get(), createCeramicTable(BlockRegistry.LIME_CERAMIC.get()));
		block(BlockRegistry.LIME_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.LIME_CERAMIC_TILE.get()));
		block(BlockRegistry.YELLOW_CERAMIC.get(), createCeramicTable(BlockRegistry.YELLOW_CERAMIC.get()));
		block(BlockRegistry.YELLOW_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.YELLOW_CERAMIC_TILE.get()));
		block(BlockRegistry.ORANGE_CERAMIC.get(), createCeramicTable(BlockRegistry.ORANGE_CERAMIC.get()));
		block(BlockRegistry.ORANGE_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.ORANGE_CERAMIC_TILE.get()));
		block(BlockRegistry.BROWN_CERAMIC.get(), createCeramicTable(BlockRegistry.BROWN_CERAMIC.get()));
		block(BlockRegistry.BROWN_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.BROWN_CERAMIC_TILE.get()));
		block(BlockRegistry.RED_CERAMIC.get(), createCeramicTable(BlockRegistry.RED_CERAMIC.get()));
		block(BlockRegistry.RED_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.RED_CERAMIC_TILE.get()));
		block(BlockRegistry.PINK_CERAMIC.get(), createCeramicTable(BlockRegistry.PINK_CERAMIC.get()));
		block(BlockRegistry.PINK_CERAMIC_TILE.get(), createCeramicTable(BlockRegistry.PINK_CERAMIC_TILE.get()));

		block(BlockRegistry.PAINTED_WHITE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_WHITE_CERAMIC.get()));
		block(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIGHT_GREY_CERAMIC.get()));
		block(BlockRegistry.PAINTED_GREY_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_GREY_CERAMIC.get()));
		block(BlockRegistry.PAINTED_BLACK_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BLACK_CERAMIC.get()));
		block(BlockRegistry.PAINTED_PURPLE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_PURPLE_CERAMIC.get()));
		block(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_MAGENTA_CERAMIC.get()));
		block(BlockRegistry.PAINTED_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BLUE_CERAMIC.get()));
		block(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIGHT_BLUE_CERAMIC.get()));
		block(BlockRegistry.PAINTED_CYAN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_CYAN_CERAMIC.get()));
		block(BlockRegistry.PAINTED_GREEN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_GREEN_CERAMIC.get()));
		block(BlockRegistry.PAINTED_LIME_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_LIME_CERAMIC.get()));
		block(BlockRegistry.PAINTED_YELLOW_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_YELLOW_CERAMIC.get()));
		block(BlockRegistry.PAINTED_ORANGE_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_ORANGE_CERAMIC.get()));
		block(BlockRegistry.PAINTED_BROWN_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_BROWN_CERAMIC.get()));
		block(BlockRegistry.PAINTED_RED_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_RED_CERAMIC.get()));
		block(BlockRegistry.PAINTED_PINK_CERAMIC.get(), createCeramicTable(BlockRegistry.PAINTED_PINK_CERAMIC.get()));
	}
}