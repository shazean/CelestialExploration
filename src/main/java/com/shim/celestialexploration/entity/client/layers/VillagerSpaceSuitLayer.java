package com.shim.celestialexploration.entity.client.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shim.celestialexploration.registry.CelestialTags;
import com.shim.celestialexploration.util.CelestialUtil;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.VillagerHeadModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.metadata.animation.VillagerMetaDataSection;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VillagerSpaceSuitLayer<T extends LivingEntity & VillagerDataHolder, M extends EntityModel<T> & VillagerHeadModel> extends RenderLayer<T, M> {
    private static final Int2ObjectMap<ResourceLocation> LEVEL_LOCATIONS = Util.make(new Int2ObjectOpenHashMap<>(), (p_117657_) -> {
        p_117657_.put(1, new ResourceLocation("stone"));
        p_117657_.put(2, new ResourceLocation("iron"));
        p_117657_.put(3, new ResourceLocation("gold"));
        p_117657_.put(4, new ResourceLocation("emerald"));
        p_117657_.put(5, new ResourceLocation("diamond"));
    });

    public VillagerSpaceSuitLayer(RenderLayerParent<T, M> p_174550_) {
        super(p_174550_);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int p_117648_, T entity, float p_117650_, float p_117651_, float p_117652_, float p_117653_, float p_117654_, float p_117655_) {
        if (!entity.isInvisible()) {
            if (entity.level.getBiome(entity.getOnPos()).is(CelestialTags.Biomes.CELESTIAL_BODIES)) {
                VillagerData villagerdata = entity.getVillagerData();
                VillagerProfession villagerprofession = villagerdata.getProfession();
                M m = this.getParentModel();
                ResourceLocation spacesuit = CelestialUtil.getModLoc("textures/entity/villager/spacesuit.png");
                VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(spacesuit));
                this.getParentModel().renderToBuffer(poseStack, vertexconsumer, p_117648_, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
                m.hatVisible(true);
                if (villagerprofession != VillagerProfession.NONE && !entity.isBaby()) {
                    ResourceLocation resourcelocation1 = this.getResourceLocation("profession", Registry.VILLAGER_PROFESSION.getKey(villagerprofession));
                    renderColoredCutoutModel(m, resourcelocation1, poseStack, bufferSource, p_117648_, entity, 1.0F, 1.0F, 1.0F);
                    if (villagerprofession != VillagerProfession.NITWIT) {
                        ResourceLocation resourcelocation2 = this.getResourceLocation("profession_level", LEVEL_LOCATIONS.get(Mth.clamp(villagerdata.getLevel(), 1, LEVEL_LOCATIONS.size())));
                        renderColoredCutoutModel(m, resourcelocation2, poseStack, bufferSource, p_117648_, entity, 1.0F, 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    private ResourceLocation getResourceLocation(String p_117669_, ResourceLocation p_117670_) {
        return new ResourceLocation(p_117670_.getNamespace(), "textures/entity/villager/" + p_117669_ + "/" + p_117670_.getPath() + ".png");
    }
}