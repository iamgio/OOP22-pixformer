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
    private boolean sprintKey;
    private boolean jumpKey;

    // State variable to check if player is sprinting
    private boolean isSprinting;

    /**
     * Max speed limit of a walking player.
     */
    public static final double BASE_SPEED_LIMIT = 0.008;

    /**
     * Max speed limit of a sprinting player.
     */
    public static final double SPRINT_SPEED_LIMIT = 0.013;

    private static final double FALLING_SPEED_LIMIT = 0.014;

    private static final double SPEED = 0.000_3;

    private static final double SPRINT_SPEED = 0.000_6;

    // Max duration of a jump
    private static final double INITIAL_JUMP_FORCE = -0.012;

    private static final double REVERSE_JUMP_FORCE = 0.000_25;

    // Ability cooldown in milliseconds
    private static final long ABILITY_COOLDOWN = 500;

    // Chronometer for ability cooldown
    private final ChronometerImpl abilityDelay = new ChronometerImpl();

    private double currentJumpForce;

    private boolean stopJumping;


    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final PlayerImpl entity) {
        super(entity);
        player = entity;
        abilityDelay.start();
        resetJumping();
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
        if (super.getEntity().getVelocity().y() <= 0 && !stopJumping) {
            currentJumpForce += REVERSE_JUMP_FORCE;
            forceJump(currentJumpForce);
        }

        jumpKey = true;
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
        if (player.isOnGround() 
            || player.isTouchingAbove()) {
            this.resetJumping();
        }

        if (isJumping() && !jumpKey) {
            stopJumping = true;
        }

        // Player speed limit and sprint management
        VelocitySetterFactory.limitSpeed(player, sprintKey ? SPRINT_SPEED_LIMIT : BASE_SPEED_LIMIT);
        VelocitySetterFactory.limitFallingSpeed(player, FALLING_SPEED_LIMIT);

        isSprinting = sprintKey;

        System.out.println(isJumping());

        sprintKey = false;
        jumpKey = false;
    }

     /**
     * Check if Player is jumping.
     * @return True if Player is jumping otherwise False.
     */
    public boolean isJumping() {
        return player.getVelocity().y() < 0;
    }

    /**
     * Apply jump force to the player.
     * @param force jump force to be applied.
     */
    private void forceJump(final double force) {
        player.setVelocity(player.getVelocity().copyWithY(force));
    }

    /**
     * Reset the "jumpCounter" variable.
     */
    private void resetJumping() {
        this.currentJumpForce = INITIAL_JUMP_FORCE;
        stopJumping = false;
    }
}
