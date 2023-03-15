package pixformer.model.entity.powerups.other.Fireball;

import java.util.Set;

import pixformer.model.World;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class FireballCollisionComponent extends CollisionComponent {
    private Fireball fireball;
    private World world;

    /**
     * 
     * @param entity Entity linked with current component.
     */
    protected FireballCollisionComponent(final Fireball fireball, final World world) {
        super(fireball);
        this.fireball = fireball;
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        for (var x : collisions) {
            if (x.side().isHorizontal()) {
                world.killEntity(fireball);
            }
        }

    }

}
