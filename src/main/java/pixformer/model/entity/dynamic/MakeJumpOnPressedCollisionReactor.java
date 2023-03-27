package pixformer.model.entity.dynamic;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Collection;

/**
 * A collision reactor which makes the entity which press on the controlled entity jump.
 */
public class MakeJumpOnPressedCollisionReactor implements CollisionReactor {

    private static final double JUMP_FORCE = 0.000_8 * 7;
    private final CollisionReactor inner = new ActionOnPressedCollisionReactor(
            e -> {
                if (e instanceof Player player) {
                    player.setVelocity(player.getVelocity().copyWithY(-JUMP_FORCE));
                }
            }
    );

    @Override
    public void react(final Collection<Collision> collisions) {
        inner.react(collisions);
    }
}
