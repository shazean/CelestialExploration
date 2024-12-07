package com.shim.celestialexploration.inventory;

import com.google.common.collect.Lists;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.inventory.containers.WorkbenchCraftingContainer;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

import java.util.List;
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
//        if (this.player instanceof ServerPlayer && this.container instanceof RecipeHolder) {
//            CelestialExploration.LOGGER.debug("checkTakeAchievements, serverPlayer, is workbenchBlockEntity");
//            ((WorkbenchBlockEntity)this.container).awardUsedRecipesAndPopExperience((ServerPlayer)this.player);
//        }

        if (this.removeCount > 0) {
            itemStack.onCraftedBy(this.player.level, this.player, this.removeCount);
            net.minecraftforge.event.ForgeEventFactory.firePlayerCraftingEvent(this.player, itemStack, this.craftSlots);
        }

        //TODO grant experience

        if (this.container instanceof RecipeHolder) {
            ((RecipeHolder)this.container).awardUsedRecipes(this.player);
//            if (this.player instanceof ServerPlayer serverPlayer) popExperience(serverPlayer, recipe);

        }

        this.removeCount = 0;
    }

    public void popExperience(ServerPlayer player, WorkbenchCraftingRecipe recipe) {
        CelestialExploration.LOGGER.debug("popExperience");

        Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
        ResourceLocation resourcelocation = recipe.getId();
        recipesUsed.addTo(resourcelocation, 1);

        for(Object2IntMap.Entry<ResourceLocation> entry : recipesUsed.object2IntEntrySet()) {
            player.level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe1) -> {
                createExperience(player.getLevel(), player.position(), entry.getIntValue(), ((WorkbenchCraftingRecipe)recipe1).getExperience());
            });
        }
    }

//    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel level, Vec3 pos) {
//        List<Recipe<?>> list = Lists.newArrayList();
//        CelestialExploration.LOGGER.debug("getRecipesToAwardAndPopExperience");
//
//
//
//        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
//            level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
//                list.add(recipe);
//                createExperience(level, pos, entry.getIntValue(), ((WorkbenchCraftingRecipe)recipe).getExperience());
//            });
//        }
//
//        return list;
//    }

    private static void createExperience(ServerLevel level, Vec3 position, int p_155001_, float p_155002_) {
        int i = Mth.floor((float)p_155001_ * p_155002_);
        float f = Mth.frac((float)p_155001_ * p_155002_);
        if (f != 0.0F && Math.random() < (double)f) {
            ++i;
        }

        ExperienceOrb.award(level, position, i);
    }

    public void onTake(Player player, ItemStack stack) {
        this.checkTakeAchievements(stack);

        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
        NonNullList<ItemStack> nonnulllist = player.level.getRecipeManager().getRemainingItemsFor(WorkbenchCraftingRecipe.Type.INSTANCE, this.craftSlots, player.level);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

        Optional<WorkbenchCraftingRecipe> recipe = player.level.getRecipeManager().getRecipeFor(WorkbenchCraftingRecipe.Type.INSTANCE, this.craftSlots, player.level);

        IFluidHandlerItem cap = CelestialExploration.getCapability(stack, CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY);

        if (cap != null) {

            CelestialExploration.LOGGER.debug("fluidJustAdded: " + this.craftSlots.getFluidToLeaveBehind());
            FluidStack fluidToLeaveBehind = new FluidStack(this.craftSlots.getTank().getFluid(), this.craftSlots.getFluidToLeaveBehind());
            this.craftSlots.getTank().drain(this.craftSlots.getTank().getTankCapacity(0), IFluidHandler.FluidAction.EXECUTE);
            this.craftSlots.getTank().fill(fluidToLeaveBehind, IFluidHandler.FluidAction.EXECUTE);

            this.craftSlots.setFluidAmount(this.craftSlots.getTank().getFluidAmount());

            this.craftSlots.resetFluidToLeaveBehind();

            for (int i = 0; i < nonnulllist.size(); ++i) {
                ItemStack itemstack = this.craftSlots.getItem(i);
                ItemStack itemstack1 = nonnulllist.get(i);
                if (!itemstack.isEmpty()) {
                    this.craftSlots.removeItem(i, 1);
                    itemstack = this.craftSlots.getItem(i);
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


        if (recipe.isPresent()) {

            if (player instanceof ServerPlayer serverPlayer) this.popExperience(serverPlayer, recipe.get());


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