package com.shim.celestialexploration.item;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import javax.annotation.Nullable;
import java.util.List;

public class LoxTankItem extends BlockItem {

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
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void onDestroyed(ItemEntity p_150700_) {

        CelestialExploration.LOGGER.debug("hello? onDestroyed?");

        System.out.println("Hello is my logger working?");

        if (this.getBlock() instanceof LoxTankBlock) {
            ItemStack itemStack = p_150700_.getItem();

            CompoundTag compoundtag = getBlockEntityData(itemStack);
            CelestialExploration.LOGGER.debug("Lox block destroying!");

            if (compoundtag != null && compoundtag.contains("ForgeCaps")) {
                CelestialExploration.LOGGER.debug("We found a thing?");
            }

//            LoxTankCapability.ILoxTank loxTankEntity = CelestialExploration.getCapability(blockEntity, CapabilityRegistry.LOX_TANK_CAPABILITY);
//            if (loxTankEntity != null) {
//                int amount = loxTankEntity.getAmount();
//
//                LoxTankCapability.ILoxTank loxTank = CelestialExploration.getCapability(itemStack, CapabilityRegistry.LOX_TANK_CAPABILITY);
//                if (loxTank != null) {
//                    loxTank.setAmount(amount);
//                    CelestialExploration.LOGGER.debug("item lox amount: " + loxTank.getAmount());
//                }
//        }

//            CompoundTag compoundtag = getBlockEntityData(itemstack);
//            if (compoundtag != null && compoundtag.contains("Items", 9)) {
//                ListTag listtag = compoundtag.getList("Items", 10);
//                ItemUtils.onContainerDestroyed(p_150700_, listtag.stream().map(CompoundTag.class::cast).map(ItemStack::of));
//            }

        }
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
