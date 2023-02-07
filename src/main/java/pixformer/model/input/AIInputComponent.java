package pixformer.model.input;

import pixformer.model.entity.Entity;

/**
 * An AI-controlled input component.
 */
public abstract class AIInputComponent extends InputComponent {

    /**
     * Instantiates an AI-controlled input component.
     * @param entity target entity
     */
    protected AIInputComponent(final Entity entity) {
        super(entity);
    }
}
