package pixformer.model.entity.powerups.other.fireball;

import java.util.Set;

import pixformer.model.World;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.player.Player;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class FireballCollisionComponent extends CollisionComponent {
    private final Fireball fireball;
    private final World world;

    /**
     * 
     * @param fireball Fireball Entity linked with current component.
     * @param world Instance of current world spawn.
     */
    protected FireballCollisionComponent(final Fireball fireball, final World world) {
        super(fireball);
        this.fireball = fireball;
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        for (final var collisor : collisions) {
            if (collisor.side().isHorizontal() && !(collisor.entity() instanceof Player)) {
                world.dropEntity(fireball);
            }
        }

    }

}
