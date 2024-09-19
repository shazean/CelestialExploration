package com.shim.celestialexploration.blocks;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class CelestialProperties {
    public static final EnumProperty<AirlockDoorHingeSide> HINGE = EnumProperty.create("hinge", AirlockDoorHingeSide.class);




    public enum AirlockDoorHingeSide implements StringRepresentable {
        LEFT("left"),
        RIGHT("right"),
        NON_HINGE("non_hinge");

        private final String name;

        AirlockDoorHingeSide(String name) {
            this.name = name;
        }

        public String toString() {
            return this.getSerializedName();
        }

        public String getSerializedName() {
            return name;
        }
    }
}
