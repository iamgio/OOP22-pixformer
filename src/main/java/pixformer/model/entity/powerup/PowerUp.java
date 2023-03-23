package pixformer.model.entity.powerup;

import java.util.Optional;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private final PowerupBehaviour behaviour;

    private final Optional<PowerUp> previousPowerup;

    /**
     * @param behaviour current powerup behaviour.
     * @param previous previous powerup.
     */
    public PowerUp(final PowerupBehaviour behaviour, final Optional<PowerUp> previous) {
        this.behaviour = behaviour;
        this.previousPowerup = previous;
    }

    /**
     * @param behaviour current powerup behaviour.
     */
    public PowerUp(final PowerupBehaviour behaviour) {
        this.behaviour = behaviour;
        previousPowerup = Optional.empty();
    }

    /**
     * Get powerup behaviour.
     * 
     * @return powerup behaviour.
     */
    public PowerupBehaviour getBehaviour() {
        return behaviour;
    }

    public Optional<PowerUp> getPrevious() {
        return previousPowerup;
    }

}
