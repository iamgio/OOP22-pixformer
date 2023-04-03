package pixformer.common.time;

/**
 * Implementation of a Timer.
 */
public class TimerImpl implements Timer {

    private long timeLeft;

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final long time) {
        timeLeft = time;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasTimeLeft() {
        return timeLeft > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTimeLeft() {
        return timeLeft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final long dt) {
        timeLeft -= dt;

        if (timeLeft < 0) {
            timeLeft = 0;
        }
    }

}
