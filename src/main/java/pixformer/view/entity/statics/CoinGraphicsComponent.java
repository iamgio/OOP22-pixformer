package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

/**
 * {@link pixformer.model.entity.GraphicsComponent} for the coin in the game.
 */
public class CoinGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the coin.
     *
     * @param entity entity with this graphic component
     */
    public CoinGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/items/coin.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
