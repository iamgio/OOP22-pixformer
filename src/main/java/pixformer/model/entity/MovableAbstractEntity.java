package pixformer.model.entity;

import pixformer.common.Vector2D;
import pixformer.model.entity.collision.BoundingBox;

/**
 * Abstract class for moving entities.
 */
public class MovableAbstractEntity extends AbstractEntity {

    //Forza a cui è attualmente soggetta l'entità
    private Vector2D movingForce = new Vector2D(0, 0);

    /**
     * Constructor for the MovableAbstractEntity.
     * 
     * @param x         X entity position
     * @param y         Y entity position
     * @param width     Entity Width
     * @param height    Entity Height
     */
    protected MovableAbstractEntity(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
        //TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundingBox'");
    }

    /**
     * @return Current force applied to entity 
     */
    public Vector2D getForce() {
        return this.movingForce;
    }

    /**
     * Setter for the force.
     * @param force force of the vector
     */
    protected void setForce(final Vector2D force) {
        this.movingForce = force;
    }

    /**
     * Function to update player position with vectors.
     * @param newForce New vector force applied to the player.
     * @param dt delta-time passed.
     */
    protected void updatePos(final Vector2D newForce, final double dt) {
        this.setX(this.getX() + newForce.x() * dt);
        this.setY(this.getY() + newForce.y() * dt);
    }

}
