package pixformer.model.input;

import pixformer.model.entity.AbstractEntity;

/**
 * A tagging abstract class which represents AI-controlled input component.
 */
public abstract class AIInputComponent extends InputComponent {

    /**
     * Instantiates an AI-controlled input component.
     * @param entity target entity
     */
    protected AIInputComponent(final AbstractEntity entity) {
        super(entity);
    }
}
