package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.input.AIInputComponent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final Set<Entity> entities;
    private final Set<Entity> killedEntities;
    private final EntityCollisionManager collisionManager;

    /**
     * Create a new World.
     */
    public WorldImpl() {
        this.entities = new HashSet<>();
        this.killedEntities = new HashSet<>();
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
    public void killEntity(final Entity entity) {
        this.killedEntities.add(entity);
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
            entity.getPhysicsComponent().ifPresent(physicsComponent -> {
                physicsComponent.update(dt);
            });
            entity.getCollisionComponent().ifPresent(collisionComponent -> {
                collisionComponent.update(dt, this.collisionManager.findCollisionsFor(entity));
            });
            entity.getInputComponent()
                    .filter(AIInputComponent.class::isInstance)
                    .map(AIInputComponent.class::cast)
                    .ifPresent(ai -> ai.update(this));

            if (entity instanceof MutableEntity mutableEntity) {
                updatePosition(dt, mutableEntity);
            }
        });
        this.entities.removeAll(this.killedEntities);
    }

    private void updatePosition(final double dt, final MutableEntity entity) {
        entity.setX(entity.getX() + dt * entity.getVelocity().x());
        entity.setY(entity.getY() + dt * entity.getVelocity().y());
    }
}
