package pixformer.view.entity;

import pixformer.common.time.Chronometer;
import pixformer.common.time.ChronometerImpl;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.List;

/**
 * A graphics component that continuously alternates renderers after a specified amount of time.
 */
public abstract class AnimatedGraphicsComponent extends GraphicsComponent {

    private final Chronometer chronometer = new ChronometerImpl();
    private final long switchTime;

    private int index;

    /**
     * Instantiates a timered graphics component.
     *
     * @param entity the target entity
     * @param switchTime time (in milliseconds) to wait in order to switch with the next renderer
     */
    public AnimatedGraphicsComponent(final Entity entity, final long switchTime) {
        super(entity);
        this.switchTime = switchTime;
    }

    /**
     * {@inheritDoc}
     */
    @OverridingMethodsMustInvokeSuper
    @Override
    public void update(final GameScene scene) {
        final List<Renderer> renderers = this.getRenderers(scene.getRendererFactory());
        if (chronometer.hasElapsed(switchTime) || !chronometer.isRunning()) {
            chronometer.reset();
            chronometer.start();
            index = (index + 1) % renderers.size();
        } else if (index >= renderers.size()) {
            // In case the renderers list is dynamic, in order to avoid out of bounds accesses.
            index = 0;
        }
        scene.getGraphics().draw(renderers.get(index));
    }

    /**
     * @param factory the factory to create renderers from
     * @return a list of renderers to continuously alternate
     */
    protected abstract List<Renderer> getRenderers(RendererFactory factory);
}
