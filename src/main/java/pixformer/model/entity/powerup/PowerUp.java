package pixformer.model.entity.powerup;

import java.util.Optional;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private Optional<PowerupBehaviour> behaviour;

    private final Optional<PowerUp> previousPowerup;

    /**
     * @param behaviour current powerup behaviour.
     * @param previous previous powerup.
     */
    public PowerUp(final PowerupBehaviour behaviour, final PowerUp previous) {
        this.behaviour = Optional.of(behaviour);
        this.previousPowerup = Optional.of(previous);
    }

    /**
     * @param behaviour current powerup behaviour.
     */
    public PowerUp(final PowerupBehaviour behaviour) {
        this.behaviour = Optional.of(behaviour);
        this.previousPowerup = Optional.empty();
    }

    /**
     */
    public PowerUp() {
        this.behaviour = Optional.empty();
        previousPowerup = Optional.empty();
    }

    /**
     * Get powerup behaviour.
     * 
     * @return powerup behaviour.
     */
    public Optional<PowerupBehaviour> getBehaviour() {
        return behaviour;
    }

    /**
     * @return previous powerup if present.
     */
    public Optional<PowerUp> getPrevious() {
        return previousPowerup;
    }

}
