package pixformer.model.entity;

/**
 * A factory for {@link GraphicsComponent} implementation for different entities.
 */
public interface GraphicsComponentFactory {

    /**
     * @param entity target entity
     * @return a new Goomba graphics component
     */
    GraphicsComponent goomba(Entity entity);
}
