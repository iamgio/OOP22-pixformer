package pixformer.controller.deserialization.level;

import com.google.gson.GsonBuilder;
import pixformer.model.LevelData;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * A level data deserializer from JSON format.
 */
public class JsonLevelDataDeserializer implements LevelDataDeserializer {

    private final EntityFactory factory;

    /**
     * @param factory entity factory to create entities from
     */
    public JsonLevelDataDeserializer(final EntityFactory factory) {
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData deserialize(final InputStream inputStream) {
        return new GsonBuilder()
                .registerTypeAdapter(Entity.class,
                        new JsonEntityDeserializer(new EntityFactoryLookupDecorator(factory)))
                .create()
                .fromJson(new InputStreamReader(inputStream, Charset.defaultCharset()), LevelData.class);
    }
}
