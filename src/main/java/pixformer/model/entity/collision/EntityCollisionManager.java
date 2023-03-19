package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

import java.util.Set;

/**
 * Handler for entity-entity collisions.
 */
public interface EntityCollisionManager {

    /**
     * Looks for collisions involving the given entity.
     * @param entity entity to check collisions for
     * @return the group of collisions involving the given entity
     */
    Set<Collision> findCollisionsFor(Entity entity);

    /**
     * @param entity entity to check collisions for
     * @return whether the entity is colliding a solid entity on the bottom side.
     */
    boolean isCollidingGround(Entity entity);

    /**
     * @param entity entity to check collisions for
     * @return whether the entity is colliding a solid entity on the top side.
     */
    boolean isCollidingCeiling(Entity entity);

    /**
     * @param entity entity to check collisions for
     * @return whether the entity is colliding a solid entity on the right side.
     */
    boolean isCollidingRightWall(Entity entity);

    /**
     * @param entity entity to check collisions for
     * @return whether the entity is colliding a solid entity on the left side.
     */
    boolean isCollidingLeftWall(Entity entity);
}
