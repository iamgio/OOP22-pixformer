package pixformer.model.entity.powerups.other.Fireball;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.physics.PhysicsComponent;

/**
 * Implementation of PhysicalComponent for a Player entity.
 */
public class FireballPhysicsComponent extends PhysicsComponent {

    /**
     * 
     * @param entity Entity affected by the class physics rules.
     */
    public FireballPhysicsComponent(final AbstractEntity entity) {
        super(entity);
    }
}
