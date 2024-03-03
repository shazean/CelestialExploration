package com.shim.celestialexploration.inventory;

import net.minecraft.world.Container;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class FluidSlot {
    public final FluidTank tank;
    public final Container container;
    public int index;
    public final int x;
    public final int y;
    public final int height;
    public final int width;

    public FluidSlot(FluidTank tank, Container container, int x, int y, int height, int width) {
        this.tank = tank;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.container = container;
    }

    public FluidStack getFluid() {
        return this.tank.getFluid();
    }

}
