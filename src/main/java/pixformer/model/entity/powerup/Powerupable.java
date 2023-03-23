package pixformer.model.entity.powerup;

/**
 *  An entity implementing Powerupable can utilize powerups.
 */
public interface Powerupable {

    /**
     * @return current entity powerup.
     */
    PowerupBehaviour getPowerupBehaviour();

}
