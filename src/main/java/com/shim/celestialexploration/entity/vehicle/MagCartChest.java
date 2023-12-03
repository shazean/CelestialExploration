package com.shim.celestialexploration.entity.vehicle;

import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MagCartChest extends AbstractMagCartContainer {
    public MagCartChest(EntityType<? extends MagCartChest> p_38487_, Level p_38488_) {
        super(p_38487_, p_38488_);
    }

    public MagCartChest(Level p_38490_, double p_38491_, double p_38492_, double p_38493_) {
        super(EntityRegistry.CHEST_MAGCART.get(), p_38491_, p_38492_, p_38493_, p_38490_);
    }

    public void destroy(DamageSource p_38499_) {
        super.destroy(p_38499_);
        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.spawnAtLocation(Blocks.CHEST);
        }

    }

    public int getContainerSize() {
        return 27;
    }

    public AbstractMagCart.Type getMagCartType() {
        return AbstractMagCart.Type.CHEST;
    }

    public BlockState getDefaultDisplayBlockState() {
        return Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }

    public int getDefaultDisplayOffset() {
        return 8;
    }

    public AbstractContainerMenu createMenu(int p_38496_, Inventory p_38497_) {
        return ChestMenu.threeRows(p_38496_, p_38497_, this);
    }
}