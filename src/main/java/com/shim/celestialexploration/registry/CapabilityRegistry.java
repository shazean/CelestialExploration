package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.*;
import com.shim.celestialexploration.entity.entity.vehicle.Spaceship;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

public class CapabilityRegistry {

    public static final Capability<LoxTankCapability.ILoxTank> LOX_TANK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<ISpaceFlight> SPACE_FLIGHT_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<TaxiCapability.ITaxi> TAXI_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<TaxiCapability.ITaxi> VILLAGER_TRAVEL_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<LightTravelCapability.ILightTravel> LIGHT_TRAVEL_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent eventIn) {
        eventIn.register(LoxTankCapability.ILoxTank.class);
        eventIn.register(ISpaceFlight.class);
        eventIn.register(TaxiCapability.ITaxi.class);
        eventIn.register(VillagerTravelCapability.ITravel.class);
    }

    public static void attachItemCapabilities(AttachCapabilitiesEvent<ItemStack> eventIn) {
        if (eventIn.getObject().getItem() == ItemRegistry.LOX_TANK.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_tank_item"), new LoxTankCapability.LoxTankCapabilityProvider());
        }
        if (eventIn.getObject().getItem() == ItemRegistry.FLUID_BASIN.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "basin"), new FluidHandlerItemStack(ItemRegistry.FLUID_BASIN.get().getDefaultInstance(), 4000));
        }
    }

    public static void attachBlockCapabilities(AttachCapabilitiesEvent<BlockEntity> eventIn) {
        if (eventIn.getObject().getBlockState() == BlockRegistry.LOX_TANK.get().defaultBlockState()) {
            if (!eventIn.getObject().getCapability(LoxTankCapability.LoxTankCapabilityProvider.LOX_TANK).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_tank_block"), new LoxTankCapability.LoxTankCapabilityProvider());
            }
        }
    }

    public static void attachEntityCapabilities(AttachCapabilitiesEvent<Entity> eventIn) {
        if (eventIn.getObject() instanceof Spaceship) {
            if (!eventIn.getObject().getCapability(SPACE_FLIGHT_CAPABILITY).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "spaceship_flight"), new SpaceFlightCapabilityProvider());
            }
        }
        if (eventIn.getObject() instanceof Player) {
            if (!eventIn.getObject().getCapability(TaxiCapability.TaxiProvider.TAXI).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "taxi"), new TaxiCapability.TaxiProvider());
            }
            if (!eventIn.getObject().getCapability(LightTravelCapability.LightTravelProvider.LIGHT_TRAVEL).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "light_travel"), new LightTravelCapability.LightTravelProvider());
            }
        }

        if (eventIn.getObject() instanceof Villager) {
            if (!eventIn.getObject().getCapability(VILLAGER_TRAVEL_CAPABILITY).isPresent()) {
                eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "villager_travel"), new VillagerTravelCapability.VillagerTravelCapabilityProvider());
            }
        }
    }
}