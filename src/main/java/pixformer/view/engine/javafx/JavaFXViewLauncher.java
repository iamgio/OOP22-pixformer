package pixformer.view.engine.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.controller.AbstractController;
import pixformer.controller.Controller;
import pixformer.controller.gameloop.GameLoop;
import pixformer.view.ViewImpl;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;

import java.util.Objects;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private JavaFXScene scene;
    private Stage stage;
    private Controller controller;

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) {
        this.stage = primaryStage;
        this.controller = this.createController();
        this.setScene(this.createInitialScene());

        primaryStage.setTitle(this.getTitle());
        primaryStage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void launch() {
        Application.launch(getAppClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameScene getScene() {
        if (scene == null) {
            throw new IllegalStateException("JavaFX scene is initialized only after launch.");
        }
        return this.scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScene(final GameScene scene) {
        if (!(scene instanceof JavaFXScene)) {
            throw new IllegalArgumentException("Expected a JavaFX scene.");
        }

        this.scene = (JavaFXScene) Objects.requireNonNull(scene);
        this.stage.setScene(this.scene.getScene());
    }

    private Controller createController() {
        return new AbstractController() {
            @Override
            public void startGameLoop() {
                final GameLoop loop = createGameLoop(new ViewImpl(getScene()));

                if (loop != null) {
                    new AnimationTimer() {
                        @Override
                        public void handle(final long now) {
                            loop.loop(now);
                        }
                    }.start();
                }
            }
        };
    }

    /**
     * @return the application title
     */
    protected abstract String getTitle();

    /**
     * @return the JavaFX application to run
     */
    protected abstract Class<? extends Application> getAppClass();
    // This is because JavaFX is unable to detect inheritance in terms of Applications
}
