package pixformer.controller.gameloop;

import pixformer.model.ModelMock;
import pixformer.model.World;
import pixformer.model.entity.TestEntity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.view.ViewImpl;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

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
                        } catch (final InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }
}
