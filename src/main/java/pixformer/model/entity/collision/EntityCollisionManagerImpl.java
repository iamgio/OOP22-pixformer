package pixformer.model.entity.collision;

import pixformer.model.World;
import pixformer.model.entity.Entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * The default implementation of an {@link EntityCollisionManager}.
 */
public class EntityCollisionManagerImpl implements EntityCollisionManager {

    private final World world;
    private final Map<Entity, Set<Consumer<Collision>>> onCollide = new HashMap<>();

    /**
     * @param world world to handle collisions in
     */
    public EntityCollisionManagerImpl(final World world) {
        this.world = world;
    }

    /**
     * @param entity1 first entity to check collisions with
     * @param entity2 second entity to check collisions with
     * @return whether the two entities collide with each other
     */
    private Optional<CollisionSide> getCollision(final Entity entity1, final Entity entity2) {
        return entity1.getBoundingBox().getCollisionSide(
                entity2.getBoundingBox(),
                entity1.getX(), entity1.getY(),
                entity2.getX(), entity2.getY()
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Collision> findCollisionsFor(final Entity entity) {
        return this.world.getEntities().stream()
                .filter(other -> entity != other)
                .map(other -> this.getCollision(entity, other))
                .flatMap(Optional::stream)
                .map(side -> new Collision(entity, side))
                .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Consumer<Collision>> getOnCollideCallbacksFor(final Entity entity) {
        final var callbacks = this.onCollide.get(entity);
        return callbacks != null ? Collections.unmodifiableSet(callbacks) : Collections.emptySet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnCollide(final Entity entity, final Consumer<Collision> action) {
        this.onCollide.computeIfAbsent(entity, e -> new HashSet<>()).add(action);
    }
}
