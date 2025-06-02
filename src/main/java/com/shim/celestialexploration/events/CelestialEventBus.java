package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.ambient.Eureka;
import com.shim.celestialexploration.entity.client.layers.VillagerSpaceSuitLayer;
import com.shim.celestialexploration.entity.friendlies.CelestialCat;
import com.shim.celestialexploration.entity.friendlies.Cobblesaurus;
import com.shim.celestialexploration.entity.mob.*;
import com.shim.celestialexploration.entity.mob.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.mob.piglins.CyborgPiglin;
import com.shim.celestialexploration.entity.mob.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.client.model.MagCartModel;
import com.shim.celestialexploration.entity.mob.slimes.*;
import com.shim.celestialexploration.entity.robots.*;
import com.shim.celestialexploration.particles.*;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.WaterDropParticle;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.layers.VillagerProfessionLayer;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.client.model.geom.LayerDefinitions.INNER_ARMOR_DEFORMATION;
import static net.minecraft.client.model.geom.LayerDefinitions.OUTER_ARMOR_DEFORMATION;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CelestialEventBus {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(CelestialEntities.RUST_SLIME.get(), RustSlime.setAttributes());
        event.put(CelestialEntities.LUNAR_SLIME.get(), LunarSlime.setAttributes());
        event.put(CelestialEntities.MARS_MALLOW.get(), MarsMallow.setAttributes());
        event.put(CelestialEntities.LURKER.get(), Lurker.setAttributes());
        event.put(CelestialEntities.VOIDFELLOW.get(), VoidFellow.setAttributes());
        event.put(CelestialEntities.VOIDED.get(), Voided.setAttributes());
        event.put(CelestialEntities.SULFUR_CUBE.get(), SulfurCube.setAttributes());
        event.put(CelestialEntities.VOIDED_PIGLIN.get(), VoidedPiglin.setAttributes());
        event.put(CelestialEntities.FLARE.get(), Flare.setAttributes());
        event.put(CelestialEntities.GYST.get(), Gyst.setAttributes());
        event.put(CelestialEntities.ASTRAL_PIGLIN.get(), AstralPiglin.setAttributes());
        event.put(CelestialEntities.CYBORG_PIGLIN.get(), CyborgPiglin.setAttributes());
        event.put(CelestialEntities.ASTRAL_HOGLIN.get(), AstralHoglin.setAttributes());
        event.put(CelestialEntities.VOIDED_ZOGLIN.get(), VoidedZoglin.setAttributes());

        event.put(CelestialEntities.QUICKSILVER_SLIME.get(), QuicksilverSlime.setAttributes());
        event.put(CelestialEntities.VISCOUS_SLIME.get(), ViscousSlime.setAttributes());
        event.put(CelestialEntities.METEOR_CRAWLER.get(), MeteorCrawler.createAttributes().build());
        event.put(CelestialEntities.VOID_CRAWLER.get(), VoidCrawler.createAttributes().build());
        event.put(CelestialEntities.CELESTIAL_CAT.get(), CelestialCat.createAttributes().build());

        event.put(CelestialEntities.EUREKA.get(), Eureka.createAttributes().build());

        event.put(CelestialEntities.GUST.get(), Gust.createAttributes().build());
        event.put(CelestialEntities.DRONE.get(), Drone.createAttributes().build());
        event.put(CelestialEntities.ROVER.get(), Rover.createAttributes().build());
        event.put(CelestialEntities.MECHADOG.get(), MechaDog.createAttributes().build());
        event.put(CelestialEntities.COBBLESAURUS.get(), Cobblesaurus.createAttributes().build());
        event.put(CelestialEntities.ORBITER.get(), Orbiter.createAttributes().build());
        event.put(CelestialEntities.MECHACERBERUS.get(), MechaCerberus.createAttributes().build());
        event.put(CelestialEntities.MECHACERBERUS_BOSS.get(), MechaCerberusBoss.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(CelestialModelLayers.MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.CHEST_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.COMMAND_BLOCK_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.FURNACE_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.HOPPER_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.SPAWNER_MAGCART, MagCartModel::createBodyLayer);
        event.registerLayerDefinition(CelestialModelLayers.TNT_MAGCART, MagCartModel::createBodyLayer);

        LayerDefinition humanoidLayer = LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64);
        LayerDefinition innerArmorLayer = LayerDefinition.create(HumanoidModel.createMesh(INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);
        LayerDefinition outerArmorLayer = LayerDefinition.create(HumanoidModel.createMesh(OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);

        event.registerLayerDefinition(CelestialModelLayers.VOIDED, () -> humanoidLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_OUTER_ARMOR, () -> outerArmorLayer);

        LayerDefinition piglinLayer = LayerDefinition.create(PiglinModel.createMesh(CubeDeformation.NONE), 64, 64);

        event.registerLayerDefinition(CelestialModelLayers.VOIDED_PIGLIN, () -> piglinLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_PIGLIN_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_PIGLIN_OUTER_ARMOR, () -> outerArmorLayer);

        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_PIGLIN, () -> piglinLayer);
        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_PIGLIN_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_PIGLIN_OUTER_ARMOR, () -> outerArmorLayer);

        LayerDefinition hoglinLayer = HoglinModel.createBodyLayer();

        event.registerLayerDefinition(CelestialModelLayers.VOIDED_ZOGLIN, () -> hoglinLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_ZOGLIN_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_ZOGLIN_OUTER_ARMOR, () -> outerArmorLayer);

        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_HOGLIN, () -> hoglinLayer);
        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_HOGLIN_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.ASTRAL_HOGLIN_OUTER_ARMOR, () -> outerArmorLayer);

        event.registerLayerDefinition(CelestialModelLayers.GUST, GhastModel::createBodyLayer);

        LayerDefinition skullLayer = SkullModel.createMobHeadLayer();
        LayerDefinition humanoidHeadLayer = SkullModel.createHumanoidHeadLayer();

        event.registerLayerDefinition(CelestialModelLayers.LURKER_HEAD, () -> skullLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_HEAD, () -> humanoidHeadLayer);
            event.registerLayerDefinition(CelestialModelLayers.MECHADOG_HEAD, () -> skullLayer);

