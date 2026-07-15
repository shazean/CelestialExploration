package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.registry.CelestialCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.List;

public class FuelTankItem extends BlockItem {

    public FuelTankItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        super.place(blockPlaceContext);

        ItemStack item = blockPlaceContext.getItemInHand();
        Level level = blockPlaceContext.getLevel();

        IFuelTank fuelTank = CelestialExploration.getCapability(item, CelestialCapabilities.FUEL_TANK_CAPABILITY);
        if (fuelTank != null) {

            int amount = fuelTank.getAmount();

            BlockPos blockPos = blockPlaceContext.getClickedPos();
            BlockEntity entity = level.getBlockEntity(blockPos);

            IFuelTank fuelTankEntity = CelestialExploration.getCapability(entity, CelestialCapabilities.FUEL_TANK_CAPABILITY);
            if (fuelTankEntity != null) {
                fuelTankEntity.setAmount(amount);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public CompoundTag getShareTag(ItemStack stackIn) {
        CompoundTag nbt = stackIn.getOrCreateTag();
        IFuelTank fuelTank = CelestialExploration.getCapability(stackIn, CelestialCapabilities.FUEL_TANK_CAPABILITY);
        if (fuelTank != null) {
            nbt.put("FuelData", fuelTank.getFuelData());
        }
        return nbt;
    }

    @Override
    public void readShareTag(ItemStack stackIn, @Nullable CompoundTag nbtIn) {
        super.readShareTag(stackIn, nbtIn);
        if (nbtIn != null) {
            IFuelTank fuelTank = CelestialExploration.getCapability(stackIn, CelestialCapabilities.FUEL_TANK_CAPABILITY);
            if (fuelTank != null && nbtIn.contains("FuelData", 10)) fuelTank.setFuelData(nbtIn.getCompound("FuelData"));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        IFuelTank fuelTank = CelestialExploration.getCapability(itemStack, CelestialCapabilities.FUEL_TANK_CAPABILITY);

        if (fuelTank != null) {
            components.add(new TextComponent(fuelTank.getAmount() + " / " + fuelTank.getTotalCapacity() + " mb"));
        }
    }
}
