package pixformer.model.input;

import pixformer.model.World;
import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.components.Component;
import pixformer.model.modelinput.ModelInput;

/**
 * Represents an input source for an {@link Entity}.
 */
public abstract class InputComponent extends Component<MutableEntity> implements ModelInput {

    /**
     * Instantiates an input component.
     * @param entity target entity
     */
    protected InputComponent(final MutableEntity entity) {
        super(entity);
    }

    /**
     * Update the behaviour of the ai according to the current state of the {@code World}.
     * @param world the current world.
     */
    public abstract void update(World world);
}
