package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * A collision reactor which reacts when it finds a collision with Player for the TOP direction.
 */
public final class ActionOnPressedCollisionReactor implements CollisionReactor {

    private final CollisionReactor innerReactor;

    /**
     * @param action consumer which accepts the colliding entity.
     */
    public ActionOnPressedCollisionReactor(final Consumer<Entity> action) {
        innerReactor = new SingleCollisionReactor(
            collision -> collision.entity() instanceof Player && collision.side() == CollisionSide.TOP,
            action
        );
    }
    @Override
    public void react(final Collection<Collision> collisions) {
        innerReactor.react(collisions);
    }
}
