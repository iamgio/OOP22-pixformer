package pixformer.view.entity;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * @deprecated test
 */
@Deprecated
public class TestGraphicsComponent extends GraphicsComponent {

    /**
     * Instantiates a graphics component for a test entity.
     * @param entity test entity
     */
    public TestGraphicsComponent(final Entity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameScene scene) {
        final Entity entity = super.getEntity();
        final RectangleRenderer rect = scene.getRendererFactory().newRectangle(entity.getWidth(), entity.getHeight());
        rect.setColor(new Color(1, 0, 0));
        scene.getGraphics().draw(rect);
    }
}
