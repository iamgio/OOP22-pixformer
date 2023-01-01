package pixformer.view.engine;

import pixformer.controller.InputType;

import java.util.Map;
import java.util.Optional;

/**
 * Mapper from a raw input (keyboard, mouse, ...) to an {@link InputType}.
 */
public class InputMapper<T> {

    private final Map<T, InputType> controls;

    /**
     * Creates an input mapper with given bindings.
     * @param controls input bindings
     */
    public InputMapper(Map<T, InputType> controls) {
        this.controls = controls;
    }

    /**
     * @param input raw input
     * @return associated input type, if it exists
     */
    public Optional<InputType> get(T input) {
        return Optional.ofNullable(this.controls.get(input));
    }
}
