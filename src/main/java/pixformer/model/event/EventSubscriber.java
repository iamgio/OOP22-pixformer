package pixformer.model.event;

import pixformer.model.entity.Entity;

import java.util.function.BiConsumer;

/**
 * Event manager for what happens in the game, do specific action depending on what happened.
 */
public interface EventSubscriber {

    /**
     * Add an observer when the player kill an entity.
     *
     * @param consumer consumer subscribed to a specific event
     */
    void addPlayerOnKill(BiConsumer<Entity, Entity> consumer);
}
