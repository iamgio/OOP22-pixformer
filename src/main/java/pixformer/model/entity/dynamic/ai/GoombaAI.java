package pixformer.model.entity.dynamic.ai;

import pixformer.model.World;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

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
        collisionManager.findCollisionsFor(goomba).stream()
                .filter(c -> c.entity() instanceof Block)
                .findFirst()
                .map(Collision::side)
                .ifPresent(c -> {
                    switch (c) {
                        case LEFT:
                            joystick.left();
                            break;
                        case RIGHT:
                            joystick.right();
                            break;
                        default:
                            break;
                    }
                });
    }
}
