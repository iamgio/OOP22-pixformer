package pixformer.model.entity.dynamic.player;

import java.util.Optional;
import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.physics.PhysicsComponent;
import pixformer.model.entity.powerups.PowerUp;
import pixformer.model.input.InputComponent;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements CompleteModelInput,
        DrawableEntity, DefaultRectangleBoundingBoxEntity {
    static final double GRAVITY = 1.0;
    static final double SPEED = 1.0;

    // This playerIndex
    private int playerIndex;

    // State variables to check if player is jumping or crouching
    private boolean isCrouching;
    private boolean isJumping;

    // Max duration of a jump
    static final double MAX_JUMP_DURATION = 5.0;
    static final double JUMP_FORCE = 1.0;

    // Current jump state
    private double jumpTimeCounter = MAX_JUMP_DURATION;

    // Current powerup
    private Optional<PowerUp> powerup;

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

        this.graphicsComponent = new PlayerGraphicsComponent();
        this.physicsComponent = new PlayerPhysicsComponent(new Vector2D(0, 0));
        this.collisionComponent = new PlayerCollisionComponent(this);
        this.inputComponent = new PlayerInputComponent(this);
    }

    /**
     * @return True if is crouching.
     */
    public boolean isCrouching() {
        return isCrouching;
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

}
