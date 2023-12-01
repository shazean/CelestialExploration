package com.shim.celestialexploration.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.crafting.CraftingHelper.getNBT;
import static net.minecraftforge.fluids.FluidStack.EMPTY;

public class CelestialJsonHelper {
    public static FluidStack getFluidStackFromJson(JsonObject json, boolean readNBT, boolean disallowsAirInRecipe, String string) {
        String fluidName = GsonHelper.getAsString(json, string);
        Fluid fluid = getFluid(fluidName, disallowsAirInRecipe);
        if (readNBT && json.has("nbt")) {
            CompoundTag nbt = getNBT(json.get("nbt"));
            CompoundTag tmp = new CompoundTag();
            if (nbt.contains("ForgeCaps")) {
                tmp.put("ForgeCaps", nbt.get("ForgeCaps"));
                nbt.remove("ForgeCaps");
            }

            tmp.put("tag", nbt);
            tmp.putString("id", fluidName);
            tmp.putInt("Count", GsonHelper.getAsInt(json, "count", 1));

            return FluidStack.loadFluidStackFromNBT(tmp);
        }

        return new FluidStack(fluid, GsonHelper.getAsInt(json, "count", 1));
    }

    public static Fluid getFluid(String fluidName, boolean disallowsAirInRecipe) {
        ResourceLocation fluidKey = new ResourceLocation(fluidName);
        if (!ForgeRegistries.FLUIDS.containsKey(fluidKey))
            throw new JsonSyntaxException("Unknown fluid '" + fluidName + "'");

        Fluid fluid = ForgeRegistries.FLUIDS.getValue(fluidKey);
        if (disallowsAirInRecipe && fluid == Fluids.EMPTY)
            throw new JsonSyntaxException("Invalid fluid: " + fluidName);
        return Objects.requireNonNull(fluid);
    }

}
