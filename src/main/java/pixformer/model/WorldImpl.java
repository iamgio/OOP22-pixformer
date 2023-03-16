package pixformer.model;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.event.EventManager;
import pixformer.model.score.ScoreManager;
import pixformer.model.score.ScoreManagerImpl;

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
    private final EventManager eventManager;
    private final ScoreManager scoreManager;

    /**
     * Create a new World.
     */
    public WorldImpl() {
        this.entities = new HashSet<>();
        this.killedEntities = new HashSet<>();
        this.collisionManager = new EntityCollisionManagerImpl(this);
        this.eventManager = new EventManager();
        this.scoreManager = new ScoreManagerImpl(this.eventManager);
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
        eventManager.killed(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dropEntity(final Entity entity) {
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
            entity.getInputComponent().ifPresent(ai -> ai.update(this));

            if (entity instanceof MutableEntity mutableEntity) {
                updatePosition(dt, mutableEntity);
            }
        });
        this.entities.removeAll(this.killedEntities);
    }

    /**
     * Updates an entity's position depending on its velocity and possible nearby solid entities.
     * @param dt dela time
     * @param entity entity to update position of
     */
    private void updatePosition(final double dt, final MutableEntity entity) {
        this.handleCollisions(entity);
        entity.setX(entity.getX() + dt * entity.getVelocity().x());
        entity.setY(entity.getY() + dt * entity.getVelocity().y());
    }

    /**
     * Handles an entity's velocity and position in case of collisions width solid entities.
     * @param entity entity to handle collisions for
     */
    private void handleCollisions(final MutableEntity entity) {
        // Ground collision
        if (entity.getVelocity().y() > 0 && collisionManager.isCollidingGround(entity)) {
            entity.setVelocity(new Vector2D(entity.getVelocity().x(), 0));
            entity.setY(Math.floor(entity.getY())); // Fixes intersections.
        }

        // Ceiling collision
        if (entity.getVelocity().y() < 0 && collisionManager.isCollidingCeiling(entity)) {
            entity.setVelocity(new Vector2D(entity.getVelocity().x(), 0));
            entity.setY(Math.ceil(entity.getY()));
        }

        // Left collision
        if (entity.getVelocity().x() < 0 && collisionManager.isCollidingLeftWall(entity)) {
            entity.setVelocity(new Vector2D(0, entity.getVelocity().y()));
            entity.setX(Math.ceil(entity.getX()));
        }

        // Right collision
        if (entity.getVelocity().x() > 0 && collisionManager.isCollidingRightWall(entity)) {
            entity.setVelocity(new Vector2D(0, entity.getVelocity().y()));
            entity.setX(Math.floor(entity.getX()));
        }

        // TODO reduce repetitions
    }
}
