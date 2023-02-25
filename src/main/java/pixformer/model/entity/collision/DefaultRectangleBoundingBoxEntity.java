package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

/**
 * A shortcut for defining a standard rectangle-shaped {@link BoundingBox}
 *  for an {@link Entity}, with its size matching that of the entity.
 */
public interface DefaultRectangleBoundingBoxEntity extends Entity {

    /**
     * {@inheritDoc}
     */
    @Override
    default BoundingBox getBoundingBox() {
        return new RectangleBoundingBox(getWidth(), getHeight());
    }
}
