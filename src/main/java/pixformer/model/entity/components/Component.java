package pixformer.model.entity.components;

import pixformer.model.entity.Entity;

/**
 * Generic component extended by other components.
 */
public class Component {

    private final Entity entity;

    /**
     * 
     * @param entity Entity linked to the component.
     */
    protected Component(final Entity entity) {
        this.entity = entity;
    }

    /**
     * @return The target entity.
     */
    public Entity getEntity() {
        return this.entity;
    }
}
