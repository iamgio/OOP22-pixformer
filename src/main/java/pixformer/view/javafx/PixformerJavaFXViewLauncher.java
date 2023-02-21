package pixformer.view.javafx;

import javafx.application.Application;
import pixformer.controller.GameLoop;
import pixformer.controller.GameLoopBuilder;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.TestEntity;
import pixformer.model.modelinput.CompleteModelInput;
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
        final World world = new WorldImpl();
        final ViewImpl view = new ViewImpl(super.getScene());

        view.getScene().getGraphics().setScale(15); // test

        var test = new TestEntity(5);
        world.getEntities().add(test); // test

        return new GameLoopBuilder(world, view)
            .addControllerInput(view)
            //.addPlayer(new ModelMock())
            .addPlayer((CompleteModelInput) test.getInputComponent().get(), view) // test
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
