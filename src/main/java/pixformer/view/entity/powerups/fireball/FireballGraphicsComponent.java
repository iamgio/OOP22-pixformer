package pixformer.view.entity.powerups.fireball;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * Implementation of a GraphicsCopmponent for a Fireball entity.
 */
public class FireballGraphicsComponent extends GraphicsComponent {

    /**
     * Entity that will be displayed.
     * @param entity
     */
    public FireballGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final GameScene scene) {
        RectangleRenderer fireballShape = scene.getRendererFactory().newRectangle(getEntity().getWidth(), getEntity().getHeight());
        fireballShape.setColor(new Color(1, 0, 0));
        scene.getGraphics().draw(fireballShape);
    }

}
