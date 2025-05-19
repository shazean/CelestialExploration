package com.shim.celestialexploration.entity.entity.projectile;

import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

/**
 * Credit to JayZX535 for this code
 * Thank you, Jay, for figuring this one out
 */
public abstract class AbstractDirectionalProjectile extends Projectile implements GeoEntity, IEntityAdditionalSpawnData {

    protected AnimatableInstanceCache animatableInstance = AzureLibUtil.createInstanceCache(this);

    // Most projectiles just need one animation so we can set that up here
    protected static final RawAnimation ANIMATION_AMBIENT = RawAnimation.begin().thenLoop("ambient");

    public AbstractDirectionalProjectile(EntityType<? extends AbstractDirectionalProjectile> entityTypeIn, Level levelIn) {
        super(entityTypeIn, levelIn);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    public void tick() {
        super.tick();

        this.xOld = this.getX();
        this.yOld = this.getY();
        this.zOld = this.getZ();

        ProjectileUtil.rotateTowardsMovement(this, 1F);
        Vec3 vec3 = this.getDeltaMovement();
        double x = this.getX() + vec3.x;
        double y = this.getY() + vec3.y;
        double z = this.getZ() + vec3.z;

        if (!this.isNoGravity()) {
            Vec3 vec34 = this.getDeltaMovement();
            this.setDeltaMovement(vec34.x, vec34.y - this.gravityAmount(), vec34.z);
        }
        this.setPos(x, y, z);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return this.animatableInstance; }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllersIn) {
        controllersIn.add(new AnimationController<>(this, "projectile_controller", 0, event -> {
            return event.setAndContinue(ANIMATION_AMBIENT);
        }));
    }

    @Override
    public boolean isNoGravity() { return true; }

    public double gravityAmount() { return 0.05D; }

    @Override
    public void writeSpawnData(FriendlyByteBuf bufferIn) {
        bufferIn.writeFloat(this.getXRot());
        bufferIn.writeFloat(this.getYRot());
        bufferIn.writeDouble(this.getX());
        bufferIn.writeDouble(this.getY());
        bufferIn.writeDouble(this.getZ());
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalDataIn) {
        this.setXRot(additionalDataIn.readFloat());
        this.setYRot(additionalDataIn.readFloat());
        this.setPos(new Vec3(additionalDataIn.readDouble(), additionalDataIn.readDouble(), additionalDataIn.readDouble()));
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
