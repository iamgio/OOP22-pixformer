package pixformer.model.entity.powerup;

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
    }

    public PowerUp() {

    }

    /**
     * Get powerup behaviour.
     * 
     * @return powerup behaviour.
     */
    public PowerupBehaviour getBehaviour() {
        return behaviour;
    }

    public PowerUp getPrevious() {
        return previousPowerup;
    }

    public void setBehaviour(PowerupBehaviour powerupBehaviour) {
        this.behaviour = powerupBehaviour;
    }

}
