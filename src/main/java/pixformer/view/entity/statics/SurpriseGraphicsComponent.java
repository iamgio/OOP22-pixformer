package pixformer.view.entity.statics;

import pixformer.model.entity.statics.Surprise;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class SurpriseGraphicsComponent extends StaticGraphicsComponent {

    private final Surprise surprise;

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public SurpriseGraphicsComponent(final Surprise entity) {
        super(entity);
        this.surprise = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/blocks/surprise.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
