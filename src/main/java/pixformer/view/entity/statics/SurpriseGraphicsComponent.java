package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.model.entity.statics.Surprise;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

/**
 * Graphics component for the surprise block in the game.
 */
public class SurpriseGraphicsComponent extends StaticGraphicsComponent {

    private final Surprise surprise;

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public SurpriseGraphicsComponent(final Entity entity) {
        super(entity);
        this.surprise = entity instanceof Surprise ? (Surprise) entity : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        if (surprise.hasCollided()) {
            return factory.newImage("/sprites/blocks/marble.png", getEntity().getWidth(), getEntity().getHeight());
        }
        return factory.newImage("/sprites/blocks/surprise.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
