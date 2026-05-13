package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DisplayBoardType extends WoodType {

    public Material material;
    public static final WoodType BLACK_TYPE = register(new DisplayBoardType(name("black")));
    public static final WoodType WHITE_TYPE = register(new DisplayBoardType(name("white")));
    public static final WoodType RED_TYPE = register(new DisplayBoardType(name("red")));
    public static final WoodType BLUE_TYPE = register(new DisplayBoardType(name("blue")));

    protected DisplayBoardType(String name) {
        super(name);
    }

    private static String name(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc).toString();
    }

}