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

public class IoPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return CelestialDimensions.IO;
    }

    @Override
    public PlanetPortalTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetPortalTeleporter(serverLevel, CelestialPOIs.IO_PORTAL.get(), CelestialBlocks.IO_BRICKS.get(), CelestialBlocks.IO_PORTAL.get(), CelestialDimensions.IO);
    }

    @Override
    public Block getPortalBlock() {
        return CelestialBlocks.IO_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return CelestialTags.Blocks.IO_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return CelestialParticles.IO_PORTAL_PARTICLES.get();
    }
}