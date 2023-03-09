package pixformer.model.entity.components;

import pixformer.model.entity.Entity;

/**
 * Generic component extended by other components.
 * A component defines a specific property of a target entity and its behaviour.
 *
 * @param <T> supported entity type
 */
public class Component<T extends Entity> {

    private final T entity;

    /**
     * @param entity Entity linked to the component.
     */
    protected Component(final T entity) {
        this.entity = entity;
    }

    /**
     * @return The target entity.
     */
    protected T getEntity() {
        return this.entity;
    }
}
