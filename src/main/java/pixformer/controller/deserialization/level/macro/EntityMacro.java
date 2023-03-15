package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;

import java.util.Set;
import java.util.function.Supplier;

/**
 * Defines a modification of a deserializable entity.
 */
public interface EntityMacro {

    /**
     * Applies a modification to an entity supplier and produces one or more entity outputs.
     * @param entitySupplier supplier of entities
     * @return one or more entities, retrieved from the given supplier, with the given modifications
     */
    Set<Entity> apply(Supplier<Entity> entitySupplier);
}
