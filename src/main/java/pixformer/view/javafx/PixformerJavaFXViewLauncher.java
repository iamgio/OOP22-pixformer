package pixformer.view.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.model.Level;
import pixformer.model.LevelMock;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.view.ViewImpl;
import pixformer.view.engine.internationalization.Lang;
import pixformer.view.engine.javafx.JavaFXScene;
import pixformer.view.engine.javafx.JavaFXViewLauncher;

/**
 * The default game view launcher for JavaFX.
 */
public class PixformerJavaFXViewLauncher extends JavaFXViewLauncher {

    /**
     * {@inheritDoc}
     */
    @Override
    public JavaFXScene createInitialScene() {
        // Commentare la riga sotto per far comparire il menu principale (togliere prima della consegna)
        Platform.runLater(() -> this.switchToGameScene(new LevelMock()));

        var menu = new PixformerJavaFXMainMenuScene();
        menu.addOnLevelSelect(this::switchToGameScene);

        return menu;
    }

    private void switchToGameScene(final Level level) {
        // TODO use level
        // TODO use LevelManager instead of Level to not break MVC
        this.setScene(new PixformerJavaFXGameScene());
        this.startGameLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop createGameLoop() {
        final World world = new WorldImpl();
        final ViewImpl view = new ViewImpl(super.getScene());

        return new GameLoopFactory(world, view).defaultLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getTitle() {
        return Lang.getInstance().get("title");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<? extends Application> getAppClass() {
        return this.getClass();
    }
}
