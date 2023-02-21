package pixformer.controller.gameloop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.ControllerCommandSupplier;
import pixformer.view.ModelCommandSupplier;

/**
 * A builder for easing creating collectors of inputs with multiple
 * {@link ControllerCommandSupplier} and multiple players.
 */
public class InputCollectorBuilderImpl implements InputCollectorBuilder {

    private final Set<ControllerCommandSupplier<PauseControllerInput>> controllerInputs = new HashSet<>();
    private final Map<ModelCommandSupplier<CompleteModelInput>, CompleteModelInput> players = new HashMap<>();

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
     * @param view
     * @param model
     * @return itself.
     */
    @Override
    public InputCollectorBuilder addPlayer(
            final ModelCommandSupplier<CompleteModelInput> view,
            final CompleteModelInput model) {
        players.put(view, model);
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

                if (isRunning) {
                    players.entrySet().stream()
                            .map(e -> Map.entry(e.getKey().supplyModelCommand(), e.getValue()))
                            .filter(e -> e.getKey().isPresent())
                            .map(e -> Map.entry(e.getKey().get(), e.getValue()))
                            .forEach(e -> e.getKey().accept(e.getValue()));
                }
            }

        };
    }

}
