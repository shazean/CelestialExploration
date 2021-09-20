package mod.shim.celestialexploration.client.model;

import java.util.Arrays;

import com.google.common.collect.ImmutableList;

import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import com.google.common.collect.ImmutableList.Builder;


public class ShuttleModel<T extends ShuttleEntity> extends SegmentedModel<T> {
	private final ModelRenderer shuttle;
	private final ModelRenderer tailright;
	private final ModelRenderer tail2_r1;
	private final ModelRenderer tail2_r2;
	private final ModelRenderer tailleft;
	private final ModelRenderer tail3_r1;
	private final ModelRenderer tail3_r2;
	private final ModelRenderer cockpit;
	private final ModelRenderer cube_r1;
	private final ModelRenderer nose4a_r1;
	private final ModelRenderer glass_r1;
	private final ModelRenderer nose4a_r2;
	private final ModelRenderer nose3_r1;
	private final ModelRenderer nose1_r1;
	private final ModelRenderer rightwing;
	private final ModelRenderer wing4a_r1;
	private final ModelRenderer wing4a_r2;
	private final ModelRenderer boosterright_r1;
	private final ModelRenderer wing3a_r1;
	private final ModelRenderer cargo3a_r1;
	private final ModelRenderer cargo3a_r2;
	private final ModelRenderer wing3a_r2;
	private final ModelRenderer wing2a_r1;
	private final ModelRenderer leftwing;
	private final ModelRenderer wing4a_r3;
	private final ModelRenderer wing4a_r4;
	private final ModelRenderer boosterleft_r1;
	private final ModelRenderer wing3a_r3;
	private final ModelRenderer cargo3a_r3;
	private final ModelRenderer cargo3a_r4;
	private final ModelRenderer wing3a_r4;
	private final ModelRenderer wing2a_r2;
	private final ModelRenderer core;
	private final ModelRenderer cargo1a_r1;
	private final ModelRenderer cargo1a_r2;
	private final ImmutableList<ModelRenderer> parts;


	public ShuttleModel() {
		texWidth = 1024;
		texHeight = 1024;

		shuttle = new ModelRenderer(this);
		shuttle.setPos(0.0F, 24.0F, 0.0F);
		

		tailright = new ModelRenderer(this);
		tailright.setPos(-31.4877F, -74.3717F, 104.3987F);
		shuttle.addChild(tailright);
		setRotationAngle(tailright, 0.0F, 0.0F, -0.0873F);
		

		tail2_r1 = new ModelRenderer(this);
		tail2_r1.setPos(-6.3754F, -41.5434F, 24.7975F);
		tailright.addChild(tail2_r1);
		setRotationAngle(tail2_r1, -0.0873F, 0.0F, -0.3927F);
		tail2_r1.texOffs(480, 336).addBox(-13.0F, -19.5F, -20.5F, 14.0F, 21.0F, 42.0F, 0.0F, false);

		tail2_r2 = new ModelRenderer(this);
		tail2_r2.setPos(12.1877F, 3.2717F, -24.3987F);
		tailright.addChild(tail2_r2);
		setRotationAngle(tail2_r2, -0.7418F, 0.0F, -0.3927F);
		tail2_r2.texOffs(480, 336).addBox(-13.0F, -97.5F, 9.0F, 14.0F, 26.0F, 22.0F, 0.0F, false);
		tail2_r2.texOffs(480, 336).addBox(-13.0F, -71.5F, -24.0F, 14.0F, 88.0F, 55.0F, 0.0F, false);

		tailleft = new ModelRenderer(this);
		tailleft.setPos(31.1877F, -70.3717F, 104.3987F);
		shuttle.addChild(tailleft);
		setRotationAngle(tailleft, 0.0F, 0.0F, 0.0873F);
		

		tail3_r1 = new ModelRenderer(this);
		tail3_r1.setPos(6.3754F, -45.5434F, 24.7975F);
		tailleft.addChild(tail3_r1);
		setRotationAngle(tail3_r1, -0.0873F, 0.0F, 0.3927F);
		tail3_r1.texOffs(480, 336).addBox(-1.0F, -19.5F, -20.5F, 14.0F, 21.0F, 42.0F, 0.0F, true);

		tail3_r2 = new ModelRenderer(this);
		tail3_r2.setPos(-12.1877F, -0.7283F, -24.3987F);
		tailleft.addChild(tail3_r2);
		setRotationAngle(tail3_r2, -0.7418F, 0.0F, 0.3927F);
		tail3_r2.texOffs(480, 336).addBox(-1.0F, -97.5F, 9.0F, 14.0F, 26.0F, 22.0F, 0.0F, true);
		tail3_r2.texOffs(480, 336).addBox(-1.0F, -71.5F, -24.0F, 14.0F, 88.0F, 55.0F, 0.0F, true);

		cockpit = new ModelRenderer(this);
		cockpit.setPos(0.0F, 10.3F, 0.0F);
		shuttle.addChild(cockpit);
		cockpit.texOffs(0, 0).addBox(-40.0F, -46.0F, -183.0F, 16.0F, 25.0F, 64.0F, 0.0F, false);
		cockpit.texOffs(272, 400).addBox(-24.0F, -64.0F, -152.0F, 48.0F, 16.0F, 32.0F, 0.0F, false);
		cockpit.texOffs(670, 406).addBox(-29.0F, -46.0F, -208.6F, 59.0F, 26.0F, 13.0F, 0.0F, false);
		cockpit.texOffs(0, 0).addBox(24.0F, -46.0F, -183.0F, 16.0F, 20.0F, 64.0F, 0.0F, true);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(31.5F, -24.5F, -159.5F);
		cockpit.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3491F, 0.0F, 0.0F);
		cube_r1.texOffs(670, 406).addBox(-7.5F, -32.9F, -15.0F, 15.0F, 26.0F, 70.0F, 0.0F, true);
		cube_r1.texOffs(670, 406).addBox(-70.5F, -32.9F, -15.0F, 15.0F, 26.0F, 70.0F, 0.0F, false);

