package com.shim.celestialexploration.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(Explosion.class)
public class ExplosionMixin {

    @Shadow @Final @Nullable private Entity source;
//    @Shadow @Final private Level level;
//    @Shadow @Final private double x;
//    @Shadow @Final private double y;
//    @Shadow @Final private double z;
//    @Shadow @Final private float radius;
//    @Shadow @Final private Explosion.BlockInteraction blockInteraction;


//    @Inject(method = "finalizeExplosion", at = @At(
//            value = "INVOKE",
//            target = "Lnet/minecraft/world/level/Level;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"
//    ))
//    private void injected(boolean p_46076_, CallbackInfo ci) {
//        if (this.source instanceof Gust) {
//            this.level.addParticle(ParticleTypes.PORTAL, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D);
//        }
//    }


//    @ModifyArg(method = "finalizeExplosion",
//            at = @At(value = "INVOKE",
//            target = "Lnet/minecraft/world/level/Level;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"), index = 0)
//    private ParticleOptions injected(ParticleOptions particle) {
//        CelestialExploration.LOGGER.debug("source: " + source);
//        if (this.source instanceof Gust) {
//            return ParticleTypes.PORTAL;
//        } else {
//            return particle;
//        }
//
////        if (!(this.radius < 2.0F) && this.blockInteraction != Explosion.BlockInteraction.NONE) {
////            CelestialExploration.LOGGER.debug("running mixin! raidus < 2, source: " + this.source);
////            if (this.source instanceof Gust) {
////                return ParticleTypes.PORTAL;
////            } else {
////                return ParticleTypes.EXPLOSION_EMITTER;
////            }
////        } else {
////            CelestialExploration.LOGGER.debug("running mixin! raidus >= 2, source: " + this.source);
////            if (this.source instanceof Gust) {
////                return ParticleTypes.PORTAL;
////            } else {
////                return ParticleTypes.EXPLOSION;
////            }
////        }
//    }
}
