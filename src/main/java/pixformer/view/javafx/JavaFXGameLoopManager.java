package pixformer.view.javafx;

import javafx.animation.AnimationTimer;
import pixformer.controller.GameLoopManager;
import pixformer.controller.gameloop.GameLoop;
import pixformer.view.ViewImpl;
import pixformer.view.engine.ViewLauncher;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Game loop manager for JavaFX, based on {@link AnimationTimer}.
 */
public class JavaFXGameLoopManager implements GameLoopManager {

    private final ViewLauncher viewLauncher;

    private long delta;
    private long lastFrameTime;
    private boolean isRunning;
    private AnimationTimer currentTimer;

    /**
     * @param viewLauncher view launcher to loop on
     */
    public JavaFXGameLoopManager(final ViewLauncher viewLauncher) {
        this.isRunning = true;
        this.viewLauncher = viewLauncher;
    }

    private long getDelta() {
        return this.delta;
    }

    private void setDelta(final long delta) {
        this.delta = delta;
    }

    private long getLastFrameTime() {
        return this.lastFrameTime;
    }

    private void setLastFrameTime(final long lastFrameTime) {
        this.lastFrameTime = lastFrameTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        final GameLoop loop = Objects.requireNonNull(
                this.viewLauncher.getController().createGameLoop(
                        new ViewImpl(this.viewLauncher.getController(), this.viewLauncher.getScene())));

        if (currentTimer != null) {
            currentTimer.stop();
        }

        currentTimer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                setDelta(now - getLastFrameTime());
                setLastFrameTime(now);
                loop.loop(TimeUnit.NANOSECONDS.toMillis(getDelta()));
            }
        };

        currentTimer.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
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

    @Override
    public void pause() {
        this.isRunning = false;
    }

    @Override
    public void resume() {
        this.isRunning = true;
    }
}
