package com.shim.celestialexploration.util;

import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialFluids;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.HashMap;
import java.util.Map;

public class SolidifiedFluids {

    private static final Map<Fluid, Block> FLUID_TO_SOLID_BLOCK = Util.make(new HashMap<>(), (map) -> {
        map.put(Fluids.LAVA, CelestialBlocks.QUASI_SOLID_OBSIDIAN.get());
        map.put(Fluids.WATER, Blocks.FROSTED_ICE);
        map.put(CelestialFluids.SULFUR.get(), CelestialBlocks.QUASI_SOLID_SULFUR_OBSIDIAN.get());
        map.put(CelestialFluids.METALLIC_HYDROGEN.get(), CelestialBlocks.QUASI_SOLID_METALLIC_HYDROGEN.get());

    });

    public static void addToMap(Fluid fluid, Block solid) {
        FLUID_TO_SOLID_BLOCK.put(fluid, solid);
    }

    public static Block getSolidBlock(Fluid fluid) {
        Block block = FLUID_TO_SOLID_BLOCK.get(fluid);
        if (block != null) {
            return block;
        } else
            return CelestialBlocks.QUASI_SOLID_NEBULOUS_BLOCK.get();
    }
}
