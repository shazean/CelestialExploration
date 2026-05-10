//package com.shim.celestialexploration.entity.spawner;
//
//import com.shim.celestialexploration.entity.creatures.AlienTraderLlama;
//import com.shim.celestialexploration.entity.creatures.SpaceTraderLlama;
//import com.shim.celestialexploration.registry.CelestialEntities;
//import net.minecraft.core.BlockPos;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.util.Mth;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.MobSpawnType;
//import net.minecraft.world.entity.SpawnPlacements;
//import net.minecraft.world.entity.ai.village.poi.PoiManager;
//import net.minecraft.world.entity.ai.village.poi.PoiType;
//import net.minecraft.world.entity.animal.horse.TraderLlama;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.*;
//import net.minecraft.world.level.biome.Biomes;
//import net.minecraft.world.level.levelgen.Heightmap;
//import net.minecraft.world.level.storage.ServerLevelData;
//
//import javax.annotation.Nullable;
//import java.util.Optional;
//import java.util.Random;
//
//public class CelestialTraderSpawner implements CustomSpawner {
//    private static final int DEFAULT_TICK_DELAY = 1200;
//    public static final int DEFAULT_SPAWN_DELAY = 24000;
//    private static final int MIN_SPAWN_CHANCE = 25;
//    private static final int MAX_SPAWN_CHANCE = 75;
//    private static final int SPAWN_CHANCE_INCREASE = 25;
//    private static final int SPAWN_ONE_IN_X_CHANCE = 10;
//    private static final int NUMBER_OF_SPAWN_ATTEMPTS = 10;
//    private final Random random = new Random();
////    private final ServerLevelData serverLevelData;
//    private int tickDelay;
//    private int spawnDelay;
//    private int spawnChance;
//
//    public CelestialTraderSpawner() {
////        this.serverLevelData = levelData;
//        this.tickDelay = DEFAULT_TICK_DELAY;
//        this.spawnChance = 50;
//        this.spawnDelay = DEFAULT_SPAWN_DELAY;
////        this.spawnDelay = levelData.getWanderingTraderSpawnDelay();
////        this.spawnChance = levelData.getWanderingTraderSpawnChance();
////        if (this.spawnDelay == 0 && this.spawnChance == 0) {
////            this.spawnDelay = DEFAULT_SPAWN_DELAY;
////            levelData.setWanderingTraderSpawnDelay(this.spawnDelay);
////            this.spawnChance = MIN_SPAWN_CHANCE;
////            levelData.setWanderingTraderSpawnChance(this.spawnChance);
////        }
//    }
//
//    public int tick(ServerLevel level, boolean p_35923_, boolean p_35924_) {
//        if (!level.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING)) {
//            return 0;
//        } else if (--this.tickDelay > 0) {
//            return 0;
//        } else {
//            this.tickDelay = DEFAULT_TICK_DELAY;
//            this.spawnDelay -= DEFAULT_TICK_DELAY;
////            this.serverLevelData.setWanderingTraderSpawnDelay(this.spawnDelay);
//            if (this.spawnDelay > 0) {
//                return 0;
//            } else {
//                this.spawnDelay = DEFAULT_SPAWN_DELAY;
//                if (!level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
//                    return 0;
//                } else {
//                    int i = this.spawnChance;
//                    this.spawnChance = Mth.clamp(this.spawnChance + SPAWN_CHANCE_INCREASE, MIN_SPAWN_CHANCE, MAX_SPAWN_CHANCE);
////                    this.serverLevelData.setWanderingTraderSpawnChance(this.spawnChance);
//                    if (this.random.nextInt(100) > i) {
//                        return 0;
//                    } else if (this.spawn(level)) {
//                        this.spawnChance = MIN_SPAWN_CHANCE;
//                        return 1;
//                    } else {
//                        return 0;
//                    }
//                }
//            }
//        }
//    }
//
//    private boolean spawn(ServerLevel level) {
//        Player player = level.getRandomPlayer();
//        if (player == null) {
//            return true;
//        } else if (this.random.nextInt(10) != 0) {
//            return false;
//        } else {
//            BlockPos blockpos = player.blockPosition();
//            int i = 48;
//            PoiManager poimanager = level.getPoiManager();
//            Optional<BlockPos> optional = poimanager.find(PoiType.MEETING.getPredicate(), (p_35933_) -> {
//                return true;
//            }, blockpos, 48, PoiManager.Occupancy.ANY);
//            BlockPos blockpos1 = optional.orElse(blockpos);
//            BlockPos blockpos2 = this.findSpawnPositionNear(level, blockpos1, 48);
//            if (blockpos2 != null && this.hasEnoughSpace(level, blockpos2)) {
//                if (level.getBiome(blockpos2).is(Biomes.THE_VOID)) {
//                    return false;
//                }
//
//                CelestialTrader trader = CelestialEntities.CELESTIAL_TRADER.get().spawn(level, null, null, null, blockpos2, MobSpawnType.EVENT, false, false);
//                if (trader != null) {
//                    for(int j = 0; j < 2; ++j) {
//                        this.tryToSpawnLlamaFor(level, trader, 4);
//                    }
//
////                    this.serverLevelData.setWanderingTraderId(trader.getUUID());
//                    trader.setDespawnDelay(48000);
//                    trader.setWanderTarget(blockpos1);
//                    trader.restrictTo(blockpos1, 16);
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
//
//    private void tryToSpawnLlamaFor(ServerLevel level, CelestialTrader trader, int p_35920_) {
//        BlockPos blockpos = this.findSpawnPositionNear(level, trader.blockPosition(), p_35920_);
//        if (blockpos != null) {
//
//            if (level.random.nextInt(5) <= 3) {
//                AlienTraderLlama traderllama = CelestialEntities.ALIEN_LLAMA.get().spawn(level, (CompoundTag)null, (Component)null, (Player)null, blockpos, MobSpawnType.EVENT, false, false);
//                if (traderllama != null) {
//                    traderllama.setLeashedTo(trader, true);
//                }
//            } else {
//                SpaceTraderLlama traderllama = CelestialEntities.SPACE_LLAMA.get().spawn(level, (CompoundTag) null, (Component) null, (Player) null, blockpos, MobSpawnType.EVENT, false, false);
//                if (traderllama != null) {
//                    traderllama.setLeashedTo(trader, true);
//                }
//            }
//        }
//    }
//
//    @Nullable
//    private BlockPos findSpawnPositionNear(LevelReader level, BlockPos pos, int p_35931_) {
//        BlockPos blockpos = null;
//
//        for(int i = 0; i < 10; ++i) {
//            int j = pos.getX() + this.random.nextInt(p_35931_ * 2) - p_35931_;
//            int k = pos.getZ() + this.random.nextInt(p_35931_ * 2) - p_35931_;
//            int l = level.getHeight(Heightmap.Types.WORLD_SURFACE, j, k);
//            BlockPos blockpos1 = new BlockPos(j, l, k);
//            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, level, blockpos1, CelestialEntities.CELESTIAL_TRADER.get())) {
//                blockpos = blockpos1;
//                break;
//            }
//        }
//
//        return blockpos;
//    }
//
//    private boolean hasEnoughSpace(BlockGetter getter, BlockPos pos) {
//        for(BlockPos blockpos : BlockPos.betweenClosed(pos, pos.offset(1, 2, 1))) {
//            if (!getter.getBlockState(blockpos).getCollisionShape(getter, blockpos).isEmpty()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}