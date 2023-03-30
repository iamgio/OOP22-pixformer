package pixformer.model.entity.dynamic.enemy.koopa.turtle;

import pixformer.model.World;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.reactor.SingleCollisionReactor;
import pixformer.model.input.InputComponent;
import pixformer.model.entity.dynamic.player.Player;

public class MoveWhenPressedInputComponent extends InputComponent {

    private final CollisionReactor collisionReactor;

    /**
     * Instantiates an input component.
     *
     * @param entity target entity
     */
    public MoveWhenPressedInputComponent(final MutableEntity entity, final double velocity) {
        super(entity);
        collisionReactor = new SingleCollisionReactor(
                collision -> collision.side() == CollisionSide.TOP &&
                        collision.entity() instanceof Player
                        && entity.getVelocity().x() == 0,
                e -> getEntity().setVelocity(getEntity().getVelocity().copyWithX(velocity))
        );
    }

    @Override
    public void update(final World world) {
        final var collisions = world.getCollisionManager().findCollisionsFor(getEntity());
        collisionReactor.react(collisions);
    }
}
