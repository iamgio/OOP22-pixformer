package pixformer.model.entity.powerups;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private PowerupBehaviour behaviour;

    /**
     * 
     * @param behaviour current powerup behaviour.
     */
    public PowerUp(final PowerupBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    /**
     * Get powerup behaviour.
     * 
     * @return powerup behaviour.
     */
    public PowerupBehaviour getBehaviour() {
        return behaviour;
    }

}
