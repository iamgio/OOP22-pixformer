package pixformer.model.entity.dynamic.player;

import java.util.Set;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.player.PlayerInputComponent;
import pixformer.model.entity.dynamic.Goomba;
import pixformer.model.entity.dynamic.Koopa;
import pixformer.model.input.InputComponent;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends CollisionComponent {
    private Player player;

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

        if (player.isOnGround()) {
            this.player.resetJumping();
        }

        for (var x : collisions) {
            if (x.entity() instanceof Goomba || x.entity() instanceof Koopa) {
                if (x.side().isHorizontal()) {
                    this.player.getDamage();
                }
            }
        }

    }

}
