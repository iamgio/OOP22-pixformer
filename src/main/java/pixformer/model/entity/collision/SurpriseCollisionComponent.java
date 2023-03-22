package pixformer.model.entity.collision;

import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.PowerUpFactory;
import pixformer.model.entity.statics.Surprise;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

import java.util.Set;

/**
 * Collision component for the surprise block.
 */
public class SurpriseCollisionComponent extends CollisionComponent{

    private final PowerUpFactory powerupFactory;

    /**
     * Simple constructor for the SurpriseCollisionComponent
     *
     * @param entity entity with this collision component
     */
    public SurpriseCollisionComponent(final Surprise entity) {
        super(entity);
        this.powerupFactory = new EntityFactoryImpl(new SpritesGraphicsComponentFactory());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        // TODO better way to cast the entity
        Surprise entity;
        if (super.getEntity() instanceof Surprise) {
            entity = (Surprise) super.getEntity();
        } else {
            return;
        }
        for (var collision : collisions) {
            if (collision.side() == CollisionSide.BOTTOM && entity.getWorld().isPresent() && !entity.hasCollided()) {
                entity.getWorld().get().addEntityToSpawn(powerupFactory.createMushroom(20, 20));
                entity.setCollided(true);
            }
        }
    }
}
