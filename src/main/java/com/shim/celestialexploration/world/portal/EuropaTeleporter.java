package com.shim.celestialexploration.world.portal;

import com.shim.celestialexploration.blocks.AbstractPortalBlock;
import com.shim.celestialexploration.blocks.MarsPortalBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.PoiRegistry;
import net.minecraft.server.level.ServerLevel;

public class EuropaTeleporter extends AbstractTeleporter {

    public EuropaTeleporter(ServerLevel worldIn) {
        super(worldIn, PoiRegistry.EUROPA_PORTAL.get(), BlockRegistry.EUROPA_BRICKS.get(), BlockRegistry.EUROPA_PORTAL.get(), DimensionRegistry.EUROPA);
    }
}