package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

/**
 * Graphics component for the brick in the game.
 */
public class BrickGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public BrickGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/brick.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
