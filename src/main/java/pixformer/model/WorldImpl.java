package pixformer.model;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.entity.dynamic.Player;

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
            this.collisionManager.findCollisionsFor(entity).forEach(other -> {
                collisionManager.getOnCollideCallbacksFor(entity).forEach(callback -> callback.accept(other));
            });
        });
    }
}
