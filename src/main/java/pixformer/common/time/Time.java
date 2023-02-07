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
     * @return if the entity has ended the time
     */
    boolean hasEnded();

}
