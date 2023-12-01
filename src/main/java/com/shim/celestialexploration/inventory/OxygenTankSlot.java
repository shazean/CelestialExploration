package com.shim.celestialexploration.inventory;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class OxygenTankSlot extends SlotItemHandler {
    public OxygenTankSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == ItemRegistry.LOX_TANK.get();
    }
}