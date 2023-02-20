package pixformer.view.javafx;

import javafx.application.Application;
import pixformer.controller.GameLoop;
import pixformer.controller.GameLoopBuilder;
import pixformer.model.ModelMock;
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
    public JavaFXScene createScene() {
        return new PixformerJavaFXScene();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop createGameLoop() {
        final ViewImpl view = new ViewImpl(super.getScene());
        return new GameLoopBuilder(new WorldImpl(), view, view)
            .addControllerInput(view)
            .addPlayer(new ModelMock())
            .build();
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
