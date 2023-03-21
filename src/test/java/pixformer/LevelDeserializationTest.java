package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.LevelData;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.statics.Block;
import pixformer.view.entity.NullGraphicsComponentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Test of level deserialization.
 */
public class LevelDeserializationTest {

    @Test
    void testSimple() {
        final LevelData data = new JsonLevelDataDeserializer(new EntityFactoryImpl(new NullGraphicsComponentFactory()))
                .deserialize(this.getClass().getResourceAsStream("/levels/test1.json"));

        assertEquals("First level", data.name());
        assertEquals(1, data.spawnPointX());
        assertEquals(2, data.spawnPointY());
        assertEquals(2, data.entities().size());

        Entity block = data.entities().stream().filter(Block.class::isInstance).findFirst().orElseThrow();

        assertInstanceOf(Block.class, block);
        assertEquals(block.getX(), 10);
        assertEquals(block.getY(), 10);
    }

    @Test
    void testMacro() {
        final LevelData data = new JsonLevelDataDeserializer(new EntityFactoryImpl(new NullGraphicsComponentFactory()))
                .deserialize(this.getClass().getResourceAsStream("/levels/test2.json"));

        assertEquals("Second level", data.name());
        assertEquals(5 * 3, data.entities().size());

        for (Entity entity : data.entities()) {
            assertInstanceOf(Block.class, entity);
        }
    }
}
