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

}
