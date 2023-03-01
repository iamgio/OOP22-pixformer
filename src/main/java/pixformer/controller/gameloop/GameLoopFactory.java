package pixformer.controller.gameloop;

import pixformer.model.ModelMock;
import pixformer.model.World;
import pixformer.model.entity.TestEntity;
import pixformer.view.ViewImpl;

import java.util.concurrent.TimeUnit;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;

    private final World world;
    private final ViewImpl view; // TODO cambiare da ViewImpl a View

    /**
     * Instantiates a new game loop factory.
     * @param world game world
     * @param view game view
     */
    public GameLoopFactory(final World world, final ViewImpl view) {
        this.world = world;
        this.view = view;
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        final var test1 = new TestEntity(5);
        final var test2 = new TestEntity(10);

        world.spawnEntity(test1);
        world.spawnEntity(test2);

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

                    world.getEntities().forEach(entity -> {
                        view.getScene().getGraphics().setTranslate(entity.getX(), entity.getY());
                        entity.getGraphicsComponent().update(view.getScene());
                    });
                },
                dt -> {
                    final long period = (SECONDS_TO_MILLIS / FPS);
                    if (dt < period) {
                        try {
                            Thread.sleep(period - dt);
                        } catch (final InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }
}
