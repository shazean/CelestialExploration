package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import com.shim.celestialexploration.capabilities.SpaceFlightCapabilityProvider;
import com.shim.celestialexploration.entity.Spaceship;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class CapabilityRegistry {

    public static final Capability<LoxTankCapability.ILoxTank> LOX_TANK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });
    public static final Capability<ISpaceFlight> SPACE_FLIGHT_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static void registerCapabilities(RegisterCapabilitiesEvent eventIn) {
        eventIn.register(LoxTankCapability.ILoxTank.class);
        eventIn.register(ISpaceFlight.class);

    }

    public static void attachItemCapabilities(AttachCapabilitiesEvent<ItemStack> eventIn) {
        if (eventIn.getObject().getItem() == ItemRegistry.LOX_TANK.get()) {
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_tank_item"), new LoxTankCapability.LoxTankCapabilityProvider());
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
    }
}
