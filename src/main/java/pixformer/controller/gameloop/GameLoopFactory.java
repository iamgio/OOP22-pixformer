package pixformer.controller.gameloop;

import pixformer.controller.Controller;
import pixformer.model.Level;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.view.View;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000; // millis in a second
    private static final int FPS = 30; // in-game fps

    private final Level level;
    private final View view;

    private final Controller controller;

    /**
     * Instantiates a new game loop factory.
     *
     * @param level      game level
     * @param controller game controller
     * @param view       game view
     */
    public GameLoopFactory(final Level level, final Controller controller, final View view) {
        this.level = level;
        this.view = view;
        this.controller = controller;
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        view.init();

        final World world = level.getWorld();
        final Set<Entity> playersEntities = world.getUserControlledEntities();

        return dt -> {
            view.update(dt);
            if (this.controller.getGameLoopManager().isRunning()) {
                world.update(dt);
            }

            // Game over check
            if (playersEntities.stream().map(Entity::getWorld).allMatch(Optional::isEmpty)) {
                this.controller.getLevelManager().endCurrentLevel();
            }

            final double cameraPivotX = this.controller.calcEntitiesCommonPointX(playersEntities);
            final double cameraPivotY = this.controller.calcEntitiesCommonPointY(playersEntities);
            view.updateCamera(cameraPivotX, cameraPivotY);

            world.getUpdatableEntities()
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
                    final Logger logger = Logger.getLogger(this.getClass().getName());
                    // ex.printStackTrace();
                    logger.log(java.util.logging.Level.FINE, ex.toString());
                }
            }
        };
    }
}
