package com.shim.celestialexploration.inventory;

import net.minecraftforge.fluids.FluidStack;

public class SimpleFluidContainerData {
    FluidStack fluid;

    public SimpleFluidContainerData(FluidStack fluid) {
        this.fluid = fluid;
    }

    public FluidStack getFluid() {
        return fluid;
    }

    public void setFluid(FluidStack fluid) {
        this.fluid = fluid;
    }
}
