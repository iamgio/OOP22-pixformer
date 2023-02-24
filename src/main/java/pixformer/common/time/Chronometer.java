package pixformer.common.time;

/**
 * Chronometer interface, representing a chronometer.
 */
public interface Chronometer {

    /**
     * Start the chronometer.
     */
    void start();

    /**
     * Stop the chronometer.
     * @return the time passed since the chronometer started
     */
    long end();
}