		nose4a_r1 = new ModelRenderer(this);
		nose4a_r1.setPos(32.0F, -36.0F, -187.0F);
		cockpit.addChild(nose4a_r1);
		setRotationAngle(nose4a_r1, 0.0F, 0.4363F, 0.0F);
		nose4a_r1.texOffs(0, 0).addBox(-12.0F, -10.0F, -13.0F, 16.0F, 20.0F, 20.0F, 0.0F, true);

		glass_r1 = new ModelRenderer(this);
		glass_r1.setPos(0.0F, -67.559F, -143.3658F);
		cockpit.addChild(glass_r1);
		setRotationAngle(glass_r1, -0.7854F, 0.0F, 0.0F);
		glass_r1.texOffs(0, 112).addBox(-24.0F, -26.5F, -6.0F, 48.0F, 40.0F, 18.0F, 0.0F, false);

		nose4a_r2 = new ModelRenderer(this);
		nose4a_r2.setPos(-32.0F, -36.0F, -187.0F);
		cockpit.addChild(nose4a_r2);
		setRotationAngle(nose4a_r2, 0.0F, -0.4363F, 0.0F);
		nose4a_r2.texOffs(0, 0).addBox(-3.0F, -10.0F, -13.0F, 15.0F, 25.0F, 20.0F, 0.0F, false);

		nose3_r1 = new ModelRenderer(this);
		nose3_r1.setPos(0.0F, -40.0F, -152.0F);
		cockpit.addChild(nose3_r1);
		setRotationAngle(nose3_r1, 0.3054F, 0.0F, 0.0F);
		nose3_r1.texOffs(0, 320).addBox(-24.0F, -23.0F, -46.0F, 48.0F, 16.0F, 64.0F, 0.0F, false);

