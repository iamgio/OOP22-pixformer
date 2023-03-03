package pixformer.view.engine.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.controller.Controller;
import pixformer.controller.ControllerImpl;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;
import pixformer.view.javafx.JavaFXGameLoopManager;

import java.util.Objects;

import java.util.concurrent.TimeUnit;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private final Controller controller = this.createController();

    private JavaFXScene scene;
    private Stage stage;

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) {
        this.stage = primaryStage;
        this.setScene(this.createInitialScene());

        primaryStage.setTitle(this.getTitle());
        primaryStage.show();
    }

    private Controller createController() {
        return new ControllerImpl(new JavaFXGameLoopManager(this));
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
