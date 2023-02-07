package pixformer.model.joystick;

/**
 * A Joystick whose movements are left and right.
 */
public interface HorizontalJoystick extends Joystick {
    
    /**
     * Represents a left movement.
     */
    void left();

    /**
     * Represents a right movement.
     */
    void right();
}
