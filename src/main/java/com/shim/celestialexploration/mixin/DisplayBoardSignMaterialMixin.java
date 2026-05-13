package com.shim.celestialexploration.mixin;

import com.shim.celestialexploration.blocks.IDisplayBoard;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SignEditScreen.class)
public class DisplayBoardSignMaterialMixin {

    @Shadow
    @Final
    private SignBlockEntity sign;

    @ModifyVariable(at = @At(value = "STORE", ordinal = 0), method = "render")
    public Material useDisplayBoardMaterials(Material material) {
        if (sign.getBlockState().getBlock() instanceof IDisplayBoard board)
            material = board.getMaterial();
        return material;
    }

}
