package com.shim.celestialexploration.item.armor;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ThermalSpaceSuitRenderer extends GeoArmorRenderer<ThermalSpaceSuitArmorItem> {

//    private final AnimatedGeoModel<SpaceSuitArmorItem> modelProvider;
//    protected SpaceSuitArmorItem currentArmorItem;

    public ThermalSpaceSuitRenderer() {
        super(new ThermalSpaceSuitModel());
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
