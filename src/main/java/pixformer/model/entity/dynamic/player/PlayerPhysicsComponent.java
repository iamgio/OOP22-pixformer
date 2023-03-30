package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.physics.PhysicsComponent;

/**
 * Implementation of PhysicalComponent for a Player entity.
 */
public class PlayerPhysicsComponent extends PhysicsComponent {

    /**
     * 
     * @param entity Entity linked to the component
     */
    public PlayerPhysicsComponent(final AbstractEntity entity) {
        super(entity);
    }

}
