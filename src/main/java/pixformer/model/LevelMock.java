package pixformer.model;

import pixformer.model.entity.TestEntity;

import java.util.Set;

/**
 * @deprecated test
 */
@Deprecated
public class LevelMock extends LevelImpl {

    /**
     * Test level.
     */
    public LevelMock() {
        super(new LevelData("TestLevel", Set.of(new TestEntity(15)), 5, 5));
    }
}
