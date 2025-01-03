package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CelestialSkullRenderer {

    public static void setSkullRenderers() {
        SkullBlockRenderer.SKIN_BY_TYPE.put(Types.LURKER, new ResourceLocation(CelestialExploration.MODID, "textures/entity/lurker/lurker.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(Types.VOIDED, new ResourceLocation(CelestialExploration.MODID, "textures/entity/voided.png"));
        SkullBlockRenderer.SKIN_BY_TYPE.put(Types.MECHADOG, new ResourceLocation(CelestialExploration.MODID, "textures/entity/mechadog/mechadog_red.png"));
    }

    public enum Types implements SkullBlock.Type {
        LURKER,
        VOIDED,
        MECHADOG
    }
}