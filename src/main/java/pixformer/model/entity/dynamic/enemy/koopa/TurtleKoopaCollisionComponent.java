package pixformer.model.entity.dynamic.enemy.koopa;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.reactor.CollisionReactorFactory;
import pixformer.model.entity.dynamic.reactor.ActionOnPressedCollisionReactor;
import pixformer.model.entity.dynamic.reactor.DieByTurtleCollisionReactor;
import pixformer.model.entity.dynamic.reactor.MakeJumpOnPressedCollisionReactor;

import java.util.Set;
import java.util.function.Consumer;

/**
 * The collision component for a turtle koopa. The koopa dies when pressed by a player.
 */
public final class TurtleKoopaCollisionComponent extends SolidCollisionComponent {

    private final CollisionReactor reactor;

    /**
     * @param entity to be controlled.
     * @param die when called it kills the koopa. It consumes the killer.
     */
    public TurtleKoopaCollisionComponent(final MutableEntity entity, final Consumer<Entity> die) {
        super(entity);
        reactor = CollisionReactorFactory.compose(Set.of(
                new ActionOnPressedCollisionReactor(die),
                new DieByTurtleCollisionReactor(die),
                new MakeJumpOnPressedCollisionReactor()
        ));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        reactor.react(collisions);
    }
}
