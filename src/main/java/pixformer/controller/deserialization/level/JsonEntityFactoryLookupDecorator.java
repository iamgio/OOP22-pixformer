package pixformer.controller.deserialization.level;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * An {@link EntityFactory} decorator whose objective is retrieving
 * entities from type strings specified by {@link EntityType} annotations.
 *
 * @see EntityFactory
 * @see EntityType
 */
public class JsonEntityFactoryLookupDecorator {

    private final EntityFactory factory;

    /**
     * @param factory entity factory to instantiate entities from
     */
    public JsonEntityFactoryLookupDecorator(final EntityFactory factory) {
        this.factory = factory;
    }

    /**
     * Retrieves an entity from its type.
     * @param type entity type, matching the one specified by the {@link EntityType} annotation
     * @param json json object that represents the entity
     * @return new instance of the matching entity
     * @throws java.util.NoSuchElementException if no entity with the given type was found
     */
    public Entity fromType(final String type, JsonObject json) {
        Method factoryMethod = Stream.of(factory.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(EntityType.class))
                .filter(method -> method.getAnnotation(EntityType.class).value().equals(type))
                .findFirst().orElseThrow();

        final Class<?>[] parameterTypes = factoryMethod.getParameterTypes();
        final String[] parameterNames = factoryMethod.getAnnotation(EntityType.class).parameters();

        // Values to pass as arguments
        final Object[] arguments = new Object[parameterTypes.length];

        if (arguments.length != parameterNames.length) {
            throw new IllegalArgumentException("Parameters count does not match.");
        }

        for (int i = 0; i < parameterNames.length; i++) {
            arguments[i] = new Gson().fromJson(json.get(parameterNames[i]), parameterTypes[i]);
        }

        try {
            return (Entity) factoryMethod.invoke(factory, arguments);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }
}
