package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

import java.util.Set;
import java.util.function.Consumer;

public class TurtleKoopaCollisionComponent extends CollisionComponent {

    private final CollisionComponent forDying;
    public TurtleKoopaCollisionComponent(final MutableEntity entity, final Consumer<Entity> die) {
        super(entity);
        forDying = new ActionOnPressedCollisionComponent(entity, (__, player) -> die.accept(player));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        forDying.update(dt, collisions);
    }
}
