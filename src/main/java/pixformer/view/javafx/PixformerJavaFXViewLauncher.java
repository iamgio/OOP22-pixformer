package pixformer.view.javafx;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.internationalization.Lang;
import pixformer.view.engine.javafx.JavaFXViewLauncher;

/**
 * The default game view launcher for JavaFX.
 */
public class PixformerJavaFXViewLauncher extends JavaFXViewLauncher {

    /**
     * {@inheritDoc}
     */
    @Override
    public GameScene createGameScene() {
        var scene = new PixformerJavaFXGameScene();
        scene.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            // TODO remove
            if (e.getCode() == KeyCode.ENTER) {
                this.getController().getLevelManager().endCurrentLevel();
            }
        });
        return scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameScene createMenuScene() {
        var menu = new PixformerJavaFXMainMenuScene(this.getController());
        menu.addOnLevelSelect(level -> this.getController().getLevelManager().start(level, menu.getPlayersAmount()));
        return menu;
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
