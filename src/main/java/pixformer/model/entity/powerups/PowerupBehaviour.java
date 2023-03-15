package pixformer.model.entity.powerups;

/**
 * Interface for a generic powerup.
 */
public interface PowerupBehaviour {
    /**
     * Behaviour of a powerup activation.
     */
    void ability();

    /**
     * Priority of current powerup regard another, an higher priority powerup "overrides" one with a lower priority
     */
    int getPriority();
}
