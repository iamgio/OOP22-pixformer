package pixformer.model.entity.dynamic.player;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.PowerUp;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.Powerupable;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.entity.powerup.powerups.Mushroom;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.entity.player.PlayerGraphicsComponent;

import java.lang.annotation.Inherited;
import java.util.Optional;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity, Powerupable {
    // This playerIndex
    private final int playerIndex;

    // State variable to check if player is sprinting
    private boolean isSprinting;

    // Current powerup
    private Optional<PowerUp> powerup;

    // Player components
    private final PlayerGraphicsComponent graphicsComponent;
    private final PlayerPhysicsComponent physicsComponent;
    private final PlayerCollisionComponent collisionComponent;
    private PlayerInputComponent inputComponent;

    /**
     * 
     * @param x      X position of the player.
     * @param y      Y position of the player.
     * @param width  Width of the player.
     * @param height Height of the player.
     * @param playerIndex Index of this player istance.
     */
    public Player(final double x, final double y, final double width, final double height, final int playerIndex) {
        super(x, y, width, height);

        this.playerIndex = playerIndex;
        this.powerup = Optional.of(new PowerUp(new FireFlower()));

        this.graphicsComponent = new PlayerGraphicsComponent(this);
        this.physicsComponent = new PlayerPhysicsComponent(this);
        this.collisionComponent = new PlayerCollisionComponent(this);
        this.inputComponent = new PlayerInputComponent(this);
    }

    /**
     * Return this entity player index.
     * @return playerIndex
     */
    public int getIndex() {
        return this.playerIndex;
    }

    /**
     * Set the new inputComponent.
     * @param inputComponent new Player's inputComponent.
     */
    public void setInputComponent(final PlayerInputComponent inputComponent) {
        this.inputComponent = inputComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(this.inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(this.collisionComponent);
    }

    /**
     * Return current physics component.
     * @return player's physics component.
     */
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(this.physicsComponent);
    }

    /**
     * Return current player powerup.
     * @return current player powerup.
     */
    public Optional<PowerUp> getPowerup() {
        return this.powerup;
    }

    /**
     * Set the new Powerup for the player.
     * @param powerupBehaviour the new powerup.
     */
    public void setPowerup(final PowerupBehaviour powerupBehaviour) {
        if (this.powerup.isEmpty()) {
            this.powerup = Optional.of(new PowerUp(powerupBehaviour));
        } else if (powerupBehaviour.getPriority() >= this.powerup.get().getBehaviour().getPriority()) {
            this.powerup = Optional.of(new PowerUp(powerupBehaviour));
        }
    }

    /**
     * Manage the player behaviour when jumping on an enemy.
     */
    public void onEnemyJump() {
        this.inputComponent.onEnemyJump();
    }

     /**
     * @return True if is sprinting.
     */
    public boolean isSprinting() {
        return isSprinting;
    }

    /**
     * @return true if the player is touching ground otherwise false.
     */
    public boolean isOnGround() {
        return collisionComponent.getIsOnGround();
    }

    /**
     * Define what happens when Player get damaged.
     */
    public void damaged() {
        if (this.powerup.isEmpty()) {
            kill();
        } else if (this.powerup.get().getBehaviour().getPriority() == 1) {
            this.powerup = Optional.empty();
        } else if (this.powerup.get().getBehaviour().getPriority() == 2) {
            this.powerup = Optional.of(new PowerUp(new Mushroom()));
        }
    }

    /**
     * Define what happens on Player death.
     */
    private void kill() {
        getWorld().get().dropEntity(this);
        //this.graphicsComponent.startDeathAnimation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PowerupBehaviour> getPowerupBehaviour() {
        return Optional.of(powerup.get().getBehaviour());
    }
}
