package com.shim.celestialexploration.item;

import com.shim.celestialexploration.registry.CelestialEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class SuspiciousJelloItem extends Item {
    public SuspiciousJelloItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!level.isClientSide) entity.addEffect(getRandomEffect(new Random()));

        if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return super.finishUsingItem(itemStack, level, entity);
    }

    protected static MobEffectInstance getRandomEffect(Random random) {

        return switch (random.nextInt(6)) {
            case 0, 1 -> new MobEffectInstance(MobEffects.JUMP, 400, 1);
            case 2 -> new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 1);
            case 3 -> new MobEffectInstance(CelestialEffects.EXTRA_LOW_GRAVITY.get(), 400, 0);
            case 4, 5 -> new MobEffectInstance(CelestialEffects.LOW_GRAVITY.get(), 400, 0);
            default -> null;
        };
    }
}
