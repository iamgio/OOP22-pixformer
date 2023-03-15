package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;

import java.util.function.Supplier;

/**
 * Defines a modification of a deserializable entity.
 */
public interface EntityMacro {

    /**
     * Applies a modification to an entity supplier.
     * @param entitySupplier supplier of entities
     * @return an entity, retrieved from the given supplier, with the given modifications
     */
    Entity apply(Supplier<Entity> entitySupplier);
}
