package pixformer.model.entity.dynamic.player;

import java.util.Optional;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.physics.PhysicsComponent;
import pixformer.model.entity.powerups.PowerUp;
import pixformer.model.input.InputComponent;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {
    // This playerIndex
    private int playerIndex;

    // State of the player life
    private boolean isAlive = true;

    // State variable to check if player is crouching
    private boolean isCrouching;

    // Current powerup
    private Optional<PowerUp> powerUp;

    // Player components
    private PlayerGraphicsComponent graphicsComponent;
    private PlayerPhysicsComponent physicsComponent;
    private PlayerCollisionComponent collisionComponent;
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
        this.powerUp = Optional.empty();

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
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(this.physicsComponent);
    }

    /**
     * Return current player powerup.
     * @return current player powerup.
     */
    public Optional<PowerUp> getPowerup() {
        return this.powerUp;
    }

     /**
     * @return True if is crouching.
     */
    public boolean isCrouching() {
        return isCrouching;
    }

    /**
     * Reset Jump of current entity.
     */
    public void resetJumping() {
        this.inputComponent.resetJumping();
    }

    /**
     * Define what happens when Player get damaged.
     */
    public void getDamage() {
        if(this.powerUp.isEmpty()) {
            death();
        }

        this.powerUp = Optional.empty();
    }

    /**
     * Define what happens on Player death.
     */
    private void death() {
        this.graphicsComponent.startDeathAnimation();
    }
}
