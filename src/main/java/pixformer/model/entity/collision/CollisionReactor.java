package pixformer.model.entity.collision;

import java.util.Collection;

/**
 * It react to the collisions given executing some operation in response.
 */
public interface CollisionReactor {

    /**
     * React to the {@code collisions} passed.
     * 
     * @param collisions to which it reacts.
     */
    void react(Collection<Collision> collisions);
}
