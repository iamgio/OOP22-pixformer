package pixformer.view.entity.statics;

import pixformer.model.entity.statics.Block;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class BlockGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the indestructible block.
     *
     * @param entity entity with this graphic component
     */
    public BlockGraphicsComponent(final Block entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/block.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
