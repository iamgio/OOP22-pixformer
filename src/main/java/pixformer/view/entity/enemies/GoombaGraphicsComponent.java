package pixformer.view.entity.enemies;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

import java.util.List;

/**
 * The graphics component of a Goomba.
 */
public class GoombaGraphicsComponent extends CachedAnimatedGraphicsComponent {

    private static final long SWITCH_TIME = 200;

    /**
     * @param entity the target entity
     */
    public GoombaGraphicsComponent(final Entity entity) {
        super(entity, SWITCH_TIME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Renderer> createRenderers(final RendererFactory factory) {
        return List.of(
                factory.newImage("/sprites/enemies/goomba1.png", getEntity().getWidth(), getEntity().getHeight()),
                factory.newImage("/sprites/enemies/goomba2.png", getEntity().getWidth(), getEntity().getHeight())
        );
    }
}
