package pixformer.view.javafx;

import javafx.animation.AnimationTimer;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.GameLoopManager;
import pixformer.controller.gameloop.GameLoop;
import pixformer.view.ViewImpl;
import pixformer.view.engine.ViewLauncher;

import java.util.concurrent.TimeUnit;

/**
 * Game loop manager for JavaFX, based on {@link AnimationTimer}.
 */
public class JavaFXGameLoopManager implements GameLoopManager {

    private final Wrapper<ViewLauncher> viewLauncher;

    private boolean isRunning;
    private AnimationTimer currentTimer;

    /**
     * @param viewLauncher view launcher to loop on
     */
    public JavaFXGameLoopManager(final ViewLauncher viewLauncher) {
        this.isRunning = true;
        this.viewLauncher = new SimpleWrapper<>(viewLauncher);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        this.isRunning = true;

        final ViewLauncher viewLauncher = this.viewLauncher.get();
        final GameLoop loop = viewLauncher.getController().createGameLoop(new ViewImpl(viewLauncher));

        if (currentTimer != null) {
            currentTimer.stop();
        }

        currentTimer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                // if (isRunning) {
                loop.loop(TimeUnit.NANOSECONDS.toMillis(now));
                // }
            }
        };

        currentTimer.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        this.isRunning = false;
        if (currentTimer != null) {
            currentTimer.stop();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return this.isRunning;
    }
}
