package pixformer.model;

import pixformer.controller.input.ModelInputAdapter;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.modelinput.CompleteModelInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Implementation of a game {@link Level}.
 */
public class LevelImpl implements Level {

    private final LevelData data;
    private final World world;

    private final List<CompleteModelInput> players;

    /**
     * Constructor for the level.
     *
     * @param data level data
     * @param world world
     */
    public LevelImpl(final LevelData data, final World world) {
        this.data = data;
        this.world = world;
        this.players = new ArrayList<>();
    }

    /**
     * Constructor for the level.
     *
     * @param data level data
     */
    public LevelImpl(final LevelData data) {
        this(data, new WorldImpl(WorldOptionsFactory.defaultOptions()));
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
    public void init(final int playersAmount) {
        this.data.entities().forEach(this.world::spawnEntity);

        IntStream.range(0, playersAmount).forEach(i -> {
            final Entity player = this.createPlayer(i, data.spawnPointX(), data.spawnPointY());
            this.world.spawnEntity(player);

            player.getInputComponent().ifPresent(inputComponent -> {
                this.players.add(ModelInputAdapter.from(inputComponent));
            });
        });
    }

    /**
     * @param playerIndex index of the player, starting from 0
     * @param startX x coordinate start position
     * @param startY y coordinate start position
     * @return a new player entity
     */
    private Entity createPlayer(final int playerIndex, final double startX, final double startY) {
         return new Player(startX, startY, 1, 1, playerIndex);
    }
}
