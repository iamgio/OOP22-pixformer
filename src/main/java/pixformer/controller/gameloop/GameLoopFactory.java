package pixformer.controller.gameloop;

import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.model.Level;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.view.View;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;

    private final Wrapper<Level> level;
    private final Wrapper<View> view;

    /**
     * Instantiates a new game loop factory.
     * 
     * @param level         game level
     * @param view          game view
     */
    public GameLoopFactory(final Level level, final View view) {
        this.level = new SimpleWrapper<>(level);
        this.view = new SimpleWrapper<>(view);
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        final Level level = this.level.get();
        final View view = this.view.get();

        view.setup();
        view.getScene().getGraphics().setScale(15); // test

        final World world = this.level.get().getWorld();

        return dt -> {
            view.update(dt);
            world.update(dt);

            world.getEntities().stream()
                    .filter(DrawableEntity.class::isInstance)
                    .map(DrawableEntity.class::cast)
                    .forEach(entity -> {
                        view.getScene().getGraphics().setTranslate(entity.getX(), entity.getY());
                        entity.getGraphicsComponent().update(view.getScene());
                    });

            final long period = SECONDS_TO_MILLIS / FPS;
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
