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

public class VenusPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return CelestialDimensions.VENUS;
    }

    @Override
    public PlanetPortalTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetPortalTeleporter(serverLevel, CelestialPOIs.VENUS_PORTAL.get(), CelestialBlocks.VENUS_BRICKS.get(), CelestialBlocks.VENUS_PORTAL.get(), CelestialDimensions.VENUS);
    }

    @Override
    public Block getPortalBlock() {
        return CelestialBlocks.VENUS_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return CelestialTags.Blocks.VENUS_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return CelestialParticles.VENUS_PORTAL_PARTICLES.get();
    }
}