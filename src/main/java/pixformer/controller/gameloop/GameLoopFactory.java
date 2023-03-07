package pixformer.controller.gameloop;

import pixformer.model.Level;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.view.ViewImpl;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;
    private final Level level;
    private final ViewImpl view; // TODO cambiare da ViewImpl a View
    private final int playersAmount;

    /**
     * Instantiates a new game loop factory.
     * 
     * @param level         game level
     * @param view          game view
     * @param playersAmount amount of players
     */
    public GameLoopFactory(final Level level, final ViewImpl view, final int playersAmount) {
        this.level = level;
        this.view = view;
        this.playersAmount = playersAmount;
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        this.level.setup(this.playersAmount);
        this.view.setup();
        this.view.getScene().getGraphics().setScale(15); // test

        final World world = this.level.getWorld();

        return dt -> {
            view.update(dt);
            world.update(dt);

            world.getEntities().stream()
                    .filter(entity -> entity instanceof DrawableEntity)
                    .forEach(entity -> {
                        view.getScene().getGraphics().setTranslate(entity.getX(), entity.getY());
                        ((DrawableEntity) entity).getGraphicsComponent().update(view.getScene());
                    });

            final long period = SECONDS_TO_MILLIS / FPS;
            System.out.println("Period -> " + period);
            System.out.println("Delta time -> " + dt);
            if (dt < period) {
                try {
                    Thread.sleep(period - dt);
                } catch (final InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
}
