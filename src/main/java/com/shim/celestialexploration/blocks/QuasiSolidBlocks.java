package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.CelestialFluids;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;

public class QuasiSolidBlocks {

    public static class Obsidian extends TemporarySolidBlock {
        public Obsidian(Properties properties) {
            super(properties);
        }

        @Override
        public LiquidBlock getFluid() {
            return (LiquidBlock) Blocks.LAVA;
        }
    }

    public static class Ice extends TemporarySolidBlock {
        public Ice(Properties properties) {
            super(properties);
        }

        @Override
        public LiquidBlock getFluid() {
            return (LiquidBlock) Blocks.WATER;
        }
    }

    public static class SulfurObsidian extends TemporarySolidBlock {
        public SulfurObsidian(Properties properties) {
            super(properties);
        }

        @Override
        public LiquidBlock getFluid() {
            return CelestialFluids.SULFUR_BLOCK.get();
        }
    }

    public static class MetallicHydrogen extends TemporarySolidBlock {
        public MetallicHydrogen(Properties properties) {
            super(properties);
        }

        @Override
        public LiquidBlock getFluid() {
            return CelestialFluids.METALLIC_HYDROGEN_BLOCK.get();
        }
    }

    public static class Nebulous extends TemporarySolidBlock {

        public Nebulous(Properties properties) {
            super(properties, true);
        }

        @Override
        public LiquidBlock getFluid() {
            return null;
        }
    }
}
