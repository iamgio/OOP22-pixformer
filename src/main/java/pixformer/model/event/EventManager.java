package pixformer.model.event;

import pixformer.model.entity.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class EventManager implements EventSubscriber, EventHandler{

    private final Set<Consumer<Entity>> listeners;

    public EventManager() {
        this.listeners = new HashSet<>();
    }

    @Override
    public void killed(final Entity entity) {
        listeners.forEach(cons -> cons.accept(entity));
    }

    @Override
    public void addPlayerOnKill(final Consumer<Entity> consumer) {
        this.listeners.add(consumer);
    }
}
