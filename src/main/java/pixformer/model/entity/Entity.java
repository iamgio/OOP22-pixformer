package pixformer.model.entity;

import pixformer.view.entity.GraphicsComponent;

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
     * @return the component responsible for drawing this entity on screen
     */
    Optional<GraphicsComponent> getGraphicsComponent();
}
