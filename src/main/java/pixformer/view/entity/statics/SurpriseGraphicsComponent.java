package pixformer.view.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.statics.Surprise;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.StaticGraphicsComponent;

/**
 * Graphics component for the surprise block in the game.
 */
public class SurpriseGraphicsComponent extends GraphicsComponent {

    private final GraphicsComponent defaultGraphicsComponent;
    private final GraphicsComponent usedGraphicsComponent;

    /**
     * Simple constructor for the graphics component of the grass block.
     *
     * @param entity entity with this graphic component
     */
    public SurpriseGraphicsComponent(final Entity entity) {
        super(entity);
        this.defaultGraphicsComponent = new DefaultSurpriseGraphicsComponent(entity);
        this.usedGraphicsComponent = new UsedSurpriseGraphicsComponent(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameScene scene) {
        final GraphicsComponent graphicsComponent =
                getEntity() instanceof Surprise surprise && surprise.hasCollided()
                        ? this.usedGraphicsComponent
                        : this.defaultGraphicsComponent;
        graphicsComponent.update(scene);
    }

    /**
     * Nested class representing the default graphics component of the surprise block.
     */
    private static class DefaultSurpriseGraphicsComponent extends StaticGraphicsComponent {

        /**
         * Simple constructor for the graphics component.
         *
         * @param entity entity target of the graphics component
         */
        protected DefaultSurpriseGraphicsComponent(final Entity entity) {
            super(entity);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Renderer getRenderer(final RendererFactory factory) {
            return factory.newImage("/sprites/blocks/surprise.png", getEntity().getWidth(), getEntity().getHeight());
        }
    }

    /**
     * Nested class representing the graphics component of the used surprise block.
     */
    private static class UsedSurpriseGraphicsComponent extends StaticGraphicsComponent {

        /**
         * Simple constructor for the graphics component.
         *
         * @param entity entity target of the graphics component
         */
        protected UsedSurpriseGraphicsComponent(final Entity entity) {
            super(entity);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Renderer getRenderer(final RendererFactory factory) {
            return factory.newImage("/sprites/blocks/block.png", getEntity().getWidth(), getEntity().getHeight());
        }
    }
}
