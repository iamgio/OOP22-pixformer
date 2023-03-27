package pixformer.controller;

import pixformer.common.file.FileUtils;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.controller.deserialization.level.JsonLevelDataDeserializer;
import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.gameloop.GameLoopFactory;
import pixformer.controller.level.LevelManager;
import pixformer.controller.level.LevelManagerImpl;
import pixformer.model.*;
import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.EntityFactoryImpl;
import pixformer.view.View;
import pixformer.view.entity.SpritesGraphicsComponentFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The default implementation of a {@link Controller}.
 */
public final class ControllerImpl implements Controller {

    private static final File APP_DIRECTORY = new File(System.getProperty("user.home"), ".pixformer");
    private static final String LEVELS_SUBFOLDER_NAME = "levels";

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
    public void init() {
        if (!APP_DIRECTORY.exists() && !APP_DIRECTORY.mkdirs()) {
            throw new IllegalStateException("Cannot create application directory at " + APP_DIRECTORY);
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
    public List<Integer> getScore() {
        final Level level = this.levelManager.get().getCurrentLevel().orElse(null);
        if (level != null) {
            return level.getWorld().getScoreManager().getAllScores();
        }
        return new ArrayList<>();
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
        if (!FileUtils.copyDirectory("/levels", new File(APP_DIRECTORY, LEVELS_SUBFOLDER_NAME))) {
            throw new IllegalStateException("Could not copy level files");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<File> getLevelFiles() {
        final File[] files = new File(APP_DIRECTORY, LEVELS_SUBFOLDER_NAME).listFiles();
        return files != null ? Arrays.asList(files) : List.of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevelFromFile(final File levelFile) {
        try (FileInputStream inputStream = new FileInputStream(levelFile)) {
//            final EntityFactory entityFactory = new EntityFactoryImpl(new SpritesGraphicsComponentFactory());
//            final LevelData data = new JsonLevelDataDeserializer(entityFactory).deserialize(inputStream);
//            return new LevelImpl(data);
            return new SpawnDespawnLevel(world -> new JsonLevelDataDeserializer(new EntityFactoryImpl(new SpritesGraphicsComponentFactory(), world))
                    .deserialize(inputStream));
        } catch (IOException e) {
            throw new IllegalStateException("Could not get level data from file");
        }
    }
}
