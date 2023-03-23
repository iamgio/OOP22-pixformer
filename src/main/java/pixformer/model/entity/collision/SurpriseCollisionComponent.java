package pixformer.model.entity.collision;

import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.PowerUpFactory;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Surprise;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

import java.util.Set;

/**
 * A {@link CollisionComponent} component for the surprise block, specifying the behaviour
 * when something collide with it.
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
        collisions.stream()
                .filter(collision -> collision.entity() instanceof Player && collision.side() == CollisionSide.BOTTOM)
                .forEach(collision -> {
                    if (entity.getWorld().isPresent() && !entity.hasCollided()) {
                        entity.getWorld().get().addEntityToSpawn(powerupFactory.createMushroom((int) super.getEntity().getX(), (int) super.getEntity().getY() - 1));
                        entity.setCollided(true);
                    }
        });
    }
}
