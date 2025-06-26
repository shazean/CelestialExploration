package com.shim.celestialexploration.entity.mob.slimes;

import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

import static net.minecraft.world.entity.monster.Monster.isDarkEnoughToSpawn;

public class QuicksilverSlime extends AbstractQuicksilverSlime {

    public QuicksilverSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
//        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, CONVERSION_TIME, 1));

    }

    @Override
    public void tick() {
        this.squish += (this.targetSquish - this.squish) * 0.5F;
        this.oSquish = this.squish;
        super.tick();
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2F + 0.1F * (float)this.getSize() + 0.35F);
        if (this.onGround && !this.wasOnGround) {
            int i = this.getSize();

            if (spawnCustomParticles()) i = 0; // don't spawn particles if it's handled by the implementation itself
            for(int j = 0; j < i * 8; ++j) {
                float f = this.random.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
                float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
                this.level.addParticle(this.getParticleType(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.targetSquish = -0.8F; //-0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.targetSquish = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.decreaseSquish();


        if (this.level.isNight()) {
            if (!this.level.isClientSide()) {
                this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, CONVERSION_TIME, 2));

                if (currentConversionTime != 0) {
                    currentConversionTime--;
                } else {
                    currentConversionTime = CONVERSION_TIME;
                    convertSlime();
                }
            }
        }
    }

    protected void convertSlime() {
        ViscousSlime viscousSlime = this.convertTo(CelestialEntities.VISCOUS_SLIME.get(), true);
        if (viscousSlime != null) {
            viscousSlime.setSize(this.getSize());
            viscousSlime.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, viscousSlime);
        }
    }

    @Override
    protected void decreaseSquish() {
        this.targetSquish *= 0.93F; //0.6F;
    }

    @Override
    protected ParticleOptions getParticleType() {
        return CelestialParticles.QUICKSILVER_SLIME_PARTICLES.get();
    }

    public static boolean checkQuicksilverSlimeSpawnRules(EntityType<QuicksilverSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL || pos.getY() > 64) {
            return false;
        }
        return !isDarkEnoughToSpawn((ServerLevelAccessor) level, pos, random) && checkMobSpawnRules(slime, level, spawnType, pos, random);
    }
}
