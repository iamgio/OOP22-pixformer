package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.event.EventManager;
import pixformer.model.input.UserInputComponent;
import pixformer.model.score.ScoreManager;
import pixformer.model.score.ScoreManagerImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    /**
     * The distance range from any player in which entities are updated.
     */
    private static final int UPDATE_RANGE = 8;

    private final Set<Entity> entities;
    private final Set<Entity> killedEntities;
    private final Set<Entity> toSpawnEntities;
    private final EntityCollisionManager collisionManager;
    private final EventManager eventManager;
    private final ScoreManager scoreManager;

    private Set<Entity> lazyUserControlledEntity;

    /**
     * Create a new World.
     */
    public WorldImpl() {
        this.entities = new HashSet<>();
        this.killedEntities = new HashSet<>();
        this.toSpawnEntities = new HashSet<>();
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
    public ScoreManager getScoreManager() {
        return this.scoreManager;
    }

    /**
     * {@inheritDoc}
     * @implNote lazily evaluated
     */
    @Override
    public Set<Entity> getUserControlledEntities() {
        if (this.lazyUserControlledEntity == null) {
            this.lazyUserControlledEntity = this.entities.stream()
                    .filter(entity -> entity.getInputComponent().isPresent())
                    .filter(entity -> entity.getInputComponent().get() instanceof UserInputComponent)
                    .collect(Collectors.toUnmodifiableSet());
        }
        return this.lazyUserControlledEntity;
    }

    /**
     * @return entities within the 'update range' from any player
     */
    private Stream<Entity> getEntitiesInUpdateRange() {
        return this.getEntities().stream()
                .filter(entity ->
                        getUserControlledEntities().stream()
                                .anyMatch(player -> entity.getDistanceFrom(player) < UPDATE_RANGE)
                );
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
    public void addEntityToSpawn(final Entity entity) {
        this.toSpawnEntities.add(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void killEntity(final Entity entity, final Entity player) {
        this.killedEntities.add(entity);
        eventManager.killed(entity, player);
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
        this.getEntitiesInUpdateRange().forEach(entity -> {
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
        for (var entity : this.toSpawnEntities) {
            spawnEntity(entity);
        }
        this.toSpawnEntities.clear();
    }

    /**
     * Updates an entity's position depending on its velocity and possible nearby solid entities.
     * @param dt dela time
     * @param entity entity to update position of
     */
    private void updatePosition(final double dt, final MutableEntity entity) {
        entity.setX(entity.getX() + dt * entity.getVelocity().x());
        entity.setY(entity.getY() + dt * entity.getVelocity().y());
    }
}
