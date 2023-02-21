package pixformer.controller;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.World;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.modelinput.ModelInput;
import pixformer.view.ControllerCommandSupplier;
import pixformer.view.ModelCommandSupplier;
import pixformer.view.View;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A builder for easing creating controllers with multiple
 * {@link ControllerCommandSupplier} and multiple players.
 */
public class GameLoopBuilder {

    private final World world;
    private final View view;
    private final Set<ControllerCommandSupplier<PauseControllerInput>> controllerInputs = new HashSet<>();
    private final Set<Map.Entry<CompleteModelInput, ModelCommandSupplier<CompleteModelInput>>> players = new HashSet<>();

    /**
     * Construct a builder and setup the view.
     * 
     * @param view responsible for the output.
     */
    public GameLoopBuilder(final World world, final View view) {
        this.world = world;
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
     * @param model
     * @return itself.
     */
    public GameLoopBuilder addPlayer(
            final CompleteModelInput model,
            final ModelCommandSupplier<CompleteModelInput> supplier) {
        players.add(Map.entry(model, supplier));
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
                if (!isRunning) {
                    return;
                }

                controllerInputs.stream()
                        .flatMap(i -> i.supplyControllerCommand().stream())
                        .forEach(i -> i.accept(mockController));

                for (var entry : players) {
                    var command = entry.getValue().supplyModelCommand();
                    command.ifPresent(cmd -> cmd.accept(entry.getKey()));
                }

                view.update(0 /* TODO delta time */);

                world.getEntities().forEach(entity -> {
                    view.getScene().getGraphics().setTranslate(entity.getX(), entity.getY());
                    entity.getGraphicsComponent().ifPresent(graphics -> graphics.update(view.getScene()));
                });
            }
        };
    }

}
