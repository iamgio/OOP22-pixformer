package pixformer.model.entity.components;

import javax.swing.text.html.parser.Entity;

/**
 * Generic component.
 */
public abstract class AbstractComponent {
    private final Entity entity;

    /**
     * 
     * @param entity Entity linked to the component.
     */
    protected AbstractComponent(final Entity entity) {
        this.entity = entity;
    }

    /**
     * @return the target entity.
     */
    public Entity getEntity() {
        return this.entity;
    }
}
