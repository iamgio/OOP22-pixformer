package pixformer.model.entity.powerups.other.Fireball;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.GameScene;

/**
 * Implementation of a GraphicsCopmponent for a Fireball entity.
 */
public class FireballGraphicsComponent extends GraphicsComponent {

    /**
     * Entity that will be displayed.
     * @param entity
     */
    protected FireballGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final GameScene scene) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
