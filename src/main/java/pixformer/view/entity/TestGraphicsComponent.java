package pixformer.view.entity;

import pixformer.model.entity.TestEntity;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RectangleRenderer;

/**
 * @deprecated test
 */
public class TestGraphicsComponent implements GraphicsComponent {

    private final TestEntity entity;

    /**
     * Instantiates a graphics component for a test entity.
     * @param entity test entity
     */
    public TestGraphicsComponent(final TestEntity entity) {
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameScene scene) {
        final RectangleRenderer rect = scene.getRendererFactory().newRectangle(entity.getWidth(), entity.getHeight());
        rect.setColor(new Color(1, 0, 0));
        scene.getGraphics().draw(rect);
    }
}
