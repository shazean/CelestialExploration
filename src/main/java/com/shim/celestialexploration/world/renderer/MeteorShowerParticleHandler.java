package com.shim.celestialexploration.world.renderer;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.ParticleStatus;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.IWeatherParticleRenderHandler;

import java.util.Random;

public class MeteorShowerParticleHandler implements IWeatherParticleRenderHandler {

    @Override
    public void render(int ticks, ClientLevel level, Minecraft minecraft, Camera camera) {
        if (level.isThundering()) {

        }

        Random random = new Random((long) ticks * 312987231L);
        BlockPos blockpos = new BlockPos(camera.getPosition());
        BlockPos blockpos1;
        int i = (int) (100.0F) / (minecraft.options.particles == ParticleStatus.DECREASED ? 2 : 1);

        for (int j = 0; j < i; ++j) {
            int k = random.nextInt(21) - 10;
            int l = random.nextInt(21) - 10;
            BlockPos blockpos2 = ((LevelReader) level).getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockpos.offset(k, 0, l));
//            Biome biome = level.getBiome(blockpos2).value();
            if (blockpos2.getY() > level.getMinBuildHeight() && blockpos2.getY() <= blockpos.getY() + 10 && blockpos2.getY() >= blockpos.getY() - 10) { //&& biome.getPrecipitation() == Biome.Precipitation.RAIN && biome.warmEnoughToRain(blockpos2)) {
                blockpos1 = blockpos2.below();
                if (minecraft.options.particles == ParticleStatus.MINIMAL) {
                    break;
                }

                double d0 = random.nextDouble();
                double d1 = random.nextDouble();
                BlockState blockstate = ((LevelReader) level).getBlockState(blockpos1);
                FluidState fluidstate = ((LevelReader) level).getFluidState(blockpos1);
                VoxelShape voxelshape = blockstate.getCollisionShape(level, blockpos1);
                double d2 = voxelshape.max(Direction.Axis.Y, d0, d1);
                double d3 = (double) fluidstate.getHeight(level, blockpos1);
                double d4 = Math.max(d2, d3);
                ParticleOptions particleoptions = ParticleTypes.SMOKE;
                level.addParticle(particleoptions, (double) blockpos1.getX() + d0, (double) blockpos1.getY() + d4, (double) blockpos1.getZ() + d1, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
