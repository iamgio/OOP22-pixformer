package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.physics.PhysicsComponent;

/**
 * Implementation of PhysicalComponent for a Player entity.
 */
public class PlayerPhysicsComponent extends PhysicsComponent {

    static float SPEED = 0.00011f;
    static float JUMP_FORCE = 0.0008f;

    /**
     * 
     * @param entity Entity linked to the component
     */
    public PlayerPhysicsComponent(AbstractEntity entity) {
        super(entity);
        //TODO Auto-generated constructor stub
    }

}
