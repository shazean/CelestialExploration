package com.shim.celestialexploration.blocks;

import com.shim.celestialexploration.registry.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.openjdk.nashorn.internal.ir.annotations.Ignore;

import javax.annotation.Nullable;
import java.util.Random;

public class AtmosphereBlock extends HalfTransparentBlock {

    public AtmosphereBlock(Properties p_53970_) {
        super(p_53970_);
    }

    public VoxelShape getVisualShape(BlockState p_48735_, BlockGetter p_48736_, BlockPos p_48737_, CollisionContext p_48738_) {
        return Shapes.empty();
    }

    public float getShadeBrightness(BlockState p_48731_, BlockGetter p_48732_, BlockPos p_48733_) {
        return 1.0F;
    }

    public boolean propagatesSkylightDown(BlockState p_48740_, BlockGetter p_48741_, BlockPos p_48742_) {
        return true;
    }


    public void entityInside(BlockState p_58180_, Level p_58181_, BlockPos p_58182_, Entity p_58183_) {
        p_58183_.makeStuckInBlock(p_58180_, new Vec3(0.08D, (double) 0.05F, 0.08D));
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0) {
            Direction direction = Direction.getRandom(rand);
            if (direction != Direction.UP) {
                BlockPos blockpos = pos.relative(direction);
                BlockState blockstate = level.getBlockState(blockpos);
                if (!state.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, direction.getOpposite())) {
//                    double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
//                    double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
//                    double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
//                    level.addParticle(DustParticleOptions.REDSTONE, (double)pos.getX() + d1, (double)pos.getY() + d2, (double)pos.getZ() + d3, 0.0D, 0.0D, 0.0D);


                    double d0 = direction.getStepX() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepX() * 0.6D;
                    double d1 = direction.getStepY() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepY() * 0.6D;
                    double d2 = direction.getStepZ() == 0 ? rand.nextDouble() : 0.5D + (double) direction.getStepZ() * 0.6D;
//                    level.addParticle(ParticleRegistry.LIGHTNING_PARTICLE.get(), (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
//                    level.addParticle(ParticleRegistry.LIGHTNING_PARTICLE.get(), (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 1.0D, 0.0D, 0.0D);
                }
            }
        }

    }


}