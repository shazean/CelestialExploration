package com.shim.celestialexploration.events;

import com.google.common.collect.ImmutableMap;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.registry.CelestialVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID)
public class CelestialVillagerTrades {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades;
//
//        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
//            trades = event.getTrades();
//
//
//            trades.get(1)
//                    .add((trader, rand) -> getTreasureMapForEmeralds(trader,13, TagRegistry.Structures.MARS_LABYRINTH, "filled_map.mars_labyrinth", MapDecoration.Type.RED_X, 12, 5));
//
//
//        }


        if (event.getType() == CelestialVillagers.ASTRONOMER.get()) {
            trades = event.getTrades();

//            int villagerLevel = 1;

            trades.get(1).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.MOON_DUST.get(), 4), 1, 12, 1, 0.05F));
            trades.get(1).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.RUSTED_IRON_NUGGET.get(), 4), 1, 12, 1, 0.05F));
            trades.get(1).add((trader, rand) -> getItemForEmeralds(new ItemStack(Items.MAP), 7, 12, 1, 0.02F));
            trades.get(2).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.SULFUR_CRYSTAL.get(), 4), 1, 12, 2, 0.05F));
            trades.get(2).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.CINNABAR.get(), 4), 1, 12, 2, 0.05F));
            trades.get(2).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialBlocks.LUNAR_LANTERN.get()), 5, 12, 15, 0.05F));
            trades.get(2).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialBlocks.MARS_LANTERN.get()), 5, 12, 15, 0.05F));
            trades.get(2).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialBlocks.MERCURY_LANTERN.get()), 5, 12, 15, 0.05F));
            trades.get(2).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialBlocks.VENUS_LANTERN.get()), 5, 12, 15, 0.05F));

        } else if (event.getType() == CelestialVillagers.ENGINEER.get()) {
            trades = event.getTrades();

            trades.get(1).add((trader, rand) -> getEmeraldsForItem(new ItemStack(Items.COAL, 15), 1, 16, 2, 0.05F));
            trades.get(1).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.BASIC_SPACESUIT_HELMET.get()), 5, 12, 2, 0.2F));
            trades.get(1).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get()), 9, 12, 2, 0.2F));
            trades.get(1).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.BASIC_SPACESUIT_LEGGINGS.get()), 7, 12, 2, 0.2F));
            trades.get(1).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.BASIC_SPACESUIT_BOOTS.get()), 4, 12, 2, 0.2F));
            trades.get(2).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.STEEL_INGOT.get()), 6, 12, 10, 0.05F));
            trades.get(2).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.BAUXITE_INGOT.get()), 4, 12, 10, 0.05F));
            trades.get(2).add((trader, rand) -> getEmeraldsForItem(new ItemStack(CelestialItems.ALUMINUM_INGOT.get()), 6, 12, 10, 0.05F));
            trades.get(3).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.MAGCART.get()), 5, 12, 4, 0.2F));
            trades.get(3).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialBlocks.MAGRAIL.get()), 3, 12, 4, 0.2F));
            trades.get(3).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.THERMAL_SPACESUIT_BOOTS.get()), 7, 3, 15, 0.2F));
            trades.get(3).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.OG_HEAVY_DUTY_SPACESUIT_BOOTS.get()), 7, 3, 15, 0.2F));
            trades.get(4).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.SPACESHIP_CABIN.get()), 20, 5, 12, 0.2F));
            trades.get(4).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.SPACESHIP_FRAME.get()), 20, 5, 12, 0.2F));
            trades.get(4).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.SPACESHIP_ENGINE.get()), 20, 5, 12, 0.2F));
            trades.get(4).add((trader, rand) -> getItemForEmeralds(new ItemStack(CelestialItems.LOX_TANK.get()), 10, 5, 4, 0.2F));
            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.ADVANCED_SPACESUIT_HELMET.get()), 8, 3, 15, 0.2F));
            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.ADVANCED_SPACESUIT_CHESTPLATE.get()), 16, 3, 15, 0.2F));
            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.ADVANCED_SPACESUIT_LEGGINGS.get()), 14, 3, 15, 0.2F));
            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(new ItemStack(CelestialItems.ADVANCED_SPACESUIT_BOOTS.get()), 8, 3, 15, 0.2F));

        }

