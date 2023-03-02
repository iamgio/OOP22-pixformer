package pixformer.view.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import pixformer.model.Level;
import pixformer.model.LevelMock;
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
        this.setScene(new PixformerJavaFXGameScene());
        this.getController().getLevelManager().start(level);
        this.getController().startGameLoop();
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
