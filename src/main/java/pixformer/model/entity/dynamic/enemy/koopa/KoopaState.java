package pixformer.model.entity.dynamic.enemy.koopa;

import pixformer.model.entity.MutableEntity;

/**
 * An interface representing all the base classes for koopa and its states.
 */
public interface KoopaState extends MutableEntity {

    /**
     * @return true if the koopa is walking, otherwise false.
     */
    boolean isWalking();

    /**
     * @return true if the koopa is turtle, otherwise false.
     */
    default boolean isTurtle() {
        return !isWalking();
    }
}
