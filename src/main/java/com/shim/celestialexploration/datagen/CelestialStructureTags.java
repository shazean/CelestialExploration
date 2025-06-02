package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialStructureKeys;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ConfiguredStructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CelestialStructureTags extends ConfiguredStructureTagsProvider {

    public CelestialStructureTags(DataGenerator p_211098_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_211098_, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(CelestialTags.Structures.MARS_LABYRINTH)
                .add(CelestialStructureKeys.MARS_LABYRINTH);

    }
}
