package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.MutableEntity;

import java.util.function.Consumer;

/**
 * Velocity setter which does not change the x component of the current velocity.
 */
public class OnlyXVelocitySetter implements Consumer<Vector2D> {

    private final Consumer<Vector2D> inner;

    /**
     * @param entity to which we want to change the velocity.
     */
    public OnlyXVelocitySetter(final MutableEntity entity) {
        inner = v -> entity.setVelocity(entity.getVelocity().copyWithX(v.x()));
    }

    @Override
    public void accept(final Vector2D v) {
        inner.accept(v);
    }
}
