package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.CelestialTrader;
import com.shim.celestialexploration.entity.ambient.Eureka;
import com.shim.celestialexploration.entity.creatures.*;
import com.shim.celestialexploration.entity.monster.*;
import com.shim.celestialexploration.entity.monster.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.monster.piglins.CyborgPiglin;
import com.shim.celestialexploration.entity.monster.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.monster.slimes.*;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.entity.robots.*;
import com.shim.celestialexploration.entity.vehicle.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
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

    private static String modLocString(String loc) {
        return new ResourceLocation(CelestialExploration.MODID, loc).toString();
    }

    //---- MOBS -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<RustSlime>> RUST_SLIME = registerEntityType("rust_slime", "Rust Slime", () -> EntityType.Builder.of(RustSlime::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(modLocString("rust_slime")));
    public static final RegistryObject<EntityType<LunarSlime>> LUNAR_SLIME = registerEntityType("lunar_slime", "Lunar Slime", () -> EntityType.Builder.of(LunarSlime::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(modLocString("lunar_slime")));
    public static final RegistryObject<EntityType<MarsMallow>> MARS_MALLOW = registerEntityType("mars_mallow", "Mars Mallow", () -> EntityType.Builder.of(MarsMallow::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(modLocString("mars_mallow")));
    public static final RegistryObject<EntityType<QuicksilverSlime>> QUICKSILVER_SLIME = registerEntityType("quicksilver_slime", "Quicksilver Slime", () -> EntityType.Builder.of(QuicksilverSlime::new, MobCategory.MONSTER).sized(3.14F, 3.14F).clientTrackingRange(10).build(modLocString("quicksilver_slime")));
    public static final RegistryObject<EntityType<ViscousSlime>> VISCOUS_SLIME = registerEntityType("viscous_slime", "Viscous Slime", () -> EntityType.Builder.of(ViscousSlime::new, MobCategory.MONSTER).sized(1.8F, 1.8F).clientTrackingRange(10).build(modLocString("lunar_slime")));
    public static final RegistryObject<EntityType<SulfurCube>> SULFUR_CUBE = registerEntityType("sulfur_cube", "Sulfur Cube", () -> EntityType.Builder.of(SulfurCube::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).fireImmune().build(modLocString("sulfur_cube")));

    public static final RegistryObject<EntityType<Lurker>> LURKER = registerEntityType("lurker", "Lurker", () -> EntityType.Builder.of(Lurker::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build(modLocString("lurker")));
    public static final RegistryObject<EntityType<VoidFellow>> VOIDFELLOW = registerEntityType("voidfellow", "Space Fellow", () -> EntityType.Builder.of(VoidFellow::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build(modLocString("voidfellow")));
    public static final RegistryObject<EntityType<Voided>> VOIDED = registerEntityType("voided", "Voided", () -> EntityType.Builder.of(Voided::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build(modLocString("voided")));

    public static final RegistryObject<EntityType<VoidedPiglin>> VOIDED_PIGLIN = registerEntityType("voided_piglin", "Voided Piglin", () -> EntityType.Builder.of(VoidedPiglin::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(modLocString("voided_piglin")));
    public static final RegistryObject<EntityType<AstralPiglin>> ASTRAL_PIGLIN = registerEntityType("astral_piglin", "Astral Piglin", () -> EntityType.Builder.of(AstralPiglin::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(modLocString("astral_piglin")));
    public static final RegistryObject<EntityType<CyborgPiglin>> CYBORG_PIGLIN = registerEntityType("cyborg_piglin", "Cyborg Piglin", () -> EntityType.Builder.of(CyborgPiglin::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(modLocString("cyborg_piglin")));
    public static final RegistryObject<EntityType<VoidedZoglin>> VOIDED_ZOGLIN = registerEntityType("voided_zoglin", "Voided Zoglin", () -> EntityType.Builder.of(VoidedZoglin::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(modLocString("voided_zoglin")));
    public static final RegistryObject<EntityType<AstralHoglin>> ASTRAL_HOGLIN = registerEntityType("astral_hoglin", "Astral Hoglin", () -> EntityType.Builder.of(AstralHoglin::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(modLocString("astral_hoglin")));

    public static final RegistryObject<EntityType<MeteorCrawler>> METEOR_CRAWLER = registerEntityType("meteor_crawler", "Meteorite Crawler", () -> EntityType.Builder.of(MeteorCrawler::new, MobCategory.MONSTER).sized(1.4F, 0.9F).clientTrackingRange(8).build(modLocString("meteor_crawler")));
    public static final RegistryObject<EntityType<VoidCrawler>> VOID_CRAWLER = registerEntityType("void_crawler", "Void Crawler", () -> EntityType.Builder.of(VoidCrawler::new, MobCategory.MONSTER).sized(1.0F, 0.7F).clientTrackingRange(8).build(modLocString("void_crawler")));

    public static final RegistryObject<EntityType<Flare>> FLARE = registerEntityType("flare", "Flare", () -> EntityType.Builder.of(Flare::new, MobCategory.MONSTER).sized(0.6F, 1.8F).clientTrackingRange(8).fireImmune().build(modLocString("flare")));
    public static final RegistryObject<EntityType<Gyst>> GYST = registerEntityType("gyst", "Gyst", () -> EntityType.Builder.of(Gyst::new, MobCategory.MONSTER).sized(4.0F, 4.0F).clientTrackingRange(10).fireImmune().build(modLocString("gyst")));

    public static final RegistryObject<EntityType<Gust>> GUST = registerEntityType("gust", "Gust", () -> EntityType.Builder.of(Gust::new, MobCategory.MONSTER).sized(0.7F, 2.3F).clientTrackingRange(8).build(modLocString("gust")));
    public static final RegistryObject<EntityType<Orbiter>> ORBITER = registerEntityType("orbiter", "Orbiter", () -> EntityType.Builder.of(Orbiter::new, MobCategory.MONSTER).sized(4.0F, 4.0F).clientTrackingRange(10).fireImmune().build(modLocString("orbiter")));
    public static final RegistryObject<EntityType<MechaCerberusBoss>> MECHACERBERUS_BOSS = registerEntityType("mechacerberus_boss", "Mechacerberus", () -> EntityType.Builder.of(MechaCerberusBoss::new, MobCategory.MONSTER).sized(3.1F, 3.0F).clientTrackingRange(8).build(modLocString("mechacerberus_boss")));

    public static final RegistryObject<EntityType<Vulkan>> VULKAN = registerEntityType("vulkan", "Vulkan", () -> EntityType.Builder.of(Vulkan::new, MobCategory.MONSTER).fireImmune().sized(1.2F, 2.2F).clientTrackingRange(8).build(modLocString("vulkan")));


    //---- VEHICLES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Spaceship>> SPACESHIP = registerEntityType("spaceship", "Spaceship", () -> EntityType.Builder.<Spaceship>of(Spaceship::new, MobCategory.MISC).sized(2.45f, 2.65f).build(modLocString("spaceship")));
//    public static final RegistryObject<EntityType<SpaceTaxi>> SPACE_TAXI = registerEntityType("space_taxi", "Space Taxi", () -> EntityType.Builder.<SpaceTaxi>of(SpaceTaxi::new, MobCategory.MISC).sized(2.45f, 2.65f).build(modLocString("space_taxi")));
public static final RegistryObject<EntityType<Buggy>> BUGGY = registerEntityType("buggy", "Buggy", () -> EntityType.Builder.<Buggy>of(Buggy::new, MobCategory.MISC).sized(2.8f, 2.8f).build(modLocString("buggy")));

    //---- MAGCARTS -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<MagCart>> MAGCART = registerEntityType("magcart", "Magcart", () -> EntityType.Builder.<MagCart>of(MagCart::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("magcart")));
    public static final RegistryObject<EntityType<MagCartChest>> CHEST_MAGCART = registerEntityType("chest_magcart", "Chest Magcart", () -> EntityType.Builder.<MagCartChest>of(MagCartChest::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("chest_magcart")));
    public static final RegistryObject<EntityType<MagCartCommandBlock>> COMMAND_BLOCK_MAGCART = registerEntityType("command_block_magcart", "Command Block Magcart", () -> EntityType.Builder.<MagCartCommandBlock>of(MagCartCommandBlock::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("command_block_magcart")));
    public static final RegistryObject<EntityType<MagCartFurnace>> FURNACE_MAGCART = registerEntityType("furnace_magcart", "Furnace Magcart", () -> EntityType.Builder.<MagCartFurnace>of(MagCartFurnace::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("furnace_magcart")));
    public static final RegistryObject<EntityType<MagCartHopper>> HOPPER_MAGCART = registerEntityType("hopper_magcart", "Hopper Magcart", () -> EntityType.Builder.<MagCartHopper>of(MagCartHopper::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("hopper_magcart")));
    public static final RegistryObject<EntityType<MagCartSpawner>> SPAWNER_MAGCART = registerEntityType("spawner_magcart", "Spawner Magcart", () -> EntityType.Builder.<MagCartSpawner>of(MagCartSpawner::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("spawner_magcart")));
    public static final RegistryObject<EntityType<MagCartTNT>> TNT_MAGCART = registerEntityType("tnt_magcart", "TNT Magcart", () -> EntityType.Builder.<MagCartTNT>of(MagCartTNT::new, MobCategory.MISC).sized(0.98f, 1.5f).clientTrackingRange(8).build(modLocString("tnt_magcart")));

    //---- TAMABLES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<CelestialCat>> CELESTIAL_CAT = registerEntityType("celestial_cat", "Celestial Cat", () -> EntityType.Builder.of(CelestialCat::new, MobCategory.CREATURE).sized(0.6F, 0.7F).clientTrackingRange(8).build(modLocString("celestial_cat")));
    public static final RegistryObject<EntityType<Drone>> DRONE = registerEntityType("drone", "Camera Drone", () -> EntityType.Builder.of(Drone::new, MobCategory.CREATURE).sized(0.9F, 0.9F).clientTrackingRange(8).build(modLocString("drone")));
    public static final RegistryObject<EntityType<MechaDog>> MECHADOG = registerEntityType("mechadog", "MechaDog", () -> EntityType.Builder.of(MechaDog::new, MobCategory.CREATURE).sized(1.0F, 1.2F).clientTrackingRange(8).build(modLocString("mechadog")));
    public static final RegistryObject<EntityType<MechaCerberus>> MECHACERBERUS = registerEntityType("mechacerberus", "Mechacerberus", () -> EntityType.Builder.of(MechaCerberus::new, MobCategory.CREATURE).sized(3.1F, 3.0F).clientTrackingRange(8).build(modLocString("mechacerberus")));
    public static final RegistryObject<EntityType<MechaCrow>> MECHACROW = registerEntityType("mechacrow", "MechaCrow", () -> EntityType.Builder.of(MechaCrow::new, MobCategory.CREATURE).sized(0.3F, 0.4F).clientTrackingRange(10).build(modLocString("mechacrow")));


    //---- CREATURES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Rover>> ROVER = registerEntityType("rover", "Rover", () -> EntityType.Builder.of(Rover::new, MobCategory.CREATURE).sized(2.0F, 1.8F).clientTrackingRange(8).build(modLocString("rover")));
    public static final RegistryObject<EntityType<Cobblesaurus>> COBBLESAURUS = registerEntityType("cobblesaurus", "Cobblesaurus", () -> EntityType.Builder.of(Cobblesaurus::new, MobCategory.CREATURE).sized(2.0F, 1.8F).clientTrackingRange(8).build(modLocString("cobblesaurus")));
    public static final RegistryObject<EntityType<MoonCow>> MOON_COW = registerEntityType("moon_ow", "Moon Cow", () -> EntityType.Builder.of(MoonCow::new, MobCategory.CREATURE).sized(0.8F, 1.4F).clientTrackingRange(10).build(modLocString("moon_cow")));
//    public static final RegistryObject<EntityType<CelestialSquid>> ASTEROID_SQUID = registerEntityType("asteroid_squid", "Asteroid Squid", () -> EntityType.Builder.of(CelestialSquid::new, MobCategory.CREATURE).sized(1.0F, 1.0F).clientTrackingRange(10).build(modLocString("asteroid_squid")));
//    public static final RegistryObject<EntityType<StardustSquid>> STARDUST_SQUID = registerEntityType("stardust_squid", "Stardust Squid", () -> EntityType.Builder.of(StardustSquid::new, MobCategory.CREATURE).sized(1.0F, 1.0F).clientTrackingRange(10).build(modLocString("stardust_squid")));

//    public static final RegistryObject<EntityType<CelestialAxolotl>> CELESTIAL_AXOLOTL = registerEntityType("celestial_axolotl", "Celestial Axolotl", () -> EntityType.Builder.of(CelestialAxolotl::new, MobCategory.AXOLOTLS).sized(0.8F, 0.42F).clientTrackingRange(10).build(modLocString("celestial_axolotl")));

    public static final RegistryObject<EntityType<SpaceTraderLlama>> SPACE_LLAMA = registerEntityType("space_llama", "Space Llama", () -> EntityType.Builder.of(SpaceTraderLlama::new, MobCategory.CREATURE).sized(0.9F, 1.87F).clientTrackingRange(10).build(modLocString("space_llama")));
    public static final RegistryObject<EntityType<AlienTraderLlama>> ALIEN_LLAMA = registerEntityType("alien_llama", "Alien Llama", () -> EntityType.Builder.of(AlienTraderLlama::new, MobCategory.CREATURE).sized(0.9F, 1.87F).clientTrackingRange(10).build(modLocString("alien_llama")));


    //---- AMBIENT -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Eureka>> EUREKA = registerEntityType("eureka", "Eureka!", () -> EntityType.Builder.of(Eureka::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.4F).clientTrackingRange(4).build(modLocString("eureka")));

    //---- PROJECTILES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<MeteorProjectile>> METEOR = registerEntityType("meteor", "Shooting Star", () -> EntityType.Builder.of(MeteorProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(modLocString("meteor")));

//    ---- OTHER -------------------------------------------------------------------------------

    public static final RegistryObject<EntityType<CelestialTrader>> CELESTIAL_TRADER = registerEntityType("celestial_trader", "Celestial Trader", () -> EntityType.Builder.<CelestialTrader>of(CelestialTrader::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(10).build(modLocString("celestial_trader")));

}
