package pixformer.model.entity.dynamic;

import java.util.Map;
import java.util.Optional;

import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.collision.SimpleCollisionReactor;
import pixformer.model.entity.dynamic.player.Player;

/**
 * The state of the koopa which walks normally and behaves like a goomba.
 */
public final class WalkingKoopa extends Enemy implements KoopaState {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 2;
    private final Runnable changeToTurtle;

    /**
     * Construct a WalkingKoopa.
     * 
     * @param x              its initial x position
     * @param y              its initial x position.
     * @param changeToTurtle a Runnable which makes the koopa becomes a turtle.
     */
    public WalkingKoopa(final double x, final double y, final Runnable changeToTurtle) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
        this.changeToTurtle = changeToTurtle;
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(new ActionOnPressedCollisionComponent(this, e -> changeToTurtle.run()));
    }

    @Override
    public boolean isWalking() {
        return true;
    }

}
