package pixformer.controller;

/**
 * A container for currently active user inputs.
 */
public interface InputPolling {

    /**
     * Sets an input as currently active.
     * @param input input to store
     */
    void add(InputType input);

    /**
     * Sets an input as currently inactive.
     * @param input input to release
     */
    void remove(InputType input);

    /**
     * @param input input to check
     * @return whether the input is currently active
     */
    boolean contains(InputType input);
}
