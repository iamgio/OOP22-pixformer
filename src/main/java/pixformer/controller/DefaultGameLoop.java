package pixformer.controller;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.ModelInputComponent;
import pixformer.model.joystick.CompleteJoystick;
import pixformer.view.View;
import pixformer.view.ViewInputComponent;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final ViewInputComponent viewInput;
    private final View view;
    private final ModelInputComponent model;
    private boolean isRunning = true;
    private final ControllerInputComponent<CompleteJoystick> mockInputComponent = 
        new ControllerInputComponent<CompleteJoystick>() {

            @Override
            public void acceptGameInput(final Consumer<CompleteJoystick> input) {
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
    public DefaultGameLoop(final ViewInputComponent viewComp, final ModelInputComponent model, final View view) {
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
        var optional = viewInput.popInput();
        if (optional.isPresent()) {
            var input = optional.get();
            input.accept(mockInputComponent);
        }
        this.view.update(0 /* TODO delta time */);
    }
}
