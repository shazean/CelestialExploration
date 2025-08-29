package com.shim.celestialexploration.events;

import com.mojang.datafixers.util.Either;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.ISpaceFlight;
import com.shim.celestialexploration.capabilities.LightTravelCapability;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.CelestialCatSpawner;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.item.armor.ThermalSpacesuitArmorItem;
import com.shim.celestialexploration.packets.CelestialPacketHandler;
import com.shim.celestialexploration.packets.SpaceFlightPacket;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.CelestialUtil;
import com.shim.celestialexploration.util.DimensionUtil;
import com.shim.celestialexploration.util.teleportation.TeleportUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Random;

@Mod.EventBusSubscriber(modid = CelestialExploration.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CelestialForgeEventBus {

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.isDismounting() && event.getEntityBeingMounted() instanceof Spaceship spaceship) {
            if (!spaceship.isRemoved() && !event.getWorldObj().isClientSide) {
                event.setCanceled(spaceship.getTimeOnGround() < Spaceship.maxTimeOnGround);
            }
        }
    }
//
//    @SubscribeEvent
//    public static void onExplosion(ExplosionEvent.Detonate event) {
//        if (event.getExplosion().getSourceMob() instanceof MechaCerberusBoss) {
//            List<Entity> entityList = event.getAffectedEntities();
//            entityList.removeIf(entity -> entity instanceof MechaDog dog && !dog.isTame());
//        }
//    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent.WorldTickEvent event) {
        if (event.world instanceof ServerLevel serverLevel && event.haveTime()) {
            new CelestialCatSpawner().tick(serverLevel, true, true);

            if (serverLevel.isThundering()) {
                Player player = serverLevel.getRandomPlayer();
                if (player != null && serverLevel.getBiome(player.blockPosition()).is(CelestialTags.Biomes.METEOR_SHOWER_BIOMES)) {
//                if (serverLevel.dimension().equals(CelestialDimensions.MERCURY) || (serverLevel.dimension().equals(CelestialDimensions.CALLISTO))) {
                    Random random = new Random();
                    if (random.nextInt(3) == 0) {
                        MeteorProjectile meteor = CelestialEntities.METEOR.get().create(serverLevel);
                        if (meteor != null) {
                            double height = Math.min(player.position().y + random.nextInt(128) - 16, serverLevel.getMaxBuildHeight());
                            meteor.moveTo(player.position().x + random.nextInt(128) - 64, height, player.position().z - random.nextInt(64));
                            serverLevel.addFreshEntity(meteor);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Entity spaceVehicle = null;

        if (player.level.dimension().equals(CelestialDimensions.SPACE)) {
            //Warn players they're approaching min Y levels in space
            if (player.position().y <= player.level.getMinBuildHeight()) {
                player.displayClientMessage(new TranslatableComponent("celestialexploration.spaceship.space_min_height"), true);

            }
        }

        //should player teleport to/from space logic
        if (!player.level.isClientSide()) {
            //check for ISpaceFlight capability. This is checked against both the player and the player's vehicle, if applicable
            ISpaceFlight flightCap = CelestialExploration.getCapability(player, CelestialCapabilities.SPACE_FLIGHT_CAPABILITY);
            if (flightCap != null) spaceVehicle = player;
            else {
                if (player.getVehicle() != null) {
                    flightCap = CelestialExploration.getCapability(player.getVehicle(), CelestialCapabilities.SPACE_FLIGHT_CAPABILITY);
                    if (flightCap != null) spaceVehicle = player.getVehicle();
                }
            }
            //once we've acquired our capability, regardless of if it comes from the player or the vehicle…
            if (spaceVehicle != null) {
                //this is the logic for traveling from a dimension TO space
                //check if space travel is allowed, and we're at the appropriate height
                if (flightCap.canSpaceTravel(spaceVehicle) && flightCap.isTeleportHeight(spaceVehicle) && !spaceVehicle.level.dimension().equals(CelestialDimensions.SPACE)) {
                    //get a list of all of our teleporting entities
                    ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);
                    //display message that we're teleporting to space
                    TeleportUtil.displayTeleportMessage(player, flightCap.getTeleportationCooldown(), CelestialDimensions.SPACE);

                    //if the cooldown is 0, we're good to go
                    if (flightCap.getTeleportationCooldown() == 0) {
                        //determine where in space we're teleporting to
                        BlockPos pos = new BlockPos(spaceVehicle.position().x, spaceVehicle.position().y, spaceVehicle.position().z);
                        Vec3 teleportLocation = CelestialUtil.getDimensionToSpaceCoordinates(spaceVehicle.level.dimension(), new ChunkPos(pos));

                        //teleport and reset capability cooldown
                        TeleportUtil.teleport(spaceVehicle, passengers, CelestialDimensions.SPACE, teleportLocation);
                        flightCap.resetTeleportationCooldown();
                    } else { //decrease cooldown
                        if (event.phase.equals(TickEvent.Phase.END)) {
                            flightCap.decrementTeleportationCooldown();
                        }
                    }
                } else if (flightCap.canSpaceTravel(spaceVehicle) && spaceVehicle.level.dimension().equals(CelestialDimensions.SPACE)) {
                    //this is the logic for traveling from space to a planet
                    //like above, check if space travel is allowed and that we're in space

                    //now we determine what planet (or moon) we should teleport to based off our general location and what block we're looking at
                    //first, find what block we can see
                    BlockHitResult hitResult;
                    //TODO/FIXME update so only controlling player has to be looking at the right block
                    //TODO test if this fix worked?
                    if (spaceVehicle.getControllingPassenger().is(player)) {
                        if (spaceVehicle instanceof Spaceship spaceship && spaceship.getMaxSpeed() >= Spaceship.SPACESHIP_LOW_FUEL_SPEED) {
                            //to account for the spaceship having the option for fast movement speeds in space
                            hitResult = (BlockHitResult) player.pick(35.0D, 0.0F, false);
                        } else {
                            hitResult = (BlockHitResult) player.pick(18.0D, 0.0F, false);
                        }
                    } else {
                        hitResult = null;
                    }
                    if (hitResult != null) {

                        BlockState blockState = spaceVehicle.level.getBlockState(hitResult.getBlockPos());

                        if (!spaceVehicle.level.isClientSide()) {
                            //now check to see what planet/moon based off this block
                            ResourceKey<Level> destination = TeleportUtil.getTeleportLocation(spaceVehicle.position(), blockState);

                            //get our full list of passengers
                            ArrayList<Entity> passengers = flightCap.getAdditionalEntitiesToTeleport(spaceVehicle);

                            //if we're looking at a block that corresponds with a destination…
                            if (destination != null) {
                                //display message
                                TeleportUtil.displayTeleportMessage(player, flightCap.getTeleportationCooldown(), destination);

                                //check for cooldown to be 0
                                if (flightCap.getTeleportationCooldown() == 0) {
                                    //send a packet back to the client to update cooldown
                                    if (player instanceof ServerPlayer serverPlayer) {
                                        CelestialPacketHandler.INSTANCE.sendTo(new SpaceFlightPacket(flightCap.getTeleportationCooldown()), serverPlayer.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
                                    }

                                    //teleport and reset cooldown
                                    TeleportUtil.teleport(spaceVehicle, passengers, destination, spaceVehicle.position());
                                    flightCap.resetTeleportationCooldown();

                                } else {
                                    //update cooldown on the client, and decrease cooldown
                                    if (player instanceof ServerPlayer serverPlayer) {
                                        CelestialPacketHandler.INSTANCE.sendTo(new SpaceFlightPacket(flightCap.getTeleportationCooldown()), serverPlayer.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
                                    }
                                    flightCap.decrementTeleportationCooldown();
                                }
                            } else { //if we haven't found a destination (or looked away before cooldown reached 0), reset cooldown
                                flightCap.resetTeleportationCooldown();
                            }
                        }
                    }
                }
            }
        }

        //at the end of the tick, decrease light speed travel cooldowns, if applicable to the player
        LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);
        if (travelCap != null) {
            if (event.phase.equals(TickEvent.Phase.END)) {
                travelCap.getMercuryCooldown().decrementCooldown();
                travelCap.getVenusCooldown().decrementCooldown();
                travelCap.getOverworldCooldown().decrementCooldown();
                travelCap.getMarsCooldown().decrementCooldown();
                travelCap.getJupiterCooldown().decrementCooldown();
            }
        }

        if (CelestialCommonConfig.STORMS.get()) {
            //if a player is in a dust storm, apply slowness
            //and do damage if they're not wearing any armor at all
            //note: this doesn't care if a player is in a building or underground at all…
            if (player.level.isRaining() && player.level.getBiome(player.blockPosition()).is(CelestialTags.Biomes.DUST_STORM_BIOMES)) {
                ItemStack boots = player.getInventory().getArmor(0);
                ItemStack leggings = player.getInventory().getArmor(1);
                ItemStack breastplate = player.getInventory().getArmor(2);
                ItemStack helmet = player.getInventory().getArmor(3);

                if (helmet.isEmpty() && breastplate.isEmpty() && leggings.isEmpty() && boots.isEmpty()) {
                    player.hurt(CelestialDamageSource.DUST_STORM, 0.5F);
                }

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0, false, false, true));
            }
            if (!player.level.isRaining() && player.level.getBiome(player.blockPosition()).is(CelestialTags.Biomes.DUST_STORM_BIOMES)) {
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTakeDamage(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (event.getSource().isFall()) {
            if (CelestialCommonConfig.USE_GRAVITY_EFFECTS.get() && (entity.hasEffect(CelestialEffects.LOW_GRAVITY.get()) || entity.hasEffect(CelestialEffects.EXTRA_LOW_GRAVITY.get()))) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void clickEvent(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();

        if (event.getSide() == LogicalSide.SERVER && player != null) {
            if (event.getItemStack() != null && event.getItemStack().getItem() == Items.FLINT_AND_STEEL) {
                if (CelestialCommonConfig.PORTALS.get()) {
                    Level level = event.getWorld();

                    if (player.level.getBiome(player.getOnPos()).is(CelestialTags.Biomes.CELESTIAL_BODIES) || player.level.dimension() == Level.OVERWORLD) {
                        for (Direction direction : Direction.Plane.VERTICAL) {
                            BlockPos framePos = event.getPos().relative(direction);

                            for (RegistryObject<? extends AbstractPortalBlock> block : CelestialBlocks.PORTAL_BLOCKS) {
                                if (block.get().trySpawnPortal(level, framePos)) {
                                    level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                                    event.setCanceled(true);
                                    event.setCancellationResult(InteractionResult.CONSUME);
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (event.getItemStack() != null && event.getItemStack().getItem() instanceof ShovelItem) {
                Level level = event.getWorld();
                BlockPos pos = event.getHitVec().getBlockPos();

                BlockState block = level.getBlockState(pos);
                if (block.is(CelestialBlocks.MOON_SAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MOON_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.MARS_SAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MARS_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.VENUS_SAND.get())) {
                    level.setBlock(pos, CelestialBlocks.VENUS_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.MERCURY_SAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MERCURY_SAND_PATH.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.IO_SAND.get())) {
                    level.setBlock(pos, CelestialBlocks.IO_SAND_PATH.get().defaultBlockState(), 1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        ResourceKey<Level> dimension = event.getWorld().dimension();

        if (event.getEntity() instanceof Player player) {
            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

            if (travelCap != null) {
                travelCap.sync(player);
            }
        }

        if (CelestialCommonConfig.USE_GRAVITY_EFFECTS.get()) {

            if (entity instanceof ServerPlayer player) {
                ItemStack itemStack = player.getItemBySlot(EquipmentSlot.FEET);

                if (itemStack.getItem() instanceof ThermalSpacesuitArmorItem && ((ThermalSpacesuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
                    player.removeEffect(CelestialEffects.LOW_GRAVITY.get());
                } else {
                    if (DimensionUtil.isLowGravityDimension(dimension)) {
                        player.addEffect(new MobEffectInstance(CelestialEffects.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                    } else {
                        player.removeEffect(CelestialEffects.LOW_GRAVITY.get());
                    }
                }

                if (DimensionUtil.isHighGravityDimension(dimension)) {
                    player.addEffect(new MobEffectInstance(CelestialEffects.HIGH_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    player.removeEffect(CelestialEffects.HIGH_GRAVITY.get());
                }
            } else if (entity instanceof LivingEntity livingEntity) {
                if (DimensionUtil.isLowGravityDimension(dimension) && !livingEntity.getType().is(CelestialTags.Entities.LOW_GRAVITY_EXEMPT)) {
                    livingEntity.addEffect(new MobEffectInstance(CelestialEffects.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    livingEntity.removeEffect(CelestialEffects.LOW_GRAVITY.get());
                }

                if (DimensionUtil.isHighGravityDimension(dimension) && !livingEntity.getType().is(CelestialTags.Entities.HIGH_GRAVITY_EXEMPT)) {
                    livingEntity.addEffect(new MobEffectInstance(CelestialEffects.HIGH_GRAVITY.get(), 120000, 0, false, false, true));
                } else {
                    livingEntity.removeEffect(CelestialEffects.HIGH_GRAVITY.get());
                }
            }
        }

        if (CelestialCommonConfig.STORMS.get()) {
            if (event.getWorld().isRaining() && event.getWorld().getBiome(entity.blockPosition()).is(CelestialTags.Biomes.DUST_STORM_BIOMES)) {
                if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 7000, 0, false, false, true));
                }
            }
            if (!event.getWorld().isRaining() && event.getWorld().getBiome(entity.blockPosition()).is(CelestialTags.Biomes.DUST_STORM_BIOMES)) {
                if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                    livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!CelestialCommonConfig.USE_GRAVITY_EFFECTS.get()) return;

        Entity entity = event.getEntity();
        EquipmentSlot slot = event.getSlot();

        if (entity instanceof ServerPlayer player) {
            ItemStack itemStack = event.getTo();

            if (!(slot == EquipmentSlot.FEET)) return;

            if (itemStack.getItem() instanceof ThermalSpacesuitArmorItem && ((ThermalSpacesuitArmorItem) itemStack.getItem()).isGravityBoots(itemStack)) {
                player.removeEffect(CelestialEffects.LOW_GRAVITY.get());
                player.removeEffect(CelestialEffects.EXTRA_LOW_GRAVITY.get());

            } else {
                ResourceKey<Level> dimension = player.level.dimension();
                if (DimensionUtil.isLowGravityDimension(dimension)) {
                    player.addEffect(new MobEffectInstance(CelestialEffects.LOW_GRAVITY.get(), 120000, 0, false, false, true));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerChangeDimensions(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getPlayer();
        LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY);

        if (travelCap != null) {

            if (event.getTo().equals(CelestialDimensions.SPACE)) {
                travelCap.setBeenToSpace();
            } else if (event.getTo().equals(CelestialDimensions.MARS)) {
                travelCap.setBeenToMars();
            } else if (event.getTo().equals(CelestialDimensions.VENUS)) {
                travelCap.setBeenToVenus();
            } else if (event.getTo().equals(CelestialDimensions.MERCURY)) {
                travelCap.setBeenToMercury();
            } else if (event.getTo().equals(CelestialDimensions.JUPITER)) {
                travelCap.setBeenToJupiter();
            }

            travelCap.sync(player);
        }
    }

//    @SubscribeEvent
//    public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
//        if (event.getEntity() instanceof Player player) {
//            LightTravelCapability.ILightTravel travelCap = CelestialExploration.getCapability(player, CapabilityRegistry.LIGHT_TRAVEL_CAPABILITY);
//
//            if (travelCap != null) {
//                if (event.getDimension().equals(DimensionRegistry.SPACE)) {
//                    CelestialExploration.LOGGER.debug("beenToSpace");
//                    travelCap.setBeenToSpace();
//                } else if (event.getDimension().equals(DimensionRegistry.MARS)) {
//                    travelCap.setBeenToMars();
//                } else if (event.getDimension().equals(DimensionRegistry.VENUS)) {
//                    travelCap.setBeenToVenus();
//                } else if (event.getDimension().equals(DimensionRegistry.MERCURY)) {
//                    travelCap.setBeenToMercury();
//                } else if (event.getDimension().equals(DimensionRegistry.JUPITER)) {
//                    travelCap.setBeenToJupiter();
//                }
//            }
//        }
//    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal() != null && event.getPlayer() != null) {
                event.getOriginal().reviveCaps();

                LightTravelCapability.ILightTravel oldTravelData = event.getOriginal().getCapability(CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY).orElse(null);
                LightTravelCapability.ILightTravel newTravelData = event.getPlayer().getCapability(CelestialCapabilities.LIGHT_TRAVEL_CAPABILITY).orElse(null);
                if (oldTravelData != null && newTravelData != null) newTravelData.setData(oldTravelData.getData());

                TaxiCapability.ITaxi oldTaxiData = event.getOriginal().getCapability(CelestialCapabilities.TAXI_CAPABILITY).orElse(null);
                TaxiCapability.ITaxi newTaxiData = event.getPlayer().getCapability(CelestialCapabilities.TAXI_CAPABILITY).orElse(null);
                if (oldTaxiData != null && newTaxiData != null) newTaxiData.setData(oldTaxiData.getData());

                event.getOriginal().invalidateCaps();
            }
        }
    }

    @SubscribeEvent
    public static void onToolTipRender(RenderTooltipEvent.GatherComponents event) {
        if (event.getItemStack().is(CelestialBlocks.AIRLOCK_PANEL_DOOR.get().asItem()) || event.getItemStack().is(CelestialBlocks.AIRLOCK_PANEL_DOOR_WINDOW.get().asItem())) {
            event.getTooltipElements().add(Either.left(new TranslatableComponent("item.celestialexploration.door.airlock_panel_door")));
        }
        if (event.getItemStack().is(CelestialBlocks.HANGAR_DOOR.get().asItem()) || event.getItemStack().is(CelestialBlocks.HANGAR_DOOR_WINDOW.get().asItem())) {
            event.getTooltipElements().add(Either.left(new TranslatableComponent("item.celestialexploration.door.hangar_door")));
        }
    }
}