package pixformer.view;

import pixformer.common.wrap.ObservableWritableWrapper;
import pixformer.common.wrap.SimpleObservableWritableWrapper;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.Controller;
import pixformer.controller.input.ControllerInput;
import pixformer.controller.input.ControllerInputImpl;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.ViewLauncher;
import pixformer.view.engine.camera.Camera;
import pixformer.view.engine.camera.SimpleCamera;
import pixformer.view.engine.camera.SimpleCameraBuilder;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Implementation of the standard game view.
 */
public final class ViewImpl implements View, ControllerCommandSupplier<ControllerInput> {

    private static final double CAMERA_X_OFFSET = -10;
    private static final double CAMERA_Y_OFFSET = 0;
    private static final double CAMERA_SCALE = 15;

    private static final Color BACKGROUND_COLOR = new Color(0.4, 0.55, 0.95);

    private final Controller controller;
    private final Wrapper<GameScene> scene;
    private final ObservableWritableWrapper<Camera> camera;

    private Optional<Consumer<ControllerInput>> controllerCommand = Optional.empty();
    // private final CommandFactory commandFactory = new CommandFactory();

    /**
     * Initializes the default view.
     *
     * @param controller global controller
     * @param scene      current game scene
     */
    public ViewImpl(final Controller controller, final GameScene scene) {
        this.controller = controller;
        this.scene = new SimpleWrapper<>(scene);
        this.camera = new SimpleObservableWritableWrapper<>(SimpleCamera.DEFAULT_CAMERA);

        this.camera.addOnChange(camera -> camera.applyBeforeRendering(this.getScene().getGraphics()));
    }

    /**
     * Initializes the default view.
     *
     * @param viewLauncher view launcher used to begin the visual output
     */
    public ViewImpl(final ViewLauncher viewLauncher) {
        this(viewLauncher.getController(), viewLauncher.getScene());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        final RendererFactory rendererFactory = this.getScene().getRendererFactory();
        this.getScene().add(rendererFactory.newSolidBackground(BACKGROUND_COLOR));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameScene getScene() {
        return this.scene.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCamera(final double pivotX, final double pivotY) {
        final Camera camera = new SimpleCameraBuilder()
                .withPivot(pivotX, pivotY)
                .withOffset(CAMERA_X_OFFSET, CAMERA_Y_OFFSET)
                .withScale(CAMERA_SCALE)
                .build();
        this.camera.set(camera);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        final GameScene scene = this.scene.get();

        scene.getGraphics().setOriginPoint(0, 0);
        scene.getGraphics().setTranslate(0, 0);

        scene.getInputs().stream()
                .map(SceneInput::getMappedCommands).forEach(commands -> {
                    commands.forEach(command -> {
                        command.accept(new ControllerInputImpl(controller));
                    });
                });

        if (this.controller.getGameLoopManager().isRunning()) {
            scene.getInputs().stream()
                    .map(SceneInput::getMappedPolling)
                    .forEach(actions -> {
                        actions.forEach(action -> {
                            this.controller.getLevelManager().getCurrentLevel().ifPresent(action);
                        });
                    });
        }

        scene.render();
    }

    @Override
    public Optional<Consumer<ControllerInput>> supplyControllerCommand() {
        final var tmp = Optional.ofNullable(controllerCommand.orElseGet(() -> null));
        controllerCommand = Optional.empty();
        return tmp;
    }
}
