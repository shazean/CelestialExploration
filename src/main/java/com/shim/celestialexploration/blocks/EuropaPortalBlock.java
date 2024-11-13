package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.ParticleRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.world.portal.AbstractTeleporter;
import com.shim.celestialexploration.world.portal.EuropaTeleporter;
import com.shim.celestialexploration.world.portal.MarsTeleporter;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class EuropaPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.EUROPA;
    }

    @Override
    public AbstractTeleporter getTeleporter(ServerLevel serverLevel) {
        return new EuropaTeleporter(serverLevel);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.EUROPA_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.EUROPA_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.EUROPA_PORTAL_PARTICLES.get();
    }
}