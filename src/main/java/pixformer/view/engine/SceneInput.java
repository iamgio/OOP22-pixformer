package pixformer.view.engine;

import pixformer.model.Level;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * An input source for a {@link GameScene}.
 *
 * @param <T> raw input type (e.g. a framework-specific keyboard enum)
 */
public interface SceneInput<T> {

    /**
     * Adds an input to the polling.
     * @param input input to add
     */
    void addInput(T input);

    /**
     * Removes an input from the polling.
     * @param input input to remove
     */
    void removeInput(T input);

    /**
     * @return the active unmapped inputs
     */
    Set<T> getRawPolling();

    /**
     * @return the mapper from raw inputs to actual actions
     */
    InputMapper<T> getMapper();

    /**
     * @return the active inputs mapped to their actions
     */
    default Set<Consumer<Level>> getMappedPolling() {
        return this.getRawPolling().stream()
                .map(this.getMapper()::map)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
