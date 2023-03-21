package pixformer.view.entity.statics;

import pixformer.model.entity.statics.Brick;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class BrickGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public BrickGraphicsComponent(final Brick entity) {
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
