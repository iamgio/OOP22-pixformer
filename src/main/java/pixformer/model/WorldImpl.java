package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.event.EventManager;
import pixformer.model.input.UserInputComponent;
import pixformer.model.score.ScoreManager;
import pixformer.model.score.ScoreManagerImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final WorldOptions options;
    private final Set<Entity> entities;
    private final EntityCollisionManager collisionManager;
    private final EventManager eventManager;
    private final ScoreManager scoreManager;
    private final List<Runnable> commandQueue;

    private Set<Entity> lazyUserControlledEntity;

    /**
     * Create a new World.
     *
     * @param options world options that affect this world's behavior
     */
    public WorldImpl(final WorldOptions options) {
        this.options = options;
        this.entities = new HashSet<>();
        this.commandQueue = new LinkedList<>();
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
     * {@inheritDoc}
     */
    @Override
    public Stream<Entity> getUpdatableEntities() {
        if (this.options.updateRange() == WorldOptions.INFINITE_UPDATE_RANGE) {
            return this.getEntities().stream();
        }

        return this.getEntities().stream()
                .filter(entity ->
                        getUserControlledEntities().stream()
                                .anyMatch(player -> entity.getDistanceFrom(player) < this.options.updateRange())
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
    public void queueEntitySpawn(final Entity entity) {
        this.commandQueue.add(() -> spawnEntity(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void queueEntityKill(final Entity killed, final Entity killer) {
        this.queueEntityDrop(killed);
        eventManager.killed(killed, killer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void queueEntityDrop(final Entity entity) {
        this.commandQueue.add(() -> this.entities.remove(entity));
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
    public void endGame(Player winner) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.getUpdatableEntities().forEach(entity -> {
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
        this.commandQueue.forEach(Runnable::run);
        this.commandQueue.clear();
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
