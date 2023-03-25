package pixformer.model.entity.dynamic.player;

import pixformer.common.time.ChronometerImpl;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.Enemy;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.statics.Block;
import pixformer.model.entity.statics.Brick;
import pixformer.model.entity.statics.Surprise;

import java.util.Set;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends SolidCollisionComponent {
    private static final long INVULNERABILITY_TIME = 3000;

    private final Player player;

    private boolean isOnGround = false;

    private final ChronometerImpl invulnerabilityChronometer = new ChronometerImpl();

    /**
     * 
     * @param player Player entity whose collisions will be managed.
     */
    protected PlayerCollisionComponent(final Player player) {
        super(player);
        this.player = player;
    }

    /**
     * @return true if player is touching ground, other false.
     */
    public boolean getIsOnGround() {
        return isOnGround;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        super.update(dt, collisions);

        isOnGround = false;

        for (final var collisor : collisions) {

            if (collisor.entity() instanceof Enemy && collisor.side() == CollisionSide.BOTTOM) {
                this.player.onEnemyJump();
            } else if (isCollidingGround(collisions)) {
                isOnGround = true;
            }

            if (collisor.entity() instanceof Enemy && collisor.side().isHorizontal()) {
                if (invulnerabilityChronometer.getTimeElapsed() == 0 || invulnerabilityChronometer.hasElapsed(INVULNERABILITY_TIME)) {

                    this.player.damaged();

                    invulnerabilityChronometer.reset();
                    invulnerabilityChronometer.start();
                }
            }

            if (collisor.entity() instanceof PhysicalPowerup powerup) {
                player.setPowerup(powerup.getPowerupBehaviour());
            }
        }
    }
}
