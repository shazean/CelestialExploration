package com.shim.celestialexploration.util;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialDimensions;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class PlayerRenderDimension {
    private static ResourceKey<Level> dimension;

    public static void setPlayerDimension(ResourceKey<Level> dimension) {
        PlayerRenderDimension.dimension = dimension;
    }

    public static ResourceLocation getBackgroundTexture() {
        ResourceLocation texture = BG_LOCATIONS.get(dimension);
        if (texture != null) return texture;
        else return Screen.BACKGROUND_LOCATION;
    }

    private static final Map<ResourceKey<Level>, ResourceLocation> BG_LOCATIONS = Util.make(new HashMap<>(), (map) -> {
        map.put(CelestialDimensions.MILKY_WAY, textureLoc("milky_way"));
        map.put(CelestialDimensions.MOON, textureLoc("moon"));
        map.put(CelestialDimensions.MARS, textureLoc("mars"));
        map.put(CelestialDimensions.IO, textureLoc("io"));
        map.put(CelestialDimensions.EUROPA, textureLoc("moon"));
        map.put(CelestialDimensions.CALLISTO, textureLoc("moon"));
        map.put(CelestialDimensions.GANYMEDE, textureLoc("moon"));
        map.put(CelestialDimensions.MERCURY, textureLoc("mercury"));
        map.put(CelestialDimensions.VENUS, textureLoc("venus"));
        map.put(CelestialDimensions.JUPITER, textureLoc("jupiter"));

        map.put(Level.OVERWORLD, new ResourceLocation("textures/gui/options_background.png"));
    });

    private static ResourceLocation textureLoc(String texture) {
        return new ResourceLocation(CelestialExploration.MODID, "textures/gui/background/" + texture + ".png");
    }
}
