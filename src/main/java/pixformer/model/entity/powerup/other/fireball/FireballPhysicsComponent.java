package pixformer.model.entity.powerup.other.fireball;

import pixformer.common.Vector2D;
import pixformer.model.physics.PhysicsComponent;

/**
 * Implementation of PhysicalComponent for a Player entity.
 */
public class FireballPhysicsComponent extends PhysicsComponent {
    private final Fireball fireball;

    /**
     * 
     * @param fireball Entity Fireball affected by the class physics rules.
     */
    public FireballPhysicsComponent(final Fireball fireball) {
        super(fireball);
        this.fireball = fireball;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        super.update(dt);
        fireball.setVelocity(new Vector2D(fireball.getSpeed(), fireball.getVelocity().y()));
    }
}
