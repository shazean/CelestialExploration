package com.shim.celestialexploration.entity.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MagCartModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;

    public MagCartModel(ModelPart p_170737_) {
        this.root = p_170737_;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
//        int i = 20;
//        int j = 8;
//        int k = 16;
//        int l = 4;
//        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 10).addBox(-10.0F, -8.0F, -1.0F, 20.0F, 16.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));
//        partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -9.0F, -1.0F, 16.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-9.0F, 4.0F, 0.0F, 0.0F, ((float)Math.PI * 1.5F), 0.0F));
//        partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -9.0F, -1.0F, 16.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(9.0F, 4.0F, 0.0F, 0.0F, ((float)Math.PI / 2F), 0.0F));
//        partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -9.0F, -1.0F, 16.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -7.0F, 0.0F, (float)Math.PI, 0.0F));
//        partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -9.0F, -1.0F, 16.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 4.0F, 7.0F));
        partdefinition.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-10.0F, -8.0F, 5.0F, 20.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-10.0F, -8.0F, 2.0F, 20.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 13.0F, -1.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 28).mirror().addBox(-8.0F, 0.0F, -1.0F, 16.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 13.0F, -1.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 28).mirror().addBox(-8.0F, 0.0F, -1.0F, 16.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -1.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
        partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 13.0F, -1.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 43).mirror().addBox(-8.0F, 0.0F, -1.0F, 16.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -7.0F, 0.0F, -3.1416F, 0.0F));
        partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(-8.0F, 0.0F, -1.0F, 16.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-8.0F, 13.0F, -1.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(T p_103100_, float p_103101_, float p_103102_, float p_103103_, float p_103104_, float p_103105_) {
    }

    public ModelPart root() {
        return this.root;
    }
}