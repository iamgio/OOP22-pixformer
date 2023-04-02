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
 * A collision reactor which moves the entity right when finding an obstacle at its left
 * and moves left when finding an obstacle at its right.
 */
public class GeneralAICollisionReactor implements CollisionReactor {

    private Consumer<HorizontalModelInput> currentBehaviour;
    private final Consumer<HorizontalModelInput> initialBehavior;
    private final HorizontalModelInput joystick;
    private final Predicate<Collision> whichCollisions;

    /**
     * @param joystick to control the entity's movements.
     * @param initialBehavior the behaviour which the entity will have when spawned.
     * @param whichCollisions this reactor should react.
     */
    public GeneralAICollisionReactor(final HorizontalModelInput joystick,
                                    final Consumer<HorizontalModelInput> initialBehavior,
                                    final Predicate<Collision> whichCollisions
    ) {
        this.joystick = joystick;
        this.initialBehavior = initialBehavior;
        this.whichCollisions = whichCollisions;
    }

    @Override
    public final void react(final Collection<Collision> collisions) {
        final var horizontals = collisions.stream()
                .filter(whichCollisions)
                .map(Collision::side)
                .filter(CollisionSide::isHorizontal)
                .collect(Collectors.toSet());
        if (horizontals.isEmpty() && currentBehaviour == null) {
            currentBehaviour = initialBehavior;
        }
        if (horizontals.contains(CollisionSide.LEFT) && !horizontals.contains(CollisionSide.RIGHT)) {
            currentBehaviour = HorizontalModelInput::left;
        }
        if (horizontals.contains(CollisionSide.RIGHT) && !horizontals.contains(CollisionSide.LEFT)) {
            currentBehaviour = HorizontalModelInput::right;
        }
        if (horizontals.contains(CollisionSide.RIGHT) && horizontals.contains(CollisionSide.LEFT)) {
            currentBehaviour = null;
        }
        Optional.ofNullable(currentBehaviour).ifPresent(b -> b.accept(joystick));
    }
}
