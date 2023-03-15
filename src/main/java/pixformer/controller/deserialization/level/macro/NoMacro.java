package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;

import java.util.Set;
import java.util.function.Supplier;

/**
 * A macro that does not apply any modification.
 */
public class NoMacro implements EntityMacro {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> apply(final Supplier<Entity> entitySupplier) {
        return Set.of(entitySupplier.get());
    }
}
