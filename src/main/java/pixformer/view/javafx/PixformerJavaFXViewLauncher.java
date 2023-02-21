package pixformer.view.javafx;

import javafx.application.Application;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GeneralGameLoop;
import pixformer.controller.gameloop.InputCollector;
import pixformer.controller.gameloop.InputCollectorBuilder;
import pixformer.controller.gameloop.InputCollectorBuilderImpl;
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
    public JavaFXScene createScene() {
        return new PixformerJavaFXScene();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop createGameLoop() {
        final ViewImpl view = new ViewImpl(super.getScene());
        final World level = new WorldImpl();
        final InputCollector inputCollector = new InputCollectorBuilderImpl()
            .addControllerInput(view)
            .addPlayer(view, level.getPlayer(0).get())
            .build();
        return new GeneralGameLoop(
            inputCollector::execute, 
            level::update,
            () -> {
                
            },
            dt -> {
                final long period = 17;
                if (dt < period) {
                    try {
                        Thread.sleep(period - dt);
                    } catch (final InterruptedException ex) { }
                }
            });
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
