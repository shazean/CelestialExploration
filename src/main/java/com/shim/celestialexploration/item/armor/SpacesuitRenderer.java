package com.shim.celestialexploration.item.armor;

import com.shim.celestialexploration.util.CelestialUtil;
import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiFunction;

public abstract class SpacesuitRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = CelestialUtil.getModLoc("geo/spacesuit.geo.json");
    private static final ResourceLocation TEX = CelestialUtil.getModLoc("textures/models/armor/simple_spacesuit.png");

    public SpacesuitRenderer(BiFunction<Entity, ItemStack, RenderType> renderTypeProvider) {
        super(AzArmorRendererConfig.builder(GEO, TEX).setRenderType(renderTypeProvider)
                .build());
    }

    public static class Lightweight extends SpacesuitRenderer {

        public Lightweight() {
            super(Lightweight::getTexture);
        }

        private static RenderType getTexture(Entity entity, ItemStack itemStack) {
            if (itemStack.getItem() instanceof SpacesuitArmorItem armorItem) {
                return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/" + armorItem.getDyeColor(itemStack) + "_lightweight_spacesuit.png"));
            }
            return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/simple_spacesuit.png"));
        }
    }

    public static class HeavyDuty extends SpacesuitRenderer {

        public HeavyDuty() {
            super(HeavyDuty::getTexture);
        }

        private static RenderType getTexture(Entity entity, ItemStack itemStack) {
            if (itemStack.getItem() instanceof SpacesuitArmorItem armorItem) {
                return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/" + armorItem.getDyeColor(itemStack) + "_heavy_duty_spacesuit.png"));
            }
            return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/simple_spacesuit.png"));
        }
    }

    public static class Insulated extends SpacesuitRenderer {

        public Insulated() {
            super(Insulated::getTexture);
        }

        private static RenderType getTexture(Entity entity, ItemStack itemStack) {
            if (itemStack.getItem() instanceof SpacesuitArmorItem armorItem) {
                return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/" + armorItem.getDyeColor(itemStack) + "_insulated_spacesuit.png"));
            }
            return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/simple_spacesuit.png"));
        }
    }

    public static class Simple extends SpacesuitRenderer {

        public Simple() {
            super(Simple::getTexture);
        }

        private static RenderType getTexture(Entity entity, ItemStack itemStack) {
            return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/simple_spacesuit.png"));
        }
    }

    public static class LongFall extends SpacesuitRenderer {

        public LongFall() {
            super(LongFall::getTexture);
        }

        private static RenderType getTexture(Entity entity, ItemStack itemStack) {
            return RenderType.entityTranslucent(CelestialUtil.getModLoc("textures/models/armor/long_fall_spacesuit.png"));
        }
    }
}
