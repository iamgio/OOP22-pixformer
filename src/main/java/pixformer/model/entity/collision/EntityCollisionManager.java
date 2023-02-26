package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Handler for entity-entity collisions.
 */
public interface EntityCollisionManager {

    /**
     * Looks for collisions involving the given entity.
     * @param entity entity to check collisions for
     * @return the group of entities colliding with the given entity
     */
    Stream<? extends Entity> findCollisionsFor(Entity entity);

    /**
     * @param entity entity to get collision callbacks for
     * @return an immutable copy of the callbacks to be called
     *     whenever the given entity collides with another entity
     */
    Set<Consumer<Entity>> getOnCollideCallbacksFor(Entity entity);

    /**
     * Adds an entity collision callback.
     * @param entity entity to add the callback for
     * @param action action to be executed on collision, with the other entity as an argument
     */
    void addOnCollide(Entity entity, Consumer<Entity> action);
}
