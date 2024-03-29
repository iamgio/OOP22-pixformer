package pixformer.view;

import pixformer.common.wrap.ObservableWritableWrapper;
import pixformer.common.wrap.SimpleObservableWritableWrapper;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.Controller;
import pixformer.controller.input.ControllerInputImpl;
import pixformer.view.engine.Color;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.TextRenderer;
import pixformer.view.engine.ViewLauncher;
import pixformer.view.engine.camera.Camera;
import pixformer.view.engine.camera.SimpleCamera;
import pixformer.view.engine.camera.SimpleCameraBuilder;
import pixformer.view.engine.internationalization.Lang;

/**
 * Implementation of the standard game view.
 */
public final class ViewImpl implements View {

    private static final double CAMERA_X_OFFSET = -10;
    private static final double CAMERA_Y_OFFSET = 5;
    private static final double CAMERA_Y_OFFSET_SCALE_DIVISOR = 200;

    private static final double CAMERA_SCALE_OFFSET = 20;
    private static final double CAMERA_SCALE_WIDTH_DIVISOR = 1200;

    private static final Color BACKGROUND_COLOR = new Color(0.4, 0.55, 0.95);

    private final Controller controller;
    private final Wrapper<GameScene> scene;
    private final ObservableWritableWrapper<Camera> camera;
    private TextRenderer infoLabel;

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
    public void init() {
        final RendererFactory rendererFactory = this.getScene().getRendererFactory();
        this.getScene().add(rendererFactory.newSolidBackground(BACKGROUND_COLOR));

        this.infoLabel = rendererFactory.newText("");
        this.infoLabel.setFontFamily("Impact");
        this.infoLabel.setFontSize(1);
        this.getScene().add(infoLabel.at(1, 1));
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
        final double scale = CAMERA_SCALE_OFFSET + getScene().getWidth() / CAMERA_SCALE_WIDTH_DIVISOR;
        final Camera camera = new SimpleCameraBuilder()
                .withPivot(pivotX, pivotY)
                .withOffset(CAMERA_X_OFFSET, CAMERA_Y_OFFSET + scale / CAMERA_Y_OFFSET_SCALE_DIVISOR)
                .withScale(scale)
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
                    commands.forEach(command -> command.accept(new ControllerInputImpl(controller)));
                });

        if (this.controller.getGameLoopManager().isRunning()) {
            scene.getInputs().stream()
                    .map(SceneInput::getMappedPolling)
                    .forEach(actions -> actions.forEach(action -> {
                        this.controller.getLevelManager().getCurrentLevel().ifPresent(action);
                    }));
        }

        this.updateTextRenderer();

        scene.render();
    }

    /**
     * Update the scoreLabel, with all players score, during the game.
     */
    private void updateTextRenderer() {
        this.infoLabel.setText("");
        final var leaderboard = this.controller.getIndexedLeaderboard();
        final Lang lang = Lang.getInstance();
        final StringBuilder builder = new StringBuilder();
        for (final var i : leaderboard) {
            final String text = lang.get("score.label")
                    .replace("{i}", Integer.toString(i + 1))
                    .replace("{p}", controller.getPlayerPointsByIndex(i).toString())
                    .replace("{c}", controller.getPlayerCoinsByIndex(i).toString());
            builder.append(text);
        }
        this.infoLabel.setText(builder.toString());
    }
}
