package pixformer.model.entity.dynamic.enemy.ai;

import pixformer.model.modelinput.HorizontalModelInput;

import java.util.function.Consumer;

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
