package pixformer.model.event;

import pixformer.model.entity.Entity;

import java.util.function.Consumer;

/**
 * Event manager for what happens in the game, do specific action depending on what happened.
 */
public interface EventSubscriber {

    /**
     * Add an observer when the player kill an entity.
     */
    void addPlayerOnKill(Consumer<Entity> consumer);
}
