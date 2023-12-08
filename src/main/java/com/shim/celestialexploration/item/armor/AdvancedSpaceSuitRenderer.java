package com.shim.celestialexploration.item.armor;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AdvancedSpaceSuitRenderer extends GeoArmorRenderer<AdvancedSpaceSuitArmorItem> {

    public AdvancedSpaceSuitRenderer() {
        super(new AdvancedSpaceSuitModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}