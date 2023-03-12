package pixformer;

import org.junit.jupiter.api.Test;
import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.LevelData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test of level deserialization.
 */
public class LevelDeserializationTest {

    @Test
    void testLevel1() {
        final LevelData data = new JsonLevelDataDeserializer()
                .deserialize(this.getClass().getResourceAsStream("/levels/test1.json"));

        assertEquals("First level", data.name());
        assertEquals(1, data.spawnPointX());
        assertEquals(2, data.spawnPointY());
    }
}
