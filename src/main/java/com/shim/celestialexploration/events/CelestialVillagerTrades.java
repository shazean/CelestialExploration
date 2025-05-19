package com.shim.celestialexploration.events;

import com.google.common.collect.ImmutableMap;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.registry.VillagerRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
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


        if (event.getType() == VillagerRegistry.ASTRONOMER.get()) {
            trades = event.getTrades();

//            int villagerLevel = 1;

            trades.get(1).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.MOON_DUST.get(), 4), 1, 12, 1, 0.05F));

            trades.get(1).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.RUSTED_IRON_NUGGET.get(), 4), 1, 12, 1, 0.05F));

            trades.get(1).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(Items.MAP), 7, 12, 1, 0.02F));

            trades.get(2).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.SULFUR_CRYSTAL.get(), 4), 1, 12, 2, 0.05F));

            trades.get(2).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.CINNABAR.get(), 4), 1, 12, 2, 0.05F));

            trades.get(2).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(BlockRegistry.LUNAR_LANTERN.get()), 5, 12, 15, 0.05F));

            trades.get(2).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(BlockRegistry.MARS_LANTERN.get()), 5, 12, 15, 0.05F));

            trades.get(2).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(BlockRegistry.MERCURY_LANTERN.get()), 5, 12, 15, 0.05F));

            trades.get(2).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(BlockRegistry.VENUS_LANTERN.get()), 5, 12, 15, 0.05F));


        }

        if (event.getType() == VillagerRegistry.ENGINEER.get()) {
            trades = event.getTrades();

            trades.get(1).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(Items.COAL, 15), 1, 16, 2, 0.05F));

            trades.get(1).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.BASIC_SPACESUIT_HELMET.get()), 5, 12, 2, 0.2F));

            trades.get(1).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.BASIC_SPACESUIT_CHESTPLATE.get()), 9, 12, 2, 0.2F));

            trades.get(1).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.BASIC_SPACESUIT_LEGGINGS.get()), 7, 12, 2, 0.2F));

            trades.get(1).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.BASIC_SPACESUIT_BOOTS.get()), 4, 12, 2, 0.2F));

            trades.get(2).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.STEEL_INGOT.get()), 6, 12, 10, 0.05F));

            trades.get(2).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.BAUXITE_INGOT.get()), 4, 12, 10, 0.05F));

            trades.get(2).add((trader, rand) -> getEmeraldsForItem(
                    new ItemStack(ItemRegistry.ALUMINUM_INGOT.get()), 6, 12, 10, 0.05F));

            trades.get(3).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.MAGCART.get()), 5, 12, 4, 0.2F));

            trades.get(3).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(BlockRegistry.MAG_RAIL.get()), 3, 12, 4, 0.2F));

            trades.get(3).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.THERMAL_SPACESUIT_BOOTS.get()), 7, 3, 15, 0.2F));

            trades.get(3).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.HEAVY_DUTY_SPACESUIT_BOOTS.get()), 7, 3, 15, 0.2F));

            trades.get(4).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.SPACESHIP_CABIN.get()), 20, 5, 12, 0.2F));

            trades.get(4).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.SPACESHIP_FRAME.get()), 20, 5, 12, 0.2F));

            trades.get(4).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.SPACESHIP_ENGINE.get()), 20, 5, 12, 0.2F));

            trades.get(4).add((trader, rand) -> getItemForEmeralds(
                    new ItemStack(ItemRegistry.LOX_TANK.get()), 10, 5, 4, 0.2F));

            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.ADVANCED_SPACESUIT_HELMET.get()), 8, 3, 15, 0.2F));

            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.ADVANCED_SPACESUIT_CHESTPLATE.get()), 16, 3, 15, 0.2F));

            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.ADVANCED_SPACESUIT_LEGGINGS.get()), 14, 3, 15, 0.2F));

            trades.get(5).add((trader, rand) -> getEnchantedItemForEmeralds(
                    new ItemStack(ItemRegistry.ADVANCED_SPACESUIT_BOOTS.get()), 8, 3, 15, 0.2F));

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