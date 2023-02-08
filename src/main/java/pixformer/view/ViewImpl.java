package pixformer.view;

import pixformer.controller.input.InputType;
import pixformer.controller.input.ObservableInputPolling;
import pixformer.model.joystick.CompleteJoystick;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

import java.util.Date;
import java.util.Optional;

/**
 * Implementation of the standard game view.
 */
public class ViewImpl implements View, ViewInputComponent {

    private final GameScene scene;

    private TextRenderer text;
    private Optional<Command<CompleteJoystick>> command = Optional.empty();
    private final CommandFactory commandFactory = new CommandFactory();

    /**
     * Initializes the default view.
     * @param scene current game scene
     */
    public ViewImpl(final GameScene scene) {
        this.scene = scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        final RendererFactory rendererFactory = scene.getRendererFactory();

        scene.add(rendererFactory.newSolidBackground(Color.BLACK));

        this.text = rendererFactory.newText("");
        text.setColor(new Color(1, 0, 0));
        scene.add(text.at(100, 100));

        // Test
        scene.getInputPolling().addAction(InputType.P1_JUMP, () -> command = Optional.of(commandFactory.jump()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableInputPolling getInputPolling() {
        return this.scene.getInputPolling();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.text.setText("Now:\n" + new Date());

        this.getInputPolling().update(dt);
        this.scene.render();
    }

    @Override
    public Optional<Command<CompleteJoystick>> popInput() {
        var tmp = Optional.ofNullable(command.orElseGet(() -> null));
        command = Optional.empty();
        return tmp;
    }
}
