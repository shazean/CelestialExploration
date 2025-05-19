package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;

public class EntityTags extends EntityTypeTagsProvider {

    public EntityTags(DataGenerator generator, String modid, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TagRegistry.Entities.FARM_ANIMALS)
                .add(EntityType.COW)
                .add(EntityType.SHEEP)
                .add(EntityType.CHICKEN)
                .add(EntityType.PIG)
                .add(EntityType.HORSE)
                .add(EntityType.MULE)
                .add(EntityType.GOAT)
                .add(EntityType.DONKEY)
                .add(EntityType.LLAMA);

        tag(TagRegistry.Entities.LOW_GRAVITY_EXEMPT)
                .add(EntityRegistry.MECHADOG.get())
                .add(EntityRegistry.MECHACERBERUS.get())
                .add(EntityRegistry.MECHACERBERUS_BOSS.get());

    }
}