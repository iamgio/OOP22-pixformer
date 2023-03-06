package pixformer.model.entity.collision;

import pixformer.model.entity.Entity;

import java.util.Set;

/**
 * A component that can repeatedly access collisions happening within the game world
 * as long as the target entity is involved in them.
 * A common use case would be "the player jumps on top of a monster":
 * The player's collision component would let the player perform a small jump,
 * while the monster's one would let the monster die.
 */
public abstract class CollisionComponent {

    private final Entity entity;

    protected CollisionComponent(final Entity entity) {
        this.entity = entity;
    }

    /**
     * @return the target entity
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Updates collision handling.
     * @param dt delta time
     * @param collisions collision this component's entity is involved in
     */
    public abstract void update(double dt, Set<Collision> collisions);
}
