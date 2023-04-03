package pixformer.model.entity.dynamic.player;

import pixformer.common.time.Timer;
import pixformer.common.time.TimerImpl;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.enemy.Enemy;
import pixformer.model.entity.powerup.PhysicalPowerup;

import java.util.Set;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends SolidCollisionComponent {
    private static final long INVULNERABILITY_TIME = 3000;
    private static final float BIG_PLAYER_SIZE_MULTIPLIER = 2;
    private static final double PLAYER_FRICTION = 0.96;

    private final PlayerImpl player;
    private final double baseHeight;

    private boolean isOnGround;
    private boolean isTouchingAbove;

    private final Timer invulnerabilityTimer = new TimerImpl();

    /**
     * 
     * @param player Player entity whose collisions will be managed.
     */
    protected PlayerCollisionComponent(final PlayerImpl player) {
        super(player, PLAYER_FRICTION);
        this.player = player;
        this.baseHeight = player.getHeight();
    }

    /**
     * @return true if player is touching ground, other false.
     */
    public boolean isOnGround() {
        return isOnGround;
    }

    /**
     * @return true if player is touching ground, other false.
     */
    public boolean isTouchingAbove() {
        return isTouchingAbove;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);

        isTouchingAbove = isCollidingCeiling(collisions);
        isOnGround = isCollidingGround(collisions);

        for (final var collisor : collisions) {
            if (collisor.entity() instanceof Enemy 
                && (collisor.side().isHorizontal() || collisor.side() == CollisionSide.TOP)
                && invulnerabilityTimer.hasTimeLeft()) {
                    player.damaged();
                    invincibility(INVULNERABILITY_TIME);
            }

            if (collisor.entity() instanceof PhysicalPowerup powerup) {
                player.setPowerup(powerup.getPowerupBehaviour());
            }
        }

        checkPlayerSize();
    }

    private void checkPlayerSize() {
        final double previousHeight = player.getHeight();

        player.setHeight(player.getPowerupBehaviour().isEmpty() ? baseHeight : baseHeight * BIG_PLAYER_SIZE_MULTIPLIER);

        if (previousHeight != player.getHeight()) {
            player.setY(player.getY() + previousHeight - player.getHeight());
        }
    }

    /**
     * Set a time during while the player is invincible.
     * @param time how long the player is invincible.
     */
    public void invincibility(final long time) {
        invulnerabilityTimer.start(time);
    }
}
