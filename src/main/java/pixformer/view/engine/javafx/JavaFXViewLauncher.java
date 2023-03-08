package pixformer.view.engine.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.common.wrap.ObservableWritableWrapper;
import pixformer.common.wrap.SimpleObservableWritableWrapper;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.Controller;
import pixformer.controller.ControllerImpl;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;
import pixformer.view.javafx.JavaFXGameLoopManager;

import java.util.Objects;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private final Wrapper<Controller> controller = new SimpleWrapper<>(this.createController());
    private final ObservableWritableWrapper<JavaFXScene> scene = new SimpleObservableWritableWrapper<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) {
        this.scene.addOnChange(scene -> primaryStage.setScene(scene.getScene()));
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
        return this.controller.get();
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
