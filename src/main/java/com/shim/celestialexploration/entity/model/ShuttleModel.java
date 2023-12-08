package com.shim.celestialexploration.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.entity.Shuttle;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

@OnlyIn(Dist.CLIENT)
public class ShuttleModel<T extends Shuttle> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "shuttle"), "main");
    private final ModelPart Body;
    private final ModelPart Chest;
    private final ModelPart Chest2;
    private final ModelPart Chest3;
    private final ModelPart FrontSeat;
    private final ModelPart RightSeat;
    private final ModelPart LeftSeat;
    private final ModelPart RightWing;
    private final ModelPart LeftWing;
    private final ModelPart BackBooster;
    private final ModelPart LeftBooster;
    private final ModelPart RightBooster;
    private final ModelPart RightTailWing;
    private final ModelPart LeftTailWing;

    public ShuttleModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Chest = root.getChild("Chest");
        this.Chest2 = root.getChild("Chest2");
        this.Chest3 = root.getChild("Chest3");
        this.FrontSeat = root.getChild("FrontSeat");
        this.RightSeat = root.getChild("RightSeat");
        this.LeftSeat = root.getChild("LeftSeat");
        this.RightWing = root.getChild("RightWing");
        this.LeftWing = root.getChild("LeftWing");
        this.BackBooster = root.getChild("BackBooster");
        this.LeftBooster = root.getChild("LeftBooster");
        this.RightBooster = root.getChild("RightBooster");
        this.RightTailWing = root.getChild("RightTailWing");
        this.LeftTailWing = root.getChild("LeftTailWing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -2.0F, -57.0F, 40.0F, 2.0F, 144.0F, new CubeDeformation(0.0F))
                .texOffs(0, 146).addBox(-14.5F, -2.0F, -87.0F, 29.0F, 2.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(224, 0).addBox(-14.5F, -19.0F, -93.25F, 29.0F, 16.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 292).addBox(-23.75F, -37.75F, -57.0F, 2.0F, 36.0F, 144.0F, new CubeDeformation(0.0F))
                .texOffs(0, 146).addBox(-12.5F, -49.0F, -57.0F, 25.0F, 2.0F, 144.0F, new CubeDeformation(0.0F))
                .texOffs(194, 148).addBox(21.75F, -37.75F, -57.0F, 2.0F, 36.0F, 144.0F, new CubeDeformation(0.0F))
                .texOffs(194, 164).addBox(-22.0F, -47.0F, 85.0F, 44.0F, 45.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 200).addBox(-0.3108F, -5.7405F, -36.4177F, 2.0F, 14.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.75F, -30.75F, -57.5F, 0.4685F, -0.2419F, -0.043F));

        PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 17).addBox(0.0F, -7.0F, -5.5F, 2.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.75F, -29.0F, -57.0F, 0.0406F, -0.1745F, 0.0177F));

        PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, -7.0F, -5.5F, 2.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -29.0F, -57.0F, 0.0406F, 0.1745F, -0.0177F));

        PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(194, 211).addBox(-1.6892F, -5.7405F, -36.4177F, 2.0F, 14.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -30.75F, -57.5F, 0.4685F, 0.2419F, 0.043F));

        PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(148, 449).addBox(0.0F, -16.0F, -56.0F, 2.0F, 16.0F, 144.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.75F, -37.75F, -1.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 120).addBox(-14.5F, -1.0F, -4.0F, 29.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.9974F, -84.3203F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(66, 44).addBox(-14.5F, -19.85F, 2.4F, 29.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -87.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(66, 111).addBox(-14.5F, -2.0F, -7.0F, 29.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -87.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r9 = Body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(224, 82).addBox(0.25F, -2.0F, -16.5F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.3586F, 0.0F, -72.856F, -0.1022F, 0.2415F, -0.4051F));

        PartDefinition cube_r10 = Body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(10, 0).addBox(-2.25F, -1.1F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.6556F, -1.7849F, -55.9083F, -0.0175F, 0.1049F, -0.4354F));

        PartDefinition cube_r11 = Body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(253, 178).addBox(-4.25F, -2.0F, -16.5F, 4.0F, 2.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.3586F, 0.0F, -72.856F, -0.1022F, -0.2415F, 0.4051F));

        PartDefinition cube_r12 = Body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(12, 23).addBox(-1.75F, -1.1F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.6556F, -1.7849F, -55.9083F, -0.0175F, -0.1049F, 0.4354F));

        PartDefinition cube_r13 = Body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(282, 224).addBox(0.0F, -1.0F, -21.5F, 6.0F, 2.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.75F, -17.75F, -36.5F, 2.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(224, 31).addBox(-3.75F, -20.75F, -30.5F, 2.0F, 20.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -1.0F, -56.5F, 0.0F, -0.2618F, 0.0F));

        PartDefinition cube_r14 = Body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 0).addBox(1.75F, -17.75F, -36.5F, 2.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(247, 234).addBox(1.75F, -20.75F, -30.5F, 2.0F, 20.0F, 31.0F, new CubeDeformation(0.0F))
                .texOffs(342, 204).addBox(-6.0F, -1.0F, -21.5F, 6.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, -1.0F, -56.5F, 0.0F, 0.2618F, 0.0F));

        PartDefinition cube_r15 = Body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(440, 449).addBox(0.0F, -2.0F, -56.0F, 4.0F, 2.0F, 144.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r16 = Body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(490, 0).addBox(-4.0F, -2.0F, -56.0F, 4.0F, 2.0F, 144.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r17 = Body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(342, 121).addBox(-2.0F, -16.0F, -56.0F, 2.0F, 16.0F, 144.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -37.75F, -1.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition WindShield = Body.addOrReplaceChild("WindShield", CubeListBuilder.create(), PartPose.offset(0.0F, -49.0F, -57.0F));

        PartDefinition cube_r18 = WindShield.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, 0.0F, -42.0F, 25.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7243F, 0.0F, 0.0F));

        PartDefinition cube_r19 = WindShield.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(66, 58).addBox(0.3447F, -8.4592F, -35.5745F, 2.0F, 17.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.386F, 6.3003F, 0.0F, 0.1244F, -0.5449F, 0.8331F));

        PartDefinition cube_r20 = WindShield.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(48, 218).addBox(-2.3447F, -8.4592F, -35.5745F, 2.0F, 17.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.386F, 6.3003F, 0.0F, 0.1244F, 0.5449F, -0.8331F));

        PartDefinition Chest = partdefinition.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(48, 324).addBox(-4.0F, -16.0F, -12.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(32, 4).addBox(12.0F, -13.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.0F, 22.0F, 49.0F));

        PartDefinition Chest2 = partdefinition.addOrReplaceChild("Chest2", CubeListBuilder.create().texOffs(64, 292).addBox(-4.0F, -16.0F, -12.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(16, 27).addBox(12.0F, -13.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.0F, 22.0F, 31.0F));

        PartDefinition Chest3 = partdefinition.addOrReplaceChild("Chest3", CubeListBuilder.create().texOffs(0, 255).addBox(-12.0F, -16.0F, -12.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(26, 0).addBox(-14.0F, -13.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 22.0F, 41.0F));

        PartDefinition FrontSeat = partdefinition.addOrReplaceChild("FrontSeat", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(48, 356).addBox(-7.0F, -5.0F, -6.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -64.0F));

        PartDefinition cube_r21 = FrontSeat.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(64, 271).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 1.309F, 0.0F, 0.0F));

        PartDefinition RightSeat = partdefinition.addOrReplaceChild("RightSeat", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(334, 355).addBox(-7.0F, -5.0F, -6.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, 17.0F, -45.0F));

        PartDefinition cube_r22 = RightSeat.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(259, 42).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 1.309F, 0.0F, 0.0F));

        PartDefinition LeftSeat = partdefinition.addOrReplaceChild("LeftSeat", CubeListBuilder.create().texOffs(16, 44).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(282, 247).addBox(-7.0F, -5.0F, -6.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 17.0F, -45.0F));

        PartDefinition cube_r23 = LeftSeat.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(44, 200).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 1.309F, 0.0F, 0.0F));

        PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offset(-23.0F, 19.0F, 37.0F));

        PartDefinition cube_r24 = RightWing.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(148, 357).addBox(-40.5F, -2.0F, -23.0F, 60.0F, 4.0F, 24.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-52.7948F, -2.0F, 30.6806F, 0.0F, 0.2967F, 0.0F));

        PartDefinition cube_r25 = RightWing.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 189).addBox(-27.0F, -2.0F, -4.5F, 57.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0139F, -4.0F, 36.2232F, -0.0831F, -0.0511F, -0.087F));

        PartDefinition cube_r26 = RightWing.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(194, 155).addBox(-58.4998F, -3.1843F, -4.5401F, 58.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6087F, -4.0F, 45.5167F, -0.2136F, -0.0623F, -0.0854F));

        PartDefinition cube_r27 = RightWing.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(259, 31).addBox(-72.0F, -4.0F, -14.0F, 34.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(224, 132).addBox(-91.0F, -4.0F, -7.0F, 91.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 48.0F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r28 = RightWing.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(254, 388).addBox(-16.0F, -1.0F, -21.0F, 32.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.1522F, -6.0978F, 12.6618F, 0.0453F, 0.0008F, -0.1158F));

        PartDefinition cube_r29 = RightWing.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(519, 283).addBox(0.0754F, -1.0F, -59.0535F, 32.0F, 2.0F, 118.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.0F, -3.0F, -21.0F, 0.0453F, -0.478F, -0.0983F));

        PartDefinition cube_r30 = RightWing.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(292, 328).addBox(-1.0F, -4.0F, 0.0F, 55.0F, 4.0F, 117.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -73.0F, 0.0F, -0.48F, 0.0F));

        PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offset(23.0F, 19.0F, 37.0F));

        PartDefinition cube_r31 = LeftWing.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(148, 328).addBox(-19.5F, -2.0F, -23.0F, 60.0F, 4.0F, 24.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(52.7948F, -2.0F, 30.6806F, 0.0F, -0.2967F, 0.0F));

        PartDefinition cube_r32 = LeftWing.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 178).addBox(-30.0F, -2.0F, -4.5F, 57.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0139F, -4.0F, 36.2232F, -0.0831F, 0.0511F, 0.087F));

        PartDefinition cube_r33 = LeftWing.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(194, 146).addBox(0.4998F, -3.1843F, -4.5401F, 58.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6087F, -4.0F, 45.5167F, -0.2136F, 0.0623F, 0.0854F));

        PartDefinition cube_r34 = LeftWing.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(238, 213).addBox(38.0F, -4.0F, -14.0F, 34.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(224, 121).addBox(0.0F, -4.0F, -7.0F, 91.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 48.0F, 0.0F, 0.0436F, 0.0F));

        PartDefinition cube_r35 = LeftWing.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(148, 386).addBox(-16.0F, -1.0F, -21.0F, 32.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1522F, -6.0978F, 12.6618F, 0.0453F, -0.0008F, 0.1158F));

        PartDefinition cube_r36 = LeftWing.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(516, 163).addBox(-32.0754F, -1.0F, -59.0535F, 32.0F, 2.0F, 118.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.0F, -3.0F, -21.0F, 0.0453F, 0.478F, 0.0983F));

        PartDefinition cube_r37 = LeftWing.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(224, 0).addBox(-54.0F, -4.0F, 0.0F, 55.0F, 4.0F, 117.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -73.0F, 0.0F, 0.48F, 0.0F));

        PartDefinition BackBooster = partdefinition.addOrReplaceChild("BackBooster", CubeListBuilder.create().texOffs(0, 292).addBox(-12.0F, -31.0F, 91.0F, 23.0F, 24.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(88, 146).addBox(-10.0F, -27.0F, 86.0F, 19.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition LeftBooster = partdefinition.addOrReplaceChild("LeftBooster", CubeListBuilder.create().texOffs(342, 175).addBox(-18.0F, -2.0F, 30.0F, 20.0F, 20.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 94).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 16.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(29.0F, -20.75F, 57.0F));

        PartDefinition cube_r38 = LeftBooster.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(300, 355).addBox(-11.05F, 0.0F, -19.75F, 7.5F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.48F, 0.0F));

        PartDefinition cube_r39 = LeftBooster.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 336).addBox(-10.4622F, -7.3076F, -11.4375F, 11.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2401F, 6.6227F, -7.4459F, -0.2546F, 0.4114F, -0.577F));

        PartDefinition cube_r40 = LeftBooster.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(194, 265).addBox(-11.0F, -2.0F, -15.0F, 11.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.48F, 0.0F));

        PartDefinition RightBooster = partdefinition.addOrReplaceChild("RightBooster", CubeListBuilder.create().texOffs(342, 146).addBox(-6.2401F, -8.6227F, 37.4459F, 20.0F, 20.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 44).addBox(-4.2401F, -6.6227F, 7.4459F, 16.0F, 16.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.7599F, -14.1273F, 49.5541F));

        PartDefinition cube_r41 = RightBooster.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(318, 328).addBox(-0.5378F, -7.3076F, -11.4375F, 11.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2546F, -0.4114F, 0.577F));

        PartDefinition cube_r42 = RightBooster.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(92, 0).addBox(0.0F, -2.0F, -15.0F, 11.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2401F, 1.3773F, 7.4459F, 0.0F, -0.48F, 0.0F));

        PartDefinition cube_r43 = RightBooster.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(342, 227).addBox(3.55F, 0.0F, -19.75F, 7.5F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2401F, -6.6227F, 7.4459F, 0.0F, -0.48F, 0.0F));

        PartDefinition RightTailWing = partdefinition.addOrReplaceChild("RightTailWing", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.0F, -23.0F, 54.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition cube_r44 = RightTailWing.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(269, 61).addBox(-2.0F, -14.5F, -12.5F, 4.0F, 27.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.407F, -10.2842F, 22.8257F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r45 = RightTailWing.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(112, 324).addBox(0.407F, -32.5342F, 2.3257F, 4.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -7.0F, -0.5644F, 0.0F, 0.0F));

        PartDefinition LeftTailWing = partdefinition.addOrReplaceChild("LeftTailWing", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0F, -23.0F, 54.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r46 = LeftTailWing.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(88, 200).addBox(-2.0F, -14.5F, -12.5F, 4.0F, 27.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.407F, -10.2842F, 22.8257F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r47 = LeftTailWing.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(294, 164).addBox(-4.407F, -32.5342F, 2.3257F, 4.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -7.0F, -0.5644F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 1024, 1024);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
       renderPitch(entity);
       renderRoll(entity);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Chest2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Chest3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        FrontSeat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightSeat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftSeat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        BackBooster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftBooster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightBooster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        RightTailWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        LeftTailWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    private void renderPitch(Shuttle shuttle) {
        double f1 = shuttle.getDeltaMovement().y;
        float pitch = 0.055F;

        if (f1 > 0) {
            this.Body.xRot = -pitch;
            this.Chest.xRot = -pitch;
            this.Chest2.xRot = -pitch;
            this.Chest3.xRot = -pitch;
            this.FrontSeat.xRot = -pitch;
            this.RightSeat.xRot = -pitch;
            this.LeftSeat.xRot = -pitch;
            this.RightWing.xRot = -pitch;
            this.LeftWing.xRot = -pitch;
            this.BackBooster.xRot = -pitch;
            this.LeftBooster.xRot = -pitch;
            this.RightBooster.xRot = -pitch;
            this.RightTailWing.xRot = -pitch;
            this.LeftTailWing.xRot = -pitch;
        } else if (f1 < 0) {
            this.Body.xRot = pitch;
            this.Chest.xRot = pitch;
            this.Chest2.xRot = pitch;
            this.Chest3.xRot = pitch;
            this.FrontSeat.xRot = pitch;
            this.RightSeat.xRot = pitch;
            this.LeftSeat.xRot = pitch;
            this.RightWing.xRot = pitch;
            this.LeftWing.xRot = pitch;
            this.BackBooster.xRot = pitch;
            this.LeftBooster.xRot = pitch;
            this.RightBooster.xRot = pitch;
            this.RightTailWing.xRot = pitch;
            this.LeftTailWing.xRot = pitch;
        } else {
            this.Body.xRot = 0;
            this.Chest.xRot = 0;
            this.Chest2.xRot = 0;
            this.Chest3.xRot = 0;
            this.FrontSeat.xRot = 0;
            this.RightSeat.xRot = 0;
            this.LeftSeat.xRot = 0;
            this.RightWing.xRot = 0;
            this.LeftWing.xRot = 0;
            this.BackBooster.xRot = 0;
            this.LeftBooster.xRot = 0;
            this.RightBooster.xRot = 0;
            this.RightTailWing.xRot = 0;
            this.LeftTailWing.xRot = 0;
        }
    }

    private void renderRoll(Shuttle shuttle) {
        double f1 = shuttle.deltaRotation;
        float pitch = 0.075F;

        if (f1 > 0) {
            this.Body.zRot = -pitch;
            this.Chest.zRot = -pitch;
            this.Chest2.zRot = -pitch;
            this.Chest3.zRot = -pitch;
            this.FrontSeat.zRot = -pitch;
            this.RightSeat.zRot = -pitch;
            this.LeftSeat.zRot = -pitch;
            this.RightWing.zRot = -pitch;
            this.LeftWing.zRot = -pitch;
            this.BackBooster.zRot = -pitch;
            this.LeftBooster.zRot = -pitch;
            this.RightBooster.zRot = -pitch;
            this.RightTailWing.zRot = -pitch;
            this.LeftTailWing.zRot = -pitch;
        } else if (f1 < 0) {
            this.Body.zRot = pitch;
            this.Chest.zRot = pitch;
            this.Chest2.zRot = pitch;
            this.Chest3.zRot = pitch;
            this.FrontSeat.zRot = pitch;
            this.RightSeat.zRot = pitch;
            this.LeftSeat.zRot = pitch;
            this.RightWing.zRot = pitch;
            this.LeftWing.zRot = pitch;
            this.BackBooster.zRot = pitch;
            this.LeftBooster.zRot = pitch;
            this.RightBooster.zRot = pitch;
            this.RightTailWing.zRot = pitch;
            this.LeftTailWing.zRot = pitch;
        } else {
            this.Body.zRot = 0;
            this.Chest.zRot = 0;
            this.Chest2.zRot = 0;
            this.Chest3.zRot = 0;
            this.FrontSeat.zRot = 0;
            this.RightSeat.zRot = 0;
            this.LeftSeat.zRot = 0;
            this.RightWing.zRot = 0;
            this.LeftWing.zRot = 0;
            this.BackBooster.zRot = 0;
            this.LeftBooster.zRot = 0;
            this.RightBooster.zRot = 0;
            this.RightTailWing.zRot = 0;
            this.LeftTailWing.zRot = 0;
        }
    }

}