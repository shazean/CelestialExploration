//package com.shim.celestialexploration.registry;
//
//import com.shim.celestialexploration.CelestialExploration;
//import net.minecraft.client.renderer.Sheets;
//import net.minecraft.client.resources.model.Material;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.state.properties.WoodType;
//
//public class DisplayBoardType extends WoodType {
//    public static final WoodType BLACK_TYPE = register(new DisplayBoardType("celestialexploration:black"));
//    public static final WoodType WHITE_TYPE = register(new DisplayBoardType("celestialexploration:white"));
//    public static final WoodType RED_TYPE = register(new DisplayBoardType("celestialexploration:red"));
//    public static final WoodType BLUE_TYPE = register(new DisplayBoardType("celestialexploration:blue"));
//
//    protected DisplayBoardType(String p_61842_) {
//        super(p_61842_);
//    }
//
//    public static final Material BLACK = sign("black");
//    public static final Material WHITE = sign("white");
//    public static final Material RED = sign("red");
//    public static final Material BLUE = sign("blue");
//
//    public static Material sign(String path) {
//        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(CelestialExploration.MODID, "entity/signs/" + path));
//    }
//}
