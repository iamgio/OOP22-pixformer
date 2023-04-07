package pixformer.model;

import java.util.function.Supplier;

/**
 * A Level which use a World given by argument in the constructor.
 */
public final class WorldAcceptingLevel extends LevelImpl {

    /**
     * @param deserializer which supply the LevelData
     * @param world which will be populated.
     */
    public WorldAcceptingLevel(final Supplier<LevelData> deserializer, final World world) {
        super(deserializer.get(), world);
    }
}
