package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GoombaCollisionComponent extends CollisionComponent {

    private final SolidCollisionComponent solidCollisionComponent;
    private final CollisionReactor collisionReactor;

    public GoombaCollisionComponent(final MutableEntity entity) {
        super(entity);
        this.solidCollisionComponent = new SolidCollisionComponent(entity);
        final Consumer<Entity> kill = killer -> entity.getWorld().get().queueEntityKill(entity, killer);
        this.collisionReactor = CollisionReactorFactory.compose(
            new ActionOnPressedCollisionReactor(kill),
            new DieByTurtleCollisionReactor(kill)
        );
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        solidCollisionComponent.update(dt, collisions);
        collisionReactor.react(collisions);
    }

}
