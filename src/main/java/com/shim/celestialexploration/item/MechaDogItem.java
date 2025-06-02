package com.shim.celestialexploration.item;

import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.registry.CelestialEntities;

public class MechaDogItem extends AutoTameSpawnItem {
    public MechaDogItem(DyeType type, Properties properties) {
        super(CelestialEntities.MECHADOG, properties);
    }
}
