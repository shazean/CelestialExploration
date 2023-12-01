package com.shim.celestialexploration.item;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BlockMoldItem extends Item {

    public BlockMoldItem(Properties properties) {
        super(new Properties()
                .tab(CreativeModeTab.TAB_MATERIALS)
        );
    }
}
