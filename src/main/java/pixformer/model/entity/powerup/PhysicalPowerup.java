package pixformer.model.entity.powerup;

/**
 * Represents a physical object in the game that contains a powerup inside.
 */
public interface PhysicalPowerup {

    /**
     * Returns the powerup behavior represented by this physical powerup.
     * 
     * @return the `PowerupBehaviour` instance that describes the behavior of the powerup contained within the physical object.
     */
    PowerupBehaviour getPowerupBehaviour();
}
