package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;

/**
 * Block without graphic component working as a border in the map.
 */
public class Barrier extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity {

    /**
     * Constructor for the Barrier.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width of the entity
     * @param height height of the entity
     */
    protected Barrier(double x, double y, double width, double height) {
        super(x, y, width, height);
    }
}
