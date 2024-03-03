package com.shim.celestialexploration.registry;

import com.google.common.collect.Sets;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class CelestialModelLayers {
    private static final String DEFAULT_LAYER = "main";
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();

    public static final ModelLayerLocation MAGCART = register( "magcart");
    public static final ModelLayerLocation CHEST_MAGCART = register( "chest_magcart");
    public static final ModelLayerLocation COMMAND_BLOCK_MAGCART = register( "command_block_magcart");
    public static final ModelLayerLocation FURNACE_MAGCART = register( "furnace_magcart");
    public static final ModelLayerLocation HOPPER_MAGCART = register( "hopper_magcart");
    public static final ModelLayerLocation SPAWNER_MAGCART = register( "spawner_magcart");
    public static final ModelLayerLocation TNT_MAGCART = register( "tnt_magcart");

    public static final ModelLayerLocation VOIDED = register("voided");
    public static final ModelLayerLocation VOIDED_INNER_ARMOR = registerInnerArmor("voided");
    public static final ModelLayerLocation VOIDED_OUTER_ARMOR = registerOuterArmor("voided");


    public static final ModelLayerLocation VOIDED_PIGLIN = register("voided_piglin");
    public static final ModelLayerLocation VOIDED_PIGLIN_INNER_ARMOR = registerInnerArmor("voided_piglin");
    public static final ModelLayerLocation VOIDED_PIGLIN_OUTER_ARMOR = registerOuterArmor("voided_piglin");

    public static final ModelLayerLocation ASTRAL_PIGLIN = register("astral_piglin");
    public static final ModelLayerLocation ASTRAL_PIGLIN_INNER_ARMOR = registerInnerArmor("astral_piglin");
    public static final ModelLayerLocation ASTRAL_PIGLIN_OUTER_ARMOR = registerOuterArmor("astral_piglin");

    public static final ModelLayerLocation VOIDED_ZOGLIN = register("voided_zoglin");
    public static final ModelLayerLocation VOIDED_ZOGLIN_INNER_ARMOR = registerInnerArmor("voided_zoglin");
    public static final ModelLayerLocation VOIDED_ZOGLIN_OUTER_ARMOR = registerOuterArmor("voided_zoglin");

    public static final ModelLayerLocation ASTRAL_HOGLIN = register("astral_hoglin");
    public static final ModelLayerLocation ASTRAL_HOGLIN_INNER_ARMOR = registerInnerArmor("astral_hoglin");
    public static final ModelLayerLocation ASTRAL_HOGLIN_OUTER_ARMOR = registerOuterArmor("astral_hoglin");


    public static final ModelLayerLocation GUST = register("gust");


    private static ModelLayerLocation registerInnerArmor(String p_171299_) {
        return register(p_171299_, "inner_armor");
    }

    private static ModelLayerLocation registerOuterArmor(String p_171304_) {
        return register(p_171304_, "outer_armor");
    }

    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation(CelestialExploration.MODID, p_171301_), p_171302_);
    }

}