//        if (event.getType() == VillagerRegistry.GEOLOGIST.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//
//            int villagerLevel = 1;
//
//            trades.get(villagerLevel).add((trader, rand) -> offer(
//                    new ItemStack(Items.SAND, 2),
//                    new ItemStack(Items.STONE), 2, 1, 0.02F));
//
//        }

    }

    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> CELESTIAL_TRADER_TRADES = toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{},
            2, new VillagerTrades.ItemListing[]{}));

    static class ItemsForEmeralds implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int emeraldCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;


        public ItemsForEmeralds(Item item, int emeraldCost, int numberOfItems, int maxUses, int villagerXp) {
            this(new ItemStack(item), emeraldCost, numberOfItems, maxUses, villagerXp);
        }

        public ItemsForEmeralds(ItemStack itemStack, int emeraldCost, int numberOfItems, int maxUses, int villagerXp) {
            this(itemStack, emeraldCost, numberOfItems, maxUses, villagerXp, 0.05F);
        }

        public ItemsForEmeralds(ItemStack itemStack, int emeraldCost, int numberOfItems, int maxUses, int villagerXp, float priceMultiplier) {
            this.itemStack = itemStack;
            this.emeraldCost = emeraldCost;
            this.numberOfItems = numberOfItems;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
            this.priceMultiplier = priceMultiplier;
        }

        public MerchantOffer getOffer(Entity p_35771_, Random p_35772_) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }


    public static MerchantOffer offer(ItemStack baseCostA, ItemStack result, int maxUses, int xp, float priceMultiplier) {
        return offer(baseCostA, ItemStack.EMPTY, result, maxUses, xp, priceMultiplier);
    }

    public static MerchantOffer offer(ItemStack baseCostA, ItemStack costB, ItemStack result, int maxUses, int xp, float priceMultiplier) {
        return offer(baseCostA, costB, result, 0, maxUses, xp, priceMultiplier);
    }

    public static MerchantOffer offer(ItemStack baseCostA, ItemStack costB, ItemStack result, int uses, int maxUses, int xp, float priceMultiplier) {
        return offer(baseCostA, costB, result, uses, maxUses, xp, priceMultiplier, 0);
    }

    public static MerchantOffer offer(ItemStack baseCostA, ItemStack costB, ItemStack result, int uses, int maxUses, int xp, float priceMultiplier, int demand) {
        return new MerchantOffer(baseCostA, costB, result, uses, maxUses, xp, priceMultiplier, demand);
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> p_35631_) {
        return new Int2ObjectOpenHashMap<>(p_35631_);
    }


    public static MerchantOffer getItemForEmeralds(ItemStack item, int numEmeralds, int maxUses, int xp, float priceMultiplier) {
        return offer(new ItemStack(Items.EMERALD, numEmeralds), item, maxUses, xp, priceMultiplier);
    }


    public static MerchantOffer getEnchantedItemForEmeralds(ItemStack item, int numEmeralds, int maxUses, int xp, float priceMultiplier) {
        Random random = new Random();
        int i = 5 + random.nextInt(15);
        ItemStack enchantedItem = EnchantmentHelper.enchantItem(random, item, i, false);

        return offer(new ItemStack(Items.EMERALD, numEmeralds), enchantedItem, maxUses, xp, priceMultiplier);
    }

    public static MerchantOffer getEmeraldsForItem(ItemStack item, int numEmeralds, int maxUses, int xp, float priceMultiplier) {
        return offer(item, new ItemStack(Items.EMERALD, numEmeralds), maxUses, xp, priceMultiplier);
    }

    @Nullable
    public static MerchantOffer getTreasureMapForEmeralds(Entity trader, int emeraldCost, TagKey<ConfiguredStructureFeature<?, ?>> destination, String displayName, MapDecoration.Type destinationType, int maxUses, int villagerXp) {
        if (!(trader.level instanceof ServerLevel)) {
            return null;
        } else {
            ServerLevel serverlevel = (ServerLevel)trader.level;
            BlockPos blockpos = serverlevel.findNearestMapFeature(destination, trader.blockPosition(), 100, true);
            if (blockpos != null) {
                ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
                MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", destinationType);
                itemstack.setHoverName(new TranslatableComponent(displayName));
                return new MerchantOffer(new ItemStack(Items.EMERALD, emeraldCost), new ItemStack(Items.COMPASS), itemstack, maxUses, villagerXp, 0.2F);
            } else {
                return null;
            }
        }
    }
}