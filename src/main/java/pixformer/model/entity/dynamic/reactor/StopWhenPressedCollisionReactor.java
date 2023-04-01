package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;

import java.util.Collection;
import java.util.function.DoubleConsumer;

/**
 * A collision reactor which stops the controlled entity when it is pressed from the top.
 */
public final class StopWhenPressedCollisionReactor implements CollisionReactor {

    private final CollisionReactor inner;

    /**
     * @param velocitySetter the setter for the x direction of the velocity of the controlled entity.
     */
    public StopWhenPressedCollisionReactor(final DoubleConsumer velocitySetter) {
        inner = new ActionOnPressedCollisionReactor(
                e -> velocitySetter.accept(0)
        );
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        inner.react(collisions);
    }
}
