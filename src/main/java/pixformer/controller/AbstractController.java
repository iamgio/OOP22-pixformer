package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.view.ViewImpl;

import java.util.Optional;

/**
 * The default implementation of a {@link Controller},
 * with room for view-specific features (e.g. {@link Controller#startGameLoop()}).
 */
public abstract class AbstractController implements Controller {

    private final GameSettings settings;
    private final LevelManager levelManager;

    /**
     * @param settings game settings
     * @param levelManager handler of playable levels
     */
    public AbstractController(final GameSettings settings, final LevelManager levelManager) {
        this.settings = settings;
        this.levelManager = levelManager;
    }

    /**
     * Instantiates a new implementation with default values.
     */
    public AbstractController() {
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
    public GameLoop createGameLoop(final ViewImpl view) {
        Optional<Level> currentLevel = this.levelManager.getCurrentLevel();
        if (currentLevel.isEmpty()) {
            throw new IllegalStateException("Current level is not set.");
        }
        return new GameLoopFactory(currentLevel.get().getWorld(), view).defaultLoop();
    }
}