		nose1_r1 = new ModelRenderer(this);
		nose1_r1.setPos(0.0F, -8.0F, -144.0F);
		cockpit.addChild(nose1_r1);
		setRotationAngle(nose1_r1, -0.0873F, 0.0F, 0.0F);
		nose1_r1.texOffs(480, 432).addBox(-24.0F, -18.9F, -66.0F, 48.0F, 16.0F, 82.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setPos(0.0F, 0.0F, 0.0F);
		shuttle.addChild(rightwing);
		

		wing4a_r1 = new ModelRenderer(this);
		wing4a_r1.setPos(-181.6345F, -85.7261F, 124.1602F);
		rightwing.addChild(wing4a_r1);
		setRotationAngle(wing4a_r1, -1.1645F, 0.0468F, -1.0053F);
		wing4a_r1.texOffs(496, 0).addBox(-9.5F, 2.0F, -9.5F, 18.0F, 60.0F, 29.0F, 0.0F, false);

		wing4a_r2 = new ModelRenderer(this);
		wing4a_r2.setPos(-127.0F, -53.5F, 93.5F);
		rightwing.addChild(wing4a_r2);
		setRotationAngle(wing4a_r2, -0.2918F, 0.0468F, -1.0053F);
		wing4a_r2.texOffs(496, 0).addBox(-13.0F, -75.5F, 2.5F, 18.0F, 38.0F, 33.0F, 0.0F, false);
		wing4a_r2.texOffs(496, 0).addBox(-13.0F, -37.5F, -42.5F, 18.0F, 64.0F, 78.0F, 0.0F, false);

		boosterright_r1 = new ModelRenderer(this);
		boosterright_r1.setPos(-39.2357F, -69.7177F, 80.0F);
		rightwing.addChild(boosterright_r1);
		setRotationAngle(boosterright_r1, 0.0F, 0.0F, 0.48F);
		boosterright_r1.texOffs(0, 400).addBox(-8.0F, -5.0F, -46.0F, 39.0F, 42.0F, 103.0F, 0.0F, false);

		wing3a_r1 = new ModelRenderer(this);
		wing3a_r1.setPos(-92.0F, -40.0F, 96.0F);
		rightwing.addChild(wing3a_r1);
		setRotationAngle(wing3a_r1, -0.0087F, -0.48F, 0.0F);
		wing3a_r1.texOffs(496, 0).addBox(-49.0F, 0.0F, -150.0F, 79.0F, 14.0F, 139.0F, 0.0F, false);

		cargo3a_r1 = new ModelRenderer(this);
		cargo3a_r1.setPos(-47.0F, -39.0F, 80.0F);
		rightwing.addChild(cargo3a_r1);
		setRotationAngle(cargo3a_r1, 0.0F, 0.1745F, 0.2182F);
		cargo3a_r1.texOffs(496, 0).addBox(-72.0F, 2.7F, -28.0F, 109.0F, 28.0F, 62.0F, 0.0F, false);

		cargo3a_r2 = new ModelRenderer(this);
		cargo3a_r2.setPos(-54.4764F, -23.7569F, -7.0F);
		rightwing.addChild(cargo3a_r2);
		setRotationAngle(cargo3a_r2, -0.1659F, -0.2595F, 0.3536F);
		cargo3a_r2.texOffs(496, 0).addBox(-11.0F, -14.5F, -34.0F, 60.0F, 14.0F, 106.0F, 0.0F, false);

		wing3a_r2 = new ModelRenderer(this);
		wing3a_r2.setPos(-92.0F, -40.0F, 96.0F);
		rightwing.addChild(wing3a_r2);
		setRotationAngle(wing3a_r2, 0.0F, 0.3491F, 0.0F);
		wing3a_r2.texOffs(496, 0).addBox(-8.0F, -9.0F, -55.0F, 85.0F, 9.0F, 80.0F, 0.0F, false);

		wing2a_r1 = new ModelRenderer(this);
		wing2a_r1.setPos(-79.5F, -40.0F, 32.5F);
		rightwing.addChild(wing2a_r1);
		setRotationAngle(wing2a_r1, 0.0F, -0.2618F, 0.0F);
		wing2a_r1.texOffs(0, 112).addBox(-10.9F, -3.0F, -186.5F, 49.0F, 16.0F, 248.0F, 0.0F, false);

		leftwing = new ModelRenderer(this);
		leftwing.setPos(0.0F, 0.0F, 0.0F);
		shuttle.addChild(leftwing);
		

		wing4a_r3 = new ModelRenderer(this);
		wing4a_r3.setPos(181.6345F, -85.7261F, 124.1602F);
		leftwing.addChild(wing4a_r3);
		setRotationAngle(wing4a_r3, -1.1645F, -0.0468F, 1.0053F);
		wing4a_r3.texOffs(496, 0).addBox(-8.5F, 2.0F, -9.5F, 18.0F, 60.0F, 29.0F, 0.0F, true);

		wing4a_r4 = new ModelRenderer(this);
		wing4a_r4.setPos(127.0F, -53.5F, 93.5F);
		leftwing.addChild(wing4a_r4);
		setRotationAngle(wing4a_r4, -0.2918F, -0.0468F, 1.0053F);
		wing4a_r4.texOffs(496, 0).addBox(-5.0F, -75.5F, 2.5F, 18.0F, 38.0F, 33.0F, 0.0F, true);
		wing4a_r4.texOffs(496, 0).addBox(-5.0F, -37.5F, -42.5F, 18.0F, 64.0F, 78.0F, 0.0F, true);

		boosterleft_r1 = new ModelRenderer(this);
		boosterleft_r1.setPos(39.2357F, -69.7177F, 80.0F);
		leftwing.addChild(boosterleft_r1);
		setRotationAngle(boosterleft_r1, 0.0F, 0.0F, -0.48F);
		boosterleft_r1.texOffs(0, 400).addBox(-32.0F, -5.0F, -46.0F, 40.0F, 42.0F, 102.0F, 0.0F, true);

		wing3a_r3 = new ModelRenderer(this);
		wing3a_r3.setPos(92.0F, -40.0F, 96.0F);
		leftwing.addChild(wing3a_r3);
		setRotationAngle(wing3a_r3, -0.0087F, 0.48F, 0.0F);
		wing3a_r3.texOffs(496, 0).addBox(-30.0F, 0.0F, -150.0F, 79.0F, 14.0F, 139.0F, 0.0F, true);

		cargo3a_r3 = new ModelRenderer(this);
		cargo3a_r3.setPos(47.0F, -39.0F, 80.0F);
		leftwing.addChild(cargo3a_r3);
		setRotationAngle(cargo3a_r3, 0.0F, -0.1745F, -0.2182F);
		cargo3a_r3.texOffs(496, 0).addBox(-37.0F, 2.7F, -28.0F, 109.0F, 28.0F, 62.0F, 0.0F, true);

		cargo3a_r4 = new ModelRenderer(this);
		cargo3a_r4.setPos(54.4764F, -23.7569F, -7.0F);
		leftwing.addChild(cargo3a_r4);
		setRotationAngle(cargo3a_r4, -0.1659F, 0.2595F, -0.3536F);
		cargo3a_r4.texOffs(496, 0).addBox(-49.0F, -14.5F, -34.0F, 60.0F, 14.0F, 106.0F, 0.0F, true);

		wing3a_r4 = new ModelRenderer(this);
		wing3a_r4.setPos(92.0F, -40.0F, 96.0F);
		leftwing.addChild(wing3a_r4);
		setRotationAngle(wing3a_r4, 0.0F, -0.3491F, 0.0F);
		wing3a_r4.texOffs(496, 0).addBox(-77.0F, -9.0F, -55.0F, 85.0F, 9.0F, 80.0F, 0.0F, true);

		wing2a_r2 = new ModelRenderer(this);
		wing2a_r2.setPos(79.5F, -40.0F, 32.5F);
		leftwing.addChild(wing2a_r2);
		setRotationAngle(wing2a_r2, 0.0F, 0.2618F, 0.0F);
		wing2a_r2.texOffs(0, 112).addBox(-38.1F, -3.0F, -186.5F, 49.0F, 16.0F, 248.0F, 0.0F, true);

		core = new ModelRenderer(this);
		core.setPos(0.0F, 0.0F, 0.0F);
		shuttle.addChild(core);
		core.texOffs(0, 0).addBox(-24.0F, -80.0F, -128.0F, 48.0F, 80.0F, 240.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(-40.0F, -64.0F, -120.0F, 80.0F, 48.0F, 240.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(-33.0F, -64.0F, 107.0F, 65.0F, 54.0F, 11.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(-18.0F, -55.0F, 84.0F, 37.0F, 34.0F, 59.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(-21.0F, -59.0F, 135.0F, 43.0F, 41.0F, 10.0F, 0.0F, false);

		cargo1a_r1 = new ModelRenderer(this);
		cargo1a_r1.setPos(32.0F, -72.0F, -2.0F);
		core.addChild(cargo1a_r1);
		setRotationAngle(cargo1a_r1, 0.0F, 0.0F, -0.6981F);
		cargo1a_r1.texOffs(480, 208).addBox(-15.0F, -11.0F, -122.0F, 16.0F, 22.0F, 244.0F, 0.0F, true);

		cargo1a_r2 = new ModelRenderer(this);
		cargo1a_r2.setPos(-32.0F, -72.0F, -2.0F);
		core.addChild(cargo1a_r2);
		setRotationAngle(cargo1a_r2, 0.0F, 0.0F, 0.6981F);
		cargo1a_r2.texOffs(480, 208).addBox(-1.0F, -11.0F, -122.0F, 16.0F, 22.0F, 244.0F, 0.0F, false);
		Builder<ModelRenderer> builder = ImmutableList.builder();

		builder.addAll(Arrays.asList(shuttle));
		builder.addAll(Arrays.asList(leftwing));
		builder.addAll(Arrays.asList(rightwing));
		builder.addAll(Arrays.asList(core));
		builder.addAll(Arrays.asList(cockpit));
		builder.addAll(Arrays.asList(tailright));
		builder.addAll(Arrays.asList(tailleft));

		this.parts = builder.build();

	}

	//	@Override
	//	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	//		//previously the render function, render code was moved to a method below
	//	}
	//
	//	@Override
	//	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
	//		window_group.render(matrixStack, buffer, packedLight, packedOverlay);
	//		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	//	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}


	public ImmutableList<ModelRenderer> parts() {
		return this.parts;
	}

	@Override
	public void setupAnim(ShuttleEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_,
			float p_225597_5_, float p_225597_6_) {



	}


}