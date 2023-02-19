package pixformer.controller.gameloop;

/**
 * It collects all the inputs and
 * - elaborates all the {@link pixformer.controller.input.ControllerInput}
 * commands
 * - redirects the {@link pixformer.model.modelinput.ModelInput} commands to the
 * corresponding {@code ModelInput}
 */
public interface InputCollector {

    /**
     * Execute the aforementioned operations.
     */
    void execute();
}
