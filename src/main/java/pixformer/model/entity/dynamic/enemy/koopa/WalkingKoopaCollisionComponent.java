package pixformer.model.entity.dynamic.enemy.koopa;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.reactor.CollisionReactorFactory;
import pixformer.model.entity.dynamic.reactor.ActionOnPressedCollisionReactor;
import pixformer.model.entity.dynamic.reactor.DieForFireCollisionReactor;
import pixformer.model.entity.dynamic.reactor.MakeJumpOnPressedCollisionReactor;

import java.util.Set;
import java.util.function.Consumer;

/**
 * The collision component for walking koopa.
 */
public class WalkingKoopaCollisionComponent extends SolidCollisionComponent {

    private final CollisionReactor reactor;

    /**
     * @param entity to be controlled.
     * @param changeToTurtle when invoked it transforms {@code entity} into a turtle koopa.
     * @param dieBy consume the killer, kills the controlled entity.
     */
    public WalkingKoopaCollisionComponent(final MutableEntity entity, final Consumer<Entity> changeToTurtle, final Consumer<Entity> dieBy) {
        super(entity);
        reactor = CollisionReactorFactory.compose(Set.of(
                new ActionOnPressedCollisionReactor(changeToTurtle),
                new MakeJumpOnPressedCollisionReactor(),
                new DieForFireCollisionReactor(dieBy)
        ));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        reactor.react(collisions);
    }
}
