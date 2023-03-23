package pixformer.model;

import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

/**
 * @deprecated test
 */
@Deprecated
public class LevelMock extends LevelImpl {

    /**
     * Test level.
     */
    public LevelMock() {
        super(new JsonLevelDataDeserializer(new EntityFactoryImpl(new SpritesGraphicsComponentFactory()))
                .deserialize(Level.class.getResourceAsStream("/levels/test2.json")));
    }
}
