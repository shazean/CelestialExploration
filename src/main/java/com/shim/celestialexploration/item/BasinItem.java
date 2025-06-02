package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasinItem extends Item {

//    protected FluidHandlerItemStack fluidHandler;
//    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.of(() -> fluidHandler);


    public BasinItem(Properties p_41383_) {
        super(p_41383_);
    }

//    public boolean addFluid(FluidStack fluid) {
//        return this.fluidHandler.fill(fluid, IFluidHandler.FluidAction.EXECUTE) > 0;
//    }
//
//    public FluidStack getFluid() {
//        return fluidHandler.getFluid();
//    }
//
//    public FluidHandlerItemStack getFluidHandler() {
//        return fluidHandler;
//    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if (this.getClass() == BasinItem.class)
            return new FluidHandlerItemStack(stack, 4000);
        else
            return super.initCapabilities(stack, nbt);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, components, tooltipFlag);

        IFluidHandlerItem cap = CelestialExploration.getCapability(stack, CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY);

        if (cap != null) {
            if (!cap.getFluidInTank(0).isEmpty()) {
                components.add(cap.getFluidInTank(0).getDisplayName());
                components.add(new TextComponent(cap.getFluidInTank(0).getAmount() + " / " + cap.getTankCapacity(0) + " mb"));
            }
        }

    }
}