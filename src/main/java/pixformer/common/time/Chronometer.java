package pixformer.common.time;

/**
 * Simple Chronometer with the basic functionality.
 */
public interface Chronometer {

    /**
     * Start the chronometer.
     */
    void start();

    /**
     * Stop the chronometer.
     */
    void stop();

    /**
     * Reset the chronometer.
     */
    void reset();

    /**
     * Compare the chronometer with a time specific quantity.
     *
     * @param time to compare
     * @return if the time in input is elapsed
     */
    boolean hasElapsed(long time);

    /**
     * @return the time elapsed between the start and the stop of the chronometer
     */
    long getTimeElapsed();

    /**
     * @return whether the chronometer is running
     */
    boolean isRunning();
}
