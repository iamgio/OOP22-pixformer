package pixformer.view.mainmenu;

import pixformer.model.Level;

import java.util.function.Consumer;

/**
 * The view responsible for handling the main menu.
 */
public interface MainMenuView {

    /**
     * @return the choosen amount of players
     */
    int getPlayersAmount();

    /**
     * Adds a callback when a level is picked from the menu.
     * @param action action to run
     */
    void addOnLevelSelect(Consumer<Level> action);
}
