package pixformer.model.event;

import pixformer.model.entity.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Event manager to implements multiple listeners for the events.
 */
public class EventManager implements EventSubscriber, EventHandler{

    private final Set<Consumer<Entity>> listeners;

    /**
     * Constructor for the event manager.
     */
    public EventManager() {
        this.listeners = new HashSet<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void killed(final Entity entity) {
        listeners.forEach(cons -> cons.accept(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPlayerOnKill(final Consumer<Entity> consumer) {
        this.listeners.add(consumer);
    }
}
