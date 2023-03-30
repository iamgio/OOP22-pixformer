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
