package com.shim.celestialexploration.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.world.features.AsteroidOres;
import com.shim.celestiallib.CelestialLib;
import com.shim.celestiallib.api.world.renderer.DimensionRenderers;
import com.shim.celestiallib.world.renderer.DatapackSkyHandler;
import com.shim.celestiallib.world.renderer.StormWeatherHandler;
import com.shim.celestiallib.world.renderer.StormWeatherParticleHandler;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IWeatherParticleRenderHandler;
import net.minecraftforge.client.IWeatherRenderHandler;

import java.util.Map;

public class AsteroidOresManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    public AsteroidOresManager() {
        super(GSON, "celestial/asteroid_ores");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> elements, ResourceManager p_10794_, ProfilerFiller p_10795_) {

        elements.forEach((asteroid, element) -> {

            JsonObject json = element.getAsJsonObject();
            Block ore = null;
            int weight = -1;
            float frequency = -1.0F;

            if (json.has("ore")) {
                ore = Block.byItem(GsonHelper.convertToItem(json.get("ore"), "ore"));
            } else {
                CelestialLib.LOGGER.error("asteroid ores {} is missing ore block", asteroid);
            }

            if (json.has("weight")) {
                weight = GsonHelper.getAsInt(json, "weight");
            } else {
                CelestialLib.LOGGER.error("asteroid ores {} is missing weight", asteroid);
            }

            if (json.has("frequency")) {
                frequency = GsonHelper.getAsFloat(json, "frequency");
            } else {
                CelestialLib.LOGGER.error("asteroid ores {} is missing frequency", asteroid);
            }

            CelestialExploration.LOGGER.debug("for {}, ore is {}, weight is {}, frequency is {}", asteroid, ore, weight, frequency);


            if (ore != null && weight != -1 && frequency != -1)
                AsteroidOres.addOre(ore, weight, frequency);

        });
    }
}