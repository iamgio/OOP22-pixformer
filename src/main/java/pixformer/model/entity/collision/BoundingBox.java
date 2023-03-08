package pixformer.model.entity.collision;

import java.util.Optional;

/**
 * Represents the 2D space occupied by a game entity.
 */
public interface BoundingBox {

    /**
     * Checks for collisions with another bounding box.
     * @param other other bounding box to look for collision with
     * @param x1 X coordinate of this bounding box
     * @param y1 Y coordinate of this bounding box
     * @param x2 X coordinate of the other bounding box
     * @param y2 Y coordinate of the other bounding box
     * @return the side the two bounding boxes (at the given coordinates) collide at, if it exists
     */
    Optional<CollisionSide> getCollisionSide(BoundingBox other, double x1, double y1, double x2, double y2);
}
