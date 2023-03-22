package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

/**
 * A proxy pattern for {@link MutableEntity} which proxies {@code setVelocity} applying the change to the velocity only
 * to the x component.
 */
public final class ProxyMutableEntity implements MutableEntity {
    private final MutableEntity proxiedEntity;

    /**
     * @param proxied the entity this object will proxy.
     */
    public ProxyMutableEntity(final MutableEntity proxied) {
        this.proxiedEntity = proxied;
    }

    @Override
    public void setVelocity(final Vector2D velocity) {
        proxiedEntity.setVelocity(getVelocity().copyWithX(velocity.x()));
    }

    @Override
    public Optional<World> getWorld() {
        return proxiedEntity.getWorld();
    }

    @Override
    public double getX() {
        return proxiedEntity.getX();
    }

    @Override
    public double getY() {
        return proxiedEntity.getY();
    }

    @Override
    public double getWidth() {
        return proxiedEntity.getWidth();
    }

    @Override
    public double getHeight() {
        return proxiedEntity.getHeight();
    }

    @Override
    public Vector2D getVelocity() {
        return proxiedEntity.getVelocity();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return proxiedEntity.getBoundingBox();
    }

    @Override
    public boolean isSolid() {
        return proxiedEntity.isSolid();
    }

    @Override
    public double getDistanceFrom(final Entity other) {
        return proxiedEntity.getDistanceFrom(other);
    }

    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return proxiedEntity.getPhysicsComponent();
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return proxiedEntity.getInputComponent();
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return proxiedEntity.getCollisionComponent();
    }

    @Override
    public void onSpawn(final World world) {
        proxiedEntity.onSpawn(world);
    }

    @Override
    public void setX(final double x) {
        proxiedEntity.setX(x);
    }

    @Override
    public void setY(final double y) {
        proxiedEntity.setY(y);
    }

    @Override
    public void setWidth(final double width) {
        proxiedEntity.setWidth(width);
    }

    @Override
    public void setHeight(final double height) {
        proxiedEntity.setHeight(height);
    }
}
