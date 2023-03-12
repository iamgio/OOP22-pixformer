package pixformer.controller.deserialization.level;

import pixformer.model.LevelData;

import java.io.InputStream;

/**
 * A deserializer of {@link LevelData}.
 */
public interface LevelDataDeserializer {

    /**
     * Converts raw data to level data.
     * @param inputStream input stream to parse
     * @return deserialized level data
     */
    LevelData deserialize(InputStream inputStream);
}
