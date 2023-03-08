package pixformer.controller;

import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.view.ViewImpl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The default implementation of a {@link Controller}.
 */
public class ControllerImpl implements Controller {

    private static final int DEFAULT_PLAYERS_AMOUNT = 1;
    private static final int MIN_PLAYERS_AMOUNT = 1;
    private static final int MAX_PLAYERS_AMOUNT = 8;

    private final GameSettings settings;
    private final Wrapper<LevelManager> levelManager;
    private final Wrapper<GameLoopManager> gameLoopManager;

    private final AtomicInteger playersAmountCounter = new AtomicInteger(DEFAULT_PLAYERS_AMOUNT);

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
    public GameLoop createGameLoop(final ViewImpl view) {
        Optional<Level> currentLevel = this.levelManager.get().getCurrentLevel();
        if (currentLevel.isEmpty()) {
            throw new IllegalStateException("Current level is not set.");
        }
        return new GameLoopFactory(currentLevel.get(), view, this.playersAmountCounter.get()).defaultLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPlayersAmount() {
        return this.playersAmountCounter.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlayersAmount(final int playersAmount) {
        if (playersAmount < MIN_PLAYERS_AMOUNT) {
            this.playersAmountCounter.set(MIN_PLAYERS_AMOUNT);
        } else {
            this.playersAmountCounter.set(Math.min(playersAmount, MAX_PLAYERS_AMOUNT));
        }
    }
}
