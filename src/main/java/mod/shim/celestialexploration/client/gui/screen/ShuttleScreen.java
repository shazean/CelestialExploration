package mod.shim.celestialexploration.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import mod.shim.celestialexploration.Main;
import mod.shim.celestialexploration.inventory.container.AssemblyStationContainer;
import mod.shim.celestialexploration.inventory.container.ShuttleContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ShuttleScreen extends ContainerScreen<ShuttleContainer> {

	
	private static final ResourceLocation SHUTTLE_GUI = new ResourceLocation(Main.MODID, "textures/gui/shuttle.png");
	
	public ShuttleScreen(ShuttleContainer p_i51105_1_, PlayerInventory p_i51105_2_,
			ITextComponent p_i51105_3_) {
		super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
		// TODO Auto-generated constructor stub
		
		
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 175;
		this.imageHeight = 175;
		
	}
	
	@Override
	public void render(MatrixStack matrixStack, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(matrixStack, p_230430_2_, p_230430_3_);
	}


	@Override
	protected void renderLabels(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
		this.font.draw(p_230451_1_, this.inventory.getDisplayName(), (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);

	}
	
	@Override
	protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int mouseX, int mouseY) {
		RenderSystem.color4f(1f, 1f, 1f, 1f);
		this.minecraft.textureManager.bind(SHUTTLE_GUI);
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		this.blit(p_230450_1_, x, y, 0, 0, this.imageWidth, this.imageHeight);
	}



}
