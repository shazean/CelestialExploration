package com.shim.celestialexploration.events;

import com.mojang.datafixers.util.Either;
import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.capabilities.OxygenHandler;
import com.shim.celestialexploration.config.CelestialCommonConfig;
import com.shim.celestialexploration.entity.monster.Vulkan;
import com.shim.celestialexploration.entity.spawner.CelestialCatSpawner;
import com.shim.celestialexploration.entity.projectile.MeteorProjectile;
import com.shim.celestialexploration.entity.spawner.CelestialTraderSpawner;
import com.shim.celestialexploration.entity.spawner.MechaCrowSpawner;
import com.shim.celestialexploration.entity.vehicle.Spaceship;
import com.shim.celestialexploration.registry.*;
import com.shim.celestialexploration.util.OxygenUtil;
import com.shim.celestiallib.api.blocks.AbstractPortalBlock;
import com.shim.celestiallib.api.effects.CLibEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
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

                if (event.getEntityMounting().isShiftKeyDown()) {
                    event.setCanceled(spaceship.getTimeOnGround() < Spaceship.maxTimeOnGround);
                }
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
            new MechaCrowSpawner().tick(serverLevel, true, true);
            new CelestialTraderSpawner().tick(serverLevel, true, true);

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


            for (Player player : serverLevel.players()) {
                OxygenHandler oxygenCap = player.getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
                if (oxygenCap != null)
                    oxygenCap.tick(player);

            }
        }
    }

    @SubscribeEvent
    public static void onEntityTakeDamage(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (event.getSource().isFall()) {
            if (CelestialCommonConfig.USE_GRAVITY_EFFECTS.get() && (entity.hasEffect(CLibEffects.LOW_GRAVITY.get()) || entity.hasEffect(CLibEffects.EXTRA_LOW_GRAVITY.get()))) {
                if (event.getAmount() <= 3.0F) {
                    event.setCanceled(true);
                } else {
                    event.setAmount(event.getAmount() - 3.0F);
                }
            }
            if (entity.isPassenger() && entity.getVehicle() instanceof Spaceship) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void clickEvent(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();

        if (event.getSide() == LogicalSide.SERVER && player != null && event.getItemStack() != null) {
            Level level = event.getWorld();
            BlockPos pos = event.getHitVec().getBlockPos();
            BlockState block = level.getBlockState(pos);

            if (event.getItemStack().getItem() == Items.FLINT_AND_STEEL) {
                if (CelestialCommonConfig.PORTALS.get()) {
                    if (player.level.getBiome(player.getOnPos()).is(CelestialTags.Biomes.CELESTIAL_BODIES) || player.level.dimension() == Level.OVERWORLD) {
                        for (Direction direction : Direction.Plane.VERTICAL) {
                            BlockPos framePos = event.getPos().relative(direction);

                            for (RegistryObject<? extends AbstractPortalBlock> portalBlock : CelestialBlocks.PORTAL_BLOCKS) {
                                if (portalBlock.get().trySpawnPortal(level, framePos)) {
                                    level.playSound(player, framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                                    event.setCanceled(true);
                                    event.setCancellationResult(InteractionResult.CONSUME);
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (event.getItemStack().getItem() instanceof ShovelItem) {
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
            } else if (event.getItemStack().getItem() instanceof HoeItem) {
                if (block.is(CelestialBlocks.MOON_FARMLAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MOON_FARMLAND_TILLED.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.MARS_FARMLAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MARS_FARMLAND_TILLED.get().defaultBlockState(), 1);
                } else if (block.is(CelestialBlocks.MERCURY_FARMLAND.get())) {
                    level.setBlock(pos, CelestialBlocks.MERCURY_FARMLAND_TILLED.get().defaultBlockState(), 1);
                }
            } else if (event.getItemStack().getItem() == CelestialItems.FLARE_ROD.get()) {
                if (block.is(CelestialBlocks.SMOKING_MAGMA.get())) {

                    Vulkan vulkan = CelestialEntities.VULKAN.get().create(level);
                    if (vulkan != null) {
                        if (level instanceof ServerLevel serverLevel) {
                            vulkan.moveTo(pos, 0.0F, 0.0F);
                            vulkan.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pos), MobSpawnType.NATURAL, (SpawnGroupData) null, (CompoundTag) null);
                            serverLevel.addFreshEntityWithPassengers(vulkan);

                            if (!event.getPlayer().isCreative())
                                event.getItemStack().shrink(1);

                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();

        if (CelestialCommonConfig.STORMS.get()) {
            if (event.getWorld().getBiome(entity.blockPosition()).is(CelestialTags.Biomes.DUST_STORM_BIOMES)) {
                if (event.getWorld().isRaining()) {
                    if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 7000, 0, false, false, true));
                    }
                } else {
                    if (entity instanceof LivingEntity livingEntity && !(entity instanceof Player)) {
                        livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                    }
                }
            }
        }

        if (entity instanceof Player player) {
            OxygenHandler oxygenCap = entity.getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
            if (oxygenCap != null) {
                oxygenCap.checkMaxOxygen(player);
//                oxygenCap.setOxygenToFull();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        OxygenHandler oxygenCap = event.getPlayer().getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
        if (oxygenCap != null) {
            oxygenCap.useOxygen(true, event.getPlayer());
        }
    }

    @SubscribeEvent
    public static void onPlayerEquipArmor(LivingEquipmentChangeEvent event) {
        if (event.getFrom() != event.getTo()) {
            if (event.getEntity() instanceof Player player) {
                OxygenHandler oxygenCap = player.getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
                if (oxygenCap != null) {
                    oxygenCap.checkMaxOxygen(player);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            if (event.getOriginal() != null && event.getPlayer() != null) {
                event.getOriginal().reviveCaps();

                OxygenHandler oldOxygenData = event.getOriginal().getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
                OxygenHandler newOxygenData = event.getPlayer().getCapability(CelestialCapabilities.OXYGEN_CAPABILITY).orElse(null);
                if (oldOxygenData != null && newOxygenData != null) newOxygenData.setData(oldOxygenData.getData());

                newOxygenData.checkMaxOxygen(event.getPlayer());
                newOxygenData.setOxygenToFull();

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

    @SubscribeEvent
    public static void onServerStart(ServerAboutToStartEvent event) {
        CelestialVillagerTrades.CELESTIAL_TRADER_TRADES.put(1, new VillagerTrades.ItemListing[]{
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.LUNAR_GOO.get(), 4, 1, 5, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.GLOWSTONE, 2, 1, 5, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.SUGAR_CANE, 1, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.PUMPKIN, 1, 1, 4, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(Items.QUARTZ, 3, 1, 12, 1),

                //keep these or no?
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.WHEAT_SEEDS, 1, 1, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.BEETROOT_SEEDS, 1, 1, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.PUMPKIN_SEEDS, 1, 1, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.MELON_SEEDS, 1, 1, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.ACACIA_SAPLING, 5, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.BIRCH_SAPLING, 5, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.DARK_OAK_SAPLING, 5, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.JUNGLE_SAPLING, 5, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.OAK_SAPLING, 5, 1, 8, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.SPRUCE_SAPLING, 5, 1, 8, 1),

                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.LUNAR_CHEESE.get(), 4, 1, 5, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.MARSHMALLOW_GOO.get(), 4, 1, 5, 1),

                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.CALLISTO_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.WHITE_MOON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.MOON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.CALLISTO_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.IO_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.EUROPA_DUST.get(), 1, 3, 12, 1),

                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.TITANIA_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.OBERON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.DIONE_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.TITAN_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.GREY_MOON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.TRITON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.ENCELADUS_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.RHEA_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.IAPETUS_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.LIGHT_GREY_MOON_DUST.get(), 1, 3, 12, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.GREY_MOON_DUST.get(), 1, 3, 12, 1),


//                new CelestialVillagerTrades.ItemsForEmeralds(Items.RED_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.WHITE_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.BLUE_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.PINK_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.BLACK_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.GREEN_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.LIGHT_GRAY_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.MAGENTA_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.YELLOW_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.GRAY_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.PURPLE_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.LIGHT_BLUE_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.LIME_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.ORANGE_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.BROWN_DYE, 1, 3, 12, 1),
//                new CelestialVillagerTrades.ItemsForEmeralds(Items.CYAN_DYE, 1, 3, 12, 1),

                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.MOON_SAND.get().asItem(), 1, 8, 8, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.MARS_SAND.get().asItem(), 1, 8, 8, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.MERCURY_SAND.get().asItem(), 1, 8, 8, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.VENUS_SAND.get().asItem(), 1, 8, 8, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.IO_SAND.get().asItem(), 1, 8, 8, 1)
        });

        CelestialVillagerTrades.CELESTIAL_TRADER_TRADES.put(2, new VillagerTrades.ItemListing[]{
                new CelestialVillagerTrades.ItemsForEmeralds(Items.PACKED_ICE, 3, 1, 6, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(Items.BLUE_ICE, 6, 1, 6, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialBlocks.DRY_ICE.get().asItem(), 3, 1, 6, 1),
                new CelestialVillagerTrades.ItemsForEmeralds(CelestialItems.MECHACERBERUS_CORE.get().asItem(), 20, 1, 1, 3),

                new CelestialVillagerTrades.ItemsForEmeralds(Items.GUNPOWDER, 1, 1, 8, 1),
        });


    }
}