package pixformer.model;

import pixformer.model.entity.TestEntity;

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
    public void setup() {
        final World world = super.getWorld();

        final var test1 = new TestEntity(5);
        final var test2 = new TestEntity(10);

        world.spawnEntity(test1);
        world.spawnEntity(test2);
    }
}
