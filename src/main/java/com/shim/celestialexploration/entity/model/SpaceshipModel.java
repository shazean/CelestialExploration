package com.shim.celestialexploration.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.Spaceship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpaceshipModel<T extends Spaceship> extends EntityModel<T> {
//    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CelestialExploration.MODID, "spaceship"), "main");
    private final ModelPart front;
    private final ModelPart chest;
    private final ModelPart seat;
    private final ModelPart backSeat;
    private final ModelPart tail;
    private final ModelPart body;
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public SpaceshipModel(ModelPart root) {
        this.front = root.getChild("front");
        this.chest = root.getChild("chest");
        this.seat = root.getChild("seat");
        this.backSeat = root.getChild("backSeat");
        this.tail = root.getChild("tail");
        this.body = root.getChild("body");
        this.leftWing = root.getChild("leftWing");
        this.rightWing = root.getChild("rightWing");
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition front = partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(119, 52).addBox(-9.5F, -6.25F, -44.75F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(119, 116).addBox(-9.0F, -25.25F, -44.75F, 18.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 46).addBox(-0.8357F, -0.1862F, -3.8798F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.6729F, -43.1811F, -20.8765F, 0.6502F, 0.2773F, -0.1166F));
        PartDefinition cube_r2 = front.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(49, 36).addBox(-0.1643F, -0.1862F, -3.8798F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.6729F, -43.1811F, -20.8765F, 0.6502F, -0.2773F, 0.1166F));
        PartDefinition cube_r3 = front.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(122, 122).addBox(-1.0F, -2.0F, -25.0F, 2.0F, 2.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, -19.75F, -0.1745F, 0.2182F, 0.0F));
        PartDefinition cube_r4 = front.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(29, 151).addBox(-1.7708F, -0.4838F, -0.5714F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.25F, -3.5F, -30.75F, -0.1705F, 0.0462F, 0.0302F));
        PartDefinition cube_r5 = front.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(91, 156).addBox(-0.2292F, -0.4838F, -0.5714F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -3.5F, -30.75F, -0.1705F, -0.0462F, -0.0302F));
        PartDefinition cube_r6 = front.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(35, 36).addBox(-1.7814F, -1.0318F, -0.9184F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.3732F, -2.9054F, -28.0988F, 0.0709F, -0.2935F, -0.1332F));
        PartDefinition cube_r7 = front.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(35, 97).addBox(-0.2186F, -1.0318F, -0.9184F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.3732F, -2.9054F, -28.0988F, 0.0709F, 0.2935F, 0.1332F));
        PartDefinition cube_r8 = front.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 151).addBox(-1.0F, -2.0F, -25.0F, 2.0F, 2.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, -19.75F, -0.1745F, -0.2182F, 0.0F));
        PartDefinition cube_r9 = front.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(196, 113).addBox(-0.75F, -19.5F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -5.75F, -43.75F, 0.0F, -0.2182F, 0.0F));
        PartDefinition cube_r10 = front.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 0).addBox(-1.8658F, -0.8044F, -0.9777F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.4018F, -34.4152F, -30.9591F, 0.5073F, 0.3247F, -0.1453F));

        PartDefinition cube_r11 = front.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(24, 61).addBox(-0.1342F, -0.8044F, -0.9777F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.4018F, -34.4152F, -30.9591F, 0.5073F, -0.3247F, 0.1453F));

        PartDefinition cube_r12 = front.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(55, 210).addBox(1.5973F, -1.0F, -0.7844F, 2.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2945F, -24.25F, -43.9537F, 0.6545F, -0.2182F, 0.0F));

        PartDefinition cube_r13 = front.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(153, 188).addBox(-0.1668F, -0.2859F, -1.7228F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.3311F, -35.6871F, -30.0227F, 0.6479F, -0.0478F, 0.0205F));

        PartDefinition cube_r14 = front.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(152, 207).addBox(-1.8332F, -0.2859F, -1.7228F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.3311F, -35.6871F, -30.0227F, 0.6479F, 0.0478F, -0.0205F));

        PartDefinition cube_r15 = front.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(259, 259).addBox(-3.5973F, -1.0F, -0.7844F, 2.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2945F, -24.25F, -43.9537F, 0.6545F, 0.2182F, 0.0F));

        PartDefinition cube_r16 = front.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(138, 184).addBox(-1.25F, -19.5F, -1.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -5.75F, -43.75F, 0.0F, 0.2182F, 0.0F));

        PartDefinition ControlPanel = front.addOrReplaceChild("ControlPanel", CubeListBuilder.create().texOffs(46, 55).addBox(-7.0F, -1.5F, -0.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -23.4858F, -41.8413F));

        PartDefinition cube_r17 = ControlPanel.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(40, 77).addBox(-2.0F, -0.7858F, 2.3004F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(49, 95).addBox(-1.5F, -0.2858F, -0.6996F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.0583F, -0.2341F, 0.4413F, 0.1639F, 0.0602F));

        PartDefinition cube_r18 = ControlPanel.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(90, 236).addBox(-7.0F, -1.5F, -0.75F, 14.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -0.5142F, -0.4087F, 0.1309F, 0.0F, 0.0F));

        PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 122).addBox(-15.25F, -16.0F, 19.0F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -14.0F, 25.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition seat = partdefinition.addOrReplaceChild("seat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r19 = seat.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(245, 146).addBox(-6.0F, -10.0F, -1.0F, 12.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -16.5F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r20 = seat.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 107).addBox(-6.0F, -1.0F, -5.5F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9209F, -21.0691F, 0.1484F, 0.0F, 0.0F));

        PartDefinition cube_r21 = seat.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(151, 122).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, -19.0F, -1.2654F, 0.0F, 0.0F));

        PartDefinition backSeat = partdefinition.addOrReplaceChild("backSeat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r22 = backSeat.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(245, 146).addBox(-6.0F, -10.0F, -1.0F, 12.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 1.5F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r23 = backSeat.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 107).addBox(-6.0F, -1.0F, -5.5F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.9209F, -3.0691F, 0.1484F, 0.0F, 0.0F));

        PartDefinition cube_r24 = backSeat.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(151, 122).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, -1.0F, -1.2654F, 0.0F, 0.0F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 111).addBox(22.25F, -48.0F, 36.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 107).addBox(23.0F, -49.0F, 50.25F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 99).addBox(-25.25F, -48.0F, 36.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 103).addBox(-26.0F, -49.0F, 50.25F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r25 = tail.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(42, 122).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.062F, -39.6858F, 52.3991F, -0.0438F, 0.0871F, -0.0057F));

        PartDefinition cube_r26 = tail.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(269, 0).addBox(-0.3F, -0.4F, -0.35F, 1.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -40.25F, 55.0F, 0.323F, 0.025F, 0.0079F));

        PartDefinition cube_r27 = tail.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(269, 38).addBox(-0.7F, -0.4F, -0.35F, 1.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -40.25F, 55.0F, 0.323F, -0.025F, -0.0079F));

        PartDefinition cube_r28 = tail.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(182, 139).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.062F, -39.6858F, 52.3991F, -0.0438F, -0.0871F, 0.0057F));

        PartDefinition cube_r29 = tail.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(10, 0).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -49.0F, 97.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r30 = tail.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 130).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.5F, -47.5F, 52.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r31 = tail.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(261, 38).addBox(-7.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -47.0F, 43.0F, 0.0873F, -0.0436F, 0.0F));

        PartDefinition cube_r32 = tail.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(63, 150).addBox(-1.0F, -2.75F, 3.0F, 42.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -45.0F, 40.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r33 = tail.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(220, 260).addBox(-2.25F, -0.75F, -2.0F, 7.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -44.0F, 28.0F, 0.0873F, -0.9599F, 0.0F));

        PartDefinition cube_r34 = tail.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 151).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.5F, -47.5F, 52.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r35 = tail.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(48, 291).addBox(1.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, -47.0F, 43.0F, 0.0873F, 0.0436F, 0.0F));

        PartDefinition cube_r36 = tail.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(44, 261).addBox(-4.75F, -0.75F, -2.0F, 7.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -44.0F, 28.0F, 0.0873F, 0.9599F, 0.0F));

        PartDefinition cube_r37 = tail.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(143, 0).addBox(-1.0F, -17.0F, -1.75F, 2.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.908F, 105.7439F, -0.2443F, 0.0F, 0.0F));

        PartDefinition cube_r38 = tail.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(171, 184).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.9892F, 94.6362F, -0.8988F, 0.0F, 0.0F));

        PartDefinition cube_r39 = tail.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(63, 122).addBox(-1.0F, 5.0F, 3.0F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.8081F, 86.3174F, -0.4189F, 0.0F, 0.0F));

        PartDefinition cube_r40 = tail.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(245, 135).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.8081F, 86.3174F, 0.5847F, 0.0F, 0.0F));

        PartDefinition cube_r41 = tail.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(189, 202).addBox(-1.0F, -2.0F, 0.5F, 2.0F, 10.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.6613F, 38.6458F, 0.1484F, 0.0F, 0.0F));

        PartDefinition cube_r42 = tail.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(126, 202).addBox(-1.0F, -2.0F, -18.0F, 2.0F, 4.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, 31.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 61).addBox(-15.0F, -2.0F, -21.0F, 30.0F, 2.0F, 59.0F, new CubeDeformation(0.0F))
                .texOffs(245, 171).addBox(-5.0F, -2.0F, 38.0F, 10.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-15.0F, -43.5F, -20.75F, 30.0F, 2.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r43 = body.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(63, 156).addBox(-1.0F, -1.0F, -24.5F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.3498F, -16.557F, 38.25F, -0.0349F, 0.0F, -0.0698F));

        PartDefinition cube_r44 = body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(126, 184).addBox(-2.0F, -1.0F, -1.25F, 3.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.75F, -16.5F, 38.0F, -0.0873F, -0.8727F, 0.0F));

        PartDefinition cube_r45 = body.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(182, 113).addBox(-1.0F, -1.0F, -24.5F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3498F, -16.557F, 38.25F, -0.0349F, 0.0F, 0.0698F));

        PartDefinition cube_r46 = body.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(189, 202).addBox(-1.0F, -1.0F, -1.25F, 3.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.75F, -16.5F, 38.0F, -0.0873F, 0.8727F, 0.0F));

        PartDefinition cube_r47 = body.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(119, 99).addBox(-1.3432F, -25.7846F, -39.0F, 2.0F, 26.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.75F, -17.5F, 18.0F, 0.0F, 0.0F, -0.2094F));

        PartDefinition cube_r48 = body.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 125).addBox(-0.6568F, -25.7846F, -39.0F, 2.0F, 26.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.75F, -17.5F, 18.0F, 0.0F, 0.0F, 0.2094F));

        PartDefinition cube_r49 = body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 277).addBox(-8.852F, -3.287F, 0.8135F, 10.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.4502F, -40.6085F, 36.6901F, -0.2524F, -0.8449F, 0.1227F));

        PartDefinition cube_r50 = body.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(283, 87).addBox(-1.148F, -3.287F, 0.8135F, 10.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.4502F, -40.6085F, 36.6901F, -0.2524F, 0.8449F, -0.1227F));

        PartDefinition cube_r51 = body.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, -13.0F, -0.75F, 2.0F, 26.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7562F, -29.9339F, 38.0F, 0.0F, 0.8727F, 0.2094F));

        PartDefinition cube_r52 = body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(119, 0).addBox(11.1532F, -2.2992F, 10.9231F, 2.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.3708F, -18.7113F, 27.5043F, -0.4279F, -0.7863F, 0.363F));

        PartDefinition cube_r53 = body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(63, 156).addBox(-1.9127F, -0.1685F, 6.0798F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.3708F, -17.3113F, 38.0043F, -0.4279F, -0.7863F, 0.363F));

        PartDefinition cube_r54 = body.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(119, 61).addBox(-13.1532F, -2.2992F, 10.9231F, 2.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.3708F, -18.7113F, 27.5043F, -0.4279F, 0.7863F, -0.363F));

        PartDefinition cube_r55 = body.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(44, 77).addBox(-1.9127F, 1.8315F, 0.0798F, 2.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.3708F, -17.3113F, 38.0043F, -0.0352F, -0.7863F, 0.363F));
        PartDefinition cube_r56 = body.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(182, 113).addBox(-0.0873F, 1.8315F, 0.0798F, 2.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3708F, -17.3113F, 38.0043F, -0.0352F, 0.7863F, -0.363F));
        PartDefinition cube_r57 = body.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(75, 156).addBox(-0.0873F, -0.1685F, 6.0798F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3708F, -17.3113F, 38.0043F, -0.4279F, 0.7863F, -0.363F));
        PartDefinition cube_r58 = body.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 61).addBox(-1.25F, -13.0F, -0.75F, 2.0F, 26.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.7562F, -29.9339F, 38.0F, 0.0F, -0.8727F, -0.2094F));
        PartDefinition cube_r59 = body.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(182, 125).addBox(-1.75F, -17.25F, -39.0F, 2.0F, 18.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -1.0F, 18.0F, 0.0F, 0.0F, 0.3054F));
        PartDefinition cube_r60 = body.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(63, 184).addBox(-0.25F, -17.25F, -39.0F, 2.0F, 18.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -1.0F, 18.0F, 0.0F, 0.0F, -0.3054F));
        PartDefinition cube_r61 = body.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(289, 238).addBox(-6.5437F, -1.0F, -12.9191F, 7.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -1.0F, 46.75F, 0.0F, -0.7854F, 0.0F));
        PartDefinition cube_r62 = body.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(210, 290).addBox(-0.4563F, -1.0F, -12.9191F, 7.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -1.0F, 46.75F, 0.0F, 0.7854F, 0.0F));
        PartDefinition cube_r63 = body.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(126, 207).addBox(-2.0F, -8.0F, -6.75F, 4.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.1345F, 50.9407F, 1.2654F, 0.0F, 0.0F));

        PartDefinition cube_r64 = body.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(128, 265).addBox(-5.0F, -3.25F, -0.25F, 10.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.6859F, 52.1173F, 1.7104F, 0.0F, 0.0F));
        PartDefinition cube_r65 = body.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(119, 99).addBox(-5.0F, -2.0658F, -14.8051F, 10.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.3523F, 51.0017F, 1.2566F, 0.0F, 0.0F));

        PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r66 = leftWing.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(24, 77).addBox(-0.5F, -1.25F, 3.35F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(156, 52).addBox(-0.5F, -1.25F, -1.65F, 11.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.2446F, -26.7775F, 18.7744F, -0.6955F, -0.3778F, 0.1118F));
        PartDefinition cube_r67 = leftWing.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(42, 69).addBox(8.0F, 0.0F, 9.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(189, 225).addBox(0.0F, 0.0F, -2.0F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.8264F, -25.1409F, 5.4861F, 0.2208F, -0.3778F, 0.1118F));

        PartDefinition cube_r68 = leftWing.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 128).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(241, 238).addBox(-1.0F, -2.0F, -1.0F, 13.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.0748F, -26.2902F, 13.706F, -0.6473F, -0.346F, -0.024F));

        PartDefinition cube_r69 = leftWing.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(210, 123).addBox(-4.5F, 0.0F, -0.5F, 5.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0437F, -23.2034F, 23.8964F, -1.3671F, -0.953F, 1.0477F));

        PartDefinition cube_r70 = leftWing.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 53).addBox(0.1309F, -1.634F, -1.1665F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.2902F, -19.9969F, -9.604F, 0.2912F, -0.5138F, -0.077F));

        PartDefinition cube_r71 = leftWing.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(10, 61).addBox(-5.0F, -3.5F, -16.75F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 109).addBox(-14.0F, -3.5F, -16.75F, 9.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 210).addBox(-7.0F, -3.5F, -15.75F, 16.0F, 1.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.2114F, -22.2661F, 5.8027F, 0.269F, -0.346F, -0.024F));
        PartDefinition cube_r72 = leftWing.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(155, 265).addBox(-0.3718F, -0.5189F, 1.032F, 7.0F, 4.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.8534F, -20.7691F, -13.8773F, 0.2538F, -0.093F, 0.0452F));
        PartDefinition cube_r73 = leftWing.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 75).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.6438F, -19.2556F, 30.5632F, 2.2242F, 1.5494F, 1.9187F));
        PartDefinition cube_r74 = leftWing.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(126, 234).addBox(14.75F, -1.5F, -0.101F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(281, 151).addBox(2.75F, -1.5F, -6.101F, 12.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.7407F, -22.6791F, 43.901F, 3.1106F, 0.9903F, 2.81F));

        PartDefinition cube_r75 = leftWing.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(182, 99).addBox(-21.0F, -0.75F, -5.5F, 37.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(43.2759F, -27.2927F, 36.7494F, 0.021F, 0.6238F, -0.2934F));
        PartDefinition cube_r76 = leftWing.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(281, 135).addBox(-0.0229F, -0.3107F, -0.6907F, 27.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(71.3425F, -34.4479F, 1.4369F, -0.0477F, -0.7827F, 0.1601F));
        PartDefinition cube_r77 = leftWing.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(245, 113).addBox(-0.5F, 0.0F, -2.0F, 23.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(67.6174F, -34.6936F, 17.3235F, -0.035F, -0.2595F, 0.1355F));
        PartDefinition cube_r78 = leftWing.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(119, 61).addBox(-2.0F, -1.0F, -1.0F, 58.0F, 4.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, -17.0F, -12.0F, 0.0804F, -0.2494F, -0.3155F));

        PartDefinition LeftWingBooster = leftWing.addOrReplaceChild("LeftWingBooster", CubeListBuilder.create().texOffs(241, 202).addBox(-8.5999F, -8.2348F, -3.9898F, 16.0F, 16.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(126, 207).addBox(-3.5999F, -3.2348F, -5.9898F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(170, 204).addBox(-8.5999F, -5.2348F, -7.9898F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(126, 184).addBox(5.4001F, -8.2348F, -7.9898F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 178).addBox(-6.5999F, 5.7652F, -7.9898F, 12.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(151, 139).addBox(-3.5999F, -8.2348F, -7.9898F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(122, 134).addBox(-6.0F, -6.0F, 17.0F, 11.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(70.5999F, -23.7652F, 13.9898F));

        PartDefinition cube_r79 = LeftWingBooster.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(245, 135).addBox(-2.5F, 0.0671F, -2.0474F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -8.0F, 18.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition cube_r80 = LeftWingBooster.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(147, 149).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.5F, 16.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r81 = LeftWingBooster.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(154, 99).addBox(0.0F, -3.0F, -7.5F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.751F, 0.0F, 23.1214F, 0.0F, 0.2182F, 0.0F));
        PartDefinition cube_r82 = LeftWingBooster.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(0, 162).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 17.0F, 0.0F, -0.2182F, 0.0F));
        PartDefinition cube_r83 = LeftWingBooster.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(45, 151).addBox(-2.5F, -2.5F, 3.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 19.5F, 0.0F, 0.0F, 2.3562F));
        PartDefinition cube_r84 = LeftWingBooster.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(182, 147).addBox(-3.5F, -3.5F, 1.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 19.5F, 0.0F, 0.0F, 1.5708F));
        PartDefinition cube_r85 = LeftWingBooster.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(189, 202).addBox(-4.5F, -4.5F, -0.5F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 19.5F, 0.0F, 0.0F, 0.7854F));
        PartDefinition cube_r86 = LeftWingBooster.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(189, 242).addBox(-6.0F, -44.0F, 15.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5999F, 39.7652F, -7.9898F, 0.3927F, 0.0F, 0.0F));
        PartDefinition cube_r87 = LeftWingBooster.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(245, 159).addBox(-6.0F, -2.0F, -3.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5999F, 7.7652F, -7.9898F, -0.3927F, 0.0F, 0.0F));
        PartDefinition cube_r88 = LeftWingBooster.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(143, 71).addBox(-2.0F, -6.0F, -3.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4001F, -0.2348F, -7.9898F, 0.0F, 0.3927F, 0.0F));
        PartDefinition cube_r89 = LeftWingBooster.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(24, 61).addBox(0.0F, -6.5F, -3.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5999F, 1.2652F, -7.9898F, 0.0F, -0.3927F, 0.0F));

        PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r90 = rightWing.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(24, 16).addBox(-4.5F, -1.25F, 3.35F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(119, 86).addBox(-10.5F, -1.25F, -1.65F, 11.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.2446F, -26.7775F, 18.7744F, -0.6955F, 0.3778F, -0.1118F));

        PartDefinition cube_r91 = rightWing.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(42, 8).addBox(-11.0F, 0.0F, 9.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(182, 139).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-36.8264F, -25.1409F, 5.4861F, 0.2208F, 0.3778F, -0.1118F));
        PartDefinition cube_r92 = rightWing.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(0, 122).addBox(1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(210, 113).addBox(-12.0F, -2.0F, -1.0F, 13.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0748F, -26.2902F, 13.706F, -0.6473F, 0.346F, 0.024F));
        PartDefinition cube_r93 = rightWing.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(90, 210).addBox(-0.5F, 0.0F, -0.5F, 5.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.0437F, -23.2034F, 23.8964F, -1.3671F, 0.953F, -1.0477F));
        PartDefinition cube_r94 = rightWing.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(40, 16).addBox(-3.1309F, -1.634F, -1.1665F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.2902F, -19.9969F, -9.604F, 0.2912F, 0.5138F, 0.077F));
        PartDefinition cube_r95 = rightWing.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(0, 61).addBox(2.0F, -3.5F, -16.75F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 48).addBox(5.0F, -3.5F, -16.75F, 9.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(63, 122).addBox(-9.0F, -3.5F, -15.75F, 16.0F, 1.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.2114F, -22.2661F, 5.8027F, 0.269F, 0.346F, 0.024F));
        PartDefinition cube_r96 = rightWing.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(87, 265).addBox(-6.6282F, -0.5189F, 1.032F, 7.0F, 4.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.8534F, -20.7691F, -13.8773F, 0.2538F, 0.093F, -0.0452F));
        PartDefinition cube_r97 = rightWing.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(0, 14).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.6438F, -19.2556F, 30.5632F, 2.2242F, -1.5494F, -1.9187F));
        PartDefinition cube_r98 = rightWing.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(91, 170).addBox(-23.75F, -1.5F, -0.101F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(196, 265).addBox(-14.75F, -1.5F, -6.101F, 12.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.7407F, -22.6791F, 43.901F, 3.1106F, -0.9903F, -2.81F));

        PartDefinition cube_r99 = rightWing.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(119, 38).addBox(-16.0F, -0.75F, -5.5F, 37.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.2759F, -27.2927F, 36.7494F, 0.021F, -0.6238F, 0.2934F));
        PartDefinition cube_r100 = rightWing.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(269, 71).addBox(-26.9771F, -0.3107F, -0.6907F, 27.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-71.3425F, -34.4479F, 1.4369F, -0.0477F, 0.7827F, -0.1601F));
        PartDefinition cube_r101 = rightWing.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(196, 38).addBox(-22.5F, 0.0F, -2.0F, 23.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-67.6174F, -34.6936F, 17.3235F, -0.035F, 0.2595F, -0.1355F));
        PartDefinition cube_r102 = rightWing.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(119, 0).addBox(-56.0F, -1.0F, -1.0F, 58.0F, 4.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -17.0F, -12.0F, 0.0804F, 0.2494F, 0.3155F));
        PartDefinition rightWingBooster = rightWing.addOrReplaceChild("rightWingBooster", CubeListBuilder.create().texOffs(0, 241).addBox(-7.4001F, -8.2348F, -3.9898F, 16.0F, 16.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(42, 61).addBox(-2.4001F, -3.2348F, -5.9898F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(153, 184).addBox(6.5999F, -5.2348F, -7.9898F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 16).addBox(-7.4001F, -8.2348F, -7.9898F, 2.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(119, 25).addBox(-5.4001F, 5.7652F, -7.9898F, 12.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(151, 133).addBox(-5.4001F, -8.2348F, -7.9898F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(122, 122).addBox(-5.0F, -6.0F, 17.0F, 11.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-70.5999F, -23.7652F, 13.9898F));

        PartDefinition cube_r103 = rightWingBooster.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(29, 165).addBox(-2.5F, 0.0671F, -2.0474F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -8.0F, 18.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition cube_r104 = rightWingBooster.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(63, 137).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.5F, 16.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r105 = rightWingBooster.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -7.5F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.751F, 0.0F, 23.1214F, 0.0F, -0.2182F, 0.0F));
        PartDefinition cube_r106 = rightWingBooster.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(0, 61).addBox(0.0F, -2.0F, -1.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -1.0F, 17.0F, 0.0F, 0.2182F, 0.0F));
        PartDefinition cube_r107 = rightWingBooster.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(78, 122).addBox(-2.5F, -2.5F, 3.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 19.5F, 0.0F, 0.0F, -2.3562F));
        PartDefinition cube_r108 = rightWingBooster.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(42, 0).addBox(-3.5F, -3.5F, 1.5F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 19.5F, 0.0F, 0.0F, -1.5708F));
        PartDefinition cube_r109 = rightWingBooster.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(133, 61).addBox(-4.5F, -4.5F, -0.5F, 9.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 19.5F, 0.0F, 0.0F, -0.7854F));
        PartDefinition cube_r110 = rightWingBooster.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(183, 52).addBox(-6.0F, -44.0F, 15.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5999F, 39.7652F, -7.9898F, 0.3927F, 0.0F, 0.0F));
        PartDefinition cube_r111 = rightWingBooster.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(149, 234).addBox(-6.0F, -2.0F, -3.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5999F, 7.7652F, -7.9898F, -0.3927F, 0.0F, 0.0F));
        PartDefinition cube_r112 = rightWingBooster.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(119, 99).addBox(0.0F, -6.0F, -3.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4001F, -0.2348F, -7.9898F, 0.0F, -0.3927F, 0.0F));
        PartDefinition cube_r113 = rightWingBooster.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -6.5F, -3.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5999F, 1.2652F, -7.9898F, 0.0F, 0.3927F, 0.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        seat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        backSeat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}