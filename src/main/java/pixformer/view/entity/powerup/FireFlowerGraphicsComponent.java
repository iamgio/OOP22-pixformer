package pixformer.view.entity.powerup;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

import java.util.List;

/**
 * A {@link pixformer.model.entity.GraphicsComponent} for the fire flower in the game.
 */
public class FireFlowerGraphicsComponent extends CachedAnimatedGraphicsComponent {

    private static final int SWITCH_TIME = 390;

    /**
     * Simple constructor for the collision component.
     *
     * @param entity entity target of the collision component
     */
    public FireFlowerGraphicsComponent(final Entity entity) {
        super(entity, SWITCH_TIME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Renderer> createRenderers(final RendererFactory factory) {
        return List.of(
                factory.newImage("/sprites/items/flower_1.png", getEntity().getWidth(), getEntity().getHeight()),
                factory.newImage("/sprites/items/flower_2.png", getEntity().getWidth(), getEntity().getHeight()),
                factory.newImage("/sprites/items/flower_3.png", getEntity().getWidth(), getEntity().getHeight()),
                factory.newImage("/sprites/items/flower_4.png", getEntity().getWidth(), getEntity().getHeight())
        );
    }
}
