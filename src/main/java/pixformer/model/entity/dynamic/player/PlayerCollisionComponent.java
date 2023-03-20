package pixformer.model.entity.dynamic.player;

import java.util.Set;

import pixformer.common.time.ChronometerImpl;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.Enemy;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends CollisionComponent {
    private static final long INVULNERABILITY_TIME = 3000;

    private final Player player;

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
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        for (final var collisor : collisions) {
            
            if (collisor.entity() instanceof Enemy && collisor.side().isVertical()) {
                this.player.onEnemyJump();
            }

            if (collisor.entity() instanceof Enemy && collisor.side().isHorizontal()) {
                if (invulnerabilityChronometer.getTimeElapsed() == 0 || invulnerabilityChronometer.hasElapsed(INVULNERABILITY_TIME)) {

                    this.player.damaged();

                    invulnerabilityChronometer.reset();
                    invulnerabilityChronometer.start();
                }
            }
        }
    }
}
