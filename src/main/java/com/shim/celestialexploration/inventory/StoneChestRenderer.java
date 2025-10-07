package com.shim.celestialexploration.inventory;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.blocks.blockentities.StoneChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.Locale;

public class StoneChestRenderer extends ChestRenderer<StoneChestBlockEntity> {
    public static Material[] single = new Material[StoneChestType.values().length];
    public static Material[] left = new Material[StoneChestType.values().length];
    public static Material[] right = new Material[StoneChestType.values().length];

    static {
        for (StoneChestType type : StoneChestType.values()) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public StoneChestRenderer(BlockEntityRendererProvider.Context p_173607_) {
        super(p_173607_);
    }

    @Override
    protected Material getMaterial(StoneChestBlockEntity blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    private static Material getChestMaterial(String path) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(CelestialExploration.MODID, "entity/chest/" + path));
    }

    private static Material getChestMaterial(StoneChestBlockEntity blockEntity, ChestType type) {
        return switch (type) {
            case SINGLE -> single[blockEntity.getStoneType().ordinal()];
            case LEFT -> left[blockEntity.getStoneType().ordinal()];
            case RIGHT -> right[blockEntity.getStoneType().ordinal()];
        };
    }
}
