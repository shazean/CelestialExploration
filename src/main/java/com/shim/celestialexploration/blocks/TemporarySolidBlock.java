package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TemporarySolidBlock extends Block {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final int NEIGHBORS_TO_AGE = 4;
    private static final int NEIGHBORS_TO_MELT = 2;
    private final boolean isUnknown;

    public TemporarySolidBlock(BlockBehaviour.Properties properties) {
        this(properties, false);
    }

    public TemporarySolidBlock(BlockBehaviour.Properties properties, boolean isUnknown) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.isUnknown = isUnknown;
    }

    public abstract LiquidBlock getFluid();


    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        this.tick(state, level, pos, random);

        if (level.getBrightness(LightLayer.BLOCK, pos) > 11 - state.getLightBlock(level, pos)) {
            this.melt(state, level, pos);
        }
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if ((random.nextInt(3) == 0 || this.fewerNeigboursThan(level, pos, 4)) && level.getMaxLocalRawBrightness(pos) > 11 - state.getValue(AGE) - state.getLightBlock(level, pos) && this.slightlyMelt(state, level, pos)) {
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (Direction direction : Direction.values()) {
                mutablePos.setWithOffset(pos, direction);
                BlockState blockstate = level.getBlockState(mutablePos);
                if (blockstate.is(this) && !this.slightlyMelt(blockstate, level, mutablePos)) {
                    level.scheduleTick(mutablePos, this, Mth.nextInt(random, 20, 40));
                }
            }

        } else {
            level.scheduleTick(pos, this, Mth.nextInt(random, 20, 40));
        }
    }

    private boolean slightlyMelt(BlockState state, Level level, BlockPos pos) {
        int i = state.getValue(AGE);
        if (i < 3) {
            level.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
            return false;
        } else {
            this.melt(state, level, pos);
            return true;
        }
    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos neighborPos, boolean p_53584_) {
        if (block.defaultBlockState().is(this) && this.fewerNeigboursThan(level, pos, 2)) {
            this.melt(state, level, pos);
        }

        super.neighborChanged(state, level, pos, block, neighborPos, p_53584_);
    }

    private boolean fewerNeigboursThan(BlockGetter getter, BlockPos pos, int p_53568_) {
        int i = 0;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values()) {
            mutablePos.setWithOffset(pos, direction);
            if (getter.getBlockState(mutablePos).is(this)) {
                ++i;
                if (i >= p_53568_) {
                    return false;
                }
            }
        }

        return true;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(AGE);
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, blockEntity, stack);
        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            if (level.dimensionType().ultraWarm()) {
                level.removeBlock(pos, false);
                return;
            }

            Material material = level.getBlockState(pos.below()).getMaterial();
            if (material.blocksMotion() || material.isLiquid()) {


                level.setBlockAndUpdate(pos, this.getFluidOrAir(level, pos).defaultBlockState());

            }
        }
    }

    private Block getFluidOrAir(Level level, BlockPos pos) {
        if (this.isUnknown) {
            if (!CelestialCommonConfig.USE_GENERIC_QUASI_SOLID_BLOCK.get()) {
                return Blocks.AIR;
            }

            FluidState fluidState = level.getFluidState(pos.north());
            BlockState blockState = level.getBlockState(pos.north());
            if (fluidState.isEmpty()) {
                fluidState = level.getFluidState(pos.east());
                blockState = level.getBlockState(pos.east());
            }
            if (fluidState.isEmpty()) {
                fluidState = level.getFluidState(pos.south());
                blockState = level.getBlockState(pos.south());
            }
            if (fluidState.isEmpty()) {
                fluidState = level.getFluidState(pos.west());
                blockState = level.getBlockState(pos.west());
            }

            if (!fluidState.isEmpty()) {
                return blockState.getBlock();
            } else {
                return Blocks.AIR;
            }
        } else {
            return this.getFluid();
        }
    }

    protected void melt(BlockState state, Level level, BlockPos pos) {
        if (level.dimensionType().ultraWarm()) {
            level.removeBlock(pos, false);
        } else {
            Block block = this.getFluidOrAir(level, pos);
            level.setBlockAndUpdate(pos, block.defaultBlockState());
            if (!block.defaultBlockState().isAir())
                level.neighborChanged(pos, block, pos);
        }
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }
}