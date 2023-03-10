package pixformer.model.input;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.components.Component;
import pixformer.model.modelinput.ModelInput;

/**
 * Represents an input source for an {@link Entity}.
 */
public abstract class InputComponent extends Component<AbstractEntity> implements ModelInput {

    /**
     * Instantiates an input component.
     * @param entity target entity
     */
    protected InputComponent(final AbstractEntity entity) {
        super(entity);
    }
}
