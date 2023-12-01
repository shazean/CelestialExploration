package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
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

    public static final ResourceLocation WATER_STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, CelestialExploration.MODID);

    public static final RegistryObject<FlowingFluid> LOX = FLUIDS.register("lox", () -> new ForgeFlowingFluid.Source(FluidRegistry.LOX_PROPERTIES));
    public static final RegistryObject<FlowingFluid> LOX_FLOWING = FLUIDS.register("lox_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.LOX_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_IRON = FLUIDS.register("molten_iron", () -> new ForgeFlowingFluid.Source(FluidRegistry.MOLTEN_IRON_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_IRON_FLOWING = FLUIDS.register("molten_iron_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MOLTEN_IRON_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_STEEL = FLUIDS.register("molten_steel", () -> new ForgeFlowingFluid.Source(FluidRegistry.MOLTEN_STEEL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_STEEL_FLOWING = FLUIDS.register("molten_steel_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MOLTEN_STEEL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_COPPER = FLUIDS.register("molten_copper", () -> new ForgeFlowingFluid.Source(FluidRegistry.MOLTEN_COPPER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_COPPER_FLOWING = FLUIDS.register("molten_copper_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MOLTEN_COPPER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_GOLD = FLUIDS.register("molten_gold", () -> new ForgeFlowingFluid.Source(FluidRegistry.MOLTEN_GOLD_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MOLTEN_GOLD_FLOWING = FLUIDS.register("molten_gold_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MOLTEN_GOLD_PROPERTIES));
//    public static final RegistryObject<FlowingFluid> MOLTEN_NETHERITE = FLUIDS.register("molten_netherite", () -> new ForgeFlowingFluid.Source(FluidRegistry.MOLTEN_NETHERITE_PROPERTIES));
//    public static final RegistryObject<FlowingFluid> MOLTEN_NETHERITE_FLOWING = FLUIDS.register("molten_neitherite_flowing", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.MOLTEN_NETHERITE_PROPERTIES));

    public static final RegistryObject<Item> LOX_BUCKET = ItemRegistry.ITEMS.register("lox_bucket", () -> new BucketItem(FluidRegistry.LOX, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MOLTEN_IRON_BUCKET = ItemRegistry.ITEMS.register("molten_iron_bucket", () -> new BucketItem(FluidRegistry.MOLTEN_IRON, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MOLTEN_STEEL_BUCKET = ItemRegistry.ITEMS.register("molten_steel_bucket", () -> new BucketItem(FluidRegistry.MOLTEN_STEEL, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MOLTEN_COPPER_BUCKET = ItemRegistry.ITEMS.register("molten_copper_bucket", () -> new BucketItem(FluidRegistry.MOLTEN_COPPER, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MOLTEN_GOLD_BUCKET = ItemRegistry.ITEMS.register("molten_gold_bucket", () -> new BucketItem(FluidRegistry.MOLTEN_GOLD, new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> MOLTEN_NETHERITE_BUCKET = ItemRegistry.ITEMS.register("molten_netherite_bucket", () -> new BucketItem(FluidRegistry.MOLTEN_NETHERITE, new Item.Properties().stacksTo(1)));


    public static final ForgeFlowingFluid.Properties LOX_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> LOX.get(), () -> LOX_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(0xfa9bf9ff)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> FluidRegistry.LOX_BLOCK.get()).bucket(() -> FluidRegistry.LOX_BUCKET.get());
    public static final ForgeFlowingFluid.Properties MOLTEN_IRON_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_IRON.get(), () -> MOLTEN_IRON_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(0xfaaf8e77)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> FluidRegistry.MOLTEN_IRON_BLOCK.get()).bucket(() -> FluidRegistry.MOLTEN_IRON_BUCKET.get());
    public static final ForgeFlowingFluid.Properties MOLTEN_STEEL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_STEEL.get(), () -> MOLTEN_STEEL_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(0xfa454042)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> FluidRegistry.MOLTEN_STEEL_BLOCK.get()).bucket(() -> FluidRegistry.MOLTEN_STEEL_BUCKET.get());
    public static final ForgeFlowingFluid.Properties MOLTEN_COPPER_PROPERTIES = new ForgeFlowingFluid.Properties(
        () -> MOLTEN_COPPER.get(), () -> MOLTEN_COPPER_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
        .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
        .color(0xfac15a36)).slopeFindDistance(2).levelDecreasePerBlock(2)
        .block(() -> FluidRegistry.MOLTEN_COPPER_BLOCK.get()).bucket(() -> FluidRegistry.MOLTEN_COPPER_BUCKET.get());
    public static final ForgeFlowingFluid.Properties MOLTEN_GOLD_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MOLTEN_GOLD.get(), () -> MOLTEN_GOLD_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
            .color(0xfadc9613)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> FluidRegistry.MOLTEN_GOLD_BLOCK.get()).bucket(() -> FluidRegistry.MOLTEN_GOLD_BUCKET.get());
//    public static final ForgeFlowingFluid.Properties MOLTEN_NETHERITE_PROPERTIES = new ForgeFlowingFluid.Properties(
//            () -> MOLTEN_NETHERITE.get(), () -> MOLTEN_NETHERITE_FLOWING.get(), FluidAttributes.builder(WATER_STILL, WATER_FLOWING_RL)
//            .density(15).luminosity(2).viscosity(5).sound(SoundEvents.LAVA_AMBIENT).overlay(WATER_OVERLAY_RL)
//            .color(0xfa4a2940)).slopeFindDistance(2).levelDecreasePerBlock(2)
//            .block(() -> FluidRegistry.MOLTEN_NETHERITE_BLOCK.get()).bucket(() -> FluidRegistry.MOLTEN_NETHERITE_BUCKET.get());

    public static final RegistryObject<LiquidBlock> LOX_BLOCK = BlockRegistry.BLOCKS.register("lox", () -> new LiquidBlock(FluidRegistry.LOX, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(10f).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_IRON_BLOCK = BlockRegistry.BLOCKS.register("molten_iron", () -> new LiquidBlock(FluidRegistry.MOLTEN_IRON, BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(10f).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_STEEL_BLOCK = BlockRegistry.BLOCKS.register("molten_steel", () -> new LiquidBlock(FluidRegistry.MOLTEN_STEEL, BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(10f).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_COPPER_BLOCK = BlockRegistry.BLOCKS.register("molten_copper", () -> new LiquidBlock(FluidRegistry.MOLTEN_COPPER, BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(10f).noDrops()));
    public static final RegistryObject<LiquidBlock> MOLTEN_GOLD_BLOCK = BlockRegistry.BLOCKS.register("molten_gold", () -> new LiquidBlock(FluidRegistry.MOLTEN_GOLD, BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(10f).noDrops()));
//    public static final RegistryObject<LiquidBlock> MOLTEN_NETHERITE_BLOCK = BlockRegistry.BLOCKS.register("molten_netherite", () -> new LiquidBlock(FluidRegistry.MOLTEN_NETHERITE, BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(10f).noDrops()));


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
