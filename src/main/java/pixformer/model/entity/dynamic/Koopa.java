package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.BoundingBox;

public final class Koopa implements MutableEntity {

    private KoopaState currentKoopaState;

    public Koopa(final double x, final double y) {
        currentKoopaState = new WalkingKoopa(x, y, this::changeToTurtle);
    }

    private void changeToTurtle() {
        this.currentKoopaState = new TurtleKoopa(getX(), getY());
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
        return currentKoopaState.getWorld();
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
    public void setX(double x) {
       currentKoopaState.setX(x);
    }

    @Override
    public void setY(double y) {
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

}
