package pixformer.model;

import pixformer.common.Updatable;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;

import java.util.Set;

/**
 * The environment where entities live, interact and die.
 */
public interface World extends Updatable {

    /**
     * @return the entities living within this world
     */
    Set<Entity> getEntities();

    /**
     * Adds an entity to the game world.
     * 
     * @param entity entity to add
     */
    void spawnEntity(Entity entity);

    /**
     * @return the handler of entity collisions for this world
     */
    EntityCollisionManager getCollisionManager();
}
