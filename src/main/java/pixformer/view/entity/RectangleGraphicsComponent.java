package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * Represent as a rectangle of dimensions proportional to the Entity to be
 * represented.
 */
public class RectangleGraphicsComponent extends GraphicsComponent {

    private Color color;

    /**
     * Instantiates a graphics component for a test entity.
     * 
     * @param entity test entity
     * @param color color of the rectangle
     */
    public RectangleGraphicsComponent(final Entity entity, final Color color) {
        super(entity);
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameScene scene) {
        final Entity entity = super.getEntity();
        final RectangleRenderer rect = scene.getRendererFactory().newRectangle(entity.getWidth(), entity.getHeight());
        rect.setColor(color);
        scene.getGraphics().draw(rect);
    }
}
