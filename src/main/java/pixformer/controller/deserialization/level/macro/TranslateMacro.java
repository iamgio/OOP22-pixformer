package pixformer.controller.deserialization.level.macro;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;

import java.util.Set;
import java.util.function.Supplier;

/**
 * A macro that applies a 2D translation to a {@link MutableEntity}.
 */
public class TranslateMacro implements EntityMacro {

    private final int x;
    private final int y;

    /**
     * @param x X offset
     * @param y Y offset
     */
    public TranslateMacro(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException if the provided entity is not an instance of {@link MutableEntity}
     */
    @Override
    public Set<Entity> apply(final Supplier<Entity> entitySupplier) {
        final Entity entity = entitySupplier.get();
        if (entity instanceof MutableEntity mutableEntity) {
            mutableEntity.setX(mutableEntity.getX() + this.x);
            mutableEntity.setY(mutableEntity.getY() + this.y);
        } else {
            throw new IllegalArgumentException("Translation macro requires mutable entities");
        }
        return Set.of(entity);
    }
}
