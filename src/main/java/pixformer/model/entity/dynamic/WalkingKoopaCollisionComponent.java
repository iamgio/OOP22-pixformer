package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;

import java.util.Set;
import java.util.function.Consumer;

public class WalkingKoopaCollisionComponent extends SolidCollisionComponent {

    private final CollisionReactor reactor;
    public WalkingKoopaCollisionComponent(final MutableEntity entity, final Consumer<Entity> changeToTurtle) {
        super(entity);
        reactor = CollisionReactorFactory.compose(Set.of(
                new ActionOnPressedCollisionReactor(changeToTurtle),
                new MakeJumpOnPressedCollisionReactor()
        ));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
    }
}
