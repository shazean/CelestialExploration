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

public class EuropaPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return CelestialDimensions.EUROPA;
    }

    @Override
    public PlanetPortalTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetPortalTeleporter(serverLevel, CelestialPOIs.EUROPA_PORTAL.get(), CelestialBlocks.EUROPA_BRICKS.get(), CelestialBlocks.EUROPA_PORTAL.get(), CelestialDimensions.EUROPA);
    }

    @Override
    public Block getPortalBlock() {
        return CelestialBlocks.EUROPA_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return CelestialTags.Blocks.EUROPA_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return CelestialParticles.EUROPA_PORTAL_PARTICLES.get();
    }
}