package pixformer.model.entity.powerup.other.fireball;

import pixformer.common.time.ChronometerImpl;
import pixformer.model.World;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.coin.Coin;

import java.util.Set;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class FireballCollisionComponent extends SolidCollisionComponent {

    static final long ALIVE_TIME = 3000;
    private static final int FIREBALL_FRICTION = 1;

    private final Fireball fireball;
    private final World world;

    private final ChronometerImpl despawnCronometer = new ChronometerImpl();

    private final Set<Class<?>> collisionIgnoreEntities = Set.of(Player.class, Coin.class);

    /**
     * 
     * @param fireball Fireball Entity linked with current component.
     * @param world Instance of current world spawn.
     */
    protected FireballCollisionComponent(final Fireball fireball, final World world) {
        super(fireball, FIREBALL_FRICTION);
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
        super.update(dt, collisions);

        if (despawnCronometer.hasElapsed(ALIVE_TIME)) {
            world.queueEntityDrop(fireball);
        }

        for (final var collisor : collisions) {
            if (collisor.side().isHorizontal()
                    && collisionIgnoreEntities.stream().noneMatch(c -> c.isInstance(collisor.entity()))) {
                world.queueEntityDrop(fireball);
            }

            System.out.println(collisor.entity().getClass());
        }

    }

}
