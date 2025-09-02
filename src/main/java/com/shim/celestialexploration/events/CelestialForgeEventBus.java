package com.shim.celestialexploration.events;

import com.mojang.datafixers.util.Either;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.TaxiCapability;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.CelestialCatSpawner;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.registry.*;
import com.shim.celestiallib.api.blocks.AbstractPortalBlock;
import com.shim.celestiallib.effects.CelestialLibEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

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
    public static void onEntityTakeDamage(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (event.getSource().isFall()) {
            if (CelestialCommonConfig.USE_GRAVITY_EFFECTS.get() && (entity.hasEffect(CelestialLibEffects.LOW_GRAVITY.get()) || entity.hasEffect(CelestialLibEffects.EXTRA_LOW_GRAVITY.get()))) {
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
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal() != null && event.getPlayer() != null) {
                event.getOriginal().reviveCaps();

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