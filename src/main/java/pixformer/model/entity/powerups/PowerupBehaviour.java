package pixformer.model.entity.powerups;

import pixformer.model.entity.Entity;

/**
 * Interface for a generic powerup.
 */
public interface PowerupBehaviour {

    /**
     * Behaviour of a powerup activation.
     * @param entity The entity who has used the ability of the powerup.
     */
    void ability(Entity entity);

    /**
     * Priority of current powerup regard another, an higher priority powerup "overrides" one with a lower priority.
     * @return the the priority of current powerup.
     */
    int getPriority();
}
