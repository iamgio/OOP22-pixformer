package pixformer.model;

/**
 * Builder for {@link WorldOptions}.
 */
public class WorldOptionsBuilder {

    private int updateRange;

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
     * @return a new {@link WorldOptions} instance with the specified properties.
     */
    public WorldOptions build() {
        return new WorldOptions(updateRange);
    }
}
