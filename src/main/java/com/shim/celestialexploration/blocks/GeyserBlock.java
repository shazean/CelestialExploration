package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.blocks.blockentities.GeyserBlockEntity;
import com.shim.celestialexploration.blocks.blockentities.OxygenCompressorBlockEntity;
import com.shim.celestialexploration.registry.BlockEntityRegistry;
import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GeyserBlock extends BaseEntityBlock {
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;

    public GeyserBlock(Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(this.stateDefinition.any().setValue(ENABLED, Boolean.FALSE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(ENABLED);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GeyserBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BlockEntityRegistry.GEYSER_BLOCK_ENTITY.get(), GeyserBlockEntity::tick);
    }


    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (state.getValue(ENABLED)) {
            spawnParticles(level, pos, random);
        }
    }

    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (state.getValue(ENABLED)) {
            if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) { //TODO add proof-ness or resistance from heavy duty spacesuit?
                entity.hurt(DamageSource.HOT_FLOOR, 2.5F);
            }
        }
        super.stepOn(level, pos, state, entity);
    }


    private static void spawnParticles(Level level, BlockPos pos, Random random) {
        int height = random.nextInt(20) + 5;
        for (int i = 0; i < height; i++) {
            level.addParticle(ParticleRegistry.SULFUR_PARTICLE.get(), (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5 + (i / 2.0), (double) pos.getZ() + 0.5D, 0.0D, 0.5D, 0.0D);
        }
    }

}
