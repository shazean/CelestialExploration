package com.shim.celestialexploration.entity.mob.piglins;

import com.shim.celestialexploration.registry.CelestialEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class AstralPiglin extends Piglin {
    public AstralPiglin(EntityType<? extends AbstractPiglin> p_34683_, Level p_34684_) {
        super(p_34683_, p_34684_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, (double)0.35F).add(Attributes.ATTACK_DAMAGE, 5.0D).build();
    }

    @Override
    protected void finishConversion(ServerLevel p_34663_) {
        ZombifiedPiglin zombifiedpiglin = this.convertTo(CelestialEntities.VOIDED_PIGLIN.get(), true);
        if (zombifiedpiglin != null) {
            zombifiedpiglin.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, zombifiedpiglin);
        }
    }

    public static boolean checkAstralPiglinSpawnRules(EntityType<AstralPiglin> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (random.nextDouble() > 0.2) return false;
        return level.getDifficulty() != Difficulty.PEACEFUL;
    }


}
