package pixformer.view;

import java.util.Optional;

import pixformer.model.modelInput.CompleteModelInput;

/**
 * It is the interface which the input-responsible component of the controller
 * will see.
 */
public interface ViewInputComponent {

    /**
     * It pops the possibly-collected input by the view.
     * 
     * @return the input collected by this view.
     * @implNote when this method is called, a following call of this method should
     *           return {@code Optional.empty()} if the view hasn't received another
     *           input in the meanwhile.
     */
    Optional<Command<CompleteModelInput>> popInput();
}
