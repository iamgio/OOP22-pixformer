package pixformer.model;

/**
 * Builder for {@link WorldOptions}.
 */
public class WorldOptionsBuilder {

    private int updateRange;
    private int yFallThreshold;

    /**
     * Sets a new update range.
     * @param updateRange update range
     * @return this for concatenation
     */
    public WorldOptionsBuilder withUpdateRange(final int updateRange) {
        this.updateRange = updateRange;
        return this;
    }

    /**
     * Sets a new Y fall threshold.
     * @param yFallThreshold the minimum Y coordinate where entities are killed.
     * @return this for concatenation
     */
    public WorldOptionsBuilder withYFallThreshold(final int yFallThreshold) {
        this.yFallThreshold = yFallThreshold;
        return this;
    }

    /**
     * @return a new {@link WorldOptions} instance with the specified properties.
     */
    public WorldOptions build() {
        return new WorldOptions(updateRange, yFallThreshold);
    }
}
