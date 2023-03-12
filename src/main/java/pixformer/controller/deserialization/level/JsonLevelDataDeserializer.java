package pixformer.controller.deserialization.level;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import pixformer.model.LevelData;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * A level data deserializer from JSON format.
 */
public class JsonLevelDataDeserializer implements LevelDataDeserializer, JsonDeserializer<LevelData> {

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData deserialize(final InputStream inputStream) {
        return new GsonBuilder()
                .registerTypeAdapter(LevelData.class, this)
                .create()
                .fromJson(new InputStreamReader(inputStream), LevelData.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData deserialize(final JsonElement json,
                                 final Type typeOfT,
                                 final JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();

        String name = object.get("name").getAsString();
        int spawnPointX = object.get("spawnPointX").getAsInt();
        int spawnPointY = object.get("spawnPointY").getAsInt();

        // TODO entities
        return new LevelData(name, Set.of(), spawnPointX, spawnPointY);
    }
}
