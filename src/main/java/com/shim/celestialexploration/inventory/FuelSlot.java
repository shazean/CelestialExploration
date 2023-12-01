package com.shim.celestialexploration.inventory;

import com.shim.celestialexploration.item.LoxTankItem;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FuelSlot extends SlotItemHandler {
    public FuelSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return true; //TODO make only fuel items or buckets
    }
}