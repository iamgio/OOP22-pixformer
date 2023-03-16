package pixformer.model.entity.dynamic.player;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {
    private Player player;
    private boolean jumpKey = false;
    private boolean sprintKey = false;

    // Max duration of a jump
    private final float maxJumpDuration = 0.01f;

    // Speedup factor while sprinting
    static final float baseSpeedLimit = 0.01f;
    static final float sprintSpeedLimit = 0.02f;

    // Current jump state
    private float currentPlayerJump = maxJumpDuration;

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final Player entity) {
        super(entity);
        player = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(-PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        if (player.getPowerup().isPresent()) {
            player.getPowerup().get().getBehaviour().ability(player);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
        jumpKey = true;

        if (jump(-PlayerPhysicsComponent.JUMP_FORCE)) {
            this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(0, -PlayerPhysicsComponent.JUMP_FORCE)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sprint() {
        sprintKey = true;        
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final World world) {
        System.out.println("Speed: " + player.getVelocity().x());
        // Jump management
        if (!jumpKey && isJumping()) {
            stopJumping();
        }

        if (!player.isOnGround() && !isJumping()) {
            stopJumping();
        }

        jumpKey = false;

        // Player speed limit management
        int direction = player.getVelocity().x() >= 0 ? 1 : -1;

        if (!sprintKey && Math.abs(player.getVelocity().x()) > baseSpeedLimit) {
            player.setVelocity(new Vector2D(baseSpeedLimit * direction, player.getVelocity().y()));
        } else if (sprintKey && Math.abs(player.getVelocity().x()) > sprintSpeedLimit) {
            player.setVelocity(new Vector2D(sprintSpeedLimit * direction, player.getVelocity().y()));
        }
        
        sprintKey = true;  
        
        // Fireball cooldown management

    }

    /**
     * 
     * @param jumpForce Negative jumping force applied to the entity.
     * @return True if the player jumped, False if he couldnt.
     */
    public boolean jump(final float jumpForce) {
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
        return currentPlayerJump < maxJumpDuration;
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
        this.currentPlayerJump = maxJumpDuration;
    }
}
