package pixformer.model;

import pixformer.controller.input.ModelInputAdapter;
import pixformer.model.entity.Entity;
import pixformer.model.entity.TestEntity;
import pixformer.model.entity.dynamic.player.Player;
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
     * @param name  level name
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
        return new TestEntity(playerIndex * 5)
        // return new Player(0, 0, 1, 1, playerIndex);
    }
}
