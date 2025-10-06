package com.shim.celestialexploration.datagen;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.registry.CelestialDimensions;
import com.shim.celestialexploration.registry.CelestialEntities;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class CelestialAdvancements extends AdvancementProvider {

    public CelestialAdvancements(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {

        Advancement root = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.MOON_STONE.get()),
                        new TranslatableComponent("advancements.celestialexploration.root.title"), new TranslatableComponent("advancements.celestialexploration.root.description"),
                        new ResourceLocation(CelestialExploration.MODID, "textures/block/moon_stone.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE)).save(consumer, modLoc("root"));

        Advancement obtainSpacesuit = Advancement.Builder.advancement().display(new ItemStack(CelestialItems.BASIC_SPACESUIT_HELMET.get()),
                        new TranslatableComponent("advancements.celestialexploration.obtain_spacesuit.title"), new TranslatableComponent("advancements.celestialexploration.obtain_spacesuit.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(root).addCriterion("basic_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BASIC_SPACESUIT_HELMET.get()))
                .addCriterion("basic_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BASIC_SPACESUIT_CHESTPLATE.get()))
                .addCriterion("basic_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BASIC_SPACESUIT_LEGGINGS.get()))
                .addCriterion("basic_boots", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BASIC_SPACESUIT_BOOTS.get())).save(consumer, modLoc("obtain_spacesuit"));

        Advancement obtainSpaceship = Advancement.Builder.advancement().display(new ItemStack(CelestialItems.WHITE_SPACESHIP.get()),
                        new TranslatableComponent("advancements.celestialexploration.obtain_spaceship.title"), new TranslatableComponent("advancements.celestialexploration.obtain_spaceship.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpacesuit).addCriterion("white_spaceship", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.WHITE_SPACESHIP.get())).save(consumer, modLoc("obtain_spaceship"));

        Advancement placeAirlock = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.AIRLOCK_DOOR.get()),
                        new TranslatableComponent("advancements.celestialexploration.place_airlock.title"), new TranslatableComponent("advancements.celestialexploration.place_airlock.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpaceship).addCriterion("airlock_door", PlacedBlockTrigger.TriggerInstance.placedBlock(CelestialBlocks.AIRLOCK_DOOR.get()))
                .addCriterion("airlock_trapdoor", PlacedBlockTrigger.TriggerInstance.placedBlock(CelestialBlocks.AIRLOCK_TRAPDOOR.get())).save(consumer, modLoc("place_airlock"));

        Advancement enterSpace = Advancement.Builder.advancement().display(new ItemStack(CelestialItems.WHITE_SPACESHIP.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_milky_way.title"), new TranslatableComponent("advancements.celestialexploration.enter_milky_way.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainSpaceship).addCriterion("entered_milky_way", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.MILKY_WAY)).save(consumer, modLoc("enter_milky_way"));

        Advancement flyIntoSun = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.SOLAR_FLARE.get()),
                        new TranslatableComponent("advancements.celestialexploration.fly_into_sun.title"), new TranslatableComponent("advancements.celestialexploration.fly_into_sun.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace)
                .addCriterion("step_on_sun", EnterBlockTrigger.TriggerInstance.entersBlock(CelestialBlocks.SOLAR_FLARE.get())).save(consumer, modLoc("fly_into_sun"));

        Advancement killMobInSpace = Advancement.Builder.advancement().display(new ItemStack(Items.IRON_SWORD),
                        new TranslatableComponent("advancements.celestialexploration.kill_mob_in_space.title"), new TranslatableComponent("advancements.celestialexploration.kill_mob_in_space.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace)
                .addCriterion("kill_lurker", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CelestialEntities.LURKER.get()).located(LocationPredicate.Builder.location().setDimension(CelestialDimensions.MILKY_WAY).build())))
                .addCriterion("kill_voided", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CelestialEntities.VOIDED.get()).located(LocationPredicate.Builder.location().setDimension(CelestialDimensions.MILKY_WAY).build())))
                .addCriterion("kill_voidfellow", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CelestialEntities.VOIDFELLOW.get()).located(LocationPredicate.Builder.location().setDimension(CelestialDimensions.MILKY_WAY).build())))
                .save(consumer, modLoc("kill_mob_in_space"));

        Advancement enterMoon = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.MOON_SAND.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_moon.title"), new TranslatableComponent("advancements.celestialexploration.enter_moon.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace)
                .addCriterion("entered_moon", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.MOON)).save(consumer, modLoc("enter_moon"));

        Advancement enterMars = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.MARS_SAND.get()),
                    new TranslatableComponent("advancements.celestialexploration.enter_mars.title"),
                    new TranslatableComponent("advancements.celestialexploration.enter_mars.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(root).addCriterion("entered_moon", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.MARS)).save(consumer, modLoc("enter_mars"));

        Advancement plantPotato = Advancement.Builder.advancement().display(new ItemStack(Items.POTATO),
                        new TranslatableComponent("advancements.celestialexploration.plant_potato.title"), new TranslatableComponent("advancements.celestialexploration.plant_potato.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterSpace)
                .addCriterion("plant_potato", ItemUsedOnBlockTrigger.TriggerInstance.itemUsedOnBlock((LocationPredicate.Builder.location().setDimension(CelestialDimensions.MARS).setBlock(BlockPredicate.Builder.block().of(Blocks.DIRT).build())),
                        ItemPredicate.Builder.item().of(Items.POTATO))).save(consumer, modLoc("plant_potato"));

        Advancement enterVenus = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.VENUS_SAND.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_venus.title"), new TranslatableComponent("advancements.celestialexploration.enter_venus.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMars).addCriterion("entered_venus", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.VENUS)).save(consumer, modLoc("enter_venus"));

        Advancement enterMercury = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.MERCURY_SAND.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_mercury.title"), new TranslatableComponent("advancements.celestialexploration.enter_mercury.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterVenus).addCriterion("entered_mercury", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.MERCURY)).save(consumer, modLoc("enter_mercury"));

        Advancement enterJupiter = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.JUPITER_DEEPSLATE.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_jupiter.title"), new TranslatableComponent("advancements.celestialexploration.enter_jupiter.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMercury).addCriterion("entered_jupiter", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.JUPITER)).save(consumer, modLoc("enter_jupiter"));

        Advancement enterEuropa = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.EUROPA_BRICKS.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_europa.title"), new TranslatableComponent("advancements.celestialexploration.enter_europa.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterJupiter).addCriterion("entered_europa", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.EUROPA)).save(consumer, modLoc("enter_europa"));

        Advancement enterCallisto = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.CALLISTO_BRICKS.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_callisto.title"), new TranslatableComponent("advancements.celestialexploration.enter_callisto.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMercury).addCriterion("entered_callisto", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.CALLISTO)).save(consumer, modLoc("enter_callisto"));

        Advancement enterIo = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.IO_BRICKS.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_io.title"), new TranslatableComponent("advancements.celestialexploration.enter_io.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMercury).addCriterion("entered_io", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.IO)).save(consumer, modLoc("enter_io"));

        Advancement enterGanymede = Advancement.Builder.advancement().display(new ItemStack(CelestialBlocks.GANYMEDE_BRICKS.get()),
                        new TranslatableComponent("advancements.celestialexploration.enter_ganymede.title"), new TranslatableComponent("advancements.celestialexploration.enter_ganymede.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(enterMercury).addCriterion("entered_ganymede", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(CelestialDimensions.GANYMEDE)).save(consumer, modLoc("enter_ganymede"));

        Advancement obtainAllMechaDogs = Advancement.Builder.advancement().display(new ItemStack(CelestialItems.WHITE_MECHADOG.get()),
                        new TranslatableComponent("advancements.celestialexploration.all_mechadogs.title"), new TranslatableComponent("advancements.celestialexploration.all_mechadogs.description"),
                        null, FrameType.TASK, true, true, false)
                .parent(root).addCriterion("white", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.WHITE_MECHADOG.get()))
                .addCriterion("light_grey", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.LIGHT_GREY_MECHADOG.get()))
                .addCriterion("grey", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.GREY_MECHADOG.get()))
                .addCriterion("black", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BLACK_MECHADOG.get()))
                .addCriterion("purple", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.PURPLE_MECHADOG.get()))
                .addCriterion("blue", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BLUE_MECHADOG.get()))
                .addCriterion("light_blue", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.LIGHT_BLUE_MECHADOG.get()))
                .addCriterion("cyan", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.CYAN_MECHADOG.get()))
                .addCriterion("green", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.GREEN_MECHADOG.get()))
                .addCriterion("lime", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.LIME_MECHADOG.get()))
                .addCriterion("yellow", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.YELLOW_MECHADOG.get()))
                .addCriterion("orange", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.ORANGE_MECHADOG.get()))
                .addCriterion("red", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.RED_MECHADOG.get()))
                .addCriterion("pink", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.PINK_MECHADOG.get()))
                .addCriterion("magenta", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.MAGENTA_MECHADOG.get()))
                .addCriterion("brown", InventoryChangeTrigger.TriggerInstance.hasItems(CelestialItems.BROWN_MECHADOG.get()))
                .save(consumer, modLoc("all_mechadogs"));


    }

    protected String modLoc(String name) {
        return CelestialExploration.MODID + ":" + name;
    }
}