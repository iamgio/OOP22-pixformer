package pixformer.model.entity.dynamic.player;

import java.util.Optional;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.entity.player.PlayerGraphicsComponent;
import pixformer.model.entity.powerups.FireFlower;
import pixformer.model.entity.powerups.Mushroom;
import pixformer.model.entity.powerups.PowerUp;
import pixformer.model.input.InputComponent;

/**
 * The class manages the character used by the player.
 */
public class Player extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {
    // This playerIndex
    private final int playerIndex;

    // State variable to check if player is sprinting
    private boolean isSprinting;

    // Current powerup
    private Optional<PowerUp> powerUp;

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
        this.powerUp = Optional.of(new PowerUp(new FireFlower()));

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
        return this.powerUp;
    }

     /**
     * @return True if is sprinting.
     */
    public boolean isSprinting() {
        return isSprinting;
    }

    /**
     * Define what happens when Player get damaged.
     */
    public void damaged() {
        if (this.powerUp.isEmpty()) {
            kill();
        }

        if (this.powerUp.get().getBehaviour().getPriority() == 2) {
            this.powerUp = Optional.of(new PowerUp(new Mushroom()));
        }

        if (this.powerUp.get().getBehaviour().getPriority() == 1) {
            this.powerUp = Optional.empty();
        }        
    }

    /**
     * Define what happens on Player death.
     */
    private void kill() {
        this.graphicsComponent.startDeathAnimation();
    }
}
