package com.shim.celestialexploration.entity;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.EntityRegistry;
import com.shim.celestialexploration.registry.StructureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

public class CelestialCatSpawner implements CustomSpawner {
    private static final int TICK_DELAY = 1200;
    private static int nextTick;

    @Override
    public int tick(ServerLevel level, boolean p_35331_, boolean p_35332_) {
        if (p_35332_ && level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
            --nextTick;
            if (nextTick > 0) {
                return 0;
            } else {
                nextTick = TICK_DELAY;
                Player player = level.getRandomPlayer();
                if (player == null) {
                    return 0;
                } else {
                    Random random = level.random;
                    int i = (8 + random.nextInt(24)) * (random.nextBoolean() ? -1 : 1);
                    int j = (8 + random.nextInt(24)) * (random.nextBoolean() ? -1 : 1);
                    BlockPos blockpos = player.blockPosition().offset(i, 0, j);
                    int k = 10;
                    if (!level.hasChunksAt(blockpos.getX() - 10, blockpos.getZ() - 10, blockpos.getX() + 10, blockpos.getZ() + 10)) {
                        return 0;
                    } else {
                        if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, level, blockpos, EntityRegistry.CELESTIAL_CAT.get())) {
                            if (level.isCloseToVillage(blockpos, 2)) {
                                return this.spawnInVillage(level, blockpos);
                            }
                        }
                        return 0;
                    }
                }
            }
        } else {
            return 0;
        }
    }

    private int spawnInVillage(ServerLevel level, BlockPos pos) {
        int i = 48;
        if (level.getPoiManager().getCountInRange(PoiType.HOME.getPredicate(), pos, 48, PoiManager.Occupancy.IS_OCCUPIED) > 4L) {
            List<CelestialCat> list = level.getEntitiesOfClass(CelestialCat.class, (new AABB(pos)).inflate(48.0D, 8.0D, 48.0D));
            if (list.size() < 5) {
                return this.spawnCat(pos, level);
            }
        }

        return 0;
    }

    private int spawnCat(BlockPos pos, ServerLevel level) {
        CelestialCat cat = EntityRegistry.CELESTIAL_CAT.get().create(level);
        if (cat == null) {
            return 0;
        } else {
            cat.moveTo(pos, 0.0F, 0.0F);
            if(net.minecraftforge.common.ForgeHooks.canEntitySpawn(cat, level, pos.getX(), pos.getY(), pos.getZ(), null, MobSpawnType.NATURAL) == -1) return 0;
            cat.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.NATURAL, (SpawnGroupData)null, (CompoundTag)null);
            level.addFreshEntityWithPassengers(cat);
            return 1;
        }
    }
}