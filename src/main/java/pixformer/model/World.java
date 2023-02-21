package pixformer.model;

import pixformer.common.Updatable;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamics.Player;

import java.util.List;
import java.util.Optional;
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
     * @return immutable list of the active players that may control entities
     */
    List<Player> getPlayers();

    /**
     * Adds a new player to the world.
     * @param player player to add
     */
    void addPlayer(Player player);

    /**
     * @param index index of the player, starting from {@code 0}
     * @return player at the given index if it exists, or an empty {@link Optional} otherwise
     */
    default Optional<Player> getPlayer(final int index) {
        return index < this.getPlayers().size()
                ? Optional.of(this.getPlayers().get(index))
                : Optional.empty();
    }

    /**
     * @return the first player if it exists
     */
    default Optional<Player> getPlayer1() {
        return this.getPlayer(0);
    }
}
