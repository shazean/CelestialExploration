package com.shim.celestialexploration.entity.villager;

import com.google.common.collect.ImmutableMap;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import com.shim.celestialexploration.registry.VillagerRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID)
public class CelestialVillagerTrades {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
//        if (event.getType() == VillagerRegistry.ASTRONOMER.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//
//            int villagerLevel = 1;
//
//            trades.get(villagerLevel).add((trader, rand) -> getItemForEmeralds(
//                    new ItemStack(ItemRegistry.MOON_DUST.get(), 4), 1, 3, 1, 0.02F));
//        }
//
//        if (event.getType() == VillagerRegistry.ENGINEER.get()) {
//            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//
//            int villagerLevel = 1;
//
//            trades.get(villagerLevel).add((trader, rand) -> offer(
//                    new ItemStack(ItemRegistry.MOON_DUST.get(), 2), new ItemStack(Items.IRON_INGOT, 2),
//                    new ItemStack(BlockRegistry.LUNAR_LANTERN.get()), 2, 1, 0.02F));
//        }

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
}
