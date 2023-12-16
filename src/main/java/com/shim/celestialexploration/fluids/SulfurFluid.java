package com.shim.celestialexploration.fluids;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.Random;

public class SulfurFluid extends ForgeFlowingFluid {
    protected SulfurFluid(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }


    public void animateTick(Level p_76208_, BlockPos p_76209_, FluidState p_76210_, Random p_76211_) {
        BlockPos blockpos = p_76209_.above();
        if (p_76208_.getBlockState(blockpos).isAir() && !p_76208_.getBlockState(blockpos).isSolidRender(p_76208_, blockpos)) {
            if (p_76211_.nextInt(100) == 0) {
                double d0 = (double)p_76209_.getX() + p_76211_.nextDouble();
                double d1 = (double)p_76209_.getY() + 1.0D;
                double d2 = (double)p_76209_.getZ() + p_76211_.nextDouble();
                p_76208_.addParticle(ParticleRegistry.SULFUR_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                p_76208_.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.2F + p_76211_.nextFloat() * 0.2F, 0.9F + p_76211_.nextFloat() * 0.15F, false);
            }

            if (p_76211_.nextInt(200) == 0) {
                p_76208_.playLocalSound((double)p_76209_.getX(), (double)p_76209_.getY(), (double)p_76209_.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.2F + p_76211_.nextFloat() * 0.2F, 0.9F + p_76211_.nextFloat() * 0.15F, false);
            }
        }

    }

    protected boolean isRandomlyTicking() {
        return true;
    }


    public void randomTick(Level p_76239_, BlockPos p_76240_, FluidState p_76241_, Random p_76242_) {
        if (p_76239_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = p_76242_.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = p_76240_;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.offset(p_76242_.nextInt(3) - 1, 1, p_76242_.nextInt(3) - 1);
                    if (!p_76239_.isLoaded(blockpos)) {
                        return;
                    }

                    BlockState blockstate = p_76239_.getBlockState(blockpos);
                    if (blockstate.isAir()) {
                        if (this.hasFlammableNeighbours(p_76239_, blockpos)) {
                            p_76239_.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_76239_, blockpos, p_76240_, Blocks.SOUL_FIRE.defaultBlockState()));
                            return;
                        }
                    } else if (blockstate.getMaterial().blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = p_76240_.offset(p_76242_.nextInt(3) - 1, 0, p_76242_.nextInt(3) - 1);
                    if (!p_76239_.isLoaded(blockpos1)) {
                        return;
                    }

                    if (p_76239_.isEmptyBlock(blockpos1.above()) && this.isFlammable(p_76239_, blockpos1, Direction.UP)) {
                        p_76239_.setBlockAndUpdate(blockpos1.above(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_76239_, blockpos1.above(), p_76240_, Blocks.SOUL_FIRE.defaultBlockState()));
                    }
                }
            }

        }
    }

    private boolean hasFlammableNeighbours(LevelReader p_76228_, BlockPos p_76229_) {
        for(Direction direction : Direction.values()) {
            if (this.isFlammable(p_76228_, p_76229_.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }

    private boolean isFlammable(LevelReader level, BlockPos pos, Direction face) {
        return (pos.getY() < level.getMinBuildHeight() || pos.getY() >= level.getMaxBuildHeight() || level.hasChunkAt(pos)) && level.getBlockState(pos).isFlammable(level, pos, face);
    }


    public static class Flowing extends SulfurFluid
    {
        public Flowing(Properties properties)
        {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends SulfurFluid
    {
        public Source(Properties properties)
        {
            super(properties);
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

}
