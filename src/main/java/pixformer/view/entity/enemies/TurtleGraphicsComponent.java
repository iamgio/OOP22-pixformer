package pixformer.view.entity.enemies;

import pixformer.model.entity.Entity;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

public class TurtleGraphicsComponent extends StaticGraphicsComponent {


    /**
     * Instantiates a graphics component for a static entity.
     *
     * @param entity the target entity
     */
    public TurtleGraphicsComponent(Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Renderer getRenderer(final RendererFactory factory) {
        return factory.newImage("/sprites/enemies/koopa_shell.png", getEntity().getWidth(), getEntity().getHeight());
    }
}
