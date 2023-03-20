package pixformer.view.entity.powerups.fireball;

import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.powerups.other.fireball.Fireball;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * Implementation of a GraphicsCopmponent for a Fireball entity.
 */
public class FireballGraphicsComponent extends GraphicsComponent {
    private final double width;
    private final double height;

    /**
     * @param fireball Entity that will be displayed.
     */
    public FireballGraphicsComponent(final Fireball fireball) {
        super(fireball);

        this.width = fireball.getWidth();
        this.height = fireball.getHeight();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final GameScene scene) {
        final RectangleRenderer fireballShape = scene.getRendererFactory().newRectangle(width, height);
        fireballShape.setColor(new Color(1, 0, 0));
        scene.getGraphics().draw(fireballShape);
    }

}
