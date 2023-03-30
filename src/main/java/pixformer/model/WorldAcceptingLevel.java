package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

import java.util.Optional;
import java.util.function.Supplier;

public final class WorldAcceptingLevel implements Level {

    private final Level inner;

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
    public void setup(final int playersAmount) {
        inner.setup(playersAmount);
    }
}
