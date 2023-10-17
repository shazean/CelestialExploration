package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CelestialExploration.MODID);

    //MOBS
    public static final RegistryObject<EntityType<RustSlimeEntity>> RUST_SLIME = ENTITY_TYPES.register("rust_slime", () -> EntityType.Builder.of(RustSlimeEntity::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "rust_slime").toString()));

    public static final RegistryObject<EntityType<LunarSlimeEntity>> LUNAR_SLIME = ENTITY_TYPES.register("lunar_slime", () -> EntityType.Builder.of(LunarSlimeEntity::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "lunar_slime").toString()));

    public static final RegistryObject<EntityType<MarsMallowEntity>> MARS_MALLOW = ENTITY_TYPES.register("mars_mallow", () -> EntityType.Builder.of(MarsMallowEntity::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "mars_mallow").toString()));

    public static final RegistryObject<EntityType<LurkerEntity>> LURKER = ENTITY_TYPES.register("lurker", () -> EntityType.Builder.of(LurkerEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "lurker").toString()));

    //VEHICLES
    public static final RegistryObject<EntityType<Shuttle>> SHUTTLE = ENTITY_TYPES.register("shuttle", () -> EntityType.Builder.<Shuttle>of(Shuttle::new, MobCategory.MISC)
            .sized(3.1f, 3.1f)
            .build(new ResourceLocation(CelestialExploration.MODID, "shuttle").toString()));

    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }

}
