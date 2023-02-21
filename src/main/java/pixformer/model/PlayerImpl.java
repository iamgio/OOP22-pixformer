package pixformer.model;

import pixformer.model.score.Score;

import java.util.HashSet;
import java.util.Set;

/**
 * The standard implementation of a player.
 */
public class PlayerImpl implements Player {

    private final Set<Runnable> onGoLeft = new HashSet<>();
    private final Set<Runnable> onGoRight = new HashSet<>();
    private final Set<Runnable> onJump = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Score getScore() {
        return null; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        this.onGoLeft.forEach(Runnable::run);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnGoLeft(final Runnable action) {
        this.onGoLeft.add(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        this.onGoRight.forEach(Runnable::run);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnGoRight(final Runnable action) {
        this.onGoRight.add(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
        this.onJump.forEach(Runnable::run);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnJump(final Runnable action) {
        this.onJump.add(action);
    }

    @Override
    public void fire() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fire'");
    }

    @Override
    public void crouch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crouch'");
    }
}
