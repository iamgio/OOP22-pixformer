package pixformer.view.entity.powerups.fireball;

import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.powerups.other.Fireball.Fireball;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * Implementation of a GraphicsCopmponent for a Fireball entity.
 */
public class FireballGraphicsComponent extends GraphicsComponent {
    private Fireball fireball;

    /**
     * @param fireball Entity that will be displayed.
     */
    public FireballGraphicsComponent(final Fireball fireball) {
        super(fireball);

        this.fireball = fireball;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final GameScene scene) {
        RectangleRenderer fireballShape = scene.getRendererFactory().newRectangle(fireball.getWidth(), fireball.getHeight());
        fireballShape.setColor(new Color(1, 0, 0));
        scene.getGraphics().draw(fireballShape);
    }

}
