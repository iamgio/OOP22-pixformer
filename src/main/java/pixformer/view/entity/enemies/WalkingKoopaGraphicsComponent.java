package pixformer.view.entity.enemies;

import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.entity.CachedAnimatedGraphicsComponent;

import java.util.List;

/**
 * A {@link pixformer.model.entity.GraphicsComponent} for the default koopa.
 */
public class WalkingKoopaGraphicsComponent extends GraphicsComponent {

    private final GraphicsComponent goingLeft;
    private final GraphicsComponent goingRight;

    /**
     * Instantiates a cached timered graphics component.
     *
     * @param entity the target entity
     */
    public WalkingKoopaGraphicsComponent(final Entity entity) {
        super(entity);
        this.goingLeft = new WalkingKoopaOrientationGraphicsComponent(entity, false);
        this.goingRight = new WalkingKoopaOrientationGraphicsComponent(entity, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameScene scene) {
        (getEntity().getVelocity().x() < 0 ? goingLeft : goingRight).update(scene);
    }

    private static class WalkingKoopaOrientationGraphicsComponent extends CachedAnimatedGraphicsComponent {

        private static final int SWITCH_TIME = 200;

        private final boolean flipped;

        /**
         * @param entity the target entity
         * @param flipped whether the sprite should be horizontally flipped
         */
        WalkingKoopaOrientationGraphicsComponent(final Entity entity, final boolean flipped) {
            super(entity, SWITCH_TIME);
            this.flipped = flipped;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected List<Renderer> createRenderers(final RendererFactory factory) {
            return List.of(
                    factory.newImage("/sprites/enemies/koopa1.png", getEntity().getWidth(), getEntity().getHeight(), flipped),
                    factory.newImage("/sprites/enemies/koopa2.png", getEntity().getWidth(), getEntity().getHeight(), flipped)
            );
        }
    }
}
