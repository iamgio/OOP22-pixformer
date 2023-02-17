package pixformer.view;

import java.util.Optional;
import java.util.function.Consumer;

import pixformer.controller.input.ControllerInput;


/**
 * It represents something which can produce commands for the controller.
 * 
 * @param <C> the controller input which this interface will produce.
 */
public interface ControllerCommandProducer<C extends ControllerInput> {

    /**
     * It supply the possibly-collected command.
     * 
     * @return the command.
     * @implNote when this method is called, a following call of this method should
     *           return {@code Optional.empty()} if the view hasn't received another
     *           input in the meanwhile.
     */
    Optional<Consumer<C>> supplyControllerCommand();
}
