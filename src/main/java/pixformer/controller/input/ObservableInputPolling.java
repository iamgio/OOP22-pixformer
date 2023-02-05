package pixformer.controller.input;

import pixformer.common.Updatable;

/**
 * An {@link InputPolling} that allows observing inputs of specified types.
 */
public interface ObservableInputPolling extends InputPolling, Updatable {

    /**
     * Registers a task executed as long as the input is active.
     * @param input input type to observe
     * @param action task to execute
     */
    void addAction(InputType input, Runnable action);
}
