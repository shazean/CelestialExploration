package com.shim.celestialexploration.inventory;

import com.shim.celestialexploration.blocks.blockentities.WorkbenchBlockEntity;
import com.shim.celestialexploration.inventory.containers.WorkbenchCraftingContainer;
import com.shim.celestialexploration.item.BlockMoldItem;
import com.shim.celestialexploration.item.IngotMoldItem;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.registry.ItemRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.Optional;

public class WorkbenchResultSlot extends Slot {
    private final WorkbenchCraftingContainer craftSlots;
    private final Player player;
    private int removeCount;

    public WorkbenchResultSlot(Player p_40166_, WorkbenchCraftingContainer p_40167_, Container p_40168_, int p_40169_, int p_40170_, int p_40171_) {
        super(p_40168_, p_40169_, p_40170_, p_40171_);
        this.player = p_40166_;
        this.craftSlots = p_40167_;
    }

    public boolean mayPlace(ItemStack p_40178_) {
        return false;
    }

    public ItemStack remove(int p_40173_) {
        if (this.hasItem()) {
            this.removeCount += Math.min(p_40173_, this.getItem().getCount());
        }

        return super.remove(p_40173_);
    }

    protected void onQuickCraft(ItemStack p_40180_, int p_40181_) {
        this.removeCount += p_40181_;
        this.checkTakeAchievements(p_40180_);
    }

    protected void onSwapCraft(int p_40183_) {
        this.removeCount += p_40183_;
    }

    protected void checkTakeAchievements(ItemStack itemStack) {
        if (this.removeCount > 0) {
            itemStack.onCraftedBy(this.player.level, this.player, this.removeCount);
            net.minecraftforge.event.ForgeEventFactory.firePlayerCraftingEvent(this.player, itemStack, this.craftSlots);
        }

        //TODO grant experience

        if (this.container instanceof RecipeHolder) {
            ((RecipeHolder)this.container).awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }

    public void onTake(Player player, ItemStack p_150639_) {
        this.checkTakeAchievements(p_150639_);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
        NonNullList<ItemStack> nonnulllist = player.level.getRecipeManager().getRemainingItemsFor(WorkbenchCraftingRecipe.Type.INSTANCE, this.craftSlots, player.level);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

        Optional<WorkbenchCraftingRecipe> recipe = player.level.getRecipeManager().getRecipeFor(WorkbenchCraftingRecipe.Type.INSTANCE, this.craftSlots, player.level);

        if (recipe.isPresent()) {
            float buckets = recipe.get().getBuckets();

            int millibuckets = (int) (buckets * 1000.0);

            this.craftSlots.getTank().drain(millibuckets, IFluidHandler.FluidAction.EXECUTE);
            this.craftSlots.setFluidAmount(this.craftSlots.getTank().getFluidAmount());

            for (int i = 0; i < nonnulllist.size(); ++i) {
                ItemStack itemstack = this.craftSlots.getItem(i);
                ItemStack itemstack1 = nonnulllist.get(i);
                if (!itemstack.isEmpty()) {

                    this.craftSlots.removeItem(i, 1);
                    itemstack = this.craftSlots.getItem(i);

//                    if (itemstack.getItem() instanceof IngotMoldItem) {
//                        this.craftSlots.setItem(i, new ItemStack(ItemRegistry.INGOT_MOLD.get(), 1));
//                    }

//                    if (itemstack.getItem() instanceof BlockMoldItem) {
//                        this.craftSlots.setItem(i, new ItemStack(ItemRegistry.BLOCK_MOLD.get(), 1));
//                    }
                }

                if (!itemstack1.isEmpty()) {
                    if (itemstack.isEmpty()) {
                        this.craftSlots.setItem(i, itemstack1);
                    } else if (ItemStack.isSame(itemstack, itemstack1) && ItemStack.tagMatches(itemstack, itemstack1)) {
                        itemstack1.grow(itemstack.getCount());
                        this.craftSlots.setItem(i, itemstack1);
                    } else if (!this.player.getInventory().add(itemstack1)) {
                        this.player.drop(itemstack1, false);
                    }
                }
            }
        }
    }
}