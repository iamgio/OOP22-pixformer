package pixformer.view.engine.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.common.wrap.ObservableWritableWrapper;
import pixformer.common.wrap.SimpleObservableWritableWrapper;
import pixformer.controller.Controller;
import pixformer.controller.ControllerImpl;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;
import pixformer.view.entity.SpritesGraphicsComponentFactory;
import pixformer.view.javafx.JavaFXGameLoopManager;

import java.util.Objects;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private final Controller controller = this.createController();
    private final ObservableWritableWrapper<JavaFXScene> scene = new SimpleObservableWritableWrapper<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) {
        this.controller.init();
        setupLevelScenesRoutine();
        this.scene.addOnChange(scene -> {
            primaryStage.setScene(scene.getScene());
            scene.handleInput();
        });

        this.setScene(this.createMenuScene());

        primaryStage.setTitle(this.getTitle());
        primaryStage.show();
    }

    private Controller createController() {
        return new ControllerImpl(new JavaFXGameLoopManager(this), new SpritesGraphicsComponentFactory());
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
        final GameScene scene = this.scene.get();
        if (scene == null) {
            throw new IllegalStateException("JavaFX scene is initialized only after launch.");
        }
        return scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScene(final GameScene scene) {
        if (!(scene instanceof JavaFXScene)) {
            throw new IllegalArgumentException("Expected a JavaFX scene.");
        }

        final JavaFXScene javaFXScene = (JavaFXScene) Objects.requireNonNull(scene);
        this.scene.set(javaFXScene);
    }

    /**
     * @return the application title
     */
    protected abstract String getTitle();

    /**
     * @return the JavaFX application to run
     */
    protected abstract Class<? extends Application> getAppClass();
    // This is because JavaFX is unable to detect inheritance in terms of
    // Applications
}
