package pixformer.model.entity.powerup;

import java.util.Optional;

import pixformer.model.entity.powerup.powerups.Mushroom;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private PowerupBehaviour behaviour;

    private PowerUp previousPowerup;

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

    /**
     * Set the new Powerup for the player.
     * @param powerupBehaviour the new powerup.
     */
    public void setPowerup(final PowerupBehaviour powerupBehaviour) {

        if (behaviour == null) {
            if (powerupBehaviour.getPriority() > 1) {
                previousPowerup = new PowerUp(new Mushroom());
            }
            behaviour = powerupBehaviour;            
        } else {
            if (behaviour.getPriority() == powerupBehaviour.getPriority()) {
                behaviour = powerupBehaviour;
            } else if (behaviour.getPriority() < powerupBehaviour.getPriority()) {
                previousPowerup = new PowerUp(behaviour, previousPowerup);
                behaviour = powerupBehaviour;
            }
        }
    }

    /**
     * If possible substitute current powerup with the older one. 
     * @return true if the substitution happened successfully, false otherwise.
     */
    public boolean downgrade() {
        if (behaviour == null) {
            return false;
        }

        if (previousPowerup == null) {
            behaviour = null;
            return true;
        }

        this.behaviour = previousPowerup.behaviour;
        this.previousPowerup = previousPowerup.previousPowerup;
        return true;
    }

}
