package pixformer.model.entity.statics;

import pixformer.model.entity.Entity;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.PowerUpFactory;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.model.entity.collision.SurpriseCollisionComponent;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Optional;

/**
 * Surprise block, hittable block which contains a power-up, depending on the player status.
 */
public final class Surprise extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;
    private final PowerUpFactory entityFactory;
    private boolean hasCollided;

    /**
     * Simple constructor of the Surprise block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param graphicsComponent graphics component of the surprise
     * @param entityFactory factory for the power-up to spawn
     */
    public Surprise(final double x, final double y, final GraphicsComponentRetriever graphicsComponent,
                    final PowerUpFactory entityFactory) {
        super(x, y, WIDTH, HEIGHT);
        this.hasCollided = false;
        this.entityFactory = entityFactory;
        this.collisionComponent = new SurpriseCollisionComponent(this, this::powerupSpawnBehaviour);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    private void powerupSpawnBehaviour(final Entity entity) {
        if (entity instanceof Player player && getWorld().isPresent()) {
            if (player.getPowerupBehaviour().isEmpty()) {
                getWorld().get().queueEntitySpawn(entityFactory.createMushroom((int) getX(), (int) getY() - 1));
            } else {
                getWorld().get().queueEntitySpawn(entityFactory.createFireFlower((int) getX(), (int) getY() - 1));
            }
            this.hasCollided = true;
        }
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
