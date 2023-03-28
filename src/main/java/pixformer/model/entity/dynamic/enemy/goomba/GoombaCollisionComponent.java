package pixformer.model.entity.dynamic.enemy.goomba;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.reactor.*;

import java.util.Set;
import java.util.function.Consumer;

public class GoombaCollisionComponent extends SolidCollisionComponent {
    private final CollisionReactor collisionReactor;

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

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        collisionReactor.react(collisions);
    }

}
