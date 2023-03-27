package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.components.Component;

import java.util.Set;

/**
 * A component that can repeatedly access collisions happening within the game world
 * as long as the target entity is involved in them.
 * A common use case would be "the player jumps on top of a monster":
 * The player's collision component would let the player perform a small jump,
 * while the monster's one would let the monster die.
 */
public abstract class CollisionComponent extends Component<MutableEntity> {

    /**
     * Simple constructor for sub-classes.
     *
     * @param entity target of the collision component
     */
    protected CollisionComponent(final MutableEntity entity) {
        super(entity);
    }

    /**
     * Updates collision handling.
     * @param dt delta time
     * @param collisions collision this component's entity is involved in
     */
    public abstract void update(double dt, Set<Collision> collisions);
}
