package pixformer.controller;

import pixformer.common.file.FileUtils;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.controller.level.LevelManager;
import pixformer.controller.level.LevelManagerImpl;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.model.entity.Entity;
import pixformer.view.View;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The default implementation of a {@link Controller}.
 */
public final class ControllerImpl implements Controller {

    private static final File APP_DIRECTORY = new File(System.getProperty("user.home"), ".pixformer");

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
    public void setup() {
        if (!APP_DIRECTORY.exists()) {
            APP_DIRECTORY.mkdirs();
        }

        this.setupLevelChangeActions();
        this.copyBuiltinLevelFiles();
    }

    private void setupLevelChangeActions() {
        getLevelManager().addOnLevelStart((level, playersAmount) -> {
            level.setup(playersAmount);
            this.getGameLoopManager().start();
        });
        getLevelManager().addOnLevelEnd(level -> this.getGameLoopManager().stop());
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
        return new GameLoopFactory(currentLevel.get(), this, view).defaultLoop();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcEntitiesCommonPointX(final Set<Entity> entities) {
        return entities.stream().mapToDouble(Entity::getX).average().orElse(0);
    }

    /**
     * Copies the level data stored as internal resources to files on the filesystem.
     */
    private void copyBuiltinLevelFiles() {
        if (!FileUtils.copyDirectory("/levels", new File(APP_DIRECTORY, "levels"))) {
            throw new IllegalStateException("Could not copy level files");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<File> getLevelFiles() {
        return null;
    }
}
