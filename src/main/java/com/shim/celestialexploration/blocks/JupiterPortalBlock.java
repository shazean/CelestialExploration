package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.portal.PlanetTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class JupiterPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.JUPITER;
    }

    @Override
    public PlanetTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetTeleporter(serverLevel, PoiRegistry.EUROPA_PORTAL.get(), BlockRegistry.EUROPA_BRICKS.get(), BlockRegistry.EUROPA_PORTAL.get(), DimensionRegistry.EUROPA);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.JUPITER_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.JUPITER_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.JUPITER_PORTAL_PARTICLES.get();
    }
}