//        LayerDefinition displayBoardDef = DisplayBoardRenderer.createDisplayBoardLayer();
//        DisplayBoardBlock.DisplayBoardColors.values().forEach((p_171114_) -> {
//            event.registerLayerDefinition(CelestialModelLayers.createDisplayBoardModelName(p_171114_), () -> displayBoardDef);
//        });
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft minecraft = CelestialExploration.PROXY.getMinecraft();

        minecraft.particleEngine.register(CelestialParticles.RUST_SLIME_PARTICLES.get(), CelestialSlimeParticles.RustProvider::new);
        minecraft.particleEngine.register(CelestialParticles.LUNAR_SLIME_PARTICLES.get(), CelestialSlimeParticles.LunarProvider::new);
        minecraft.particleEngine.register(CelestialParticles.MARS_MALLOW_SLIME_PARTICLES.get(), CelestialSlimeParticles.MallowProvider::new);
        minecraft.particleEngine.register(CelestialParticles.QUICKSILVER_SLIME_PARTICLES.get(), CelestialSlimeParticles.QuickSilverProvider::new);

        minecraft.particleEngine.register(CelestialParticles.SULFUR_CUBE_PARTICLES.get(), CelestialSlimeParticles.SulfurProvider::new);
        minecraft.particleEngine.register(CelestialParticles.SULFUR_PARTICLE.get(), SulfurParticle.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.SULFUR_FIRE_FLAME.get(), FlameParticle.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.SULFUR_SPLASH_PARTICLE.get(), WaterDropParticle.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.DUST_PARTICLE.get(), DustStormParticle.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.LIGHTNING_PARTICLE.get(), LightningParticles.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.SHOOTING_STAR_PARTICLE.get(), MeteorParticles.Provider::new);
        minecraft.particleEngine.register(CelestialParticles.STUN_PARTICLE.get(), StunParticle.Provider::new);

        minecraft.particleEngine.register(CelestialParticles.MARS_PORTAL_PARTICLES.get(), CelestialPortalParticle.MarsProvider::new);
        minecraft.particleEngine.register(CelestialParticles.VENUS_PORTAL_PARTICLES.get(), CelestialPortalParticle.VenusProvider::new);
        minecraft.particleEngine.register(CelestialParticles.MOON_PORTAL_PARTICLES.get(), CelestialPortalParticle.MoonProvider::new);
        minecraft.particleEngine.register(CelestialParticles.MERCURY_PORTAL_PARTICLES.get(), CelestialPortalParticle.MercuryProvider::new);
        minecraft.particleEngine.register(CelestialParticles.JUPITER_PORTAL_PARTICLES.get(), CelestialPortalParticle.JupiterProvider::new);
        minecraft.particleEngine.register(CelestialParticles.EUROPA_PORTAL_PARTICLES.get(), CelestialPortalParticle.EuropaProvider::new);
        minecraft.particleEngine.register(CelestialParticles.CALLISTO_PORTAL_PARTICLES.get(), CelestialPortalParticle.CallistoProvider::new);
        minecraft.particleEngine.register(CelestialParticles.IO_PORTAL_PARTICLES.get(), CelestialPortalParticle.IoProvider::new);

        minecraft.particleEngine.register(CelestialParticles.SPACESHIP_PARTICLES.get(), SpaceshipParticles.Provider::new);
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, WorkbenchSmeltingRecipe.Type.ID, WorkbenchSmeltingRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, WorkbenchCraftingRecipe.Type.ID, WorkbenchCraftingRecipe.Type.INSTANCE);
    }
}