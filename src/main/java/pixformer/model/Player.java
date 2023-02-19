package pixformer.model;

import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.score.Score;

/**
 * Abstraction of a user playing the game.
 */
public interface Player extends CompleteModelInput {

    /**
     * @return the player's score
     */
    Score getScore();

    /**
     * The player moves left.
     */
    @Override
    void left();

    /**
     * Adds an action to be executed when the player goes left.
     * @param action action to execute
     */
    void addOnGoLeft(Runnable action);

    /**
     * The player moves right.
     */
    @Override
    void right();

    /**
     * Adds an action to be executed when the player goes right.
     * @param action action to execute
     */
    void addOnGoRight(Runnable action);

    /**
     * The player jumps.
     */
    @Override
    void jump();

    /**
     * Adds an action to be executed when the player jumps.
     * @param action action to execute
     */
    void addOnJump(Runnable action);

    // run, fire, ... added thanks to CompleteModelInput
}
