package pixformer.model.input;

import pixformer.model.entity.Entity;

/**
 * Represents an input source for an {@link Entity}.
 */
public abstract class InputComponent {

    private final Entity entity;

    /**
     * Instantiates an input component.
     * @param entity target entity
     */
    protected InputComponent(final Entity entity) {
        this.entity = entity;
    }

    /**
     * @return the target entity
     */
    protected Entity getEntity() {
        return this.entity;
    }
}
