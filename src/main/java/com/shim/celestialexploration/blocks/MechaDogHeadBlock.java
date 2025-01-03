//package com.shim.celestialexploration.blocks;
//
//import com.shim.celestialexploration.entity.entity.robots.AbstractCerberus;
//import com.shim.celestialexploration.entity.entity.robots.MechaCerberusBoss;
//import com.shim.celestialexploration.registry.BlockRegistry;
//import com.shim.celestialexploration.registry.EntityRegistry;
//import net.minecraft.advancements.CriteriaTriggers;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.Difficulty;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.pattern.BlockInWorld;
//import net.minecraft.world.level.block.state.pattern.BlockPattern;
//import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
//import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
//import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
//import net.minecraft.world.level.block.state.properties.DirectionProperty;
//import net.minecraft.world.level.material.Material;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import javax.annotation.Nullable;
//
//public class MechaDogHeadBlock extends Block {
//    @Nullable
//    private static BlockPattern patternFull;
//    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
//
//    public MechaDogHeadBlock(BlockBehaviour.Properties p_48687_) {
//        super(p_48687_);
//        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
//    }
//
//    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
//        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
//    }
//
//
//    private static final VoxelShape SHAPE =  Block.box(2, 0, 2, 14, 9, 14);
//
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        return SHAPE;
//    }
//
//    public RenderShape getRenderShape(BlockState p_48727_) {
//        return RenderShape.MODEL;
//    }
//
//    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
//        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
//    }
//
//    public BlockState mirror(BlockState p_48719_, Mirror p_48720_) {
//        return p_48719_.rotate(p_48720_.getRotation(p_48719_.getValue(FACING)));
//    }
//
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
//        p_48725_.add(FACING);
//    }
//
//    @Override
//    public void onPlace(BlockState blockState, Level level, BlockPos pos, BlockState p_60569_, boolean p_60570_) {
//        super.onPlace(blockState, level, pos, p_60569_, p_60570_);
//        checkSpawn(level, pos, blockState);
//    }
//
////    public void setPlacedBy(Level level, BlockPos pos, BlockState blockState, @Nullable LivingEntity entity, ItemStack itemStack) {
////        super.setPlacedBy(level, pos, blockState, entity, itemStack);
//////        BlockEntity blockentity = level.getBlockEntity(p_58261_);
//////        if (blockentity instanceof SkullBlockEntity) {
////            checkSpawn(level, pos, (SkullBlockEntity)blockentity);
//////        }
////
////    }
//
//    public static void checkSpawn(Level level, BlockPos pos, BlockState blockState) {
//        if (!level.isClientSide) {
//            boolean flag = blockState.is(BlockRegistry.MECHADOG_HEAD.get()); // || blockState.is(Blocks.WITHER_SKELETON_WALL_SKULL);
//            if (flag && pos.getY() >= level.getMinBuildHeight() && level.getDifficulty() != Difficulty.PEACEFUL) {
//                BlockPattern blockpattern = getOrCreateFull();
//                BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = blockpattern.find(level, pos);
//                if (blockpattern$blockpatternmatch != null) {
//                    for(int i = 0; i < blockpattern.getWidth(); ++i) {
//                        for(int j = 0; j < blockpattern.getHeight(); ++j) {
//                            BlockInWorld blockinworld = blockpattern$blockpatternmatch.getBlock(i, j, 0);
//                            level.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
//                            level.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
//                        }
//                    }
//
//                    MechaCerberusBoss boss = EntityRegistry.MECHACERBERUS_BOSS.get().create(level);
//                    BlockPos blockpos = blockpattern$blockpatternmatch.getBlock(1, 2, 0).getPos();
//                    boss.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.55D, (double)blockpos.getZ() + 0.5D, blockpattern$blockpatternmatch.getForwards().getAxis() == Direction.Axis.X ? 0.0F : 90.0F, 0.0F);
//                    boss.yBodyRot = blockpattern$blockpatternmatch.getForwards().getAxis() == Direction.Axis.X ? 0.0F : 90.0F;
//                    boss.makeInvulnerable();
//
//                    for(ServerPlayer serverplayer : level.getEntitiesOfClass(ServerPlayer.class, boss.getBoundingBox().inflate(50.0D))) {
//                        CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, boss);
//                    }
//
//                    level.addFreshEntity(boss);
//
//                    for(int k = 0; k < blockpattern.getWidth(); ++k) {
//                        for(int l = 0; l < blockpattern.getHeight(); ++l) {
//                            level.blockUpdated(blockpattern$blockpatternmatch.getBlock(k, l, 0).getPos(), Blocks.AIR);
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
////    public static boolean canSpawnMob(Level p_58268_, BlockPos p_58269_, ItemStack p_58270_) {
////        if (p_58270_.is(Items.WITHER_SKELETON_SKULL) && p_58269_.getY() >= p_58268_.getMinBuildHeight() + 2 && p_58268_.getDifficulty() != Difficulty.PEACEFUL && !p_58268_.isClientSide) {
////            return getOrCreateWitherBase().find(p_58268_, p_58269_) != null;
////        } else {
////            return false;
////        }
////    }
//
//    private static BlockPattern getOrCreateFull() {
//        if (patternFull == null) {
//            patternFull = BlockPatternBuilder.start().aisle("^^^", "###", "~#~").where('#', (p_58272_) -> p_58272_.getState().is(BlockRegistry.STEEL_BLOCK.get()))
//                    .where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockRegistry.MECHADOG_HEAD.get())
////                    .or(BlockStatePredicate.forBlock(Blocks.WITHER_SKELETON_WALL_SKULL))
//                    )).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
//        }
//
//        return patternFull;
//    }
//
////    private static BlockPattern getOrCreateWitherBase() {
////        if (witherPatternBase == null) {
////            witherPatternBase = BlockPatternBuilder.start().aisle("   ", "###", "~#~").where('#', (p_58266_) -> {
////                return p_58266_.getState().is(BlockTags.WITHER_SUMMON_BASE_BLOCKS);
////            }).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
////        }
////
////        return witherPatternBase;
////    }
////
//}
