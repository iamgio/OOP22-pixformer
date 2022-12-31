package pixformer.view.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import pixformer.controller.DefaultGameLoop;
import pixformer.controller.GameLoop;
import pixformer.view.GameScene;
import pixformer.view.ViewLauncher;

/**
 * JavaFX application launcher.
 */
public class JavaFXViewLauncher extends Application implements ViewLauncher {

    private static final double INITIAL_WIDTH = 1200;
    private static final double INITIAL_HEIGHT = 600;

    private JavaFXScene scene;
    private GameLoop loop;

    @Override
    public void start(final Stage primaryStage) {
        this.scene = new JavaFXScene(INITIAL_WIDTH, INITIAL_HEIGHT);
        this.loop = new DefaultGameLoop(this.scene);
        this.startLoop();
        primaryStage.setTitle("Pixformer");
        primaryStage.setScene(this.scene.getScene());
        primaryStage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void launch() {
        Application.launch();
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
}
