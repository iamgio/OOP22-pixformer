package pixformer.view.engine;

import pixformer.controller.input.ControllerInput;
import pixformer.model.Level;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Mapper from a raw input (keyboard, mouse, ...) to an action.
 *
 * @param <T> input type
 */
public interface InputMapper<T> {

    /**
     * @param input raw input
     * @return associated model action, if it exists
     */
    Optional<Consumer<Level>> map(T input);

    /**
     * @param input raw input
     * @return associated controller action, if it exists
     */
    Optional<ControllerInput> mapController(T input);
}
