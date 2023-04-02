package pixformer.model.entity.statics.surprise;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Set;
import java.util.function.Consumer;

/**
 * A {@link CollisionComponent} component for the surprise block, specifying the behaviour
 * when something collide with it.
 */
public class SurpriseCollisionComponent extends CollisionComponent {

    private final Consumer<Entity> consumer;

    /**
     * Simple constructor for the SurpriseCollisionComponent.
     *
     * @param entity entity with this collision component
     * @param consumer consumer that specify the behaviour of the surprise block when collided
     */
    public SurpriseCollisionComponent(final Surprise entity, final Consumer<Entity> consumer) {
        super(entity);
        this.consumer = consumer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        collisions.stream()
                .filter(collision -> collision.entity() instanceof Player player
                        && collision.side() == CollisionSide.BOTTOM
                        && player.getVelocity().y() < 0)
                .forEach(collision -> consumer.accept(collision.entity()));
    }
}
