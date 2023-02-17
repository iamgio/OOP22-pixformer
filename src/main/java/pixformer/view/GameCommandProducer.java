package pixformer.view;

import java.util.Optional;
import java.util.function.Consumer;

import pixformer.model.modelinput.ModelInput;

/**
 * It represents a component which can produce a command for the game.
 * 
 * @param <M> the ModelInput which will be produced.
 */
public interface GameCommandProducer<M extends ModelInput> {

    /**
     * It pops the possibly-collected command.
     * 
     * @return the command.
     * @implNote when this method is called, a following call of this method should
     *           return {@code Optional.empty()} if the view hasn't received another
     *           input in the meanwhile.
     */
    Optional<Consumer<M>> supplyModelCommand();
}
