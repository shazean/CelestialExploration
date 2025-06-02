package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.ambient.Eureka;
import com.shim.celestialexploration.entity.friendlies.CelestialCat;
import com.shim.celestialexploration.entity.friendlies.Cobblesaurus;
import com.shim.celestialexploration.entity.mob.*;
import com.shim.celestialexploration.entity.mob.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.mob.piglins.CyborgPiglin;
import com.shim.celestialexploration.entity.mob.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.mob.slimes.*;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.entity.robots.*;
import com.shim.celestialexploration.entity.vehicle.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CelestialEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CelestialExploration.MODID);

    public static final Map<RegistryObject<? extends EntityType>, String> ENTITY_LANG_EN_US = new HashMap<>();

    private static <T extends EntityType> RegistryObject<T> registerEntityType(String nameIn, String localizationIn, Supplier<T> entityIn) {
        RegistryObject<T> entity = ENTITY_TYPES.register(nameIn, entityIn);
        ENTITY_LANG_EN_US.put(entity, localizationIn);
        return entity;
    }

    //---- MOBS -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<RustSlime>> RUST_SLIME = registerEntityType("rust_slime", "Rust Slime", () -> EntityType.Builder.of(RustSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).build(new ResourceLocation(CelestialExploration.MODID, "rust_slime").toString()));

    public static final RegistryObject<EntityType<LunarSlime>> LUNAR_SLIME = registerEntityType("lunar_slime", "Lunar Slime", () -> EntityType.Builder.of(LunarSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).build(new ResourceLocation(CelestialExploration.MODID, "lunar_slime").toString()));

    public static final RegistryObject<EntityType<MarsMallow>> MARS_MALLOW = registerEntityType("mars_mallow", "Mars Mallow", () -> EntityType.Builder.of(MarsMallow::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).build(new ResourceLocation(CelestialExploration.MODID, "mars_mallow").toString()));

    public static final RegistryObject<EntityType<QuicksilverSlime>> QUICKSILVER_SLIME = registerEntityType("quicksilver_slime", "Quicksilver Slime", () -> EntityType.Builder.of(QuicksilverSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).build(new ResourceLocation(CelestialExploration.MODID, "quicksilver_slime").toString()));

    public static final RegistryObject<EntityType<ViscousSlime>> VISCOUS_SLIME = registerEntityType("viscous_slime", "Viscous Slime", () -> EntityType.Builder.of(ViscousSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).build(new ResourceLocation(CelestialExploration.MODID, "lunar_slime").toString()));

    public static final RegistryObject<EntityType<Lurker>> LURKER = registerEntityType("lurker", "Lurker", () -> EntityType.Builder.of(Lurker::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "lurker").toString()));

    public static final RegistryObject<EntityType<VoidFellow>> VOIDFELLOW = registerEntityType("voidfellow", "Space Fellow", () -> EntityType.Builder.of(VoidFellow::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "voidfellow").toString()));

    public static final RegistryObject<EntityType<Voided>> VOIDED = registerEntityType("voided", "Voided", () -> EntityType.Builder.of(Voided::new, MobCategory.MONSTER)
            .sized(0.6F, 1.7F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "voided").toString()));

    public static final RegistryObject<EntityType<SulfurCube>> SULFUR_CUBE = registerEntityType("sulfur_cube", "Sulfur Cube", () -> EntityType.Builder.of(SulfurCube::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "sulfur_cube").toString()));

    public static final RegistryObject<EntityType<VoidedPiglin>> VOIDED_PIGLIN = registerEntityType("voided_piglin", "Voided Piglin", () -> EntityType.Builder.of(VoidedPiglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "voided_piglin").toString()));

    public static final RegistryObject<EntityType<AstralPiglin>> ASTRAL_PIGLIN = registerEntityType("astral_piglin", "Astral Piglin", () -> EntityType.Builder.of(AstralPiglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "astral_piglin").toString()));

    public static final RegistryObject<EntityType<CyborgPiglin>> CYBORG_PIGLIN = registerEntityType("cyborg_piglin", "Cyborg Piglin", () -> EntityType.Builder.of(CyborgPiglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "cyborg_piglin").toString()));

    public static final RegistryObject<EntityType<Flare>> FLARE = registerEntityType("flare", "Flare", () -> EntityType.Builder.of(Flare::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "flare").toString()));

    public static final RegistryObject<EntityType<Gyst>> GYST = registerEntityType("gyst", "Gyst", () -> EntityType.Builder.of(Gyst::new, MobCategory.MONSTER)
            .sized(4.0F, 4.0F).clientTrackingRange(10).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "gyst").toString()));


    public static final RegistryObject<EntityType<VoidedZoglin>> VOIDED_ZOGLIN = registerEntityType("voided_zoglin", "Voided Zoglin", () -> EntityType.Builder.of(VoidedZoglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "voided_zoglin").toString()));

    public static final RegistryObject<EntityType<AstralHoglin>> ASTRAL_HOGLIN = registerEntityType("astral_hoglin", "Astral Hoglin", () -> EntityType.Builder.of(AstralHoglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "astral_hoglin").toString()));

    public static final RegistryObject<EntityType<MeteorCrawler>> METEOR_CRAWLER = registerEntityType("meteor_crawler", "Meteorite Crawler", () -> EntityType.Builder.of(MeteorCrawler::new, MobCategory.MONSTER)
            .sized(1.4F, 0.9F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "meteor_crawler").toString()));

    public static final RegistryObject<EntityType<VoidCrawler>> VOID_CRAWLER = registerEntityType("void_crawler", "Void Crawler", () -> EntityType.Builder.of(VoidCrawler::new, MobCategory.MONSTER)
            .sized(1.0F, 0.7F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "void_crawler").toString()));

    public static final RegistryObject<EntityType<Gust>> GUST = registerEntityType("gust", "Gust", () -> EntityType.Builder.of(Gust::new, MobCategory.MONSTER)
            .sized(0.7F, 2.3F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "gust").toString()));

    //---- VEHICLES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Spaceship>> SPACESHIP = registerEntityType("spaceship", "Spaceship", () -> EntityType.Builder.<Spaceship>of(Spaceship::new, MobCategory.MISC)
            .sized(2.45f, 2.65f).build(new ResourceLocation(CelestialExploration.MODID, "spaceship").toString()));

    public static final RegistryObject<EntityType<SpaceTaxi>> SPACE_TAXI = registerEntityType("space_taxi", "Space Taxi", () -> EntityType.Builder.<SpaceTaxi>of(SpaceTaxi::new, MobCategory.MISC)
            .sized(2.45f, 2.65f).build(new ResourceLocation(CelestialExploration.MODID, "space_taxi").toString()));


    //---- MAGCARTS -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<MagCart>> MAGCART = registerEntityType("magcart", "Magcart", () -> EntityType.Builder.<MagCart>of(MagCart::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "magcart").toString()));

    public static final RegistryObject<EntityType<MagCartChest>> CHEST_MAGCART = registerEntityType("chest_magcart", "Chest Magcart", () -> EntityType.Builder.<MagCartChest>of(MagCartChest::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "chest_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartCommandBlock>> COMMAND_BLOCK_MAGCART = registerEntityType("command_block_magcart", "Command Block Magcart", () -> EntityType.Builder.<MagCartCommandBlock>of(MagCartCommandBlock::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "command_block_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartFurnace>> FURNACE_MAGCART = registerEntityType("furnace_magcart", "Furnace Magcart", () -> EntityType.Builder.<MagCartFurnace>of(MagCartFurnace::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "furnace_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartHopper>> HOPPER_MAGCART = registerEntityType("hopper_magcart", "Hopper Magcart", () -> EntityType.Builder.<MagCartHopper>of(MagCartHopper::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "hopper_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartSpawner>> SPAWNER_MAGCART = registerEntityType("spawner_magcart", "Spawner Magcart", () -> EntityType.Builder.<MagCartSpawner>of(MagCartSpawner::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "spawner_magcart").toString()));

    public static final RegistryObject<EntityType<MagCartTNT>> TNT_MAGCART = registerEntityType("tnt_magcart", "TNT Magcart", () -> EntityType.Builder.<MagCartTNT>of(MagCartTNT::new, MobCategory.MISC)
            .sized(0.98f, 1.5f).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "tnt_magcart").toString()));


    //---- TAMABLES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<CelestialCat>> CELESTIAL_CAT = registerEntityType("celestial_cat", "Celestial Cat", () -> EntityType.Builder.of(CelestialCat::new, MobCategory.CREATURE)
            .sized(0.6F, 0.7F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "celestial_cat").toString()));

    public static final RegistryObject<EntityType<Drone>> DRONE = registerEntityType("drone", "Camera Drone", () -> EntityType.Builder.of(Drone::new, MobCategory.CREATURE)
            .sized(0.9F, 0.9F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "drone").toString()));

    public static final RegistryObject<EntityType<MechaDog>> MECHADOG = registerEntityType("mechadog", "MechaDog", () -> EntityType.Builder.of(MechaDog::new, MobCategory.CREATURE)
            .sized(1.0F, 1.2F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "mechadog").toString()));

    //---- PROJECTILES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<MeteorProjectile>> METEOR = registerEntityType("meteor", "Shooting Star", () -> EntityType.Builder.of(MeteorProjectile::new, MobCategory.MISC)
            .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(CelestialExploration.MODID, "meteor").toString()));

    //---- OTHER -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Eureka>> EUREKA = registerEntityType("eureka", "Eureka!", () -> EntityType.Builder.of(Eureka::new, MobCategory.WATER_AMBIENT)
            .sized(0.5F, 0.4F).clientTrackingRange(4).build(new ResourceLocation(CelestialExploration.MODID, "eureka").toString()));

    public static final RegistryObject<EntityType<Rover>> ROVER = registerEntityType("rover", "Rover", () -> EntityType.Builder.of(Rover::new, MobCategory.CREATURE)
            .sized(2.0F, 1.8F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "rover").toString()));

    public static final RegistryObject<EntityType<Cobblesaurus>> COBBLESAURUS = registerEntityType("cobblesaurus", "Cobblesaurus", () -> EntityType.Builder.of(Cobblesaurus::new, MobCategory.CREATURE)
            .sized(2.0F, 1.8F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "cobblesaurus").toString()));


    //    public static final RegistryObject<EntityType<ControlPanel>> CONTROL_PANEL = registerEntityType("control_panel_1", "Control Panel", () -> EntityType.Builder.<ControlPanel>of(ControlPanel::new, MobCategory.MISC)
//            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(new ResourceLocation(CelestialExploration.MODID, "control_panel").toString()));

    public static final RegistryObject<EntityType<Orbiter>> ORBITER = registerEntityType("orbiter", "Orbiter", () -> EntityType.Builder.of(Orbiter::new, MobCategory.MONSTER)
            .sized(4.0F, 4.0F).clientTrackingRange(10).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "orbiter").toString()));

    public static final RegistryObject<EntityType<MechaCerberus>> MECHACERBERUS = registerEntityType("mechacerberus", "Mechacerberus", () -> EntityType.Builder.of(MechaCerberus::new, MobCategory.CREATURE)
            .sized(3.1F, 3.0F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "mechacerberus").toString()));

    public static final RegistryObject<EntityType<MechaCerberusBoss>> MECHACERBERUS_BOSS = registerEntityType("mechacerberus_boss", "Mechacerberus", () -> EntityType.Builder.of(MechaCerberusBoss::new, MobCategory.MONSTER)
            .sized(3.1F, 3.0F).clientTrackingRange(8).build(new ResourceLocation(CelestialExploration.MODID, "mechacerberus_boss").toString()));

    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }
}
