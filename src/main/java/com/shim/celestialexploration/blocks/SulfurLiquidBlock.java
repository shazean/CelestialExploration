package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.BlockRegistry;
import com.shim.celestialexploration.registry.FluidRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class SulfurLiquidBlock extends LiquidBlock {
    public SulfurLiquidBlock(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_) {
        super(p_54694_, p_54695_);
    }


    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.fireImmune()) {
            entity.lavaHurt();
        }
        super.entityInside(state, level, pos, entity);
    }

    public void neighborChanged(BlockState p_54709_, Level p_54710_, BlockPos p_54711_, Block p_54712_, BlockPos p_54713_, boolean p_54714_) {
        if (this.shouldSpreadLiquid(p_54710_, p_54711_, p_54709_)) {
            p_54710_.scheduleTick(p_54711_, p_54709_.getFluidState().getType(), this.getFluid().getTickDelay(p_54710_));
        }
    }

    private boolean shouldSpreadLiquid(Level level, BlockPos pos, BlockState p_54699_) {
        if (this.getFluid().is(FluidRegistry.SULFUR_TAG)) {
//            boolean soulSoilBelow = level.getBlockState(pos.below()).is(Blocks.SOUL_SOIL);

            for(Direction direction : POSSIBLE_FLOW_DIRECTIONS) {
                BlockPos blockpos = pos.relative(direction.getOpposite());
                if (level.getFluidState(blockpos).is(FluidTags.WATER)) {
                    Block block = level.getFluidState(pos).isSource() ? BlockRegistry.SULFURIC_OBSIDIAN.get(): BlockRegistry.VENUS_COBBLESTONE.get();
                    level.setBlockAndUpdate(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(level, pos, pos, block.defaultBlockState()));
                    this.fizz(level, pos);
                    return false;
                }

//                if (soulSoilBelow && level.getBlockState(blockpos).is(Blocks.BLUE_ICE)) {
//                    level.setBlockAndUpdate(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(level, pos, pos, Blocks.BASALT.defaultBlockState()));
//                    this.fizz(level, pos);
//                    return false;
//                }
            }
        }

        return true;
    }

    private void fizz(LevelAccessor p_54701_, BlockPos p_54702_) {
        p_54701_.levelEvent(1501, p_54702_, 0);
    }


}
