package pixformer.model;

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
}
