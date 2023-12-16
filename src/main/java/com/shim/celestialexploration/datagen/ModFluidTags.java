package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModFluidTags extends FluidTagsProvider {
    public ModFluidTags(DataGenerator p_126523_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126523_, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(FluidRegistry.SULFUR_TAG)
                .add(FluidRegistry.SULFUR.get())
                .add(FluidRegistry.SULFUR_FLOWING.get());

        tag(FluidRegistry.MOLTEN_METAL_TAG)
                .add(FluidRegistry.MOLTEN_IRON.get())
                .add(FluidRegistry.MOLTEN_IRON_FLOWING.get())
                .add(FluidRegistry.MOLTEN_STEEL.get())
                .add(FluidRegistry.MOLTEN_STEEL_FLOWING.get())
                .add(FluidRegistry.MOLTEN_COPPER.get())
                .add(FluidRegistry.MOLTEN_COPPER_FLOWING.get())
                .add(FluidRegistry.MOLTEN_GOLD.get())
                .add(FluidRegistry.MOLTEN_GOLD_FLOWING.get());
    }

    @Override
    public @NotNull String getName() {
        return "Celestial Exploration fluid tags";
    }
}