package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.DimensionRegistry;
import com.shim.celestialexploration.registry.ParticleRegistry;
import com.shim.celestialexploration.registry.TagRegistry;
import com.shim.celestialexploration.world.portal.AbstractTeleporter;
import com.shim.celestialexploration.world.portal.JupiterTeleporter;
import com.shim.celestialexploration.world.portal.MarsTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;
import java.util.Random;

public class JupiterPortalBlock extends AbstractPortalBlock {
    @Override
    public ResourceKey<Level> getLinkedDimension() {
        return DimensionRegistry.JUPITER;
    }

    @Override
    public AbstractTeleporter getTeleporter(ServerLevel serverLevel) {
        return new JupiterTeleporter(serverLevel);
    }

    @Override
    public Block getPortalBlock() {
        return BlockRegistry.JUPITER_PORTAL.get();
    }

    @Override
    public TagKey<Block> getPortalFrameBlock() {
        return TagRegistry.Blocks.JUPITER_PORTAL_FRAME_BLOCK;
    }

    @Override
    public SimpleParticleType getPortalParticle() {
        return ParticleRegistry.JUPITER_PORTAL_PARTICLES.get();
    }
}