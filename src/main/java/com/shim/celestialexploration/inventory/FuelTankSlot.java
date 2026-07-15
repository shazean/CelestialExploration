package com.shim.celestialexploration.inventory;

import com.shim.celestialexploration.registry.CelestialItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FuelTankSlot extends SlotItemHandler {
    public FuelTankSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.getItem() == CelestialItems.LOX_TANK.get() || stack.getItem() == CelestialItems.METALLIC_HYDROGEN_TANK.get();
    }
}