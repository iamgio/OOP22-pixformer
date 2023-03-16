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

    /**
     * @param entity entity to check collisions for
     * @param side collision side to check collisions for
     * @return whether the entity is colliding a solid entity on the given side.
     */
    private boolean isCollingSolidEntity(Entity entity, CollisionSide side) {
        return this.findCollisionsFor(entity).stream()
                .filter(collision -> collision.side() == side)
                .anyMatch(collision -> collision.entity().isSolid());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingGround(final Entity entity) {
        return this.isCollingSolidEntity(entity, CollisionSide.BOTTOM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingCeiling(final Entity entity) {
        return this.isCollingSolidEntity(entity, CollisionSide.TOP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingRightWall(final Entity entity) {
        return this.isCollingSolidEntity(entity, CollisionSide.RIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingLeft(final Entity entity) {
        return this.isCollingSolidEntity(entity, CollisionSide.LEFT);
    }
}
