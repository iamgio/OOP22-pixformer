package pixformer.model.modelinput;

/**
 * A ModelInput whose movements are left and right.
 */
public interface HorizontalModelInput extends ModelInput {

    /**
     * Represents a left movement.
     */
    void left();

    /**
     * Represents a right movement.
     */
    void right();
}
