package pixformer.model.entity.powerup.other.fireball;

import pixformer.model.physics.PhysicsComponent;

/**
 * Implementation of PhysicalComponent for a Player entity.
 */
public class FireballPhysicsComponent extends PhysicsComponent {

    /**
     * 
     * @param fireball Entity Fireball affected by the class physics rules.
     */
    public FireballPhysicsComponent(final Fireball fireball) {
        super(fireball);
    }
}
