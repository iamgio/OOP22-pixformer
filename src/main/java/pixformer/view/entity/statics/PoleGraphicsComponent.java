package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class PoleGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the pole.
     *
     * @param entity entity with this graphic component
     */
    public PoleGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/pole.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
