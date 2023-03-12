package pixformer.model;

import pixformer.controller.input.ModelInputAdapter;
import pixformer.model.entity.Entity;
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

    private final LevelData data;
    private final World world;

    private final List<CompleteModelInput> players;

    /**
     * @param data level data
     */
    public LevelImpl(final LevelData data) {
        this.data = data;
        this.world = new WorldImpl();
        this.players = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelData getData() {
        return this.data;
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
        this.data.entities().forEach(this.world::spawnEntity);
        // TODO put player at spawn point from level data
        IntStream.range(0, playersAmount).forEach(i -> {
            Entity player = this.createPlayer(i);
            this.world.spawnEntity(player);

            player.getInputComponent().ifPresent(inputComponent -> {
                this.players.add(ModelInputAdapter.from(inputComponent));
            });
        });
    }

    /**
     * @param playerIndex index of the player, starting from 0
     * @return a new player entity
     */
    private Entity createPlayer(final int playerIndex) {
        return new TestEntity(playerIndex * 5);
        // return new Player(0, 0, 1, 1, playerIndex);
    }
}
