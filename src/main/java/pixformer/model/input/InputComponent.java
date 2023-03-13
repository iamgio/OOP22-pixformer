package pixformer.model.input;

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
}
