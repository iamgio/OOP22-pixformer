package pixformer.view.engine;

import pixformer.controller.input.InputType;

import java.util.Optional;

/**
 * Mapper from a raw input (keyboard, mouse, ...) to an {@link InputType}.
 *
 * @param <T> input type
 */
public interface InputMapper<T> {

    /**
     * @param input raw input
     * @return associated input type, if it exists
     */
    Optional<InputType> map(T input);
}
