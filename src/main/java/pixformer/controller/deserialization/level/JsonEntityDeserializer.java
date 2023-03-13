package pixformer.controller.deserialization.level;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import pixformer.model.entity.Entity;

import java.lang.reflect.Type;

/**
 * A JSON deserializer for {@link Entity}.
 */
public class JsonEntityDeserializer implements JsonDeserializer<Entity> {

    private final JsonEntityFactoryLookupDecorator lookup;

    /**
     * @param lookup entity lookup from its {@link pixformer.model.entity.EntityFactory}
     */
    JsonEntityDeserializer(final JsonEntityFactoryLookupDecorator lookup) {
        this.lookup = lookup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity deserialize(final JsonElement json,
                                 final Type typeOfT,
                                 final JsonDeserializationContext context) throws JsonParseException {
        final JsonObject object = json.getAsJsonObject();
        final String type = object.get("type").getAsString();
        return lookup.fromType(type, object);
    }
}
