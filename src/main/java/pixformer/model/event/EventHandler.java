package pixformer.model.event;

import pixformer.model.entity.Entity;

/**
 * Event handler to manage specific event that happens in the game.
 */
public interface EventHandler {

    /**
     * Handler to manage when an entity is killed by the player.
     *
     * @param entity entity who got killed
     */
    void killed(Entity entity);

}
