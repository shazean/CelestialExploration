package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.FluidRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FluidTags extends FluidTagsProvider {
    public FluidTags(DataGenerator p_126523_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126523_, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TagRegistry.Fluids.SULFUR)
                .add(FluidRegistry.SULFUR.get())
                .add(FluidRegistry.SULFUR_FLOWING.get());

        tag(TagRegistry.Fluids.MOLTEN_METAL)
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