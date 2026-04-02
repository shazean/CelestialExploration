package com.shim.celestialexploration.entity.spawner;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.robots.MechaCrow;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.Random;

public class MechaCrowSpawner implements CustomSpawner {
    private static final int TICK_DELAY = 800;
    private static int nextTick;

    @Override
    public int tick(ServerLevel level, boolean p_35331_, boolean p_35332_) {
        if (p_35332_ && level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
            --nextTick;
            if (nextTick <= 0) {
                nextTick = TICK_DELAY;
                Player player = level.getRandomPlayer();
                if (player != null) {

                    Random random = level.random;
                    int variety = 24;
                    int i = (8 + random.nextInt(variety)) * (random.nextBoolean() ? -1 : 1);
                    int j = (8 + random.nextInt(variety)) * (random.nextBoolean() ? -1 : 1);
                    BlockPos pos = player.blockPosition().offset(i, 0, j);
                    pos = new BlockPos(pos.getX(), level.getHeight(Heightmap.Types.WORLD_SURFACE, pos.getX(), pos.getZ()), pos.getZ());
                    int radius = 10;
                    if (level.hasChunksAt(pos.getX() - radius, pos.getZ() - radius, pos.getX() + radius, pos.getZ() + radius)) {

//                        if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, level, pos, CelestialEntities.MECHACROW.get())) {
                            if (level.getBiome(pos).is(CelestialTags.Biomes.CELESTIAL_BODIES)) {

                                StructureFeatureManager featureManager = level.structureFeatureManager();

                                if (isNearColony(pos, featureManager) && isOnValidBlock(level, pos)) {
                                    return this.spawnCrow(pos, level);
                                }
                            }
//                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isNearColony(BlockPos pos, StructureFeatureManager featureManager) {
        //FIXME find out why the colony structure isn't being properly recognized and actually check against it
        return true;

//        ConfiguredStructureFeature<?, ?> structure = featureManager.registryAccess().registryOrThrow(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY).get(CelestialStructureKeys.LUNAR_COLONY);
//        for (ConfiguredStructureFeature<?, ?> s : featureManager.getAllStructuresAt(pos).keySet()) {
//            CelestialExploration.LOGGER.debug("structure: " + s.feature + " at " + pos);
//
//        }
//        CelestialExploration.LOGGER.debug("structures: " + featureManager.getAllStructuresAt(pos));
//        return structure != null && featureManager.getStructureAt(pos, structure).isValid();
    }

    //FIXME temporary method until structure check above has been debugged…
    public static boolean isOnValidBlock(ServerLevel level, BlockPos pos) {
        pos = pos.below();
        if (level.getBlockState(pos).is(CelestialBlocks.MOON_SAND_PATH.get()) || level.getBlockState(pos).is(CelestialBlocks.IO_SAND_PATH.get())) {
            CelestialExploration.LOGGER.debug("standing on sand path");
            return true;
        } else if (level.getBlockState(pos).is(CelestialBlocks.MOON_SAND.get()) || level.getBlockState(pos).is(CelestialBlocks.IO_SAND.get())) {
            return level.getRandom().nextDouble() < 0.20;
        } else return false;
    }

    private int spawnCrow(BlockPos pos, ServerLevel level) {
        MechaCrow crow = CelestialEntities.MECHACROW.get().create(level);
        if (crow == null) {
            return 0;
        } else {
            crow.moveTo(pos, 0.0F, 0.0F);
            if (net.minecraftforge.common.ForgeHooks.canEntitySpawn(crow, level, pos.getX(), pos.getY(), pos.getZ(), null, MobSpawnType.NATURAL) == -1)
                return 0;
            crow.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.NATURAL, (SpawnGroupData) null, (CompoundTag) null);
            level.addFreshEntityWithPassengers(crow);
            return 1;
        }
    }
}