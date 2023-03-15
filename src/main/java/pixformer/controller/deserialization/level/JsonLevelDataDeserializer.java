package pixformer.controller.deserialization.level;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import pixformer.model.LevelData;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * A level data deserializer from JSON format.
 */
public class JsonLevelDataDeserializer implements LevelDataDeserializer, JsonDeserializer<LevelData> {

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
                .registerTypeAdapter(LevelData.class, this)
                .create()
                .fromJson(new InputStreamReader(inputStream, Charset.defaultCharset()), LevelData.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData deserialize(final JsonElement json,
                                 final Type typeOfT,
                                 final JsonDeserializationContext context) throws JsonParseException {
        final JsonObject object = json.getAsJsonObject();

        final String name = object.get("name").getAsString();
        final int spawnPointX = object.get("spawnPointX").getAsInt();
        final int spawnPointY = object.get("spawnPointY").getAsInt();

        final EntityFactoryLookupDecorator lookup = new EntityFactoryLookupDecorator(this.factory);
        final Set<Entity> entities = new HashSet<>();

        for (final JsonElement entityElement : object.get("entities").getAsJsonArray()) {
            this.appendEntity(entities, entityElement.getAsJsonObject(), lookup);
        }

        return new LevelData(name, entities, spawnPointX, spawnPointY);
    }

    private void appendEntity(Set<Entity> entities, JsonObject json, EntityFactoryLookupDecorator lookup) {
        final String type = json.get("type").getAsString();

        final Entity entity = lookup.fromType(type,
                // Retrieving factory method's parameter values from JSON
                (parameterName, parameterType) -> new Gson().fromJson(json.get(parameterName), parameterType)
        );

        entities.add(entity);
    }
}
