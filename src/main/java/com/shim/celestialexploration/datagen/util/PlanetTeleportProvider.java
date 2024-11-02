package com.shim.celestialexploration.datagen.util;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class PlanetTeleportProvider implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;
    protected net.minecraftforge.common.data.ExistingFileHelper fileHelper;
    protected static String modid;

    public PlanetTeleportProvider(DataGenerator generatorIn, String modid, net.minecraftforge.common.data.ExistingFileHelper fileHelperIn) {
        this.generator = generatorIn;
        this.modid = modid;
        this.fileHelper = fileHelperIn;
    }

    public void run(HashCache cache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<PlanetTeleport> consumer = (teleport) -> {
            if (!set.add(teleport.getId())) {
                throw new IllegalStateException("Duplicate planet " + teleport.getId());
            } else {
                Path path1 = createPath(path, teleport);

                try {
                    DataProvider.save(GSON, cache, teleport.deconstruct().serializeToJson(), path1);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save planet {}", path1, ioexception);
                }

            }
        };

        register(consumer, fileHelper);
    }

    protected void register(Consumer<PlanetTeleport> consumer, net.minecraftforge.common.data.ExistingFileHelper fileHelper) {
    }

    public PlanetTeleport.SpaceCoordinates coord(int x, int z) {
        return new PlanetTeleport.SpaceCoordinates(x, z);
    }

    private static Path createPath(Path p_123971_, PlanetTeleport p_123972_) {
        return p_123971_.resolve("data/" + modid + "/" + modid + "/planets/" + p_123972_.getId().getPath() + ".json");
    }

    public String getName() {
        return "Planet Teleporters";
    }
}
