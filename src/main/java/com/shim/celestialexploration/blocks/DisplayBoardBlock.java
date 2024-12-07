//package com.shim.celestialexploration.blocks;
//
//import com.shim.celestialexploration.blocks.blockentities.DisplayBoardBlockEntity;
//import it.unimi.dsi.fastutil.objects.ObjectArraySet;
//import net.minecraft.advancements.CriteriaTriggers;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.stats.Stats;
//import net.minecraft.util.StringRepresentable;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.*;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.block.BaseEntityBlock;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.SimpleWaterloggedBlock;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//import net.minecraft.world.level.material.FluidState;
//import net.minecraft.world.level.material.Fluids;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import java.util.Set;
//import java.util.stream.Stream;
//
//public class DisplayBoardBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
//    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
//    protected static final float AABB_OFFSET = 4.0F;
//    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
//    private final DisplayBoardColors type;
//
//    protected DisplayBoardBlock(BlockBehaviour.Properties p_56273_, DisplayBoardColors p_56274_) {
//        super(p_56273_);
//        this.type = p_56274_;
//    }
//
//    public BlockState updateShape(BlockState p_56285_, Direction p_56286_, BlockState p_56287_, LevelAccessor p_56288_, BlockPos p_56289_, BlockPos p_56290_) {
//        if (p_56285_.getValue(WATERLOGGED)) {
//            p_56288_.scheduleTick(p_56289_, Fluids.WATER, Fluids.WATER.getTickDelay(p_56288_));
//        }
//
//        return super.updateShape(p_56285_, p_56286_, p_56287_, p_56288_, p_56289_, p_56290_);
//    }
//
//    public VoxelShape getShape(BlockState p_56293_, BlockGetter p_56294_, BlockPos p_56295_, CollisionContext p_56296_) {
//        return SHAPE;
//    }
//
//    public boolean isPossibleToRespawnInThis() {
//        return true;
//    }
//
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new DisplayBoardBlockEntity(pos, state, this.type.textColor);
//    }
//
//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
//        ItemStack itemstack = player.getItemInHand(hand);
//        Item item = itemstack.getItem();
//        boolean flag = item instanceof DyeItem;
//        boolean flag1 = true; //itemstack.is(Items.GLOW_INK_SAC);
//        boolean flag2 = itemstack.is(Items.INK_SAC);
//        boolean flag3 = player.getAbilities().mayBuild;
//        if (level.isClientSide) {
//            return flag3 ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
//        } else {
//            BlockEntity blockentity = level.getBlockEntity(pos);
//            if (!(blockentity instanceof DisplayBoardBlockEntity)) {
//                return InteractionResult.PASS;
//            } else {
//                DisplayBoardBlockEntity boardBlockEntity = (DisplayBoardBlockEntity)blockentity;
//                boolean flag4 = boardBlockEntity.hasGlowingText();
//                if ((!flag1 || !flag4) && !flag2) {
//                    if (flag3) {
//                        boolean flag5;
//                        level.playSound((Player)null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
//                        flag5 = boardBlockEntity.setHasGlowingText(true);
//                        if (player instanceof ServerPlayer) {
//                            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, itemstack);
//                        }
//
//                        if (flag5) {
//                            if (!player.isCreative()) {
//                                itemstack.shrink(1);
//                            }
//
//                            player.awardStat(Stats.ITEM_USED.get(item));
//                        }
//                    }
//
//                    return boardBlockEntity.executeClickCommands((ServerPlayer)player) ? InteractionResult.SUCCESS : InteractionResult.PASS;
//                } else {
//                    return InteractionResult.PASS;
//                }
//            }
//        }
//    }
//
//    public FluidState getFluidState(BlockState p_56299_) {
//        return p_56299_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56299_);
//    }
//
//    public DisplayBoardColors type() {
//        return this.type;
//    }
//
//    public static class DisplayBoardColors {
//        private static final Set<DisplayBoardColors> VALUES = new ObjectArraySet<>();
//        public static final DisplayBoardColors RED = register(new DisplayBoardColors("red", DyeColor.BLACK));
//        public static final DisplayBoardColors BLACK = register(new DisplayBoardColors("black", DyeColor.GREEN));
//        public static final DisplayBoardColors BLUE = register(new DisplayBoardColors("blue", DyeColor.WHITE));
//        public static final DisplayBoardColors WHITE = register(new DisplayBoardColors("white", DyeColor.BLACK));
//        private final String name;
//        private final DyeColor textColor;
//
//        protected DisplayBoardColors(String name, DyeColor defaultTextColor) {
//            this.name = name;
//            this.textColor = defaultTextColor;
//        }
//
//        public static DisplayBoardColors register(DisplayBoardColors p_61845_) {
//            VALUES.add(p_61845_);
//            return p_61845_;
//        }
//
//        public static Stream<DisplayBoardColors> values() {
//            return VALUES.stream();
//        }
//
//        public String name() {
//            return this.name;
//        }
//
//        public DyeColor textColor() {
//            return this.textColor;
//        }
//
//    }
//
//}