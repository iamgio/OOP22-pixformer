package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A Level which use a World given by argument in the constructor.
 */
public final class WorldAcceptingLevel implements Level {

    private final Level inner;

    /**
     * @param deserializer which supply the LevelData
     * @param world which will be populated.
     */
    public WorldAcceptingLevel(final Supplier<LevelData> deserializer, final World world) {
        inner = new LevelImpl(deserializer.get(), world);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData getData() {
        return inner.getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public World getWorld() {
        return inner.getWorld();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer1() {
        return inner.getPlayer1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer2() {
        return inner.getPlayer2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer3() {
        return inner.getPlayer3();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer4() {
        return inner.getPlayer4();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final int playersAmount) {
        inner.init(playersAmount);
    }
}
