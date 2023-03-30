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
    private final Player player;
    private boolean jumpKey;
    private boolean sprintKey;

    /**
     * Max speed limit of a walking player.
     */
    public static final float BASE_SPEED_LIMIT = 0.01f;

    /**
     * Max speed limit of a sprinting player.
     */
    public static final float SPRINT_SPEED_LIMIT = 0.02f;

    private static final float SPEED = 0.000_25f;

    // Max duration of a jump
    private static final float MAX_JUMP_DURATION = 0.023f;

    private static final float JUMP_FORCE = 0.0015f;

    // Ability cooldown in milliseconds
    private static final long ABILITY_COOLDOWN = 500;

    // Force multiplier applied to the jumpforce when jumping on an enemy
    private static final int ON_ENEMY_JUMP_MULTIPLIER = 7;

    // Current jump state
    private float currentPlayerJump = MAX_JUMP_DURATION;

    // Chronometer for ability cooldown
    private final ChronometerImpl abilityDelay = new ChronometerImpl();

    // Chronometer for the jump trigger on enemies
    private final ChronometerImpl onEnemyJumpDelay = new ChronometerImpl();

    /**
     * 
     * @param entity Entity associated with current component
     */
    protected PlayerInputComponent(final Player entity) {
        super(entity);
        player = entity;
        abilityDelay.start();
        onEnemyJumpDelay.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        player.setVelocity(player.getVelocity().sum(new Vector2D(-SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        player.setVelocity(player.getVelocity().sum(new Vector2D(SPEED, 0)));
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
        System.out.println(player.getVelocity().x() + " " + player.getVelocity().y());
        // Jump management
        if (!jumpKey && isJumping()) {
            stopJumping();
        }

        if (!player.isOnGround() && !isJumping()) {
            stopJumping();
        }

        if (player.isOnGround()) {
            resetJumping();
        }

        jumpKey = false;

        // Player speed limit and sprint management

        VelocitySetterFactory.limitSpeed(player, sprintKey ? SPRINT_SPEED_LIMIT : BASE_SPEED_LIMIT);

        player.setVelocity(player.getVelocity().copyWithY(Math.abs(player.getVelocity().y()) > 0.014 ? 0.014 * Math.signum(player.getVelocity().y()) : player.getVelocity().y()));

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
        player.setVelocity(new Vector2D(player.getVelocity().x(), -JUMP_FORCE * ON_ENEMY_JUMP_MULTIPLIER));
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
