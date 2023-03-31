package pixformer.model.entity.dynamic.enemy;


import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

/**
 * The default implementation of an enemy.
 */
public class EnemyImpl extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, Enemy {
    private final double velocityModule;

    /**
     * Create a Goomba at position ({@code x}, {@code y}).
     * 
     * @param x coordinate
     * @param y coordinate.
     * @param width of the Enemy.
     * @param height of the Enemy.
     * @param velocity the module of the velocity of the Enemy.
     */
    public EnemyImpl(final double x, final double y, final double width, final double height, final double velocity) {
        super(x, y, width, height);
        this.velocityModule = velocity;
    }

    /**
     * Velocity setter which guarantees that the velocity module of this entity will be less than {@code velocity}.
     * @param velocity the new value of the velocity.
     */
    protected final void fixVelocity(final Vector2D velocity) {
        final double newX = velocity.x();
        final double oldX = getVelocity().x();
        setVelocity(getVelocity().copyWithX(oldX > 0
                ? Math.min(velocityModule, newX) : Math.max(-velocityModule, newX)
        ));
    }
}
