package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.portal.PlanetTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MercuryPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.MERCURY;
    }

    @Override
    public PlanetTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetTeleporter(serverLevel, PoiRegistry.MERCURY_PORTAL.get(), BlockRegistry.MERCURY_BRICKS.get(), BlockRegistry.MERCURY_PORTAL.get(), DimensionRegistry.MERCURY);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.MERCURY_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.MERCURY_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.MERCURY_PORTAL_PARTICLES.get();
    }
}