package com.shim.celestialexploration.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
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

import java.util.Random;

public abstract class AbstractPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    ParticleOptions particle;

    public AbstractPortalBlock(ParticleOptions particle) {
        super(Properties.of(Material.PORTAL)
                .strength(-1F)
                .noCollission()
                .lightLevel((state) -> 10)
                .noDrops()
        );
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));

        this.particle = particle;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case Z -> Z_AABB;
            case X -> X_AABB;
            default -> X_AABB;
        };
    }

    public abstract boolean trySpawnPortal(LevelAccessor worldIn, BlockPos pos);

//    public static boolean onTrySpawnPortal(LevelAccessor world, BlockPos pos, AbstractPortalBlock.Size size) {
//        return MinecraftForge.EVENT_BUS.post(new AbstractPortalBlock.PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
//    }
//
//    @Cancelable
//    public static class PortalSpawnEvent extends BlockEvent {
//        private final AbstractPortalBlock.Size size;
//
//        public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, AbstractPortalBlock.Size size) {
//            super(world, pos, state);
//            this.size = size;
//        }
//
//        public AbstractPortalBlock.Size getPortalSize()
//        {
//            return size;
//        }
//    }

//    @Nullable
//    public Size isPortal(LevelAccessor worldIn, BlockPos pos);

    public abstract void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity);

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D,
                    (double)pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT,
                    SoundSource.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double x = (double)pos.getX() + rand.nextDouble();
            double y = (double)pos.getY() + rand.nextDouble();
            double z = (double)pos.getZ() + rand.nextDouble();
            double xSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
                x = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                xSpeed = rand.nextFloat() * 2.0F * (float)j;
            } else {
                z = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                zSpeed = rand.nextFloat() * 2.0F * (float)j;
            }

            worldIn.addParticle(particle, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return switch (rot) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
                case Z -> state.setValue(AXIS, Direction.Axis.X);
                case X -> state.setValue(AXIS, Direction.Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}