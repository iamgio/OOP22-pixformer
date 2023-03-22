package pixformer.model.entity.powerup.other.fireball;

import java.util.Set;

import pixformer.common.time.ChronometerImpl;
import pixformer.model.World;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.player.Player;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class FireballCollisionComponent extends CollisionComponent {
    static final long ALIVE_TIME = 3000;

    private final Fireball fireball;
    private final World world;

    private final ChronometerImpl despawnCronometer = new ChronometerImpl();

    /**
     * 
     * @param fireball Fireball Entity linked with current component.
     * @param world Instance of current world spawn.
     */
    protected FireballCollisionComponent(final Fireball fireball, final World world) {
        super(fireball);
        this.fireball = fireball;
        this.world = world;

        despawnCronometer.reset();
        despawnCronometer.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        if (despawnCronometer.hasElapsed(ALIVE_TIME)) {
            world.dropEntity(fireball);
        }

        for (final var collisor : collisions) {
            if (collisor.side().isHorizontal() && !(collisor.entity() instanceof Player)) {
                world.dropEntity(fireball);
            }
        }

    }

}
