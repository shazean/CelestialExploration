package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class CelestialMaterials {

    public static final Material BLACK = sign("black");
    public static final Material WHITE = sign("white");
    public static final Material RED = sign("red");
    public static final Material BLUE = sign("blue");


    public static Material sign(String path) {
        return new Material(Sheets.SIGN_SHEET, new ResourceLocation(CelestialExploration.MODID, "entity/signs/" + path));
    }
}