package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.input.AIInputComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final Set<Entity> entities;
    private final EntityCollisionManager collisionManager;
    private final List<Player> players = new ArrayList<>();

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
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPlayer(final Player player) {
        this.players.add(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.getEntities().forEach(entity -> {
            entity.getCollisionComponent().ifPresent(collisionComponent -> {
                collisionComponent.update(dt, this.collisionManager.findCollisionsFor(entity));
            entity.getInputComponent()
                .filter(AIInputComponent.class::isInstance)
                .map(AIInputComponent.class::cast)
                .ifPresent(ai -> ai.update(this));
            });
            updatePosition(dt, entity);
        });
    }

    private void updatePosition(final double dt, final Entity entity) {
        entity.setX(entity.getX() + dt * entity.getVelocity().x());
        entity.setY(entity.getY() + dt * entity.getVelocity().y());
    }
}
