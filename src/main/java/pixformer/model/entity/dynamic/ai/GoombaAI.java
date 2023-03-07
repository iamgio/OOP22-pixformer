package pixformer.model.entity.dynamic.ai;

import java.util.Optional;

import pixformer.model.World;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.EntityCollisionManager;
import pixformer.model.entity.statics.Block;
import pixformer.model.input.AIInputComponent;
import pixformer.model.entity.collision.Collision;

/**
 * A general AI which makes the entity go left until death. 
 */
public class GoombaAI extends AIInputComponent {

    /**
     * Create a new GoombaAI.
     * @param entity which this AI will control.
     */
    public GoombaAI(final Entity entity) {
        super(entity);
    }

    @Override
    public final void update(final World world) {
        final EntityCollisionManager collisionManager = world.getCollisionManager();
        Entity goomba = super.getEntity();
        final Optional<?> collidingBlock =
            collisionManager.findCollisionsFor(goomba).stream()
                .map(Collision::entity)
                .filter(Block.class::isInstance)
                .findFirst();
        if (collidingBlock.isPresent()) {
            goomba.setVelocity(goomba.getVelocity().scale(-1));
        }
    }    
}
