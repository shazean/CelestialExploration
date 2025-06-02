package com.shim.celestialexploration.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CelestialTabs {

    public static final CreativeModeTab CELESTIAL_BLOCKS_TAB = new CreativeModeTab("celestial_blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CelestialBlocks.MOON_STONE.get());
        }
    };

    public static final CreativeModeTab CELESTIAL_MISC_TAB = new CreativeModeTab("celestial_misc_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CelestialItems.MOON_DUST.get());
        }
    };

    public static final CreativeModeTab SPACESHIP_TAB = new CreativeModeTab("spaceship_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CelestialItems.WHITE_SPACESHIP.get());
        }
    };
}