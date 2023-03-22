package pixformer.model;

/**
 * Options that affect a {@link World}'s behavior.
 *
 * @param updateRange the range around each player in which surrounding entities are updated
 */
public record WorldOptions(int updateRange) {

    /**
     * Update range that allows every entity in the world to be updated,
     * even if there is no player.
     */
    public static final int INFINITE_UPDATE_RANGE = Integer.MAX_VALUE;
}
