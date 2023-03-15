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

    // Max duration of a jump
    static final float MAX_JUMP_DURATION = 0.01f;

    // Current jump state
    private float currentPlayerJump = MAX_JUMP_DURATION;

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

        System.out.println("LEFT");

        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(-PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {

        System.out.println("RIGHT");

        this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {

        System.out.println("ABILITY");

        if (player.getPowerup().isPresent()) {
            player.getPowerup().get().getBehaviour().ability();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {

        System.out.println("JUMP");

        jumpKey = true;

        if (jump(-PlayerPhysicsComponent.JUMP_FORCE)) {
            this.getEntity().setVelocity(this.getEntity().getVelocity().sum(new Vector2D(0, -PlayerPhysicsComponent.JUMP_FORCE)));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crouch() {
        System.out.println("CROUCH");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final World world) {
        if (!jumpKey && isJumping()) {
            stopJumping();
        }

        jumpKey = false;
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
}
