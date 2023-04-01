package pixformer.model.entity.powerup;

import java.util.Optional;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private PowerupBehaviour behaviour;

    private final PowerUp previousPowerup;

    /**
     * @param behaviour current powerup behaviour.
     * @param previous previous powerup.
     */
    public PowerUp(final PowerupBehaviour behaviour, final PowerUp previous) {
        this.behaviour = behaviour;
        this.previousPowerup = previous;
    }

    /**
     * @param behaviour current powerup behaviour.
     */
    public PowerUp(final PowerupBehaviour behaviour) {
        this.behaviour = behaviour;
        this.previousPowerup = null;
    }

    /**
     */
    public PowerUp() {
        this.behaviour = null;
        previousPowerup = null;
    }

    /**
     * Get powerup behaviour.
     * 
     * @return powerup behaviour.
     */
    public Optional<PowerupBehaviour> getBehaviour() {
        return behaviour == null ? Optional.empty() : Optional.of(behaviour);
    }

    /**
     * @return previous powerup if present.
     */
    public Optional<PowerUp> getPrevious() {
        return previousPowerup == null ? Optional.empty() : Optional.of(previousPowerup);
    }

}
