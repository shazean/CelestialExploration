package com.shim.celestialexploration.item;

import com.shim.celestialexploration.entity.DyeType;
import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;

import java.util.function.Supplier;

public class MechaDogItem extends AutoTameSpawnItem {
    public MechaDogItem(DyeType type, Properties properties) {
        super(EntityRegistry.MECHADOG, properties);
    }
}
