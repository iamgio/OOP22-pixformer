package pixformer.controller;

import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.view.View;

import java.util.Optional;

/**
 * The default implementation of a {@link Controller}.
 */
public class ControllerImpl implements Controller {

    private static final int MIN_PLAYERS_AMOUNT = 1;
    private static final int MAX_PLAYERS_AMOUNT = 8;

    private final GameSettings settings;
    private final Wrapper<LevelManager> levelManager;
    private final Wrapper<GameLoopManager> gameLoopManager;

    /**
     * @param settings game settings
     * @param levelManager handler of playable levels
     * @param gameLoopManager game loop handler
     */
    public ControllerImpl(final GameSettings settings, final LevelManager levelManager, final GameLoopManager gameLoopManager) {
        this.settings = settings;
        this.levelManager = new SimpleWrapper<>(levelManager);
        this.gameLoopManager = new SimpleWrapper<>(gameLoopManager);
    }

    /**
     * Instantiates a new implementation with default values.
     * @param gameLoopManager game loop handler
     */
    public ControllerImpl(final GameLoopManager gameLoopManager) {
        // TODO implement GameSettings
        this(null, new LevelManagerImpl(), gameLoopManager);
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
        return this.levelManager.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoopManager getGameLoopManager() {
        return this.gameLoopManager.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameLoop createGameLoop(final View view) {
        Optional<Level> currentLevel = this.levelManager.get().getCurrentLevel();
        if (currentLevel.isEmpty()) {
            throw new IllegalStateException("Current level is not set.");
        }
        return new GameLoopFactory(currentLevel.get(), view, this.gameLoopManager.get()).defaultLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initLevel(final Level level, final int playersAmount) {
        level.setup(playersAmount);
        this.getGameLoopManager().start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopLevel(final Level level) {
        this.getGameLoopManager().stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int correctSupportedPlayersAmount(final int playersAmount) {
        if (playersAmount < MIN_PLAYERS_AMOUNT) {
            return MIN_PLAYERS_AMOUNT;
        } else {
            return Math.min(playersAmount, MAX_PLAYERS_AMOUNT);
        }
    }
}
