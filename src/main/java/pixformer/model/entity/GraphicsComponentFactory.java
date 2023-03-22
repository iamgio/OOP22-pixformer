package pixformer.model.entity;

/**
 * A factory for {@link GraphicsComponent} implementation for different entities.
 */
public interface GraphicsComponentFactory {

    /**
     * @param entity block target
     * @return a graphics component for a tile block
     */
    GraphicsComponent tileBlock(Entity entity);

    /**
     * @param entity grass block
     * @return the graphics component for a grass block
     */
    GraphicsComponent grassBlock(Entity entity);

    /**
     * @param entity brick block
     * @return the graphics component for the brick block
     */
    GraphicsComponent brickBlock(Entity entity);

    /**
     * @param entity surprise block
     * @return the graphics component for the surprise block
     */
    GraphicsComponent surpriseBlock(Entity entity);

    /**
     * @param entity target entity
     * @return a new Goomba graphics component
     */
    GraphicsComponent goomba(Entity entity);
}
