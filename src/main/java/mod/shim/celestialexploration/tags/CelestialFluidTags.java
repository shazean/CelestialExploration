package mod.shim.celestialexploration.tags;

import java.util.List;

import mod.shim.celestialexploration.Main;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollection;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class CelestialFluidTags {

	   protected static final TagRegistry<Fluid> HELPER = TagRegistryManager.create(new ResourceLocation(Main.MODID + ":fluid"), ITagCollectionSupplier::getFluids);
	   public static final ITag.INamedTag<Fluid> SULFUR = bind("sulfur");
	   public static final ITag.INamedTag<Fluid> LIQUID_OXYGEN = bind("liquid_oxygen");


	   public static ITag.INamedTag<Fluid> bind(String p_206956_0_) {
	      return HELPER.bind(p_206956_0_);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name) {
	       return createOptional(name, null);
	   }

	   public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Fluid>> defaults) {
	      return HELPER.createOptional(name, defaults);
	   }

	   public static List<? extends ITag.INamedTag<Fluid>> getWrappers() {
	      return HELPER.getWrappers();
	   }

	   //Forge: Readd this stripped getter like the other tag classes
	   public static ITagCollection<Fluid> getAllTags() {
	       return HELPER.getAllTags();
	   }
	}