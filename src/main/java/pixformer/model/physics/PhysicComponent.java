package pixformer.model.physics;

/**
 * PhysicComponent of an Entity.
 */
public interface PhysicComponent {

    /**
     * @return the gravity
     */
    double getGravity();

    /**
     * Set the gravity of the component.
     * @param value intensity of the gravity
     */
    void setGravity(double value);

}
