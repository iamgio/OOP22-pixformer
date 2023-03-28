package pixformer.view.entity.enemies;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

import java.util.List;

/**
 * A {@link pixformer.model.entity.GraphicsComponent} for the default koopa.
 */
public class WalkingKoopaGraphicsComponent extends CachedAnimatedGraphicsComponent {

    private static final int SWITCH_TIME = 200;

    /**
     * Instantiates a cached timered graphics component.
     *
     * @param entity the target entity
     */
    public WalkingKoopaGraphicsComponent(final Entity entity) {
        super(entity, SWITCH_TIME);
    }

    /**
     * {@inheritDoc}
     */
     @Override
     protected List<Renderer> createRenderers(final RendererFactory factory) {
        return List.of(
             factory.newImage("/sprites/enemies/koopa1.png", getEntity().getWidth(), getEntity().getHeight()),
             factory.newImage("/sprites/enemies/koopa2.png", getEntity().getWidth(), getEntity().getHeight())
        );
     }
}
