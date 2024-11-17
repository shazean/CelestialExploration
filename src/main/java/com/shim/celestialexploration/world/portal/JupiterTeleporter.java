package com.shim.celestialexploration.world.portal;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.PoiRegistry;
import net.minecraft.server.level.ServerLevel;

public class JupiterTeleporter extends AbstractTeleporter {

    public JupiterTeleporter(ServerLevel worldIn) {
        super(worldIn, PoiRegistry.JUPITER_PORTAL.get(), BlockRegistry.JUPITER_DEEPSLATE_BRICKS.get(), BlockRegistry.JUPITER_PORTAL.get(), DimensionRegistry.JUPITER);
    }
}