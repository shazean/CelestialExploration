package com.shim.celestialexploration.entity.vehicle;

import com.shim.celestialexploration.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public interface IAbstractMagCart {
    public static float DEFAULT_MAX_SPEED_AIR_LATERAL = 0.4f;
    public static float DEFAULT_MAX_SPEED_AIR_VERTICAL = -1.0f;
    public static double DEFAULT_AIR_DRAG = 0.95f;

    private AbstractMagCart self() {
        return (AbstractMagCart) this;
    }

    /**
     * Internal, returns the current spot to look for the attached rail.
     */
    default BlockPos getCurrentRailPosition() {
        int x = Mth.floor(self().getX());
        int y = Mth.floor(self().getY());
        int z = Mth.floor(self().getZ());
        BlockPos pos = new BlockPos(x, y, z);
        if (self().level.getBlockState(pos.below()).is(BlockRegistry.MAG_RAIL_TAG)) pos = pos.below();
        return pos;
    }

    double getMaxSpeedWithRail();

    /**
     * Moved to allow overrides.
     * This code handles minecart movement and speed capping when on a rail.
     */
    void moveMagCartOnRail(BlockPos pos);

    /**
     * Returns true if this cart can currently use rails.
     * This function is mainly used to gracefully detach a minecart from a rail.
     *
     * @return True if the minecart can use rails.
     */
    boolean canUseRail();

    /**
     * Set whether the minecart can use rails.
     * This function is mainly used to gracefully detach a minecart from a rail.
     *
     * @param use Whether the minecart can currently use rails.
     */
    void setCanUseRail(boolean use);

    /**
     * Return false if this cart should not call onMinecartPass() and should ignore Powered Rails.
     *
     * @return True if this cart should call onMinecartPass().
     */
    default boolean shouldDoRailFunctions() {
        return true;
    }

    /**
     * Returns true if this cart is self propelled.
     *
     * @return True if powered.
     */
    default boolean isPoweredCart() {
        return self().getMagCartType() == AbstractMagCart.Type.FURNACE;
    }

    /**
     * Returns true if this cart can be ridden by an Entity.
     *
     * @return True if this cart can be ridden.
     */
    default boolean canBeRidden() {
        return self().getMagCartType() == AbstractMagCart.Type.RIDEABLE;
    }

    /**
     * Returns the carts max speed when traveling on rails. Carts going faster
     * than 1.1 cause issues with chunk loading. Carts cant traverse slopes or
     * corners at greater than 0.5 - 0.6. This value is compared with the rails
     * max speed and the carts current speed cap to determine the carts current
     * max speed. A normal rail's max speed is 0.4.
     *
     * @return Carts max speed.
     */
    default float getMaxCartSpeedOnRail() {
        return 1.2f;
    }

    /**
     * Returns the current speed cap for the cart when traveling on rails. This
     * functions differs from getMaxCartSpeedOnRail() in that it controls
     * current movement and cannot be overridden. The value however can never be
     * higher than getMaxCartSpeedOnRail().
     */
    float getCurrentCartSpeedCapOnRail();

    void setCurrentCartSpeedCapOnRail(float value);

    float getMaxSpeedAirLateral();

    void setMaxSpeedAirLateral(float value);

    float getMaxSpeedAirVertical();

    void setMaxSpeedAirVertical(float value);

    double getDragAir();

    void setDragAir(double value);

    default double getSlopeAdjustment() {
        return 0.0078125D;
    }

    /**
     * Called from Detector Rails to retrieve a redstone power level for comparators.
     */
    default int getComparatorLevel() {
        return -1;
    }
}
