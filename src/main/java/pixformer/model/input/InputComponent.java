package pixformer.model.input;

import pixformer.common.Updatable;
import pixformer.model.entity.Entity;

/**
 * Represents an input source for an {@link Entity}.
 */
public abstract class InputComponent implements Updatable {

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
