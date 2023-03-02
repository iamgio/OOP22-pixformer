package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;

/**
 * The default implementation of a {@link Controller}.
 */
public class ControllerImpl implements Controller {

    private final GameSettings settings;
    private final LevelManager levelManager;

    private GameLoop gameLoop;

    /**
     * @param settings game settings
     * @param levelManager handler of playable levels
     */
    public ControllerImpl(final GameSettings settings, final LevelManager levelManager) {
        this.settings = settings;
        this.levelManager = levelManager;
    }

    /**
     * Instantiates a new implementation with default values.
     */
    public ControllerImpl() {
        // TODO implement GameSettings
        this(null, new LevelManagerImpl());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameSettings getSettings() {
        return this.settings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LevelManager getLevelManager() {
        return this.levelManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGameLoop(final GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }
}
