package pixformer.model.entity.dynamic.player;

import pixformer.view.engine.Color;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * Implementation of GraphicComponent for a Player entity.
 */
public class PlayerGraphicsComponent extends GraphicsComponent {

    private Player player;

    private boolean isAlive = true;

    /**
     * 
     * @param player Player entity who will be displayed.
     */
    protected PlayerGraphicsComponent(final Player player) {
        super(player);
        this.player = player;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final GameScene scene) {
        System.out.println(player.getX() + " " + player.getY());
        if (this.isAlive) {
            RectangleRenderer playerShape = scene.getRendererFactory().newRectangle(player.getWidth(), player.getHeight());
            playerShape.setColor(new Color(1, 1, 1));
            scene.getGraphics().draw(playerShape);
        }
    }

    /**
     * Describe what happens on Player death.
     */
    public void startDeathAnimation() {
        isAlive = false;
    }

}
