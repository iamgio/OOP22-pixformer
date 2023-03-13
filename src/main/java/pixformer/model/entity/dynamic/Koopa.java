package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.BoundingBox;

public class Koopa implements Entity {

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

}
