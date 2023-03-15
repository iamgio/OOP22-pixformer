package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;

import java.util.function.Supplier;

/**
 * A macro that does not apply any modification.
 */
public class NoMacro implements EntityMacro {

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity apply(final Supplier<Entity> entitySupplier) {
        return entitySupplier.get();
    }
}
