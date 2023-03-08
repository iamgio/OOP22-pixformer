package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final Set<Entity> entities;
    private final EntityCollisionManager collisionManager;

    /**
     * Create a new World.
     */
    public WorldImpl() {
        this.entities = new HashSet<>();
        this.collisionManager = new EntityCollisionManagerImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getEntities() {
        return Collections.unmodifiableSet(this.entities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void spawnEntity(final Entity entity) {
        this.entities.add(entity);
        entity.onSpawn(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityCollisionManager getCollisionManager() {
        return this.collisionManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.getEntities().forEach(entity -> {
            entity.getCollisionComponent().ifPresent(collisionComponent -> {
                collisionComponent.update(dt, this.collisionManager.findCollisionsFor(entity));
            });
        });
    }
}
