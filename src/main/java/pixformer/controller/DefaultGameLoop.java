package pixformer.controller;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.ModelInputComponent;
import pixformer.model.World;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.View;
import pixformer.view.ViewInputComponent;

import java.util.function.Consumer;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final ViewInputComponent viewInput;
    private final View view;
    private final ModelInputComponent model;
    private boolean isRunning = true;
    private final ControllerInputComponent<CompleteModelInput> mockInputComponent = 
        new ControllerInputComponent<>() {

            @Override
            public void acceptGameInput(final Consumer<CompleteModelInput> input) {
                model.acceptMarioInput(input);
            }

            @Override
            public void pause() {
                isRunning = false;
            }

            @Override
            public void unpause() {
                isRunning = true;
            }

        };

    /**
     * Creates the default game loop that relies on a visual renderable scene.
     * 
     * @param viewComp the ViewInputComponent which will collect the user input.
     * @param model    of the application
     * @param view     active game view.
     */
    public DefaultGameLoop(final World world, final ViewInputComponent viewComp, final ModelInputComponent model, final View view) {
        this.viewInput = viewComp;
        this.model = model;
        this.view = view;
        view.setup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loop(final long now) {
        final var optional = viewInput.popInput();
        if (optional.isPresent()) {
            final var input = optional.get();
            if (isRunning) {
                input.accept(mockInputComponent);
            }
        }
        this.view.update(0 /* TODO delta time */);
    }
}
