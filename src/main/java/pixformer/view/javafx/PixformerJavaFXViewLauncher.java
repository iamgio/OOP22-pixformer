package pixformer.view.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pixformer.controller.LevelManager;
import pixformer.model.LevelMock;
import pixformer.view.engine.internationalization.Lang;
import pixformer.view.engine.javafx.JavaFXScene;
import pixformer.view.engine.javafx.JavaFXViewLauncher;

/**
 * The default game view launcher for JavaFX.
 */
public class PixformerJavaFXViewLauncher extends JavaFXViewLauncher {

    private JavaFXScene createGameScene() {
        var scene = new PixformerJavaFXGameScene();
        scene.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            // TODO remove
            if (e.getCode() == KeyCode.ENTER) {
                this.getController().getLevelManager().endCurrentLevel();
            }
        });
        return scene;
    }

    private JavaFXScene createMenuScene() {
        var menu = new PixformerJavaFXMainMenuScene(this.getController());
        menu.addOnLevelSelect(level -> this.getController().getLevelManager().start(level, menu.getPlayersAmount()));
        return menu;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JavaFXScene createInitialScene() {
        LevelManager levelManager = this.getController().getLevelManager();
        levelManager.addOnLevelStart((level, playersAmount) -> {
            this.setScene(this.createGameScene());
            this.getController().initLevel(level, playersAmount);
        });
        levelManager.addOnLevelEnd(level -> {
            this.setScene(this.createMenuScene());
            this.getController().stopLevel(level);
        });

        // Commentare la riga sotto per far comparire il menu principale (togliere prima della consegna)
        Platform.runLater(() -> this.getController().getLevelManager().start(new LevelMock(), 1));

        return this.createMenuScene();
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
