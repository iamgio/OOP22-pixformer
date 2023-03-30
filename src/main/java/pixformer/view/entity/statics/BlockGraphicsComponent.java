package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

/**
 * Graphics component for the generic block in the game.
 */
public class BlockGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the indestructible block.
     *
     * @param entity entity with this graphic component
     */
    public BlockGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/marble.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
