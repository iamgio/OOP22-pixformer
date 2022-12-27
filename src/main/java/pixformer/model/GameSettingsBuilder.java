package pixformer.model;

/**
 * Builder for {@link GameSettings}.
 */
public interface GameSettingsBuilder {

    // Here go withX methods, according to GameSettings values.

    /**
     * @return new {@link GameSettings} specified by this builder
     */
    GameSettings build();
}
