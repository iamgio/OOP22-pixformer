package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.entity.MutableEntity;
import pixformer.model.modelinput.HorizontalModelInput;

/**
 * The input component for Goomba.
 */
public class GoombaInputComponent extends SimpleAIInputComponent {
    private static final double INITIAL_VELOCITY = 0.002;

    /**
     * Instantiates an AI-controlled input component.
     *
     * @param entity target entity
     */
    public GoombaInputComponent(final MutableEntity entity) {
        super(
            entity,
            INITIAL_VELOCITY,
            HorizontalModelInput::left
        );
    }

}
