package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.statics.Brick;
import pixformer.model.entity.statics.Surprise;

import java.util.Set;

/**
 * Collision component for the surprise block.
 */
public class SurpriseCollisionComponent extends CollisionComponent{

    /**
     * Simple constructor for the SurpriseCollisionComponent
     *
     * @param entity entity with this collision component
     */
    public SurpriseCollisionComponent(final Surprise entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        Surprise entity;
        if (super.getEntity() instanceof Surprise) {
            entity = (Surprise) super.getEntity();
        } else {
            return;
        }
        for (var collision : collisions) {
            if (collision.side() == CollisionSide.BOTTOM && entity.getWorld().isPresent() && !entity.hasCollided()) {
                entity.getWorld().get().addEntityToSpawn(new Brick(20, 20));
                entity.setCollided(true);
            }
        }
    }
}
