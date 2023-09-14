package com.shim.celestialexploration.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Shuttle;
import com.shim.celestialexploration.entity.model.ShuttleModel;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class ShuttleRenderer<T extends Shuttle> extends EntityRenderer<T> {

        private static final ResourceLocation[] SHUTTLE_TEXTURE_LOCATIONS = new ResourceLocation[]{
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/black.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/grey.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/light_grey.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/white.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/pink.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/magenta.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/red.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/brown.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/orange.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/yellow.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/lime.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/green.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/cyan.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/light_blue.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/blue.png"),
                new ResourceLocation(CelestialExploration.MODID, "textures/entity/shuttle/purple.png")};

        private final Map<Shuttle.Type, Pair<ResourceLocation, ShuttleModel>> shuttleResources;

        public ShuttleRenderer(EntityRendererProvider.Context manager) {
                super(manager);
                this.shuttleResources = Stream.of(Shuttle.Type.values()).collect(ImmutableMap.toImmutableMap((type) ->
                        type, (p_173941_) ->
                        Pair.of(new ResourceLocation("textures/entity/shuttle/" + p_173941_.getName() + ".png"), new ShuttleModel(manager.bakeLayer(createShuttleModelName(p_173941_))))));
        }

        public static ModelLayerLocation createShuttleModelName(Shuttle.Type p_171290_) {
                return createLocation("shuttle/" + p_171290_.getName(), "main");
        }

        private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
                return new ModelLayerLocation(new ResourceLocation(CelestialExploration.MODID, p_171301_), p_171302_);
        }

        @Override
        public void render(T p_225623_1_, float p_225623_2_, float p_225623_3_, PoseStack p_225623_4_,
                           MultiBufferSource p_225623_5_, int p_225623_6_) {


                Pair<ResourceLocation, ShuttleModel> pair = getModelWithLocation(p_225623_1_);
                ResourceLocation resourcelocation = pair.getFirst();
                ShuttleModel model = pair.getSecond();

                p_225623_4_.pushPose();
                p_225623_4_.translate(0.0D, 1.1D, 0.0D); //originally: 0.0D, 0.375D, 0.0D
                p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));
                p_225623_4_.scale(-1.0F, -1.0F, 1.0F);
//                p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
                model.setupAnim(p_225623_1_, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
                VertexConsumer ivertexbuilder = p_225623_5_.getBuffer(model.renderType(this.getTextureLocation(p_225623_1_)));
                model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                p_225623_4_.popPose();
                super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);


        }

        public Pair<ResourceLocation, ShuttleModel> getModelWithLocation(Shuttle shuttle) { return this.shuttleResources.get(shuttle.getShuttleType()); }

        @Override
        public ResourceLocation getTextureLocation(T p_110775_1_) {
                return SHUTTLE_TEXTURE_LOCATIONS[p_110775_1_.getShuttleType().ordinal()];
        }

}