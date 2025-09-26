package com.shim.celestialexploration.entity.client.model;

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
    private final ModelPart base;
    private final ModelPart top;

    public MagCartModel(ModelPart root) {
        this.root = root.getChild("root");
        this.base = this.root.getChild("base");
        this.top = this.root.getChild("top");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -10.0F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(18, 51).addBox(-8.0F, -10.0F, -10.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 51).addBox(-8.0F, -10.0F, 8.0F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 63).addBox(6.0F, -10.0F, -8.0F, 2.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 63).mirror().addBox(-8.0F, -10.0F, -8.0F, 2.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition top = root.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -25.0F, -10.0F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(20, 2).mirror().addBox(8.0F, -23.0F, -10.0F, 0.0F, 13.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 2).mirror().addBox(-8.0F, -23.0F, -10.0F, 0.0F, 13.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 35).addBox(-8.0F, -23.0F, -10.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).mirror().addBox(-8.0F, -23.0F, 10.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setupAnim(T p_103100_, float p_103101_, float p_103102_, float p_103103_, float p_103104_, float p_103105_) {
    }

    public ModelPart root() {
        return this.root;
    }
}