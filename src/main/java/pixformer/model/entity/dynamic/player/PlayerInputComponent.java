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

    // Speedup factor while sprinting
    private static final float BASE_SPEED_LIMIT = 0.01f;
    private static final float SPRINT_SPEED_LIMIT = 0.02f;

    // Ability cooldown in milliseconds
    private static final int ABILITY_COOLDOWN = 500;

    // On enemy jump cooldown in milliseconds
    private static final int ON_ENEMY_JUMP_COOLDOWN = 500;

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

        // Player speed limit management
        final int direction = player.getVelocity().x() >= 0 ? 1 : -1;

        if (!sprintKey && Math.abs(player.getVelocity().x()) > BASE_SPEED_LIMIT) {
            player.setVelocity(new Vector2D(BASE_SPEED_LIMIT * direction, player.getVelocity().y()));
        } else if (sprintKey && Math.abs(player.getVelocity().x()) > SPRINT_SPEED_LIMIT) {
            player.setVelocity(new Vector2D(SPRINT_SPEED_LIMIT * direction, player.getVelocity().y()));
        }

        sprintKey = false;
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

    /**
     * Force a jump on player
     */
    public void onEnemyJump() {

        if (onEnemyJumpDelay.hasElapsed(ABILITY_COOLDOWN)) {
            resetJumping();
            player.setVelocity(player.getVelocity().sum(new Vector2D(0, -PlayerPhysicsComponent.JUMP_FORCE)));
            onEnemyJumpDelay.reset();
            onEnemyJumpDelay.start();
        }
    }
}
