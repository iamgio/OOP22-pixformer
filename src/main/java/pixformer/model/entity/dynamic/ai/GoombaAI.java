package pixformer.model.entity.dynamic.ai;

import java.util.Map;
import java.util.function.Consumer;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.collision.SimpleCollisionReactor;
import pixformer.model.entity.dynamic.HorizontalModelInputImpl;
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
    private final CollisionReactor reactor;

    /**
     * Create a new GoombaAI.
     * 
     * @param entity which this AI will control.
     * @param velocitySetter the entity setter for its velocity.
     * @param velocity the module of the velocity of the controlled entity.
     */
    public GoombaAI(final AbstractEntity entity, final Consumer<Vector2D> velocitySetter, final double velocity) {
        super(entity);
        this.joystick = new HorizontalModelInputImpl(velocitySetter, velocity);
        reactor = new SimpleCollisionReactor(Map.of(
            Entity::isSolid, this::reactOnBlockCollision
        ));
        initialBehaviour();
    }

    private void initialBehaviour() {
        joystick.left();
    }

    @Override
    public final void update(final World world) {
        final EntityCollisionManager collisionManager = world.getCollisionManager();
        final Entity goomba = super.getEntity();
        reactor.react(collisionManager.findCollisionsFor(goomba));
    }       

    private void reactOnBlockCollision(final CollisionSide side) {
        switch (side) {
            case LEFT:
                initialBehaviour();
                break;
            case RIGHT:
                joystick.right();
                break;
            default:
                break;
        }
    }
}
