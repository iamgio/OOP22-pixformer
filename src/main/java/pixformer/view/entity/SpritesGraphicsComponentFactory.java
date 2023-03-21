package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentFactory;
import pixformer.view.entity.enemies.GoombaGraphicsComponent;

/**
 * A factory of graphics component represented by sprite images.
 */
public class SpritesGraphicsComponentFactory implements GraphicsComponentFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent goomba(final Entity entity) {
        return new GoombaGraphicsComponent(entity);
    }
}
