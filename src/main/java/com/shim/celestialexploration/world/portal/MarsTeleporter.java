package com.shim.celestialexploration.world.portal;

import com.shim.celestialexploration.blocks.JupiterPortalBlock;
import com.shim.celestialexploration.blocks.MarsPortalBlock;
import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.PoiRegistry;
import net.minecraft.BlockUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class MarsTeleporter extends AbstractTeleporter {

    public MarsTeleporter(ServerLevel worldIn) {
        super(worldIn, PoiRegistry.MARS_PORTAL.get(), BlockRegistry.MARS_BRICKS.get(), BlockRegistry.MARS_PORTAL.get(), DimensionRegistry.MARS);
    }
}