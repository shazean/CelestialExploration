package com.shim.celestialexploration.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Spaceship;
import com.shim.celestialexploration.entity.model.SpaceshipModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class SpaceshipRenderer<T extends Spaceship> extends EntityRenderer<T> {

        protected final List<RenderLayer<T, SpaceshipModel<T>>> layers = Lists.newArrayList();

        private static final ResourceLocation[] SPACESHIP_TEXTURE_LOCATIONS = new ResourceLocation[]{
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/black.png"),  new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/grey.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_grey.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/white.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/pink.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/magenta.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/red.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/brown.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/orange.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/yellow.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/lime.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/green.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/cyan.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/light_blue.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/blue.png"), new ResourceLocation(CelestialExploration.MODID, "textures/entity/spaceship/purple.png")};

        private final Map<Spaceship.Type, Pair<ResourceLocation, SpaceshipModel>> spaceshipResources;

        public SpaceshipRenderer(EntityRendererProvider.Context manager) {
                super(manager);
                this.spaceshipResources = Stream.of(Spaceship.Type.values()).collect(ImmutableMap.toImmutableMap((type) ->
                        type, (p_173941_) ->
                        Pair.of(new ResourceLocation("textures/entity/spaceship/" + p_173941_.getName() + ".png"), new SpaceshipModel(manager.bakeLayer(createSpaceshipModelName(p_173941_))))));
        }


        public static ModelLayerLocation createSpaceshipModelName(Spaceship.Type p_171290_) {
                return createLocation("spaceship/" + p_171290_.getName(), "main");
        }

        private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
                return new ModelLayerLocation(new ResourceLocation(CelestialExploration.MODID, p_171301_), p_171302_);
        }

        public final boolean addLayer(RenderLayer<T, SpaceshipModel<T>> p_115327_) {
                return this.layers.add(p_115327_);
        }


        @Override
        public void render(T p_225623_1_, float p_225623_2_, float p_225623_3_, PoseStack poseStack,
                               MultiBufferSource bufferSource, int p_225623_6_) {

                Pair<ResourceLocation, SpaceshipModel> pair = getModelWithLocation(p_225623_1_);
                ResourceLocation resourcelocation = pair.getFirst();
                SpaceshipModel model = pair.getSecond();

                poseStack.pushPose();
                poseStack.translate(0.0D, 1.51D, 0.0D); //originally: 0.0D, 0.375D, 0.0D

                poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));
                poseStack.scale(-1.0F, -1.0F, 1.0F);
//                p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
                model.setupAnim(p_225623_1_, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
                VertexConsumer ivertexbuilder = bufferSource.getBuffer(model.renderType(this.getTextureLocation(p_225623_1_)));
                model.renderToBuffer(poseStack, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

                if (!p_225623_1_.isSpectator()) {
                        for(RenderLayer<T, SpaceshipModel<T>> renderlayer : this.layers) {
                                renderlayer.render(poseStack, bufferSource, p_225623_6_, p_225623_1_, 1, 1, p_225623_3_, 1, 1, 1);
                        }
                }

                poseStack.popPose();
                super.render(p_225623_1_, p_225623_2_, p_225623_3_, poseStack, bufferSource, p_225623_6_);
        }

        public Pair<ResourceLocation, SpaceshipModel> getModelWithLocation(Spaceship spaceship) { return this.spaceshipResources.get(spaceship.getSpaceshipType()); }

        @Override
        public ResourceLocation getTextureLocation(T p_110775_1_) {
                return SPACESHIP_TEXTURE_LOCATIONS[p_110775_1_.getSpaceshipType().ordinal()];
        }
}