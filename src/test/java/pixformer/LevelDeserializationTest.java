package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.LevelData;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.entity.statics.Block;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Test of level deserialization.
 */
public class LevelDeserializationTest {

    @Test
    void testLevel1() {
        final LevelData data = new JsonLevelDataDeserializer(new EntityFactoryImpl())
                .deserialize(this.getClass().getResourceAsStream("/levels/test1.json"));

        assertEquals("First level", data.name());
        assertEquals(1, data.spawnPointX());
        assertEquals(2, data.spawnPointY());
        assertEquals(1, data.entities().size());

        Entity first = data.entities().iterator().next();

        assertInstanceOf(Block.class, first);
        assertEquals(first.getX(), 10);
        assertEquals(first.getY(), 10);
    }
}
