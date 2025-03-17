package com.shim.celestialexploration.entity.model;

import com.shim.celestialexploration.entity.entity.robots.AbstractCerberus;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

import javax.annotation.Nonnull;

public class CerberusPart extends PartEntity<AbstractCerberus> {
    public final String name;
    private final EntityDimensions size;
    private float xOffset;
    private float yOffset;
    private float zOffset;
    public boolean hasCollider;

    public CerberusPart(AbstractCerberus parentIn, String nameIn, float sizeXIn, float sizeYIn, float xOffsetIn, float yOffsetIn, float zOffsetIn, boolean hasCollider) {
        super(parentIn);
        this.name = nameIn;
        this.size = EntityDimensions.scalable(sizeXIn, sizeYIn);
        this.xOffset = xOffsetIn;
        this.yOffset = yOffsetIn;
        this.zOffset = zOffsetIn;
        this.hasCollider = hasCollider;
        this.refreshDimensions();
    }

    /**
     * Getter methods for various variables
     */
    public float getWidth() { return this.size.width; }
    public float getHeight() { return this.size.height; }
    public float getDefaultXOffset() { return this.xOffset; }
    public float getDefaultYOffset() { return this.yOffset; }
    public float getDefaultZOffset() { return this.zOffset; }

    /**
     * Updates the position of the hitbox relative to the dragon's rotation.  Rotation info is pulled directly from the parent entity.
     * Any adjustments to offset (i.e. shifting for animations) should be done before passing in the variables
     */
    public void updatePosition(double offsetXIn, double offsetYIn, double offsetZIn) {
        Vec3 lastPos = new Vec3(this.getX(), this.getY(), this.getZ());

        AbstractCerberus parent = this.getParent();
        Vec3 newPos = translateWithXRotation(parent.position(), parent.getYRot(), offsetXIn, offsetYIn, offsetZIn);

        //Sets the position with rotation applied
        this.setPos(newPos.x, newPos.y, newPos.z);

        //Not sure if this is strictly necessary but some examples showed it
        this.xo = lastPos.x;
        this.yo = lastPos.y;
        this.zo = lastPos.z;
        this.xOld = lastPos.x;
        this.yOld = lastPos.y;
        this.zOld = lastPos.z;
    }

    public boolean isPickable() { return this.hasCollider; }
    public EntityDimensions getDimensions(Pose poseIn) { return this.size;}

    public static Vec3 translateWithXRotation(@Nonnull Vec3 baseIn, double rotationIn, double xOffsetIn, double yOffsetIn, double zOffsetIn) {
        double rotation = Math.toRadians(rotationIn);
        double offsetXRotated = (xOffsetIn * -Math.sin(rotation)) + (zOffsetIn * Math.cos(rotation));
        double offsetZRotated = (xOffsetIn * Math.cos(rotation)) + (zOffsetIn * Math.sin(rotation));
        return new Vec3(baseIn.x + offsetXRotated, baseIn.y + yOffsetIn, baseIn.z + offsetZRotated);
    }

    /**
     * Applies damage when this part is struck.  Used to transfer that damage to the parent entity.
     * We could do something with variable damage here...
     */
    public boolean hurt(DamageSource damageSourceIn, float damageIn) {
        return this.hasCollider ? this.getParent().hurt(damageSourceIn, damageIn) : false;
    }

    /**
     * Passes interaction to the parent entity.  Makes it so that when you interact with a subpart, it forwards the interaction to the main dragon
     */
    public InteractionResult interact(Player playerIn, InteractionHand handIn) {
        return this.hasCollider ? this.getParent().interact(playerIn, handIn) : InteractionResult.PASS;
    }

    /**
     * Default methods, but parts don't seem to use them
     */
    @Override
    protected void defineSynchedData() {}
    @Override
    protected void readAdditionalSaveData(CompoundTag tagIn) {}
    @Override
    protected void addAdditionalSaveData(CompoundTag tagIn) {}

}