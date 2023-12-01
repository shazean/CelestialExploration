package com.shim.celestialexploration.inventory.containers;

import com.shim.celestialexploration.inventory.menus.WorkbenchMenu;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class WorkbenchCraftingContainer implements Container, StackedContentsCompatible {
    private final NonNullList<ItemStack> items;
    private final int width;
    private final int height;
    private final WorkbenchMenu menu;
    private final FluidTank tank;

    public WorkbenchCraftingContainer(WorkbenchMenu menu, int width, int height, FluidTank tank) {
        this.items = NonNullList.withSize(width * height, ItemStack.EMPTY);
        this.menu = menu;
        this.width = width;
        this.height = height;
        this.tank = tank;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        if (!tank.isEmpty()) return false;

        return true;
    }

    public ItemStack getItem(int p_39332_) {
        return p_39332_ >= this.getContainerSize() ? ItemStack.EMPTY : this.items.get(p_39332_);
    }

    public ItemStack removeItemNoUpdate(int p_39344_) {
        return ContainerHelper.takeItem(this.items, p_39344_);
    }

    public ItemStack removeItem(int p_39334_, int p_39335_) {
        ItemStack itemstack = ContainerHelper.removeItem(this.items, p_39334_, p_39335_);
        if (!itemstack.isEmpty()) {
            this.menu.slotsChanged(this);
        }

        return itemstack;
    }

    public FluidTank getTank() {
        return tank;
    }

    public int getFluidAmount() {
        return tank.getFluidAmount();
    }

    public void setFluidAmount(int amount) {
        this.menu.setFluidAmount(amount);
    }

    public FluidStack removeFluid(int amount) { //??
        return tank.drain(amount, IFluidHandler.FluidAction.EXECUTE);
    }

    public void setItem(int p_39337_, ItemStack p_39338_) {
        this.items.set(p_39337_, p_39338_);
        this.menu.slotsChanged(this);
    }

    public void setChanged() {
    }

    public boolean stillValid(Player p_39340_) {
        return true;
    }

    public void clearContent() {
        this.items.clear();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void fillStackedContents(StackedContents p_39342_) {
        for(ItemStack itemstack : this.items) {
            p_39342_.accountSimpleStack(itemstack);
        }

    }
}