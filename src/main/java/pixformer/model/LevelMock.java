package pixformer.model;

/**
 * @deprecated test
 */
@Deprecated
public class LevelMock extends LevelImpl {

    /**
     * Test level.
     */
    public LevelMock() {
        super("TestLevel", new WorldImpl());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup(final int playersAmount) {
        super.setup(playersAmount);
    }
}
