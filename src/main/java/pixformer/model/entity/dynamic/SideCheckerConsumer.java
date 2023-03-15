package pixformer.model.entity.dynamic;

import java.util.function.Consumer;

import pixformer.model.entity.collision.CollisionSide;

/**
 * A Consumer which runs only if the CollisionSide passed to it respect some conditions.
 */
public final class SideCheckerConsumer implements Consumer<CollisionSide> {

    private final CollisionSide checkingSide;
    private final Runnable runnable;

    /**
     * @param checkingSide the only accepted side.
     * @param runnable to be run is the condition is satisfied.
     */
    public SideCheckerConsumer(final CollisionSide checkingSide, final Runnable runnable) {
        this.checkingSide = checkingSide;
        this.runnable = runnable;
    }

    @Override
    public void accept(final CollisionSide arg0) {
        if (arg0 == checkingSide) {
            runnable.run();
        }
    }

}
