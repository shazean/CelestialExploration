package com.shim.celestialexploration.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.StoneChestBlock;
import com.shim.celestialexploration.blocks.blockentities.StoneChestBlockEntity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class StoneChestWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {

    public static final StoneChestWithoutLevelRenderer INSTANCE = new StoneChestWithoutLevelRenderer();

    private StoneChestBlockEntity[] blockEntities = new StoneChestBlockEntity[StoneChestType.values().length];

    {
        for (StoneChestType type : StoneChestType.values())
            blockEntities[type.ordinal()] = new StoneChestBlockEntity(type, BlockPos.ZERO, StoneChestBlock.getChests()[type.ordinal()].defaultBlockState());
    }

    public StoneChestWithoutLevelRenderer() {
        super(CelestialExploration.PROXY.getMinecraft().getBlockEntityRenderDispatcher(), CelestialExploration.PROXY.getMinecraft().getEntityModels());
    }

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemTransforms.TransformType transformType, PoseStack posestack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Block block = Block.byItem(itemStackIn.getItem());
        if (block instanceof StoneChestBlock) {
            CelestialExploration.PROXY.getMinecraft().getBlockEntityRenderDispatcher().renderItem(this.blockEntities[((StoneChestBlock)block).getStoneType().ordinal()], posestack, buffer, combinedLight, combinedOverlay);
        } else {
            super.renderByItem(itemStackIn, transformType, posestack, buffer, combinedLight, combinedOverlay);
        }
    }
}
