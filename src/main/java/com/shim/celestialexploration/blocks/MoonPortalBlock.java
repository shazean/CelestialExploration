package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.world.portal.PlanetTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MoonPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.MOON;
    }

    @Override
    public PlanetTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetTeleporter(serverLevel, PoiRegistry.MOON_PORTAL.get(), BlockRegistry.MOON_BRICKS.get(), BlockRegistry.MOON_PORTAL.get(), DimensionRegistry.MOON);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.MOON_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.MOON_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.MOON_PORTAL_PARTICLES.get();
    }
}