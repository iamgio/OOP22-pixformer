package pixformer.model.input;

import pixformer.model.World;
import pixformer.model.entity.Entity;

/**
 * A tagging abstract class which represents AI-controlled input component.
 */
public abstract class AIInputComponent extends InputComponent {

    /**
     * Instantiates an AI-controlled input component.
     * @param entity target entity
     */
    protected AIInputComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Update the behaviour of the ai according to the current state of the {@code World}.
     * @param world the current world.
     */
    public abstract void update(World world);
}
