package pixformer.model;

import pixformer.controller.input.ModelInputAdapter;
import pixformer.model.entity.TestEntity;
import pixformer.model.modelinput.CompleteModelInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Implementation of a game level.
 */
public class LevelImpl implements Level {

    private final String name;
    private final World world;

    private final List<CompleteModelInput> players;

    /**
     * @param name level name
     * @param world game world of the level
     */
    public LevelImpl(final String name, final World world) {
        this.name = name;
        this.world = world;
        this.players = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public World getWorld() {
        return this.world;
    }

    /**
     * @param index player index (starting from 0)
     * @return the corresponding player if it exists
     */
    private Optional<CompleteModelInput> getPlayer(final int index) {
        return index < this.players.size() ? Optional.of(this.players.get(index)) : Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer1() {
        return this.getPlayer(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CompleteModelInput> getPlayer2() {
        return this.getPlayer(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup(final int playersAmount) {
        IntStream.range(0, playersAmount).forEach(i -> {
            var test = new TestEntity(i * 5); // test
            this.world.spawnEntity(test);

            test.getInputComponent().ifPresent(inputComponent -> {
                this.players.add(ModelInputAdapter.from(inputComponent));
            });
        });
    }
}
