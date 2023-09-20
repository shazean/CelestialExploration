package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;
import java.util.List;

public class LoxTankItem extends BlockItem {
//    public static final IntegerProperty FULLNESS = IntegerProperty.create("fullness", 0, 8);

    public LoxTankItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        super.place(blockPlaceContext);

        ItemStack item = blockPlaceContext.getItemInHand();
        Level level = blockPlaceContext.getLevel();

        LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(item, CapabilityRegistry.LOX_TANK_CAPABILITY);
        if (loxTank != null) {

            int amount = loxTank.getAmount();

            BlockPos blockPos = blockPlaceContext.getClickedPos();

            BlockEntity entity = level.getBlockEntity(blockPos);

            LoxTankCapability.ILoxTank loxTankEntity = CelestialExploration.getCapability(entity, CapabilityRegistry.LOX_TANK_CAPABILITY);
            if (loxTankEntity != null) {
                loxTankEntity.setAmount(amount);
                CelestialExploration.LOGGER.debug("Lox tank item placed!  Item lox amount was: " + loxTank.getAmount() + " and fullness was: " + loxTank.getFullness());
                CelestialExploration.LOGGER.debug("Block placed! Block lox amount is: " + loxTankEntity.getAmount() + " and fullness was: " + loxTankEntity.getFullness());
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
//        return super.place(blockPlaceContext);
    }

    @Override
    public CompoundTag getShareTag(ItemStack stackIn) {
        CompoundTag nbt = stackIn.getOrCreateTag();
        LoxTankCapability.ILoxTank loxCap = CelestialExploration.getCapability(stackIn, CapabilityRegistry.LOX_TANK_CAPABILITY);
        if (loxCap != null) {
            nbt.put("LoxData", loxCap.getLoxData());
        }
        return nbt;
    }

    @Override
    public void readShareTag(ItemStack stackIn, @Nullable CompoundTag nbtIn) {
        super.readShareTag(stackIn, nbtIn);
        if (nbtIn != null) {
            LoxTankCapability.ILoxTank loxCap = CelestialExploration.getCapability(stackIn, CapabilityRegistry.LOX_TANK_CAPABILITY);
            if (loxCap != null && nbtIn.contains("LoxData", 10)) loxCap.setLoxData(nbtIn.getCompound("LoxData"));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        LoxTankCapability.ILoxTank loxCap = CelestialExploration.getCapability(itemStack, CapabilityRegistry.LOX_TANK_CAPABILITY);

        if (loxCap != null) {
            components.add(new TextComponent(loxCap.getAmount() + " / 8000 millibuckets"));
        }
    }
}
