package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

/**
 * The implementation of the enemy Koopa. This class uses the two states of a
 * Koopa: walking and turtle.
 */
public final class Koopa implements KoopaState, DrawableEntity, DefaultRectangleBoundingBoxEntity {

    private KoopaState currentKoopaState;
    private World world;

    /**
     * Create a new Koopa.
     * 
     * @param x its initial x position.
     * @param y its initial y position.
     */
    public Koopa(final double x, final double y) {
        currentKoopaState = new WalkingKoopa(x, y, this::changeToTurtle);
    }

    @Override
    public boolean isWalking() {
        return currentKoopaState.isWalking();
    }

    @Override
    public boolean isTurtle() {
        return currentKoopaState.isTurtle();
    }

    private void changeToTurtle() {
        this.currentKoopaState = new TurtleKoopa(getX(), getY());
        currentKoopaState.onSpawn(getWorld().get());
    }

    @Override
    public double getX() {
        return currentKoopaState.getX();
    }

    @Override
    public double getY() {
        return currentKoopaState.getY();
    }

    @Override
    public double getWidth() {
        return currentKoopaState.getWidth();
    }

    @Override
    public double getHeight() {
        return currentKoopaState.getHeight();
    }

    @Override
    public Vector2D getVelocity() {
        return currentKoopaState.getVelocity();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return currentKoopaState.getBoundingBox();
    }

    @Override
    public Optional<World> getWorld() {
        return Optional.of(world);
    }

    @Override
    public boolean isSolid() {
        return currentKoopaState.isSolid();
    }

    @Override
    public boolean isOnGround() {
        return currentKoopaState.isOnGround();
    }

    @Override
    public void setX(final double x) {
        currentKoopaState.setX(x);
    }

    @Override
    public void setY(final double y) {
        currentKoopaState.setY(y);
    }

    @Override
    public void setWidth(final double width) {
        this.currentKoopaState.setWidth(width);
    }

    @Override
    public void setHeight(final double height) {
        this.currentKoopaState.setHeight(height);
    }

    @Override
    public void setVelocity(final Vector2D velocity) {
        this.currentKoopaState.setVelocity(velocity);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return new RectangleGraphicsComponent(this, new Color(0, 1, 0));
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return currentKoopaState.getCollisionComponent();
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return currentKoopaState.getInputComponent();
    }

    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return currentKoopaState.getPhysicsComponent();
    }

    @Override
    public void onSpawn(final World world) {
        this.world = world;
        currentKoopaState.onSpawn(getWorld().get());
    }

}
