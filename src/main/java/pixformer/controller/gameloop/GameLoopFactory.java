package pixformer.controller.gameloop;

import pixformer.model.Level;
import pixformer.model.World;
import pixformer.view.ViewImpl;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private final Level level;
    private final ViewImpl view; // TODO cambiare da ViewImpl a View

    /**
     * Instantiates a new game loop factory.
     * @param level game level
     * @param view game view
     */
    public GameLoopFactory(final Level level, final ViewImpl view) {
        this.level = level;
        this.view = view;
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        this.level.setup();
        this.view.setup();
        this.view.getScene().getGraphics().setScale(15); // test

        final World world = this.level.getWorld();

        final InputCollector inputCollector = new InputCollectorBuilderImpl()
                .addControllerInput(view)
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
