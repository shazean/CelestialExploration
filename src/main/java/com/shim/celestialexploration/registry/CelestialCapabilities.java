package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.IFuelTank;
import com.shim.celestialexploration.capabilities.LoxTankCapabilityProvider;
import com.shim.celestialexploration.capabilities.MetallicHydrogenCapabilityProvider;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestiallib.api.capabilities.SpaceVehicleCapabilityProvider;
import com.shim.celestiallib.capabilities.CLibCapabilities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

public class CelestialCapabilities {

    public static final Capability<IFuelTank> FUEL_TANK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    public static final Capability<ISpaceFlight> SPACE_FLIGHT_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    public static final Capability<TaxiCapability.ITaxi> TAXI_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
//    public static final Capability<TaxiCapability.ITaxi> VILLAGER_TRAVEL_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent eventIn) {
        eventIn.register(IFuelTank.class);
//        eventIn.register(ISpaceFlight.class);
//        eventIn.register(TaxiCapability.ITaxi.class);
//        eventIn.register(VillagerTravelCapability.ITravel.class);
    }

    public static void attachItemCapabilities(AttachCapabilitiesEvent<ItemStack> eventIn) {
        if (eventIn.getObject().getItem() == CelestialItems.LOX_TANK.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_fuel_tank_item"), new LoxTankCapabilityProvider());
        }
        if (eventIn.getObject().getItem() == CelestialItems.METALLIC_HYDROGEN_TANK.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "metallic_hydrogen_fuel_tank_item"), new MetallicHydrogenCapabilityProvider());
        }
        if (eventIn.getObject().getItem() == CelestialItems.FLUID_BASIN.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "basin"), new FluidHandlerItemStack(CelestialItems.FLUID_BASIN.get().getDefaultInstance(), 4000));
        }
    }

    public static void attachBlockCapabilities(AttachCapabilitiesEvent<BlockEntity> eventIn) {
        if (eventIn.getObject().getBlockState() == CelestialBlocks.LOX_TANK.get().defaultBlockState()) {
            if (!eventIn.getObject().getCapability(LoxTankCapabilityProvider.LOX_TANK).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_fuel_tank_block"), new LoxTankCapabilityProvider());
            }
        } else if (eventIn.getObject().getBlockState() == CelestialBlocks.METALLIC_HYDROGEN_TANK.get().defaultBlockState()) {
            if (!eventIn.getObject().getCapability(MetallicHydrogenCapabilityProvider.METALLIC_HYDROGEN_TANK).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "metallic_hydrogen_fuel_tank_block"), new MetallicHydrogenCapabilityProvider());
            }
        }
    }

    public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> eventIn) {
        if (eventIn.getObject() instanceof Spaceship) {
            if (!eventIn.getObject().getCapability(CLibCapabilities.SPACE_FLIGHT_CAPABILITY).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "spaceship_flight"), new SpaceVehicleCapabilityProvider());
            }
        }
//        if (eventIn.getObject() instanceof Player) {
//            if (!eventIn.getObject().getCapability(TaxiCapability.TaxiProvider.TAXI).isPresent()) {
//                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "taxi"), new TaxiCapability.TaxiProvider());
//            }
//        }
//
//        if (eventIn.getObject() instanceof Villager) {
//            if (!eventIn.getObject().getCapability(VILLAGER_TRAVEL_CAPABILITY).isPresent()) {
//                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "villager_travel"), new VillagerTravelCapability.VillagerTravelCapabilityProvider());
//            }
//        }
    }
}