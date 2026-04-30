package com.shim.celestialexploration.datagen.util;

import com.google.common.collect.Sets;
import com.google.gson.*;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestiallib.api.world.galaxy.Galaxy;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class StructureProvider implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;
    protected ExistingFileHelper fileHelper;

    public StructureProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        this.generator = generator;
        this.fileHelper = fileHelper;
    }

    @Override
    public void run(HashCache cache) {
        Path outputFolder = this.generator.getOutputFolder();
        Set<ResourceLocation> structureSets = Sets.newHashSet();
        Consumer<StructureSetGen> structureSetConsumer = (structureSet) -> {
            if (!structureSets.add(structureSet.getId())) {
                throw new IllegalStateException("Duplicate structure set " + structureSet.getId());
            } else {
                Path path = createPath(outputFolder, structureSet);

                try {
                    DataProvider.save(GSON, cache, structureSet.serializeToJson(), path);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save structure set {}", path, ioexception);
                }
            }
        };

        registerStructureSets(structureSetConsumer, fileHelper);

        Set<ResourceLocation> templatePoolSets = Sets.newHashSet();
        Consumer<TemplatePoolGen> templatePoolConsumer = (templatePoolSet) -> {
            if (!templatePoolSets.add(templatePoolSet.getId())) {
                throw new IllegalStateException("Duplicate template pool " + templatePoolSet.getId());
            } else {
                Path path = createPath(outputFolder, templatePoolSet);

                try {
                    DataProvider.save(GSON, cache, templatePoolSet.serializeToJson(), path);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save template pool {}", path, ioexception);
                }
            }
        };

        registerTemplatePools(templatePoolConsumer, fileHelper);

        Set<ResourceLocation> configuredStructuresSets = Sets.newHashSet();
        Consumer<ConfiguredStructureFeatureGen> configuredStructuresConsumer = (configuredStructuresSet) -> {
            if (!configuredStructuresSets.add(configuredStructuresSet.getId())) {
                throw new IllegalStateException("Duplicate configured structure feature " + configuredStructuresSet.getId());
            } else {
                Path path = createPath(outputFolder, configuredStructuresSet);

                try {
                    DataProvider.save(GSON, cache, configuredStructuresSet.deconstruct().serializeToJson(), path);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save configured structure features {}", path, ioexception);
                }
            }
        };

        registerConfiguredStructures(configuredStructuresConsumer, fileHelper);

        Set<ResourceLocation> processorListSets = Sets.newHashSet();
        Consumer<ProcessorListGen> processorListConsumer = (processorListSet) -> {
            if (!processorListSets.add(processorListSet.getId())) {
                throw new IllegalStateException("Duplicate processor list " + processorListSet.getId());
            } else {
                Path path = createPath(outputFolder, processorListSet);

                try {
                    DataProvider.save(GSON, cache, processorListSet.serializeToJson(), path);
                } catch (IOException ioexception) {
                    LOGGER.error("Couldn't save processor list {}", path, ioexception);
                }
            }
        };

        registerProcessorList(processorListConsumer, fileHelper);

    }

    private static Path createPath(Path path, StructureSetGen structureSet) { return path.resolve("data/" + structureSet.getId().getNamespace() + "/worldgen/structure_set/" + structureSet.getId().getPath() + ".json");	}
    private static Path createPath(Path path, TemplatePoolGen templatePool) { return path.resolve("data/" + templatePool.getId().getNamespace() + "/worldgen/template_pool/" + templatePool.getId().getPath() + ".json");	}
    private static Path createPath(Path path, ConfiguredStructureFeatureGen configuredStructure) { return path.resolve("data/" + configuredStructure.getId().getNamespace() + "/worldgen/configured_structure_feature/" + configuredStructure.getId().getPath() + ".json");	}
    private static Path createPath(Path path, ProcessorListGen processorList) { return path.resolve("data/" + processorList.getId().getNamespace() + "/worldgen/processor_list/" + processorList.getId().getPath() + ".json");	}

    protected void registerStructureSets(Consumer<StructureSetGen> consumer, ExistingFileHelper fileHelper) {}
    protected void registerTemplatePools(Consumer<TemplatePoolGen> consumer, ExistingFileHelper fileHelper) {}
    protected void registerConfiguredStructures(Consumer<ConfiguredStructureFeatureGen> consumer, ExistingFileHelper fileHelper) {}
    protected void registerProcessorList(Consumer<ProcessorListGen> consumer, ExistingFileHelper fileHelper) {}

    protected StructureSetGen registerStructureSet(StructureFeature<?> structure, long salt, int spacing, int separation, Pair<ResourceLocation, Integer>... structuresAndWeight) {
        return new StructureSetGen(new ResourceLocation(structure.getRegistryName().getNamespace(), structure.getRegistryName().getPath()), salt, spacing, separation, structuresAndWeight);
    }

    protected TemplatePoolGen registerTemplatePool(ResourceLocation name, ResourceLocation fallback, Pair<TemplatePoolGen.Element, Integer>... structuresAndWeight) {
        return new TemplatePoolGen(name, fallback, structuresAndWeight);
    }

    protected TemplatePoolGen registerTemplatePool(ResourceLocation name, Pair<TemplatePoolGen.Element, Integer>... structuresAndWeight) {
        return registerTemplatePool(name, new ResourceLocation("empty"), structuresAndWeight);
    }

    protected ConfiguredStructureFeatureGen.Builder registerStructureFeature() {
        return ConfiguredStructureFeatureGen.builder();
    }

    protected ProcessorListGen registerProcessorRules(ResourceLocation name, List<RuleProcessor> processorRules) {
        return new ProcessorListGen(name, processorRules);
    }


    @Override
    public String getName() {
        return "Celestial Exploration Structures";
    }

    protected static class StructureSetGen {

        private final List<Pair<ResourceLocation, Integer>> structures;
        private final ResourceLocation location;
        private final long salt;
        private final int spacing;
        private final int separation;

        protected StructureSetGen(ResourceLocation location, long salt, int spacing, int separation, Pair<ResourceLocation, Integer>... structuresAndWeight) {
            this.location = location;
            this.salt = salt;
            this.spacing = spacing;
            this.separation = separation;

            ArrayList<Pair<ResourceLocation, Integer>> list = new ArrayList<>();
            Collections.addAll(list, structuresAndWeight);
            this.structures = list;
        }

        public ResourceLocation getId() {
            return this.location;
        }

        public StructureSetGen save(Consumer<StructureSetGen> consumer) {
            consumer.accept(this);
            return this;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();

            JsonArray structuresJsonArray = new JsonArray();

            for (Pair<ResourceLocation, Integer> pair : this.structures) {
                JsonObject structureJson = new JsonObject();
                structureJson.addProperty("structure", pair.getFirst().toString());
                structureJson.addProperty("weight", pair.getSecond());

                structuresJsonArray.add(structureJson);
            }

            json.add("structures", structuresJsonArray);

            JsonObject placementJson = new JsonObject();

            placementJson.addProperty("salt", this.salt);
            placementJson.addProperty("spacing", this.spacing);
            placementJson.addProperty("separation", this.separation);
            placementJson.addProperty("type", "minecraft:random_spread");

            json.add("placement", placementJson);

            return json;
        }
    }

    protected static class TemplatePoolGen {

        private final ResourceLocation location;
        private final ResourceLocation fallback;
        private final List<Pair<Element, Integer>> elements;

        protected TemplatePoolGen(ResourceLocation location, ResourceLocation fallback, Pair<Element, Integer>... structuresAndWeight) {
            this.location = location;
            this.fallback = fallback;

            ArrayList<Pair<Element, Integer>> list = new ArrayList<>();
            Collections.addAll(list, structuresAndWeight);
            this.elements = list;
        }

        public ResourceLocation getId() {
            return this.location;
        }

        public TemplatePoolGen save(Consumer<TemplatePoolGen> consumer) {
            consumer.accept(this);
            return this;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();

            json.addProperty("name", this.location.toString());
            json.addProperty("fallback", this.fallback.toString());

            JsonArray elementsJsonArray = new JsonArray();

            for (Pair<Element, Integer> pair : this.elements) {
                JsonObject elementJson = new JsonObject();
                elementJson.addProperty("weight", pair.getSecond());
                elementJson.add("element", pair.getFirst().toJson());

                elementsJsonArray.add(elementJson);
            }

            json.add("elements", elementsJsonArray);

            return json;
        }

        public record Element(ResourceLocation location, ResourceLocation processor, StructureTemplatePool.Projection projection) {

            public JsonObject toJson() {
                JsonObject json = new JsonObject();

                json.addProperty("location", location().toString());
                json.addProperty("processors", processor().toString());
                json.addProperty("projection", projection.getName());
                json.addProperty("element_type", "minecraft:single_pool_element");

                return json;
            }
        }
    }

    protected static class ConfiguredStructureFeatureGen {

        private final ResourceLocation location;
        private final ResourceLocation startPool;
        private final int size;
        private int x;
        private int z;
        @Nullable
        private final ResourceLocation galaxyDimension;
        private final ResourceLocation biomeTag;
        private final boolean adaptNoise;
        private final StructureFeature<?> type;
        //TODO add spawn overrides
        private final boolean emptyMonsterSpawns;

        protected ConfiguredStructureFeatureGen(ResourceLocation location, ResourceLocation startPool, int size, ResourceLocation biomeTag, boolean adaptNoise, StructureFeature<?> type, boolean emptyMonsterSpawns) {
            this.location = location;
            this.startPool = startPool;
            this.size = size;
            this.galaxyDimension = null;
            this.biomeTag = biomeTag;
            this.adaptNoise = adaptNoise;
            this.type = type;
            this.emptyMonsterSpawns = emptyMonsterSpawns;
        }

        protected ConfiguredStructureFeatureGen(ResourceLocation location, ResourceLocation startPool, int size, int x, int z, ResourceLocation galaxyDimension, ResourceLocation biomeTag, boolean adaptNoise, StructureFeature<?> type, boolean emptyMonsterSpawns) {
            this.location = location;
            this.startPool = startPool;
            this.size = size;
            this.x = x;
            this.z = z;
            this.galaxyDimension = galaxyDimension;
            this.biomeTag = biomeTag;
            this.adaptNoise = adaptNoise;
            this.type = type;
            this.emptyMonsterSpawns = emptyMonsterSpawns;
        }

        public ConfiguredStructureFeatureGen.Builder deconstruct() {
            return new ConfiguredStructureFeatureGen.Builder(this.startPool, this.size, this.x, this.z, this.galaxyDimension, this.biomeTag, this.adaptNoise, this.type, this.emptyMonsterSpawns);
        }

        public static ConfiguredStructureFeatureGen.Builder builder() {
            return new ConfiguredStructureFeatureGen.Builder();
        }

        public ResourceLocation getId() {
            return this.location;
        }


        public static class Builder {
            private ResourceLocation startPool;
            private int size;
            int x;
            int z;
            ResourceLocation galaxyDimension;
            private ResourceLocation biomeTag;
            private boolean adaptNoise = false;
            private StructureFeature<?> type;
            private boolean emptyMonsterSpawns = false;

            private Builder() {}

            public Builder(ResourceLocation startPool, int size, int x, int z, ResourceLocation galaxyDimension, ResourceLocation biomeTag, boolean adaptNoise, StructureFeature<?> type, boolean emptyMonsterSpawns) {
                this.startPool = startPool;
                this.size = size;
                this.x = x;
                this.z = z;
                this.galaxyDimension = galaxyDimension;
                this.biomeTag = biomeTag;
                this.adaptNoise = adaptNoise;
                this.type = type;
                this.emptyMonsterSpawns = emptyMonsterSpawns;
            }

            public Builder jigsawConfig(ResourceLocation startPool, int size) {
                this.startPool = startPool;
                this.size = size;
                return this;
            }

            public Builder planetConfig(ResourceLocation startPool, int size, int x, int z, Galaxy galaxy) {
                this.startPool = startPool;
                this.size = size;
                this.x = x;
                this.z = z;
                this.galaxyDimension = galaxy.getDimension().location();
                return this;
            }

            public Builder planetConfig(ResourceLocation startPool, int size, int x, int z, ResourceKey<Level> galaxy) {
                this.startPool = startPool;
                this.size = size;
                this.x = x;
                this.z = z;
                this.galaxyDimension = galaxy.location();
                return this;
            }

            public Builder biomes(TagKey<Biome> biomeTag) {
                this.biomeTag = biomeTag.location();
                return this;
            }

            public Builder biomes(ResourceLocation biomeTag) {
                this.biomeTag = biomeTag;
                return this;
            }

            public Builder doAdaptNoise() {
                this.adaptNoise = true;
                return this;
            }

            public Builder type(StructureFeature<?> type) {
                this.type = type;
                return this;
            }

            public Builder emptyMonsterSpawns() {
                this.emptyMonsterSpawns = true;
                return this;
            }

            private boolean canBuild(Function<ResourceLocation, ConfiguredStructureFeatureGen> structureFeature) {
                return this.startPool != null || this.size != -1;
            }

            public ConfiguredStructureFeatureGen build(ResourceLocation resourceLocation) {
                if (!this.canBuild((loc) -> null)) {
                    throw new IllegalStateException("Tried to build incomplete configured structure feature!");
                } else {
                    return new ConfiguredStructureFeatureGen(resourceLocation, this.startPool, this.size, this.x, this.z, this.galaxyDimension, this.biomeTag, this.adaptNoise, this.type, this.emptyMonsterSpawns);
                }
            }

            public ConfiguredStructureFeatureGen save(Consumer<ConfiguredStructureFeatureGen> consumer, String name) {
                ConfiguredStructureFeatureGen structure = this.build(new ResourceLocation(CelestialExploration.MODID, name));
                consumer.accept(structure);
                return structure;
            }

            public JsonObject serializeToJson() {
                JsonObject json = new JsonObject();

                json.addProperty("type", this.type.getRegistryName().toString());

                JsonObject configJson = new JsonObject();

                configJson.addProperty("start_pool", this.startPool.toString());
                configJson.addProperty("size", this.size);

                if (this.galaxyDimension != null) {
                    configJson.addProperty("x", this.x);
                    configJson.addProperty("z", this.z);
                    configJson.addProperty("galaxy", this.galaxyDimension.toString());
                }

                json.add("config", configJson);

                json.addProperty("biomes", "#" + this.biomeTag.toString());
                json.addProperty("adapt_noise", this.adaptNoise);


                //TODO
                JsonObject spawnOverrides = new JsonObject();

                if (this.emptyMonsterSpawns) {
                    JsonObject monsterSpawns = new JsonObject();

                    monsterSpawns.addProperty("bounding_box", "full");

                    JsonArray spawns = new JsonArray();

                    monsterSpawns.add("spawns", spawns);

                    spawnOverrides.add("monster", monsterSpawns);

                }

                json.add("spawn_overrides", spawnOverrides);


                return json;
            }
        }
    }

    protected static class ProcessorListGen {

        private final ResourceLocation location;
        private final List<RuleProcessor> processorRules;

        protected ProcessorListGen(ResourceLocation location, List<RuleProcessor> processorRules) {
            this.location = location;
            this.processorRules = processorRules;
        }

        public ResourceLocation getId() {
            return this.location;
        }

        public ProcessorListGen save(Consumer<ProcessorListGen> consumer) {
            consumer.accept(this);
            return this;
        }

        public JsonObject serializeToJson() {
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();

            for (RuleProcessor rule : this.processorRules) {

                DataResult<JsonElement> ruleData = RuleProcessor.CODEC.encodeStart(JsonOps.INSTANCE, rule);
                JsonObject ruleJson = ruleData.result().get().getAsJsonObject();

                ruleJson.addProperty("processor_type", "minecraft:rule");
                array.add(ruleJson);

            }

            json.add("processors", array);


            return json;
        }
    }
}