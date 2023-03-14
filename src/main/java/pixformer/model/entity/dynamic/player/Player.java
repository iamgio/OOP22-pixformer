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

    // Max duration of a jump
    static final float MAX_JUMP_DURATION = 0.01f;

    // State variable to check if player is crouching
    private boolean isCrouching;

    // Current jump state
    private float currentPlayerJump = MAX_JUMP_DURATION;

    // Current powerup
    private Optional<PowerUp> powerUp;

    // Player components
    private GraphicsComponent graphicsComponent;
    private PhysicsComponent physicsComponent;
    private CollisionComponent collisionComponent;
    private InputComponent inputComponent;

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
    public void setInputComponent(final InputComponent inputComponent) {
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
     * 
     * @param jumpForce Negative jumping force applied to the entity.
     * @return True if the player jumped, False if he couldnt.
     */
    public boolean jump(final float jumpForce) {

        System.out.println(currentPlayerJump);

        if (currentPlayerJump <= 0) {
            return false;
        }

        currentPlayerJump += jumpForce;
        return true;
    }

    /**
     * Check if Player is jumping.
     * @return True if Player is jumping.
     */
    public boolean isJumping() {
        return currentPlayerJump < MAX_JUMP_DURATION;
    }

    /**
     * Block player jump.
     */
    public void stopJumping() {
        this.currentPlayerJump = 0;
    }

    /**
     * Reset the "jump counter" variable.
     */
    public void resetJumping() {
        this.currentPlayerJump = MAX_JUMP_DURATION;
    }

    public void getDamage() {
        if(powerUp.isEmpty()) {
            death();
        }

        powerUp = Optional.empty();
    }

    private void death() {

    }
}
