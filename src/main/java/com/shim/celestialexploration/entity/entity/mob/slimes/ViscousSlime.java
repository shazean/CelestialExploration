package com.shim.celestialexploration.entity.entity.mob.slimes;

import com.shim.celestialexploration.registry.EntityRegistry;
import net.minecraft.core.BlockPos;
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

public class ViscousSlime extends AbstractQuicksilverSlime {

    public ViscousSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, CONVERSION_TIME, 1));

    }

    @Override
    protected void decreaseSquish() {
        this.targetSquish *= 0.75F; //0.6F;
    }

    public static boolean checkViscousSlimeSpawnRules(EntityType<ViscousSlime> slime, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (level.getDifficulty() == Difficulty.PEACEFUL || pos.getY() > 64) {
            return false;
        }
        return isDarkEnoughToSpawn((ServerLevelAccessor) level, pos, random) && checkMobSpawnRules(slime, level, spawnType, pos, random);
    }

    @Override
    public void tick() {
        this.squish += (this.targetSquish - this.squish) * 0.5F;
        this.oSquish = this.squish;
        super.tick();
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2F + 0.1F * (float)this.getSize() - 0.15F);
        if (this.onGround && !this.wasOnGround) {
            int i = this.getSize();

            for(int j = 0; j < i * 8; ++j) {
                float f = this.random.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
                float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
                this.level.addParticle(this.getParticleType(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.targetSquish = -0.5F;
        } else if (!this.onGround && this.wasOnGround) {
            this.targetSquish = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.decreaseSquish();

        if (this.level.isDay()) {
            if (!this.level.isClientSide()) {
                this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, CONVERSION_TIME, 0, false, false));
                this.setSecondsOnFire(CONVERSION_TIME / 20);

                if (currentConversionTime != 0) {
                    currentConversionTime--;
                } else {
                    currentConversionTime = CONVERSION_TIME;
                    convertSlime();
                }
            }
        }
    }

    @Override
    protected void convertSlime() {
        QuicksilverSlime quicksilverSlime = this.convertTo(EntityRegistry.QUICKSILVER_SLIME.get(), true);
        if (quicksilverSlime != null) {
            quicksilverSlime.setSize(this.getSize());
            quicksilverSlime.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 0));
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, quicksilverSlime);
        }
    }
}