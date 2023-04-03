package pixformer.model.entity.dynamic.player;

import pixformer.common.Vector2D;
import pixformer.common.time.ChronometerImpl;
import pixformer.model.World;
import pixformer.model.entity.dynamic.VelocitySetterFactory;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {
    private final PlayerImpl player;
    private boolean jumpKey;
    private boolean sprintKey;

    // State variable to check if player is sprinting
    private boolean isSprinting;

    /**
     * Max speed limit of a walking player.
     */
    public static final float BASE_SPEED_LIMIT = 0.008f;

    /**
     * Max speed limit of a sprinting player.
     */
    public static final float SPRINT_SPEED_LIMIT = 0.013f;

    private static final float FALLING_SPEED_LIMIT = 0.014f;

    private static final float SPEED = 0.000_3f;

    private static final float SPRINT_SPEED = 0.000_6f;

    // Max duration of a jump
    private static final float MAX_JUMP_DURATION = 0.09f;

    private static final float JUMP_FORCE = 0.0135f;

    // Ability cooldown in milliseconds
    private static final long ABILITY_COOLDOWN = 500;

    // Current jump state
    private float currentPlayerJump = MAX_JUMP_DURATION;

    // Chronometer for ability cooldown
    private final ChronometerImpl abilityDelay = new ChronometerImpl();

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final PlayerImpl entity) {
        super(entity);
        player = entity;
        abilityDelay.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        player.setVelocity(player.getVelocity().sum(new Vector2D(isSprinting ? -SPRINT_SPEED : -SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        player.setVelocity(player.getVelocity().sum(new Vector2D(isSprinting ? SPRINT_SPEED : SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        if (player.getPowerup().getBehaviour().isPresent() && abilityDelay.hasElapsed(ABILITY_COOLDOWN)) {
            player.getPowerup().getBehaviour().get().ability(player);

            abilityDelay.reset();
            abilityDelay.start();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
        jumpKey = true;

        if (currentPlayerJump > 0) {
            forceJump();
            currentPlayerJump -= JUMP_FORCE;
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
        // Jump management
        if (!jumpKey && isJumping()
            || !player.isOnGround() && !isJumping()
            || player.isTouchingAbove()) {
            stopJumping();
        }

        if (player.isOnGround()) {
            resetJumping();
        }

        jumpKey = false;

        // Player speed limit and sprint management

        VelocitySetterFactory.limitSpeed(player, sprintKey ? SPRINT_SPEED_LIMIT : BASE_SPEED_LIMIT);
        VelocitySetterFactory.limitFallingSpeed(player, FALLING_SPEED_LIMIT);

        isSprinting = sprintKey;

        sprintKey = false;
    }

     /**
     * Check if Player is jumping.
     * @return True if Player is jumping otherwise False.
     */
    public boolean isJumping() {
        return currentPlayerJump < MAX_JUMP_DURATION;
    }

    /**
     * Apply jump force to the player.
     */
    private void forceJump() {
        player.setVelocity(new Vector2D(player.getVelocity().x(), -JUMP_FORCE));
    }

    /**
     * Stop player on jumping further.
     */
    private void stopJumping() {
        this.currentPlayerJump = 0;
    }

    /**
     * Reset the "jumpCounter" variable.
     */
    private void resetJumping() {
        this.currentPlayerJump = MAX_JUMP_DURATION;
    }
}
