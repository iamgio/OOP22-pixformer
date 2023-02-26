package pixformer.view;

import java.util.Optional;
import java.util.function.Consumer;

import pixformer.model.modelinput.ModelInput;

/**
 * It represents a component which can produce a command for the game.
 * 
 * @param <M> the ModelInput which will be produced.
 */
public interface ModelCommandSupplier<M extends ModelInput> {

    /**
     * It supply the possibly-collected command.
     * 
     * @return the command.
     */
    Optional<Consumer<M>> supplyModelCommand();

    /**
     * Set the returning value of {@code supplyModelCommand} to Optional.empty().
     */
    void clear();
}
