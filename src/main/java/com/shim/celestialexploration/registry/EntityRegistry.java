package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.mob.*;
import com.shim.celestialexploration.entity.mob.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.mob.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.mob.slimes.*;
import com.shim.celestialexploration.entity.vehicle.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntityRegistry {

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

    public static final RegistryObject<EntityType<Flare>> FLARE = registerEntityType("flare", "Flare", () -> EntityType.Builder.of(Flare::new, MobCategory.MONSTER)
            .sized(0.6F, 1.8F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "flare").toString()));

    public static final RegistryObject<EntityType<Gust>> GUST = registerEntityType("gust", "Gust", () -> EntityType.Builder.of(Gust::new, MobCategory.MONSTER)
            .sized(4.0F, 4.0F).clientTrackingRange(10).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "gust").toString()));

    public static final RegistryObject<EntityType<VoidedZoglin>> VOIDED_ZOGLIN = registerEntityType("voided_zoglin", "Voided Zoglin", () -> EntityType.Builder.of(VoidedZoglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "voided_zoglin").toString()));

    public static final RegistryObject<EntityType<AstralHoglin>> ASTRAL_HOGLIN = registerEntityType("astral_hoglin", "Astral Hoglin", () -> EntityType.Builder.of(AstralHoglin::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8).fireImmune().build(new ResourceLocation(CelestialExploration.MODID, "astral_hoglin").toString()));

    //---- VEHICLES -------------------------------------------------------------------------------
    public static final RegistryObject<EntityType<Spaceship>> SPACESHIP = registerEntityType("spaceship", "Spaceship", () -> EntityType.Builder.<Spaceship>of(Spaceship::new, MobCategory.MISC)
            .sized(2.45f, 2.65f).build(new ResourceLocation(CelestialExploration.MODID, "spaceship").toString()));

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


    public static final RegistryObject<EntityType<ControlPanel>> CONTROL_PANEL = registerEntityType("control_panel_1", "Control Panel", () -> EntityType.Builder.<ControlPanel>of(ControlPanel::new, MobCategory.MISC)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(new ResourceLocation(CelestialExploration.MODID, "control_panel").toString()));


    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);
    }
}
