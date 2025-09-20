package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.*;
import com.shim.celestiallib.api.blocks.AbstractPortalBlock;
import com.shim.celestiallib.api.world.portal.PlanetPortalTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MarsPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return CelestialDimensions.MARS;
    }

    @Override
    public PlanetPortalTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetPortalTeleporter(serverLevel, CelestialPOIs.MARS_PORTAL.get(), CelestialBlocks.MARS_BRICKS.get(), CelestialBlocks.MARS_PORTAL.get(), CelestialDimensions.MARS);
    }

    @Override
    public Block getPortalBlock() {
        return CelestialBlocks.MARS_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return CelestialTags.Blocks.MARS_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return CelestialParticles.MARS_PORTAL_PARTICLES.get();
    }
}