package pixformer.model.entity.dynamic.ai;

import pixformer.model.World;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;
import pixformer.model.entity.collision.Collision;

/**
 * A general AI which makes the entity go left until death.
 */
public class GoombaAI extends AIInputComponent {

    private final HorizontalModelInput joystick;

    /**
     * Create a new GoombaAI.
     * 
     * @param entity which this AI will control.
     */
    public GoombaAI(final Entity entity, final HorizontalModelInput modelInput) {
        super(entity);
        this.joystick = modelInput;
    }

    @Override
    public final void update(final World world) {
        System.out.println(world.getEntities());
        final EntityCollisionManager collisionManager = world.getCollisionManager();
        final Entity goomba = super.getEntity();
        collisionManager.findCollisionsFor(goomba).stream()
                .peek(System.out::println)
                .filter(c -> c.entity() instanceof Block)
                .findFirst()
                .map(Collision::side)
                .ifPresent(c -> {
                    switch (c) {
                        case LEFT:
                            joystick.right(); break;
                        case RIGHT:
                            joystick.left(); break;
                        default: break;
                    }
                });
    }
}
