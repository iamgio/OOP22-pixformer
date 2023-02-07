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
    void left();

    /**
     * The player moves right.
     */
    void right();

    /**
     * The player jumps.
     */
    void jump();

    // run, fire, ...
}
