package pixformer.view.entity.powerup;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class MushroomGraphicsComponent extends StaticGraphicsComponent {

    /**
     * Simple constructor for the graphics component of the mushroom
     *
     * @param entity entity target of the graphics component
     */
    public MushroomGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/items/red_mushroom.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
