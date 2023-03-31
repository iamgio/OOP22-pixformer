package pixformer.model;

import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

import java.util.Optional;

/**
 * @deprecated test
 */
@Deprecated
public final class LevelMock implements Level {

    private final Level inner;

    /**
     * Test level.
     */
    public LevelMock() {
        final World world = new WorldImpl(WorldOptionsFactory.defaultOptions());
        inner = new WorldAcceptingLevel(() -> new JsonLevelDataDeserializer(
                new EntityFactoryImpl(new SpritesGraphicsComponentFactory(), world))
                .deserialize(Level.class.getResourceAsStream("/levels/test2.json")), world);
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
