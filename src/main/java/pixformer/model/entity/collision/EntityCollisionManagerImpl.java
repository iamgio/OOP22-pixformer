package pixformer.model.entity.collision;

import pixformer.model.World;
import pixformer.model.entity.Entity;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The default implementation of an {@link EntityCollisionManager}.
 */
public class EntityCollisionManagerImpl implements EntityCollisionManager {

    private final World world;

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
                .map(other -> this.getCollision(entity, other).map(side -> new Collision(other, side)))
                .flatMap(Optional::stream)
                .collect(Collectors.toUnmodifiableSet());
    }
}
