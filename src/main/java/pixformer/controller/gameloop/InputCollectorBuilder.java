package pixformer.controller.gameloop;

import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.ModelInput;
import pixformer.view.ControllerCommandSupplier;
import pixformer.view.ModelCommandSupplier;

/**
 * A builder for easing creating collectors of inputs with multiple
 * {@link ControllerCommandSupplier} and multiple players.
 */
public interface InputCollectorBuilder {

        /**
         * Add a {@link ControllerCommandSupplier} to the building controller.
         * 
         * @param controllerInput to be added
         * @return itself.
         */
        InputCollectorBuilder addControllerInput(
                        ControllerCommandSupplier<PauseControllerInput> controllerInput);

        /**
         * Add a player to the controller, which means adding a pair of
         * {@link ModelCommandSupplier} and {@link ModelInput}.
         * 
         * @param <M> the type of the model which will receive the commands
         * @param view
         * @param model
         * @return itself.
         */
        <M extends ModelInput> InputCollectorBuilder addPlayer(
                        M model,
                        ModelCommandSupplier<M> view);

        /**
         * Builds a new input collector.
         * 
         * @return the new input collector.
         */
        InputCollector build();

}
