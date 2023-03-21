package pixformer.model.entity.dynamic.player;

import pixformer.common.Vector2D;
import pixformer.common.time.ChronometerImpl;
import pixformer.model.World;
import pixformer.model.input.UserInputComponent;
import pixformer.model.modelinput.CompleteModelInput;

/**
 * Implementation of InputComponent for a Player entity.
 */
public class PlayerInputComponent extends UserInputComponent implements CompleteModelInput {
    private final Player player;
    private boolean jumpKey;
    private boolean sprintKey;

    // Max duration of a jump
    private static final float MAX_JUMP_DURATION = 0.01f;

    // Speed-limits of the player
    private static final float BASE_SPEED_LIMIT = 0.01f;
    private static final float SPRINT_SPEED_LIMIT = 0.02f;

    // Ability cooldown in milliseconds
    private static final long ABILITY_COOLDOWN = 500;

    // On enemy jump cooldown in milliseconds
    private static final long ON_ENEMY_JUMP_COOLDOWN = 500;

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
        player.setVelocity(player.getVelocity().sum(new Vector2D(-PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        player.setVelocity(player.getVelocity().sum(new Vector2D(PlayerPhysicsComponent.SPEED, 0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        if (player.getPowerup().isPresent() && abilityDelay.hasElapsed(ABILITY_COOLDOWN)) {
            player.getPowerup().get().getBehaviour().ability(player);

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
            currentPlayerJump -= PlayerPhysicsComponent.JUMP_FORCE;
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
        final int direction = player.getVelocity().x() >= 0 ? 1 : -1;

        if (!sprintKey && Math.abs(player.getVelocity().x()) > BASE_SPEED_LIMIT) {
            player.setVelocity(new Vector2D(BASE_SPEED_LIMIT * direction, player.getVelocity().y()));
        } else if (sprintKey && Math.abs(player.getVelocity().x()) > SPRINT_SPEED_LIMIT) {
            player.setVelocity(new Vector2D(SPRINT_SPEED_LIMIT * direction, player.getVelocity().y()));
        }

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
        player.setVelocity(new Vector2D(player.getVelocity().x(), -PlayerPhysicsComponent.JUMP_FORCE*ON_ENEMY_JUMP_MULTIPLIER));
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

    /**
     * Force a jump on player.
     */
    public void onEnemyJump() {

        if (onEnemyJumpDelay.hasElapsed(ON_ENEMY_JUMP_COOLDOWN)) {
            resetJumping();
            forceJump();
            onEnemyJumpDelay.reset();
            onEnemyJumpDelay.start();
        }
    }
}
