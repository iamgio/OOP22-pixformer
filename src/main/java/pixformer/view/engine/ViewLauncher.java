package pixformer.view.engine;

import pixformer.controller.Controller;
import pixformer.controller.level.LevelManager;

/**
 * Responsible for launching a kind of view.
 */
public interface ViewLauncher {

    /**
     * Launches the view.
     */
    void launch();

    /**
     * @return the controller for model interactions
     */
    Controller getController();

    /**
     * @return the active game scene
     */
    GameScene getScene();

    /**
     * Sets a new game scene as the active one.
     * @param scene new game scene
     */
    void setScene(GameScene scene);

    /**
     * @return a new game scene instance
     */
    GameScene createGameScene();

    /**
     * @return a new main menu scene instance
     */
    GameScene createMenuScene();

    /**
     * Set-ups the scene switch when a level starts or ends.
     */
    default void setupLevelScenesRoutine() {
        final LevelManager levelManager = this.getController().getLevelManager();
        levelManager.addOnLevelStart((level, playersAmount) -> this.setScene(this.createGameScene()));
        levelManager.addOnLevelEnd((level, leaderboard) -> this.setScene(this.createMenuScene()));
    }
}
