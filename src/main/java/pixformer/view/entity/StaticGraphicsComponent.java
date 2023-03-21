package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public abstract class StaticGraphicsComponent extends GraphicsComponent {

    /**
     * Instantiates a graphics component for a static entity.
     *
     * @param entity the target entity
     */
    protected StaticGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @OverridingMethodsMustInvokeSuper
    @Override
    public void update(final GameScene scene) {
        final Renderer renderer = this.getRenderer(scene.getRendererFactory());
        scene.getGraphics().draw(renderer);
    }

    /**
     * @param factory the factory to create renderers from
     * @return a list of renderers to apply at the entity
     */
    protected abstract Renderer getRenderer(RendererFactory factory);
}
