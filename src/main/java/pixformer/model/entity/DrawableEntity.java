package pixformer.model.entity;

/**
 * In-Game entity that can be drawn.
 */
public interface DrawableEntity extends Entity {

    /**
     * @return the entity's graphicsComponent
     */
    GraphicsComponent getGraphicsComponent();

}
