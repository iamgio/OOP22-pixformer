package pixformer.model;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.EntityCollisionManagerImpl;
import pixformer.model.entity.dynamics.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final Set<DrawableEntity> entities;
    private final EntityCollisionManager collisionManager;
    private final List<Player> players = new ArrayList<>();

    /**
     * Create a new World with the given entities.
     * 
     * @param entities
     */
    public WorldImpl(final Set<DrawableEntity> entities) {
        this.entities = new HashSet<>(entities);
        this.collisionManager = new EntityCollisionManagerImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DrawableEntity> getEntities() {
        return Set.copyOf(this.entities);
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

    }
}
