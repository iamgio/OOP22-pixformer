package pixformer.model.entity;

import pixformer.model.entity.collision.BoundingBox;

/**
 * In-Game entity.
 */
public interface Entity {

    /**
     * @return X coordinate
     */
    double getX();

    /**
     * @return Y coordinate
     */
    double getY();

    /**
     * @return the width of the entity
     */
    double getWidth();

    /**
     * @return the height of the entity
     */
    double getHeight();

    /**
     * @return the bounding box of the entity
     */
    BoundingBox getBoundingBox();
}
