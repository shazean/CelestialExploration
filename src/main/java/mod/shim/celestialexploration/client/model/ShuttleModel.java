package mod.shim.celestialexploration.client.model;

import java.util.Arrays;

import com.google.common.collect.ImmutableList;

import mod.shim.celestialexploration.entity.item.ShuttleEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import com.google.common.collect.ImmutableList.Builder;


public class ShuttleModel<T extends ShuttleEntity> extends SegmentedModel<T> {
	private final ModelRenderer core;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;
	private final ModelRenderer addins;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cockpit;
	private final ModelRenderer glass2_r1;
	private final ModelRenderer tail;	private final ImmutableList<ModelRenderer> parts;


	public ShuttleModel() {
		texWidth = 1024;
		texHeight = 1024;

		core = new ModelRenderer(this);
		core.setPos(0.0F, 24.0F, 0.0F);
		core.texOffs(0, 0).addBox(-24.0F, -80.0F, -120.0F, 48.0F, 80.0F, 240.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(-40.0F, -64.0F, -120.0F, 16.0F, 48.0F, 240.0F, 0.0F, false);
		core.texOffs(0, 320).addBox(24.0F, -64.0F, -120.0F, 16.0F, 48.0F, 240.0F, 0.0F, false);
		core.texOffs(272, 320).addBox(40.0F, -48.0F, -56.0F, 16.0F, 16.0F, 176.0F, 0.0F, false);
		core.texOffs(272, 320).addBox(-56.0F, -48.0F, -56.0F, 16.0F, 16.0F, 176.0F, 0.0F, false);
		core.texOffs(480, 208).addBox(-40.0F, -80.0F, 8.0F, 16.0F, 16.0F, 112.0F, 0.0F, false);
		core.texOffs(480, 208).addBox(24.0F, -80.0F, 8.0F, 16.0F, 16.0F, 112.0F, 0.0F, false);
		core.texOffs(0, 400).addBox(-56.0F, -80.0F, 40.0F, 16.0F, 32.0F, 80.0F, 0.0F, false);
		core.texOffs(0, 400).addBox(40.0F, -80.0F, 40.0F, 16.0F, 32.0F, 80.0F, 0.0F, false);
		core.texOffs(496, 0).addBox(-40.0F, -16.0F, 40.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		core.texOffs(496, 0).addBox(24.0F, -16.0F, 40.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		core.texOffs(128, 0).addBox(-56.0F, -32.0F, 88.0F, 16.0F, 16.0F, 32.0F, 0.0F, false);
		core.texOffs(496, 0).addBox(-72.0F, -64.0F, 40.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		core.texOffs(496, 0).addBox(56.0F, -64.0F, 40.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		core.texOffs(128, 0).addBox(40.0F, -32.0F, 88.0F, 16.0F, 16.0F, 32.0F, 0.0F, false);

		leftwing = new ModelRenderer(this);
		leftwing.setPos(0.0F, 24.0F, 0.0F);
		leftwing.texOffs(336, 0).addBox(56.0F, -48.0F, -8.0F, 16.0F, 16.0F, 128.0F, 0.0F, false);
		leftwing.texOffs(0, 112).addBox(72.0F, -48.0F, 40.0F, 32.0F, 16.0F, 80.0F, 0.0F, false);
		leftwing.texOffs(496, 0).addBox(104.0F, -48.0F, 56.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		leftwing.texOffs(496, 0).addBox(120.0F, -64.0F, 56.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		leftwing.texOffs(496, 0).addBox(136.0F, -80.0F, 72.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		leftwing.texOffs(0, 0).addBox(152.0F, -96.0F, 72.0F, 16.0F, 16.0F, 96.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setPos(0.0F, 24.0F, 0.0F);
		rightwing.texOffs(336, 0).addBox(-72.0F, -48.0F, -8.0F, 16.0F, 16.0F, 128.0F, 0.0F, false);
		rightwing.texOffs(0, 112).addBox(-104.0F, -48.0F, 40.0F, 32.0F, 16.0F, 80.0F, 0.0F, false);
		rightwing.texOffs(496, 0).addBox(-120.0F, -48.0F, 56.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		rightwing.texOffs(496, 0).addBox(-136.0F, -64.0F, 56.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		rightwing.texOffs(496, 0).addBox(-152.0F, -80.0F, 72.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
		rightwing.texOffs(0, 0).addBox(-168.0F, -96.0F, 72.0F, 16.0F, 16.0F, 96.0F, 0.0F, false);

		addins = new ModelRenderer(this);
		addins.setPos(0.0F, 24.0F, 0.0F);
		addins.texOffs(128, 48).addBox(72.0F, -48.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		addins.texOffs(128, 48).addBox(-88.0F, -48.0F, 24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		addins.texOffs(128, 48).addBox(-104.0F, -48.0F, 120.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		addins.texOffs(128, 48).addBox(88.0F, -48.0F, 120.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(40.0F, -64.0F, 24.0F);
		addins.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.texOffs(0, 64).addBox(0.0F, 0.0F, 0.0F, 23.0F, 16.0F, 16.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-40.0F, -64.0F, 24.0F);
		addins.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
		cube_r2.texOffs(0, 64).addBox(-23.0F, 0.0F, 0.0F, 23.0F, 16.0F, 16.0F, 0.0F, false);

		cockpit = new ModelRenderer(this);
		cockpit.setPos(0.0F, 24.0F, 0.0F);
		cockpit.texOffs(480, 432).addBox(-24.0F, -16.0F, -168.0F, 48.0F, 16.0F, 48.0F, 0.0F, false);
		cockpit.texOffs(336, 144).addBox(-24.0F, -32.0F, -200.0F, 48.0F, 16.0F, 80.0F, 0.0F, false);
		cockpit.texOffs(0, 320).addBox(-24.0F, -48.0F, -184.0F, 48.0F, 16.0F, 64.0F, 0.0F, false);
		cockpit.texOffs(0, 0).addBox(24.0F, -48.0F, -152.0F, 16.0F, 32.0F, 32.0F, 0.0F, false);
		cockpit.texOffs(0, 0).addBox(-40.0F, -48.0F, -152.0F, 16.0F, 32.0F, 32.0F, 0.0F, false);
		cockpit.texOffs(272, 400).addBox(-24.0F, -64.0F, -152.0F, 48.0F, 16.0F, 32.0F, 0.0F, false);
		cockpit.texOffs(0, 208).addBox(-23.0F, -79.0F, -135.0F, 46.0F, 15.0F, 15.0F, 0.0F, false);
		cockpit.texOffs(670, 406).addBox(-8.0F, -56.0F, -168.0F, 16.0F, 8.0F, 16.0F, 0.0F, false);
		cockpit.texOffs(670, 406).addBox(24.0F, -32.0F, -167.0F, 15.0F, 15.0F, 15.0F, 0.0F, false);
		cockpit.texOffs(670, 406).addBox(-39.0F, -32.0F, -167.0F, 15.0F, 15.0F, 15.0F, 0.0F, false);

		glass2_r1 = new ModelRenderer(this);
		glass2_r1.setPos(0.0F, -67.559F, -143.3658F);
		cockpit.addChild(glass2_r1);
		setRotationAngle(glass2_r1, -0.7854F, 0.0F, 0.0F);
		glass2_r1.texOffs(0, 112).addBox(-8.0F, -13.5F, -1.5F, 16.0F, 21.0F, 15.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(0.0F, 24.0F, 0.0F);
		tail.texOffs(480, 336).addBox(-9.0F, -96.0F, 40.0F, 18.0F, 16.0F, 80.0F, 0.0F, false);
		tail.texOffs(272, 320).addBox(-8.0F, -128.0F, 88.0F, 16.0F, 16.0F, 64.0F, 0.0F, false);
		tail.texOffs(496, 0).addBox(-8.0F, -112.0F, 56.0F, 16.0F, 16.0F, 80.0F, 0.0F, false);
	    Builder<ModelRenderer> builder = ImmutableList.builder();

		builder.addAll(Arrays.asList(core));
		builder.addAll(Arrays.asList(leftwing));
		builder.addAll(Arrays.asList(rightwing));
		builder.addAll(Arrays.asList(addins));
		builder.addAll(Arrays.asList(cockpit));
		builder.addAll(Arrays.asList(glass2_r1));
		builder.addAll(Arrays.asList(tail));

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