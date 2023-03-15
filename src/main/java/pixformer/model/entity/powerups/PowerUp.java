package pixformer.model.entity.powerups;

/**
 * Class defining the powerup object.
 */
public class PowerUp {

    // Current powerup ability power
    private PowerupBehaviour behaviour;

    /*
     * Priority among powerups (if player current powerup is lower than the new one
     * the new powerup is set,
     * otherwhise the previous powerup will be kept)
     */
    private int priority = 0;

    /**
     * 
     * @param behaviour current powerup behaviour.
     * @param priority  The priority of current powerup
     */
    public PowerUp(final PowerupBehaviour behaviour, final int priority) {
        this.behaviour = behaviour;
        this.priority = priority;
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
