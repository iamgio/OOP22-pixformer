package pixformer.model.entity.dynamic;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.collision.SimpleCollisionReactor;
import pixformer.model.entity.dynamic.player.Player;

/**
 * A collision component which makes its entity die when it collides from the
 * top with a Player.
 */
public final class ActionOnPressedCollisionComponent extends CollisionComponent {

    private final CollisionReactor reactor;

    /**
     * If the entity has a world create a {@code ActionOnPressedCollisionComponent}.
     * 
     * @param entity to be controlled.
     * @return a {@code ActionOnPressedCollisionComponent} if the entity has a world
     */
    static Optional<CollisionComponent> createWithWorldFromEntityForDying(final MutableEntity entity) {
        return entity.getWorld().map(world -> new ActionOnPressedCollisionComponent(entity, world::killEntity));
    }

    /**
     * @param entity to be controlled.
     * @param action the consumer to which will be passed this entity.
     */
    public ActionOnPressedCollisionComponent(final MutableEntity entity, final Consumer<Entity> action) {
        super(entity);
        reactor = new SimpleCollisionReactor(Map.of(
                Player.class::isInstance, new SideCheckerConsumer(CollisionSide.TOP, () -> action.accept(entity))));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        reactor.react(collisions);
    }

}
