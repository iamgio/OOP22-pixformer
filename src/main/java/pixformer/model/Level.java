package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

import java.util.Optional;

/**
 * A playable level.
 */
public interface Level {

    /**
     * @return read-only level data
     */
    LevelData getData();

    /**
     * The level world is a mutable container where entities' lifecycles run as time passes and events happen.
     * @return the world of this level.
     */
    World getWorld();

    /**
     * @return player 1 if it exists
     */
    Optional<CompleteModelInput> getPlayer1();

    /**
     * @return player 2 if it exists
     */
    Optional<CompleteModelInput> getPlayer2();

    /**
     * Sets up the game world.
     * @param playersAmount amount of players to add to the game world
     */
    void setup(int playersAmount);
}
