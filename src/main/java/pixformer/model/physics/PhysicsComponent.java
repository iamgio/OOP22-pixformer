package pixformer.model.physics;

import pixformer.common.Vector2D;

/**
 * PhysicComponent of an Entity.
 */
public interface PhysicComponent {

    /**
     * @return the gravity
     */
    Vector2D getGravity();

    /**
     * Set the gravity of the component.
     * 
     * @param vector intensity of the gravity
     */
    void setGravity(Vector2D vector);

}
