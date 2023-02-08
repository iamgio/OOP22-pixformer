package pixformer.model;

import pixformer.model.entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The standard implementation of the game world.
 */
public class WorldImpl implements World {

    private final Set<Entity> entities = new HashSet<>();
    private final List<Player> players = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getEntities() {
        return this.entities;
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
