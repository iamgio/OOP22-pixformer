package pixformer.model.entity;

import pixformer.model.entity.components.Component;
import pixformer.view.engine.GameScene;

/**
 * An entity's component responsible for its rendering on screen,
 * or another output.
 */
public abstract class GraphicsComponent extends Component<Entity> {

    /**
     * Instantiates a graphics component.
     *
     * @param entity the target entity
     */
    protected GraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * Updates the game scene with the content to draw.
     * 
     * @param scene game scene to draw on
     */
    public abstract void update(GameScene scene);
}
