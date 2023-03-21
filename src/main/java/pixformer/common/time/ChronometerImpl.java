package pixformer.common.time;

/**
 * {@inheritDoc}.
 */
public class ChronometerImpl implements Chronometer {
    private long startTime;
    private long stopTime;
    private boolean isRunning;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.isRunning = true;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.isRunning = false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void reset() {
        this.startTime = 0;
        this.stopTime = 0;
        this.isRunning = false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean hasElapsed(final long time) {
        if (this.isRunning) {
            return (System.currentTimeMillis() - startTime) - time >= 0;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTimeElapsed() {
        return this.stopTime - this.startTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return this.isRunning;
    }
}
