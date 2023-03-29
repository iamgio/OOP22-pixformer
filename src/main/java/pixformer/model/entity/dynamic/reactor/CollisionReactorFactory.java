package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.collision.CollisionReactor;

import java.util.Collection;

/**
 * Static factory of CollisionReactors.
 */
public final class CollisionReactorFactory {

    private static final CollisionReactor DO_NOTHING = collisions -> {};

    private CollisionReactorFactory() {}

    /**
     * @param a CollisionReactor
     * @param b CollisionReactor
     * @return a CollisionReactor which makes react {@code a} first and then {@code b}.
     */
    public static CollisionReactor compose(final CollisionReactor a, final CollisionReactor b) {
        return collisions -> {
            a.react(collisions);
            b.react(collisions);
        };
    }

    /**
     * An iterative generalization of {@link CollisionReactorFactory#compose(CollisionReactor, CollisionReactor)}
     * @param reactors to be merged
     * @return a CollisionReactor which reacts like the {@code reactors} combined.
     */
    public static CollisionReactor compose(final Collection<CollisionReactor> reactors) {
        return reactors.stream().reduce(doNothing(), CollisionReactorFactory::compose);
    }

    /**
     * @return a CollisionReactor that does nothing.
     */
    public static CollisionReactor doNothing() {
        return DO_NOTHING;
    }
}
