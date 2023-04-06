package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.powerup.PowerUp;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.powerups.Mushroom;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;
import pixformer.model.sound.SoundComponent;
import pixformer.view.entity.player.PlayerGraphicsComponent;

import java.util.Optional;

/**
 * The class manages the character used by the player.
 */
public class PlayerImpl extends AbstractEntity implements Player {
    static final double WIDTH = 0.94;
    static final double HEIGHT = 1;

    private final int playerIndex;

    // Current powerup
    private PowerUp powerup = new PowerUp();

    // Player components
    private PlayerGraphicsComponent graphicsComponent;
    private PlayerInputComponent inputComponent;
    private final PlayerPhysicsComponent physicsComponent;
    private final PlayerCollisionComponent collisionComponent;
    private final SoundComponent soundComponent;

    /**
     * @param x X position of the player.
     * @param y Y position of the player.
     * @param playerIndex Index of this player istance.
     */
    public PlayerImpl(final double x, final double y, final int playerIndex) {
        super(x, y, WIDTH, HEIGHT);

        graphicsComponent = new PlayerGraphicsComponent(this);
        physicsComponent = new PlayerPhysicsComponent(this);
        collisionComponent = new PlayerCollisionComponent(this);
        inputComponent = new PlayerInputComponent(this);
        soundComponent = new PlayerSoundComponent(this);

        powerup = new PowerUp();

        this.playerIndex = playerIndex;
    }

    /**
     * @param x X position of the player.
     * @param y Y position of the player.
     */
    public PlayerImpl(final double x, final double y) {
        this(x, y, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIndex() {
        return playerIndex;
    }

    /**
     * Set the new inputComponent.
     * 
     * @param newInputComponent new Player's inputComponent.
     */
    public void setInputComponent(final PlayerInputComponent newInputComponent) {
        inputComponent = newInputComponent;
    }

    /**
     * Set the new graphicsComponent.
     * 
     * @param newGraphicsComponent new Player's graphicsComponent.
     */
    public void setGraphicsComponent(final PlayerGraphicsComponent newGraphicsComponent) {
        this.graphicsComponent = newGraphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(physicsComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SoundComponent> getSoundComponent() {
        return Optional.of(soundComponent);
    }

    /**
     * Set the new Powerup for the player.
     * 
     * @param powerupBehaviour the new powerup.
     */
    public void setPowerup(final PowerupBehaviour powerupBehaviour) {

        if (powerup.getBehaviour().isPresent()) {
            if (powerup.getBehaviour().get().getPriority() == powerupBehaviour.getPriority()) {
                powerup = new PowerUp(powerupBehaviour, powerup.getPrevious().get());
            } else if (powerup.getBehaviour().get().getPriority() < powerupBehaviour.getPriority()) {
                powerup = new PowerUp(powerupBehaviour, powerup);
            }
        } else {

            if (powerupBehaviour.getPriority() > 1) {
                powerup = new PowerUp(new Mushroom(), powerup);
            }

            powerup = new PowerUp(powerupBehaviour, powerup);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOnGround() {
        return collisionComponent.isOnGround();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTouchingAbove() {
        return collisionComponent.isTouchingAbove();
    }

    /**
     * Define what happens when Player get damaged.
     */
    public void damaged() {
        if (powerup.getBehaviour().isEmpty()) {
            kill();
        } else {
            powerup = powerup.getPrevious().get();
        }
    }

    /**
     * Define what happens on Player death.
     */
    private void kill() {
        getWorld().get().queueEntityDrop(this);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void invulnerable(final long invincibleTime) {
        collisionComponent.invincibility(invincibleTime);
    }
}
