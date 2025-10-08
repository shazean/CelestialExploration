package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.registry.CelestialBlocks;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestiallib.api.datagen.base.BaseLootTableProvider;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class CelestialLootTables extends BaseLootTableProvider {

    public CelestialLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {

		for (RegistryObject<? extends Block> block : CelestialBlocks.BLOCKS_LOOT_TABLE) block(block.get(), createSimpleTable(block.get()));

		//---- ENTITIES -------------------------------------------------------------------------------
		entity(CelestialEntities.FLARE.get(), createEntitySingleDropTable(CelestialItems.FLARE_ROD.get(), 0.0F, 1.0F, true));
		entity(CelestialEntities.LUNAR_SLIME.get(), createEntitySingleDropTable(CelestialItems.LUNAR_GOO.get(), 0.0F, 2.0F, false));
		entity(CelestialEntities.MARS_MALLOW.get(), createEntitySingleDropTable(CelestialItems.MARSHMALLOW_GOO.get(), 0.0F, 2.0F, false));
		entity(CelestialEntities.RUST_SLIME.get(), createEntitySingleDropTable(CelestialItems.RUSTED_IRON_NUGGET.get(), 0.0F, 2.0F, false));
		entity(CelestialEntities.SULFUR_CUBE.get(), createEntitySingleDropTable(Items.LAPIS_LAZULI, -2.0F, 1.0F, false));
		entity(CelestialEntities.VISCOUS_SLIME.get(), createEntitySingleDropTable(CelestialItems.CINNABAR.get(), 0.0F, 2.0F, false));
		entity(CelestialEntities.QUICKSILVER_SLIME.get(), createEntitySingleDropTable(CelestialItems.CINNABAR.get(), 0.0F, 2.0F, false));

		entity(CelestialEntities.VOIDED.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 2.0F, false)
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(Items.IRON_INGOT))
						.add(LootItem.lootTableItem(Items.CARROT))
						.add(LootItem.lootTableItem(Items.POTATO)
								.apply(SmeltItemFunction.smelted()
										.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.LURKER.get(), createEntitySingleDropTable(Items.GUNPOWDER, 0.0F, 2.0F, false)
				.withPool(LootPool.lootPool()
						.add(TagEntry.expandTag(ItemTags.CREEPER_DROP_MUSIC_DISCS))
						.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.entity().of(EntityTypeTags.SKELETONS)))));

		entity(CelestialEntities.VOIDED_PIGLIN.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 1.0F, false)
				.withPool(createEntitySingleDropPool(Items.GOLD_NUGGET, 0.0F, 1.0F, false))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.GOLD_INGOT))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.VOIDED_ZOGLIN.get(), createEntitySingleDropTable(Items.ROTTEN_FLESH, 0.0F, 1.0F, false));
		entity(CelestialEntities.FLARE.get(), createEntitySingleDropTable(CelestialItems.FLARE_ROD.get(), 0.0F, 1.0F, true));

		entity(CelestialEntities.CELESTIAL_CAT.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.STRING)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(CelestialItems.BASIC_SPACESUIT_HELMET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.VOID_CRAWLER.get(), createEntitySingleDropTable(Items.STRING, 0.0F, 2.0F, false)
				.withPool(createEntitySingleDropPool(Items.SPIDER_EYE, -1.0F, 1.0F, true)));

		entity(CelestialEntities.ORBITER.get(), createEntitySingleDropTable(Items.GHAST_TEAR, 0.0F, 1.0F, false)
				.withPool(createEntitySingleDropPool(Items.GUNPOWDER, 0.0F, 2.0F, false)));


		entity(CelestialEntities.METEOR_CRAWLER.get(), createEntitySingleDropTable(Items.STRING, 0.0F, 2.0F, false)
				.withPool(createEntitySingleDropPool(Items.SPIDER_EYE, -1.0F, 1.0F, true))
				.withPool(createEntitySingleDropPool(Items.IRON_NUGGET, -1.0F, 1.0F, true))
				.withPool(createEntitySingleDropPool(Items.GOLD_NUGGET, -1.0F, 1.0F, true)));


		entity(CelestialEntities.ASTRAL_HOGLIN.get(), createEntitySingleDropTable(Items.LEATHER, 0.0F, 1.0F, false)
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.PORKCHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
								.apply(SmeltItemFunction.smelted()
										.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE)))
								.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));

		entity(CelestialEntities.ASTRAL_PIGLIN.get(), LootTable.lootTable());

		entity(CelestialEntities.CYBORG_PIGLIN.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(CelestialItems.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.DRONE.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.REDSTONE))
						.add(LootItem.lootTableItem(CelestialItems.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.VOIDFELLOW.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.ENDER_PEARL)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
								.apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))))));


		entity(CelestialEntities.ROVER.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.REDSTONE))
						.add(LootItem.lootTableItem(CelestialItems.RUSTED_IRON_NUGGET.get()))
						.add(LootItem.lootTableItem(Items.IRON_NUGGET))
						.add(LootItem.lootTableItem(CelestialItems.STEEL_NUGGET.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.COBBLESAURUS.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(CelestialBlocks.MARS_COBBLESTONE.get()))
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.025F, 0.01F))));

		entity(CelestialEntities.GUST.get(), createEntitySingleDropTable(Items.GUNPOWDER, 0.0F, 2.0F, false));

		entity(CelestialEntities.MECHADOG.get(), LootTable.lootTable()
				.withPool(LootPool.lootPool()
					.setRolls(ConstantValue.exactly(1.0F))
					.add(LootItem.lootTableItem(Items.REDSTONE)))
//					.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.8F, 0.01F)))
				.withPool(LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(CelestialBlocks.MECHADOG_HEAD.get()))
						.when(LootItemKilledByPlayerCondition.killedByPlayer())
						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.1F, 0.01F)))
