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
}
