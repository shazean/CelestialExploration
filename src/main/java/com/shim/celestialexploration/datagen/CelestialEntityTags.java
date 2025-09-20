package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialTags;
import com.shim.celestiallib.api.world.tags.CLibTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;

public class CelestialEntityTags extends EntityTypeTagsProvider {

    public CelestialEntityTags(DataGenerator generator, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(generator, CelestialExploration.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(CelestialTags.Entities.FARM_ANIMALS)
                .add(EntityType.COW)
                .add(EntityType.SHEEP)
                .add(EntityType.CHICKEN)
                .add(EntityType.PIG)
                .add(EntityType.HORSE)
                .add(EntityType.MULE)
                .add(EntityType.GOAT)
                .add(EntityType.DONKEY)
                .add(EntityType.LLAMA);

        tag(CLibTags.EntityTypes.LOW_GRAVITY_EXEMPT)
                .add(CelestialEntities.MECHADOG.get())
                .add(CelestialEntities.MECHACERBERUS.get())
                .add(CelestialEntities.MECHACERBERUS_BOSS.get());

    }
}