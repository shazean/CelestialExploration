package com.shim.celestialexploration.datagen.util;

import com.google.common.collect.Sets;
import com.google.gson.*;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class AsteroidOreProvider implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;
    protected ExistingFileHelper fileHelper;
    protected static String modid;

    public AsteroidOreProvider(DataGenerator generatorIn, String modid, ExistingFileHelper fileHelperIn) {
        this.generator = generatorIn;
        this.modid = modid;
        this.fileHelper = fileHelperIn;
    }

    public void run(HashCache cache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<AsteroidOreBuilder> consumer = (oreGen) -> {
            if (!set.add(oreGen.getId())) {
                throw new IllegalStateException("Duplicate asteroid ore " + oreGen.getId());
            } else {
                Path path1 = createPath(path, oreGen);

                try {
                    DataProvider.save(GSON, cache, oreGen.deconstruct().serializeToJson(), path1);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save asteroid ore {}", path1, ioexception);
                }
            }
        };

        register(consumer, fileHelper);
    }

    protected void register(Consumer<AsteroidOreBuilder> consumer, ExistingFileHelper fileHelper) {
    }


    private static Path createPath(Path path, AsteroidOreBuilder oreGen) {
        return path.resolve("data/" + oreGen.getId().getNamespace() + "/celestial/asteroid_ores/" + oreGen.getId().getPath() + ".json");
    }

    public String getName() {
        return "Asteroid Ore Data";
    }
}
