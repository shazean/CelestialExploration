package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.vehicle.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CelestialExploration.MODID);

    //MOBS
    public static final RegistryObject<EntityType<RustSlime>> RUST_SLIME = ENTITY_TYPES.register("rust_slime", () -> EntityType.Builder.of(RustSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "rust_slime").toString()));

    public static final RegistryObject<EntityType<LunarSlime>> LUNAR_SLIME = ENTITY_TYPES.register("lunar_slime", () -> EntityType.Builder.of(LunarSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "lunar_slime").toString()));

    public static final RegistryObject<EntityType<MarsMallow>> MARS_MALLOW = ENTITY_TYPES.register("mars_mallow", () -> EntityType.Builder.of(MarsMallow::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(CelestialExploration.MODID, "mars_mallow").toString()));

    public static final RegistryObject<EntityType<Lurker>> LURKER = ENTITY_TYPES.register("lurker", () -> EntityType.Builder.of(Lurker::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "lurker").toString()));

    public static final RegistryObject<EntityType<VoidFellow>> VOIDFELLOW = ENTITY_TYPES.register("voidfellow", () -> EntityType.Builder.of(VoidFellow::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "voidfellow").toString()));

    //VEHICLES
    public static final RegistryObject<EntityType<Shuttle>> SHUTTLE = ENTITY_TYPES.register("shuttle", () -> EntityType.Builder.<Shuttle>of(Shuttle::new, MobCategory.MISC)
            .sized(3.1f, 3.1f)
            .build(new ResourceLocation(CelestialExploration.MODID, "shuttle").toString()));

    //MAG CARTS
    public static final RegistryObject<EntityType<MagCart>> MAGCART = ENTITY_TYPES.register("magcart", () -> EntityType.Builder.<MagCart>of(MagCart::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "magcart").toString()));

    public static final RegistryObject<EntityType<MagCartChest>> CHEST_MAGCART = ENTITY_TYPES.register("chest_magcart", () -> EntityType.Builder.<MagCartChest>of(MagCartChest::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "chest_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartCommandBlock>> COMMAND_BLOCK_MAGCART = ENTITY_TYPES.register("command_block_magcart", () -> EntityType.Builder.<MagCartCommandBlock>of(MagCartCommandBlock::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "command_block_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartFurnace>> FURNACE_MAGCART = ENTITY_TYPES.register("furnace_magcart", () -> EntityType.Builder.<MagCartFurnace>of(MagCartFurnace::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "furnace_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartHopper>> HOPPER_MAGCART = ENTITY_TYPES.register("hopper_magcart", () -> EntityType.Builder.<MagCartHopper>of(MagCartHopper::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "hopper_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartSpawner>> SPAWNER_MAGCART = ENTITY_TYPES.register("spawner_magcart", () -> EntityType.Builder.<MagCartSpawner>of(MagCartSpawner::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "spawner_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartTNT>> TNT_MAGCART = ENTITY_TYPES.register("tnt_magcart", () -> EntityType.Builder.<MagCartTNT>of(MagCartTNT::new, MobCategory.MISC)
            .sized(0.98f, 1.5f)
            .clientTrackingRange(8)
            .build(new ResourceLocation(CelestialExploration.MODID, "tnt_magcart").toString()));



//    public static final EntityType<Minecart> MINECART = register("minecart", EntityType.Builder.<Minecart>of(Minecart::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartChest> CHEST_MINECART = register("chest_minecart", EntityType.Builder.<MinecartChest>of(MinecartChest::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartCommandBlock> COMMAND_BLOCK_MINECART = register("command_block_minecart", EntityType.Builder.<MinecartCommandBlock>of(MinecartCommandBlock::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartFurnace> FURNACE_MINECART = register("furnace_minecart", EntityType.Builder.<MinecartFurnace>of(MinecartFurnace::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartHopper> HOPPER_MINECART = register("hopper_minecart", EntityType.Builder.<MinecartHopper>of(MinecartHopper::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartSpawner> SPAWNER_MINECART = register("spawner_minecart", EntityType.Builder.<MinecartSpawner>of(MinecartSpawner::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));
//    public static final EntityType<MinecartTNT> TNT_MINECART = register("tnt_minecart", EntityType.Builder.<MinecartTNT>of(MinecartTNT::new, MobCategory.MISC).sized(0.98F, 0.7F).clientTrackingRange(8));



    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }

}
