package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

import java.util.Set;
import java.util.function.Consumer;

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
     * @param entity entity to get collision callbacks for
     * @return an immutable copy of the callbacks to be called
     *     whenever the given entity collides with another entity
     */
    Set<Consumer<Collision>> getOnCollideCallbacksFor(Entity entity);

    /**
     * Adds an entity collision callback.
     * @param entity entity to add the callback for
     * @param action action to be executed on collision, with the other entity as {@link Collision#entity()}
     */
    void addOnCollide(Entity entity, Consumer<Collision> action);
}
