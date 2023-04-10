package pixformer.model.input;

import pixformer.model.entity.AbstractEntity;

/**
 * A user-controlled input component.
 */
public abstract class UserInputComponent extends InputComponent {

    /**
     * Instantiates a user-controlled input component.
     * 
     * @param entity target entity
     */
    public UserInputComponent(final AbstractEntity entity) {
        super(entity);
    }
}
