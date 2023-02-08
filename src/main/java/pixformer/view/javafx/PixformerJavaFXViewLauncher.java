package pixformer.view.javafx;

import javafx.application.Application;
import pixformer.controller.DefaultGameLoop;
import pixformer.controller.GameLoop;
import pixformer.model.ModelMock;
import pixformer.view.View;
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
    public JavaFXScene createScene() {
        return new PixformerJavaFXScene();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop createGameLoop() {
        ViewImpl view = new ViewImpl(super.getScene());
        return new DefaultGameLoop(view, new ModelMock(), view);
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
