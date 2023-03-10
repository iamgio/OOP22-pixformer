package pixformer.model.entity.powerups.other.Fireball;

import java.util.Set;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class FireballCollisionComponent extends CollisionComponent {

    /**
     * 
     * @param entity Entity linked with current component.
     */
    protected FireballCollisionComponent(final Entity entity) {
        super(entity);
        //TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        for (var x : collisions) {
            throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

    }

}
