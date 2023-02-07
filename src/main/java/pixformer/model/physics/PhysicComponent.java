package pixformer.model.physics;

/**
 * PhysicComponent of a Entity.
 */
public interface PhysicComponent {

    /**
     * @return the gravity
     */
    double getGravity();

    /**
     * Set the gravity of the component.
     */
    void setGravity();

}
