package pixformer;

import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.powerup.AbstractPowerupableEntity;
import pixformer.model.entity.powerup.PowerUp;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.physics.PhysicsComponent;

import java.util.Optional;

/**
 * A mock for Player entity. Use this only for unit tests.
 */
class PlayerMock extends AbstractPowerupableEntity implements Player {
    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width of the entity
     * @param height height of the entity
     */
    PlayerMock(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return null;
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public void invulnerable(final long invincibleTime) {

    }

    @Override
    public boolean isOnGround() {
        return false;
    }

    @Override
    public boolean isTouchingAbove() {
        return false;
    }

    @Override
    public Optional<PowerupBehaviour> getPowerupBehaviour() {
        return Optional.empty();
    }

    @Override
    public PowerUp getPowerup() {
        return null;
    }

    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(new PhysicsComponent(this));
    }
}
