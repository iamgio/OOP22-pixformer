package pixformer.view.engine.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.controller.GameLoop;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.ViewLauncher;

/**
 * JavaFX application launcher.
 */
public abstract class JavaFXViewLauncher extends Application implements ViewLauncher {

    private JavaFXScene scene;
    private GameLoop loop;

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
            throw new NullPointerException("JavaFX scene is initialized only after launch.");
        }
        return this.scene;
    }

    private void startLoop() throws NullPointerException {
        if (this.loop == null) {
            throw new NullPointerException("Could not start game loop.");
        }

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                loop.loop(now);
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
