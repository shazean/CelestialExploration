//package com.shim.celestialexploration.inventory;
//
//import com.shim.celestialexploration.inventory.menus.OxygenCompressorMenu;
//import net.minecraft.world.Container;
//import net.minecraft.world.inventory.AbstractFurnaceMenu;
//import net.minecraft.world.inventory.Slot;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//
//public class OxygenCompressorFuelSlot extends Slot {
//    private final OxygenCompressorMenu menu;
//
//    public OxygenCompressorFuelSlot(OxygenCompressorMenu menu, Container container, int p_39522_, int p_39523_, int p_39524_) {
//        super(container, p_39522_, p_39523_, p_39524_);
//        this.menu = menu;
//    }
//
//    public boolean mayPlace(ItemStack itemStack) {
//        return this.menu.isFuel(itemStack) || isBucket(itemStack);
//    }
//
//    public int getMaxStackSize(ItemStack itemStack) {
//        return isBucket(itemStack) ? 1 : super.getMaxStackSize(itemStack);
//    }
//
//    public static boolean isBucket(ItemStack itemStack) {
//        return itemStack.is(Items.BUCKET);
//    }
//}