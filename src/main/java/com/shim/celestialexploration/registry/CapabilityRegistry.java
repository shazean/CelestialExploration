package com.shim.celestialexploration.registry;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.LoxTankCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class CapabilityRegistry {

    public static final Capability<LoxTankCapability.ILoxTank> LOX_TANK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent eventIn) {
        eventIn.register(LoxTankCapability.ILoxTank.class);
    }

    public static void attachItemCapabilities(AttachCapabilitiesEvent<ItemStack> eventIn) {
        if(eventIn.getObject().getItem() == ItemRegistry.LOX_TANK.get()) {
//            CelestialExploration.LOGGER.debug("Lox tank item capability!");
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_tank_item"), new LoxTankCapability.LoxTankCapabilityProvider());
        }
    }

    public static void attachBlockCapabilities(AttachCapabilitiesEvent<BlockEntity> eventIn) {
        if(eventIn.getObject().getBlockState() == BlockRegistry.LOX_TANK.get().defaultBlockState()) {
//            CelestialExploration.LOGGER.debug("Lox tank block capability!");
            eventIn.addCapability(new ResourceLocation(CelestialExploration.MODID, "lox_tank_block"), new LoxTankCapability.LoxTankCapabilityProvider());
        }
    }
}
