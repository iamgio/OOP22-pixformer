package pixformer.common.time;

import javafx.animation.AnimationTimer;

public class PausableAnimationTimer extends AnimationTimer {

    private long animationStart;
    private boolean restartScheduled;
    private boolean pauseScheduled;
    private long pauseStart;
    private boolean isPaused;

    public PausableAnimationTimer() {
    }

    @Override
    public void start() {
        super.start();
        restartScheduled = true;
    }

    public void pause() {
        if (!isPaused) {
            pauseScheduled = true;
        }
    }

    @Override
    public void handle(final long now) {
        if (pauseScheduled) {
            pauseStart = now;
            isPaused = true;
            pauseScheduled = false;
        }
    }

}
