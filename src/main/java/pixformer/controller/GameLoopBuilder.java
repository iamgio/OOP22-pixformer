package pixformer.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.ControllerCommandSupplier;
import pixformer.view.ModelCommandSupplier;
import pixformer.view.View;

/**
 * A builder for easing creating controllers with multiple
 * {@link ControllerCommandSupplier} and multiple players.
 */
public class GameLoopBuilder {

    private final View view;
    private final Set<ControllerCommandSupplier<PauseControllerInput>> controllerInputs = new HashSet<>();
    private final Map<ModelCommandSupplier<CompleteModelInput>, CompleteModelInput> players = new HashMap<>();

    /**
     * Construct a builder and setup the view.
     * 
     * @param view responsible for the output.
     */
    public GameLoopBuilder(final View view) {
        this.view = view;
        this.view.setup();
    }

    /**
     * Add a {@link ControllerCommandSupplier} to the building controller.
     * 
     * @param controllerInput to be added
     * @return itself.
     */
    public GameLoopBuilder addControllerInput(final ControllerCommandSupplier<PauseControllerInput> controllerInput) {
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
    public GameLoopBuilder addPlayer(
            final ModelCommandSupplier<CompleteModelInput> view,
            final CompleteModelInput model) {
        players.put(view, model);
        return this;
    }

    /**
     * Builds a new controller.
     * 
     * @return the new controller.
     */
    public GameLoop build() {
        return new GameLoop() {

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
            public void loop(final long now) {
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
                view.update(0 /* TODO delta time */);
            }

        };
    }

}
