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

    @Override
    public LevelData getData() {
        return inner.getData();
    }

    @Override
    public World getWorld() {
        return inner.getWorld();
    }

    @Override
    public Optional<CompleteModelInput> getPlayer1() {
        return inner.getPlayer1();
    }

    @Override
    public Optional<CompleteModelInput> getPlayer2() {
        return inner.getPlayer2();
    }

    @Override
    public Optional<CompleteModelInput> getPlayer3() {
        return inner.getPlayer3();
    }

    @Override
    public Optional<CompleteModelInput> getPlayer4() {
        return inner.getPlayer4();
    }

    @Override
    public void init(final int playersAmount) {
        inner.init(playersAmount);
    }
}
