package pixformer.model.entity.dynamic.enemy.goomba;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.reactor.ActionOnPressedCollisionReactor;
import pixformer.model.entity.dynamic.reactor.CollisionReactorFactory;
import pixformer.model.entity.dynamic.reactor.MakeJumpOnPressedCollisionReactor;
import pixformer.model.entity.dynamic.reactor.DieByTurtleCollisionReactor;
import pixformer.model.entity.dynamic.reactor.DieForFireCollisionReactor;

import java.util.Set;
import java.util.function.Consumer;

/**
 * A {@link pixformer.model.entity.collision.CollisionComponent} for the goomba.
 */
public class GoombaCollisionComponent extends SolidCollisionComponent {
    private final CollisionReactor collisionReactor;

    /**
     * Simple constructor for the collision component.
     *
     * @param entity entity target
     */
    public GoombaCollisionComponent(final MutableEntity entity) {
        super(entity);
        final Consumer<Entity> kill = killer -> entity.getWorld().get().queueEntityKill(entity, killer);
        this.collisionReactor = CollisionReactorFactory.compose(Set.of(
            new ActionOnPressedCollisionReactor(kill),
            new MakeJumpOnPressedCollisionReactor(),
            new DieByTurtleCollisionReactor(kill),
            new DieForFireCollisionReactor(kill)
        ));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        collisionReactor.react(collisions);
    }

}
