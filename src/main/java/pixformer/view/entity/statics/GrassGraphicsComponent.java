package pixformer.view.entity.statics;

import pixformer.model.entity.statics.Block;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class GrassGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public GrassGraphicsComponent(final Block entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/used_brick.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
