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

        final World world = super.getWorld();
    }
}
