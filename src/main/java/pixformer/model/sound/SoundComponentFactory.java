package pixformer.model.sound;

import pixformer.model.entity.Entity;

/**
 * A factory for {@link SoundComponent} implementation for different entities.
 */
public interface SoundComponentFactory {

    /**
     * @param entity target of the graphics component
     * @return a sound component for a player entity
     */
    SoundComponent player(Entity entity);

    /**
     * @param entity target of the graphics component
     * @return a sound component for a fireball entity
     */
    SoundComponent fireball(Entity entity);
}
