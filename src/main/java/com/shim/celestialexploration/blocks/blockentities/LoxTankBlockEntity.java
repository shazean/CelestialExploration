package com.shim.celestialexploration.blocks.blockentities;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.LoxTankBlock;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.CapabilityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class LoxTankBlockEntity extends BlockEntity {

    public LoxTankBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(BlockEntityRegistry.LOX_TANK_BLOCK_ENTITY.get(), worldPosition, blockState);
        setChanged();
    }

    private final LoxTankCapability.LoxTankHandler loxTankHandler = new LoxTankCapability.LoxTankHandler() {};
    private LazyOptional<LoxTankCapability.ILoxTank> lazyLoxHandler = LazyOptional.empty();

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityRegistry.LOX_TANK_CAPABILITY) {
            return lazyLoxHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyLoxHandler = LazyOptional.of(() -> loxTankHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyLoxHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("loxdata", loxTankHandler.getLoxData());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        loxTankHandler.setLoxData(nbt.getCompound("loxdata"));
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LoxTankBlockEntity blockEntity) {
        if (!level.isClientSide){
            state = state.setValue(LoxTankBlock.FULLNESS, blockEntity.loxTankHandler.getFullness());
            level.setBlock(pos, state, 3);
            setChanged(level, pos, state);
        }
    }
}