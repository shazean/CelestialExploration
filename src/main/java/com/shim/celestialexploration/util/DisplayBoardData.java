//package com.shim.celestialexploration.util;
//
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.blocks.DisplayBoardBlock;
//import net.minecraft.client.renderer.Sheets;
//import net.minecraft.client.resources.model.Material;
//import net.minecraft.resources.ResourceLocation;
//
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class DisplayBoardData {
//
//    public static final Map<DisplayBoardBlock.DisplayBoardColors, Material> DISPLAY_BOARD_MATERIALS = DisplayBoardBlock.DisplayBoardColors.values().collect(Collectors.toMap(Function.identity(),
//            DisplayBoardData::createDisplayBoardMaterial));
//    public static final ResourceLocation BOARD_SHEET = new ResourceLocation("textures/atlas/signs.png");
//
//
//    private static Material createDisplayBoardMaterial(DisplayBoardBlock.DisplayBoardColors p_173386_) {
//        ResourceLocation location = new ResourceLocation(p_173386_.name());
//        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(CelestialExploration.MODID, "textures/entity/displayboard/" + location.getPath()));
//    }
//
//    public static Material getDisplayBoardMaterial(DisplayBoardBlock.DisplayBoardColors p_173382_) {
//        return DISPLAY_BOARD_MATERIALS.get(p_173382_);
//    }
//}
