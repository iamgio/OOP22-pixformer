package pixformer.view.javafx;

import javafx.animation.AnimationTimer;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
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

    private static final int SECONDS_TO_MILLIS = 1_000; // millis in a second
    private static final int FPS = 30; // in-game fps

    private final Wrapper<ViewLauncher> viewLauncher;

    private long lastFrameTime;
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
     * @return the time when javaFX generated our last frame
     */
    private long getLastFrameTime() {
        return this.lastFrameTime;
    }

    /**
     * Set the new lastFrameTime.
     * 
     * @param lastFrameTime new time
     */
    private void setLastFrameTime(final long lastFrameTime) {
        this.lastFrameTime = lastFrameTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        final ViewLauncher viewLauncher = this.viewLauncher.get();
        final GameLoop loop = Objects.requireNonNull(
                viewLauncher.getController().createGameLoop(new ViewImpl(viewLauncher))
        );

        if (currentTimer != null) {
            currentTimer.stop();
        }

        currentTimer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                final long delta = getLastFrameTime() != 0 ? now - getLastFrameTime() : 0;
                setLastFrameTime(now);

                final long dt = TimeUnit.NANOSECONDS.toMillis(delta);
                loop.loop(dt);
                sleep(dt);
            }

            private void sleep(final long dt) {
                final long period = SECONDS_TO_MILLIS / FPS;
                if (dt < period) {
                    try {
                        Thread.sleep(period - dt);
                    } catch (final InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void pause() {
        this.isRunning = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resume() {
        this.isRunning = true;
    }
}
