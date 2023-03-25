package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.Set;

/**
 * A {@link CollisionComponent} that handles entity collisions involving solid entities,
 * and affecting its velocity and position on top of them.
 */
public class SolidCollisionComponent extends CollisionComponent {

    private static final double DEFAULT_FRICTION = 1;
    private static final double PUSH_DOWN_FORCE = 0.005;

    private final double friction;

    /**
     * Initializes a solid collision component.
     * @param entity target entity
     * @param friction friction on the entity when touching the ground
     */
    public SolidCollisionComponent(final MutableEntity entity, final double friction) {
        super(entity);
        this.friction = friction;
    }

    /**
     * Initializes a solid collision component.
     * @param entity target entity
     */
    public SolidCollisionComponent(final MutableEntity entity) {
        this(entity, DEFAULT_FRICTION);
    }

    /**
     * @param collisions collisions the entity is involved in
     * @param side collision side to check collisions for
     * @return whether the entity is colliding a solid entity on the given side.
     */
    private boolean isCollingSolidEntity(final Set<Collision> collisions, final CollisionSide side) {
        return collisions.stream()
                .filter(collision -> collision.side() == side)
                .anyMatch(collision -> collision.entity().isSolid());
    }

    /**
     * @param collisions collisions the entity is involved in
     * @return whether the entity is colliding a solid entity on the bottom side.
     */
    protected boolean isCollidingGround(Set<Collision> collisions) {
        return this.isCollingSolidEntity(collisions, CollisionSide.BOTTOM);
    }

    /**
     * @param collisions collisions the entity is involved in
     * @return whether the entity is colliding a solid entity on the top side.
     */
    protected boolean isCollidingCeiling(Set<Collision> collisions) {
        return this.isCollingSolidEntity(collisions, CollisionSide.TOP);
    }

    /**
     * @param collisions collisions the entity is involved in
     * @return whether the entity is colliding a solid entity on the left side.
     */
    protected boolean isCollidingLeftWall(Set<Collision> collisions) {
        return this.isCollingSolidEntity(collisions, CollisionSide.RIGHT); // TODO swap
    }

    /**
     * @param collisions collisions the entity is involved in
     * @return whether the entity is colliding a solid entity on the right side.
     */
    protected boolean isCollidingRightWall(Set<Collision> collisions) {
        return this.isCollingSolidEntity(collisions, CollisionSide.LEFT);
    }

    /**
     * {@inheritDoc}
     */
    @OverridingMethodsMustInvokeSuper
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        final MutableEntity entity = super.getEntity();
        if (this.isCollidingGround(collisions)) {
            entity.setVelocity(entity.getVelocity().copyWithX(entity.getVelocity().x() * this.friction));
        }
        // Ground collision
        if (entity.getVelocity().y() > 0 && isCollidingGround(collisions)) {
            entity.setVelocity(entity.getVelocity().copyWithY(0));
            entity.setY(Math.floor(entity.getY())); // Fixes intersections.
        }

        // Ceiling collision
        if (entity.getVelocity().y() < 0 && isCollidingCeiling(collisions)) {
            entity.setVelocity(entity.getVelocity().copyWithY(PUSH_DOWN_FORCE));
            entity.setY(Math.ceil(entity.getY()));
        }

        // Left wall collision
        if (entity.getVelocity().x() < 0 && isCollidingLeftWall(collisions)) {
            entity.setVelocity(entity.getVelocity().copyWithX(0));
            entity.setX(Math.ceil(entity.getX()));
        }

        // Right wall collision
        if (entity.getVelocity().x() > 0 && isCollidingRightWall(collisions)) {
            entity.setVelocity(entity.getVelocity().copyWithX(0));
            entity.setX(Math.floor(entity.getX()));
        }
    }
}
