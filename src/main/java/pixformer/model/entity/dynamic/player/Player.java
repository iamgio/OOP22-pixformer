package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.SoundableEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.Powerupable;

/**
 * Interface representing a Player entity.
 */
public interface Player extends Powerupable, DrawableEntity, SoundableEntity, DefaultRectangleBoundingBoxEntity, MutableEntity {

    /**
     * @return current player index.
     */
    int getIndex();

    /**
     * Make the player entity invincible for a while.
     * @param invincibleTime how long the player is invincible.
     */
    void invulnerable(long invincibleTime);

    /**
     * @return true if the player is touching ground, false otherwise.
     */
    boolean isOnGround();

    /**
     * @return true if the player is touching something above him, false otherwise.
     */
    boolean isTouchingAbove();
}
