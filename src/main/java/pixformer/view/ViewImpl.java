package pixformer.view;

import pixformer.controller.input.InputType;
import pixformer.controller.input.ObservableInputPolling;
import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Implementation of the standard game view.
 */
public final class ViewImpl implements View, ControllerCommandSupplier<PauseControllerInput>,
        ModelCommandSupplier<CompleteModelInput> {

    private final GameScene scene;

    private TextRenderer text;
    private Optional<Consumer<CompleteModelInput>> gameCommand = Optional.empty();
    private Optional<Consumer<PauseControllerInput>> controllerCommand = Optional.empty();
    // private final CommandFactory commandFactory = new CommandFactory();

    /**
     * Initializes the default view.
     * 
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
        scene.getInputPolling().addAction(InputType.P1_JUMP,
                () -> gameCommand = Optional.of(CompleteModelInput::jump));
        scene.getInputPolling().addAction(InputType.PAUSE,
                () -> controllerCommand = Optional.of(PauseControllerInput::pause));
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
    public GameScene getScene() {
        return this.scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.scene.getGraphics().setTranslate(0, 0);

        this.text.setText("Now:\n" + new Date());

        this.getInputPolling().update(dt);
        this.scene.render();
    }

    @Override
    public Optional<Consumer<CompleteModelInput>> supplyModelCommand() {
        return gameCommand;
    }

    @Override
    public Optional<Consumer<PauseControllerInput>> supplyControllerCommand() {
        final var tmp = Optional.ofNullable(controllerCommand.orElseGet(() -> null));
        controllerCommand = Optional.empty();
        return tmp;
    }

    @Override
    public void clear() {
        gameCommand = Optional.empty();
    }
}
