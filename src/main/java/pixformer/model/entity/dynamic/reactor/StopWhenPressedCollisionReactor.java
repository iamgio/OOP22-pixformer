package pixformer.model.entity.dynamic.reactor;

import javafx.application.Platform;
import pixformer.common.Vector2D;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class StopWhenPressedCollisionReactor implements CollisionReactor {

    private final CollisionReactor inner;

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
