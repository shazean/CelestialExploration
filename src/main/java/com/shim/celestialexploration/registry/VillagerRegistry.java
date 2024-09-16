package com.shim.celestialexploration.registry;

import com.google.common.collect.ImmutableSet;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class VillagerRegistry {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, CelestialExploration.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, CelestialExploration.MODID);

    public static final RegistryObject<PoiType> ASTRONOMY_POI = POI_TYPES.register("astronomy_poi",
            () -> new PoiType("astronomy_poi", PoiType.getBlockStates(BlockRegistry.PLANET_CHART.get()), 1, 1));

    public static final RegistryObject<PoiType> ENGINEER_POI = POI_TYPES.register("engineer_poi",
            () -> new PoiType("astronomy_poi", PoiType.getBlockStates(BlockRegistry.WORKBENCH.get()), 1, 1));

//    public static final RegistryObject<PoiType> GEOLOGIST_POI = POI_TYPES.register("geologist_poi",
//            () -> new PoiType("geologist_poi", PoiType.getBlockStates(BlockRegistry.GRINDING_WHEEL.get()), 1, 1));  //FIXME
    //crushing wheel?

//    public static final RegistryObject<PoiType> CHEF_POI = POI_TYPES.register("chef_poi",
//            () -> new PoiType("chef_poi", PoiType.getBlockStates(Blocks.FURNACE), 1, 1)); //FIXME


    public static final RegistryObject<VillagerProfession> ASTRONOMER = VILLAGER_PROFESSIONS.register("astronomer",
            () -> new VillagerProfession("astronomer", ASTRONOMY_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static final RegistryObject<VillagerProfession> ENGINEER = VILLAGER_PROFESSIONS.register("engineer",
            () -> new VillagerProfession("engineer", ENGINEER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

//    public static final RegistryObject<VillagerProfession> GEOLOGIST = VILLAGER_PROFESSIONS.register("geologist",
//            () -> new VillagerProfession("geologist", GEOLOGIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

//    public static final RegistryObject<VillagerProfession> CHEF = VILLAGER_PROFESSIONS.register("chef",
//            () -> new VillagerProfession("chef", CHEF_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER)); //FIXME


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, ASTRONOMY_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, ENGINEER_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, GEOLOGIST_POI.get());
//            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, BAKER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}