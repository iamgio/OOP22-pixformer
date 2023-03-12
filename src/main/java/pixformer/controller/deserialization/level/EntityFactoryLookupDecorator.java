package pixformer.controller.deserialization.level;

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
public class EntityFactoryLookupDecorator {

    private final EntityFactory factory;

    /**
     * @param factory entity factory to instantiate entities from
     */
    public EntityFactoryLookupDecorator(final EntityFactory factory) {
        this.factory = factory;
    }

    /**
     * Retrieves an entity from its type.
     * @param type entity type, matching the one specified by the {@link EntityType} annotation
     * @param x X coordinate
     * @param y Y coordinate
     * @return new instance of the matching entity
     * @throws java.util.NoSuchElementException if no entity with the given type was found
     */
    public Entity fromType(final String type, final int x, final int y) {
        Method factoryMethod = Stream.of(factory.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(EntityType.class))
                .filter(method -> method.getAnnotation(EntityType.class).value().equals(type))
                .findFirst().orElseThrow();

        try {
            return (Entity) factoryMethod.invoke(factory, x, y);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }
}
