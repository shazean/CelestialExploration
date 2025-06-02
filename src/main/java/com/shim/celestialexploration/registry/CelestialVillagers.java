package com.shim.celestialexploration.registry;

import com.google.common.collect.ImmutableSet;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialVillagers {
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, CelestialExploration.MODID);

    public static final RegistryObject<VillagerProfession> ASTRONOMER = VILLAGER_PROFESSIONS.register("astronomer",
            () -> new VillagerProfession("astronomer", CelestialPOIs.ASTRONOMY_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static final RegistryObject<VillagerProfession> ENGINEER = VILLAGER_PROFESSIONS.register("engineer",
            () -> new VillagerProfession("engineer", CelestialPOIs.ENGINEER_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

//    public static final RegistryObject<VillagerProfession> GEOLOGIST = VILLAGER_PROFESSIONS.register("geologist",
//            () -> new VillagerProfession("geologist", GEOLOGIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

//    public static final RegistryObject<VillagerProfession> CHEF = VILLAGER_PROFESSIONS.register("chef",
//            () -> new VillagerProfession("chef", CHEF_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER)); //FIXME


    public static void register(IEventBus eventBus) {
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}