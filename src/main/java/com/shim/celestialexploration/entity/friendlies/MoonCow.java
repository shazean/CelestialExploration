package com.shim.celestialexploration.entity.friendlies;

import com.shim.celestialexploration.CelestialExploration;
import com.shim.celestialexploration.entity.mob.slimes.AbstractCelestialSlime;
import com.shim.celestialexploration.registry.CelestialBlocks;
import com.shim.celestialexploration.registry.CelestialEntities;
import com.shim.celestialexploration.registry.CelestialItems;
import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.Random;

public class MoonCow extends Cow {
    public MoonCow(EntityType<? extends Cow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, CelestialItems.MOON_MILK_BUCKET.get().getDefaultInstance());
            player.setItemInHand(hand, itemstack1);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public Cow getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return CelestialEntities.MOON_COW.get().create(level);
    }

    public static boolean checkSpawnRules(EntityType<MoonCow> entity, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, Random random) {
        if (!level.getBlockState(pos.below()).is(CelestialTags.Blocks.MOON_COW_SPAWNABLE))
            return false;
        if (random.nextDouble() > 0.2) return false;
        return checkMobSpawnRules(entity, level, spawnType, pos, random);
    }
}
