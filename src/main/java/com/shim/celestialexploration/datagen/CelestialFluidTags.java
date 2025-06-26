package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialFluids;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CelestialFluidTags extends FluidTagsProvider {
    public CelestialFluidTags(DataGenerator p_126523_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126523_, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(CelestialTags.Fluids.SULFUR)
                .add(CelestialFluids.SULFUR.get())
                .add(CelestialFluids.SULFUR_FLOWING.get());

        tag(CelestialTags.Fluids.MOLTEN_METAL)
                .add(CelestialFluids.MOLTEN_IRON.get())
                .add(CelestialFluids.MOLTEN_IRON_FLOWING.get())
                .add(CelestialFluids.MOLTEN_STEEL.get())
                .add(CelestialFluids.MOLTEN_STEEL_FLOWING.get())
                .add(CelestialFluids.MOLTEN_COPPER.get())
                .add(CelestialFluids.MOLTEN_COPPER_FLOWING.get())
                .add(CelestialFluids.MOLTEN_GOLD.get())
                .add(CelestialFluids.MOLTEN_GOLD_FLOWING.get());
    }

    @Override
    public @NotNull String getName() {
        return "Celestial Exploration fluid tags";
    }
}