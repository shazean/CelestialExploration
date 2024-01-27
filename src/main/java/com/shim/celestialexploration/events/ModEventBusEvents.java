package com.shim.celestialexploration.events;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.*;
import com.shim.celestialexploration.entity.model.MagCartModel;
import com.shim.celestialexploration.entity.model.SpaceshipModel;
import com.shim.celestialexploration.particles.CelestialSlimeParticles;
import com.shim.celestialexploration.particles.SulfurParticle;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import com.shim.celestialexploration.registry.CelestialModelLayers;
import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PiglinModel;
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

import static com.shim.celestialexploration.entity.renderer.SpaceshipRenderer.createSpaceshipModelName;
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

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (Spaceship.Type spaceship$type : Spaceship.Type.values())
            event.registerLayerDefinition(createSpaceshipModelName(spaceship$type), SpaceshipModel::createBodyLayer);

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
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_INNER_ARMOR, () -> innerArmorLayer);
        event.registerLayerDefinition(CelestialModelLayers.VOIDED_OUTER_ARMOR, () -> outerArmorLayer);

        event.registerLayerDefinition(CelestialModelLayers.GUST, () -> piglinLayer);

    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.RUST_SLIME_PARTICLES.get(), CelestialSlimeParticles.RustProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.LUNAR_SLIME_PARTICLES.get(), CelestialSlimeParticles.LunarProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.MARS_MALLOW_SLIME_PARTICLES.get(), CelestialSlimeParticles.MallowProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_CUBE_PARTICLES.get(), CelestialSlimeParticles.SulfurProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_PARTICLE.get(), SulfurParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_FIRE_FLAME.get(), FlameParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ParticleRegistry.SULFUR_SPLASH_PARTICLE.get(), WaterDropParticle.Provider::new);


    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, WorkbenchSmeltingRecipe.Type.ID, WorkbenchSmeltingRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, WorkbenchCraftingRecipe.Type.ID, WorkbenchCraftingRecipe.Type.INSTANCE);

    }
}