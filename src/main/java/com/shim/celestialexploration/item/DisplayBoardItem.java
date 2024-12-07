//package com.shim.celestialexploration.item;
//
//import com.shim.celestialexploration.CelestialExploration;
//import com.shim.celestialexploration.blocks.blockentities.DisplayBoardBlockEntity;
//import com.shim.celestialexploration.inventory.screens.DisplayBoardEditScreen;
//import net.minecraft.client.player.LocalPlayer;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.StandingAndWallBlockItem;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//
//import javax.annotation.Nullable;
//
//public class DisplayBoardItem extends StandingAndWallBlockItem {
//    public DisplayBoardItem(Item.Properties p_43126_, Block p_43127_, Block p_43128_) {
//        super(p_43127_, p_43128_, p_43126_);
//    }
//
//    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack stack, BlockState state) {
//        boolean flag = super.updateCustomBlockEntityTag(pos, level, player, stack, state);
//        if (/*!*/level.isClientSide && !flag && player != null) {
////            p_43132_.openTextEdit((DisplayBoardBlockEntity)p_43131_.getBlockEntity(p_43130_));
//            CelestialExploration.PROXY.getMinecraft().setScreen(new DisplayBoardEditScreen((DisplayBoardBlockEntity)level.getBlockEntity(pos), CelestialExploration.PROXY.getMinecraft().isTextFilteringEnabled()));
//        }
//
//        return flag;
//    }
//}