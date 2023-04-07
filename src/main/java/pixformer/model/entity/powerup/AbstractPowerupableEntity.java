package pixformer.model.entity.powerup;

import java.util.Optional;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.powerup.powerups.Mushroom;

/**
 * A base class for entity who can interact with powerups.
 */
public abstract class AbstractPowerupableEntity extends AbstractEntity implements Powerupable {
    private PowerUp powerup = new PowerUp();

    /**
     * 
     * @param x initial x position.
     * @param y initial y position.
     * @param width initial width of the entity.
     * @param height initial height of the entity.
     */
    protected AbstractPowerupableEntity(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPowerup(final PowerupBehaviour powerupBehaviour) {

        if (getPowerupBehaviour().isEmpty()) {

            if (powerupBehaviour.getPriority() > 1) {
                powerup = new PowerUp(new Mushroom());
            }
            powerup = new PowerUp(powerupBehaviour, powerup);

        } else {

            if (powerup.getBehaviour().get().getPriority() == powerupBehaviour.getPriority()) {

                if (powerup.getPrevious().isPresent()) {
                    powerup = new PowerUp(powerupBehaviour, powerup.getPrevious().get());
                } else {
                    powerup = new PowerUp(powerupBehaviour);
                }
                powerup = new PowerUp(powerupBehaviour, powerup);

            } else if (powerup.getBehaviour().get().getPriority() < powerupBehaviour.getPriority()) {

                powerup = new PowerUp(powerupBehaviour, powerup);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean downgrade() {
        if (powerup.getBehaviour().isEmpty()) {
            return false;
        }

        if (powerup.getPrevious().isEmpty()) {
            powerup = new PowerUp();
            return true;
        }

        powerup = powerup.getPrevious().get();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PowerupBehaviour> getPowerupBehaviour() {
        return powerup.getBehaviour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PowerUp getPowerup() {
        return powerup;
    }
}
