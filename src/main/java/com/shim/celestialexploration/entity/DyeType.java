package com.shim.celestialexploration.entity;

import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum DyeType {
    BLACK(Items.BLACK_DYE, "black"),
    GREY(Items.GRAY_DYE, "grey"),
    LIGHT_GREY(Items.LIGHT_GRAY_DYE, "light_grey"),
    WHITE(Items.WHITE_DYE, "white"),
    PINK(Items.PINK_DYE, "pink"),
    MAGENTA(Items.MAGENTA_DYE, "magenta"),
    RED(Items.RED_DYE, "red"),
    BROWN(Items.BROWN_DYE, "brown"),
    ORANGE(Items.ORANGE_DYE, "orange"),
    YELLOW(Items.YELLOW_DYE, "yellow"),
    LIME(Items.LIME_DYE, "lime"),
    GREEN(Items.GREEN_DYE, "green"),
    CYAN(Items.CYAN_DYE, "cyan"),
    LIGHT_BLUE(Items.LIGHT_BLUE_DYE, "light_blue"),
    BLUE(Items.RED_DYE, "blue"),
    PURPLE(Items.RED_DYE, "purple"),
    RUST(Items.RED_DYE, "rust");

    private final String name;
    private final Item dye;

    DyeType(Item dye, String name) {
        this.name = name;
        this.dye = dye;
    }

    public String getName() {
        return this.name;
    }

    public Item getDye() {
        return this.dye;
    }

    public String toString() {
        return this.name;
    }

    public static DyeType byId(int id) {
        DyeType[] dyeType = values();
        if (id < 0 || id >= dyeType.length) {
            id = 0;
        }
        return dyeType[id];
    }

    public static DyeType byName(String name) {
        DyeType[] dyeType = values();

        for (DyeType type : dyeType) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return dyeType[0];
    }
}