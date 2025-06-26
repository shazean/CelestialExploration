package com.shim.celestialexploration.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.world.renderer.DatapackSkyHandler;
import com.shim.celestialexploration.world.renderer.DimensionRenderers;
import com.shim.celestialexploration.world.renderer.StormWeatherHandler;
import com.shim.celestialexploration.world.renderer.StormWeatherParticleHandler;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;

import java.util.Map;

public class CelestialDimensionEffectsManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private static final ResourceLocation DEFAULT_MOON_TEXTURE = new ResourceLocation("minecraft", "textures/environment/moon_phases");
    private static final ResourceLocation DEFAULT_SUN_TEXTURE = new ResourceLocation("minecraft", "textures/environment/sun");

    private static final float DEFAULT_MOON_SIZE = 18.0F;
    private static final float DEFAULT_SUN_SIZE = 30.0F;

    public CelestialDimensionEffectsManager() {
        super(GSON, "celestialexploration/dimension_effects");
    }

    public ResourceLocation expandEnvironmentRL(String texture) {
        String[] resource = texture.split(":");
        String namespace = resource[0];
        String path = resource[1];

        return new ResourceLocation(namespace, "textures/environment/" + path + ".png");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> elements, ResourceManager p_10794_, ProfilerFiller p_10795_) {

//        CelestialUtil.clearDimensionLocations();

        elements.forEach((dimensionPath, element) -> {

            JsonObject json = element.getAsJsonObject();

            ResourceLocation effectsLoc = new ResourceLocation(GsonHelper.getAsString(json, "effects"));
            DatapackSkyHandler skyHandler = null;
            IWeatherRenderHandler weatherHandler;
            IWeatherParticleRenderHandler particleHandler;

            if (json.has("sky")) {
                JsonObject sky = GsonHelper.getAsJsonObject(json, "sky");

                if (!sky.isJsonNull()) {
                    String stars = GsonHelper.getAsString(sky, "stars", "none");
                    String milkyway = GsonHelper.getAsString(sky, "milkyway", "none");

                    DatapackSkyHandler.CelestialObject sun1;
                    DatapackSkyHandler.CelestialObject sun2;


                    if (sky.has("sun")) {
                        JsonObject sun = GsonHelper.getAsJsonObject(sky, "sun");
                        ResourceLocation texture = sun.has("texture") ? expandEnvironmentRL(GsonHelper.getAsString(sun, "texture")) : DEFAULT_SUN_TEXTURE;
                        float size = GsonHelper.getAsFloat(sun, "size", DEFAULT_SUN_SIZE);
                        sun1 = new DatapackSkyHandler.CelestialObject(texture, size);

                        ResourceLocation binaryStarTexture = sun.has("binary_star_texture") ? expandEnvironmentRL(GsonHelper.getAsString(sun, "binary_star_texture")) : null;
                        float binaryStarSize = GsonHelper.getAsFloat(sun, "binary_star_size", DEFAULT_SUN_SIZE);
                        sun2 = binaryStarTexture != null ? new DatapackSkyHandler.CelestialObject(binaryStarTexture, binaryStarSize) : null;

                    } else {
                        sun1 = null;
                        sun2 = null;
                    }

//                    ResourceLocation sun = sky.has("sun") ? expandEnvironmentRL(GsonHelper.getAsString(sky, "sun")) : null;
                    String ringColor = GsonHelper.getAsString(sky, "ring_color", null);
    
                    DatapackSkyHandler.CelestialObject moon1;
                    DatapackSkyHandler.CelestialObject moon2;
                    DatapackSkyHandler.CelestialObject moon3;
                    DatapackSkyHandler.CelestialObject moon4;

                    if (sky.has("moon_1")) {
                        JsonObject moon = GsonHelper.getAsJsonObject(sky, "moon_1");
                        ResourceLocation texture = moon.has("texture") ? expandEnvironmentRL(GsonHelper.getAsString(moon, "texture")) : DEFAULT_MOON_TEXTURE;
                        float size = GsonHelper.getAsFloat(moon, "size", DEFAULT_MOON_SIZE);
                        moon1 = new DatapackSkyHandler.CelestialObject(texture, size);
                    } else moon1 = null;

                    if (sky.has("moon_2")) {
                        JsonObject moon = GsonHelper.getAsJsonObject(sky, "moon_2");
                        ResourceLocation texture = moon.has("texture") ? expandEnvironmentRL(GsonHelper.getAsString(moon, "texture")) : DEFAULT_MOON_TEXTURE;
                        float size = GsonHelper.getAsFloat(moon, "size", DEFAULT_MOON_SIZE);
                        moon2 = new DatapackSkyHandler.CelestialObject(texture, size);
                    } else moon2 = null;

                    if (sky.has("moon_3")) {
                        JsonObject moon = GsonHelper.getAsJsonObject(sky, "moon_3");
                        ResourceLocation texture = moon.has("texture") ? expandEnvironmentRL(GsonHelper.getAsString(moon, "texture")) : DEFAULT_MOON_TEXTURE;
                        float size = GsonHelper.getAsFloat(moon, "size", DEFAULT_MOON_SIZE);
                        moon3 = new DatapackSkyHandler.CelestialObject(texture, size);
                    } else moon3 = null;

                    if (sky.has("moon_4")) {
                        JsonObject moon = GsonHelper.getAsJsonObject(sky, "moon_4");
                        ResourceLocation texture = moon.has("texture") ? expandEnvironmentRL(GsonHelper.getAsString(moon, "texture")) : DEFAULT_MOON_TEXTURE;
                        float size = GsonHelper.getAsFloat(moon, "size", DEFAULT_MOON_SIZE);
                        moon4 = new DatapackSkyHandler.CelestialObject(texture, size);
                    } else moon4 = null;

                    skyHandler = new DatapackSkyHandler(stars, milkyway, sun1, sun2, ringColor, moon1, moon2, moon3, moon4);

                }
            }

            String weather = GsonHelper.getAsString(json, "weather", "none");

            if (weather.equalsIgnoreCase("none")) {
                weatherHandler = null;
                particleHandler = null;
            } else if (weather.equalsIgnoreCase("dust_storms")) {
                weatherHandler = new StormWeatherHandler();
                particleHandler = new StormWeatherParticleHandler();
            } else {
                weatherHandler = (ticks, partialTick, level, minecraft, lightTexture, camX, camY, camZ) -> {};
                particleHandler = (ticks, level, minecraft, camera) -> {};
            }

            float cloudLevel = GsonHelper.getAsFloat(json, "cloud_level", Float.NaN);
            boolean hasGround = GsonHelper.getAsBoolean(json, "has_ground", true);
            DimensionSpecialEffects.SkyType skyType = json.has("sky_type")
                    ? DimensionSpecialEffects.SkyType.valueOf(GsonHelper.getAsString(json, "sky_type").toUpperCase())
                    : DimensionSpecialEffects.SkyType.NORMAL;
            boolean forceBrightLightmap = GsonHelper.getAsBoolean(json, "force_bright_lightmap", false);
            boolean constantAmbientLight = GsonHelper.getAsBoolean(json, "constant_ambientLight", false);
            boolean hasSunrise = GsonHelper.getAsBoolean(json, "has_sunrise", false);

            DimensionRenderers.DatapackSkyEffects effects = new DimensionRenderers.DatapackSkyEffects(cloudLevel, hasGround, skyType, forceBrightLightmap,
                    constantAmbientLight, hasSunrise, skyHandler, weatherHandler, particleHandler);

            DimensionSpecialEffects.EFFECTS.put(effectsLoc, effects);

        });
    }
}