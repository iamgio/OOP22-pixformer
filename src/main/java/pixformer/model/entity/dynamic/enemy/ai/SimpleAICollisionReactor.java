package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A collision reactor which moves the entity right when finding a solid entity at its left
 * and moves left when finding a solid entity at its right.
 */
public final class SimpleAICollisionReactor extends GeneralAICollisionReactor {

    /**
     * @param joystick        to control the entity's movements.
     * @param initialBehavior the behaviour which the entity will have when spawned.
     */
    public SimpleAICollisionReactor(final HorizontalModelInput joystick,
                                    final Consumer<HorizontalModelInput> initialBehavior) {
        super(joystick, initialBehavior, collision -> collision.entity().isSolid());
    }
}
