package pixformer.model;

import pixformer.model.score.Score;

/**
 * Abstraction of a user playing the game.
 */
public interface Player {

    /**
     * @return the player's score
     */
    Score getScore();

    /**
     * The player moves left.
     */
    void goLeft();

    /**
     * Adds an action to be executed when the player goes left.
     * @param action action to execute
     */
    void addOnGoLeft(Runnable action);

    /**
     * The player moves right.
     */
    void goRight();

    /**
     * Adds an action to be executed when the player goes right.
     * @param action action to execute
     */
    void addOnGoRight(Runnable action);

    /**
     * The player jumps.
     */
    void jump();

    /**
     * Adds an action to be executed when the player jumps.
     * @param action action to execute
     */
    void addOnJump(Runnable action);

    // run, fire, ...
}
