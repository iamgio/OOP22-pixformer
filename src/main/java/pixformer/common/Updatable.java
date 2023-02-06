package pixformer.common;

/**
 * Represents a component that is periodically updated.
 */
public interface Updatable {

    /**
     * Updates the status.
     * @param dt delta time
     */
    void update(double dt);
}
