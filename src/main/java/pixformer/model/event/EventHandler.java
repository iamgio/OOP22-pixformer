package pixformer.model.event;

import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;

/**
 * Event handler to manage specific event that happens in the game.
 */
public interface EventHandler {

    /**
     * Handler to manage when an entity is killed by the player.
     *
     * @param entity entity who got killed
     * @param player player who killed the entity
     */
    void killed(Entity entity, Entity player);

}
