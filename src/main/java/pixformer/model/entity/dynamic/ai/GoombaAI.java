package pixformer.model.entity.dynamic.ai;

import java.util.Optional;

import pixformer.model.World;
import pixformer.model.entity.Entity;
import pixformer.model.entity.TestInputComponent;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

public class GoombaAI extends AIInputComponent {

    private final HorizontalModelInput joystick;

    public GoombaAI(final Entity entity) {
        super(entity);
        joystick = new TestInputComponent(this.getEntity());
    }

    @Override
    public void update(final World world) {
        final EntityCollisionManager collisionManager = world.getCollisionManager();
        Entity goomba = super.getEntity();
        final Optional<?> collidingBlock =
            collisionManager.findCollisionsFor(goomba).stream()
                .filter(Block.class::isInstance)
                .findFirst();
        if (collidingBlock.isPresent()) {
            goomba.setVelocity(goomba.getVelocity().scale(-1));
        }
    }    
}
