package pixformer.controller.deserialization.level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used on {@link pixformer.model.entity.EntityFactory} methods,
 * allows creating entity instances from a unique type represented by a string.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EntityType {

    /**
     * @return the entity type
     */
    String value();

    /**
     * @return names of the parameters from the target method
     */
    String[] parameters() default {"x", "y"};
}
