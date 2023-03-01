package pixformer.view.engine.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.controller.gameloop.GameLoop;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;

import java.util.concurrent.TimeUnit;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private JavaFXScene scene;
    private GameLoop loop;

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) {
        this.scene = (JavaFXScene) this.createScene();
        this.loop = this.createGameLoop();
        this.startLoop();
        primaryStage.setTitle(this.getTitle());
        primaryStage.setScene(this.scene.getScene());
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
    public GameScene getScene() {
        if (scene == null) {
            throw new IllegalStateException("JavaFX scene is initialized only after launch.");
        }
        return this.scene;
    }

    private void startLoop() {
        if (this.loop == null) {
            throw new IllegalStateException("Could not start game loop.");
        }

        new AnimationTimer() {
            @Override
            public void handle(final long now) {
                loop.loop(TimeUnit.NANOSECONDS.toMillis(now));
            }
        }.start();
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
