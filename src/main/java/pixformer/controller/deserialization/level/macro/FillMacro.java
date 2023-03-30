package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * A macro that copies a {@link pixformer.model.entity.MutableEntity} in a given rectangle area.
 */
public class FillMacro implements EntityMacro {

    private final int width;
    private final int height;

    /**
     * @param width fill area width
     * @param height fill area height
     */
    public FillMacro(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException if the provided entity is not an instance of {@link pixformer.model.entity.MutableEntity}
     */
    @Override
    public Set<Entity> apply(final Supplier<Entity> entitySupplier) {
        Set<Entity> entities = new HashSet<>();
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                entities.addAll(new TranslateMacro(x, y).apply(entitySupplier));
            }
        }
        return entities;
    }
}
