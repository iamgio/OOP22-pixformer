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
public class LevelMock implements Level {

    private final Level inner;

    /**
     * Test level.
     */
    public LevelMock() {
        inner = new LevelImpl(new JsonLevelDataDeserializer(new EntityFactoryImpl(new SpritesGraphicsComponentFactory(), getWorld()))
                .deserialize(Level.class.getResourceAsStream("/levels/test2.json")));
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
