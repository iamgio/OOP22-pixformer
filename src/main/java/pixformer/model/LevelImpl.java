package pixformer.model;

/**
 * Implementation of a game level.
 */
public class LevelImpl implements Level {

    private final String name;
    private final World world;

    /**
     * @param name level name
     * @param world game world of the level
     */
    public LevelImpl(final String name, final World world) {
        this.name = name;
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public World getWorld() {
        return this.world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {

    }
}
