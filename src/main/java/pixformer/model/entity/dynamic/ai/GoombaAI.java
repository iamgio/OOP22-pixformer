package pixformer.model.entity.dynamic.ai;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import pixformer.model.World;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;
import pixformer.model.entity.collision.CollisionSide;

/**
 * A general AI which makes the entity go left until death or it gets into a
 * {@code Block}. If so, it changes its direction.
 */
public class GoombaAI extends AIInputComponent {

    private final HorizontalModelInput joystick;

    /**
     * Create a new GoombaAI.
     * 
     * @param entity which this AI will control.
     */
    public GoombaAI(final AbstractEntity entity, final HorizontalModelInput modelInput) {
        super(entity);
        this.joystick = modelInput;
    }

    @Override
    public final void update(final World world) {
        final EntityCollisionManager collisionManager = world.getCollisionManager();
        final Entity goomba = super.getEntity();
        forCollisions(collisionManager.findCollisionsFor(goomba), Map.of(
            Block.class::isInstance, this::reactOnBlockCollision,
            Player.class::isInstance, (side) -> {/* TODO: this entity dies */ }
        ));
    }       

    private void forCollisions(
        final Set<Collision> collisions, 
        final Map<Predicate<Entity>, Consumer<CollisionSide>> reactions
    ) {
            for (final var reaction : reactions.entrySet()) {
                collisions.stream()
                    .filter(c -> reaction.getKey().test(c.entity()))
                    .map(Collision::side)
                    .forEach(reaction.getValue());
            }
    }

    private void reactOnBlockCollision(final CollisionSide side) {
        switch (side) {
            case LEFT:
                joystick.left();
                break;
            case RIGHT:
                joystick.right();
                break;
            default:
                break;
        }
    }
}
