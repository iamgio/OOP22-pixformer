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
 * {@inheritDoc}
 */
public class SimpleAIInputComponent extends GeneralAIInputComponent {

    /**
     * @param entity to be controlled.
     * @param velocityModule module of the velocity to be given to the {@code entity}
     * @param initialBehaviour of the {@code entity}.
     */
    public SimpleAIInputComponent(
            final MutableEntity entity,
            final double velocityModule,
            final Consumer<HorizontalModelInput> initialBehaviour) {
        super(entity, velocityModule,  initialBehaviour, collision -> collision.entity().isSolid());
    }
}
