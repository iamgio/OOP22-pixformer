package pixformer.model.event;

import pixformer.model.entity.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Event manager to implements multiple listeners for the events.
 */
public class EventManager implements EventSubscriber, EventHandler {

    private final Set<BiConsumer<Entity, Entity>> listeners;

    /**
     * Simple constructor for the event manager.
     */
    public EventManager() {
        this.listeners = new HashSet<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void killed(final Entity entity, final Entity player) {
        listeners.forEach(cons -> cons.accept(player, entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPlayerOnKill(final BiConsumer<Entity, Entity> consumer) {
        this.listeners.add(consumer);
    }
}
