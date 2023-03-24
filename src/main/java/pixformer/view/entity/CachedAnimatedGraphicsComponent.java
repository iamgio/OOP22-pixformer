package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

import java.util.List;

/**
 * An animated graphics component whose renderers are cached to optimize performance.
 */
public abstract class CachedAnimatedGraphicsComponent extends AnimatedGraphicsComponent {

    private List<Renderer> renderers;

    /**
     * Instantiates a cached timered graphics component.
     *
     * @param entity     the target entity
     * @param switchTime time (in milliseconds) to wait in order to switch with the next renderer
     */
    public CachedAnimatedGraphicsComponent(final Entity entity, final long switchTime) {
        super(entity, switchTime);
    }

    /**
     * @param factory the factory to create renderers from
     * @return a list of new renderers to continuously alternate
     */
    protected abstract List<Renderer> createRenderers(RendererFactory factory);

    /**
     * {@inheritDoc}
     * @implNote it saves the new renderers on cache at initialization
     */
    @Override
    protected List<Renderer> getRenderers(final RendererFactory factory) {
        if (this.renderers == null) {
            this.renderers = this.createRenderers(factory);
        }
        return this.renderers;
    }
}
