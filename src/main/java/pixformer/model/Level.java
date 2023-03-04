package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

import java.util.List;

/**
 * A playable level.
 */
public interface Level {

    /**
     * @return level name
     */
    String getName();

    /**
     * The level world is a mutable container where entities' lifecycles run as time passes and events happen.
     * @return the world of this level.
     */
    World getWorld();

    /**
     * @return an immutable list of players of the current game
     * @implNote the list is populated only after calling {@link Level#setup(int)}
     */
    List<CompleteModelInput> getPlayers();

    /**
     * Sets up the game world.
     * @param playersAmount amount of players to add to the game world
     */
    void setup(int playersAmount);
}
