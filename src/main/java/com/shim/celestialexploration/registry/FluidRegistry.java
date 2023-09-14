package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegistry {

    public static final ResourceLocation LOX_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation LOX_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LOX_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, CelestialExploration.MODID);

    public static final RegistryObject<FlowingFluid> LOX_STILL = FLUIDS.register("lox_still", () -> new ForgeFlowingFluid.Source(FluidRegistry.LOX_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LOX_FLOWING = FLUIDS.register("lox_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.LOX_PROPERTIES));

    public static final ForgeFlowingFluid.Properties LOX_PROPERTIES = new ForgeFlowingFluid.Properties(() -> LOX_STILL.get(), () -> LOX_FLOWING.get(), FluidAttributes.builder(LOX_STILL_RL, LOX_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.WATER_AMBIENT).overlay(LOX_OVERLAY_RL)
            .color(0x9bf9ff)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> FluidRegistry.LOX_BLOCK.get())
            .bucket(() -> ItemRegistry.LOX_BUCKET.get());

    public static final RegistryObject<LiquidBlock> LOX_BLOCK = BlockRegistry.BLOCKS.register("lox", () -> new LiquidBlock(() -> FluidRegistry.LOX_STILL.get(), BlockBehaviour.Properties.of(Material.WATER)
            .noCollission().strength(10f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
