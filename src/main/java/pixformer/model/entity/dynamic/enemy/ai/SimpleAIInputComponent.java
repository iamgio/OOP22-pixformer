package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.OnlyXVelocitySetter;
import pixformer.model.entity.dynamic.enemy.HorizontalModelInputImpl;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.function.Consumer;

/**
 * An AI which makes the controlled entity goes left and right.
 */
public class SimpleAIInputComponent extends AIInputComponent {
    private final CollisionReactor collisionReactor;

    /**
     * @param entity to be controlled.
     * @param velocityModule module of the velocity to be given to the {@code entity}
     * @param initialBehaviour of the {@code entity}.
     */
    public SimpleAIInputComponent(
            final MutableEntity entity,
            final double velocityModule,
            final Consumer<HorizontalModelInput> initialBehaviour) {
        super(entity);
        final var joystick = new HorizontalModelInputImpl(new OnlyXVelocitySetter(entity), velocityModule);
        collisionReactor = new SimpleAICollisionReactor(joystick, initialBehaviour);
    }

    @Override
    public void update(final World world) {
        final var collisions = world.getCollisionManager().findCollisionsFor(getEntity());
        collisionReactor.react(collisions);
    }
}
