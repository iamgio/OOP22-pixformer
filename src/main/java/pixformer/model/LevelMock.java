package pixformer.model;

import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.entity.EntityFactoryImpl;

/**
 * @deprecated test
 */
@Deprecated
public class LevelMock extends LevelImpl {

    /**
     * Test level.
     */
    public LevelMock() {
        super(new JsonLevelDataDeserializer(new EntityFactoryImpl())
                .deserialize(Level.class.getResourceAsStream("/levels/test1.json")));
    }
}
