package pixformer.common.time;

/**
 * Time class to represent a timespan.
 */
public interface Time {

    /**
     * Start the counting of the time.
     */
    void start();

    /**
     * Stop the time counter.
     * @return the time passed since the counter started.
     */
    long end();

    /**
     * @return a bool representing if the timer has ended or not
     */
    boolean hasTimeLeft();

}
