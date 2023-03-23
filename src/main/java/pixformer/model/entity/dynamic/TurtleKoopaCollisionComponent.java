package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

import java.util.Set;
import java.util.function.Consumer;

/**
 * The collision component for a turtle koopa. The koopa dies when pressed by a player.
 */
public class TurtleKoopaCollisionComponent extends CollisionComponent {

    private final CollisionComponent forDying;

    /**
     * @param entity to be controlled.
     * @param die when called it kills the koopa. It consumes the killer.
     */
    public TurtleKoopaCollisionComponent(final MutableEntity entity, final Consumer<Entity> die) {
        super(entity);
        forDying = new ActionOnPressedCollisionComponent(entity, (__, player) -> die.accept(player));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        forDying.update(dt, collisions);
    }
}
