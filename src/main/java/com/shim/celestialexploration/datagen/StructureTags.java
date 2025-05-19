package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.StructureKeys;
import com.shim.celestialexploration.registry.StructureRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ConfiguredStructureTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class StructureTags extends ConfiguredStructureTagsProvider {

    public StructureTags(DataGenerator p_211098_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_211098_, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(TagRegistry.Structures.MARS_LABYRINTH)
                .add(StructureKeys.MARS_LABYRINTH);

    }
}
