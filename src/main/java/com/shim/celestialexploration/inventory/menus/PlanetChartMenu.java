package com.shim.celestialexploration.inventory.menus;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.MenuRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;

public class PlanetChartMenu extends AbstractContainerMenu {
    private final Level level;
    private final ContainerLevelAccess access;

    public PlanetChartMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, ContainerLevelAccess.NULL);
    }

    public PlanetChartMenu(int containerId, Inventory inv, ContainerLevelAccess access) {
        super(MenuRegistry.PLANET_CHART_MENU.get(), containerId);
        this.level = inv.player.level;
        this.access = access;

    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.NULL, player, BlockRegistry.PLANET_CHART.get());
    }
}
