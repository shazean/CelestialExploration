package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.CelestialCat;
import com.shim.celestialexploration.entity.mob.*;
import com.shim.celestialexploration.entity.mob.piglins.AstralPiglin;
import com.shim.celestialexploration.entity.mob.piglins.CyborgPiglin;
import com.shim.celestialexploration.entity.mob.piglins.VoidedPiglin;
import com.shim.celestialexploration.entity.mob.slimes.*;
import com.shim.celestialexploration.entity.model.MagCartModel;
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
import net.minecraft.core.Registry;
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
public class ModEventBusEvents {


    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.RUST_SLIME.get(), RustSlime.setAttributes());
        event.put(EntityRegistry.LUNAR_SLIME.get(), LunarSlime.setAttributes());
        event.put(EntityRegistry.MARS_MALLOW.get(), MarsMallow.setAttributes());
        event.put(EntityRegistry.LURKER.get(), Lurker.setAttributes());
        event.put(EntityRegistry.VOIDFELLOW.get(), VoidFellow.setAttributes());
        event.put(EntityRegistry.VOIDED.get(), Voided.setAttributes());
        event.put(EntityRegistry.SULFUR_CUBE.get(), SulfurCube.setAttributes());
        event.put(EntityRegistry.VOIDED_PIGLIN.get(), VoidedPiglin.setAttributes());
        event.put(EntityRegistry.FLARE.get(), Flare.setAttributes());
        event.put(EntityRegistry.GUST.get(), Gust.setAttributes());
        event.put(EntityRegistry.GYST.get(), Gyst.setAttributes());
        event.put(EntityRegistry.ASTRAL_PIGLIN.get(), AstralPiglin.setAttributes());
        event.put(EntityRegistry.CYBORG_PIGLIN.get(), CyborgPiglin.setAttributes());
        event.put(EntityRegistry.ASTRAL_HOGLIN.get(), AstralHoglin.setAttributes());
        event.put(EntityRegistry.VOIDED_ZOGLIN.get(), VoidedZoglin.setAttributes());

        event.put(EntityRegistry.QUICKSILVER_SLIME.get(), QuicksilverSlime.setAttributes());
        event.put(EntityRegistry.VISCOUS_SLIME.get(), ViscousSlime.setAttributes());
        event.put(EntityRegistry.METEOR_CRAWLER.get(), MeteorCrawler.createAttributes().build());
        event.put(EntityRegistry.VOID_CRAWLER.get(), VoidCrawler.createAttributes().build());
        event.put(EntityRegistry.CELESTIAL_CAT.get(), CelestialCat.createAttributes().build());

    }

        @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
//        for (Spaceship.Type spaceship$type : Spaceship.Type.values())
//            event.registerLayerDefinition(SpaceshipRenderer.createSpaceshipModelName(spaceship$type), SpaceshipModel::createBodyLayer);

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

    }


    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.RUST_SLIME_PARTICLES.get(), CelestialSlimeParticles.RustProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.LUNAR_SLIME_PARTICLES.get(), CelestialSlimeParticles.LunarProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MARS_MALLOW_SLIME_PARTICLES.get(), CelestialSlimeParticles.MallowProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.QUICKSILVER_SLIME_PARTICLES.get(), CelestialSlimeParticles.QuickSilverProvider::new);

        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_CUBE_PARTICLES.get(), CelestialSlimeParticles.SulfurProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_PARTICLE.get(), SulfurParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_FIRE_FLAME.get(), FlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_SPLASH_PARTICLE.get(), WaterDropParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.DUST_PARTICLE.get(), DustStormParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.LIGHTNING_PARTICLE.get(), LightningParticles.Provider::new);


        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MARS_PORTAL_PARTICLES.get(), CelestialPortalParticle.MarsProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.VENUS_PORTAL_PARTICLES.get(), CelestialPortalParticle.VenusProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MOON_PORTAL_PARTICLES.get(), CelestialPortalParticle.MoonProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MERCURY_PORTAL_PARTICLES.get(), CelestialPortalParticle.MercuryProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.JUPITER_PORTAL_PARTICLES.get(), CelestialPortalParticle.JupiterProvider::new);

        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SPACESHIP_PARTICLES.get(), SpaceshipParticles.Provider::new);

    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, WorkbenchSmeltingRecipe.Type.ID, WorkbenchSmeltingRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, WorkbenchCraftingRecipe.Type.ID, WorkbenchCraftingRecipe.Type.INSTANCE);
    }
}