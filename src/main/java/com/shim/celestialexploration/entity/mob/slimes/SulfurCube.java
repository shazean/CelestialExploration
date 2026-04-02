package com.shim.celestialexploration.entity.mob.slimes;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SulfurCube extends MagmaCube {
    public SulfurCube(EntityType<? extends MagmaCube> p_32968_, Level p_32969_) {
        super(p_32968_, p_32969_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.2F).build();
    }

    public static boolean checkSulfurCubeSpawnRules(EntityType<SulfurCube> entity, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (random.nextDouble() > 0.2) return false;
        return level.getDifficulty() != Difficulty.PEACEFUL;
    }

    public boolean isInSulfur() {
        return !this.firstTick && this.fluidHeight.getDouble(CelestialTags.Fluids.SULFUR) > 0.0D;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isInSulfur()) {
            jumpInLiquid(CelestialTags.Fluids.SULFUR);
        }
    }

    @Override
    protected void jumpInLiquid(TagKey<Fluid> fluidTagKey) {

        CelestialExploration.LOGGER.debug("SulfurCube in: " +  fluidTagKey.toString());

        if (fluidTagKey == CelestialTags.Fluids.SULFUR) {
            CelestialExploration.LOGGER.debug("SulfurCube in Sulfur");
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, 0.22F + (float)this.getSize() * 0.05F, vec3.z);
            this.hasImpulse = true;
        } else {
            super.jumpInLiquid(fluidTagKey);
        }
    }
}