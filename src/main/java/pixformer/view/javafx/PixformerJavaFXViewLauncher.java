package pixformer.view.javafx;

import javafx.application.Application;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GeneralGameLoop;
import pixformer.controller.gameloop.InputCollector;
import pixformer.controller.gameloop.InputCollectorBuilderImpl;
import pixformer.model.ModelMock;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.entity.TestEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.view.ViewImpl;
import pixformer.view.engine.internationalization.Lang;
import pixformer.view.engine.javafx.JavaFXScene;
import pixformer.view.engine.javafx.JavaFXViewLauncher;

import java.util.Set;

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
        var test1 = new TestEntity(5);
        var test2 = new TestEntity(10);
        final World world = new WorldImpl(Set.of(test1, test2));
        final ViewImpl view = new ViewImpl(super.getScene());

        // test
        world.getCollisionManager().addOnCollide(test1, other -> System.out.println("Collision detected"));

        view.setup();
        view.getScene().getGraphics().setScale(15); // test

        final InputCollector inputCollector = new InputCollectorBuilderImpl()
            .addControllerInput(view)
            .addPlayer(test1.getInputComponent().get(), view)
            .addPlayer(new ModelMock("Mario"), view)
            .addPlayer(new ModelMock("Luigi"), view)
            .build();

        return new GeneralGameLoop(
            inputCollector::execute,
            world::update,
            () -> {
                view.update(0);

                final EntityCollisionManager collisionManager = world.getCollisionManager();

                world.getEntities().forEach(entity -> {
                    collisionManager.findCollisionsFor(entity).forEach(other -> {
                        collisionManager.getOnCollideCallbacksFor(entity).forEach(callback -> callback.accept(other));
                    });
                    view.getScene().getGraphics().setTranslate(entity.getX(), entity.getY());
                    entity.getGraphicsComponent().update(view.getScene());
                });
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
