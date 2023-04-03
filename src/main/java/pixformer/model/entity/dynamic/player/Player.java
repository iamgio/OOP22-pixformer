package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.Powerupable;

public interface Player extends Powerupable, DrawableEntity, DefaultRectangleBoundingBoxEntity {
    void jump();

    void invulnerable(double invincibleTime);

    boolean isOnGround();

    boolean isTouchingAbove();
}
