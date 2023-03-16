package pixformer.controller.gameloop;

import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.GameLoopManager;
import pixformer.model.Level;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.view.View;
import pixformer.view.engine.camera.Camera;
import pixformer.view.engine.camera.SimpleCameraBuilder;

import java.util.Set;

/**
 * Factory of available game loops.
 */
public final class GameLoopFactory {

    private static final int SECONDS_TO_MILLIS = 1_000;
    private static final int FPS = 30;

    private static final double CAMERA_X_OFFSET = -10;
    private static final double CAMERA_Y_OFFSET = 0;
    private static final double CAMERA_SCALE = 15;

    private final Wrapper<Level> level;
    private final Wrapper<View> view;
    private final Wrapper<GameLoopManager> gameLoopManager;

    /**
     * Instantiates a new game loop factory.
     *
     * @param level           game level
     * @param view            game view
     * @param gameLoopManager game loop handler
     */
    public GameLoopFactory(final Level level, final View view, final GameLoopManager gameLoopManager) {
        this.level = new SimpleWrapper<>(level);
        this.view = new SimpleWrapper<>(view);
        this.gameLoopManager = new SimpleWrapper<>(gameLoopManager);
    }

    /**
     * @return a new default game loop
     */
    public GameLoop defaultLoop() {
        final View view = this.view.get();

        view.setup();

        final World world = this.level.get().getWorld();
        final Set<Entity> playersEntities = world.getUserControlledEntities();

        return dt -> {
            view.update(dt);
            if (this.gameLoopManager.get().isRunning()) {
                world.update(dt);
            }

            view.setCamera(this.createCamera(playersEntities));

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

    /**
     * @param followedEntities entities to follow
     * @return a new camera instance centered on the given entities
     */
    private Camera createCamera(final Set<Entity> followedEntities) {
        return new SimpleCameraBuilder()
                .withEntityCenteringX(followedEntities)
                .withOffset(CAMERA_X_OFFSET, CAMERA_Y_OFFSET)
                .withScale(CAMERA_SCALE)
                .build();
    }
}
