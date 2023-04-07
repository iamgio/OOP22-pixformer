package pixformer.model.entity.powerup;

import java.util.Optional;

/**
 *  An entity implementing Powerupable can utilize powerups.
 */
public interface Powerupable {

    /**
     * @return current entity powerup.
     */
    Optional<PowerupBehaviour> getPowerupBehaviour();

    /**
     * @return current player powerup.
     */
    PowerUp getPowerup();

     /**
     * Set the new Powerup for the player.
     * @param powerupBehaviour the new powerup.
     * @return true if the player changed powerup state, false otherwise.
     */
    boolean setPowerup(PowerupBehaviour powerupBehaviour);

     /**
     * If possible substitute current powerup with the older one. 
     * @return true if the substitution happened successfully, false otherwise.
     */
    boolean downgrade();

}
