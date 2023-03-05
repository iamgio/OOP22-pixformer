package pixformer.model.entity;

import pixformer.model.World;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.input.InputComponent;

import java.util.Optional;

/**
 * In-Game entity.
 */
public interface Entity {

    /**
     * @return X coordinate
     */
    double getX();

    /**
     * Set the X coordinate.
     * @param x coordinate
     */
    void setX(double x);

    /**
     * @return Y coordinate
     */
    double getY();

    /**
     * Set the Y coordinate.
     * @param y coordinate
     */
    void setY(double y);

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

    /**
     * @return the world in which the Entity lives.
     */
    World getWorld();

    /**
     * @return the input component of the entity
     */
    default Optional<InputComponent> getInputComponent() {
        return Optional.empty();
    }

    /**
     * Called when this entity is added onto a game world.
     * @param world game world the entity spawned on
     */
    default void onSpawn(World world) {

    }
}
