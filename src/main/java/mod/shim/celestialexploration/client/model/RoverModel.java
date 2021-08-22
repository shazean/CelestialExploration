package mod.shim.celestialexploration.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.shim.celestialexploration.entity.RoverEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RoverModel<T extends RoverEntity> extends EntityModel<T> {
	private final ModelRenderer rover;
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer rightside;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer rightfrontwheelaxil;
	private final ModelRenderer rightfrontwheel;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer rightmiddlewheelaxil;
	private final ModelRenderer cube_r33;
	private final ModelRenderer rightmiddlewheel;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer rightbackwheelaxil;
	private final ModelRenderer rightbackwheel;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer leftside;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer leftfrontwheelaxil;
	private final ModelRenderer leftfrontwheel;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer leftmiddlewheelaxil;
	private final ModelRenderer cube_r68;
	private final ModelRenderer leftmiddlewheel;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer leftbackwheelaxil;
	private final ModelRenderer leftbackwheel;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer arm;
	private final ModelRenderer lowerarm;
	private final ModelRenderer hand;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;

	public RoverModel() {
		texWidth = 256;
		texHeight = 256;

		rover = new ModelRenderer(this);
		rover.setPos(-10.0F, 5.0F, -10.0F);
		

		body = new ModelRenderer(this);
		body.setPos(10.0F, -5.0F, 10.0F);
		rover.addChild(body);
		body.texOffs(0, 0).addBox(-12.0F, 3.0F, -16.0F, 24.0F, 11.0F, 34.0F, 0.0F, false);
		body.texOffs(95, 103).addBox(-14.6F, 3.0F, -15.6F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		body.texOffs(40, 88).addBox(-13.6F, 4.0F, -15.6F, 2.0F, 3.0F, 5.0F, 0.0F, false);
		body.texOffs(83, 101).addBox(11.6F, 3.0F, -15.6F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		body.texOffs(0, 16).addBox(11.6F, 4.0F, -15.6F, 2.0F, 3.0F, 5.0F, 0.0F, false);
		body.texOffs(18, 16).addBox(-9.4F, 2.4F, -18.0F, 7.0F, 6.0F, 1.0F, 0.0F, false);
		body.texOffs(64, 54).addBox(-1.0F, 5.7F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(50, 48).addBox(-3.0F, 3.0F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(6, 45).addBox(-9.0F, 3.0F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(30, 32).addBox(-9.0F, 7.0F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(10, 28).addBox(-3.2F, 7.3F, -17.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(86, 80).addBox(-12.0F, 2.0F, -11.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		body.texOffs(64, 54).addBox(-2.0F, 2.6F, -16.5F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		body.texOffs(0, 86).addBox(-10.0F, 0.0F, 7.0F, 7.0F, 3.0F, 7.0F, 0.0F, false);
		body.texOffs(86, 71).addBox(-10.0F, -2.0F, 7.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
		body.texOffs(50, 45).addBox(-12.0F, 2.4F, 2.0F, 23.0F, 1.0F, 5.0F, 0.0F, false);
		body.texOffs(0, 16).addBox(7.0F, -1.0F, 9.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		body.texOffs(72, 80).addBox(-3.0F, 2.7F, 8.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		body.texOffs(0, 8).addBox(4.0F, 1.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(27, 0).addBox(-2.0F, 11.0F, -16.3F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(8, 8).addBox(-1.5F, 11.5F, -17.7F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		body.texOffs(14, 127).addBox(5.3F, 1.5F, -13.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(18, 23).addBox(2.0F, -4.0F, 22.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(9.5F, 5.0F, -7.5F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.0873F, 0.0F);
		cube_r1.texOffs(0, 0).addBox(-1.1284F, -4.0F, -7.8716F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(5.5F, 2.0F, -7.5F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.texOffs(18, 0).addBox(0.5F, -1.0F, -4.5F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(5.0F, 3.2F, 10.5F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.3491F, 0.0F);
		cube_r3.texOffs(20, 32).addBox(-1.6F, -0.5F, -0.7F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(3.0F, 3.2F, 8.5F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.5672F, 0.0F);
		cube_r4.texOffs(10, 32).addBox(-2.0F, -0.5F, 0.9F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -0.5F, 18.5F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.5593F, -0.6484F, 0.7675F);
		cube_r5.texOffs(56, 75).addBox(-1.1F, -3.9F, -6.0F, 0.0F, 3.0F, 11.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.4F, -0.5F, 18.5F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.5593F, 0.6484F, -0.7675F);
		cube_r6.texOffs(50, 40).addBox(0.9F, -4.5F, -6.0F, 0.0F, 3.0F, 11.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-8.0F, -0.5F, 18.5F);
		body.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.8054F, 0.2236F, -0.2099F);
		cube_r7.texOffs(40, 74).addBox(0.3F, -1.5F, -6.0F, 5.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, -0.5F, 18.5F);
		body.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.829F, 0.0F, 0.0F);
		cube_r8.texOffs(43, 86).addBox(-0.5F, -1.9F, -6.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		cube_r8.texOffs(21, 77).addBox(0.0F, -4.5F, -6.0F, 0.0F, 3.0F, 11.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(7.5F, -1.0F, 9.5F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.5236F);
		cube_r9.texOffs(82, 28).addBox(-2.25F, -0.25F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 6.0F, 17.0F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.7418F, 0.0F, 0.0F);
		cube_r10.texOffs(67, 91).addBox(3.4F, -11.0F, -6.2F, 6.0F, 17.0F, 2.0F, 0.0F, false);
		cube_r10.texOffs(0, 45).addBox(-10.0F, -11.0F, -5.0F, 20.0F, 17.0F, 10.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(7.7679F, 1.0797F, -1.0F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.0306F, 0.1719F, -0.1772F);
		cube_r11.texOffs(0, 0).addBox(-0.25F, -1.875F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(7.7679F, 1.0797F, -1.0F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.1745F, 0.0F);
		cube_r12.texOffs(8, 0).addBox(-0.7679F, -2.0797F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-8.0F, -1.0F, 10.5F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, 0.48F);
		cube_r13.texOffs(86, 59).addBox(1.0F, -1.7F, -3.5F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(-2.4F, 4.9F, -22.5F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -0.6109F);
		cube_r14.texOffs(72, 74).addBox(-2.5F, -2.1F, 4.5F, 4.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(10.5F, 13.0F, -14.0F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, 0.2618F);
		cube_r15.texOffs(82, 0).addBox(-1.5F, -10.0F, -1.6F, 3.0F, 10.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(40, 74).addBox(-1.5F, -10.0F, 3.4F, 3.0F, 10.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-10.5F, 13.0F, -14.0F);
		body.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.2618F);
		cube_r16.texOffs(82, 14).addBox(-1.5F, -10.0F, 3.4F, 3.0F, 10.0F, 1.0F, 0.0F, false);
		cube_r16.texOffs(20, 103).addBox(-1.5F, -10.0F, -1.6F, 3.0F, 10.0F, 1.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setPos(3.0F, 0.0F, -3.0F);
		rover.addChild(neck);
		setRotationAngle(neck, 0.0873F, 0.0F, 0.0F);
		neck.texOffs(28, 91).addBox(-4.0F, -21.0F, -2.0F, 3.0F, 21.0F, 3.0F, 0.0F, false);
		neck.texOffs(86, 51).addBox(-6.0F, -17.0F, -3.5F, 7.0F, 2.0F, 6.0F, 0.0F, false);
		neck.texOffs(97, 28).addBox(-5.0F, -5.0F, -3.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		neck.texOffs(95, 91).addBox(-3.2F, -5.1F, -2.2F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		neck.texOffs(21, 91).addBox(-7.0F, -11.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(-2.4F, -19.0F, -0.4F);
		neck.addChild(head);
		setRotationAngle(head, 0.0F, -0.2618F, 0.0F);
		head.texOffs(0, 72).addBox(-5.0F, -9.0F, -6.0F, 9.0F, 5.0F, 9.0F, 0.0F, false);
		head.texOffs(83, 91).addBox(-4.0F, -4.0F, -5.4F, 2.0F, 2.0F, 8.0F, 0.0F, false);
		head.texOffs(51, 98).addBox(1.4F, -2.0F, -2.4F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		head.texOffs(0, 96).addBox(0.0F, -8.0F, -7.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		head.texOffs(61, 74).addBox(4.0F, -5.0F, -6.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		head.texOffs(18, 0).addBox(3.7F, -5.2F, 0.7F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		head.texOffs(9, 16).addBox(3.7F, -5.2F, -1.7F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		head.texOffs(27, 3).addBox(1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.texOffs(72, 84).addBox(-1.0F, -4.0F, -4.6F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-2.5F, -4.5F, -6.1F);
		head.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.3927F, 0.0F, 0.0F);
		cube_r17.texOffs(50, 45).addBox(-0.4F, -1.6F, -0.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(1.5F, -6.5F, -6.5F);
		head.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -1.1345F);
		cube_r18.texOffs(95, 95).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		rightside = new ModelRenderer(this);
		rightside.setPos(10.0F, 19.0F, 10.0F);
		rover.addChild(rightside);
		rightside.texOffs(98, 8).addBox(-17.0F, -13.0F, 10.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		rightside.texOffs(91, 126).addBox(-16.0F, -17.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(-12.0F, -16.0F, -3.0F);
		rightside.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.3491F, 0.0F, 0.0F);
		cube_r19.texOffs(64, 71).addBox(-4.0F, -1.0F, -17.0F, 2.0F, 2.0F, 18.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(-12.0F, -12.0F, 10.0F);
		rightside.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.2618F, 0.0F, 0.0F);
		cube_r20.texOffs(82, 14).addBox(-4.9F, -1.1057F, 0.3989F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-12.0F, -12.0F, 10.0F);
		rightside.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.1745F, 0.0F, 0.0F);
		cube_r21.texOffs(0, 96).addBox(-4.9F, -0.7057F, -6.6011F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(-12.0F, -16.0F, -3.0F);
		rightside.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.3054F, 0.0F, 0.0F);
		cube_r22.texOffs(22, 72).addBox(-4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		rightfrontwheelaxil = new ModelRenderer(this);
		rightfrontwheelaxil.setPos(-15.0F, -10.0F, -18.0F);
		rightside.addChild(rightfrontwheelaxil);
		rightfrontwheelaxil.texOffs(103, 126).addBox(-1.0F, -1.1F, -1.3F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rightfrontwheelaxil.texOffs(83, 126).addBox(3.0F, -0.1F, -1.3F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		rightfrontwheel = new ModelRenderer(this);
		rightfrontwheel.setPos(-0.2F, 6.7571F, -0.2321F);
		rightfrontwheelaxil.addChild(rightfrontwheel);
		rightfrontwheel.texOffs(126, 56).addBox(-2.9F, -1.0882F, -4.2023F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		rightfrontwheel.texOffs(115, 126).addBox(-1.9F, -3.9882F, -0.5023F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		rightfrontwheel.texOffs(101, 69).addBox(-1.9F, -0.4882F, -3.5023F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		rightfrontwheel.texOffs(123, 0).addBox(-1.8F, -0.9882F, -1.0523F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.5672F, 0.0F, 0.0F);
		cube_r23.texOffs(123, 12).addBox(-6.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r24);
		setRotationAngle(cube_r24, -1.1345F, 0.0F, 0.0F);
		cube_r24.texOffs(14, 123).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r25);
		setRotationAngle(cube_r25, -1.6581F, 0.0F, 0.0F);
		cube_r25.texOffs(123, 16).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r26);
		setRotationAngle(cube_r26, -2.1817F, 0.0F, 0.0F);
		cube_r26.texOffs(123, 116).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r27);
		setRotationAngle(cube_r27, -2.618F, 0.0F, 0.0F);
		cube_r27.texOffs(28, 124).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r28);
		setRotationAngle(cube_r28, 3.098F, 0.0F, 0.0F);
		cube_r28.texOffs(125, 25).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r29);
		setRotationAngle(cube_r29, 2.5307F, 0.0F, 0.0F);
		cube_r29.texOffs(61, 125).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r30);
		setRotationAngle(cube_r30, 1.9635F, 0.0F, 0.0F);
		cube_r30.texOffs(125, 120).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r31);
		setRotationAngle(cube_r31, 1.309F, 0.0F, 0.0F);
		cube_r31.texOffs(124, 125).addBox(-6.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(3.1F, 0.0118F, -0.1023F);
		rightfrontwheel.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.6109F, 0.0F, 0.0F);
		cube_r32.texOffs(42, 126).addBox(-6.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		rightmiddlewheelaxil = new ModelRenderer(this);
		rightmiddlewheelaxil.setPos(-15.0F, -10.0F, -18.0F);
		rightside.addChild(rightmiddlewheelaxil);
		rightmiddlewheelaxil.texOffs(6, 122).addBox(2.0F, 0.9F, 21.7F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(0.0F, 0.9F, 22.7F);
		rightmiddlewheelaxil.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, 0.1309F);
		cube_r33.texOffs(122, 112).addBox(-1.5F, -1.2F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		rightmiddlewheel = new ModelRenderer(this);
		rightmiddlewheel.setPos(2.0F, 7.9F, 22.8F);
		rightmiddlewheelaxil.addChild(rightmiddlewheel);
		rightmiddlewheel.texOffs(111, 122).addBox(-6.1F, -1.1F, -4.25F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		rightmiddlewheel.texOffs(0, 124).addBox(-5.1F, -4.0F, -0.55F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		rightmiddlewheel.texOffs(101, 61).addBox(-5.1F, -0.5F, -3.55F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		rightmiddlewheel.texOffs(119, 99).addBox(-5.0F, -1.0F, -1.1F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r34);
		setRotationAngle(cube_r34, -0.5672F, 0.0F, 0.0F);
		cube_r34.texOffs(34, 120).addBox(-6.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r35);
		setRotationAngle(cube_r35, -1.1345F, 0.0F, 0.0F);
		cube_r35.texOffs(120, 48).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r36);
		setRotationAngle(cube_r36, -1.6581F, 0.0F, 0.0F);
		cube_r36.texOffs(120, 52).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r37);
		setRotationAngle(cube_r37, -2.1817F, 0.0F, 0.0F);
		cube_r37.texOffs(120, 106).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r38);
		setRotationAngle(cube_r38, -2.618F, 0.0F, 0.0F);
		cube_r38.texOffs(121, 93).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r39);
		setRotationAngle(cube_r39, 3.098F, 0.0F, 0.0F);
		cube_r39.texOffs(48, 122).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r40);
		setRotationAngle(cube_r40, 2.5307F, 0.0F, 0.0F);
		cube_r40.texOffs(122, 77).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r41);
		setRotationAngle(cube_r41, 1.9635F, 0.0F, 0.0F);
		cube_r41.texOffs(122, 81).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r42);
		setRotationAngle(cube_r42, 1.309F, 0.0F, 0.0F);
		cube_r42.texOffs(83, 122).addBox(-6.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(-0.1F, 0.0F, -0.15F);
		rightmiddlewheel.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.6109F, 0.0F, 0.0F);
		cube_r43.texOffs(97, 122).addBox(-6.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		rightbackwheelaxil = new ModelRenderer(this);
		rightbackwheelaxil.setPos(-15.0F, -10.0F, -14.4F);
		rightside.addChild(rightbackwheelaxil);
		rightbackwheelaxil.texOffs(119, 73).addBox(-2.0F, -0.1F, 34.7F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		rightbackwheelaxil.texOffs(75, 119).addBox(2.0F, 0.9F, 34.7F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		rightbackwheel = new ModelRenderer(this);
		rightbackwheel.setPos(3.0F, 7.9F, 35.7F);
		rightbackwheelaxil.addChild(rightbackwheel);
		rightbackwheel.texOffs(119, 65).addBox(-7.1F, -1.1F, -4.15F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		rightbackwheel.texOffs(75, 51).addBox(-6.1F, -4.0F, -0.45F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		rightbackwheel.texOffs(40, 98).addBox(-6.1F, -0.5F, -3.45F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		rightbackwheel.texOffs(116, 4).addBox(-6.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r44);
		setRotationAngle(cube_r44, -0.5672F, 0.0F, 0.0F);
		cube_r44.texOffs(116, 33).addBox(-6.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r45);
		setRotationAngle(cube_r45, -1.1345F, 0.0F, 0.0F);
		cube_r45.texOffs(34, 116).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r46);
		setRotationAngle(cube_r46, -1.6581F, 0.0F, 0.0F);
		cube_r46.texOffs(116, 37).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r47);
		setRotationAngle(cube_r47, -2.1817F, 0.0F, 0.0F);
		cube_r47.texOffs(48, 116).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r48);
		setRotationAngle(cube_r48, -2.618F, 0.0F, 0.0F);
		cube_r48.texOffs(81, 117).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r49);
		setRotationAngle(cube_r49, 3.098F, 0.0F, 0.0F);
		cube_r49.texOffs(118, 89).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r50);
		setRotationAngle(cube_r50, 2.5307F, 0.0F, 0.0F);
		cube_r50.texOffs(95, 118).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r51);
		setRotationAngle(cube_r51, 1.9635F, 0.0F, 0.0F);
		cube_r51.texOffs(109, 118).addBox(-6.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r52);
		setRotationAngle(cube_r52, 1.309F, 0.0F, 0.0F);
		cube_r52.texOffs(20, 119).addBox(-6.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setPos(-1.1F, 0.0F, -0.05F);
		rightbackwheel.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.6109F, 0.0F, 0.0F);
		cube_r53.texOffs(61, 119).addBox(-6.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		leftside = new ModelRenderer(this);
		leftside.setPos(10.0F, 19.0F, 10.0F);
		rover.addChild(leftside);
		leftside.texOffs(18, 9).addBox(11.0F, -13.0F, 10.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		leftside.texOffs(126, 60).addBox(12.0F, -17.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setPos(12.0F, -16.0F, -3.0F);
		leftside.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.3491F, 0.0F, 0.0F);
		cube_r54.texOffs(64, 51).addBox(2.0F, -1.0F, -17.0F, 2.0F, 2.0F, 18.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setPos(12.0F, -12.0F, 10.0F);
		leftside.addChild(cube_r55);
		setRotationAngle(cube_r55, -0.2618F, 0.0F, 0.0F);
		cube_r55.texOffs(82, 0).addBox(2.9F, -1.1057F, 0.3989F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setPos(12.0F, -12.0F, 10.0F);
		leftside.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.1745F, 0.0F, 0.0F);
		cube_r56.texOffs(95, 93).addBox(2.9F, -0.7057F, -6.6011F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setPos(12.0F, -16.0F, -3.0F);
		leftside.addChild(cube_r57);
		setRotationAngle(cube_r57, -0.3054F, 0.0F, 0.0F);
		cube_r57.texOffs(0, 16).addBox(2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		leftfrontwheelaxil = new ModelRenderer(this);
		leftfrontwheelaxil.setPos(15.0F, -10.0F, -18.0F);
		leftside.addChild(leftfrontwheelaxil);
		leftfrontwheelaxil.texOffs(126, 69).addBox(-3.0F, -1.1F, -1.3F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		leftfrontwheelaxil.texOffs(0, 114).addBox(-5.0F, -0.1F, -1.3F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		leftfrontwheel = new ModelRenderer(this);
		leftfrontwheel.setPos(-3.0F, 6.8F, -0.3F);
		leftfrontwheelaxil.addChild(leftfrontwheel);
		leftfrontwheel.texOffs(115, 85).addBox(0.1F, -1.0F, -4.15F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		leftfrontwheel.texOffs(61, 74).addBox(3.1F, -3.9F, -0.45F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		leftfrontwheel.texOffs(98, 14).addBox(3.1F, -0.4F, -3.45F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		leftfrontwheel.texOffs(112, 61).addBox(0.0F, -0.9F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r58);
		setRotationAngle(cube_r58, -0.5672F, 0.0F, 0.0F);
		cube_r58.texOffs(112, 69).addBox(0.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r59);
		setRotationAngle(cube_r59, -1.1345F, 0.0F, 0.0F);
		cube_r59.texOffs(80, 112).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r60);
		setRotationAngle(cube_r60, -1.6581F, 0.0F, 0.0F);
		cube_r60.texOffs(114, 8).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r61);
		setRotationAngle(cube_r61, -2.1817F, 0.0F, 0.0F);
		cube_r61.texOffs(94, 114).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r62);
		setRotationAngle(cube_r62, -2.618F, 0.0F, 0.0F);
		cube_r62.texOffs(108, 114).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r63);
		setRotationAngle(cube_r63, 3.098F, 0.0F, 0.0F);
		cube_r63.texOffs(20, 115).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r64);
		setRotationAngle(cube_r64, 2.5307F, 0.0F, 0.0F);
		cube_r64.texOffs(115, 21).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r65);
		setRotationAngle(cube_r65, 1.9635F, 0.0F, 0.0F);
		cube_r65.texOffs(115, 29).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r66);
		setRotationAngle(cube_r66, 1.309F, 0.0F, 0.0F);
		cube_r66.texOffs(115, 44).addBox(0.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setPos(0.1F, 0.1F, -0.05F);
		leftfrontwheel.addChild(cube_r67);
		setRotationAngle(cube_r67, 0.6109F, 0.0F, 0.0F);
		cube_r67.texOffs(67, 115).addBox(0.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		leftmiddlewheelaxil = new ModelRenderer(this);
		leftmiddlewheelaxil.setPos(15.0F, -10.0F, -18.0F);
		leftside.addChild(leftmiddlewheelaxil);
		leftmiddlewheelaxil.texOffs(12, 112).addBox(-4.0F, 0.9F, 21.7F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setPos(0.0F, 0.9F, 22.7F);
		leftmiddlewheelaxil.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.0F, -0.1309F);
		cube_r68.texOffs(54, 112).addBox(-3.5F, -1.2F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		leftmiddlewheel = new ModelRenderer(this);
		leftmiddlewheel.setPos(-1.7F, 7.9F, 22.7F);
		leftmiddlewheelaxil.addChild(leftmiddlewheel);
		leftmiddlewheel.texOffs(112, 57).addBox(-0.2F, -1.1F, -4.15F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		leftmiddlewheel.texOffs(27, 72).addBox(2.8F, -4.0F, -0.45F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		leftmiddlewheel.texOffs(98, 0).addBox(2.8F, -0.5F, -3.45F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		leftmiddlewheel.texOffs(81, 108).addBox(-0.3F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r69);
		setRotationAngle(cube_r69, -0.5672F, 0.0F, 0.0F);
		cube_r69.texOffs(108, 81).addBox(0.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r70);
		setRotationAngle(cube_r70, -1.1345F, 0.0F, 0.0F);
		cube_r70.texOffs(109, 0).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r71);
		setRotationAngle(cube_r71, -1.6581F, 0.0F, 0.0F);
		cube_r71.texOffs(109, 13).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r72);
		setRotationAngle(cube_r72, -2.1817F, 0.0F, 0.0F);
		cube_r72.texOffs(109, 17).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r73);
		setRotationAngle(cube_r73, -2.618F, 0.0F, 0.0F);
		cube_r73.texOffs(0, 110).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r74);
		setRotationAngle(cube_r74, 3.098F, 0.0F, 0.0F);
		cube_r74.texOffs(66, 110).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r75);
		setRotationAngle(cube_r75, 2.5307F, 0.0F, 0.0F);
		cube_r75.texOffs(95, 110).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r76);
		setRotationAngle(cube_r76, 1.9635F, 0.0F, 0.0F);
		cube_r76.texOffs(109, 110).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r77);
		setRotationAngle(cube_r77, 1.309F, 0.0F, 0.0F);
		cube_r77.texOffs(111, 25).addBox(0.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setPos(-0.2F, 0.0F, -0.05F);
		leftmiddlewheel.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.6109F, 0.0F, 0.0F);
		cube_r78.texOffs(40, 112).addBox(0.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		leftbackwheelaxil = new ModelRenderer(this);
		leftbackwheelaxil.setPos(15.0F, -10.0F, -14.4F);
		leftside.addChild(leftbackwheelaxil);
		leftbackwheelaxil.texOffs(52, 108).addBox(-3.0F, -0.1F, 34.7F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		leftbackwheelaxil.texOffs(0, 45).addBox(-4.0F, 0.9F, 34.7F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		leftbackwheel = new ModelRenderer(this);
		leftbackwheel.setPos(-2.0F, 7.9F, 35.8F);
		leftbackwheelaxil.addChild(leftbackwheel);
		leftbackwheel.texOffs(108, 77).addBox(0.1F, -1.0828F, -4.2635F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		leftbackwheel.texOffs(0, 72).addBox(3.1F, -3.9828F, -0.5635F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		leftbackwheel.texOffs(97, 81).addBox(3.1F, -0.4828F, -3.5635F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		leftbackwheel.texOffs(0, 24).addBox(0.0F, -0.9828F, -1.1135F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r79);
		setRotationAngle(cube_r79, -0.5672F, 0.0F, 0.0F);
		cube_r79.texOffs(98, 22).addBox(0.0F, -1.4F, -4.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r80);
		setRotationAngle(cube_r80, -1.1345F, 0.0F, 0.0F);
		cube_r80.texOffs(101, 45).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r81);
		setRotationAngle(cube_r81, -1.6581F, 0.0F, 0.0F);
		cube_r81.texOffs(104, 89).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r82);
		setRotationAngle(cube_r82, -2.1817F, 0.0F, 0.0F);
		cube_r82.texOffs(0, 106).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r83);
		setRotationAngle(cube_r83, -2.618F, 0.0F, 0.0F);
		cube_r83.texOffs(40, 106).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r84);
		setRotationAngle(cube_r84, 3.098F, 0.0F, 0.0F);
		cube_r84.texOffs(106, 49).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r85);
		setRotationAngle(cube_r85, 2.5307F, 0.0F, 0.0F);
		cube_r85.texOffs(106, 53).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r86);
		setRotationAngle(cube_r86, 1.9635F, 0.0F, 0.0F);
		cube_r86.texOffs(107, 93).addBox(0.0F, -1.0F, -4.4F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r87);
		setRotationAngle(cube_r87, 1.309F, 0.0F, 0.0F);
		cube_r87.texOffs(107, 97).addBox(0.0F, -1.0F, -4.3F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setPos(0.1F, 0.0172F, -0.1635F);
		leftbackwheel.addChild(cube_r88);
		setRotationAngle(cube_r88, 0.6109F, 0.0F, 0.0F);
		cube_r88.texOffs(107, 103).addBox(0.0F, -1.0F, -4.1F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		arm = new ModelRenderer(this);
		arm.setPos(17.0F, -2.0F, 2.0F);
		rover.addChild(arm);
		setRotationAngle(arm, 0.0F, 0.1745F, 0.0F);
		arm.texOffs(42, 54).addBox(-1.0F, -1.0F, -17.0F, 2.0F, 2.0F, 18.0F, 0.0F, false);

		lowerarm = new ModelRenderer(this);
		lowerarm.setPos(0.0F, 0.0F, -4.0F);
		arm.addChild(lowerarm);
		setRotationAngle(lowerarm, 0.0F, 0.0436F, 0.0F);
		lowerarm.texOffs(0, 0).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);

		hand = new ModelRenderer(this);
		hand.setPos(0.0F, 0.0F, -12.0F);
		lowerarm.addChild(hand);
		setRotationAngle(hand, 1.5272F, 1.4835F, 0.0F);
		hand.texOffs(64, 62).addBox(-2.0F, -1.2F, -5.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		hand.texOffs(56, 89).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		hand.texOffs(12, 96).addBox(2.0F, 0.0F, -6.3F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		hand.texOffs(0, 8).addBox(1.4F, -0.7F, -5.6F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setPos(-1.0F, 0.0F, -2.0F);
		hand.addChild(cube_r89);
		setRotationAngle(cube_r89, 0.0F, 0.9599F, 0.0F);
		cube_r89.texOffs(83, 91).addBox(4.0F, -0.6F, -5.4F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setPos(-1.0F, 0.0F, -2.0F);
		hand.addChild(cube_r90);
		setRotationAngle(cube_r90, 0.0F, 1.309F, 0.0F);
		cube_r90.texOffs(0, 28).addBox(1.5F, -0.6F, -1.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setPos(0.0F, 0.0F, 0.0F);
		hand.addChild(cube_r91);
		setRotationAngle(cube_r91, 0.0F, 0.2618F, 0.0F);
		cube_r91.texOffs(83, 95).addBox(-5.0F, -0.6F, -5.4F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setPos(0.0F, 0.0F, 0.0F);
		hand.addChild(cube_r92);
		setRotationAngle(cube_r92, 0.0F, -0.0873F, 0.0F);
		cube_r92.texOffs(0, 32).addBox(-5.5F, -0.6F, -1.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
	}

//	@Override
//	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//		//previously the render function, render code was moved to a method below
//	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(RoverEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_,
			float p_225597_5_, float p_225597_6_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rover.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}