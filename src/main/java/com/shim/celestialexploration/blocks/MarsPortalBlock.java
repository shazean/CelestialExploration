package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.portal.PlanetTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MarsPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.MARS;
    }

    @Override
    public PlanetTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetTeleporter(serverLevel, PoiRegistry.MARS_PORTAL.get(), BlockRegistry.MARS_BRICKS.get(), BlockRegistry.MARS_PORTAL.get(), DimensionRegistry.MARS);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.MARS_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.MARS_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.MARS_PORTAL_PARTICLES.get();
    }
}