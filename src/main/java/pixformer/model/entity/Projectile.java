package pixformer.model.entity;

/**
 * Represents an entity which can be fired, thrown or shooted by another entity.
 */
public interface Projectile extends Entity {
    /**
     * @return the entity who shot this entity.
     */
    Entity getShooter();
}