//				.withPool(LootPool.lootPool()
//						.setRolls(ConstantValue.exactly(1.0F))
//						.add(LootItem.lootTableItem(ItemRegistry.MECHADOG_CORE.get()))
//						.when(LootItemKilledByPlayerCondition.killedByPlayer())
//						.when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.010F, 0.01F)))
		);

		entity(CelestialEntities.MECHACERBERUS_BOSS.get(), LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1.0F))
								.add(LootItem.lootTableItem(CelestialItems.MECHACERBERUS_CORE.get()))
//								.when(LootItemKilledByPlayerCondition.killedByPlayer())
						));

		//---- BLOCKS -------------------------------------------------------------------------------
		//---- MOON -------------------------------------------------------------------------------
		//STONE
		block(CelestialBlocks.MOON_STONE.get(), createSilkTouchTable(CelestialBlocks.MOON_STONE.get(), CelestialBlocks.MOON_COBBLESTONE.get(), 1, 1));

		block(CelestialBlocks.MOON_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_STONE_SLAB.get()));
		block(CelestialBlocks.MOON_COBBLESTONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_COBBLESTONE_SLAB.get()));
		block(CelestialBlocks.MOON_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_BRICK_SLAB.get()));
		block(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(CelestialBlocks.MOON_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.MOON_DEEPSLATE.get(), CelestialBlocks.MOON_COBBLED_DEEPSLATE.get(), 1, 1));

		block(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.MOON_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(CelestialBlocks.MOON_IRON_ORE.get(), createIronOreTable(CelestialBlocks.MOON_IRON_ORE.get()));
		block(CelestialBlocks.MOON_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.MOON_REDSTONE_ORE.get()));
		block(CelestialBlocks.MOON_BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.MOON_BAUXITE_ORE.get()));
		block(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get(), createIronOreTable(CelestialBlocks.MOON_DEEPSLATE_IRON_ORE.get()));
		block(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.MOON_DEEPSLATE_REDSTONE_ORE.get()));

		block(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CHISELED_MOON_DEEPSLATE_BRICKS.get()));
		block(CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CRACKED_MOON_DEEPSLATE_BRICKS.get()));

		//OTHER
    	block(CelestialBlocks.GLOWING_MOON_SAND.get(), createSilkTouchTable(CelestialBlocks.GLOWING_MOON_SAND.get(), CelestialItems.MOON_DUST.get(), 2, 5));
		block(CelestialBlocks.LUNAR_LANTERN.get(), createSilkTouchTable(CelestialBlocks.LUNAR_LANTERN.get(), CelestialItems.MOON_DUST.get(), 1, 3));

		block(CelestialBlocks.MOON_CHEST.get(), createSimpleTable(CelestialBlocks.MOON_CHEST.get()));

		//---- MARS -------------------------------------------------------------------------------
		//STONE
		block(CelestialBlocks.MARS_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_STONE_SLAB.get()));
		block(CelestialBlocks.MARS_COBBLESTONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_COBBLESTONE_SLAB.get()));
		block(CelestialBlocks.MARS_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_BRICK_SLAB.get()));
		block(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(CelestialBlocks.MARS_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.MARS_DEEPSLATE.get(), CelestialBlocks.MARS_COBBLED_DEEPSLATE.get(), 1, 1));

		block(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.MARS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(CelestialBlocks.MARS_IRON_ORE.get(), createIronOreTable(CelestialBlocks.MARS_IRON_ORE.get()));
		block(CelestialBlocks.MARS_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.MARS_REDSTONE_ORE.get()));
		block(CelestialBlocks.MARS_BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.MARS_BAUXITE_ORE.get()));
		block(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(CelestialBlocks.MARS_DEEPSLATE_IRON_ORE.get()));
		block(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get(), createIronOreTable(CelestialBlocks.MARS_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		block(CelestialBlocks.MARS_LANTERN.get(), createSilkTouchTable(CelestialBlocks.MARS_LANTERN.get(), CelestialItems.RUSTED_IRON_NUGGET.get(), 1, 3));
		block(CelestialBlocks.MARS_CHEST.get(), createSimpleTable(CelestialBlocks.MARS_CHEST.get()));

		//---- VENUS -------------------------------------------------------------------------------
		//STONE
		block(CelestialBlocks.VENUS_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_STONE_SLAB.get()));
		block(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_COBBLESTONE_SLAB.get()));
		block(CelestialBlocks.VENUS_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_BRICK_SLAB.get()));
		block(CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.SMALL_VENUS_BRICK_SLAB.get()));
		block(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(CelestialBlocks.VENUS_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.VENUS_DEEPSLATE.get(), CelestialBlocks.VENUS_COBBLED_DEEPSLATE.get(), 1, 1));

		block(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.VENUS_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(CelestialBlocks.VENUS_IRON_ORE.get(), createIronOreTable(CelestialBlocks.VENUS_IRON_ORE.get()));
		block(CelestialBlocks.VENUS_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.VENUS_REDSTONE_ORE.get()));
		block(CelestialBlocks.VENUS_BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.VENUS_BAUXITE_ORE.get()));
		block(CelestialBlocks.VENUS_LAPIS_ORE.get(), createOreTable(CelestialBlocks.VENUS_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		block(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get(), createIronOreTable(CelestialBlocks.VENUS_DEEPSLATE_IRON_ORE.get()));
		block(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.VENUS_DEEPSLATE_REDSTONE_ORE.get()));
		block(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get(), createOreTable(CelestialBlocks.VENUS_DEEPSLATE_LAPIS_ORE.get(), Items.LAPIS_LAZULI));

		//OTHER
		block(CelestialBlocks.VENUS_LANTERN.get(), createSilkTouchTable(CelestialBlocks.VENUS_LANTERN.get(), CelestialItems.SULFUR_CRYSTAL.get(), 1, 3));
		block(CelestialBlocks.VENUS_CHEST.get(), createSimpleTable(CelestialBlocks.VENUS_CHEST.get()));

		//---- CELESTIAL OBJECTS -------------------------------------------------------------------------------
		//METEOR
    	block(CelestialBlocks.METEOR_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.METEOR_BRICK_SLAB.get()));

		//METEOR ORE
		block(CelestialBlocks.METEOR_COAL_ORE.get(), createCoalOreTable(CelestialBlocks.METEOR_COAL_ORE.get()));
		block(CelestialBlocks.METEOR_COPPER_ORE.get(), createCopperOreTable(CelestialBlocks.METEOR_COPPER_ORE.get()));
		block(CelestialBlocks.METEOR_DIAMOND_ORE.get(), createOreTable(CelestialBlocks.METEOR_DIAMOND_ORE.get(), Items.DIAMOND));
		block(CelestialBlocks.METEOR_EMERALD_ORE.get(), createOreTable(CelestialBlocks.METEOR_EMERALD_ORE.get(), Items.EMERALD));
		block(CelestialBlocks.METEOR_GOLD_ORE.get(), createOreTable(CelestialBlocks.METEOR_GOLD_ORE.get(), Items.RAW_GOLD));
		block(CelestialBlocks.METEOR_IRON_ORE.get(), createIronOreTable(CelestialBlocks.METEOR_IRON_ORE.get()));
		block(CelestialBlocks.METEOR_LAPIS_ORE.get(), createOreTable(CelestialBlocks.METEOR_LAPIS_ORE.get(), Items.LAPIS_LAZULI));
		block(CelestialBlocks.METEOR_SULFUR_ORE.get(), createSulfurOreTable(CelestialBlocks.METEOR_SULFUR_ORE.get()));
		block(CelestialBlocks.METEOR_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.METEOR_REDSTONE_ORE.get()));
		block(CelestialBlocks.METEOR_BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.METEOR_BAUXITE_ORE.get()));

		//SUN
		block(CelestialBlocks.SOLAR_PLASMA.get(), createSimpleTable(CelestialBlocks.SOLAR_PLASMA.get()));
		block(CelestialBlocks.SUN_SPOT.get(), createSimpleTable(CelestialBlocks.SUN_SPOT.get()));
		block(CelestialBlocks.SOLAR_FLARE.get(), createSimpleTable(CelestialBlocks.SOLAR_FLARE.get()));

		//---- MERCURY -------------------------------------------------------------------------------
		//STONE
		block(CelestialBlocks.MERCURY_STONE.get(), createSilkTouchTable(CelestialBlocks.MERCURY_STONE.get(), CelestialBlocks.MERCURY_COBBLESTONE.get(), 1, 1));

		block(CelestialBlocks.MERCURY_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_STONE_SLAB.get()));
		block(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_COBBLESTONE_SLAB.get()));
		block(CelestialBlocks.MERCURY_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_BRICK_SLAB.get()));
		block(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(CelestialBlocks.MERCURY_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.MERCURY_DEEPSLATE.get(), CelestialBlocks.MERCURY_COBBLED_DEEPSLATE.get(), 1, 1));
		block(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.MERCURY_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(CelestialBlocks.MERCURY_BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.MERCURY_BAUXITE_ORE.get()));
		block(CelestialBlocks.MERCURY_SULFUR_ORE.get(), createSulfurOreTable(CelestialBlocks.MERCURY_SULFUR_ORE.get()));
		block(CelestialBlocks.MERCURY_COAL_ORE.get(), createCoalOreTable(CelestialBlocks.MERCURY_COAL_ORE.get()));
		block(CelestialBlocks.MERCURY_DIAMOND_ORE.get(), createOreTable(CelestialBlocks.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		block(CelestialBlocks.MERCURY_DEEPSLATE_DIAMOND_ORE.get(), createOreTable(CelestialBlocks.MERCURY_DIAMOND_ORE.get(), Items.DIAMOND));
		block(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get(), createIronOreTable(CelestialBlocks.MERCURY_DEEPSLATE_IRON_ORE.get()));
		block(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get(), createCoalOreTable(CelestialBlocks.MERCURY_DEEPSLATE_COAL_ORE.get()));
		block(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get(), createRedstoneOreTable(CelestialBlocks.MERCURY_DEEPSLATE_REDSTONE_ORE.get()));

		//OTHER
		block(CelestialBlocks.MERCURY_LANTERN.get(), createSilkTouchTable(CelestialBlocks.MERCURY_LANTERN.get(), CelestialItems.CINNABAR.get(), 1, 1));
		block(CelestialBlocks.MERCURY_SAND_PATH.get(), createSimpleTable(CelestialBlocks.MERCURY_SAND.get()));
		block(CelestialBlocks.MERCURY_CHEST.get(), createSimpleTable(CelestialBlocks.MERCURY_CHEST.get()));

		//---- JUPITER -------------------------------------------------------------------------------
		//DEEPSLATE
		block(CelestialBlocks.JUPITER_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.JUPITER_DEEPSLATE.get(), CelestialBlocks.JUPITER_COBBLED_DEEPSLATE.get(), 1, 1));

		block(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.JUPITER_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.JUPITER_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.JUPITER_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.JUPITER_DEEPSLATE_TILE_SLAB.get()));

		block(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CHISELED_JUPITER_DEEPSLATE_BRICKS.get()));
		block(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CRACKED_JUPITER_DEEPSLATE_BRICKS.get()));

		//OTHER
		block(CelestialBlocks.JUPITER_LANTERN.get(), createSilkTouchTable(CelestialBlocks.JUPITER_LANTERN.get(), CelestialBlocks.JUPITER_DEEPSLATE.get(), 1, 3)); //FIXME?
		block(CelestialBlocks.JUPITER_ATMOSPHERE.get(), createSimpleTable(CelestialBlocks.JUPITER_ATMOSPHERE.get()));
		block(CelestialBlocks.JUPITER_CHEST.get(), createSimpleTable(CelestialBlocks.JUPITER_CHEST.get()));

		//---- IO -------------------------------------------------------------------------------
		//STONE
		block(CelestialBlocks.IO_STONE.get(), createSilkTouchTable(CelestialBlocks.IO_STONE.get(), CelestialBlocks.IO_COBBLESTONE.get(), 1, 1));

		block(CelestialBlocks.IO_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_STONE_SLAB.get()));
		block(CelestialBlocks.IO_COBBLESTONE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_COBBLESTONE_SLAB.get()));
		block(CelestialBlocks.IO_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_BRICK_SLAB.get()));
		block(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_SMOOTH_STONE_SLAB.get()));

		//DEEPSLATE
		block(CelestialBlocks.IO_DEEPSLATE.get(), createSilkTouchTable(CelestialBlocks.IO_DEEPSLATE.get(), CelestialBlocks.IO_COBBLED_DEEPSLATE.get(), 1, 1));

		block(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_COBBLED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_DEEPSLATE_BRICK_SLAB.get()));
		block(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_POLISHED_DEEPSLATE_SLAB.get()));
		block(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get(), createSlabItemTable(CelestialBlocks.IO_DEEPSLATE_TILE_SLAB.get()));

		//ORES
		block(CelestialBlocks.IO_SULFUR_ORE.get(), createSulfurOreTable(CelestialBlocks.IO_SULFUR_ORE.get()));
		block(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get(), createIronOreTable(CelestialBlocks.IO_DEEPSLATE_IRON_ORE.get()));

		block(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CHISELED_IO_DEEPSLATE_BRICKS.get()));
		block(CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get(), createSimpleTable(CelestialBlocks.CRACKED_IO_DEEPSLATE_BRICKS.get()));

		//OTHER
		block(CelestialBlocks.GLOWING_IO_SAND.get(), createSilkTouchTable(CelestialBlocks.GLOWING_IO_SAND.get(), CelestialItems.IO_DUST.get(), 2, 5));
		block(CelestialBlocks.IO_LANTERN.get(), createSilkTouchTable(CelestialBlocks.LUNAR_LANTERN.get(), CelestialItems.IO_DUST.get(), 1, 3));
		block(CelestialBlocks.IO_CHEST.get(), createSimpleTable(CelestialBlocks.IO_CHEST.get()));

		//---- EUROPA -------------------------------------------------------------------------------
		block(CelestialBlocks.EUROPA_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.EUROPA_BRICK_SLAB.get()));
		block(CelestialBlocks.GLOWING_EUROPA_SAND.get(), createSilkTouchTable(CelestialBlocks.GLOWING_EUROPA_SAND.get(), CelestialItems.EUROPA_DUST.get(), 2, 5));
		block(CelestialBlocks.EUROPA_LANTERN.get(), createSilkTouchTable(CelestialBlocks.EUROPA_LANTERN.get(), CelestialItems.EUROPA_DUST.get(), 1, 3));

		//---- CALLISTO -------------------------------------------------------------------------------
		block(CelestialBlocks.CALLISTO_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.CALLISTO_BRICK_SLAB.get()));
		block(CelestialBlocks.GLOWING_CALLISTO_SAND.get(), createSilkTouchTable(CelestialBlocks.GLOWING_CALLISTO_SAND.get(), CelestialItems.CALLISTO_DUST.get(), 2, 5));
		block(CelestialBlocks.CALLISTO_LANTERN.get(), createSilkTouchTable(CelestialBlocks.CALLISTO_LANTERN.get(), CelestialItems.CALLISTO_DUST.get(), 1, 3));

		//---- GANYMEDE -------------------------------------------------------------------------------
		block(CelestialBlocks.GANYMEDE_BRICK_SLAB.get(), createSlabItemTable(CelestialBlocks.GANYMEDE_BRICK_SLAB.get()));
		block(CelestialBlocks.GLOWING_GANYMEDE_SAND.get(), createSilkTouchTable(CelestialBlocks.GLOWING_GANYMEDE_SAND.get(), CelestialItems.GANYMEDE_DUST.get(), 2, 5));
		block(CelestialBlocks.GANYMEDE_LANTERN.get(), createSilkTouchTable(CelestialBlocks.GANYMEDE_LANTERN.get(), CelestialItems.GANYMEDE_DUST.get(), 1, 3));


		//---- ORES/ALLOYS -------------------------------------------------------------------------------
		block(CelestialBlocks.BAUXITE_ORE.get(), createBauxiteOreTable(CelestialBlocks.BAUXITE_ORE.get()));

		//---- SPACESHIP-RELATED -------------------------------------------------------------------------------
		block(CelestialBlocks.STEEL_FRAME.get(), createSimpleTable(CelestialBlocks.STEEL_FRAME.get()));

		//---- GLASS/CERAMICS -------------------------------------------------------------------------------
		//GLASS
		block(CelestialBlocks.LUMINOUS_BLUE_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_BLUE_GLASS.get(), CelestialItems.MOON_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_WHITE_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_WHITE_GLASS.get(), CelestialItems.MOON_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_CYAN_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_CYAN_GLASS.get(), CelestialItems.EUROPA_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_MAGENTA_GLASS.get(), CelestialItems.CALLISTO_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_YELLOW_GLASS.get(), CelestialItems.IO_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_RED_GLASS.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_RED_GLASS.get(), CelestialItems.GANYMEDE_DUST.get(), 1, 1));

		block(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_YELLOW_GLASS_PANE.get(), CelestialItems.IO_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_RED_GLASS_PANE.get(), CelestialItems.GANYMEDE_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_MAGENTA_GLASS_PANE.get(), CelestialItems.CALLISTO_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_CYAN_GLASS_PANE.get(), CelestialItems.EUROPA_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_BLUE_GLASS_PANE.get(), CelestialItems.MOON_DUST.get(), 1, 1));
		block(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), createSilkTouchTable(CelestialBlocks.LUMINOUS_WHITE_GLASS_PANE.get(), CelestialItems.MOON_DUST.get(), 1, 1));

		block(CelestialBlocks.REINFORCED_GLASS.get(), createSimpleTable(CelestialBlocks.REINFORCED_GLASS.get()));
		block(CelestialBlocks.REINFORCED_GLASS_PANE.get(), createSimpleTable(CelestialBlocks.REINFORCED_GLASS_PANE.get()));

		//CERAMIC
		block(CelestialBlocks.CERAMIC.get(), createCeramicTable(CelestialBlocks.CERAMIC.get()));
		block(CelestialBlocks.CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.CERAMIC_TILE.get()));
		block(CelestialBlocks.WHITE_CERAMIC.get(), createCeramicTable(CelestialBlocks.WHITE_CERAMIC.get()));
		block(CelestialBlocks.WHITE_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.WHITE_CERAMIC_TILE.get()));
		block(CelestialBlocks.LIGHT_GREY_CERAMIC.get(), createCeramicTable(CelestialBlocks.LIGHT_GREY_CERAMIC.get()));
		block(CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.LIGHT_GREY_CERAMIC_TILE.get()));
		block(CelestialBlocks.GREY_CERAMIC.get(), createCeramicTable(CelestialBlocks.GREY_CERAMIC.get()));
		block(CelestialBlocks.GREY_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.GREY_CERAMIC_TILE.get()));
		block(CelestialBlocks.BLACK_CERAMIC.get(), createCeramicTable(CelestialBlocks.BLACK_CERAMIC.get()));
		block(CelestialBlocks.BLACK_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.BLACK_CERAMIC_TILE.get()));
		block(CelestialBlocks.PURPLE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PURPLE_CERAMIC.get()));
		block(CelestialBlocks.PURPLE_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.PURPLE_CERAMIC_TILE.get()));
		block(CelestialBlocks.MAGENTA_CERAMIC.get(), createCeramicTable(CelestialBlocks.MAGENTA_CERAMIC.get()));
		block(CelestialBlocks.MAGENTA_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.MAGENTA_CERAMIC_TILE.get()));
		block(CelestialBlocks.BLUE_CERAMIC.get(), createCeramicTable(CelestialBlocks.BLUE_CERAMIC.get()));
		block(CelestialBlocks.BLUE_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.BLUE_CERAMIC_TILE.get()));
		block(CelestialBlocks.LIGHT_BLUE_CERAMIC.get(), createCeramicTable(CelestialBlocks.LIGHT_BLUE_CERAMIC.get()));
		block(CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.LIGHT_BLUE_CERAMIC_TILE.get()));
		block(CelestialBlocks.CYAN_CERAMIC.get(), createCeramicTable(CelestialBlocks.CYAN_CERAMIC.get()));
		block(CelestialBlocks.CYAN_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.CYAN_CERAMIC_TILE.get()));
		block(CelestialBlocks.GREEN_CERAMIC.get(), createCeramicTable(CelestialBlocks.GREEN_CERAMIC.get()));
		block(CelestialBlocks.GREEN_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.GREEN_CERAMIC_TILE.get()));
		block(CelestialBlocks.LIME_CERAMIC.get(), createCeramicTable(CelestialBlocks.LIME_CERAMIC.get()));
		block(CelestialBlocks.LIME_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.LIME_CERAMIC_TILE.get()));
		block(CelestialBlocks.YELLOW_CERAMIC.get(), createCeramicTable(CelestialBlocks.YELLOW_CERAMIC.get()));
		block(CelestialBlocks.YELLOW_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.YELLOW_CERAMIC_TILE.get()));
		block(CelestialBlocks.ORANGE_CERAMIC.get(), createCeramicTable(CelestialBlocks.ORANGE_CERAMIC.get()));
		block(CelestialBlocks.ORANGE_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.ORANGE_CERAMIC_TILE.get()));
		block(CelestialBlocks.BROWN_CERAMIC.get(), createCeramicTable(CelestialBlocks.BROWN_CERAMIC.get()));
		block(CelestialBlocks.BROWN_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.BROWN_CERAMIC_TILE.get()));
		block(CelestialBlocks.RED_CERAMIC.get(), createCeramicTable(CelestialBlocks.RED_CERAMIC.get()));
		block(CelestialBlocks.RED_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.RED_CERAMIC_TILE.get()));
		block(CelestialBlocks.PINK_CERAMIC.get(), createCeramicTable(CelestialBlocks.PINK_CERAMIC.get()));
		block(CelestialBlocks.PINK_CERAMIC_TILE.get(), createCeramicTable(CelestialBlocks.PINK_CERAMIC_TILE.get()));

		block(CelestialBlocks.PAINTED_WHITE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_WHITE_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_LIGHT_GREY_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_LIGHT_GREY_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_GREY_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_GREY_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_BLACK_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_BLACK_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_PURPLE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_PURPLE_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_MAGENTA_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_MAGENTA_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_BLUE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_BLUE_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_LIGHT_BLUE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_LIGHT_BLUE_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_CYAN_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_CYAN_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_GREEN_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_GREEN_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_LIME_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_LIME_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_YELLOW_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_YELLOW_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_ORANGE_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_ORANGE_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_BROWN_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_BROWN_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_RED_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_RED_CERAMIC.get()));
		block(CelestialBlocks.PAINTED_PINK_CERAMIC.get(), createCeramicTable(CelestialBlocks.PAINTED_PINK_CERAMIC.get()));

		block(CelestialBlocks.BLACK_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.BLACK_DISPLAY_BOARD.get()));
		block(CelestialBlocks.RED_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.RED_DISPLAY_BOARD.get()));
		block(CelestialBlocks.BLUE_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.BLUE_DISPLAY_BOARD.get()));
		block(CelestialBlocks.WHITE_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.WHITE_DISPLAY_BOARD.get()));

		block(CelestialBlocks.BLACK_WALL_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.BLACK_DISPLAY_BOARD.get()));
		block(CelestialBlocks.BLUE_WALL_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.BLUE_DISPLAY_BOARD.get()));
		block(CelestialBlocks.RED_WALL_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.RED_DISPLAY_BOARD.get()));
		block(CelestialBlocks.WHITE_WALL_DISPLAY_BOARD.get(), createSimpleTable(CelestialBlocks.WHITE_DISPLAY_BOARD.get()));

		block(CelestialBlocks.MARS_FARMLAND.get(), createSilkTouchTable(CelestialBlocks.MARS_FARMLAND.get(), CelestialBlocks.MARS_SAND.get(), 1, 1));
		block(CelestialBlocks.MOON_FARMLAND.get(), createSilkTouchTable(CelestialBlocks.MOON_FARMLAND.get(), CelestialBlocks.MOON_SAND.get(), 1, 1));
		block(CelestialBlocks.MERCURY_FARMLAND.get(), createSilkTouchTable(CelestialBlocks.MERCURY_FARMLAND.get(), CelestialBlocks.MERCURY_SAND.get(), 1, 1));


	}

	protected LootTable.Builder createCeramicTable(Block block) {
		LootPool.Builder builder = LootPool.lootPool()
				.setRolls(ConstantValue.exactly(1))
				.add(AlternativesEntry.alternatives(
								LootItem.lootTableItem(block)
										.when(MatchTool.toolMatches(ItemPredicate.Builder.item()
												.hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
								LootItem.lootTableItem(CelestialBlocks.SILICA.get())
										.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
										.apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
										.apply(ApplyExplosionDecay.explosionDecay())
						)
				);
		return LootTable.lootTable().withPool(builder);
	}

	protected LootTable.Builder createBauxiteOreTable(Block block) {
		return createOreTable(block, CelestialItems.RAW_BAUXITE.get());
	}

	protected LootTable.Builder createSulfurOreTable(Block block) {
		return createOreTable(block, CelestialItems.SULFUR_CRYSTAL.get());
	}
}