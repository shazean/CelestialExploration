package com.shim.celestialexploration.item.armor;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HeavyDutySpaceSuitRenderer extends GeoArmorRenderer<HeavyDutySpaceSuitArmorItem> {

//    private final AnimatedGeoModel<SpaceSuitArmorItem> modelProvider;
//    protected SpaceSuitArmorItem currentArmorItem;

    public HeavyDutySpaceSuitRenderer() {
        super(new HeavyDutySpaceSuitModel());
//        this.modelProvider = new SpaceSuitModel();

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
