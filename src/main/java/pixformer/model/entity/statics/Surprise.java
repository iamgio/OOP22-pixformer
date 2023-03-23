package pixformer.model.entity.statics;

import pixformer.model.entity.*;
import pixformer.model.entity.collision.*;

import java.util.Optional;

/**
 * Surprise block, hittable block which contains a power-up, depending on the player status.
 */
public class Surprise extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;
    private boolean hasCollided;

    /**
     * Simple constructor of the Surprise block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param graphicsComponent graphics component of the surprise
     */
    public Surprise(final double x, final double y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        this.hasCollided = false;
        this.collisionComponent = new SurpriseCollisionComponent(this);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    /**
     * Set the flag representing the collision of the surprise block.
     *
     * @param hasCollided boolean representing the flag
     */
    public void setCollided(final boolean hasCollided) {
        this.hasCollided = hasCollided;
    }

    /**
     * @return if the surprise block has already collided during the game
     */
    public boolean hasCollided() {
        return this.hasCollided;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(this.collisionComponent);
    }
}
