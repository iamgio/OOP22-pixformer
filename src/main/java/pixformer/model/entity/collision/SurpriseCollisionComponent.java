package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.statics.Brick;

import java.util.Set;

/**
 * Collision component for the surprise block.
 */
public class SurpriseCollisionComponent extends CollisionComponent{
    private boolean hasCollided;

    /**
     * {@inheritDoc}
     */
    public SurpriseCollisionComponent(MutableEntity entity) {
        super(entity);
        this.hasCollided = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(double dt, Set<Collision> collisions) {
        for (var collision : collisions) {
            if (collision.side() == CollisionSide.BOTTOM && super.getEntity().getWorld().isPresent() && !hasCollided) {
                super.getEntity().getWorld().get().addEntityToSpawn(new Brick(20, 20));
                this.hasCollided = true;
            }
        }
    }
}
