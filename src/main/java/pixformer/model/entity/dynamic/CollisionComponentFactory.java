package pixformer.model.entity.dynamic;

import java.util.Set;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionReactor;

/**
 * Utility static class for transforming a CollsionReactor to a
 * CollisionComponent.
 */
public final class CollisionComponentFactory {

    private CollisionComponentFactory() {
        
    }

    /**
     * @param collisionReactor whose behaviour will be replicated by the resulting
     *                         CollisionComponent.
     * @return a CollisionComponent which behaves like the {@code CollisionReactor}.
     */
    public static CollisionComponent fromReactor(final CollisionReactor collisionReactor) {
        return new CollisionComponent(null) {

            @Override
            public void update(final double dt, final Set<Collision> collisions) {
                collisionReactor.react(collisions);
            }

        };
    }
}
