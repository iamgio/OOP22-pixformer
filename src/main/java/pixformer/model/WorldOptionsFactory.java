package pixformer.model;

/**
 * Static factory for {@link WorldOptions}.
 */
public final class WorldOptionsFactory {

    /**
     * The distance range from any player in which entities are updated.
     */
    private static final int DEFAULT_UPDATE_RANGE = 8;

    /**
     * @return the default options for visual gameplay
     */
    public static WorldOptions defaultOptions() {
        return new WorldOptionsBuilder()
                .withUpdateRange(DEFAULT_UPDATE_RANGE)
                .build();
    }

    /**
     * @return the default options for tests
     */
    public static WorldOptions testOptions() {
        return new WorldOptionsBuilder()
                .withUpdateRange(WorldOptions.INFINITE_UPDATE_RANGE)
                .build();
    }
}
