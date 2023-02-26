package pixformer.view.engine;

import pixformer.model.modelinput.ModelInput;

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
    Optional<Consumer<ModelInput>> map(T input);
}
