//package com.shim.celestialexploration.inventory.screens;
//
//import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
//import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.world.item.Item;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import java.util.Set;
//
//@OnlyIn(Dist.CLIENT)
//public class OxygenCompressorRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
//    private static final Component FILTER_NAME = new TranslatableComponent("gui.recipebook.toggleRecipes.smeltable");
//
//    protected Component getRecipeFilterName() {
//
//        return FILTER_NAME;
//    }
//
//    protected Set<Item> getFuelItems() {
//
//        return OxygenCompressorBlockEntity.getFuel().keySet();
//    }
//}