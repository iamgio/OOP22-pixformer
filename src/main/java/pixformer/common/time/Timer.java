package pixformer.common.time;

/**
 * Timer class to represent a timespan.
 */
public interface Timer {

    /**
     * Start the counting of the time.
     *
     * @param time time quantity that have to pass
     */
    void start(long time);

    /**
     * @return a bool representing if the timer has ended or not
     */
    boolean hasTimeLeft();

    /**
     * @return the time left to the end of the timer
     */
    long getTimeLeft();

    /**
     * Update internal timer.
     * @param dt time passed.
     */
    void update(long dt);

}
