package pixformer.controller.gameloop;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.ModelInput;
import pixformer.view.ControllerCommandSupplier;
import pixformer.view.ModelCommandSupplier;

import java.util.HashSet;
import java.util.Set;

/**
 * A builder for easing creating collectors of inputs with multiple
 * {@link ControllerCommandSupplier} and multiple players.
 */
public class InputCollectorBuilderImpl implements InputCollectorBuilder {

    private final Set<ControllerCommandSupplier<PauseControllerInput>> controllerInputs = new HashSet<>();
    private final Set<Runnable> playersHandlers = new HashSet<>();
    private final Set<Runnable> inputClearers = new HashSet<>();

    /**
     * Add a {@link ControllerCommandSupplier} to the building controller.
     * 
     * @param controllerInput to be added
     * @return itself.
     */
    @Override
    public InputCollectorBuilder addControllerInput(
            final ControllerCommandSupplier<PauseControllerInput> controllerInput) {
        controllerInputs.add(controllerInput);
        return this;
    }

    /**
     * Add a player to the controller, which means adding a pair of
     * {@link ModelCommandSupplier} and {@link ModelInput}.
     * 
     * @param model
     * @return itself.
     */
    @Override
    public <M extends ModelInput> InputCollectorBuilder addPlayer(final M model, final ModelCommandSupplier<M> view) {
        playersHandlers.add(() -> view.supplyModelCommand().ifPresent(s -> s.accept(model)));
        inputClearers.add(view::clear);
        return this;
    }
    
    
    /**
     * Builds a new input collector.
     * 
     * @return the new input collector.
     */
    @Override
    public InputCollector build() {
        return new InputCollector() {

            private boolean isRunning = true;
            private final PauseControllerInput mockController = new PauseControllerInput() {

                @Override
                public void pause() {
                    isRunning = false;
                }

                @Override
                public void unpause() {
                    isRunning = true;
                }

            };

            @Override
            public void execute() {
                controllerInputs.stream()
                        .flatMap(i -> i.supplyControllerCommand().stream())
                        .forEach(i -> i.accept(mockController));

                if (!isRunning) {
                    return;
                }

                playersHandlers.forEach(Runnable::run);
                inputClearers.forEach(Runnable::run);
            }

        };
    }


}
