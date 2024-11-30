package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.portal.PlanetTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class CallistoPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.CALLISTO;
    }

    @Override
    public PlanetTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetTeleporter(serverLevel, PoiRegistry.CALLISTO_PORTAL.get(), BlockRegistry.CALLISTO_BRICKS.get(), BlockRegistry.CALLISTO_PORTAL.get(), DimensionRegistry.CALLISTO);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.CALLISTO_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.CALLISTO_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.CALLISTO_PORTAL_PARTICLES.get();
    }
}