package pixformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pixformer.model.World;
import pixformer.model.WorldImpl;
import pixformer.model.WorldOptionsFactory;
import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test the increment of the score.
 */
public final class ScoreTest {

    private static final int DEFAULT_SCORE_INCREMENT = 100;
    private static final int BASE_Y = 10;
    private static final int BASE_X = 10;
    private final World world = new WorldImpl(WorldOptionsFactory.testOptions());
    private Entity a;
    private Entity b;
    private Entity c;
    private int score;

    @BeforeEach
    void setup() {
        a = new Player(BASE_X, BASE_Y, 1, 1, 0);
        b = new Player(this.a.getX() + 1, BASE_Y, 1, 1, 1);
        c = new Player(this.b.getX() + 1, BASE_Y, 1, 1, 2);
        this.world.spawnEntity(a);
        this.world.spawnEntity(b);
        this.world.spawnEntity(c);
        this.score = 0;
    }

    @Test
    void testScore() {
        world.queueEntityKill(this.a, this.c);
        world.update(1);
        this.score += DEFAULT_SCORE_INCREMENT;
        assertEquals(this.score, world.getScoreManager().getScore(this.c).points());
        world.queueEntityKill(this.b, this.c);
        world.update(1);
        this.score += DEFAULT_SCORE_INCREMENT;
        assertEquals(this.score, world.getScoreManager().getScore(this.c).points());
    }
}
