package com.shim.celestialexploration.datagen.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialItems;
import net.minecraft.advancements.critereon.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public abstract class BaseLootTableProvider extends LootTableProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());

    //    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    protected ExistingFileHelper fileHelper;
    protected final Map<ResourceLocation, Pair<LootTable.Builder, LootContextParamSet>> lootTables = new HashMap<>();
    private final DataGenerator generator;

    public BaseLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }

    protected abstract void addTables();
    
    protected LootTable.Builder createSimpleTable(Block block) {
    	LootPool.Builder builder = LootPool.lootPool()
    			.setRolls(ConstantValue.exactly(1))
    			.add(LootItem.lootTableItem(block))
                .when(ExplosionCondition.survivesExplosion());
    	return LootTable.lootTable().withPool(builder);
    }

    protected static LootTable.Builder createSlabItemTable(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))
                                .apply(ApplyExplosionDecay.explosionDecay())));
    }

    protected LootTable.Builder createIronOreTable(Block block) {
        return createOreTable(block, Items.RAW_IRON);
    }

    protected LootTable.Builder createRedstoneOreTable(Block block) {
        return createOreTable(block, Items.REDSTONE);
    }

    protected LootTable.Builder createCopperOreTable(Block block) {
        return createOreTable(block, Items.RAW_COPPER);
    }

    protected LootTable.Builder createBauxiteOreTable(Block block) {
        return createOreTable(block, CelestialItems.RAW_BAUXITE.get());
    }

    protected LootTable.Builder createSulfurOreTable(Block block) {
        return createOreTable(block, CelestialItems.SULFUR_CRYSTAL.get());
    }

    protected LootTable.Builder createCoalOreTable(Block block) {
        return createOreTable(block, Items.COAL);
    }

    protected LootTable.Builder createOreTable(Block block, Item item) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives((LootItem.lootTableItem(block)
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))),
                        LootItem.lootTableItem(item).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .apply(ApplyExplosionDecay.explosionDecay())));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createEntitySingleDropTable(ItemLike lootItem, float min, float max, boolean killedByPlayerCondition) {
        LootPool.Builder builder;
        if (killedByPlayerCondition) {
            builder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(lootItem)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max), false))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1.0F))))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
        } else {
            builder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(lootItem)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max), false))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1.0F))));
        }
        return LootTable.lootTable().withPool(builder);
    }

    protected LootPool.Builder createEntitySingleDropPool(ItemLike lootItem, float min, float max, boolean killedByPlayerCondition) {
        LootPool.Builder builder;
        if (killedByPlayerCondition) {
            builder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(lootItem)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max), false))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1.0F))))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
        } else {
            builder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(lootItem)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max), false))
                            .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1.0F))));
        }
        return builder;
    }


    protected LootTable.Builder createSilkTouchTable(Block block, ItemLike lootItem, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block)
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
                                LootItem.lootTableItem(lootItem)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                );
        return LootTable.lootTable().withPool(builder);
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


    protected static Pair<LootTable.Builder, LootContextParamSet> createTable(LootTable.Builder builderIn, LootContextParamSet paramSetIn) { return new Pair<>(builderIn, paramSetIn); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createAdvancementReward(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.ADVANCEMENT_REWARD); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createBlockTable(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.BLOCK); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createChestTable(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.CHEST); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createEntityTable(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.ENTITY); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createSelectorTable(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.SELECTOR); }
    protected static Pair<LootTable.Builder, LootContextParamSet> createGenericTable(LootTable.Builder builderIn) { return new Pair<>(builderIn, LootContextParamSets.ALL_PARAMS); }

    protected static LootPoolEntryContainer.Builder<?> lootTable(ResourceLocation poolLocationIn, int poolWeightIn) { return LootTableReference.lootTableReference(poolLocationIn).setWeight(poolWeightIn); }
    protected static LootPoolEntryContainer.Builder<?> lootTable(ResourceLocation poolLocationIn) { return LootTableReference.lootTableReference(poolLocationIn); }

    protected static ResourceLocation getBlockLootTable(Block blockIn, String suffixIn) { return new ResourceLocation(blockIn.getRegistryName().getNamespace(), "blocks/" + blockIn.getRegistryName().getPath() + suffixIn); }
    protected static ResourceLocation getBlockLootTable(Block blockIn) { return getBlockLootTable(blockIn, ""); }

    protected static ResourceLocation getEntityLootTable(EntityType<?> entity) {
        return new ResourceLocation(entity.getRegistryName().getNamespace(), "entity/" + entity.getRegistryName().getPath());
    }

    protected void entity(EntityType<?> entity, LootTable.Builder builder) {
        lootTables.put(getEntityLootTable(entity), createEntityTable(builder));
    }

    protected void block(Block block, LootTable.Builder builder) {
        lootTables.put(getBlockLootTable(block), createBlockTable(builder));
    }

    protected void block(Block block, String suffix, LootTable.Builder builder) {
        lootTables.put(getBlockLootTable(block, suffix), createBlockTable(builder));
    }

    @Override
    public void run(HashCache cacheIn) {
        this.addTables();
        Map<ResourceLocation, LootTable> tables = Maps.newHashMap();
        for (Map.Entry<ResourceLocation, Pair<LootTable.Builder, LootContextParamSet>> entry : this.lootTables.entrySet()) {
            tables.put(entry.getKey(), entry.getValue().getFirst().setParamSet(entry.getValue().getSecond()).build());
        }
        this.writeTables(cacheIn, tables);
    }

    private void writeTables(HashCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                DataProvider.save(GSON, cache, LootTables.serialize(lootTable), path);
            } catch (IOException e) {
                LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }

    @Override
    public String getName() {
        return "Celestial Exploration LootTables";
    }
}