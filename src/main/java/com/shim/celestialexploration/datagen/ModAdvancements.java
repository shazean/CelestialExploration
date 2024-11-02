package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModAdvancements extends AdvancementProvider {

    public ModAdvancements(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {

        Advancement root = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.MOON_STONE.get()),
                        new TranslatableComponent("advancements.celestial.root.title"), new TranslatableComponent("advancements.celestial.root.description"),
                        new ResourceLocation(CelestialExploration.MODID, "textures/block/moon_stone.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE)).save(consumer, modLoc("root"));

        Advancement obtainSpacesuit = Advancement.Builder.advancement().display(new ItemStack(ItemRegistry.BASIC_SPACESUIT_HELMET.get()),
                        new TranslatableComponent("advancements.celestial.obtain_spacesuit.title"), new TranslatableComponent("advancements.celestial.obtain_spacesuit.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(root).addCriterion("basic_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BASIC_SPACESUIT_HELMET.get()))
                .addCriterion("basic_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BASIC_SPACESUIT_CHESTPLATE.get()))
                .addCriterion("basic_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BASIC_SPACESUIT_LEGGINGS.get()))
                .addCriterion("basic_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.BASIC_SPACESUIT_BOOTS.get())).save(consumer, modLoc("obtain_spacesuit"));

        Advancement obtainSpaceship = Advancement.Builder.advancement().display(new ItemStack(ItemRegistry.WHITE_SPACESHIP.get()),
                        new TranslatableComponent("advancements.celestial.obtain_spaceship.title"), new TranslatableComponent("advancements.celestial.obtain_spaceship.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpacesuit).addCriterion("white_spaceship", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.WHITE_SPACESHIP.get())).save(consumer, modLoc("obtain_spaceship"));

        Advancement placeAirlock = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.AIRLOCK_DOOR.get()),
                        new TranslatableComponent("advancements.celestial.place_airlock.title"), new TranslatableComponent("advancements.celestial.place_airlock.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpaceship).addCriterion("airlock_door", PlacedBlockTrigger.TriggerInstance.placedBlock(BlockRegistry.AIRLOCK_DOOR.get()))
                .addCriterion("airlock_trapdoor", PlacedBlockTrigger.TriggerInstance.placedBlock(BlockRegistry.AIRLOCK_TRAPDOOR.get())).save(consumer, modLoc("place_airlock"));

        Advancement enterSpace = Advancement.Builder.advancement().display(new ItemStack(ItemRegistry.WHITE_SPACESHIP.get()),
                        new TranslatableComponent("advancements.celestial.enter_space.title"), new TranslatableComponent("advancements.celestial.enter_space.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpaceship).addCriterion("entered_space", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.SPACE)).save(consumer, modLoc("enter_space"));

        Advancement flyIntoSun = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.SOLAR_FLARE.get()),
                        new TranslatableComponent("advancements.celestial.fly_into_sun.title"), new TranslatableComponent("advancements.celestial.fly_into_sun.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace).addCriterion("step_on_sun", EnterBlockTrigger.TriggerInstance.entersBlock(BlockRegistry.SOLAR_FLARE.get())).save(consumer, modLoc("fly_into_sun"));

        Advancement killMobInSpace = Advancement.Builder.advancement().display(new ItemStack(Items.IRON_SWORD),
                        new TranslatableComponent("advancements.celestial.kill_mob_in_space.title"), new TranslatableComponent("advancements.celestial.kill_mob_in_space.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace)
                .addCriterion("kill_lurker", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityRegistry.LURKER.get()).located(LocationPredicate.Builder.location().setDimension(DimensionRegistry.SPACE).build())))
                .addCriterion("kill_voided", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityRegistry.VOIDED.get()).located(LocationPredicate.Builder.location().setDimension(DimensionRegistry.SPACE).build())))
                .addCriterion("kill_voidfellow", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityRegistry.VOIDFELLOW.get()).located(LocationPredicate.Builder.location().setDimension(DimensionRegistry.SPACE).build())))
                .save(consumer, modLoc("kill_mob_in_space"));

        Advancement enterMoon = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.MOON_SAND.get()),
                        new TranslatableComponent("advancements.celestial.enter_moon.title"), new TranslatableComponent("advancements.celestial.enter_moon.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace).addCriterion("entered_moon", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.MOON)).save(consumer, modLoc("enter_moon"));

        Advancement enterMars = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.MARS_SAND.get()),
                    new TranslatableComponent("advancements.celestial.enter_mars.title"),
                    new TranslatableComponent("advancements.celestial.enter_mars.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(root).addCriterion("entered_moon", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.MARS)).save(consumer, modLoc("enter_mars"));

        Advancement plantPotato = Advancement.Builder.advancement().display(new ItemStack(Items.POTATO),
                        new TranslatableComponent("advancements.celestial.plant_potato.title"), new TranslatableComponent("advancements.celestial.plant_potato.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace).addCriterion("plant_potato", ItemUsedOnBlockTrigger.TriggerInstance.itemUsedOnBlock((LocationPredicate.Builder.location().setDimension(DimensionRegistry.MARS).setBlock(BlockPredicate.Builder.block().of(Blocks.DIRT).build())),
                        ItemPredicate.Builder.item().of(Items.POTATO))).save(consumer, modLoc("plant_potato"));

        Advancement enterVenus = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.VENUS_SAND.get()),
                        new TranslatableComponent("advancements.celestial.enter_venus.title"), new TranslatableComponent("advancements.celestial.enter_venus.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMars).addCriterion("entered_venus", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.VENUS)).save(consumer, modLoc("enter_venus"));

        Advancement enterMercury = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.MERCURY_SAND.get()),
                        new TranslatableComponent("advancements.celestial.enter_mercury.title"), new TranslatableComponent("advancements.celestial.enter_mercury.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterVenus).addCriterion("entered_mercury", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.MERCURY)).save(consumer, modLoc("enter_mercury"));

        Advancement enterJupiter = Advancement.Builder.advancement().display(new ItemStack(BlockRegistry.JUPITER_DEEPSLATE.get()),
                        new TranslatableComponent("advancements.celestial.enter_jupiter.title"), new TranslatableComponent("advancements.celestial.enter_jupiter.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMercury).addCriterion("entered_jupiter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionRegistry.JUPITER)).save(consumer, modLoc("enter_jupiter"));

    }

    protected String modLoc(String name) {
        return CelestialExploration.MODID + ":" + name;
    }
}