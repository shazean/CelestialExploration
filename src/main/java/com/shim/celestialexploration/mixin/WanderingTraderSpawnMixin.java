package com.shim.celestialexploration.mixin;

import com.shim.celestialexploration.registry.CelestialTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;

@Mixin(WanderingTraderSpawner.class)
public class WanderingTraderSpawnMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/npc/WanderingTraderSpawner;findSpawnPositionNear(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;I)Lnet/minecraft/core/BlockPos;"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void injected(ServerLevel level, CallbackInfoReturnable<Boolean> cir, Player player, BlockPos blockpos, int i, PoiManager poimanager, Optional optional, BlockPos blockpos1) {

        if (blockpos1 != null) {
            if (level.getBiome(blockpos1).is(CelestialTags.Biomes.CELESTIAL_BODIES))
                cir.setReturnValue(false);
        }
    }
}
