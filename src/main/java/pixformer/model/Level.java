package pixformer.model;

import pixformer.model.input.InputComponent;

import java.util.Set;

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
     * @return input components of user-controlled entities living within this level's world
     */
    Set<InputComponent> getPlayerEntityInputComponents();

    /**
     * Sets up the game world.
     */
    void setup();
}
