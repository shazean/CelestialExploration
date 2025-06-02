package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.rewrite.model.AzBakedModel;
import mod.azure.azurelib.rewrite.model.AzBone;
import mod.azure.azurelib.rewrite.render.AzRendererConfig;
import mod.azure.azurelib.rewrite.render.AzRendererPipeline;
import mod.azure.azurelib.rewrite.render.AzRendererPipelineContext;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererPipeline;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererPipelineContext;
import mod.azure.azurelib.rewrite.render.armor.bone.AzArmorBoneContext;
import mod.azure.azurelib.rewrite.render.armor.bone.AzArmorBoneProvider;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class SpacesuitRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/spacesuit.geo.json");

    public SpacesuitRenderer(ResourceLocation texture) {
        super(AzArmorRendererConfig.builder(GEO, texture).build());
    }

    public SpacesuitRenderer(String texture) {
        this(CelestialUtil.getModLoc("textures/models/armor/" + texture + ".png"));
    }

    @Override
    protected AzArmorRendererPipeline createPipeline(AzRendererConfig config) {
        return new AzArmorRendererPipeline(config, this){
            @Override
            protected AzRendererPipelineContext<ItemStack> createContext(AzRendererPipeline<ItemStack> rendererPipeline) {
                return  new AzArmorRendererPipelineContext(rendererPipeline){
                    @Override
                    public AzArmorBoneContext boneContext() {
                        return new AzArmorBoneContext(){
                            private AzBone armorWaistBone;

                            public AzBone getArmorLeggingTorsoBone(AzBakedModel model) {
                                return model.getBone("bipedWaist").orElse(null);
                            }

                            @Override
                            public void grabRelevantBones(AzBakedModel model, AzArmorBoneProvider boneProvider) {
                                super.grabRelevantBones(model, boneProvider);
                                this.armorWaistBone = this.getArmorLeggingTorsoBone(model) ;
                            }

                            @Override
                            public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
                                setAllVisible(false);

                                // Hide the legging torso bone initially
                                this.setBoneVisible(this.armorWaistBone, false);

                                switch (currentSlot) {
                                    case HEAD -> setBoneVisible(this.head, true);
                                    case CHEST -> {
                                        setBoneVisible(this.body, true);
                                        setBoneVisible(this.rightArm, true);
                                        setBoneVisible(this.leftArm, true);
                                    }
                                    case LEGS -> {
                                        // Make the legging torso bone visible when the legging armor is equiped
                                        this.setBoneVisible(this.armorWaistBone, true);
                                        setBoneVisible(this.rightLeg, true);
                                        setBoneVisible(this.leftLeg, true);
                                    }
                                    case FEET -> {
                                        setBoneVisible(this.rightBoot, true);
                                        setBoneVisible(this.leftBoot, true);
                                    }
                                    case MAINHAND, OFFHAND -> { /* NO-OP */ }
                                }
                            }

                            @Override
                            public void applyBaseTransformations(HumanoidModel<?> baseModel) {
                                super.applyBaseTransformations(baseModel);
                                if (this.armorWaistBone != null) {
                                    ModelPart modelPart = baseModel.body;
                                    RenderUtils.matchModelPartRot(modelPart, this.armorWaistBone);
                                    this.armorWaistBone.updatePosition(modelPart.x, -modelPart.y, modelPart.z);
                                }
                            }
                        };
                    }
                };
            }
        };
    }
}
