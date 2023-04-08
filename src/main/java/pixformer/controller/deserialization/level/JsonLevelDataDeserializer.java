package pixformer.controller.deserialization.level;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import pixformer.controller.deserialization.level.macro.EntityMacro;
import pixformer.controller.deserialization.level.macro.FillMacro;
import pixformer.controller.deserialization.level.macro.NoMacro;
import pixformer.controller.deserialization.level.macro.TranslateMacro;
import pixformer.model.LevelData;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

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
                                 final JsonDeserializationContext context) {
        final JsonObject object = json.getAsJsonObject();

        final String name = object.get("name").getAsString();
        final int spawnPointX = object.get("spawnPointX").getAsInt();
        final int spawnPointY = object.get("spawnPointY").getAsInt();

        final EntityFactoryLookupDecorator lookup = new EntityFactoryLookupDecorator(this.factory);
        final Set<Entity> entities = new HashSet<>();

        for (final JsonElement entityElement : object.get("entities").getAsJsonArray()) {
            this.appendEntity(entities, entityElement.getAsJsonObject(), lookup);
        }

        return new LevelData(name, factory, entities, spawnPointX, spawnPointY);
    }

    private void appendEntity(final Set<Entity> entities, final JsonObject json, final EntityFactoryLookupDecorator lookup) {
        final String type = json.get("type").getAsString();


        final Supplier<Entity> entitySupplier = lookup.fromType(type,
                // Retrieving factory method's parameter values from JSON
                (parameterName, parameterType) -> new Gson().fromJson(json.get(parameterName), parameterType)
        );

        final EntityMacro macro = this.retrieveMacro(json.getAsJsonObject("macro"));

        entities.addAll(macro.apply(entitySupplier));
    }

    private EntityMacro retrieveMacro(final JsonObject macroJson) {
        if (macroJson == null) {
            return new NoMacro();
        }

        return switch (macroJson.get("type").getAsString()) {
            case "fill" -> {
                final int width = macroJson.get("width").getAsInt();
                final int height = macroJson.get("height").getAsInt();
                yield new FillMacro(width, height);
            }
            case "translate" -> {
                final int x = macroJson.get("x").getAsInt();
                final int y = macroJson.get("y").getAsInt();
                yield new TranslateMacro(x, y);
            }
            default -> new NoMacro();
        };
    }
}
