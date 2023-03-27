package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;

import java.util.Optional;
import java.util.function.Function;

public class SpawnDespawnLevel implements Level {

    private final Level inner;

    public SpawnDespawnLevel(final Function<World, LevelData> levelDataCreator) {
        inner = new LevelImpl(levelDataCreator.apply(getWorld()));
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
