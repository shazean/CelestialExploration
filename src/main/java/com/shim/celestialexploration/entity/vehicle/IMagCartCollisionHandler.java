package com.shim.celestialexploration.entity.vehicle;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;

public interface IMagCartCollisionHandler {
    /**
     * This basically replaces the function of the same name in EntityMinecart.
     * Code in IMinecartHooks.applyEntityCollisionHook is still run.
     * @param cart The cart that called the collision.
     * @param other The object it collided with.
     */
    void onEntityCollision(AbstractMagCart cart, Entity other);

    /**
     * This function replaced the function of the same name in EntityMinecart.
     * It is used to define whether minecarts collide with specific entities,
     * for example items.
     * @param cart The cart for which the collision box was requested.
     * @param other The entity requesting the collision box.
     * @return The collision box or null.
     */
    AABB getCollisionBox(AbstractMagCart cart, Entity other);

    /**
     * This function is used to define the box used for detecting minecart collisions.
     * It is generally bigger that the normal collision box.
     * @param cart The cart for which the collision box was requested.
     * @return The collision box, cannot be null.
     */
    AABB getMinecartCollisionBox(AbstractMagCart cart);

    /**
     * This function replaces the function of the same name in EntityMinecart.
     * It defines whether minecarts are solid to the player.
     * @param cart The cart for which the bounding box was requested.
     * @return The bounding box or null.
     */
    AABB getBoundingBox(AbstractMagCart cart);
}

