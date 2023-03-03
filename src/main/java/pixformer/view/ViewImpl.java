package pixformer.view;

import pixformer.controller.Controller;
import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.ModelInput;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.TextRenderer;

import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Implementation of the standard game view.
 */
public final class ViewImpl implements View, ControllerCommandSupplier<PauseControllerInput>,
        ModelCommandSupplier<ModelInput> {

    private final Controller controller;
    private final GameScene scene;

    private TextRenderer text;
    private Optional<Consumer<ModelInput>> gameCommand = Optional.empty();
    private Optional<Consumer<PauseControllerInput>> controllerCommand = Optional.empty();
    // private final CommandFactory commandFactory = new CommandFactory();

    /**
     * Initializes the default view.
     * 
     * @param scene current game scene
     */
    public ViewImpl(final Controller controller, final GameScene scene) {
        this.controller = controller;
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

        scene.getInputs().stream()
                .map(SceneInput::getMappedPolling)
                .forEach(actions -> {
                    actions.forEach(action -> {
                        this.controller.getLevelManager().getCurrentLevel().ifPresent(action);
                    });
                });

        this.scene.render();
    }

    @Override
    public Optional<Consumer<ModelInput>> supplyModelCommand() {
        return this.gameCommand;
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
