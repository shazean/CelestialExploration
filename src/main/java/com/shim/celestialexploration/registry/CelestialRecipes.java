package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.recipes.MechaCrowCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchCraftingRecipe;
import com.shim.celestialexploration.recipes.WorkbenchSmeltingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CelestialRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CelestialExploration.MODID);

    public static final RegistryObject<RecipeSerializer<WorkbenchCraftingRecipe>> WORKBENCH_CRAFTING_SERIALIZER = SERIALIZERS.register("workbench_crafting", () -> WorkbenchCraftingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<WorkbenchSmeltingRecipe>> WORKBENCH_SMELTING_SERIALIZER = SERIALIZERS.register("workbench_smelting", () -> WorkbenchSmeltingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<MechaCrowCraftingRecipe>> MECHACROW_CRAFTING_SERIALIZER = SERIALIZERS.register("mechacrow_crafting", () -> MechaCrowCraftingRecipe.Serializer.INSTANCE);

}
