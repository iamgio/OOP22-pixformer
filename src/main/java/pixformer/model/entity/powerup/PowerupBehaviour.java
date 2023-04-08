package pixformer.model.entity.powerup;

import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;

/**
 * Interface for a generic powerup.
 */
public interface PowerupBehaviour {

    /**
     * Behaviour of a powerup activation.
     * @param entity The entity who has used the ability of the powerup.
     * @param entityFactory
     */
    void ability(Entity entity, EntityFactory entityFactory);

    /**
     * Priority of current powerup regard another, an higher priority powerup "overrides" one with a lower priority.
     * @return the the priority of current powerup.
     */
    int getPriority();
}
