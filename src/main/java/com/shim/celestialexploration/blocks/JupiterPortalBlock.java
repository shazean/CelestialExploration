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

public class JupiterPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return CelestialDimensions.JUPITER;
    }

    @Override
    public PlanetPortalTeleporter getTeleporter(ServerLevel serverLevel) {
        return new PlanetPortalTeleporter(serverLevel, CelestialPOIs.JUPITER_PORTAL.get(), CelestialBlocks.JUPITER_DEEPSLATE_BRICKS.get(), CelestialBlocks.JUPITER_PORTAL.get(), CelestialDimensions.JUPITER);
    }

    @Override
    public Block getPortalBlock() {
        return CelestialBlocks.JUPITER_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return CelestialTags.Blocks.JUPITER_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return CelestialParticles.JUPITER_PORTAL_PARTICLES.get();
    }
}