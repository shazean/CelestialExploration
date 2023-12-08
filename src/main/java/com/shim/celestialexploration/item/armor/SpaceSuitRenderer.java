package com.shim.celestialexploration.item.armor;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SpaceSuitRenderer extends GeoArmorRenderer<SpaceSuitArmorItem> {

//    private final AnimatedGeoModel<SpaceSuitArmorItem> modelProvider;
//    protected SpaceSuitArmorItem currentArmorItem;

    public SpaceSuitRenderer() {
        super(new SpaceSuitModel());
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

//    @Override
//    public GeoArmorRenderer applySlot(EquipmentSlot slot) {
//        modelProvider.getModel(modelProvider.getModelLocation(currentArmorItem));
//
//        IBone headBone = this.getAndHideBone(this.headBone);
//        IBone bodyBone = this.getAndHideBone(this.bodyBone);
//        IBone rightArmBone = this.getAndHideBone(this.rightArmBone);
//        IBone leftArmBone = this.getAndHideBone(this.leftArmBone);
//        IBone rightLegBone = this.getAndHideBone(this.rightLegBone);
//        IBone leftLegBone = this.getAndHideBone(this.leftLegBone);
//        IBone rightBootBone = this.getAndHideBone(this.rightBootBone);
//        IBone leftBootBone = this.getAndHideBone(this.leftBootBone);
//
//        switch (slot) {
//            case HEAD:
//                if (headBone != null)
//                    headBone.setHidden(false);
//                break;
//            case CHEST:
//                if (bodyBone != null)
//                    bodyBone.setHidden(false);
//                if (rightArmBone != null)
//                    rightArmBone.setHidden(false);
//                if (leftArmBone != null)
//                    leftArmBone.setHidden(false);
//                break;
//            case LEGS:
//                if (bodyBone != null)
//                    bodyBone.setHidden(false);
//                if (rightLegBone != null)
//                    rightLegBone.setHidden(false);
//                if (leftLegBone != null)
//                    leftLegBone.setHidden(false);
//                break;
//            case FEET:
//                if (rightBootBone != null)
//                    rightBootBone.setHidden(false);
//                if (leftBootBone != null)
//                    leftBootBone.setHidden(false);
//                break;
//        }
//        return this;
//    }
}