package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An AI which makes the controlled entity goes left and right.
 */
public class SimpleAICollisionReactor implements CollisionReactor {
    private final CollisionReactor collisionReactor;

    /**
     * @param entity to be controlled.
     * @param velocityModule module of the velocity to be given to the {@code entity}
     * @param reactorConstructor the constructor of the reactor which will decide the directions.
     * @param initialBehaviour of the {@code entity}.
     */
    public SimpleAICollisionReactor(
            final MutableEntity entity,
            final double velocityModule,
            final Function<HorizontalModelInput, CollisionReactor> reactorConstructor,
            final Consumer<HorizontalModelInput> initialBehaviour) {
        final HorizontalModelInput joystick = new MaxedVelocityHorizontalModelInput(
                entity, Math.abs(velocityModule)
        );
        collisionReactor = reactorConstructor.apply(joystick);
        initialBehaviour.accept(joystick);
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        collisionReactor.react(collisions);
    }
}
